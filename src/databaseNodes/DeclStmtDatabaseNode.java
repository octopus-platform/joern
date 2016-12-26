package databaseNodes;

import java.util.HashMap;
import java.util.Map;

import ast.statements.IdentifierDeclStatement;

public class DeclStmtDatabaseNode extends DatabaseNode
{

	String typeStr;
	String idStr;

	@Override
	public void initialize(Object obj)
	{
		IdentifierDeclStatement stmt = (IdentifierDeclStatement) obj;
		typeStr = stmt.getTypeAsString();

	}

	@Override
	public Map<String, Object> createProperties()
	{
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put(NodeKeys.TYPE, "DeclStmt");
		return map;
	}

}
