package output.cfg;

import java.util.Vector;

public class CFG {

	Vector<BasicBlock> basicBlocks = new Vector<BasicBlock>();
	Vector<Edge> edges = new Vector<Edge>();
	
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
		edges.add(new Edge(srcBlock, dstBlock));
	}

	public Vector<Edge> getEdges()
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
		Vector<Edge> otherEdges = otherCFG.getEdges();
		basicBlocks.addAll(otherBlocks);
		edges.addAll(otherEdges);
	}

	public void replaceCFGBy(CFG otherCFG)
	{
		this.basicBlocks = otherCFG.basicBlocks;
		this.edges = otherCFG.edges;
	}
	
}
