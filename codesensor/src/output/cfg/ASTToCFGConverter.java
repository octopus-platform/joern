package output.cfg;

import java.util.Iterator;
import java.util.List;

import astnodes.ASTNode;
import astnodes.functionDef.FunctionDef;
import astnodes.statements.BlockStarter;
import astnodes.statements.CompoundStatement;
import astnodes.statements.Condition;
import astnodes.statements.ElseStatement;
import astnodes.statements.IfStatement;
import astnodes.statements.Statement;
import astnodes.statements.WhileStatement;

public class ASTToCFGConverter {

	
	public CFG convert(FunctionDef node)
	{
		return convertFunctionDef(node);
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


	private BasicBlock addEmptyBlock(CFG cfg)
	{
		BasicBlock emptyBlock = new BasicBlock();
		cfg.addBasicBlock(emptyBlock);
		return emptyBlock;
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
	
	private CFG defaultStatementConverter(ASTNode child)
	{
		CFG cfg = new CFG();
		BasicBlock basicBlock = new BasicBlock();
		basicBlock.appendNode(child);
		cfg.addBasicBlock(basicBlock);
		return cfg;
	}
	
}
