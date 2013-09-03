package output.neo4j;

import java.util.LinkedList;
import java.util.List;

import org.neo4j.graphdb.index.IndexHits;
import org.neo4j.unsafe.batchinsert.BatchRelationship;

public class QueryUtils {

	public static boolean isASTEdge(BatchRelationship rel)
	{	
		// there's probably a more efficient way of doing this
		return rel.getType().name().equals(EdgeTypes.IS_AST_PARENT);
	}

	public static boolean isCFGEdge(BatchRelationship rel)
	{
		return rel.getType().name().equals(EdgeTypes.FLOWS_TO);
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
		long cfgNodeId = getFirstChildWithEdgeType(funcId, EdgeTypes.IS_FUNCTION_OF_CFG);
		return getFirstChildWithEdgeType(cfgNodeId, EdgeTypes.IS_CFG_OF_CFG_ROOT);
	}

	public static List<String> getSymbolsUsedByBasicBlock(long nodeId)
	{
		return getCodeOfChildrenConnectedBy(nodeId, EdgeTypes.USE);
	}

	public static List<String> getSymbolsDefinedByBasicBlock(long nodeId)
	{
		return getCodeOfChildrenConnectedBy(nodeId, EdgeTypes.DEF);
	}
	
	private static List<String> getCodeOfChildrenConnectedBy(long nodeId, String edgeType)
	{
		List<String> retval = new LinkedList<String>();
		
		Iterable<BatchRelationship> rels = getEdges(nodeId);
		for(BatchRelationship rel : rels){
			if(!rel.getType().name().equals(edgeType)) continue;
		
			String identifierStr = getNodeCode(rel.getEndNode());			
			retval.add(identifierStr);
		}
		
		return retval;
	}

	public static IndexHits<Long> getBasicBlocksFromIndex(long functionId)
	{		
		String query = "type:\"BasicBlock\" AND functionId:\"" + functionId + "\"";
		return Neo4JBatchInserter.queryIndex(query);
	}

	public static List<Long> getParentBasicBlocks(Long basicBlock)
	{
		List<Long> retval = new LinkedList<Long>();
		Iterable<BatchRelationship> rels = getEdges(basicBlock);
		for(BatchRelationship rel : rels){
			if(!rel.getType().name().equals(EdgeTypes.FLOWS_TO)) continue;
			if(rel.getStartNode() == basicBlock) continue;
			retval.add(rel.getStartNode());		
		}
		return retval;
	}

	public static List<Long> getChildBasicBlocks(Long basicBlock)
	{
		List<Long> retval = new LinkedList<Long>();
		Iterable<BatchRelationship> rels = getEdges(basicBlock);
		for(BatchRelationship rel : rels){
			if(!rel.getType().name().equals(EdgeTypes.FLOWS_TO)) continue;
			if(rel.getEndNode() == basicBlock) continue;
			retval.add(rel.getEndNode());
		}
		return retval;
	}
	
}
