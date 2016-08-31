package octopus.server.database.titan;

import org.apache.commons.configuration.Configuration;
import org.apache.tinkerpop.gremlin.structure.Graph;

import octopus.api.database.Database;

public class TitanLocalDatabase implements Database {

	private Graph graph;

	@Override
	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph graph)
	{
		this.graph = graph;
	}

	public String getPathToDatabase()
	{
		Configuration conf = graph.configuration();
		return conf.getString("storage.directory");
	}

	public String getPathToIndex()
	{
		Configuration conf = graph.configuration();
		return conf.getString("index.search.directory");
	}

	@Override
	public void closeInstance()
	{
		try {
			graph.close();
		} catch (Exception e) {
			throw new RuntimeException("Error closing database instance");
		}
	}

}
