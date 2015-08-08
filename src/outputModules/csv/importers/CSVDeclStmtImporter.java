package outputModules.csv.importers;

import java.util.Map;

import outputModules.DeclStmtImporter;
import outputModules.csv.CSVWriter;
import databaseNodes.DatabaseNode;
import databaseNodes.EdgeTypes;

public class CSVDeclStmtImporter extends DeclStmtImporter
{

	public CSVDeclStmtImporter()
	{
		declImporter = new CSVDeclImporter();
	}

	@Override
	protected void addLinkFromStmtToDecl(long mainNodeId, long declId)
	{
		CSVWriter.addEdge(mainNodeId, declId, null, EdgeTypes.DECLARES);
	}

	@Override
	protected void addMainNode(DatabaseNode dbNode)
	{
		Map<String, Object> properties = dbNode.createProperties();
		CSVWriter.addNode(dbNode, properties);
		mainNodeId = CSVWriter.getIdForObject(dbNode);
	}

}
