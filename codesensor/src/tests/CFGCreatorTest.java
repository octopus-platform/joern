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
import cfg.LoopBlock;

import tests.parsing.FineFuncContentTestUtil;
import astnodes.ASTNode;
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
		assertTrue(astNode.getEscapedCodeStr().equals("foo"));
	}

	@Test
	public void testIfStatementBody()
	{
		String input = "if(foo){ bar(); }";
		CFG cfg = getCFGForCode(input);
		
		Vector<BasicBlock> basicBlocks = cfg.getBasicBlocks();
		BasicBlock bodyBlock = basicBlocks.get(1);
		ExpressionStatement exprStmt =  (ExpressionStatement) bodyBlock.getStatements().get(0);
		
		assertTrue(exprStmt.getEscapedCodeStr().equals("bar ( )"));
	}
	
	@Test
	public void testIfEdges()
	{
		String input = "if(foo){ bar(); }";
		CFG cfg = getCFGForCode(input);
		
		BasicBlock conditionBlock = cfg.getBasicBlocks().get(0);
		BasicBlock ifStatements = cfg.getBasicBlocks().get(1);
		BasicBlock emptyBlock = cfg.getBasicBlocks().get(2);
		
		assertTrue(cfg.getEdges().size() == 3);
		assertTrue(cfg.getEdges().getEdgesFrom(conditionBlock).size() == 2);
		assertTrue(cfg.getEdges().getEdgesFrom(ifStatements).size() == 1);
		
		assertTrue(cfg.getEdges().getEdgesFrom(conditionBlock).contains(ifStatements));
		assertTrue(cfg.getEdges().getEdgesFrom(conditionBlock).contains(emptyBlock));
		assertTrue(cfg.getEdges().getEdgesFrom(ifStatements).contains(emptyBlock));
	}
	
	@Test
	public void testIfJoinWithPrevCode()
	{
		String input = "x = 10; if(foo){ bar(); }";
		CFG cfg = getCFGForCode(input);
		
		BasicBlock prevBlock = cfg.getBasicBlocks().get(0);
		BasicBlock conditionBlock = cfg.getBasicBlocks().get(1);
		BasicBlock ifStatements = cfg.getBasicBlocks().get(2);
		BasicBlock emptyBlock = cfg.getBasicBlocks().get(3);
		
		assertTrue(cfg.getEdges().size() == 4);
		assertTrue(cfg.getEdges().getEdgesFrom(conditionBlock).size() == 2);
		assertTrue(cfg.getEdges().getEdgesFrom(ifStatements).size() == 1);
		
		assertTrue(cfg.getEdges().getEdgesFrom(prevBlock).contains(conditionBlock));
		assertTrue(cfg.getEdges().getEdgesFrom(conditionBlock).contains(ifStatements));
		assertTrue(cfg.getEdges().getEdgesFrom(conditionBlock).contains(emptyBlock));
		assertTrue(cfg.getEdges().getEdgesFrom(ifStatements).contains(emptyBlock));
	}
	
	@Test
	public void testIfJoinWithNextCode()
	{
		String input = "if(foo){ bar(); } x = 10; ";
		CFG cfg = getCFGForCode(input);
		
		
		BasicBlock conditionBlock = cfg.getBasicBlocks().get(0);
		BasicBlock ifStatements = cfg.getBasicBlocks().get(1);
		BasicBlock emptyBlock = cfg.getBasicBlocks().get(2);
		BasicBlock nextBlock = cfg.getBasicBlocks().get(3);
		
		assertTrue(cfg.getEdges().size() == 4);
		assertTrue(cfg.getEdges().getEdgesFrom(conditionBlock).size() == 2);
		assertTrue(cfg.getEdges().getEdgesFrom(ifStatements).size() == 1);
		
		assertTrue(cfg.getEdges().getEdgesFrom(emptyBlock).contains(nextBlock));
		assertTrue(cfg.getEdges().getEdgesFrom(conditionBlock).contains(ifStatements));
		assertTrue(cfg.getEdges().getEdgesFrom(conditionBlock).contains(emptyBlock));
		assertTrue(cfg.getEdges().getEdgesFrom(ifStatements).contains(emptyBlock));
	}
	
	
	
	@Test
	public void testEmptyElse()
	{
		String input = "if(foo) bar(); else {}";
		CFG cfg = getCFGForCode(input);
		Edges edges = cfg.getEdges();
	}
	
	@Test
	public void testEmptyIf()
	{
		String input = "if(foo){}else bar(); ";
		CFG cfg = getCFGForCode(input);
		Edges edges = cfg.getEdges();
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
	public void testEmptyFor()
	{
		String input = "for(;;){}";
		CFG cfg = getCFGForCode(input);
		assertTrue(cfg.getBasicBlocks().get(1).getStatements().get(0) == null);
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
		System.out.println(edges.size());
		assertTrue(edges.size() == 6);
	}
	
	@Test
	public void testTwoInstructions()
	{
		String input = "x = 10; y = 20;";
		CFG cfg = getCFGForCode(input);
		assertTrue(cfg.getBasicBlocks().size() == 2);
	}
	
	@Test
	public void testLinkBetweenBlocks()
	{
		String input = "x = 10; y = 20;";
		CFG cfg = getCFGForCode(input);
		Edges edges = cfg.getEdges();
		assertTrue(cfg.getEdges().size() == 1);
	}
	
	
	@Test
	public void testAssignmentASTLink()
	{
		String input = "x = 10;";
		CFG cfg = getCFGForCode(input);
		BasicBlock basicBlock = cfg.getBasicBlocks().get(0);
		ASTNode astNode = basicBlock.getStatements().get(0);
		assertTrue(astNode != null);
		System.out.println(astNode.getClass().getSimpleName());
	}
	
	
	@Test
	public void testAssignmentInDecl()
	{
		String input = "int x = 10;";
		CFG cfg = getCFGForCode(input);
		assertTrue(cfg.getBasicBlocks().size() == 1);
	}
	
	
	private ASTNode getConditionNode(CFG cfg)
	{
		Vector<BasicBlock> basicBlocks = cfg.getBasicBlocks();
		BasicBlock conditionBlock = basicBlocks.get(0);
		ASTNode astNode = conditionBlock.getStatements().get(0);
		return astNode;
	}
	
}
