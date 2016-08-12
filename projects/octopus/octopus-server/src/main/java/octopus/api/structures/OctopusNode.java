package octopus.api.structures;

import org.apache.tinkerpop.gremlin.structure.Vertex;

public abstract class OctopusNode implements Vertex
{

	public OctopusNode(Vertex vertex)
	{
		if (vertex == null)
		{
			throw new IllegalArgumentException("vertex must not be null.");
		}
	}

	public OctopusNode(Vertex vertex, String nodeType)
	{
		this(vertex);

		if (!vertex.value(OctopusNodeProperties.TYPE).equals(nodeType))
		{
			throw new IllegalArgumentException("Invalid node. Expected a node of type " + nodeType + " was " + vertex
					.value(OctopusNodeProperties.TYPE));
		}
	}


}
