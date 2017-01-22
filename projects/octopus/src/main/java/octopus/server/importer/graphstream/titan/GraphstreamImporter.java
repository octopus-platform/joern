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

}
