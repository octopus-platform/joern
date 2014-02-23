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

	// As indicated by the type, these are statements OR conditions
	Vector<StatementOrCondition> statements = new Vector<StatementOrCondition>();
	
	Edges edges = new Edges();
	SwitchLabels switchLabels = new SwitchLabels();
	
	Vector<StatementOrCondition> jumpStatements = new Vector<StatementOrCondition>();
	HashMap<String, StatementOrCondition> labels = new HashMap<String, StatementOrCondition>();
	
	HashMap<StatementOrCondition, StatementOrCondition> loopStart = new HashMap<StatementOrCondition, StatementOrCondition>();
	
	public void addCFG(CFG otherCFG)
	{
		if(statements.size() == 0){
			replaceCFGBy(otherCFG);
			return;
		}
		
		Vector<StatementOrCondition> otherBlocks = otherCFG.getStatements();
		Edges otherEdges = otherCFG.getEdges();
		switchLabels.addMultiHashMap(otherCFG.getSwitchLabels());
		statements.addAll(otherBlocks);
		edges.addEdges(otherEdges);
		
		jumpStatements.addAll(otherCFG.getJumpStatements());
		labels.putAll(otherCFG.getLabels());
		
		loopStart.putAll(otherCFG.loopStart);
		
	}

	public void replaceCFGBy(CFG otherCFG)
	{
		this.statements = otherCFG.statements;
		this.edges = otherCFG.edges;
		this.switchLabels = otherCFG.switchLabels;
		this.labels = otherCFG.labels;
		this.jumpStatements = otherCFG.jumpStatements;
		this.loopStart = otherCFG.loopStart;
	}

	
	public StatementOrCondition getBlockByLabel(String label)
	{
		return labels.get(label);
	}
	
	public void addSwitchLabel(StatementOrCondition surroundingSwitch,
			StatementOrCondition labeledBlock)
	{
		switchLabels.add(surroundingSwitch, labeledBlock);	
	}

	public StatementOrCondition getOuterLoop(StatementOrCondition thisStatement)
	{
		return loopStart.get(thisStatement);
	}

	public SwitchLabels getSwitchLabels()
	{
		return switchLabels;
	}
	
	public StatementOrCondition getLastStatement()
	{
		try{
			return statements.lastElement();
		}catch(RuntimeException ex)
		{
			return null;
		}
	}
	
	public StatementOrCondition getFirstStatement()
	{	
		try{
			return statements.firstElement();
		}catch(RuntimeException ex)
		{
			return null;
		}
	}
	
	public void labelBlock(String label, StatementOrCondition block) { labels.put(label, block); }
	public void addStatement(StatementOrCondition newBlock) { statements.add(newBlock); }
	public void addEdge(StatementOrCondition srcBlock,
			 StatementOrCondition dstBlock){ edges.addEdge(srcBlock, dstBlock); }
	
	public int getNumberOfStatements(){ return statements.size(); }
	
	public Collection<? extends StatementOrCondition> getJumpStatements() { return jumpStatements; }
	public HashMap<String,StatementOrCondition> getLabels(){ return labels; }
	public Edges getEdges() { return edges; }
	public Vector<StatementOrCondition> getStatements(){ return statements; }

	public void addJumpStatement(StatementOrCondition block)
	{
		this.jumpStatements.add(block);
	}
	
}
