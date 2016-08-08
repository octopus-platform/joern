package orientdbimporter;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.orientechnologies.orient.client.remote.OServerAdmin;
import com.orientechnologies.orient.core.config.OGlobalConfiguration;
import com.orientechnologies.orient.core.intent.OIntentMassiveInsert;
import com.orientechnologies.orient.core.metadata.schema.OType;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.impls.orient.OrientGraphNoTx;
import com.tinkerpop.blueprints.impls.orient.OrientVertexType;
import com.tinkerpop.blueprints.util.wrappers.batch.BatchGraph;

import orientdbimporter.processors.EdgeProcessor;
import orientdbimporter.processors.NodeProcessor;

public class CSVImporter
{
	private static final Logger logger = LoggerFactory
			.getLogger(CSVImporter.class);

	String dbName;
	Graph graph;
	OrientGraphNoTx noTx;

	String[] VertexKeys;
	String[] EdgeKeys;

	boolean isNewDatabase;

	public void setDbName(String dbName)
	{
		this.dbName = dbName;
	}

	public void importCSVFiles(String nodeFile, String edgeFile)
			throws IOException
	{
		openDatabase();
		processNodeFile(nodeFile);
		processEdgeFile(edgeFile);
		closeDatabase();
	}

	protected void openDatabase() throws IOException
	{
		isNewDatabase = !databaseExists(dbName);
		if(isNewDatabase)
			logger.debug("database exists");

		openNoTxForMassiveInsert();
		graph = BatchGraph.wrap(noTx, 1000);
	}

	protected void openNoTxForMassiveInsert()
	{
		OGlobalConfiguration.USE_WAL.setValue(false);
		OGlobalConfiguration.WAL_SYNC_ON_PAGE_FLUSH.setValue(false);

		String dbURL = "plocal:" + System.getProperty("ORIENTDB_HOME") + "/databases/" + dbName;
		logger.debug("opening database: " + dbURL);
		noTx = new OrientGraphNoTx(dbURL);
		noTx.declareIntent(new OIntentMassiveInsert());
		logger.debug("database opened");
	}

	protected void processNodeFile(String filename) throws IOException
	{
		if (filename == null)
			return;
		(new NodeProcessor(this)).process(filename);
	}


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

	protected void closeDatabase()
	{
		graph.shutdown();
		noTx.shutdown();
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

	public void createPropertiesAndIndices()
	{

		if (!isNewDatabase())
			return;

		OrientVertexType vType = noTx.getVertexType("V");

		for (String key : getVertexKeys())
		{
			vType.createProperty(key, OType.STRING);
		}

		List<String> keysToIndex = new LinkedList<String>();
		for (String key : getVertexKeys())
		{
			keysToIndex.add(key);
		}

		String[] indexKeys = new String[keysToIndex.size()];
		keysToIndex.sort(null);
		keysToIndex.toArray(indexKeys);

		vType.createIndex("nodeIndex.", "FULLTEXT", null, null, "LUCENE",
				indexKeys);

	}

}
