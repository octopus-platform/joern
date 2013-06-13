package output.neo4j.nodes;

import java.util.HashMap;
import java.util.Map;

import astnodes.declarations.ClassDefStatement;

public class ClassDefDatabaseNode extends DatabaseNode {

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
		map.put("type", "CLASS_DEF");
		map.put("name", name);
		return map;
	}

}
