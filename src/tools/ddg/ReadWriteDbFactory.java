package tools.ddg;

import java.util.LinkedList;
import java.util.List;

import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.index.IndexHits;

import output.neo4j.Neo4JDBInterface;

public class ReadWriteDbFactory extends CFGForDDGFactory {

	CFGForDDGCreation cfg;
	
	@Override
	public CFGForDDGCreation create(Long funcId)
	{
		cfg = new CFGForDDGCreation();
		
		getBasicBlocksOfFunction(funcId);		
		getUsesAndDefs();		
		getParentBlocks();
		getChildBlocks();
	
		return cfg;
	}

	private void getBasicBlocksOfFunction(Long funcId)
	{
		String query = "type:BasicBlock AND functionId:" + funcId;
		IndexHits<Node> hits = Neo4JDBInterface.queryIndex(query);
		for(Node node : hits)
			cfg.basicBlocks.add(node.getId());
	}

	private void getUsesAndDefs()
	{
		for(Long basicBlockId : cfg.basicBlocks){
			
			List<String> used = getSymbolsUsedByBasicBlock(basicBlockId);
			for(String symbol : used)
				cfg.symbolsUsed.add(basicBlockId, symbol);
		
			List<String> defined = getSymbolsDefinedByBasicBlock(basicBlockId);
			for(String symbol : used)
				cfg.symbolsDefined.add(basicBlockId, symbol);
			
		}
	}
	
	private List<String> getSymbolsDefinedByBasicBlock(Long basicBlockId)
	{
		Node node = Neo4JDBInterface.getNodeById(basicBlockId);
		return getCodeOfChildrenConnectedBy(node, "DEF");
	}

	private List<String> getSymbolsUsedByBasicBlock(Long basicBlockId)
	{	
		Node node = Neo4JDBInterface.getNodeById(basicBlockId);
		return getCodeOfChildrenConnectedBy(node, "USE");
	}

	private void getParentBlocks()
	{
		for(Long basicBlockId : cfg.basicBlocks){
			Node basicBlock = Neo4JDBInterface.getNodeById(basicBlockId);
			Iterable<Relationship> rels = basicBlock.getRelationships(Direction.INCOMING);
			for(Relationship rel: rels)
				cfg.parentBlocks.add(basicBlockId, rel.getStartNode().getId());
		}
	}		
	
	private void getChildBlocks()
	{
		for(Long basicBlockId : cfg.basicBlocks){
			Node basicBlock = Neo4JDBInterface.getNodeById(basicBlockId);
			Iterable<Relationship> rels = basicBlock.getRelationships(Direction.OUTGOING);
			for(Relationship rel: rels)
				cfg.childBlocks.add(basicBlockId, rel.getEndNode().getId());
		}
	}

	private List<String> getCodeOfChildrenConnectedBy(Node node, String edgeType)
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
	
}
