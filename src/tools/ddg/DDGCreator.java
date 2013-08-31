package tools.ddg;


import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import misc.HashMapOfSets;
import misc.MultiHashMap;

import org.neo4j.graphdb.index.IndexHits;

import output.neo4j.QueryUtils;

public class DDGCreator {

	DDG ddg = new DDG();	
	MultiHashMap symbolsUsed = new MultiHashMap();
	MultiHashMap symbolsDefined = new MultiHashMap();
	
	MultiHashMap parentBlocks = new MultiHashMap();
	MultiHashMap childBlocks = new MultiHashMap();
	
	HashMapOfSets in = new HashMapOfSets();
	HashMapOfSets out = new HashMapOfSets();
	
	HashMapOfSets gen = new HashMapOfSets();
	
	LinkedList<Long> basicBlocks = new LinkedList<Long>();
	
	private class Definition{
		public Definition(Long aBasicBlock, String aIdentifier)
		{
			basicBlock = aBasicBlock;
			identifier = aIdentifier;
		}
		
		public Long basicBlock;
		public String identifier;
	};
		
	
	public DDG create(Long funcId)
	{
		IndexHits<Long> blocks = QueryUtils.getBasicBlocksFromIndex(funcId);
		
		for(Long block : blocks)
			basicBlocks.add(block);
		
		
		cacheUsesAndDefs();		
		cacheParentBlocks();
		cacheChildBlocks();
		
		reachingDefinitions();
		
		createDDGFromReachingDefs();
		
		return ddg;
	}

	private void cacheUsesAndDefs()
	{
		for(Long basicBlock : basicBlocks){
			
			List<String> useSymbols = QueryUtils.getSymbolsUsedByBasicBlock(basicBlock);			
			for(String symbol : useSymbols){
				symbolsUsed.add(basicBlock, symbol);
			}
			
			List<String> defSymbols = QueryUtils.getSymbolsDefinedByBasicBlock(basicBlock);
			for(String symbol : defSymbols){
				symbolsDefined.add(basicBlock, symbol);
			}	
		}
	}

	private void cacheParentBlocks()
	{
		for(Long basicBlock : basicBlocks){
			List<Long> parents = QueryUtils.getParentBasicBlocks(basicBlock);
			for(Long parent : parents){
				parentBlocks.add(basicBlock, parent);
			}
		}
	}
	
	private void cacheChildBlocks()
	{
		for(Long basicBlock : basicBlocks){
			List<Long> parents = QueryUtils.getChildBasicBlocks(basicBlock);
			for(Long parent : parents){
				childBlocks.add(basicBlock, parent);
			}
		}
	}
	
	
	private void reachingDefinitions()
	{
		initOutAndGen();
		
		HashSet<Long> changedNodes = new HashSet<Long>();
		for(Long basicBlock : basicBlocks)
			changedNodes.add(basicBlock);
		
		boolean changed;
		
		while(!changedNodes.isEmpty()){
			Long x = changedNodes.iterator().next();
			changedNodes.remove(x);
			
			initInFromParents(x);
			changed = updateOut(x);
		
			if(changed){
				List<Object> childrenOfX = childBlocks.getListForKey(x);
				if(childrenOfX == null) continue;
				for(Object o: childrenOfX){
					changedNodes.add((Long) o);
				}
			}
		}
		
	}

	private void initOutAndGen()
	{
		for(Long basicBlock : basicBlocks){
			
			// this has the nice side-effect that an
			// empty hash is created for the basic block.
			out.removeAllForKey(basicBlock);
			
			List<Object> symsDefined = symbolsDefined.getListForKey(basicBlock);
			if(symsDefined == null) continue;
			
			for(Object s: symsDefined){
				String symbol = (String) s;
				out.add(basicBlock, new Definition(basicBlock, symbol));
			}
			
			for(Object o: out.getListForKey(basicBlock))
				gen.add(basicBlock, o);
		}
	}

	private void initInFromParents(Long x)
	{
		List<Object> parents = parentBlocks.getListForKey(x);		
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
		List<Object> killX = symbolsDefined.getListForKey(x);
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

	private void createDDGFromReachingDefs()
	{
		for(Long basicBlock : basicBlocks){
			HashSet<Object> inForBlock = in.getListForKey(basicBlock);
			if(inForBlock == null) continue;			
			List<Object> usedSymbols = symbolsUsed.getListForKey(basicBlock);
			if(usedSymbols == null) continue;
			
			for(Object d : inForBlock){
				Definition def = (Definition) d;
				
				if(usedSymbols.contains(def.identifier))
						ddg.add(def.basicBlock, basicBlock, def.identifier);
			}
		}
	}
	
	
}
