package cfg;

import java.awt.List;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Vector;

public class CFG {

	Vector<BasicBlock> basicBlocks = new Vector<BasicBlock>();
	
	Edges edges = new Edges();
	
	Vector<BasicBlock> jumpStatements = new Vector<BasicBlock>();
	HashMap<String, BasicBlock> labels = new HashMap<String, BasicBlock>();
	
	public void addBasicBlock(BasicBlock newBlock)
	{
		basicBlocks.add(newBlock);
	}

	public Vector<BasicBlock> getBasicBlocks()
	{
		return basicBlocks;
	}

	public void addEdge(BasicBlock srcBlock,
			 BasicBlock dstBlock)
	{
		edges.addEdge(srcBlock, dstBlock);
	}
		

	public Edges getEdges()
	{
		return edges;
	}
	
	public BasicBlock getLastBlock()
	{
		return basicBlocks.lastElement();
	}

	public BasicBlock getFirstBlock()
	{
		return basicBlocks.firstElement();
	}

	public void addCFG(CFG otherCFG)
	{
		if(basicBlocks.size() == 0){
			replaceCFGBy(otherCFG);
			return;
		}
		
		Vector<BasicBlock> otherBlocks = otherCFG.getBasicBlocks();
		Edges otherEdges = otherCFG.getEdges();
		basicBlocks.addAll(otherBlocks);
		edges.addEdges(otherEdges);
		
		jumpStatements.addAll(otherCFG.getJumpStatements());
		labels.putAll(otherCFG.getLabels());
	}

	private Collection<? extends BasicBlock> getJumpStatements()
	{
		return jumpStatements;
	}

	public void replaceCFGBy(CFG otherCFG)
	{
		this.basicBlocks = otherCFG.basicBlocks;
		this.edges = otherCFG.edges;
		this.labels = otherCFG.labels;
		this.jumpStatements = otherCFG.jumpStatements;
	}

	public void labelBlock(String label, BasicBlock block)
	{
		labels.put(label, block);
	}

	public HashMap<String,BasicBlock> getLabels()
	{
		return labels;		
	}
	
}
