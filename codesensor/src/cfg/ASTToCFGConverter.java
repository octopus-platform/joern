package cfg;

import java.util.Iterator;
import java.util.List;

import astnodes.ASTNode;
import astnodes.functionDef.FunctionDef;
import astnodes.statements.BlockStarter;
import astnodes.statements.CompoundStatement;
import astnodes.statements.Condition;
import astnodes.statements.DoStatement;
import astnodes.statements.ElseStatement;
import astnodes.statements.ForStatement;
import astnodes.statements.IfStatement;
import astnodes.statements.Label;
import astnodes.statements.Statement;
import astnodes.statements.WhileStatement;

public class ASTToCFGConverter {

	
	public CFG convert(FunctionDef node)
	{
		CFG cfg = convertFunctionDef(node);
		honorJumpStatements(cfg);
		return cfg;
	}
	
	private CFG convertFunctionDef(FunctionDef node)
	{
		CompoundStatement content = node.getContent();
		return convertCompoundStatement(content);
	}
	
	public CFG convertCompoundStatement(CompoundStatement content)
	{
		CFG cfg = new CFG();
		List<ASTNode> statements = content.getStatements();
		
		appendChildCFGs(cfg, statements);
		return cfg;
	}


	private void appendChildCFGs(CFG cfg, List<ASTNode> statements)
	{
		Iterator<ASTNode> it = statements.iterator();
		while(it.hasNext()){
			Statement child = (Statement) it.next();
			CFG childCFG = convertStatement(child);
			cfg.addCFG(childCFG);
		}
	}

	private CFG convertStatement(Statement node)
	{
		// FIXME: Dispatching this way isn't nice, O(n), when we
		// could be doing O(1).
		
		if(node instanceof CompoundStatement)
			return convertCompoundStatement((CompoundStatement)node);
		
		if(node instanceof IfStatement)
			return convertIfStatement((IfStatement) node);
		
		if(node instanceof WhileStatement)
			return convertWhileStatement((WhileStatement) node);
		
		if(node instanceof DoStatement)
			return convertDoStatement((DoStatement) node);
		
		if(node instanceof ForStatement)
			return convertForStatement((ForStatement) node);
		
		if(node instanceof Label)
			return convertLabel((Label) node);
		
		return defaultStatementConverter(node);
	}

	private CFG convertIfStatement(IfStatement node)
	{
		CFG cfg = new CFG();
				
		BasicBlock conditionBlock = addConditionBlock(node, cfg);
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
		
		return cfg;
	}

	private CFG convertWhileStatement(WhileStatement node)
	{
		CFG cfg = new CFG();
		
		BasicBlock conditionBlock = addConditionBlock(node, cfg);
		CFG statementCFG = addStatementBlock(node, cfg);
		BasicBlock emptyBlock = addEmptyBlock(cfg);
		
		cfg.addEdge(conditionBlock, statementCFG.getFirstBlock());
		cfg.addEdge(statementCFG.getLastBlock(), emptyBlock);
		cfg.addEdge(emptyBlock, conditionBlock);
		
		return cfg;
	}

	private CFG convertDoStatement(DoStatement node)
	{
		CFG cfg = new CFG();

		BasicBlock emptyBlock = addEmptyBlock(cfg);
		CFG statementCFG = addStatementBlock(node, cfg);
		BasicBlock conditionBlock = addConditionBlock(node, cfg);
		
		cfg.addEdge(emptyBlock, statementCFG.getFirstBlock());
		cfg.addEdge(statementCFG.getLastBlock(), conditionBlock);
		cfg.addEdge(conditionBlock, emptyBlock);
		
		return cfg;
	}
	
	private CFG convertForStatement(ForStatement node)
	{
		CFG cfg = new CFG();
		
		BasicBlock initBlock = addEmptyBlock(cfg);
		initBlock.appendNode(node.getForInitStatement());
		
		BasicBlock conditionBlock = addConditionBlock(node, cfg);
		CFG statementCFG = addStatementBlock(node, cfg);
		
		BasicBlock exprBlock = addEmptyBlock(cfg);
		exprBlock.appendNode(node.getExpression());
		
		cfg.addEdge(initBlock, conditionBlock);
		cfg.addEdge(conditionBlock, statementCFG.getFirstBlock());
		cfg.addEdge(statementCFG.getLastBlock(), exprBlock);		
		cfg.addEdge(exprBlock, conditionBlock);
		
		return cfg;
	}
	
	private BasicBlock addEmptyBlock(CFG cfg)
	{
		BasicBlock emptyBlock = new BasicBlock();
		cfg.addBasicBlock(emptyBlock);
		return emptyBlock;
	}
	
	private BasicBlock addConditionBlock(BlockStarter node, CFG cfg)
	{
		Condition condition = node.getCondition();
		BasicBlock conditionBlock = new BasicBlock();
		conditionBlock.appendNode(condition);
		cfg.addBasicBlock(conditionBlock);
		return conditionBlock;
	}

	private CFG addStatementBlock(BlockStarter node, CFG cfg)
	{
		Statement statement = node.getStatement();
		CFG statementCFG = convertStatement(statement);
		cfg.addCFG(statementCFG);
		return statementCFG;
	}
	
	private CFG convertLabel(Label node)
	{
		CFG cfg = new CFG();
		addBasicBlockForNode(node, cfg);
		cfg.labelBlock(node.getCodeStr(), cfg.getFirstBlock());
		return cfg;
	}
	
	private CFG defaultStatementConverter(ASTNode child)
	{
		CFG cfg = new CFG();
		addBasicBlockForNode(child, cfg);
		return cfg;
	}

	private void addBasicBlockForNode(ASTNode child, CFG cfg) {
		BasicBlock basicBlock = new BasicBlock();
		basicBlock.appendNode(child);
		cfg.addBasicBlock(basicBlock);
	}
	
	private void honorJumpStatements(CFG cfg)
	{
		// TODO Auto-generated method stub	
	}
	
}
