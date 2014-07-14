package tests.cfgCreation;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import astnodes.ASTNode;
import astnodes.statements.ExpressionStatement;
import cfg.CFG;
import cfg.CFGNode;

public class IfBlockTests extends CFGCreatorTest
{

	@Test
	public void testIfStatementNumberOfBlocks()
	{
		String input = "if(foo){ bar(); }";
		CFG cfg = getCFGForCode(input);
		assertTrue(cfg.size() == 4);
	}

	@Test
	public void testElseIfNumberOfBlocks()
	{
		String input = "if(foo) bar(); else if(foo2) bar(2);";
		CFG cfg = getCFGForCode(input);
		assertTrue(cfg.size() == 7);
	}

	@Test
	public void testElseIfElseIfNumberOfBlocks()
	{
		String input = "if(foo1) bar1(); else if(foo2) bar2(); else if(foo3) bar3();";
		CFG cfg = getCFGForCode(input);
		assertTrue(cfg.size() == 10);
	}

	@Test
	public void testIfStatementNumberOfEdges()
	{
		String input = "if(foo){ bar(); }";
		CFG cfg = getCFGForCode(input);
		// Edges edges = cfg.getEdges();
		// assertTrue(edges.size() == 4);
		assertTrue(cfg.numberOfEdges() == 4);
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

		List<CFGNode> statements = cfg.getVertices();
		CFGNode bodyBlock = statements.get(1);
		ExpressionStatement exprStmt = (ExpressionStatement) bodyBlock
				.getASTNode();

		assertTrue(exprStmt.getEscapedCodeStr().equals("bar ( )"));
	}

	@Test
	public void testIfEdges()
	{
		String input = "if(foo){ bar(); }";
		CFG cfg = getCFGForCode(input);

		CFGNode conditionBlock = cfg.getVertices().get(0);
		CFGNode ifStatements = cfg.getVertices().get(1);
		CFGNode emptyBlock = cfg.getVertices().get(2);

		// assertTrue(cfg.getEdges().size() == 4);
		assertTrue(cfg.numberOfEdges() == 4);
		assertTrue(cfg.outDegree(conditionBlock) == 2);
		assertTrue(cfg.outDegree(ifStatements) == 1);

		// assertTrue(cfg.getAllEdgesFrom(conditionBlock).contains(ifStatements));
		// assertTrue(cfg.getAllEdgesFrom(conditionBlock).contains(emptyBlock));
		// assertTrue(cfg.getAllEdgesFrom(ifStatements).contains(emptyBlock));
		assertTrue(cfg.isConnected(conditionBlock, ifStatements));
		assertTrue(cfg.isConnected(conditionBlock, emptyBlock));
		assertTrue(cfg.isConnected(ifStatements, emptyBlock));
	}

	@Test
	public void testIfJoinWithPrevCode()
	{
		String input = "x = 10; if(foo){ bar(); }";
		CFG cfg = getCFGForCode(input);

		CFGNode prevBlock = cfg.getVertices().get(0);
		CFGNode conditionBlock = cfg.getVertices().get(1);
		CFGNode ifStatements = cfg.getVertices().get(2);
		CFGNode emptyBlock = cfg.getVertices().get(3);

		// assertTrue(cfg.getEdges().size() == 5);
		assertTrue(cfg.numberOfEdges() == 5);

		assertTrue(cfg.outDegree(conditionBlock) == 2);
		assertTrue(cfg.outDegree(ifStatements) == 1);

		// assertTrue(cfg.getAllEdgesFrom(prevBlock).contains(conditionBlock));
		// assertTrue(cfg.getAllEdgesFrom(conditionBlock).contains(ifStatements));
		// assertTrue(cfg.getAllEdgesFrom(conditionBlock).contains(emptyBlock));
		// assertTrue(cfg.getAllEdgesFrom(ifStatements).contains(emptyBlock));
		assertTrue(cfg.isConnected(prevBlock, conditionBlock));
		assertTrue(cfg.isConnected(conditionBlock, ifStatements));
		assertTrue(cfg.isConnected(conditionBlock, emptyBlock));
		assertTrue(cfg.isConnected(ifStatements, emptyBlock));
	}

	@Test
	public void testIfJoinWithNextCode()
	{
		String input = "if(foo){ bar(); } x = 10; ";
		CFG cfg = getCFGForCode(input);

		CFGNode conditionBlock = cfg.getVertices().get(0);
		CFGNode ifStatements = cfg.getVertices().get(1);
		CFGNode emptyBlock = cfg.getVertices().get(2);
		CFGNode nextBlock = cfg.getVertices().get(3);

		// assertTrue(cfg.getEdges().size() == 5);
		// assertTrue(cfg.getEdges().getEdgesFrom(conditionBlock).size() == 2);
		// assertTrue(cfg.getEdges().getEdgesFrom(ifStatements).size() == 1);
		//
		// assertTrue(cfg.getEdges().getEdgesFrom(emptyBlock).contains(nextBlock));
		// assertTrue(cfg.getEdges().getEdgesFrom(conditionBlock).contains(ifStatements));
		// assertTrue(cfg.getEdges().getEdgesFrom(conditionBlock).contains(emptyBlock));
		// assertTrue(cfg.getEdges().getEdgesFrom(ifStatements).contains(emptyBlock));

		// assertTrue(cfg.getEdges().size() == 5);
		assertTrue(cfg.numberOfEdges() == 5);
		assertTrue(cfg.outDegree(conditionBlock) == 2);
		assertTrue(cfg.outDegree(ifStatements) == 1);

		// assertTrue(cfg.getAllEdgesFrom(emptyBlock).contains(nextBlock));
		// assertTrue(cfg.getAllEdgesFrom(conditionBlock).contains(ifStatements));
		// assertTrue(cfg.getAllEdgesFrom(conditionBlock).contains(emptyBlock));
		// assertTrue(cfg.getAllEdgesFrom(ifStatements).contains(emptyBlock));
		assertTrue(cfg.isConnected(emptyBlock, nextBlock));
		assertTrue(cfg.isConnected(conditionBlock, ifStatements));
		assertTrue(cfg.isConnected(conditionBlock, emptyBlock));
		assertTrue(cfg.isConnected(ifStatements, emptyBlock));

	}

	@Test
	public void testEmptyElse()
	{
		String input = "if(foo) bar(); else {}";
		CFG cfg = getCFGForCode(input);
		// Edges edges = cfg.getEdges();
	}

	@Test
	public void testEmptyIf()
	{
		String input = "if(foo){}else bar(); ";
		CFG cfg = getCFGForCode(input);
		// Edges edges = cfg.getEdges();
	}

	@Test
	public void testIfElseNumberOfBlocks()
	{
		String input = "if(foo){ bar(); }else{ woo(); }";
		CFG cfg = getCFGForCode(input);
		assertTrue(cfg.size() == 5);
	}

}
