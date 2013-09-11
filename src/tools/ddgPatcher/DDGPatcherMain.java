package tools.ddgPatcher;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;

import output.neo4j.EdgeTypes;
import output.neo4j.readWriteDB.Neo4JDBInterface;
import output.neo4j.readWriteDB.QueryUtils;
import tools.ddg.DDG;
import tools.ddg.DDGCreator;
import tools.ddg.DDGDifference;
import tools.ddg.DefUseRelation;
import tools.ddg.DefUseCFGFactories.DefUseCFGFactory;
import tools.ddg.DefUseCFGFactories.DefUseCFG;
import tools.ddg.DefUseCFGFactories.ReadWriteDbFactory;

public class DDGPatcherMain {

	static DefUseCFGFactory factory = new ReadWriteDbFactory();
	
	public static void main(String[] args)
	{
		String source = "copy_from_user";
		int taintedArg = 0;
			
		Neo4JDBInterface.setIndexDirectoryName(".joernIndex");
		Neo4JDBInterface.openDatabase();
		
		HashMap<Long, SourceCalls> sourceCallsByFuncId = getSourceCallsFromIndex(source, taintedArg);	
		
		Set<Long> funcIds = sourceCallsByFuncId.keySet();
		
		for(Long funcId : funcIds){
			
			SourceCalls sourceCalls = sourceCallsByFuncId.get(funcId);
			Node funcNode = Neo4JDBInterface.getNodeById(funcId);
			DDG oldDDG = QueryUtils.getDDGForFunction(funcNode);
			
			DefUseCFG defUseCFG = getCurrentDefUseCFGFromDatabase(funcId);
						
			patchDefUseCFG(defUseCFG, sourceCalls);
			
			DDGCreator ddgCreator = new DDGCreator();
			DDG newDDG = ddgCreator.createForDefUseCFG(defUseCFG);
			DDGDifference diff = oldDDG.difference(newDDG);
			changeDDGinDatabase(diff);
		}
				
		Neo4JDBInterface.closeDatabase();
	}

	private static HashMap<Long, SourceCalls> getSourceCallsFromIndex(String source, int taintedArg)
	{
		HashMap<Long, SourceCalls> retval = new HashMap<Long, SourceCalls>();		
		
		List<Node> hits = QueryUtils.getCallsToSymbol(source);
		
		for(Node callNode : hits){
			
			Long functionId = Long.valueOf(callNode.getProperty("functionId").toString());		
			
			SourceCalls sourceCalls = retval.get(functionId);
			
			if(sourceCalls == null){
				SourceCalls newSourceCalls = new SourceCalls();
				retval.put(functionId, newSourceCalls);
				sourceCalls = newSourceCalls;
			}
			
			Node basicBlock = QueryUtils.getBasicBlockForASTNode(callNode);
			String nthArg = QueryUtils.getNthArgOfCall(callNode, taintedArg);
			
			sourceCalls.blocksCallingSource.add(basicBlock.getId());
			sourceCalls.argsToSource.add(nthArg);
			
		}
			
		return retval;
	}
	
	private static DefUseCFG getCurrentDefUseCFGFromDatabase(long funcId)
	{
		DefUseCFG cfgForDDG = factory.create(funcId);
		return cfgForDDG;
	}
	
	private static void patchDefUseCFG(DefUseCFG defUseCFG, SourceCalls sourceCalls)
	{
		int nCalls = sourceCalls.blocksCallingSource.size();

		for(int i = 0; i< nCalls; i++){
			String arg = sourceCalls.argsToSource.get(i);
			Long blockId = sourceCalls.blocksCallingSource.get(i);
			defUseCFG.addSymbolDefined(blockId, arg);
		}
		
	}

	private static void changeDDGinDatabase(DDGDifference diff)
	{
		Neo4JDBInterface.startTransaction();
		removeOldEdges(diff);
		addNewEdges(diff);
		Neo4JDBInterface.finishTransaction();
	}

	private static void addNewEdges(DDGDifference diff)
	{
		List<DefUseRelation> relsToAdd = diff.getRelsToAdd();
		for(DefUseRelation rel : relsToAdd){
			
			Map<String, Object> properties = new HashMap<String, Object>();
			properties.put("var", rel.symbol);
			RelationshipType relType = DynamicRelationshipType.withName(EdgeTypes.REACHES);
			
			Neo4JDBInterface.addRelationship(rel.src, rel.dst, relType, properties);	
		}
	}

	private static void removeOldEdges(DDGDifference diff)
	{
		List<DefUseRelation> relsToRemove = diff.getRelsToRemove();
	
		for(DefUseRelation rel : relsToRemove){
			Node srcBasicBlock = Neo4JDBInterface.getNodeById(rel.src);
			
			Iterable<Relationship> rels = srcBasicBlock.getRelationships(Direction.OUTGOING);
			
			for(Relationship reachRel : rels){
				if(!reachRel.getType().toString().equals(EdgeTypes.REACHES))
					continue;
				
				if(reachRel.getEndNode().getId() != rel.dst)
					continue;
				
				Object var = reachRel.getProperty("var");
				if(var == null || !var.toString().equals(rel.symbol))
					continue;
				
				Neo4JDBInterface.removeEdge(reachRel.getId());
				break;
			}
		}
	}
	
}
