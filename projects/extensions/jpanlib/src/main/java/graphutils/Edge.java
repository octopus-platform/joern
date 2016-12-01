package graphutils;

import java.util.Map;

public class Edge<V>
{

	private V destination;
	private V source;

	public Edge(V source, V destination)
	{
		this.source = source;
		this.destination = destination;
	}

	public V getDestination()
	{
		return this.destination;
	}

	public V getSource()
	{
		return this.source;
	}

	public Map<String, Object> getProperties()
	{
		return null;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (!(obj instanceof Edge))
		{
			return false;
		}
		Edge<?> other = (Edge<?>) obj;
		if (destination == null)
		{
			if (other.destination != null)
			{
				return false;
			}
		}
		else if (!destination.equals(other.destination))
		{
			return false;
		}
		if (source == null)
		{
			if (other.source != null)
			{
				return false;
			}
		}
		else if (!source.equals(other.source))
		{
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		return getSource() + " ====> " + getDestination();
	}

	public Edge<V> reverse()
	{
		return new Edge<V>(getDestination(), getSource());
	}

}
