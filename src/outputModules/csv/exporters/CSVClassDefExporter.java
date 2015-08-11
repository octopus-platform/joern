package outputModules.csv.exporters;

import java.util.Map;

import outputModules.common.ClassDefExporter;
import outputModules.csv.CSVWriter;
import databaseNodes.ClassDefDatabaseNode;
import databaseNodes.DatabaseNode;
import databaseNodes.EdgeTypes;
import databaseNodes.FileDatabaseNode;

public class CSVClassDefExporter extends ClassDefExporter
{

	@Override
	protected void linkClassDefToFileNode(ClassDefDatabaseNode classDefNode,
			FileDatabaseNode fileNode)
	{

		long fileId = fileNode.getId();
		long functionId = CSVWriter.getIdForObject(classDefNode);

		CSVWriter.addEdge(fileId, functionId, null, EdgeTypes.IS_FILE_OF);
	}

	@Override
	protected void addMainNode(DatabaseNode dbNode)
	{
		Map<String, Object> properties = dbNode.createProperties();
		CSVWriter.addNode(dbNode, properties);
		mainNodeId = CSVWriter.getIdForObject(dbNode);
	}

}
