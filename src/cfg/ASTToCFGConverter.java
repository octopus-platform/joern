package cfg;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;

import astnodes.ASTNode;
import astnodes.functionDef.FunctionDef;
import astnodes.functionDef.ParameterList;
import astnodes.statements.CompoundStatement;


public class ASTToCFGConverter {

	private StructuredFlowVisitor structuredFlowVisitor = new StructuredFlowVisitor();
	private JumpStatementVisitor jumpStatementVisitor = new JumpStatementVisitor();
	
	public CFG convert(FunctionDef node)
	{
		CFG cfg = convertFunctionDef(node);
		markCFGNodes(cfg);
		return cfg;
	}
	
	private void markCFGNodes(CFG cfg)
	{
		Vector<CFGNode> statements = cfg.getStatements();
		for(CFGNode statement: statements)
			statement.markAsCFGNode();
	}

	private CFG convertFunctionDef(FunctionDef node)
	{
		// create a CFG for the parameter list
		
		ParameterList parameterList = node.getParameterList();
		CFG cfg = convertParameterList(parameterList);
		CFGNode lastParamDefBlock = cfg.getLastStatement();
		
		// create a CFG for the compound statement
		
		CompoundStatement content = node.getContent();
		CFG compoundCFG = convertCompoundStatement(content);
		CFGNode firstCompoundStmtBlock = compoundCFG.getFirstStatement();

		// add compound statement cfg to parameter list CFG
		
		cfg.addCFG(compoundCFG);
		
		// create an edge from the last parameter to the first
		// statement from the compound statement if necessary.
		
		if(lastParamDefBlock != null && firstCompoundStmtBlock != null){
			cfg.addEdge(lastParamDefBlock, firstCompoundStmtBlock);
		}
		
		return cfg;
	}

	private CFG convertParameterList(ParameterList parameterList)
	{
		parameterList.accept(structuredFlowVisitor);
		CFG cfg = structuredFlowVisitor.getCFG();
		return cfg;
	}

	public CFG convertCompoundStatement(CompoundStatement content)
	{
		content.accept(structuredFlowVisitor);
		CFG cfg = structuredFlowVisitor.getCFG();
		honorJumpStatements(cfg);
		return cfg;
	}
	
	private void honorJumpStatements(CFG cfg)
	{
		fixJumps(cfg);
		fixSwitchBlocks(cfg);
	}

	private void fixSwitchBlocks(CFG cfg)
	{
		SwitchLabels switchLabels = cfg.getSwitchLabels();
		Set<Entry<Object, List<Object>>> entrySet = switchLabels.hashMap.entrySet();
		Iterator<Entry<Object, List<Object>>> it = entrySet.iterator();
		
		while(it.hasNext()){
			Entry<Object, List<Object>> entry = it.next();
			CFGNode switchBlock = (CFGNode) entry.getKey();
			List<Object> labeledBlocks = entry.getValue();
			
			for(Object labeledBlock : labeledBlocks)
				cfg.addEdge(switchBlock, (CFGNode) labeledBlock);
		}
	}

	private void fixJumps(CFG cfg)
	{
		Collection<? extends CFGNode> jumpStatements = cfg.getJumpStatements();
		Iterator<? extends CFGNode> it = jumpStatements.iterator();
		
		// if(jumpStatements.size() > 0){
			// add an exit-block
			
			CFGNode emptyStatement = new CFGNode();
			if(cfg.getLastStatement() != null)
				cfg.addEdge(cfg.getLastStatement(), emptyStatement);
			cfg.addStatement(emptyStatement);
		// }
		
		while(it.hasNext()){
			CFGNode stmt = it.next();
			ASTNode statement = stmt.getASTNode();
			
			jumpStatementVisitor.setCFG(cfg);
			jumpStatementVisitor.setStatement(stmt);
			
			try{
				statement.accept(jumpStatementVisitor);
			}catch(RuntimeException ex){
				System.err.println("While fixing jumps: " + ex.getMessage());
			}
		
		}
	}
	
}
