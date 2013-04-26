package cfg;

import java.util.Collection;
import java.util.HashMap;
import java.util.Vector;

// The first node added is the entry node
// The last node added is the exitNode
// For nodes with two outgoing edges,
// the first edge is the one taken if
// condition evaluates to true.


public class CFG {

	Vector<BasicBlock> basicBlocks = new Vector<BasicBlock>();
	
	Edges edges = new Edges();
	SwitchLabels switchLabels = new SwitchLabels();
	
	Vector<BasicBlock> jumpStatements = new Vector<BasicBlock>();
	HashMap<String, BasicBlock> labels = new HashMap<String, BasicBlock>();
	
	HashMap<BasicBlock, BasicBlock> loopStart = new HashMap<BasicBlock, BasicBlock>();
	
	public void addCFG(CFG otherCFG)
	{
		if(basicBlocks.size() == 0){
			replaceCFGBy(otherCFG);
			return;
		}
		
		Vector<BasicBlock> otherBlocks = otherCFG.getBasicBlocks();
		Edges otherEdges = otherCFG.getEdges();
		switchLabels.addMultiHashMap(otherCFG.getSwitchLabels());
		basicBlocks.addAll(otherBlocks);
		edges.addEdges(otherEdges);
		
		jumpStatements.addAll(otherCFG.getJumpStatements());
		labels.putAll(otherCFG.getLabels());
		
		loopStart.putAll(otherCFG.loopStart);
		
	}

	public void replaceCFGBy(CFG otherCFG)
	{
		this.basicBlocks = otherCFG.basicBlocks;
		this.edges = otherCFG.edges;
		this.switchLabels = otherCFG.switchLabels;
		this.labels = otherCFG.labels;
		this.jumpStatements = otherCFG.jumpStatements;
		this.loopStart = otherCFG.loopStart;
	}

	
	public BasicBlock getBlockByLabel(String label)
	{
		return labels.get(label);
	}
	
	public void addSwitchLabel(BasicBlock surroundingSwitch,
			BasicBlock labeledBlock)
	{
		switchLabels.add(surroundingSwitch, labeledBlock);	
	}

	public BasicBlock getOuterLoop(BasicBlock thisBasicBlock)
	{
		return loopStart.get(thisBasicBlock);
	}

	public SwitchLabels getSwitchLabels()
	{
		return switchLabels;
	}
	
	public BasicBlock getLastBlock()
	{
		try{
			return basicBlocks.lastElement();
		}catch(RuntimeException ex)
		{
			return null;
		}
	}
	
	public BasicBlock getFirstBlock()
	{	
		try{
			return basicBlocks.firstElement();
		}catch(RuntimeException ex)
		{
			return null;
		}
	}
	
	public void labelBlock(String label, BasicBlock block) { labels.put(label, block); }
	public void addBasicBlock(BasicBlock newBlock) { basicBlocks.add(newBlock); }
	public void addEdge(BasicBlock srcBlock,
			 BasicBlock dstBlock){ edges.addEdge(srcBlock, dstBlock); }
	
	public int getNumberOfBasicBlocks(){ return basicBlocks.size(); }
	
	public Collection<? extends BasicBlock> getJumpStatements() { return jumpStatements; }
	public HashMap<String,BasicBlock> getLabels(){ return labels; }
	public Edges getEdges() { return edges; }
	public Vector<BasicBlock> getBasicBlocks(){ return basicBlocks; }
	
}
