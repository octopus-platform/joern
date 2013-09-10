package cfg;

import java.util.List;

import astnodes.statements.BreakStatement;
import astnodes.statements.ContinueStatement;
import astnodes.statements.GotoStatement;
import astnodes.statements.ReturnStatement;
import astwalking.ASTNodeVisitor;

public class JumpStatementVisitor extends ASTNodeVisitor
{
	CFG thisCFG;
	BasicBlock thisBasicBlock;
	
	void setCFG(CFG cfg)
	{
		thisCFG = cfg;
	}
	
	void setBasicBlock(BasicBlock basicBlock)
	{
		thisBasicBlock = basicBlock;
	}
		
	public void visit(ReturnStatement expression)
	{ 
		Edges edges = thisCFG.getEdges();
		edges.removeAllEdgesFrom(thisBasicBlock);
		BasicBlock exitBlock = thisCFG.getLastBlock();
		if(exitBlock == null)
			throw new RuntimeException("error attaching return to exitBlock: no exitBlock");
		edges.addEdge(thisBasicBlock, exitBlock);
	}
	
	public void visit(GotoStatement expression)
	{	
		String target = expression.getTarget();
		BasicBlock blockByLabel = thisCFG.getBlockByLabel(target);
		if(blockByLabel == null){
			throw new RuntimeException("cannot find label " + target);
		}
		
		thisCFG.getEdges().removeAllEdgesFrom(thisBasicBlock);
		thisCFG.getEdges().addEdge(thisBasicBlock, blockByLabel);
	}
	
	public void visit(ContinueStatement expression)
	{
		thisCFG.getEdges().removeAllEdgesFrom(thisBasicBlock);
		BasicBlock outerLoop = thisCFG.getOuterLoop(thisBasicBlock);
		thisCFG.addEdge(thisBasicBlock, outerLoop);
	}
	
	public void visit(BreakStatement expression)
	{	
		thisCFG.getEdges().removeAllEdgesFrom(thisBasicBlock);
		BasicBlock outerLoop = thisCFG.getOuterLoop(thisBasicBlock);
		
		List<Object> edgesFrom = thisCFG.edges.getEdgesFrom(outerLoop);
		BasicBlock endOfLoop = (BasicBlock) edgesFrom.get(1);
		thisCFG.addEdge(thisBasicBlock, endOfLoop);
	}
}
