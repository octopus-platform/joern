package octopus.server.importer.graphstream.titan;

import java.io.IOException;
import java.lang.reflect.Array;

import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.apache.tinkerpop.gremlin.structure.VertexProperty;
import org.graphstream.stream.SinkAdapter;
import org.graphstream.stream.file.FileSource;
import org.graphstream.stream.file.FileSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GraphstreamImporter extends SinkAdapter {

	static final int NELEMS_PER_TRANSACTION = 100000;
	static final String KEY = "_key";

	Graph graph;
	int transaction_element_count = 0;

	private static final Logger logger = LoggerFactory
			.getLogger(GraphstreamImporter.class);

	public void importGraphstreamFiles(String streamFilename)
			throws IOException
	{
		FileSource fs = FileSourceFactory.sourceFor(streamFilename);
		fs.addSink(this);
		try {
			fs.readAll(streamFilename);
		} catch (IOException e) {
			// ...
		} finally {
			fs.removeSink(this);
			flushTransactionsForced();
		}

		closeDatabase();
	}

	public void setGraph(Graph graph)
	{
		this.graph = graph;
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

	public void flushTransactionsForced() {
	    flushTransactions(true);
    }

	public void flushTransactions(boolean force) {
		transaction_element_count++;
		if ( (transaction_element_count > NELEMS_PER_TRANSACTION) || force) {
			graph.tx().commit();
            transaction_element_count = 0;
		}
	}

	@Override
	public void edgeAttributeAdded(String sourceId, long timeId, String edgeId,
			String attribute, Object value) {
		logger.warn("edgeAttributeAdded not implemented");
	}

	@Override
	public void edgeAttributeChanged(String sourceId, long timeId,
			String edgeId, String attribute, Object oldValue, Object newValue) {
		logger.warn("edgeAttributeChanged not implemented");
	}

	@Override
	public void edgeAttributeRemoved(String sourceId, long timeId,
			String edgeId, String attribute) {
		logger.warn("edgeAttributeRemoved not implemented");
	}

	@Override
	public void graphAttributeAdded(String sourceId, long timeId,
			String attribute, Object value) {
		logger.warn("graphAttributeAdded not implemented");
	}

	@Override
	public void graphAttributeChanged(String sourceId, long timeId,
			String attribute, Object oldValue, Object newValue) {
		logger.warn("graphAttributeChanged not implemented");
	}

	@Override
	public void graphAttributeRemoved(String sourceId, long timeId,
			String attribute) {
		logger.warn("graphAttributeRemoved not implemented");
	}

	@Override
	public void nodeAttributeAdded(String sourceId, long timeId, String nodeId,
			String attribute, Object value) {
        nodeAttributeChanged(sourceId,timeId,nodeId,attribute,null,value);
	}

	protected static String arraystring(Object value) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i< Array.getLength(value); i++) {
			if (i!=0) {
				sb.append(",");
			}
			sb.append(String.format(String.valueOf(Array.get(value,i))));
		}
		return sb.toString();
	}

	protected Vertex findVertexWithKey(String key) {
		GraphTraversalSource g = graph.traversal();
		GraphTraversal traversal = g.V().has(KEY,key);
        if (traversal.hasNext()) {
			return (Vertex) traversal.next();
		}
		return null;
	}

	@Override
	public void nodeAttributeChanged(String sourceId, long timeId,
			String nodeId, String attribute, Object oldValue, Object newValue) {
        Vertex v = findVertexWithKey(nodeId);
		if (v != null) {
            if (newValue.getClass().isArray()) {
            	// Cardinality.list is not supported by default in TitanDB, but we can always try
                try {
					v.property(VertexProperty.Cardinality.list, attribute, newValue);
				} catch (com.thinkaurelius.titan.core.SchemaViolationException e) {
					logger.warn("nodeAttributeChanged on node {}: list properties are not supported.", nodeId);
				}
			} else {
				v.property(attribute, newValue);
			}
		} else {
			logger.error("nodeAttributeChanged: could not find node {}", nodeId);
		}
	}

	@Override
	public void nodeAttributeRemoved(String sourceId, long timeId,
			String nodeId, String attribute) {
		logger.warn("nodeAttributeRemoved not implemented");
	}

	@Override
	public void edgeAdded(String sourceId, long timeId, String edgeId,
			String fromNodeId, String toNodeId, boolean directed) {
		logger.warn("edgeAdded not implemented");
	}

	@Override
	public void edgeRemoved(String sourceId, long timeId, String edgeId) {
		logger.warn("edgeRemoved not implemented");
	}

	@Override
	public void graphCleared(String sourceId, long timeId) {
		logger.warn("graphCleared not implemented");
	}

	@Override
	public void nodeAdded(String sourceId, long timeId, String nodeId) {
		Vertex vertex = graph.addVertex(KEY, nodeId);
	}

	@Override
	public void nodeRemoved(String sourceId, long timeId, String nodeId) {
		logger.warn("nodeRemoved not implemented");
	}

	@Override
	public void stepBegins(String sourceId, long timeId, double step) {
		logger.warn("stepBegins not implemented");
	}
}
