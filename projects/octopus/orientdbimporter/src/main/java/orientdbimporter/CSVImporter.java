package orientdbimporter;

import java.io.IOException;

import com.orientechnologies.orient.core.config.OGlobalConfiguration;
import com.orientechnologies.orient.core.intent.OIntentMassiveInsert;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.impls.orient.OrientGraphNoTx;

public abstract class CSVImporter
{
	protected String dbName;
	protected Graph graph;
	protected OrientGraphNoTx noTx;

	protected String[] VertexKeys;
	protected String[] EdgeKeys;

	protected boolean isNewDatabase;

	public void importCSVFiles(String nodeFile, String edgeFile)
			throws IOException
	{
		openDatabase();
		processNodeFile(nodeFile);
		processEdgeFile(edgeFile);
		closeDatabase();
	}

	protected abstract void processNodeFile(String nodeFile) throws IOException;

	protected abstract void processEdgeFile(String edgeFile) throws IOException;

	protected abstract void openDatabase() throws IOException;

	protected void closeDatabase()
	{
		graph.shutdown();
		noTx.shutdown();
	}

	protected void openNoTxForMassiveInsert()
	{
		OGlobalConfiguration.USE_WAL.setValue(false);
		OGlobalConfiguration.WAL_SYNC_ON_PAGE_FLUSH.setValue(false);

		noTx = new OrientGraphNoTx(
				"plocal:" + System.getProperty("ORIENTDB_HOME") + "/databases/" + dbName);
		noTx.declareIntent(new OIntentMassiveInsert());
	}

	public void setDbName(String dbName)
	{
		this.dbName = dbName;
	}

	public Graph getGraph()
	{
		return graph;
	}

	public String[] getVertexKeys()
	{
		return VertexKeys;
	}

	public void setVertexKeys(String[] vertexKeys)
	{
		VertexKeys = vertexKeys;
	}

	public String[] getEdgeKeys()
	{
		return EdgeKeys;
	}

	public void setEdgeKeys(String[] edgeKeys)
	{
		EdgeKeys = edgeKeys;
	}

	public boolean isNewDatabase()
	{
		return isNewDatabase;
	}

	public OrientGraphNoTx getNoTx()
	{
		return noTx;
	}

}
