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

public class CSV2AST
{
	KeyedCSVReader reader;
	CSVRowInterpreter nodeInterpreter;
	CSVRowInterpreter edgeInterpreter;
	ASTUnderConstruction ast;

	public FunctionDef convert(String nodeFilename, String edgeFilename)
			throws InvalidCSVFile, IOException
	{
		FileReader nodeReader = new FileReader(nodeFilename);
		FileReader edgeReader = new FileReader(edgeFilename);
		return convert(nodeReader, edgeReader);
	}

	public FunctionDef convert(Reader nodeReader, Reader edgeReader)
			throws IOException
	{
		ast = new ASTUnderConstruction();

		initReader(nodeReader);
		createASTNodes();

		initReader(edgeReader);
		createASTEdges();
		
		return ast.getRootNode();
	}

	public FunctionDef convert(CSVAST csvAST) throws IOException
	{
		ast = new ASTUnderConstruction();

		initReader(csvAST.getNodesAsString());
		createASTNodes();

		initReader(csvAST.getEdgesAsString());
		createASTEdges();

		return ast.getRootNode();
	}

	private void initReader(String str) throws IOException
	{
		StringReader stringReader = new StringReader(str);
		reader = new KeyedCSVReader();
		reader.init(stringReader);
	}

	private void initReader(Reader in) throws IOException
	{
		reader = new KeyedCSVReader();
		reader.init(in);
	}

	private void createASTNodes()
	{
		KeyedCSVRow keyedRow;
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
