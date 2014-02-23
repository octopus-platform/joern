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
	StatementOrCondition thisStatement;
	
	void setCFG(CFG cfg)
	{
		thisCFG = cfg;
	}
	
	void setStatement(StatementOrCondition statement)
	{
		thisStatement = statement;
	}
		
	public void visit(ReturnStatement expression)
	{ 
		Edges edges = thisCFG.getEdges();
		edges.removeAllEdgesFrom(thisStatement);
		StatementOrCondition exitBlock = thisCFG.getLastStatement();
		if(exitBlock == null)
			throw new RuntimeException("error attaching return to exitBlock: no exitBlock");
		edges.addEdge(thisStatement, exitBlock);
	}
	
	public void visit(GotoStatement expression)
	{	
		String target = expression.getTarget();
		StatementOrCondition blockByLabel = thisCFG.getBlockByLabel(target);
		if(blockByLabel == null){
			throw new RuntimeException("cannot find label " + target);
		}
		
		thisCFG.getEdges().removeAllEdgesFrom(thisStatement);
		thisCFG.getEdges().addEdge(thisStatement, blockByLabel);
	}
	
	public void visit(ContinueStatement expression)
	{
		thisCFG.getEdges().removeAllEdgesFrom(thisStatement);
		StatementOrCondition outerLoop = thisCFG.getOuterLoop(thisStatement);
		thisCFG.addEdge(thisStatement, outerLoop);
	}
	
	public void visit(BreakStatement expression)
	{	
		thisCFG.getEdges().removeAllEdgesFrom(thisStatement);
		StatementOrCondition outerLoop = thisCFG.getOuterLoop(thisStatement);
		
		List<Object> edgesFrom = thisCFG.edges.getEdgesFrom(outerLoop);
		StatementOrCondition endOfLoop = (StatementOrCondition) edgesFrom.get(1);
		thisCFG.addEdge(thisStatement, endOfLoop);
	}
}
