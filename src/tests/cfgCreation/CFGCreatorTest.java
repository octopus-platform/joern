package tests.cfgCreation;


import java.util.Vector;

import org.junit.Before;


import tests.parseTreeToAST.FunctionContentTestUtil;
import astnodes.ASTNode;
import astnodes.statements.CompoundStatement;

import cfg.ASTToCFGConverter;
import cfg.BasicBlock;
import cfg.CFG;



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
