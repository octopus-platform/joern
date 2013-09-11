package output.neo4j.readWriteDB;

import java.util.LinkedList;
import java.util.List;

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

	public static List<String> getSymbolsDefinedByBasicBlock(Long basicBlockId)
	{
		Node node = Neo4JDBInterface.getNodeById(basicBlockId);
		return getCodeOfChildrenConnectedBy(node, "DEF");
	}

	public static List<String> getSymbolsUsedByBasicBlock(Long basicBlockId)
	{	
		Node node = Neo4JDBInterface.getNodeById(basicBlockId);
		return getCodeOfChildrenConnectedBy(node, "USE");
	}
	
	public static List<String> getCodeOfChildrenConnectedBy(Node node, String edgeType)
	{
		List<String> retval = new LinkedList<String>();
		
		Iterable<Relationship> rels = node.getRelationships();
		for(Relationship rel : rels){
			if(!rel.getType().name().equals(edgeType)) continue;
		
			Node identifierNode = rel.getEndNode();
			String identifierStr = identifierNode.getProperty("code").toString();			
			retval.add(identifierStr);
		}
		
		return retval;
	}
	
	public static List<Node> getCallsToSymbol(String source)
	{
		List<Node> retval = new LinkedList<Node>();
		
		IndexHits<Node> hits = Neo4JDBInterface.queryIndex("type:CallExpression AND code:" + source + "*");
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

	public static String getNthArgOfCall(Node callNode, int n)
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
	
}
