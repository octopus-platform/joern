package output.neo4j.batchInserter;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.neo4j.graphdb.index.IndexHits;
import org.neo4j.unsafe.batchinsert.BatchRelationship;

import output.neo4j.EdgeTypes;

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
	
	public static long getASTForStatement(Long statementId)
	{
		return getFirstChildWithEdgeType(statementId, EdgeTypes.IS_BASIC_BLOCK_OF);		
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

	public static List<String> getSymbolsUsedByStatement(long nodeId)
	{
		return getCodeOfChildrenConnectedBy(nodeId, EdgeTypes.USE);
	}

	public static List<String> getSymbolsDefinedByStatement(long nodeId)
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

	public static IndexHits<Long> getStatementsFromIndex(long functionId)
	{		
		String query = "type:\"BasicBlock\" AND functionId:\"" + functionId + "\"";
		return Neo4JBatchInserter.queryIndex(query);
	}

	public static List<Long> getParentStatements(Long statementId)
	{
		List<Long> retval = new LinkedList<Long>();
		Iterable<BatchRelationship> rels = getEdges(statementId);
		for(BatchRelationship rel : rels){
			if(!rel.getType().name().equals(EdgeTypes.FLOWS_TO)) continue;
			if(rel.getStartNode() == statementId) continue;
			retval.add(rel.getStartNode());		
		}
		return retval;
	}

	public static List<Long> getChildStatements(Long statementId)
	{
		List<Long> retval = new LinkedList<Long>();
		Iterable<BatchRelationship> rels = getEdges(statementId);
		for(BatchRelationship rel : rels){
			if(!rel.getType().name().equals(EdgeTypes.FLOWS_TO)) continue;
			if(rel.getEndNode() == statementId) continue;
			retval.add(rel.getEndNode());
		}
		return retval;
	}

	public static String getOperatorCode(Long nodeId)
	{
		return Neo4JBatchInserter.getNodeProperties(nodeId).get("operator").toString();
	}

	public static IndexHits<Long> getFunctionsByName(String functionName)
	{
		return Neo4JBatchInserter.queryIndex("functionName:" + functionName);
	}

	public static String getCalleeFromCall(Long nodeId)
	{
		Iterable<BatchRelationship> rels = getEdges(nodeId);
		for(BatchRelationship rel : rels){
			if(isIncomingEdge(nodeId, rel)) continue;
			if(!isASTEdge(rel)) continue;
			
			if(QueryUtils.getChildNumber(rel).equals("0"))
				return getNodeCode(rel.getEndNode());
		}
		return "";
	}
	
}
