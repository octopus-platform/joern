package tests.cfgCreation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import tests.parseTreeToAST.FunctionContentTestUtil;
import astnodes.ASTNode;
import astnodes.statements.CompoundStatement;
import astnodes.statements.ExpressionStatement;
import cfg.ASTToCFGConverter;
import cfg.BasicBlock;
import cfg.CFG;
import cfg.Edges;


public class CFGCreatorTest
{
	ASTToCFGConverter converter;
	
	@Before
	public void init()
	{
		converter = new ASTToCFGConverter();
	}
	
	public CFG getCFGForCode(String input)
	{
		CompoundStatement contentItem = (CompoundStatement) FunctionContentTestUtil.parseAndWalk(input);
		return converter.convertCompoundStatement(contentItem);
	}
	
	protected ASTNode getConditionNode(CFG cfg)
	{
		Vector<BasicBlock> basicBlocks = cfg.getBasicBlocks();
		BasicBlock conditionBlock = basicBlocks.get(0);
		ASTNode astNode = conditionBlock.getASTNode();
		return astNode;
	}
	
}
