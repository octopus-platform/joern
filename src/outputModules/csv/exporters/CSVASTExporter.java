package outputModules.csv.exporters;

import java.util.Map;

import outputModules.common.ASTExporter;
import outputModules.csv.CSVWriter;
import ast.ASTNode;
import databaseNodes.ASTDatabaseNode;
import databaseNodes.EdgeTypes;
import databaseNodes.NodeKeys;

public class CSVASTExporter extends ASTExporter
{

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
