package cfg;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import astnodes.ASTNode;
import astnodes.functionDef.Parameter;
import astnodes.functionDef.ParameterList;
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
	Stack<CFGNode> loopStack = new Stack<CFGNode>();
	
	CFG getCFG() { return returnCFG; }
	
	public void visit(ParameterList paramList)
	{
		CFG cfg = new CFG();
		LinkedList<Parameter> parameters = paramList.getParameters();
		CFGNode lastParamBlock = null;
		
		for(Parameter parameter : parameters){
			addStatementForNode(parameter,cfg);
			CFGNode thisBlock = cfg.getLastStatement();
			if(lastParamBlock != null)
				cfg.addEdge(lastParamBlock, thisBlock);
			lastParamBlock = thisBlock;
		}
		
		returnCFG = cfg;
	}
	
	public void visit(CompoundStatement content)
	{
		CFG cfg = new CFG();
		List<ASTNode> statements = content.getStatements();
		
		appendChildCFGs(cfg, statements);
		
		returnCFG = cfg;
	}
	
	public void visit(ASTNode expression)
	{
		returnCFG = defaultStatementConverter(expression);
	}
	
	public void visit(ReturnStatement expression)
	{
		returnCFG = defaultStatementConverter(expression);
		returnCFG.addJumpStatement(returnCFG.getLastStatement());
	}

	public void visit(GotoStatement expression)
	{
		returnCFG = defaultStatementConverter(expression);
		returnCFG.addJumpStatement(returnCFG.getLastStatement());
	}
	
	public CFG defaultStatementConverter(ASTNode child)
	{
		CFG cfg = new CFG();
		addStatementForNode(child, cfg);
		return cfg;
	}
	
	private void appendChildCFGs(CFG cfg, List<ASTNode> statements)
	{
		Iterator<ASTNode> it = statements.iterator();
		while(it.hasNext()){
			Statement child = (Statement) it.next();
			CFG childCFG = convertStatement(child);
			cfg.addEdge(cfg.getLastStatement(), childCFG.getFirstStatement());
			cfg.addCFG(childCFG);
		}
	}
	
	public CFG convertStatement(Statement node)
	{
		returnCFG = new CFG();
		node.accept(this);
		
		// if no statement is present, return
		// a CFG containing an empty basic block.
		if(returnCFG.getNumberOfStatements() == 0)
		{
			returnCFG.addStatement(new CFGNode());
		}
		
		return returnCFG;
	}
	
	
	public void visit(IfStatement node)
	{
		CFG cfg = new CFG();
		
		CFGNode conditionBlock = addConditionBlock(node, cfg, new CFGNode());
		CFG statementCFG = addStatementBlock(node, cfg);
		CFGNode emptyBlock;
				
		cfg.addEdge(conditionBlock, statementCFG.getFirstStatement());
		
		
		ElseStatement elseNode = node.getElseNode();
		if(elseNode == null){
			emptyBlock = addEmptyStatement(cfg);
			cfg.addEdge(conditionBlock, emptyBlock);
		}else{
			Statement elseStatement = elseNode.getStatement();
			CFG elseCFG = convertStatement(elseStatement);
			cfg.addCFG(elseCFG);
			cfg.addEdge(conditionBlock, elseCFG.getFirstStatement());
			emptyBlock = addEmptyStatement(cfg);
			cfg.addEdge(elseCFG.getLastStatement(), emptyBlock);
		}
		
		cfg.addEdge(statementCFG.getLastStatement(), emptyBlock);
		
		returnCFG = cfg;
	}
	
	public void visit(ForStatement node)
	{
		CFG cfg = new CFG();
		
		CFGNode initBlock = addEmptyStatement(cfg);
		initBlock.setASTNode(node.getForInitStatement());
		
		CFGNode conditionBlock = addConditionBlock(node, cfg, new LoopBlock());
		
		loopStack.push(conditionBlock);
		CFG statementCFG = addStatementBlock(node, cfg);
		loopStack.pop();
		
		CFGNode exprBlock = addEmptyStatement(cfg);
		exprBlock.setASTNode(node.getExpression());
		
		cfg.addEdge(initBlock, conditionBlock);
		cfg.addEdge(conditionBlock, statementCFG.getFirstStatement());
		cfg.addEdge(statementCFG.getLastStatement(), exprBlock);		
		cfg.addEdge(exprBlock, conditionBlock);
		
		returnCFG = cfg;
	}
	
	public void visit(WhileStatement node)
	{
		CFG cfg = new CFG();
		
		CFGNode conditionBlock = addConditionBlock(node, cfg, new LoopBlock());
		
		loopStack.push(conditionBlock);
		CFG statementCFG = addStatementBlock(node, cfg);
		loopStack.push(conditionBlock);
		
		CFGNode emptyBlock = addEmptyStatement(cfg);
		
		cfg.addEdge(conditionBlock, statementCFG.getFirstStatement());
		cfg.addEdge(statementCFG.getLastStatement(), emptyBlock);
		cfg.addEdge(emptyBlock, conditionBlock);
		
		returnCFG = cfg;
		
	}
	
	public void visit(DoStatement node)
	{
		CFG cfg = new CFG();

		CFGNode emptyBlock = addEmptyStatement(cfg);
		
		loopStack.push(emptyBlock);
		CFG statementCFG = addStatementBlock(node, cfg);
		loopStack.pop();
		
		CFGNode conditionBlock = addConditionBlock(node, cfg, new LoopBlock());
		
		cfg.addEdge(emptyBlock, statementCFG.getFirstStatement());
		cfg.addEdge(statementCFG.getLastStatement(), conditionBlock);
		cfg.addEdge(conditionBlock, emptyBlock);
		
		returnCFG = cfg;
	}
	
	public void visit(SwitchStatement node)
	{
		CFG cfg = new CFG();
		
		CFGNode conditionBlock = addConditionBlock(node, cfg, new SwitchBlock());
		
		loopStack.push(conditionBlock);
		CFG statementCFG = addStatementBlock(node, cfg);
		loopStack.pop();
		
		CFGNode emptyBlock = addEmptyStatement(cfg);
		
		cfg.addEdge(conditionBlock, statementCFG.getFirstStatement());
		cfg.addEdge(statementCFG.getLastStatement(), emptyBlock);
	
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
		addStatementForNode(node, cfg);
		String label = node.getEscapedCodeStr();
		label = label.substring(0, label.length()-2);
		cfg.labelBlock(label, cfg.getFirstStatement());
		
		
		CFGNode surroundingSwitch = getSurroundingSwitch();
		if(surroundingSwitch != null){
			cfg.addSwitchLabel(surroundingSwitch, cfg.getFirstStatement());
		}
		
		returnCFG = cfg;
	}

	public void visit(ContinueStatement expression)
	{
		returnCFG = defaultStatementConverter(expression);
		
		CFGNode surroundingLoop = getSurroundingLoop();
		
		if(surroundingLoop == null){
			System.err.println("Warning: no surrounding loop found for continue-statement");
			return;
		}
			
		returnCFG.loopStart.put(returnCFG.getFirstStatement(), surroundingLoop);
			
	}
	
	public void visit(BreakStatement expression)
	{	
		returnCFG = defaultStatementConverter(expression);
		
		CFGNode surroundingBlock = getSurroundingBlock();
		
		if(surroundingBlock == null){
			System.err.println("Warning: no surrounding block found for break-statement");
			return;
		}
			
		returnCFG.loopStart.put(returnCFG.getFirstStatement(), surroundingBlock);
	}
		
	private CFGNode getSurroundingLoop()
	{
		for(int i = loopStack.size() - 1; i>= 0; i--){
			CFGNode statement = loopStack.get(i);
			if(!(statement instanceof SwitchBlock)){
				return statement;
			}
		}
		return null;
	}
	
	private CFGNode getSurroundingSwitch()
	{
		for(int i = loopStack.size() - 1; i>= 0; i--){
			CFGNode statement = loopStack.get(i);
			if((statement instanceof SwitchBlock)){
				return statement;
			}
		}
		return null;
	}
	
	private CFGNode getSurroundingBlock()
	{
		if(loopStack.size() == 0)
			return null;
		return loopStack.peek();
	}
	
	private CFGNode addEmptyStatement(CFG cfg)
	{
		CFGNode emptyBlock = new CFGNode();
		cfg.addStatement(emptyBlock);
		return emptyBlock;
	}
	
	private CFGNode addConditionBlock(BlockStarter node, CFG cfg, CFGNode container)
	{
		Condition condition = node.getCondition();
		
		if(condition != null)
			container.setASTNode(condition);
		
		cfg.addStatement(container);
		return container;
	}

	private CFG addStatementBlock(BlockStarter node, CFG cfg)
	{
		Statement statement = node.getStatement();
		CFG statementCFG = convertStatement(statement);
		cfg.addCFG(statementCFG);
		return statementCFG;
	}
	
	private void addStatementForNode(ASTNode child, CFG cfg)
	{
		CFGNode statement = new CFGNode();
		statement.setASTNode(child);
		cfg.addStatement(statement);
	}


}
