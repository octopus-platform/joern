package orientdbimporter;

import java.util.LinkedList;
import java.util.List;

import com.orientechnologies.orient.core.metadata.schema.OType;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;
import com.tinkerpop.blueprints.impls.orient.OrientVertexType;

public class DatabaseInitializer {

	String[] vertexKeys;
	private OrientGraph tx;

	public void setVertexKeys(String [] vertexKeys)
	{
		this.vertexKeys = vertexKeys;
	}

	public void initialize(OrientGraph tx)
	{
		this.tx = tx;
		createNodeProperties();
		createIndices();
	}

	private void createNodeProperties()
	{
		OrientVertexType vType = tx.getVertexType("V");

		for (String key : getVertexKeys())
		{
			vType.createProperty(key, OType.STRING);
		}
	}

	private String [] getVertexKeys()
	{
		return vertexKeys;
	}

	private void createIndices()
	{
		OrientVertexType vType = tx.getVertexType("V");

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
