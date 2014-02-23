package cfg;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

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
		return cfg;
	}
	
	public CFG convertFunctionDef(FunctionDef node)
	{
		ParameterList parameterList = node.getParameterList();
		CFG cfg = convertParameterList(parameterList);
		StatementOrCondition lastParamDefBlock = cfg.getLastStatement();
		
		CompoundStatement content = node.getContent();
		CFG compoundCFG = convertCompoundStatement(content);
		StatementOrCondition firstCompoundStmtBlock = compoundCFG.getFirstStatement();
		cfg.addCFG(compoundCFG);
		
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
			StatementOrCondition switchBlock = (StatementOrCondition) entry.getKey();
			List<Object> labeledBlocks = entry.getValue();
			
			for(Object labeledBlock : labeledBlocks)
				cfg.addEdge(switchBlock, (StatementOrCondition) labeledBlock);
		}
	}

	private void fixJumps(CFG cfg)
	{
		Collection<? extends StatementOrCondition> jumpStatements = cfg.getJumpStatements();
		Iterator<? extends StatementOrCondition> it = jumpStatements.iterator();
		
		// if(jumpStatements.size() > 0){
			// add an exit-block
			
			EmptyStatement emptyStatement = new EmptyStatement();
			if(cfg.getLastStatement() != null)
				cfg.addEdge(cfg.getLastStatement(), emptyStatement);
			cfg.addStatement(emptyStatement);
		// }
		
		while(it.hasNext()){
			StatementOrCondition stmt = it.next();
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
