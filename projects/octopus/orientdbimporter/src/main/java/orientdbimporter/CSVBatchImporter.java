package orientdbimporter;

import java.io.IOException;

import com.orientechnologies.orient.client.remote.OServerAdmin;
import com.tinkerpop.blueprints.util.wrappers.batch.BatchGraph;

import orientdbimporter.CSVImporter;
import orientdbimporter.processors.EdgeProcessor;
import orientdbimporter.processors.NodeProcessor;

public class CSVBatchImporter extends CSVImporter
{
	@Override
	protected void openDatabase() throws IOException
	{
		isNewDatabase = !databaseExists(dbName);
		openNoTxForMassiveInsert();
		graph = BatchGraph.wrap(noTx, 1000);
	}

	@Override
	protected void processNodeFile(String filename) throws IOException
	{
		if (filename == null)
			return;
		(new NodeProcessor(this)).process(filename);
	}

	@Override
	protected void processEdgeFile(String filename) throws IOException
	{
		if (filename == null)
			return;
		(new EdgeProcessor(this)).process(filename);
	}

	private boolean databaseExists(String dbName) throws IOException
	{
		return new OServerAdmin("localhost/" + dbName).connect(
				Constants.DB_USERNAME, Constants.DB_PASSWORD).existsDatabase();
	}

}
