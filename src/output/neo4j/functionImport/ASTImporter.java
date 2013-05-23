package output.neo4j.functionImport;

import java.util.HashMap;
import java.util.Map;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;

import output.neo4j.EdgeTypes;
import output.neo4j.GraphNodeStore;
import output.neo4j.Neo4JDatabase;
import output.neo4j.nodes.ASTDatabaseNode;

import astnodes.ASTNode;

public class ASTImporter
{
	GraphNodeStore nodeStore;
	
	public ASTImporter(GraphNodeStore aNodeStore)
	{
		nodeStore = aNodeStore;
	}
	
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
			addASTLink(node, child);
		}
	}

	private void addASTNode(ASTNode node)
	{
		ASTDatabaseNode astDatabaseNode = new ASTDatabaseNode();
		astDatabaseNode.initialize(node);
		Map<String, Object> properties = astDatabaseNode.createProperties();
		nodeStore.addNeo4jNode(node, properties);
		
		indexASTNode(node, properties);
	
	}

	private void indexASTNode(ASTNode node, Map<String, Object> properties)
	{
		// index, but do not index code
		properties.remove("code");
		nodeStore.indexNode(node, properties);
	}

	private void addASTLink(Object parent, ASTNode child)
	{
		RelationshipType rel = DynamicRelationshipType.withName(EdgeTypes.IS_AST_PARENT);
		Map<String, Object> properties = new HashMap<String, Object>();
		String childStr = new Integer(child.getChildNumber()).toString();
		properties.put("n", childStr);
		
		long parentId = nodeStore.getIdForObject(parent);
		long childId = nodeStore.getIdForObject(child);
		Neo4JDatabase.addRelationship(parentId, childId, rel, properties);
	}
}
