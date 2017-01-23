package octopus.server.importer.graphstream.titan;

import java.io.IOException;

import org.apache.tinkerpop.gremlin.structure.Edge;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.graphstream.stream.SinkAdapter;
import org.graphstream.stream.file.FileSource;
import org.graphstream.stream.file.FileSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GraphstreamImporter extends SinkAdapter {

	static final String KEY = "_key";

	Graph graph;

	private static final Logger logger = LoggerFactory
			.getLogger(GraphstreamImporter.class);

	public void importGraphstreamFiles(String streamFilename)
			throws IOException
	{
		// create graphstream sink (implement one that adds elements to octopus)
		// create a file source
		FileSource fs = FileSourceFactory.sourceFor(streamFilename);
		// connect the two
		fs.addSink(this);
		try {
			fs.readAll(streamFilename);
		} catch (IOException e) {
			// ...
		} finally {
			fs.removeSink(this);
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

	@Override
	public void edgeAttributeAdded(String sourceId, long timeId, String edgeId,
			String attribute, Object value) {
		logger.warn("DGS: edgeAttributeAdded");
	}

	@Override
	public void edgeAttributeChanged(String sourceId, long timeId,
			String edgeId, String attribute, Object oldValue, Object newValue) {
		logger.warn("DGS: edgeAttributeChanged");
	}

	@Override
	public void edgeAttributeRemoved(String sourceId, long timeId,
			String edgeId, String attribute) {
		logger.warn("DGS: edgeAttributeRemoved");
	}

	@Override
	public void graphAttributeAdded(String sourceId, long timeId,
			String attribute, Object value) {
		logger.warn("DGS: graphAttributeAdded");
	}

	@Override
	public void graphAttributeChanged(String sourceId, long timeId,
			String attribute, Object oldValue, Object newValue) {
		logger.warn("DGS: graphAttributeChanged");
	}

	@Override
	public void graphAttributeRemoved(String sourceId, long timeId,
			String attribute) {
		logger.warn("DGS: graphAttributeRemoved");
	}

	@Override
	public void nodeAttributeAdded(String sourceId, long timeId, String nodeId,
			String attribute, Object value) {
		logger.warn(String.format("DGS: add node attribute nodeid=%s attribute=%s",nodeId,attribute));
		// logger.warn((String) value);
		// vertex.property(keys[i - 1], row[i]);
	}

	@Override
	public void nodeAttributeChanged(String sourceId, long timeId,
			String nodeId, String attribute, Object oldValue, Object newValue) {
		logger.warn("DGS: nodeAttributeChanged");
	}

	@Override
	public void nodeAttributeRemoved(String sourceId, long timeId,
			String nodeId, String attribute) {
		logger.warn("DGS: nodeAttributeRemoved");
	}

	@Override
	public void edgeAdded(String sourceId, long timeId, String edgeId,
			String fromNodeId, String toNodeId, boolean directed) {
		logger.warn("DGS: edgeAdded");
	}

	@Override
	public void edgeRemoved(String sourceId, long timeId, String edgeId) {
		logger.warn("DGS: edgeRemoved");
	}

	@Override
	public void graphCleared(String sourceId, long timeId) {
		logger.warn("DGS: graphCleared");
	}

	@Override
	public void nodeAdded(String sourceId, long timeId, String nodeId) {
	    logger.warn(String.format("DGS: add node %s from source %s",nodeId,sourceId));
		// Vertex vertex = graph.addVertex(KEY, nodeId);
	}

	@Override
	public void nodeRemoved(String sourceId, long timeId, String nodeId) {
		logger.warn(String.format("DGS: nodeRemoved(%s,...,%s)",sourceId,nodeId));
	}

	@Override
	public void stepBegins(String sourceId, long timeId, double step) {
		logger.warn("DGS: stepBegins");
	}
}
