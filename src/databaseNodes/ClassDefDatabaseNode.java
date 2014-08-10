package databaseNodes;

import java.util.HashMap;
import java.util.Map;

import ast.declarations.ClassDefStatement;

public class ClassDefDatabaseNode extends DatabaseNode
{

	String name;
	ClassDefStatement stmt;

	@Override
	public void initialize(Object obj)
	{
		stmt = (ClassDefStatement) obj;
		name = stmt.name.getEscapedCodeStr();
	}

	@Override
	public Map<String, Object> createProperties()
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(NodeKeys.TYPE, "Class");
		map.put(NodeKeys.NAME, name);
		map.put(NodeKeys.LOCATION, stmt.getLocationString());
		return map;
	}

}
