package orientdbimporter;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.orientechnologies.orient.client.remote.OServerAdmin;
import com.orientechnologies.orient.core.config.OGlobalConfiguration;
import com.orientechnologies.orient.core.intent.OIntentMassiveInsert;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;
import com.tinkerpop.blueprints.util.wrappers.batch.BatchGraph;
import com.tinkerpop.blueprints.util.wrappers.batch.VertexIDType;

public class CSVImporter
{
	private static final Logger logger = LoggerFactory
			.getLogger(CSVImporter.class);

	String dbName;
	Graph graph;
	OrientGraph tx;

	String[] VertexKeys;
	String[] EdgeKeys;

	boolean isNewDatabase;

	NodeFile nodeFile;
	EdgeFile edgeFile;

	public void setDbName(String dbName)
	{
		this.dbName = dbName;
	}

	public void importCSVFiles(String nodeFilename, String edgeFilename)
			throws IOException
	{
		openNodeFile(nodeFilename);
		openEdgeFile(edgeFilename);

		isNewDatabase = !databaseExists(dbName);

		if (!isNewDatabase())
			return;

		openDatabaseForBatchInsert();
		initializeDatabase();

		importNodes();
		importEdges();
		closeDatabase();
	}

	private void openNodeFile(String nodeFilename) throws IOException
	{
		nodeFile = new NodeFile();
		nodeFile.openFile(nodeFilename);
	}

	private void openEdgeFile(String edgeFilename) throws IOException
	{
		edgeFile = new EdgeFile();
		edgeFile.openFile(edgeFilename);
	}

	public void initializeDatabase() throws IOException
	{
		DatabaseInitializer initializer = new DatabaseInitializer();

		initializer.setVertexKeys(nodeFile.getKeys());
		initializer.initialize(tx);

	}

	private boolean databaseExists(String dbName) throws IOException
	{
		return new OServerAdmin("localhost/" + dbName).connect(
				Constants.DB_USERNAME, Constants.DB_PASSWORD).existsDatabase();
	}

	private void openDatabaseForBatchInsert() throws IOException
	{
		OGlobalConfiguration.USE_WAL.setValue(false);
		OGlobalConfiguration.WAL_SYNC_ON_PAGE_FLUSH.setValue(false);

		String dbURL = "plocal:" + System.getProperty("ORIENTDB_HOME") + "/databases/" + dbName;
		logger.debug("opening database: " + dbURL);
		tx = new OrientGraph(dbURL);
		tx.declareIntent(new OIntentMassiveInsert());
		logger.debug("database opened");

		graph = new BatchGraph<OrientGraph>(tx, VertexIDType.STRING, 1000);
	}

	protected void importNodes() throws IOException
	{
		String [] row;

		while((row = nodeFile.getNextRow()) != null)
		{
			importNodeRow(row);
		}
	}

	private void importNodeRow(String[] row)
	{
		// skip empty lines
		if (row.length < 1)
			return;

		String command = row[0];
		String id = row[1];

		String[] properties = new String[2 * (row.length - 1)];
		for (int i = 1; i < row.length; i++)
		{
			// We subtract 1 here when accessing vertex keys because
			// the first key (command) is discarded.
			properties[2 * (i - 1)] = nodeFile.getKeys()[i - 1];
			properties[2 * (i - 1) + 1] = row[i];
		}
		Object[] props = properties;

		if (command.equals(CSVCommands.ADD))
			addNodeToGraph(id, props);
		else if (command.equals(CSVCommands.ADD_NO_REPLACE))
			addNodeToGraphNoReplace(id, props);

	}

	private void addNodeToGraph(String id, Object[] props)
	{
		try
		{
			doAddNodeToGraph(id, props, 0);
		} catch (RuntimeException e)
		{
			logger.error(e.getMessage());
		}
	}

	private void doAddNodeToGraph(String baseId, Object[] props, int num)
	{
		BatchGraph<?> batchGraph = (BatchGraph<?>) graph;

		if (num == Constants.MAX_NODES_FOR_KEY)
			throw new RuntimeException("Too many nodes with the same key: " + baseId);

		// The first node gets the baseId, all others will
		// obtain an additional "_$number" and will be connected to
		// the last alternative.

		String completeId = createCompleteId(baseId, num);

		try
		{
			batchGraph.addVertex(completeId, props);

			if (num != 0)
			{
				linkToPreviousNode(baseId, num);
			}

		} catch (IllegalArgumentException e)
		{
			doAddNodeToGraph(baseId, props, num + 1);
		}
	}

	private String createCompleteId(String baseId, int num)
	{
		String completeId;
		if (num == 0)
			completeId = baseId;
		else
			completeId = String.format("%s_%d", baseId, num);
		return completeId;
	}

	private void linkToPreviousNode(String baseId, int num)
	{
		String previousId = createCompleteId(baseId, num - 1);
		String thisId = createCompleteId(baseId, num);

		Vertex fromNode = graph.getVertex(previousId);
		Vertex toNode = graph.getVertex(thisId);

		graph.addEdge(0, fromNode, toNode, "foo");
	}

	private void addNodeToGraphNoReplace(String id, Object[] props)
	{
		String completeId = createCompleteId(id, 0);
		BatchGraph<?> batchGraph = (BatchGraph<?>) graph;

		try
		{
			batchGraph.addVertex(completeId, props);
		} catch (IllegalArgumentException e)
		{
			return;
		}
	}

	protected void importEdges() throws IOException
	{
		String [] row;

		while((row = edgeFile.getNextRow()) != null)
		{
			importEdgeRow(row);
		}
	}

	private void importEdgeRow(String[] row)
	{

		if (row.length < 3)
			return;

		String srcId = row[0];
		String dstId = row[1];
		String label = row[2];

		Vertex outVertex = lookupVertex(srcId, graph);
		Vertex inVertex = lookupVertex(dstId, graph);

		if (outVertex == null)
		{
			logger.info("Cannot resolve source node {} for {} -> {}", srcId,
					srcId, dstId);
			return;
		}

		if (inVertex == null)
		{
			logger.info("Cannot resolve destination node {} for {} -> {}",
					dstId, srcId, dstId);
			return;
		}

		Edge edge = graph.addEdge(0, outVertex, inVertex, label);

		for (int i = 3; i < row.length; i++)
		{
			edge.setProperty(edgeFile.getKeys()[i], row[i]);
		}

	}

	protected Vertex lookupVertex(String id, Graph batchGraph)
	{
		return batchGraph.getVertex(id);
	}

	public void closeDatabase()
	{
		graph.shutdown();
		tx.shutdown();
	}

	public boolean isNewDatabase()
	{
		return isNewDatabase;
	}

}
