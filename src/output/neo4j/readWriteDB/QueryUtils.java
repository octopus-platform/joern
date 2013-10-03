package output.neo4j.readWriteDB;

import java.util.LinkedList;
import java.util.List;

import misc.Pair;

import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.index.IndexHits;

import output.neo4j.EdgeTypes;
import tools.ddg.DDG;

public class QueryUtils
{

	public static IndexHits<Node> getBasicBlocksForFunction(Node funcNode)
	{
		String query = "type:BasicBlock AND functionId:" + funcNode.getId();
		return Neo4JDBInterface.queryIndex(query);
	}

	public static List<Pair<Long,String>> getSymbolsDefinedByBasicBlock(Long basicBlockId)
	{
		Node node = Neo4JDBInterface.getNodeById(basicBlockId);
		return getIdAndCodeOfChildrenConnectedBy(node, "DEF");
	}

	public static List<Pair<Long,String>> getSymbolsUsedByBasicBlock(Long basicBlockId)
	{	
		Node node = Neo4JDBInterface.getNodeById(basicBlockId);
		return getIdAndCodeOfChildrenConnectedBy(node, "USE");
	}
	
	public static List<String> getCodeOfChildrenConnectedBy(Node node, String edgeType)
	{
		List<String> retval = new LinkedList<String>();
				
		List<Node> children = getChildrenConnectedBy(node, edgeType);
		for(Node childNode : children){
			String childCode = childNode.getProperty("code").toString();
			retval.add(childCode);
		}
		return retval;
	}
	
	public static List<Pair<Long, String>> getIdAndCodeOfChildrenConnectedBy(Node node, String edgeType)
	{
		List<Pair<Long, String>> retval = new LinkedList<Pair<Long,String>>();		
		List<Node> children = getChildrenConnectedBy(node, edgeType);
		
		for(Node childNode : children){
			String childCode = childNode.getProperty("code").toString();
			Pair<Long, String> pair = new Pair<Long,String>(childNode.getId(), childCode);
			retval.add(pair);
		}
		
		return retval;
	}
	
	public static List<Node> getChildrenConnectedBy(Node node, String edgeType)
	{
		List<Node> retval = new LinkedList<Node>();
		
		long nodeId = node.getId();
		
		Iterable<Relationship> rels = node.getRelationships();
		for(Relationship rel : rels){
			if(!rel.getType().name().equals(edgeType)) continue;
			Node childNode = rel.getEndNode();
			if(childNode.getId() == nodeId) continue;
			
			retval.add(childNode);
		}
		return retval;
	}
	
	public static List<Node> getParentsConnectedBy(Node node, String edgeType)
	{
		List<Node> retval = new LinkedList<Node>();
		
		long nodeId = node.getId();
		
		Iterable<Relationship> rels = node.getRelationships();
		for(Relationship rel : rels){
			if(!rel.getType().name().equals(edgeType)) continue;
			Node parentNode = rel.getStartNode();
			if(parentNode.getId() == nodeId) continue;
			
			retval.add(parentNode);
		}
		return retval;
	}
	
	public static List<Node> getCallsTo(String source)
	{
		List<Node> retval = new LinkedList<Node>();
		
		IndexHits<Node> hits = Neo4JDBInterface.queryIndex("type:CallExpression AND code:" + source + "*");
		for(Node n: hits){
			if(n.getProperty("code").toString().startsWith(source + " "))
				retval.add(n);
		}
		return retval;
	}

	public static List<Node> getCallsToForFunction(String source, long functionId)
	{
		List<Node> retval = new LinkedList<Node>();
		
		String query = "type:CallExpression AND functionId:"+ functionId + " AND code:" + source + "*";
		
		IndexHits<Node> hits = Neo4JDBInterface.queryIndex(query);
		for(Node n: hits){
			if(n.getProperty("code").toString().startsWith(source + " "))
				retval.add(n);
		}
		return retval;
	}
	
	
	public static DDG getDDGForFunction(Node funcNode)
	{
		DDG retval = new DDG();
		for(Node basicBlock: QueryUtils.getBasicBlocksForFunction(funcNode)){
			Iterable<Relationship> rels = basicBlock.getRelationships(Direction.OUTGOING);
			long srcId = basicBlock.getId();
			
			for(Relationship rel: rels){
				if(!rel.getType().toString().equals(EdgeTypes.REACHES))
					continue;
				long dstId = rel.getEndNode().getId();
				String symbol = rel.getProperty("var").toString();
				retval.add(srcId, dstId, symbol);
			}
		
		}
		return retval;
	}

	// The two following functions are somewhat disgraceful
	// but should work for now.
	
	public static Node getBasicBlockForASTNode(Node callNode)
	{
		Node n = callNode;
		Node parent = null;
		
		while(true){
			Iterable<Relationship> rels = n.getRelationships(Direction.INCOMING);
			for(Relationship rel : rels){
				if(rel.getType().toString().equals(EdgeTypes.IS_BASIC_BLOCK_OF))
					return rel.getStartNode(); 
				else if(rel.getType().toString().equals(EdgeTypes.IS_AST_PARENT))
					parent = rel.getStartNode();						
			}
			n = parent;
		}
	}

	public static String getNthArgCodeOfCall(Node callNode, int n)
	{
		Iterable<Relationship> rels = callNode.getRelationships(Direction.OUTGOING);
		for(Relationship rel : rels){
			
			if(!rel.getType().toString().equals(EdgeTypes.IS_AST_PARENT))
				continue;
			
			Integer nProp = Integer.valueOf(rel.getProperty("n").toString());
			if(nProp == 1){
				// found argument list
				Node argList = rel.getEndNode();
				Iterable<Relationship> rels2 = argList.getRelationships(Direction.OUTGOING);
				for(Relationship rel2 : rels2){
					if(!rel2.getType().toString().equals(EdgeTypes.IS_AST_PARENT))
						continue;
					Integer nProp2 = Integer.valueOf(rel2.getProperty("n").toString());
					if(nProp2 == n)
						return rel2.getEndNode().getProperty("code").toString();
				}	
			}
		}
		return null;
	}

	public static Long getFunctionIdFromASTNode(Node astNode)
	{
		return Long.valueOf(astNode.getProperty("functionId").toString());
	}

	public static IndexHits<Node> getFunctionsByName(String functionName)
	{
		// TODO Auto-generated method stub	
		return Neo4JDBInterface.queryIndex("functionName:" + functionName);
	}


	public static Node getASTForBasicBlock(Node basicBlock)
	{

		List<Node> r = getChildrenConnectedBy(basicBlock, EdgeTypes.IS_BASIC_BLOCK_OF);
		return r.get(0);
	}

	public static String getNodeType(Long nodeId)
	{
		Node node = Neo4JDBInterface.getNodeById(nodeId);
		return node.getProperty("type").toString();

	}

	public static String getCalleeFromCall(Long nodeId)
	{
		Node node = Neo4JDBInterface.getNodeById(nodeId);
		Iterable<Relationship> rels = node.getRelationships();
		for(Relationship rel : rels){
			if(!rel.getType().name().equals(EdgeTypes.IS_AST_PARENT)) continue;
			if(rel.getEndNode().getId() == node.getId()) continue;
			if(!rel.getProperty("n").equals("0")) continue;
			
			return rel.getEndNode().getProperty("code").toString();
		}
		return "";
	}

	public static String getNodeCode(long nodeId)
	{
		Node node = Neo4JDBInterface.getNodeById(nodeId);
		return node.getProperty("code").toString();
	}

	public static String getOperatorCode(long nodeId)
	{
		Node node = Neo4JDBInterface.getNodeById(nodeId);
		return node.getProperty("operator").toString();
	}	
	
}
