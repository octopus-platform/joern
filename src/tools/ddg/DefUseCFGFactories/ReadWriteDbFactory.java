package tools.ddg.DefUseCFGFactories;

import java.util.List;

import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.index.IndexHits;

import output.neo4j.EdgeTypes;
import output.neo4j.ReadWriteDB.Neo4JDBInterface;
import output.neo4j.ReadWriteDB.QueryUtils;

public class ReadWriteDbFactory extends DefUseCFGFactory {

	DefUseCFG cfg;
	
	@Override
	public DefUseCFG create(Long funcId)
	{
		cfg = new DefUseCFG();
		cfg.setFunctionId(funcId);
		
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
			
			List<String> used = QueryUtils.getSymbolsUsedByBasicBlock(basicBlockId);
			for(String symbol : used)
				cfg.addSymbolUsed(basicBlockId, symbol);
		
			List<String> defined = QueryUtils.getSymbolsDefinedByBasicBlock(basicBlockId);
			for(String symbol : defined)
				cfg.addSymbolDefined(basicBlockId, symbol);
			
		}
	}
	
	private void getParentBlocks()
	{
		for(Long basicBlockId : cfg.getBasicBlocks()){
			Node basicBlock = Neo4JDBInterface.getNodeById(basicBlockId);
			Iterable<Relationship> rels = basicBlock.getRelationships(Direction.INCOMING);
			for(Relationship rel: rels){
				if(!rel.getType().toString().equals(EdgeTypes.FLOWS_TO))
					continue;
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
				if(!rel.getType().toString().equals(EdgeTypes.FLOWS_TO))
					continue;
				
				long childId = rel.getEndNode().getId();
				cfg.addChildBlock(basicBlockId, childId);
			}
		}
	}
	
}
