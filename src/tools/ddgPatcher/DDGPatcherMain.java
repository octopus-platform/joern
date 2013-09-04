package tools.ddgPatcher;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.neo4j.graphdb.Node;


import output.neo4j.ReadWriteDB.Neo4JDBInterface;
import output.neo4j.ReadWriteDB.QueryUtils;
import tools.ddg.DDG;
import tools.ddg.DDGCreator;
import tools.ddg.DDGDifference;
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
		System.out.println(diff.getRelsToAdd().size());
		System.out.println(diff.getRelsToRemove().size());
	}
	
}
