package cfg;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import astnodes.ASTNode;
import astnodes.statements.BlockStarter;
import astnodes.statements.BreakStatement;
import astnodes.statements.CompoundStatement;
import astnodes.statements.Condition;
import astnodes.statements.ContinueStatement;
import astnodes.statements.DoStatement;
import astnodes.statements.ElseStatement;
import astnodes.statements.ForStatement;
import astnodes.statements.GotoStatement;
import astnodes.statements.IfStatement;
import astnodes.statements.Label;
import astnodes.statements.ReturnStatement;
import astnodes.statements.Statement;
import astnodes.statements.SwitchStatement;
import astnodes.statements.WhileStatement;
import astwalking.ASTNodeVisitor;

// This visitor is used to create a CFG from an AST
// while considering only structured control flow statements,
// e.g., for, while, do.

// Once the CFG has been created using this Visitor, the
// JumpStatementVisitor is used to account for unstructured
// control flow statements, e.g., return, goto, continue, break.

public class StructuredFlowVisitor extends ASTNodeVisitor
{
	CFG returnCFG;
	Stack<BasicBlock> loopStack = new Stack<BasicBlock>();
	
	CFG getCFG() { return returnCFG; }
	
	public void visit(ASTNode expression)
	{
		returnCFG = defaultStatementConverter(expression);
	}
	
	public void visit(ReturnStatement expression)
	{
		returnCFG = defaultStatementConverter(expression);
		returnCFG.addJumpStatement(returnCFG.getLastBlock());
	}

	public void visit(GotoStatement expression)
	{
		returnCFG = defaultStatementConverter(expression);
		returnCFG.addJumpStatement(returnCFG.getLastBlock());
	}
	
	public CFG defaultStatementConverter(ASTNode child)
	{
		CFG cfg = new CFG();
		addBasicBlockForNode(child, cfg);
		return cfg;
	}
	
	public void visit(CompoundStatement content)
	{
		CFG cfg = new CFG();
		List<ASTNode> statements = content.getStatements();
		
		appendChildCFGs(cfg, statements);
		
		returnCFG = cfg;
	}
	
	private void appendChildCFGs(CFG cfg, List<ASTNode> statements)
	{
		Iterator<ASTNode> it = statements.iterator();
		while(it.hasNext()){
			Statement child = (Statement) it.next();
			CFG childCFG = convertStatement(child);
			cfg.addEdge(cfg.getLastBlock(), childCFG.getFirstBlock());
			cfg.addCFG(childCFG);
		}
	}
	
	public CFG convertStatement(Statement node)
	{
		returnCFG = new CFG();
		node.accept(this);
		
		// if no statement is present, return
		// a CFG containing an empty basic block.
		if(returnCFG.getNumberOfBasicBlocks() == 0)
		{
			returnCFG.addBasicBlock(new EmptyBasicBlock());
		}
		
		return returnCFG;
	}
	
	
	public void visit(IfStatement node)
	{
		CFG cfg = new CFG();
		
		BasicBlock conditionBlock = addConditionBlock(node, cfg, new BasicBlock());
		CFG statementCFG = addStatementBlock(node, cfg);
		BasicBlock emptyBlock = addEmptyBlock(cfg);
				
		cfg.addEdge(conditionBlock, statementCFG.getFirstBlock());
		cfg.addEdge(statementCFG.getLastBlock(), emptyBlock);
		
		ElseStatement elseNode = node.getElseNode();
		if(elseNode == null){
			cfg.addEdge(conditionBlock, emptyBlock);
		}else{
			Statement elseStatement = elseNode.getStatement();
			CFG elseCFG = convertStatement(elseStatement);
			cfg.addCFG(elseCFG);
			cfg.addEdge(conditionBlock, elseCFG.getFirstBlock());
			cfg.addEdge(elseCFG.getLastBlock(), emptyBlock);
		}
		
		returnCFG = cfg;
	}
	
	public void visit(ForStatement node)
	{
		CFG cfg = new CFG();
		
		BasicBlock initBlock = addEmptyBlock(cfg);
		initBlock.appendNode(node.getForInitStatement());
		
		BasicBlock conditionBlock = addConditionBlock(node, cfg, new LoopBlock());
		
		loopStack.push(conditionBlock);
		CFG statementCFG = addStatementBlock(node, cfg);
		loopStack.pop();
		
		BasicBlock exprBlock = addEmptyBlock(cfg);
		exprBlock.appendNode(node.getExpression());
		
		cfg.addEdge(initBlock, conditionBlock);
		cfg.addEdge(conditionBlock, statementCFG.getFirstBlock());
		cfg.addEdge(statementCFG.getLastBlock(), exprBlock);		
		cfg.addEdge(exprBlock, conditionBlock);
		
		returnCFG = cfg;
	}
	
	public void visit(WhileStatement node)
	{
		CFG cfg = new CFG();
		
		BasicBlock conditionBlock = addConditionBlock(node, cfg, new LoopBlock());
		
		loopStack.push(conditionBlock);
		CFG statementCFG = addStatementBlock(node, cfg);
		loopStack.push(conditionBlock);
		
		BasicBlock emptyBlock = addEmptyBlock(cfg);
		
		cfg.addEdge(conditionBlock, statementCFG.getFirstBlock());
		cfg.addEdge(statementCFG.getLastBlock(), emptyBlock);
		cfg.addEdge(emptyBlock, conditionBlock);
		
		returnCFG = cfg;
		
	}
	
	public void visit(DoStatement node)
	{
		CFG cfg = new CFG();

		BasicBlock emptyBlock = addEmptyBlock(cfg);
		
		loopStack.push(emptyBlock);
		CFG statementCFG = addStatementBlock(node, cfg);
		loopStack.pop();
		
		BasicBlock conditionBlock = addConditionBlock(node, cfg, new LoopBlock());
		
		cfg.addEdge(emptyBlock, statementCFG.getFirstBlock());
		cfg.addEdge(statementCFG.getLastBlock(), conditionBlock);
		cfg.addEdge(conditionBlock, emptyBlock);
		
		returnCFG = cfg;
	}
	
	public void visit(SwitchStatement node)
	{
		CFG cfg = new CFG();
		
		BasicBlock conditionBlock = addConditionBlock(node, cfg, new SwitchBlock());
		
		loopStack.push(conditionBlock);
		CFG statementCFG = addStatementBlock(node, cfg);
		loopStack.pop();
		
		BasicBlock emptyBlock = addEmptyBlock(cfg);
		
		cfg.addEdge(conditionBlock, statementCFG.getFirstBlock());
		cfg.addEdge(statementCFG.getLastBlock(), emptyBlock);
	
		// HACK: We're adding an edge from the condition
		// to the the end of the switch-statement here
		// so that in the JumpStatementVisitor, we can
		// derive the end of the switch-statement from
		// the start of the switch statement
		// This edge is removed by the JumpStatemetVisitor
		
		cfg.addEdge(conditionBlock, emptyBlock);
	
		returnCFG = cfg;
		
	}
	
	public void visit(Label node)
	{
		CFG cfg = new CFG();
		addBasicBlockForNode(node, cfg);
		String label = node.getEscapedCodeStr();
		label = label.substring(0, label.length()-2);
		cfg.labelBlock(label, cfg.getFirstBlock());
		
		
		BasicBlock surroundingSwitch = getSurroundingSwitch();
		if(surroundingSwitch != null){
			cfg.addSwitchLabel(surroundingSwitch, cfg.getFirstBlock());
		}
		
		returnCFG = cfg;
	}

	public void visit(ContinueStatement expression)
	{
		returnCFG = defaultStatementConverter(expression);
		
		BasicBlock surroundingLoop = getSurroundingLoop();
		
		if(surroundingLoop == null)
			throw new RuntimeException("Error: no surrounding loop found for continue-statement");
		
		returnCFG.loopStart.put(returnCFG.getFirstBlock(), surroundingLoop);
			
	}
	
	public void visit(BreakStatement expression)
	{	
		returnCFG = defaultStatementConverter(expression);
		
		BasicBlock surroundingBlock = getSurroundingBlock();
		if(surroundingBlock == null)
			throw new RuntimeException("Error: no surrounding block for break statement");
		
		returnCFG.loopStart.put(returnCFG.getFirstBlock(), surroundingBlock);
	}
		
	private BasicBlock getSurroundingLoop()
	{
		for(int i = loopStack.size() - 1; i>= 0; i--){
			BasicBlock basicBlock = loopStack.get(i);
			if(!(basicBlock instanceof SwitchBlock)){
				return basicBlock;
			}
		}
		return null;
	}
	
	private BasicBlock getSurroundingSwitch()
	{
		for(int i = loopStack.size() - 1; i>= 0; i--){
			BasicBlock basicBlock = loopStack.get(i);
			if((basicBlock instanceof SwitchBlock)){
				return basicBlock;
			}
		}
		return null;
	}
	
	private BasicBlock getSurroundingBlock()
	{
		if(loopStack.size() == 0)
			return null;
		return loopStack.peek();
	}
	
	private BasicBlock addEmptyBlock(CFG cfg)
	{
		BasicBlock emptyBlock = new EmptyBasicBlock();
		cfg.addBasicBlock(emptyBlock);
		return emptyBlock;
	}
	
	private BasicBlock addConditionBlock(BlockStarter node, CFG cfg, BasicBlock container)
	{
		Condition condition = node.getCondition();
		container.appendNode(condition);
		cfg.addBasicBlock(container);
		return container;
	}

	private CFG addStatementBlock(BlockStarter node, CFG cfg)
	{
		Statement statement = node.getStatement();
		CFG statementCFG = convertStatement(statement);
		cfg.addCFG(statementCFG);
		return statementCFG;
	}
	
	private void addBasicBlockForNode(ASTNode child, CFG cfg)
	{
		BasicBlock basicBlock = new BasicBlock();
		basicBlock.appendNode(child);
		cfg.addBasicBlock(basicBlock);
	}


}
