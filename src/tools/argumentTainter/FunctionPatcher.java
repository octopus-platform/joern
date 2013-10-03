package tools.argumentTainter;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.neo4j.graphdb.Node;

import output.neo4j.readWriteDB.QueryUtils;
import tools.ddg.DefUseCFGFactories.DefUseCFG;
import tools.ddg.DefUseCFGFactories.DefUseCFGFactory;
import tools.ddg.DefUseCFGFactories.ReadWriteDbFactory;

public class FunctionPatcher {

	private DefUseCFGFactory defUseGraphFactory = new ReadWriteDbFactory();
	private Collection<Node> basicBlocksToPatch = new LinkedList<Node>();
	private DefUseCFG defUseCFG = null;
	
	private String sourceToPatch;
	private int argumentToPatch;
	
	public void setSourceToPatch(String source)
	{
		sourceToPatch = source;
	}
	
	public void setArgumentToPatch(int argToPatch)
	{
		argumentToPatch = argToPatch;
	}
	
	public void reset()
	{
		basicBlocksToPatch.clear();
		defUseCFG = null;
	}
	
	public void patch(Long funcId)
	{
		determineCallsToPatch(funcId);
		retrieveDefUseCFGFromDatabase(funcId);
		patchDefUseCFG();
		patchDDG(funcId);
	}

	
	private void determineCallsToPatch(Long funcId)
	{
		List<Node> callNodes = QueryUtils.getCallsToForFunction(sourceToPatch, funcId);	
		for(Node callNode : callNodes){
			basicBlocksToPatch.add(QueryUtils.getBasicBlockForASTNode(callNode));
		}
	}

	private void retrieveDefUseCFGFromDatabase(long funcId)
	{
		defUseCFG = defUseGraphFactory.create(funcId);
	}
	
	private void patchDefUseCFG()
	{
		DefUseCFGPatcher patcher = new DefUseCFGPatcher();
		patcher.setSourceToPatch(sourceToPatch, argumentToPatch);
		patcher.patchDefUseCFG(defUseCFG, basicBlocksToPatch);
		patcher.writeChangesToDatabase();
	}

	private void patchDDG(Long funcId)
	{
		DDGPatcher patcher = new DDGPatcher();
		patcher.patchDDG(defUseCFG, funcId);
		patcher.writeChangesToDatabase();
	}	
}
