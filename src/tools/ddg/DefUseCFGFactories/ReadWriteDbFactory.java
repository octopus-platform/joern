package tools.ddg.DefUseCFGFactories;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import misc.MultiHashMap;
import misc.Pair;

import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.index.IndexHits;

import output.neo4j.EdgeTypes;
import output.neo4j.readWriteDB.Neo4JDBInterface;
import output.neo4j.readWriteDB.QueryUtils;

public class ReadWriteDbFactory extends DefUseCFGFactory {

	DefUseCFG cfg;
	
	@Override
	public DefUseCFG create(Long funcId)
	{
		cfg = new DefUseCFG();
		cfg.setFunctionId(funcId);
		
		getStatementsOfFunction(funcId);		
		getUsesAndDefs();		
		getParentBlocks();
		getChildBlocks();
		
		return cfg;
	}

	private void getStatementsOfFunction(Long funcId)
	{
		String query = "type:BasicBlock AND functionId:" + funcId;
		IndexHits<Node> hits = Neo4JDBInterface.queryIndex(query);
		for(Node node : hits)
			cfg.addStatement(node.getId());
	}

	private void getUsesAndDefs()
	{
		for(Long statementId : cfg.getStatements()){
			
			List<Pair<Long,String>> used = QueryUtils.getSymbolsUsedByStatement(statementId);
			for(Pair<Long, String> symbolIdAndCode : used){
				Long symbolId = symbolIdAndCode.getL();
				String symbolCode = symbolIdAndCode.getR();
				cfg.addSymbolUsed(statementId, symbolCode);
				cfg.setSetSymbolId(symbolCode, symbolId);
			}
				
			List<Pair<Long,String>> defined = QueryUtils.getSymbolsDefinedByStatement(statementId);
			for(Pair<Long, String> symbolIdAndCode : defined){
				Long symbolId = symbolIdAndCode.getL();
				String symbolCode = symbolIdAndCode.getR();
				cfg.addSymbolDefined(statementId, symbolCode);
				cfg.setSetSymbolId(symbolCode, symbolId);
			}
		}
	}
	
	private void getParentBlocks()
	{
		for(Long statementId : cfg.getStatements()){
			Node statement = Neo4JDBInterface.getNodeById(statementId);
			Iterable<Relationship> rels = statement.getRelationships(Direction.INCOMING);
			for(Relationship rel: rels){
				if(!rel.getType().toString().equals(EdgeTypes.FLOWS_TO))
					continue;
				long parentId = rel.getStartNode().getId();
				cfg.addParentBlock(statementId, parentId);
			}
		}
	}		
	
	private void getChildBlocks()
	{
		for(Long statementId : cfg.getStatements()){
			Node statement = Neo4JDBInterface.getNodeById(statementId);
			Iterable<Relationship> rels = statement.getRelationships(Direction.OUTGOING);
			for(Relationship rel: rels){
				if(!rel.getType().toString().equals(EdgeTypes.FLOWS_TO))
					continue;
				
				long childId = rel.getEndNode().getId();
				cfg.addChildBlock(statementId, childId);
			}
		}
	}
	
}
