package inputModules.csv.csvFuncExtractor;

import java.io.IOException;
import java.io.Reader;
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
	int finishedFunctions = 0;
	String topLevelFuncId;
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

	private void initTopLevelFuncAST(String topLevelFuncName)
	{
		CSVAST topLevelFuncAST = new CSVAST();
		topLevelFuncAST.addNodeRow(nodeReader.getKeyRow());
		// We use a pseudo-nodetype for top-level functions.
		// These have different properties and different children
		// and should be unambiguously distinguishable from
		// AST_FUNC_DECL, AST_METHOD and AST_CLOSURE nodes.
		topLevelFuncAST.addNodeRow(topLevelFuncId + "," + PHPCSVNodeTypes.TYPE_TOPLEVEL + ",,,,,,," + topLevelFuncName + ",");
		topLevelFuncAST.addEdgeRow(edgeReader.getKeyRow());
		csvStack.push(topLevelFuncAST);
		funcIdStack.push(topLevelFuncId);
	}

	private void initFuncAST(String funcId)
	{
		CSVAST csvAST = new CSVAST();
		csvAST.addNodeRow(nodeReader.getKeyRow());
		csvAST.addEdgeRow(edgeReader.getKeyRow());
		csvStack.push(csvAST);
		funcIdStack.push(funcId);
	}
	
	public FunctionDef getNextFunction()
			throws IOException, InvalidCSVFile
	{
		CSVAST csvAST = null;
		csvAST = getNodeRowsOfNextFunction();
		FunctionDef function = null;
		if(csvAST != null)
			function = csv2ast.convert(csvAST);
		return function;
	}

	/**
	 * This function reads lines from the nodeReader:
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
	 *       that we finished scanning. We set the global variable finishedFunctions to that
	 *       number. For the next that many calls of getNodeRowsOfNextFunction(), we simply
	 *       pop the csvStack (and the funcIdStack) and return the topmost CSVAST.
	 *      
	 *  @return The CSV lines corresponding to the next function, or null if we arrived at
	 *          the end of the CSV file and there is nothing more to return.
	 */
	private CSVAST getNodeRowsOfNextFunction() throws InvalidCSVFile
	{
		
		CSVAST csvAST = null;
		
		while( 0 == finishedFunctions && nodeReader.hasNextRow())
		{

			KeyedCSVRow currNodeRow = nodeReader.getNextRow();
			System.out.println(currNodeRow);
			String currType = currNodeRow.getFieldForKey(PHPCSVNodeTypes.TYPE);

			// ignore dir nodes
			if( currType.equals(PHPCSVNodeTypes.TYPE_DIRECTORY))
				continue;

			// if we met a file node, empty the csvStack and create a new
			// top-level function
			if( currType.equals(PHPCSVNodeTypes.TYPE_FILE)) {

				// to empty the csvStack later
				finishedFunctions = csvStack.size();

				// create a new top-level function at the bottom of the stack
				Stack<CSVAST> tmpCSVStack = new Stack<CSVAST>();
				Stack<String> tmpFuncIdStack = new Stack<String>();
				for( int i = 0; i < finishedFunctions; i++) {
					tmpCSVStack.push( csvStack.pop());
					tmpFuncIdStack.push( funcIdStack.pop());
				}
				topLevelFuncId = currNodeRow.getFieldForKey(PHPCSVNodeTypes.NODE_ID);
				initTopLevelFuncAST("<" + currNodeRow.getFieldForKey(PHPCSVNodeTypes.NAME) + ">");
				for( int i = 0; i < finishedFunctions; i++) {
					csvStack.push( tmpCSVStack.pop());
					funcIdStack.push( tmpFuncIdStack.pop());
				}

				// If there are finished functions on the stack (this should always be the case
				// except at the very beginning when we never yet created a top-level function),
				// then we have to return them first. Otherwise, we just continue the loop
				if( 0 != finishedFunctions)
					break;
				else
					continue;
			}

			String currFuncId = currNodeRow.getFieldForKey(PHPCSVNodeTypes.FUNCID);
			// if this is a top-level node, use id of artificial top-level function
			if( currFuncId.equals("")) currFuncId = topLevelFuncId;
								
			// make sure stack is not empty at this point
			if( csvStack.empty())
				throw new InvalidCSVFile( "No file node to initialize top-level code was found.");

			// the funcid is still the same
			if( currFuncId.equals( funcIdStack.peek()))
				addRowAndInitASTForFuncType(currNodeRow, currType);
			// the funcid changed
			else {
				// how many functions did we just finish?
				finishedFunctions = funcIdStack.search(currFuncId) - 1;
				// if currFuncId is not in the stack, fail; this should never happen with a valid CSV file
				if( finishedFunctions < 1)
					throw new InvalidCSVFile("funcid " + currFuncId +
							" has never been initialized by a function declaration.");
				// put the current line on the correct CSVAST
				Stack<CSVAST> tmpCSVStack = new Stack<CSVAST>();
				Stack<String> tmpFuncIdStack = new Stack<String>();
				for( int i = 0; i < finishedFunctions; i++) {
					tmpCSVStack.push( csvStack.pop());
					tmpFuncIdStack.push( funcIdStack.pop());
				}
				addRowAndInitASTForFuncType(currNodeRow, currType);
				// put everything back
				for( int i = 0; i < finishedFunctions; i++) {
					csvStack.push( tmpCSVStack.pop());
					funcIdStack.push( tmpFuncIdStack.pop());
				}
				// We finished at least one function.
				// By breaking, we just return it.
				break;
			}
		}
		
		if( !nodeReader.hasNextRow())
			finishedFunctions = csvStack.size();
			
		// If we are here, it means one of two things:
		// - We broke out of the loop because we finished scanning a function;
		//   then, finishedFunctions is greater than 0 and there are at least
		//   that many CSVAST's on the stack
		// - The nodeReader does not have any more rows to read.
		//   In this case, just pop the stack and return the popped element.
		//   This can occur several times, e.g., if a function was at the very end
		//   of a file, first that function will be returned, then the top-level function.
		if( finishedFunctions > 0) {
			csvAST = csvStack.pop();
			funcIdStack.pop();
			finishedFunctions--;
		}
		
		return csvAST;
	}

	private void addRowAndInitASTForFuncType(KeyedCSVRow currNodeRow, String currType)
	{
		csvStack.peek().addNodeRow( currNodeRow.toString());
		if( PHPCSVNodeTypes.funcTypes.contains(currType)) {
			// if we met a function declaration node, push a new CSVAST atop the stack
			String currId = currNodeRow.getFieldForKey(PHPCSVNodeTypes.NODE_ID);
			initFuncAST(currId);
			// *also* add the declaration onto the newly created CSVAST
			// (see javadoc of getNextFunction())
			csvStack.peek().addNodeRow( currNodeRow.toString());
		}
	}

}
