package inputModules.csv.csv2ast;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import ast.functionDef.FunctionDef;
import inputModules.csv.KeyedCSV.KeyedCSVReader;
import inputModules.csv.KeyedCSV.KeyedCSVRow;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import inputModules.csv.csvFuncExtractor.CSVAST;
import tools.phpast2cfg.PHPCSVEdgeInterpreter;
import tools.phpast2cfg.PHPCSVNodeInterpreter;
import tools.phpast2cfg.PHPCSVNodeTypes;

public class CSV2AST
{
	KeyedCSVReader reader;
	CSVRowInterpreter nodeInterpreter;
	CSVRowInterpreter edgeInterpreter;
	ASTUnderConstruction ast;

	public FunctionDef convert(String nodeFilename, String edgeFilename)
			throws IOException, InvalidCSVFile
	{
		FileReader nodeReader = new FileReader(nodeFilename);
		FileReader edgeReader = new FileReader(edgeFilename);
		return convert(nodeReader, edgeReader);
	}

	public FunctionDef convert(CSVAST csvAST)
			throws IOException, InvalidCSVFile
	{
		StringReader nodeReader = new StringReader(csvAST.getNodesAsString());
		StringReader edgeReader = new StringReader(csvAST.getEdgesAsString());
		return convert(nodeReader, edgeReader);
	}
	
	public FunctionDef convert(Reader nodeReader, Reader edgeReader)
			throws IOException, InvalidCSVFile
	{
		ast = new ASTUnderConstruction();

		initReader(nodeReader);
		createASTNodes();

		initReader(edgeReader);
		createASTEdges();
		
		return ast.getRootNode();
	}

	private void initReader(Reader in) throws IOException
	{
		reader = new KeyedCSVReader();
		reader.init(in);
	}

	private void createASTNodes() throws InvalidCSVFile
	{
		KeyedCSVRow keyedRow;

		// first row must be a function type;
		// otherwise we cannot create a function node
		keyedRow = reader.getNextRow();
		if( null == keyedRow || !PHPCSVNodeTypes.funcTypes.contains(keyedRow.getFieldForKey(PHPCSVNodeTypes.TYPE)))
			throw new InvalidCSVFile( "Type of first row is not a function declaration.");
		
		FunctionDef root = (FunctionDef) ast.getNodeById( nodeInterpreter.handle(keyedRow, ast));
		ast.setRootNode(root);

		while ((keyedRow = reader.getNextRow()) != null)
		{
			nodeInterpreter.handle(keyedRow, ast);
		}
	}

	private void createASTEdges()
	{
		KeyedCSVRow keyedRow;
		while ((keyedRow = reader.getNextRow()) != null)
		{
			edgeInterpreter.handle(keyedRow, ast);
		}
	}

	public void setLanguage(String language)
	{
		if (language.equals("PHP"))
		{
			nodeInterpreter = new PHPCSVNodeInterpreter();
			edgeInterpreter = new PHPCSVEdgeInterpreter();
		}
	}

}
