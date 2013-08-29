package output.neo4j;

import org.neo4j.unsafe.batchinsert.BatchRelationship;

public class QueryUtils {

	public static boolean isASTEdge(BatchRelationship rel)
	{	
		// there's probably a more efficient way of doing this
		return rel.getType().name().equals(EdgeTypes.IS_AST_PARENT);
	}

	public static boolean isIncomingEdge(Long nodeId, BatchRelationship rel)
	{
		return rel.getEndNode() == nodeId;
	}
	
	
	public static Iterable<BatchRelationship> getEdges(Long nodeId)
	{
		return Neo4JBatchInserter.getRelationships(nodeId);
	}

	public static String getNodeType(Long nodeId)
	{
		return (String) Neo4JBatchInserter.getNodeProperties(nodeId).get("type");
	}

	public static String getChildNumber(BatchRelationship rel)
	{
		return (String) Neo4JBatchInserter.getRelationshipProperties(rel.getId()).get("n");
	}

	public static String getNodeCode(Long nodeId)
	{
		return (String) Neo4JBatchInserter.getNodeProperties(nodeId).get("code");
	}
	
	public static long getASTForBasicBlock(Long basicBlockId)
	{
		return getFirstChildWithEdgeType(basicBlockId, EdgeTypes.IS_BASIC_BLOCK_OF);		
	}
	
	// this is the same as 'getASTRoot' except for the edge type
	private static long getFirstChildWithEdgeType(Long nodeId, String edgeType)
	{
		Iterable<BatchRelationship> rels = getEdges(nodeId);
		for(BatchRelationship rel : rels){
			if(rel.getType().name().equals(edgeType))
						return rel.getEndNode();		
		}		
		return -1;
	}

	public static long getCFGFromFunction(Long funcId)
	{
		return getFirstChildWithEdgeType(funcId, EdgeTypes.IS_FUNCTION_OF_CFG);
	}
	
}
