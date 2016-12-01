package octopus.api;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.tinkerpop.gremlin.structure.Direction;
import org.apache.tinkerpop.gremlin.structure.Edge;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.Vertex;

import octopus.api.structures.OctopusNode;

public class GraphOperations
{

	/**
	 * Add an edge from the node src to the node dst if it does
	 * not already exist.
	 *
	 * @param src the source of the edge
	 * @param dst the destination of the edge
	 */
	public static void addEdge(Graph graph, OctopusNode src, OctopusNode dst, String edgeType)
	{
		Iterator<Edge> it = src.edges(Direction.OUT, edgeType);

		while(it.hasNext()){
			Edge edge = it.next();

			if (edge.inVertex().equals(dst))
			{
				return;
			}

		}

		src.addEdge(edgeType, dst);
	}

	public static Vertex addNode(Graph graph, Map<String, String> properties)
	{
		Vertex newVertex = graph.addVertex(0);

		for (Entry<String, String> entrySet : properties.entrySet())
		{
			newVertex.property(entrySet.getKey(), entrySet.getValue());
		}
		return newVertex;
	}

}
