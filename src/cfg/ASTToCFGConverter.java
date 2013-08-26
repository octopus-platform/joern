package cfg;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import astnodes.ASTNode;
import astnodes.functionDef.FunctionDef;
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
		CompoundStatement content = node.getContent();
		return convertCompoundStatement(content);
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
			BasicBlock switchBlock = (BasicBlock) entry.getKey();
			List<Object> labeledBlocks = entry.getValue();
			
			for(Object labeledBlock : labeledBlocks)
				cfg.addEdge(switchBlock, (BasicBlock) labeledBlock);
		}
	}

	private void fixJumps(CFG cfg)
	{
		Collection<? extends BasicBlock> jumpStatements = cfg.getJumpStatements();
		Iterator<? extends BasicBlock> it = jumpStatements.iterator();
		
		if(jumpStatements.size() > 0){
			// add an exit-block
			
			EmptyBasicBlock emptyBasicBlock = new EmptyBasicBlock();
			cfg.addEdge(cfg.getLastBlock(), emptyBasicBlock);
			cfg.addBasicBlock(emptyBasicBlock);
		}
		
		while(it.hasNext()){
			BasicBlock basicBlock = it.next();
			ASTNode statement = basicBlock.getASTNode();
			
			jumpStatementVisitor.setCFG(cfg);
			jumpStatementVisitor.setBasicBlock(basicBlock);
			statement.accept(jumpStatementVisitor);
		}
	}
	
}
