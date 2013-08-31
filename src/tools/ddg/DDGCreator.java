package tools.ddg;


import java.util.HashSet;
import java.util.Iterator;
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
	
	IndexHits<Long> basicBlocks;
	
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
		basicBlocks = QueryUtils.getBasicBlocksFromIndex(funcId);
		
		cacheUsesAndDefs(basicBlocks);		
		cacheParentBlocks(basicBlocks);
		cacheChildBlocks(basicBlocks);
		
		reachingDefinitions();
		
		createDDGFromReachingDefs();
		
		return ddg;
	}

	private void createDDGFromReachingDefs()
	{
		for(Long basicBlock : basicBlocks){
			HashSet<Object> inForBlock = in.getListForKey(basicBlock);
			for(Object d : inForBlock){
				Definition def = (Definition) d;
				ddg.add(def.basicBlock, basicBlock, def.identifier);
			}
		}
	}

	private void cacheUsesAndDefs(IndexHits<Long> basicBlocks)
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

	private void cacheParentBlocks(IndexHits<Long> basicBlocks)
	{
		for(Long basicBlock : basicBlocks){
			List<Long> parents = QueryUtils.getParentBasicBlocks(basicBlock);
			for(Long parent : parents){
				parentBlocks.add(basicBlock, parent);
			}
		}
	}
	
	private void cacheChildBlocks(IndexHits<Long> basicBlocks)
	{
		for(Long basicBlock : basicBlocks){
			List<Long> parents = QueryUtils.getChildBasicBlocks(basicBlock);
			for(Long parent : parents){
				parentBlocks.add(basicBlock, parent);
			}
		}
	}
	
	
	private void reachingDefinitions()
	{
		initOut();
		
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
				for(Object o: childBlocks.getListForKey(x)){
					changedNodes.add((Long) o);
				}
			}
		}
		
	}

	private void initOut()
	{
		for(Long basicBlock : basicBlocks){
			for(Object s: symbolsDefined.getListForKey(basicBlock)){
				String symbol = (String) s;
				out.add(basicBlock, new Definition(basicBlock, symbol));
			}
		}
	}

	private void initInFromParents(Long x)
	{
		List<Object> parents = parentBlocks.getListForKey(x);
	
		in.removeAllForKey(x);
		
		// in(x) = union(out(p))_{p in parents(x)}
		for(Object p : parents){
			Long parent = (Long) p;
			for (Object o : out.getListForKey(parent))
				in.add(x, o);
		}
	}

	private boolean updateOut(Long x)
	{
		boolean changed = false;
		HashSet<Object> thisOut = out.getListForKey(x);
		int oldSize = thisOut.size();
		int nCovered = 0;
		
		for(Object o : in.getListForKey(x)){
			
			if(thisOut.contains(o)){
				nCovered++;
				continue;
			}
			
			thisOut.add(o);
			changed = true;
		}
		
		// for each element that was already there,
		// we tried to add it. Hence, nothing has changed.
		if(nCovered == oldSize)
			return false;
		
		// now kill definitions of identifiers also
		// defined by this basic block
		
		List<Object> killX = symbolsDefined.getListForKey(x);
		Iterator<Object> it = thisOut.iterator();
		while(it.hasNext()){
			Definition def = (Definition) it.next();
			if(killX.contains(def.identifier))
				it.remove();
		}
		
		return changed;
	}

	
}
