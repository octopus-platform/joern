package inputModules.csv.csv2ast;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import ast.functionDef.FunctionDef;
import inputModules.csv.KeyedCSV.KeyedCSVReader;
import inputModules.csv.KeyedCSV.KeyedCSVRow;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import tools.phpast2cfg.PHPCSVNodeInterpreter;

public class CSV2AST
{
	KeyedCSVReader reader;
	CSVNodeInterpreter nodeInterpreter;
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
		initReader(nodeReader);
		ast = new ASTUnderConstruction();
		createASTNodes(nodeReader);
		return ast.getRootNode();
	}

	private void initReader(Reader in) throws IOException
	{
		reader = new KeyedCSVReader();
		reader.init(in);
	}

	private void createASTNodes(Reader nodeReader)
	{
		KeyedCSVRow keyedRow;
		while ((keyedRow = reader.getNextRow()) != null)
		{
			nodeInterpreter.handle(keyedRow, ast);
		}
	}

	public void setLanguage(String language)
	{
		if (language.equals("PHP"))
			nodeInterpreter = new PHPCSVNodeInterpreter();
	}

}
