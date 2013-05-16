package output.neo4j;

import java.util.HashMap;
import java.util.Map;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;

import astnodes.ASTNode;

public class ASTImporter
{
	GraphNodeStore nodeStore = new GraphNodeStore();
	
	public void addASTToDatabase(ASTNode node)
	{
		addASTNode(node);
		addASTChildren(node);
	}

	private void addASTChildren(ASTNode node)
	{
		final int nChildren = node.getChildCount();
		
		// HACK: not sure why, but adding AST-links backwards
		// results in the edges being returned in the
		// correct order by the database.
		
		for(int i = nChildren -1; i >=0; i--){
			ASTNode child = node.getChild(i);
			addASTToDatabase(child);
			addASTLink(node.id, child.id, child);
		}
	}

	private void addASTNode(ASTNode node)
	{
		Map<String, Object> properties = createPropertiesForASTNode(node);
		long thisId = nodeStore.addNeo4jNode(node, properties);
		node.id = thisId;
	
		indexASTNode(properties, thisId);
	
	}

	private Map<String, Object> createPropertiesForASTNode(ASTNode node)
	{
		Map<String, Object> properties = new HashMap<String, Object>();
		String typeString = node.getTypeAsString();
		properties.put("type", typeString);
		properties.put("code", node.getEscapedCodeStr());
		return properties;
	}
	
	private void indexASTNode(Map<String, Object> properties, long thisId)
	{
		// index, but do not index code
		properties.remove("code");
		nodeStore.indexNode(thisId, properties);
	}

	private void addASTLink(long srcId, long dstId, ASTNode child)
	{
		RelationshipType rel = DynamicRelationshipType.withName(EdgeTypes.IS_AST_PARENT);
		Map<String, Object> properties = new HashMap<String, Object>();
		String childStr = new Integer(child.getChildNumber()).toString();
		properties.put("n", childStr);
		
		Neo4JDatabase.addRelationship(srcId, dstId, rel, properties);
	}
}
