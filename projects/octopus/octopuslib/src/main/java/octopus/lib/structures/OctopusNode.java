package octopus.lib.structures;

import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.util.wrappers.wrapped.WrappedVertex;

public class OctopusNode extends WrappedVertex
{

	public OctopusNode(Vertex vertex)
	{
		super(vertex);
		if (vertex == null)
		{
			throw new IllegalArgumentException("OctopusNode must not be null.");
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

	@Override
	public String toString()
	{
		String delimiter = ", ";
		StringBuilder builder = new StringBuilder();
		builder.append(getProperty(OctopusNodeProperties.TYPE) + "(");
		for (String property : getPropertyKeys())
		{
			builder.append(property + ":" + getProperty(property));
			builder.append(delimiter);
		}
		builder.setLength(builder.length() - delimiter.length());
		builder.append(")");
		return builder.toString();
	}
}
