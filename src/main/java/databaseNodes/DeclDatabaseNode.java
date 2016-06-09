package databaseNodes;

import java.util.HashMap;
import java.util.Map;

import ast.declarations.IdentifierDecl;

public class DeclDatabaseNode extends DatabaseNode
{

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
		map.put(NodeKeys.TYPE, "Decl");
		map.put(NodeKeys.BASE_TYPE, baseType);
		map.put(NodeKeys.COMPLETE_TYPE, completeType);
		map.put(NodeKeys.IDENTIFIER, identifierString);
		return map;
	}

}
