package orientdbimporter.processors;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.opencsv.CSVReader;
import com.orientechnologies.orient.core.metadata.schema.OType;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientVertexType;
import com.tinkerpop.blueprints.util.wrappers.batch.BatchGraph;

import orientdbimporter.CSVCommands;
import orientdbimporter.CSVImporter;
import orientdbimporter.Constants;

public class NodeProcessor extends CSVFileProcessor
{

	public NodeProcessor(CSVImporter importer)
	{
		super(importer);
	}

	@Override
	protected void processFirstRow(CSVReader csvReader, String[] row)
			throws IOException
	{

		initializeVertexKeys(row);
		createPropertiesAndIndices();

	}

	private void initializeVertexKeys(String[] row)
	{
		String[] keys = rowToKeys(row);
		// remove first key, it's the command
		keys = Arrays.copyOfRange(keys, 1, keys.length);

		importer.setVertexKeys(keys);
	}

	private void createPropertiesAndIndices()
	{

		if (!importer.isNewDatabase())
			return;

		OrientVertexType vType = importer.getNoTx().getVertexType("V");


		for (String key : importer.getVertexKeys())
		{
			vType.createProperty(key, OType.STRING);
		}

		List<String> keysToIndex = new LinkedList<String>();
		for (String key : importer.getVertexKeys())
		{
			keysToIndex.add(key);
		}

		String[] indexKeys = new String[keysToIndex.size()];
		keysToIndex.sort(null);
		keysToIndex.toArray(indexKeys);

		vType.createIndex("nodeIndex.", "FULLTEXT", null, null, "LUCENE",
				indexKeys);
	}

	@Override
	protected void processRow(String[] row)
	{
		// skip empty lines
		if (row.length < 1)
			return;

		String command = row[0];
		String id = row[1];

		// TODO: handling of different commands

		String[] properties = new String[2 * (row.length -1)];
		for (int i = 1; i < row.length; i++)
		{
			// We subtract 1 here when accessing vertex keys because
			// the first key (command) is discarded.
			properties[2 *(i-1)] = importer.getVertexKeys()[i - 1];
			properties[2 *(i-1) + 1] = row[i];
		}
		Object[] props = properties;

		if(command.equals(CSVCommands.ADD))
			addNodeToGraph(id, props);
		else if(command.equals(CSVCommands.ADD_NO_REPLACE))
			addNodeToGraphNoReplace(id, props);

	}

	private void addNodeToGraph(String id, Object[] props)
	{
		doAddNodeToGraph(id, props, 0);
	}

	private void doAddNodeToGraph(String baseId, Object[] props, int num)
	{
		BatchGraph<?> batchGraph = (BatchGraph<?>) importer.getGraph();

		if(num == Constants.MAX_NODES_FOR_KEY)
			throw new RuntimeException("Too many nodes with the same key: " + baseId);

		// The first node gets the baseId, all others will
		// obtain an additional "_$number" and will be connected to
		// the last alternative.

		String completeId = createCompleteId(baseId, num);

		try {
			batchGraph.addVertex(completeId, props);

			if(num != 0){
				linkToPreviousNode(baseId, num);
			}

		} catch (IllegalArgumentException e) {
			doAddNodeToGraph(baseId, props, num + 1);
		}
	}

	private String createCompleteId(String baseId, int num)
	{
		String completeId;
		if(num == 0)
			completeId = baseId;
		else
			completeId = String.format("%s_%d", baseId, num);
		return completeId;
	}

	private void linkToPreviousNode(String baseId, int num)
	{
		String previousId = createCompleteId(baseId, num -1);
		String thisId = createCompleteId(baseId, num);

		Graph graph = importer.getGraph();

		Vertex fromNode = graph.getVertex(previousId);
		Vertex toNode = graph.getVertex(thisId);

		graph.addEdge(0, fromNode, toNode, "foo");
	}

	private void addNodeToGraphNoReplace(String id, Object[] props)
	{
		String completeId = createCompleteId(id, 0);
		BatchGraph<?> batchGraph = (BatchGraph<?>) importer.getGraph();

		try{
			batchGraph.addVertex(completeId, props);
		}catch (IllegalArgumentException e) {
			return;
		}
	}

}
