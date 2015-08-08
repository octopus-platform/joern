package outputModules.csv.importers;

import java.util.Map;

import outputModules.ASTNodeImporter;
import outputModules.csv.CSVWriter;
import ast.ASTNode;
import databaseNodes.DatabaseNode;

public abstract class CSVASTNodeImporter extends ASTNodeImporter
{
	public abstract void addToDatabaseSafe(ASTNode node);

	@Override
	protected void addMainNode(DatabaseNode dbNode)
	{
		Map<String, Object> properties = dbNode.createProperties();
		CSVWriter.addNode(dbNode, properties);
	}

}
