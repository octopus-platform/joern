package tools.phpast2cfg.csv2ast;

import java.io.IOException;
import java.util.HashMap;

import ast.ASTNode;
import ast.functionDef.FunctionDef;
import tools.phpast2cfg.PHPCSVASTNodeTypes;
import tools.phpast2cfg.KeyedCSV.KeyedCSVReader;
import tools.phpast2cfg.KeyedCSV.KeyedCSVRow;
import tools.phpast2cfg.KeyedCSV.exceptions.InvalidCSVFile;

public class CSV2AST
{
	HashMap<Long, ASTNode> idToNode = new HashMap<Long, ASTNode>();
	KeyedCSVReader reader;
	CSVASTNodeFactory nodeFactory = new CSVASTNodeFactory(
			new PHPCSVASTNodeTypes());

	/**
	 * Convert a node and an edge file (CSV format) into an AST.
	 * 
	 * Expects the first line to contain keys, and the second line to contain
	 * the root node.
	 * 
	 * @return The root node, or null, if conversion fails.
	 */

	public FunctionDef convert(String nodeFilename, String edgeFilename)
	{
		try
		{
			return createAST(nodeFilename);
		} catch (IOException | InvalidCSVFile e)
		{
			return null;
		}
	}

	private FunctionDef createAST(String nodeFilename)
			throws IOException, InvalidCSVFile
	{
		FunctionDef rootNode;
		rootNode = createASTNodes(nodeFilename);
		createASTEdges(nodeFilename);
		return rootNode;
	}

	private FunctionDef createASTNodes(String nodeFilename)
			throws IOException, InvalidCSVFile
	{
		initCSVReader(nodeFilename);
		FunctionDef rootNode = processRootNodeRow();
		processCSVNodes();
		deinitCSVReader();
		return rootNode;
	}

	private FunctionDef processRootNodeRow() throws InvalidCSVFile, IOException
	{
		KeyedCSVRow keyedRow = reader.getNextRow();
		if (keyedRow == null)
			throw new InvalidCSVFile();

		ASTNode node = nodeFactory.createNode(keyedRow);
		if (!(node instanceof FunctionDef))
			throw new InvalidCSVFile();
		return (FunctionDef) node;
	}

	private void createASTEdges(String edgeFilename)
			throws IOException, InvalidCSVFile
	{
		initCSVReader(edgeFilename);
		processCSVEdges();
		deinitCSVReader();
	}

	private void initCSVReader(String filename)
			throws InvalidCSVFile, IOException
	{
		reader = new KeyedCSVReader();
		reader.setSeparator(',');
		reader.open(filename);
	}

	private void processCSVNodes() throws IOException
	{
		KeyedCSVRow keyedRow;
		while ((keyedRow = reader.getNextRow()) != null)
		{
			processCSVNode(keyedRow);
		}
	}

	private void processCSVEdges() throws IOException
	{
		KeyedCSVRow keyedRow;
		while ((keyedRow = reader.getNextRow()) != null)
		{
			processCSVEdge(keyedRow);
		}
	}

	private void processCSVNode(KeyedCSVRow keyedRow)
	{
		ASTNode node = nodeFactory.createNode(keyedRow);
	}

	private void processCSVEdge(KeyedCSVRow keyedRow)
	{

	}

	private void deinitCSVReader() throws IOException
	{
		reader.close();
	}

}
