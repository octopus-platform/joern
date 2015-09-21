package inputModules.csv.csv2ast;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;

import ast.ASTNode;
import ast.functionDef.FunctionDef;
import inputModules.csv.KeyedCSV.KeyedCSVReader;
import inputModules.csv.KeyedCSV.KeyedCSVRow;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import tools.phpast2cfg.PHPNodeTypeMapper;

public class CSV2AST
{
	HashMap<Long, ASTNode> idToNode = new HashMap<Long, ASTNode>();
	KeyedCSVReader reader;
	CSVASTNodeFactory nodeFactory = new CSVASTNodeFactory(
			new PHPNodeTypeMapper());

	/**
	 * Convert a node and an edge file (CSV format) into an AST.
	 * 
	 * Expects the first line to contain keys, and the second line to contain
	 * the root node.
	 * 
	 * @return The root node, or null, if conversion fails.
	 * @throws InvalidCSVFile
	 * @throws IOException
	 */

	public FunctionDef convert(String nodeFilename, String edgeFilename)
			throws InvalidCSVFile, IOException
	{
		FileReader nodeReader = new FileReader(nodeFilename);
		FileReader edgeReader = new FileReader(edgeFilename);
		return convert(nodeReader, edgeReader);
	}

	private void initReader(Reader in) throws IOException
	{
		reader = new KeyedCSVReader();
		reader.init(in);
	}

	public FunctionDef convert(Reader nodeReader, Reader edgeReader)
			throws InvalidCSVFile, IOException
	{
		initReader(nodeReader);
		FunctionDef rootNode = createASTNodes(nodeReader);
		// createASTEdges(edgeReader);
		return rootNode;
	}

	private FunctionDef createASTNodes(Reader nodeReader) throws InvalidCSVFile
	{
		FunctionDef rootNode = processRootNodeRow();
		processRemainingNodes();
		return rootNode;
	}

	private void processRemainingNodes()
	{
		KeyedCSVRow keyedRow;
		while ((keyedRow = reader.getNextRow()) != null)
		{
			ASTNode node = nodeFactory.createNode(keyedRow);
			addNodeToMap(keyedRow, node);
		}
	}

	private FunctionDef processRootNodeRow() throws InvalidCSVFile
	{
		KeyedCSVRow keyedRow = reader.getNextRow();
		if (keyedRow == null)
			throw new InvalidCSVFile();

		ASTNode node = nodeFactory.createNode(keyedRow);
		if (!(node instanceof FunctionDef))
			throw new InvalidCSVFile();

		addNodeToMap(keyedRow, node);

		return (FunctionDef) node;
	}

	private void addNodeToMap(KeyedCSVRow keyedRow, ASTNode node)
	{
		String nodeIdStr = keyedRow.getFieldForKey("nodeId");
		if (nodeIdStr == null)
			throw new RuntimeException("nodeId field required");
		idToNode.put(Long.parseLong(nodeIdStr), node);
	}

}
