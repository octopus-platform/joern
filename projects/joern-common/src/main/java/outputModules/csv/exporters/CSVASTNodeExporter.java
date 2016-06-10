package outputModules.csv.exporters;

import java.util.Map;

import ast.ASTNode;
import databaseNodes.DatabaseNode;
import outputModules.common.ASTNodeExporter;
import outputModules.common.Writer;

public abstract class CSVASTNodeExporter extends ASTNodeExporter
{
	public abstract void addToDatabaseSafe(ASTNode node);

	@Override
	protected void addMainNode(DatabaseNode dbNode)
	{
		Map<String, Object> properties = dbNode.createProperties();
		Writer.addNode(dbNode, properties);

		mainNodeId = Writer.getIdForObject(dbNode);
	}

}
