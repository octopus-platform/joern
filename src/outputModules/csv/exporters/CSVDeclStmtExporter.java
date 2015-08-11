package outputModules.csv.exporters;

import java.util.Map;

import outputModules.common.DeclStmtExporter;
import outputModules.csv.CSVWriter;
import databaseNodes.DatabaseNode;
import databaseNodes.EdgeTypes;

public class CSVDeclStmtExporter extends DeclStmtExporter
{

	public CSVDeclStmtExporter()
	{
		declImporter = new CSVDeclExporter();
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
