package octopus.server.importer.csv.titan;

import java.io.IOException;

import org.apache.tinkerpop.gremlin.structure.Edge;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thinkaurelius.titan.core.SchemaViolationException;

public class CSVImporter
{
	private static final Logger logger = LoggerFactory
			.getLogger(CSVImporter.class);

	static final int NELEMS_PER_TRANSACTION = 100000;
	static final String KEY = "_key";

	String dbName;
	Graph graph;

	String[] VertexKeys;
	String[] EdgeKeys;

	boolean isNewDatabase;

	NodeFile nodeFile;
	EdgeFile edgeFile;

	int nElemsInTransaction = 0;

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
			possiblyFinishTransaction();
		}
	}

	private void importNodeRow(String[] row)
	{
		// skip empty lines
		if (row.length < 1)
			return;

		String command = row[0];
		String id = row[1];

		String[] keys = nodeFile.getKeys();

		if (command.equals(CSVCommands.ADD))
			addNodeToGraph(id, row, keys);
		else if (command.equals(CSVCommands.ADD_NO_REPLACE))
			addNodeToGraphNoReplace(id, row, keys);
	}

	private void possiblyFinishTransaction()
	{
		nElemsInTransaction++;
		if(nElemsInTransaction >= NELEMS_PER_TRANSACTION){
			graph.tx().commit();
			nElemsInTransaction = 0;
		}
	}

	private void addNodeToGraph(String id, String[] row, String[] keys)
	{
		try
		{
			doAddNodeToGraph(id, row, keys, 0);
		} catch (RuntimeException e)
		{
			logger.error(e.getMessage());
		}
	}

	private void doAddNodeToGraph(String baseId, String[] row, String[] keys, int num)
	{

		if (num == Constants.MAX_NODES_FOR_KEY)
			throw new RuntimeException("Too many nodes with the same key: " + baseId);

		// The first node gets the baseId, all others will
		// obtain an additional "_$number" and will be connected to
		// the last alternative.

		String completeId = createCompleteId(baseId, num);

		try
		{
			Vertex vertex = graph.addVertex(KEY, completeId);
			setPropertiesOnVertex(vertex, row, keys);

			if (num != 0)
			{
				linkToPreviousNode(baseId, num);
			}

		} catch (IllegalArgumentException e)
		{
			doAddNodeToGraph(baseId, row, keys, num + 1);
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

		Vertex fromNode = lookupVertex(previousId);
		Vertex toNode = lookupVertex(thisId);

		fromNode.addEdge("foo", toNode);
	}

	private void addNodeToGraphNoReplace(String id, String[] row, String[] keys)
	{
		String completeId = createCompleteId(id, 0);
		Vertex vertex;

		try{
			vertex = graph.addVertex(KEY, completeId);
		}catch(SchemaViolationException ex)
		{
			return;
		}

		setPropertiesOnVertex(vertex, row, keys);

	}

	private void setPropertiesOnVertex(Vertex vertex, String[] row, String[] keys)
	{
		for(int i = 2; i < row.length; i++) {
			if (!row[i].equals(""))
					vertex.property(keys[i - 1], row[i]);
		}
	}

	protected void importEdges() throws IOException
	{
		String [] row;

		while((row = edgeFile.getNextRow()) != null)
		{
			importEdgeRow(row);
			possiblyFinishTransaction();
		}
	}

	private void importEdgeRow(String[] row)
	{

		if (row.length < 3)
			return;

		String srcId = row[0];
		String dstId = row[1];
		String label = row[2];

		Vertex outVertex = lookupVertex(srcId);
		Vertex inVertex = lookupVertex(dstId);

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
			if (!row[i].equals(""))
				edge.property(edgeFile.getKeys()[i], row[i]);
		}

	}

	protected Vertex lookupVertex(String id)
	{
		return graph.traversal().V().has(KEY, id).next();
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
