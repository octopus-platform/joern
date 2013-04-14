package tests;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import cfg.ASTToCFGConverter;
import cfg.BasicBlock;
import cfg.CFG;
import cfg.Edges;

import tests.parsing.FineFuncContentTestUtil;
import astnodes.ASTNode;
import astnodes.expressions.CallExpression;
import astnodes.statements.CompoundStatement;
import astnodes.statements.ExpressionStatement;


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
		CompoundStatement contentItem = (CompoundStatement) FineFuncContentTestUtil.parseAndWalk(input);
		return converter.convertCompoundStatement(contentItem);
	}
	
	@Test
	public void testSingleAssignmentBlockNumber()
	{
		String input = "x = y;";
		CFG cfg = getCFGForCode(input);
		assertTrue(cfg.getBasicBlocks().size() == 1);
	}

	@Test
	public void testSingleCallBlockNumber()
	{
		String input = "foo();";
		CFG cfg = getCFGForCode(input);
		assertTrue(cfg.getBasicBlocks().size() == 1);
	}
	
	@Test
	public void testIfStatementNumberOfBlocks()
	{
		String input = "if(foo){ bar(); }";
		CFG cfg = getCFGForCode(input);
		assertTrue(cfg.getBasicBlocks().size() == 3);
	}
	
	@Test
	public void testIfStatementNumberOfEdges()
	{
		String input = "if(foo){ bar(); }";
		CFG cfg = getCFGForCode(input);
		Edges edges = cfg.getEdges();
		assertTrue(edges.size() == 3);
	}
	
	
	@Test
	public void testIfStatementCondition()
	{
		String input = "if(foo){ bar(); }";
		CFG cfg = getCFGForCode(input);
		ASTNode astNode = getConditionNode(cfg);
		assertTrue(astNode.getCodeStr().equals("foo"));
	}

	@Test
	public void testIfStatementBody()
	{
		String input = "if(foo){ bar(); }";
		CFG cfg = getCFGForCode(input);
		
		Vector<BasicBlock> basicBlocks = cfg.getBasicBlocks();
		BasicBlock bodyBlock = basicBlocks.get(1);
		ExpressionStatement exprStmt =  (ExpressionStatement) bodyBlock.getStatements().get(0);
		
		assertTrue(exprStmt.getCodeStr().equals("bar ( )"));
	}
	
	@Test
	public void testIfElseNumberOfBlocks()
	{
		String input = "if(foo){ bar(); }else{ woo(); }";
		CFG cfg = getCFGForCode(input);
		assertTrue(cfg.getBasicBlocks().size() == 4);
	}
	
	@Test
	public void testWhileNumberOfBlocks()
	{
		String input = "while(foo){ bar(); }";
		CFG cfg = getCFGForCode(input);
		assertTrue(cfg.getBasicBlocks().size() == 3);
	}
	
	@Test
	public void testDoNumberOfBlocks()
	{
		String input = "do{ bar(); }while(foo);";
		CFG cfg = getCFGForCode(input);
		assertTrue(cfg.getBasicBlocks().size() == 3);
	}
	

	@Test
	public void testForNumberOfBlocks()
	{
		String input = "for(i = 0; i < 10; i ++){ foo(); }";
		CFG cfg = getCFGForCode(input);
		assertTrue(cfg.getBasicBlocks().size() == 4);
	}
	
	@Test
	public void testLabel()
	{
		String input = "foo: foo();";
		CFG cfg = getCFGForCode(input);
		HashMap<String, BasicBlock> labels = cfg.getLabels();
		System.out.println(labels.size());
		assertTrue(labels.size() == 1);
	}
	
	@Test
	public void testSwitchNumberOfEdges()
	{
		String input = "switch(foo){ case 1: case2: case 3: }";
		CFG cfg = getCFGForCode(input);
		Edges edges = cfg.getEdges();
		assertTrue(edges.size() == 6);
	}
	
	private ASTNode getConditionNode(CFG cfg)
	{
		Vector<BasicBlock> basicBlocks = cfg.getBasicBlocks();
		BasicBlock conditionBlock = basicBlocks.get(0);
		ASTNode astNode = conditionBlock.getStatements().get(0);
		return astNode;
	}
	
}
