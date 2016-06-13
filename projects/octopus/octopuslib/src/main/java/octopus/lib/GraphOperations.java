package octopus.lib;

import java.util.Map;
import java.util.Map.Entry;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;

import octopus.lib.structures.Node;

public class GraphOperations
{

	/**
	 * Add an edge from the node src to the node dst if it does
	 * not already exist.
	 *
	 * @param src the source of the edge
	 * @param dst the destination of the edge
	 */
	public static void addEdge(Graph graph, Node src, Node dst, String edgeType)
	{
		for (Edge edge : src.getNode().getEdges(Direction.OUT,
				edgeType))
		{
			if (edge.getVertex(Direction.IN).equals(dst.getNode()))
			{
				return;
			}
		}
		graph.addEdge(0, src.getNode(), dst.getNode(), edgeType);
	}

	public static Vertex addNode(Graph graph, Map<String, String> properties)
	{
		Vertex newVertex = graph.addVertex(0);

		for (Entry<String, String> entrySet : properties.entrySet())
		{
			newVertex.setProperty(entrySet.getKey(), entrySet.getValue());
		}
		return newVertex;
	}

}
