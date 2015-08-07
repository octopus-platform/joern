package outputModules.csv.importers;

import java.util.Map;

import outputModules.csv.CSVWriter;
import ast.ASTNode;
import databaseNodes.ASTDatabaseNode;
import databaseNodes.EdgeTypes;
import databaseNodes.FunctionDatabaseNode;
import databaseNodes.NodeKeys;

public class ASTImporter
{
	private FunctionDatabaseNode currentFunction;

	public void importAST(ASTNode node)
	{
		addASTNode(node);
		addASTChildren(node);
	}

	public void setCurrentFunction(FunctionDatabaseNode func)
	{
		currentFunction = func;
	}

	private void addASTChildren(ASTNode node)
	{

		final int nChildren = node.getChildCount();

		for (int i = 0; i < nChildren; i++)
		{
			ASTNode child = node.getChild(i);
			importAST(child);
			addASTLink(node, child);
		}

	}

	private void addASTLink(ASTNode parent, ASTNode child)
	{
		long srcId = CSVWriter.getIdForObject(parent);
		long dstId = CSVWriter.getIdForObject(child);
		CSVWriter.addEdge(srcId, dstId, null, EdgeTypes.IS_AST_PARENT);
	}

	private void addASTNode(ASTNode node)
	{
		ASTDatabaseNode astDatabaseNode = new ASTDatabaseNode();
		astDatabaseNode.initialize(node);
		astDatabaseNode.setCurrentFunction(currentFunction);
		Map<String, Object> properties = astDatabaseNode.createProperties();

		properties.put(NodeKeys.FUNCTION_ID,
				CSVWriter.getIdForObject(currentFunction).toString());
		CSVWriter.addNode(node, properties);
	}
}
