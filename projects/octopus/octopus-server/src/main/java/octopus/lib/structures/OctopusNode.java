package octopus.lib.structures;

import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.util.wrappers.wrapped.WrappedElement;

public abstract class OctopusNode extends WrappedElement implements Vertex
{

	public OctopusNode(Vertex vertex)
	{
		super(vertex);
		if (vertex == null)
		{
			throw new IllegalArgumentException("vertex must not be null.");
		}
	}

	public OctopusNode(Vertex vertex, String nodeType)
	{
		this(vertex);
		if (!vertex.getProperty(OctopusNodeProperties.TYPE).equals(nodeType))
		{
			throw new IllegalArgumentException("Invalid node. Expected a node of type " + nodeType + " was " + vertex
					.getProperty(OctopusNodeProperties.TYPE));
		}
	}

	public Vertex getBaseVertex()
	{
		return (Vertex) getBaseElement();
	}
}
