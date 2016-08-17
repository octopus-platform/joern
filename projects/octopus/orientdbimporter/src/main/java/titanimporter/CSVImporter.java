package titanimporter;

import java.io.IOException;

import org.apache.tinkerpop.gremlin.structure.Edge;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CSVImporter
{
	private static final Logger logger = LoggerFactory
			.getLogger(CSVImporter.class);

	String dbName;
	Graph graph;

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

		if (num == Constants.MAX_NODES_FOR_KEY)
			throw new RuntimeException("Too many nodes with the same key: " + baseId);

		// The first node gets the baseId, all others will
		// obtain an additional "_$number" and will be connected to
		// the last alternative.

		String completeId = createCompleteId(baseId, num);

		try
		{
			graph.addVertex(completeId, props);

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

		Vertex fromNode = graph.vertices(previousId).next();
		Vertex toNode = graph.vertices(thisId).next();

		fromNode.addEdge("foo", toNode);
	}

	private void addNodeToGraphNoReplace(String id, Object[] props)
	{
		String completeId = createCompleteId(id, 0);

		try
		{
			graph.addVertex(completeId, props);
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
			logger.debug("Cannot resolve source node {} for {} -> {}", srcId,
					srcId, dstId);
			return;
		}

		if (inVertex == null)
		{
			logger.debug("Cannot resolve destination node {} for {} -> {}",
					dstId, srcId, dstId);
			return;
		}

		Edge edge = outVertex.addEdge(label, inVertex);

		for (int i = 3; i < row.length; i++)
		{
			edge.property(edgeFile.getKeys()[i], row[i]);
		}

	}

	protected Vertex lookupVertex(String id, Graph graph)
	{
		// Problem is: id is an external id

		return graph.vertices(id).next();
	}

	public void closeDatabase()
	{
		try {
			graph.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean isNewDatabase()
	{
		return isNewDatabase;
	}

	public void setGraph(Graph graph)
	{
		this.graph = graph;
	}

}
