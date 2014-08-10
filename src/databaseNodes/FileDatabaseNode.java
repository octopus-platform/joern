package databaseNodes;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class FileDatabaseNode extends DatabaseNode
{

	long neo4jId = -1;
	private String pathString;
	private String type;

	public void setType(String aType)
	{
		type = aType;
	}

	public void setId(long anId)
	{
		neo4jId = anId;
	}

	public long getId()
	{
		return neo4jId;
	}

	@Override
	public void initialize(Object obj)
	{
		Path path = (Path) obj;
		pathString = path.toString();
	}

	@Override
	public Map<String, Object> createProperties()
	{
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put(NodeKeys.TYPE, type);
		properties.put(NodeKeys.FILEPATH, pathString);
		return properties;
	}

}
