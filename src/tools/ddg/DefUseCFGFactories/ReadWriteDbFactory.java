package tools.ddg.DefUseCFGFactories;

import java.util.LinkedList;
import java.util.List;

import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.index.IndexHits;

import output.neo4j.Neo4JDBInterface;

public class ReadWriteDbFactory extends DefUseCFGFactory {

	DefUseCFG cfg;
	
	@Override
	public DefUseCFG create(Long funcId)
	{
		cfg = new DefUseCFG();
		
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
			cfg.addBasicBlock(node.getId());
	}

	private void getUsesAndDefs()
	{
		for(Long basicBlockId : cfg.getBasicBlocks()){
			
			List<String> used = getSymbolsUsedByBasicBlock(basicBlockId);
			for(String symbol : used)
				cfg.addSymbolUsed(basicBlockId, symbol);
		
			List<String> defined = getSymbolsDefinedByBasicBlock(basicBlockId);
			for(String symbol : defined)
				cfg.addSymbolDefined(basicBlockId, symbol);
			
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
		for(Long basicBlockId : cfg.getBasicBlocks()){
			Node basicBlock = Neo4JDBInterface.getNodeById(basicBlockId);
			Iterable<Relationship> rels = basicBlock.getRelationships(Direction.INCOMING);
			for(Relationship rel: rels){
				long parentId = rel.getStartNode().getId();
				cfg.addParentBlock(basicBlockId, parentId);
			}
		}
	}		
	
	private void getChildBlocks()
	{
		for(Long basicBlockId : cfg.getBasicBlocks()){
			Node basicBlock = Neo4JDBInterface.getNodeById(basicBlockId);
			Iterable<Relationship> rels = basicBlock.getRelationships(Direction.OUTGOING);
			for(Relationship rel: rels){
				long childId = rel.getEndNode().getId();
				cfg.addChildBlock(basicBlockId, childId);
			}
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
