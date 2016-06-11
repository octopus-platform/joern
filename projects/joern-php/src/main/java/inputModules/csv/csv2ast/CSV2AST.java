package inputModules.csv.csv2ast;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.NoSuchElementException;

import ast.functionDef.FunctionDef;
import inputModules.csv.KeyedCSV.KeyedCSVReader;
import inputModules.csv.KeyedCSV.KeyedCSVRow;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import tools.PHPCSVNodeTypes;


public class CSV2AST
{
	CSVRowInterpreter nodeInterpreter;
	CSVRowInterpreter edgeInterpreter;

	public FunctionDef convert(String nodeFilename, String edgeFilename)
			throws IOException, InvalidCSVFile
	{
		FileReader nodeStrReader = new FileReader(nodeFilename);
		FileReader edgeStrReader = new FileReader(edgeFilename);

		return convert(nodeStrReader, edgeStrReader);
	}

	public FunctionDef convert(Reader nodeStrReader, Reader edgeStrReader)
			throws IOException, InvalidCSVFile
	{
		KeyedCSVReader nodeReader = new KeyedCSVReader();
		KeyedCSVReader edgeReader = new KeyedCSVReader();
		nodeReader.init(nodeStrReader);
		edgeReader.init(edgeStrReader);

		CSVAST csvAST = new CSVAST();
		while( nodeReader.hasNextRow())
			csvAST.addNodeRow(nodeReader.getNextRow());
		while( edgeReader.hasNextRow())
			csvAST.addEdgeRow(edgeReader.getNextRow());

		return convert(csvAST);
	}

	public FunctionDef convert(CSVAST csvAST)
			throws IOException, InvalidCSVFile
	{
		ASTUnderConstruction ast = new ASTUnderConstruction();

		createASTNodes(csvAST, ast);
		createASTEdges(csvAST, ast);

		return ast.getRootNode();
	}

	private void createASTNodes(CSVAST csvAST, ASTUnderConstruction ast) throws InvalidCSVFile
	{
		Iterator<KeyedCSVRow> nodeRows = csvAST.nodeIterator();
		KeyedCSVRow keyedRow;

		try {
			keyedRow = nodeRows.next();
		}
		catch( NoSuchElementException ex) {
			throw new InvalidCSVFile( "Empty CSV files are not permissible.");
		}

		// first row must be a function type;
		// otherwise we cannot create a function node
		if( !PHPCSVNodeTypes.funcTypes.contains(keyedRow.getFieldForKey(PHPCSVNodeTypes.TYPE)))
			throw new InvalidCSVFile( "Type of first row is not a function declaration.");

		FunctionDef root = (FunctionDef) ast.getNodeById( nodeInterpreter.handle(keyedRow, ast));
		ast.setRootNode(root);

		while (nodeRows.hasNext())
		{
			keyedRow = nodeRows.next();
			nodeInterpreter.handle(keyedRow, ast);
		}
	}

	private void createASTEdges(CSVAST csvAST, ASTUnderConstruction ast) throws InvalidCSVFile
	{
		Iterator<KeyedCSVRow> edgeRows = csvAST.edgeIterator();
		KeyedCSVRow keyedRow;

		while (edgeRows.hasNext())
		{
			keyedRow = edgeRows.next();
			edgeInterpreter.handle(keyedRow, ast);
		}
	}

	public void setInterpreters(CSVRowInterpreter nodeInterpreter, CSVRowInterpreter edgeInterpreter)
	{
		this.nodeInterpreter = nodeInterpreter;
		this.edgeInterpreter = edgeInterpreter;
	}

}
