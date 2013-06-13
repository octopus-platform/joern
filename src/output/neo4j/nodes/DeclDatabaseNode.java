package output.neo4j.nodes;

import java.util.HashMap;
import java.util.Map;

import astnodes.declarations.IdentifierDecl;

public class DeclDatabaseNode extends DatabaseNode {

	IdentifierDecl decl;
	String baseType;
	String completeType;
	String identifierString;
	
	@Override
	public void initialize(Object obj)
	{	
		decl = (IdentifierDecl) obj;
		baseType = decl.getType().baseType;
		completeType = decl.getType().completeType;
		identifierString = decl.getName().getEscapedCodeStr();
	}

	@Override
	public Map<String, Object> createProperties()
	{
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("type", "DECL");
		map.put("baseType", baseType);
		map.put("completeType", completeType);
		map.put("identifier", identifierString);
		return map;
	}

}
