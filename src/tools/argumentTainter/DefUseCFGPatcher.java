package tools.argumentTainter;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;

import output.neo4j.EdgeTypes;
import output.neo4j.readWriteDB.Neo4JDBInterface;
import output.neo4j.readWriteDB.QueryUtils;
import tools.ddg.DefUseCFGFactories.DefUseCFG;
import tools.udg.ASTDefUseAnalyzer;
import tools.udg.DBProvider;
import tools.udg.ReadWriteDBProvider;
import tools.udg.UseOrDef;

public class DefUseCFGPatcher {

	List<DefUseLink> newlyAddedLinks = new LinkedList<DefUseLink>();
	DefUseCFG defUseCFG;
	ASTDefUseAnalyzer astDefUseAnalyzer = new ASTDefUseAnalyzer();
	DBProvider dbProvider = new ReadWriteDBProvider();

	public DefUseCFGPatcher()
	{
		astDefUseAnalyzer.setDBProvider(dbProvider);
	}
	
	public class DefUseLink{
		public DefUseLink(String aSymbol, Long aBasicBlockId, boolean aIsDef) {
			symbol = aSymbol;
			basicBlock = aBasicBlockId;
			isDef = aIsDef;
		}
		public String symbol;
		public long basicBlock;
		public boolean isDef;
	}
	
	
	static final Map<String, Object> EMPTY_PROPERTIES = new HashMap<String, Object>();

	public void setSourceToPatch(String sourceToPatch, int argToPatch)
	{
		astDefUseAnalyzer.addTaintSource(sourceToPatch, argToPatch);
	}
	
	public Collection<DefUseLink> getDefUseLinksToAdd()
	{
		return newlyAddedLinks;
	}
	

	public void patchDefUseCFG(DefUseCFG defUseCFG, Collection<Node> basicBlocksToPatch)
	{
		this.defUseCFG = defUseCFG;
		newlyAddedLinks.clear();
		
		for(Node basicBlock : basicBlocksToPatch){
			
			long basicBlockId = basicBlock.getId();
			
			Node astNode = QueryUtils.getASTForBasicBlock(basicBlock);
			Collection<UseOrDef> newDefs = astDefUseAnalyzer.analyzeAST(astNode.getId());
			
			Collection<Object> oldDefs = defUseCFG.getSymbolsDefinedBy(basicBlockId);
			updateDefsToAdd(oldDefs, newDefs, basicBlockId);
			
		}
		
	}
	
	private void updateDefsToAdd(Collection<Object> oldDefs,
			Collection<UseOrDef> newDefs, Long basicBlockId)
	{
		for(UseOrDef newDef : newDefs){
			if(oldDefs.contains(newDef.symbol)) continue;
			if(!newDef.isDef) continue;
			DefUseLink e = new DefUseLink(newDef.symbol, basicBlockId, newDef.isDef);
			// add to newlyAddedLinks
			newlyAddedLinks.add(e);
			defUseCFG.addSymbolDefined(basicBlockId, newDef.symbol);
		}
	}

	public void writeChangesToDatabase()
	{
		
		if(defUseCFG == null){
			System.out.println("defUseCFG is null");
			return;
		}
			
		Neo4JDBInterface.startTransaction();
		for(DefUseLink link : newlyAddedLinks){
			
			Long fromId = link.basicBlock;
			Long toId = defUseCFG.getIdForSymbol(link.symbol); 
			
			if(toId == null){
				System.err.println("Warning: Trying to create DEF-link to unknown symbol: " + link.symbol);
				break;
			}
			
			RelationshipType relType = DynamicRelationshipType.withName(EdgeTypes.DEF);
			Neo4JDBInterface.addRelationship(fromId, toId, relType, null);	
		}
		Neo4JDBInterface.finishTransaction();
	}

}
