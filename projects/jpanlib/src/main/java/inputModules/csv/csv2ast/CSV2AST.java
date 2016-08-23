package inputModules.csv.csv2ast;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.NoSuchElementException;

import ast.functionDef.FunctionDefBase;
import inputModules.csv.KeyedCSV.KeyedCSVReader;
import inputModules.csv.KeyedCSV.KeyedCSVRow;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;


public class CSV2AST
{
	CSVRowInterpreter nodeInterpreter;
	CSVRowInterpreter edgeInterpreter;

	public FunctionDefBase convert(String nodeFilename, String edgeFilename)
			throws IOException, InvalidCSVFile
	{
		FileReader nodeStrReader = new FileReader(nodeFilename);
		FileReader edgeStrReader = new FileReader(edgeFilename);

		return convert(nodeStrReader, edgeStrReader);
	}

	public FunctionDefBase convert(Reader nodeStrReader, Reader edgeStrReader)
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

	public FunctionDefBase convert(CSVAST csvAST)
			throws IOException, InvalidCSVFile
	{
		ASTUnderConstruction ast = new ASTUnderConstruction();

		createASTNodes(csvAST, ast);
		createASTEdges(csvAST, ast);

		return ast.getRootNode();
	}

	protected void createASTNodes(CSVAST csvAST, ASTUnderConstruction ast) throws InvalidCSVFile
	{
		Iterator<KeyedCSVRow> nodeRows = csvAST.nodeIterator();
		KeyedCSVRow keyedRow = getFirstKeyedRow(nodeRows);
		createASTForFunction(ast, nodeRows, keyedRow);
	}

	protected KeyedCSVRow getFirstKeyedRow(Iterator<KeyedCSVRow> nodeRows) throws InvalidCSVFile {
		try {
			return nodeRows.next();
		}
		catch( NoSuchElementException ex) {
			throw new InvalidCSVFile( "Empty CSV files are not permissible.");
		}

	}

	protected void createASTForFunction(ASTUnderConstruction ast, Iterator<KeyedCSVRow> nodeRows, KeyedCSVRow keyedRow)
			throws InvalidCSVFile
	{
		FunctionDefBase root = (FunctionDefBase) ast.getNodeById( nodeInterpreter.handle(keyedRow, ast));
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
