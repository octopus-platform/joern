package neo4j.nodes;

import java.util.Map;

public abstract class DatabaseNode
{

	abstract public void initialize(Object obj);

	abstract public Map<String, Object> createProperties();
}
