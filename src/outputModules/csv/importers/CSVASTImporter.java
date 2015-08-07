package outputModules.csv.importers;

import java.util.Map;

import outputModules.ASTImporter;
import outputModules.csv.CSVWriter;
import ast.ASTNode;
import databaseNodes.ASTDatabaseNode;
import databaseNodes.EdgeTypes;
import databaseNodes.NodeKeys;

public class CSVASTImporter extends ASTImporter
{

	@Override
	protected void addASTChildren(ASTNode node)
	{

		final int nChildren = node.getChildCount();

		for (int i = 0; i < nChildren; i++)
		{
			ASTNode child = node.getChild(i);
			addASTToDatabase(child);
			addASTLink(node, child);
		}

	}

	@Override
	protected void addASTLink(ASTNode parent, ASTNode child)
	{
		long srcId = CSVWriter.getIdForObject(parent);
		long dstId = CSVWriter.getIdForObject(child);
		CSVWriter.addEdge(srcId, dstId, null, EdgeTypes.IS_AST_PARENT);
	}

	@Override
	protected void addASTNode(ASTNode node)
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
