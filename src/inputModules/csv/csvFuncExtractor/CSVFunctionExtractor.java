package inputModules.csv.csvFuncExtractor;

import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import ast.functionDef.FunctionDef;
import inputModules.csv.KeyedCSV.KeyedCSVReader;
import inputModules.csv.KeyedCSV.KeyedCSVRow;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import inputModules.csv.csv2ast.CSV2AST;
import tools.phpast2cfg.PHPCSVNodeTypes;

public class CSVFunctionExtractor
{

	KeyedCSVReader nodeReader;
	KeyedCSVReader edgeReader;
	Stack<CSVAST> csvStack = new Stack<CSVAST>();
	Stack<String> funcIdStack = new Stack<String>();
	Queue<CSVAST> csvFifoQueue = new LinkedList<CSVAST>();
	CSV2AST csv2ast = new CSV2AST();

	public void setLanguage(String language)
	{
		csv2ast.setLanguage(language);
	}

	public void initialize(Reader nodeStrReader, Reader edgeStrReader)
			throws IOException
	{
		nodeReader = new KeyedCSVReader();
		edgeReader = new KeyedCSVReader();
		nodeReader.init(nodeStrReader);
		edgeReader.init(edgeStrReader);
	}
	
	public FunctionDef getNextFunction()
			throws IOException, InvalidCSVFile
	{	
		if( csvFifoQueue.isEmpty()) {

			// there are no functions in the queue, let's get some
			assert csvStack.empty() : "There are unfinished CSVASTs on the stack and they are not going to be converted.";
			addNodeRowsUntilNextFile();
			// addEdgeRowsUntilNextFile();
		}
		
		FunctionDef function = null;
		
		if( !csvFifoQueue.isEmpty()) {

			CSVAST csvAST = csvFifoQueue.remove();
			System.out.println("Converting " + csvAST);
			function = csv2ast.convert(csvAST);
		}

		return function;
	}

	/**
	 * This function reads lines from the nodeReader, file by file.
	 * 
	 * 1. It first continuously adds lines that have the same funcid as the
	 *    funcid currently on top of the funcIdStack to the CSVAST on top of
	 *    the csvStack.
	 * 2. Upon finding a function declaration:
	 *    a) It adds the line to the CSVAST on top of the csvStack, since the
	 *       declaration as such is indeed part of the outer scope and belongs there.
	 *    b) It pushes a new CSVAST on top of  the csvStack and that function's id
	 *       on top of the funcIdStack. The line is also added to this new CSVAST.
	 *       Do note that this means that we intentionally duplicate a line by adding it
	 *       to two separate CSVAST instances. This second addition is needed for
	 *       technical reasons, because the line contains meta-information about the
	 *       function (e.g., its name) that we will need when converting the CSVAST to an
	 *       ast.functionDef.FunctionDef node using the CSV2AST class.
	 * 3. Upon finding a funcId different from the one on top of the funcIdStack,
	 *    it looks for that funcId within the stack. In a valid CSV file, this
	 *    funcId must have been previously declared by a function declaration.
	 *    a) If it is not found, an exception is thrown.
	 *    b) If it is found, the line is added to the correct csvAST within the stack.
	 *       Additionally, we know that we finished scanning at least one function (since
	 *       we got back to the "outer" scope). The distance from the top of the stack to
	 *       the csvAST that we just added the current line to is the number of functions
	 *       that we finished scanning. We pop the csvStack (and the funcIdStack) that many
	 *       times and put the popped CSVAST's in the csvFifoQueue.
	 */
	private void addNodeRowsUntilNextFile() throws InvalidCSVFile
	{		
		while( nodeReader.hasNextRow())
		{
			
			KeyedCSVRow currNodeRow = nodeReader.getNextRow();
			System.out.println(currNodeRow);
			String currType = currNodeRow.getFieldForKey(PHPCSVNodeTypes.TYPE);

			// ignore dir nodes
			if( currType.equals(PHPCSVNodeTypes.TYPE_DIRECTORY))
				continue;

			// If we met a file node and we finished some new functions, break.
			// There should always be some new functions except at the very beginning
			// when this function is called for the first time.
			if( currType.equals(PHPCSVNodeTypes.TYPE_FILE)) {
				if( !csvStack.isEmpty())
					break;
				else
					continue;
			}
			
			// if we met a toplevel node of a file, then make sure the csvStack is
			// empty, put a new CSVAST on the stack, add current row, and continue
			if( currType.equals(PHPCSVNodeTypes.TYPE_TOPLEVEL) &&
				currNodeRow.getFieldForKey(PHPCSVNodeTypes.FLAGS).contains(PHPCSVNodeTypes.FLAG_TOPLEVEL_FILE)) {
				
				// make sure stack is empty
				if( !csvStack.empty())
					throw new InvalidCSVFile( "A toplevel node of a file was found when the toplevel function"
							+ " of the previous file was not finished scanning.");
				
				// create a new top-level function at the bottom of the stack and add current row
				String topLevelFuncId = currNodeRow.getFieldForKey(PHPCSVNodeTypes.NODE_ID);
				initCSVAST(topLevelFuncId);
				csvStack.peek().addNodeRow( currNodeRow.toString());

				continue;
			}

			// we are looking neither at a dir node, file node, nor toplevel node of a file
			// make sure stack is not empty at this point
			if( csvStack.empty())
				throw new InvalidCSVFile( "No toplevel node of a file to initialize top-level code was found.");

			String currFuncId = currNodeRow.getFieldForKey(PHPCSVNodeTypes.FUNCID);

			// the funcid is still the same
			if( currFuncId.equals( funcIdStack.peek()))
				addRowAndInitASTForFuncType(currNodeRow, currType);
			// the funcid changed
			else {
				// how many functions did we just finish?
				int finishedFunctions = funcIdStack.search(currFuncId) - 1;
				// if currFuncId is not in the stack, fail; this should never happen with a valid CSV file
				if( finishedFunctions < 1)
					throw new InvalidCSVFile("funcid " + currFuncId +
							" has never been initialized by a function declaration.");
				// put finished functions into the finished functions queue
				for( int i = 0; i < finishedFunctions; i++) {
					csvFifoQueue.add( csvStack.pop());
					funcIdStack.pop();
				}
				// put the current line on the correct CSVAST
				addRowAndInitASTForFuncType(currNodeRow, currType);
			}
		}

		// If we are here, it means one of two things:
		// - We broke out of the loop because we finished scanning a file;
		// - The nodeReader does not have any more rows to read.
		// In both cases, we just push the remaining (now finished) functions
		// on the csvStack onto the csvFifoQueue.
		while( !csvStack.empty()) {
			csvFifoQueue.add( csvStack.pop());
			funcIdStack.pop();
		}
	}
	
	private void initCSVAST(String funcId)
	{
		CSVAST csvAST = new CSVAST();
		System.out.println("New CSVAST " + csvAST);
		csvAST.addNodeRow(nodeReader.getKeyRow());
		csvAST.addEdgeRow(edgeReader.getKeyRow());
		csvStack.push(csvAST);
		funcIdStack.push(funcId);
	}

	private void addRowAndInitASTForFuncType(KeyedCSVRow currNodeRow, String currType)
	{
		csvStack.peek().addNodeRow( currNodeRow.toString());
		if( PHPCSVNodeTypes.funcTypes.contains(currType)) {
			// if we met a function declaration node, push a new CSVAST atop the stack
			String currId = currNodeRow.getFieldForKey(PHPCSVNodeTypes.NODE_ID);
			initCSVAST(currId);
			// *also* add the declaration onto the newly created CSVAST
			// (see javadoc of getNextFunction())
			csvStack.peek().addNodeRow( currNodeRow.toString());
		}
	}

}
