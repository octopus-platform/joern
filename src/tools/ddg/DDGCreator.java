package tools.ddg;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import misc.HashMapOfSets;
import tools.ddg.DefUseCFGFactories.BatchInserterFactory;
import tools.ddg.DefUseCFGFactories.DefUseCFG;
import tools.ddg.DefUseCFGFactories.DefUseCFGFactory;


public class DDGCreator {
	
	DefUseCFG cfg;
	DefUseCFGFactory cfgFactory = new BatchInserterFactory();
	
	HashMapOfSets in = new HashMapOfSets();
	HashMapOfSets out = new HashMapOfSets();
	HashMapOfSets gen = new HashMapOfSets();
	HashSet<Long> changedNodes;
	
	private class Definition{
		public Definition(Long aStatement, String aIdentifier)
		{
			statement = aStatement;
			identifier = aIdentifier;
		}
		
		public Long statement;
		public String identifier;
	};
	
	public void setFactory(DefUseCFGFactory aFactory)
	{
		cfgFactory = aFactory;
	}
	
	public DDG createForFunctionById(Long funcId)
	{
		return createForDefUseCFG(cfgFactory.create(funcId));	
	}

	public DDG createForDefUseCFG(DefUseCFG aCfg)
	{
		cfg = aCfg;
		calculateReachingDefs();
		return createDDGFromReachingDefs();
	}
	
	private void calculateReachingDefs()
	{
		initReachingDefs();
				
		while(!changedNodes.isEmpty()){
			
			Long currentBlock = popFromChangedNodes();
			
			updateIn(currentBlock);
			boolean changed = updateOut(currentBlock);
		
			if(!changed) continue;
						
			List<Object> children = cfg.getChildBlocks().getListForKey(currentBlock);
			if(children == null)
				continue;			
			
			for(Object o: children)
				changedNodes.add((Long) o);
						
		}
		
	}

	private void initReachingDefs()
	{
		initOut();
		initGenFromOut();
		changedNodes = new HashSet<Long>();		
		changedNodes.addAll(cfg.getStatements());
	}

	private Long popFromChangedNodes()
	{
		Long x = changedNodes.iterator().next();
		changedNodes.remove(x);		
		return x;
	}

	private void initOut()
	{
		for(Long statement : cfg.getStatements()){
			
			// this has the nice side-effect that an
			// empty hash is created for the basic block.
			
			out.removeAllForKey(statement);
			
			List<Object> symsDefined = cfg.getSymbolsDefined().getListForKey(statement);
			if(symsDefined == null) continue;
			
			for(Object s: symsDefined){
				String symbol = (String) s;
				out.add(statement, new Definition(statement, symbol));
			}
		}
	}

	private void initGenFromOut()
	{
		for(Long statement : cfg.getStatements()){
			for(Object o: out.getListForKey(statement))
				gen.add(statement, o);		
		}
	}
	
	private void updateIn(Long x)
	{
		List<Object> parents = cfg.getParentBlocks().getListForKey(x);		
		if(parents == null) return;
		
		in.removeAllForKey(x);
		
		// in(x) = union(out(p))_{p in parents(x)}
		for(Object p : parents){
			Long parent = (Long) p;
			HashSet<Object> parentOut = out.getListForKey(parent);
			if(parentOut == null) continue;			
			for (Object o : parentOut)
				in.add(x, o);
		}
	}

	private boolean updateOut(Long x)
	{	
		HashSet<Object> oldOut = new HashSet<Object>(out.getListForKey(x));		
		
		out.removeAllForKey(x);
		
		// in(x)
		HashSet<Object> inForX = in.getListForKey(x);
		if(inForX != null){		
			for(Object o : inForX){
				out.add(x, o);
			}		
		}
		
		// -kill(x)
		List<Object> killX = cfg.getSymbolsDefined().getListForKey(x);
		if(killX != null){
		
			Iterator<Object> it = out.getListForKey(x).iterator();
			while(it.hasNext()){
				Definition def = (Definition) it.next();
				if(killX.contains(def.identifier))
					it.remove();
			}
			
		}	
		
		// gen(X)
		HashSet<Object> genX = gen.getListForKey(x);

		if(genX != null){
			for(Object o :  genX){
				out.add(x, o);
			}
		}
		
		
		return !oldOut.equals(out.getListForKey(x));
	}

	private DDG createDDGFromReachingDefs()
	{
		DDG ddg = new DDG();
		
		for(Long statement : cfg.getStatements()){
			HashSet<Object> inForBlock = in.getListForKey(statement);
			if(inForBlock == null) continue;			
			List<Object> usedSymbols = cfg.getSymbolsUsed().getListForKey(statement);
			if(usedSymbols == null) continue;
			
			for(Object d : inForBlock){
				Definition def = (Definition) d;
				
				if(usedSymbols.contains(def.identifier))
						ddg.add(def.statement, statement, def.identifier);
			}
		}
	
		return ddg;
	}
	
	
}
