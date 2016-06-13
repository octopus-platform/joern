package octopus.lib.structures;

import com.tinkerpop.blueprints.Vertex;

public class Node
{
	private final Vertex node;

	public Node(Vertex vertex)
	{
		if (vertex == null)
		{
			throw new IllegalArgumentException("Node must not be null.");
		}
		node = vertex;
	}

	public Node(Vertex vertex, String nodeType)
	{
		if (!vertex.getProperty(OctopusNodeProperties.TYPE).equals(nodeType))
		{
			throw new IllegalArgumentException("Invalid node. Expected a node of type " + nodeType + " was " + vertex
					.getProperty(OctopusNodeProperties.TYPE));
		}
		node = vertex;
	}

	public Vertex getNode()
	{
		return node;
	}

	public long getId()
	{
		return Long.parseLong(getNode().getId().toString().split(":")[1]);
	}

	@Override
	public boolean equals(Object o)
	{
		if (!(o instanceof Node))
		{
			return false;
		}

		Node other = (Node) o;
		return getNode().getId().equals(other.getNode().getId());
	}

	@Override
	public int hashCode()
	{
		return node != null ? node.hashCode() : 0;
	}

	@Override
	public String toString()
	{
		String delimiter = ", ";
		StringBuilder builder = new StringBuilder();
		builder.append(getNode().getProperty(OctopusNodeProperties.TYPE) + "(");
		for (String property : getNode().getPropertyKeys())
		{
			builder.append(property + ":" + getNode().getProperty(property));
			builder.append(delimiter);
		}
		builder.setLength(builder.length() - delimiter.length());
		builder.append(")");
		return builder.toString();
	}
}
