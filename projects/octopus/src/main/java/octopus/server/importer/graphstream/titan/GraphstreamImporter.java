package octopus.server.importer.graphstream.titan;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Iterator;

import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal;
import org.apache.tinkerpop.gremlin.structure.*;
import org.graphstream.stream.SinkAdapter;
import org.graphstream.stream.file.FileSource;
import org.graphstream.stream.file.FileSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GraphstreamImporter extends SinkAdapter {

	static final int NELEMS_PER_TRANSACTION = 100000;
	static final String KEY = "_key";

	class EdgeInfoFormatException extends Exception {
	}

	class EdgeInfoNodeNotFoundException extends Exception {
	}

	class EdgeInfo {
		private String label;
		private String fromNodeId;
		private String toNodeId;
        static final String SEPARATOR = ":";

		public EdgeInfo(String edgeId) throws EdgeInfoFormatException {
			try {
				String[] parts = edgeId.split(SEPARATOR, 3);
				label = parts[0];
				fromNodeId = parts[1];
				toNodeId = parts[2];
			} catch (ArrayIndexOutOfBoundsException e) {
				throw new EdgeInfoFormatException();
			}
		}

		public String getLabel() {
			return label;
		}

		public String getFromNodeId() {
			return fromNodeId;
		}

		public String getToNodeId() {
			return toNodeId;
		}
	}

	class GraphEdgeNotFoundException extends Exception {
	}

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

	protected Vertex findVertexWithKey(String key) {
	    GraphTraversal traversal = graph.traversal().V().has(KEY,key);
        if (traversal.hasNext()) {
        	return (Vertex) traversal.next();
		}
		return null;
	}

	protected Vertex getEdgeVertexFrom(EdgeInfo edge_info) throws EdgeInfoNodeNotFoundException {
		Vertex fromVertex = findVertexWithKey(edge_info.getFromNodeId());
		if (fromVertex == null) {
			throw new EdgeInfoNodeNotFoundException();
		}
		return fromVertex;
	}

	protected Vertex getEdgeVertexTo(EdgeInfo edge_info) throws EdgeInfoNodeNotFoundException {
		Vertex toVertex = findVertexWithKey(edge_info.getToNodeId());
		if (toVertex == null) {
			throw new EdgeInfoNodeNotFoundException();
		}
		return toVertex;
	}

	protected Edge findEdge(EdgeInfo edge_info) throws EdgeInfoNodeNotFoundException, GraphEdgeNotFoundException {
	    Vertex fromVertex = getEdgeVertexFrom(edge_info);
		Vertex toVertex = getEdgeVertexTo(edge_info);
        Iterator<Edge> edges = fromVertex.edges(Direction.OUT, edge_info.getLabel());
		Edge edge_found = null;
		while (edges.hasNext()) {
			Edge edge = edges.next();
			if (edge.inVertex() == toVertex) {
				edge_found = edge;
				break;
			}
		}
		if (edge_found == null) {
			throw new GraphEdgeNotFoundException();
		}
		return edge_found;
	}

	@Override
	public void edgeAttributeAdded(String sourceId, long timeId, String edgeId,
			String attribute, Object value) {
		logger.warn("edgeAttributeAdded not implemented");
	}

	@Override
	public void edgeAttributeChanged(String sourceId, long timeId,
			String edgeId, String attribute, Object oldValue, Object newValue) {
		try {
			EdgeInfo edge_info = new EdgeInfo(edgeId);
            Edge edge = findEdge(edge_info);
            edge.property(attribute,newValue);
		} catch (EdgeInfoFormatException e) {
			logger.error("edgeAttributeChanged: invalid edge-id format {}", edgeId);
		} catch (EdgeInfoNodeNotFoundException e) {
			logger.error("edgeAttributeChanged: could not find source node for {}", edgeId);
		} catch (GraphEdgeNotFoundException e) {
			logger.error("edgeAttributeChanged: could not find edge {}", edgeId);
		} catch (java.lang.IllegalArgumentException e) {
		    // only simple values are allowed as edge attributes
			logger.error("edgeAttributeChanged: could not add value {}", newValue.toString());
		}
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
					logger.error("nodeAttributeChanged on node {}: list properties are not supported.", nodeId);
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
        Vertex fromVertex = findVertexWithKey(fromNodeId);
		Vertex toVertex = findVertexWithKey(toNodeId);
		// the nodes need to have been defined and created before we can add the edge
		if (fromVertex == null) {
			logger.error("edgeAdded: could not find source node {}", fromNodeId);
		}
		if (toVertex == null) {
			logger.error("edgeAdded: could not find destination node {}", toNodeId);
		}
		if ((fromVertex != null) && (toVertex != null)) {
			// we assume edgeId has a certain format, so that we do not have to defer
			// the creation of edges to the end of the file.
			try {
				EdgeInfo edge_info = new EdgeInfo(edgeId);
				fromVertex.addEdge(edge_info.getLabel(), toVertex);
			} catch (EdgeInfoFormatException e) {
				logger.error("edgeAdded: invalid edge-id format {}", edgeId);
			}
		}
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
