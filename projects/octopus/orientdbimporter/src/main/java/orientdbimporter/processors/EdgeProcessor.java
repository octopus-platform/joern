package orientdbimporter.processors;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opencsv.CSVReader;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;

import orientdbimporter.CSVImporter;

public class EdgeProcessor extends CSVFileProcessor
{
	private static final Logger logger = LoggerFactory
			.getLogger(EdgeProcessor.class);

	public EdgeProcessor(CSVImporter importer)
	{
		super(importer);
	}

	@Override
	protected void processFirstRow(CSVReader csvReader, String[] row)
			throws IOException
	{
		initializeEdgeKeys(row);
	}

	private void initializeEdgeKeys(String[] row)
	{
		String[] keys = rowToKeys(row);
		importer.setEdgeKeys(keys);
	}

	@Override
	protected void processRow(String[] row)
	{
		if (row.length < 3)
			return;

		String srcId = row[0];
		String dstId = row[1];
		String label = row[2];

		Graph graph = importer.getGraph();

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
			edge.setProperty(importer.getEdgeKeys()[i], row[i]);
		}
	}

	protected Vertex lookupVertex(String id, Graph batchGraph)
	{
		return batchGraph.getVertex(id);
	}

}
