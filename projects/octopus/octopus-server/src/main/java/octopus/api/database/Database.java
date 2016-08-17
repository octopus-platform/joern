package octopus.api.database;

import org.apache.tinkerpop.gremlin.structure.Graph;

public interface Database {


	/**
	 * Return a tinkerpop3 graph instance
	 * */

	public Graph getGraph();

	public void closeInstance();

}
