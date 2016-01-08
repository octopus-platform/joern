package tests.languages.php.cfgCreation;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Collection;

import org.junit.Test;

import cfg.CFG;
import cfg.nodes.CFGNode;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import tests.languages.php.samples.CSVASTSamples;

public class StructuredFlowTests extends PHPCFGCreatorTest {

	@Test
	public void testIfAndElseIf() throws IOException, InvalidCSVFile
	{
		CFG cfg = getCFGForCSVLines(CSVASTSamples.ifStatementNodeStr, CSVASTSamples.ifStatementEdgeStr);
		Collection<CFGNode> vertices = cfg.getVertices();

		assertEquals(vertices.size(), 5);

		// Make sure there is exactly one condition node for each predicate

		assertEquals(getNodesOfType(cfg, "ASTNodeContainer").length, 3);
	}

	@Test
	public void testWhile() throws IOException, InvalidCSVFile
	{
		CFG cfg = getCFGForCSVLines(CSVASTSamples.whileNodeStr, CSVASTSamples.whileEdgeStr);

		Object[] conditions = getNodesOfType(cfg, "ASTNodeContainer");
		assertEquals(conditions.length, 1);
		CFGNode onlyCondition = (CFGNode) conditions[0];

		edgeExists(cfg, cfg.getEntryNode(), onlyCondition);
		edgeExists(cfg, onlyCondition, onlyCondition);
		edgeExists(cfg, onlyCondition, cfg.getExitNode());
	}

	// do {} while($foo);

	@Test
	public void testDo() throws IOException, InvalidCSVFile
	{
		CFG cfg = getCFGForCSVLines(CSVASTSamples.doNodeStr , CSVASTSamples.doEdgeStr);

		Object[] conditions = getNodesOfType(cfg, "ASTNodeContainer");
		assertEquals(conditions.length, 1);
		CFGNode onlyCondition = (CFGNode) conditions[0];

		edgeExists(cfg, cfg.getEntryNode(), onlyCondition);
		edgeExists(cfg, onlyCondition, onlyCondition);
		edgeExists(cfg, onlyCondition, cfg.getExitNode());

	}


	// for ($i = 0, $j = 1; $i < 3; $i++, $j++) {}

	@Test
	public void testFor() throws IOException, InvalidCSVFile
	{
		CFG cfg = getCFGForCSVLines(CSVASTSamples.forNodeStr, CSVASTSamples.forEdgeStr);

		assertEquals(cfg.getVertices().size(), 5);

		Object[] expressions = getNodesOfType(cfg, "ASTNodeContainer");
		assertEquals(expressions.length, 3);

		// TODO: we don't really care about the order in which expression
		// nodes are stored in the CFG, but this test does.

		CFGNode condition = (CFGNode) expressions[0];
		CFGNode forInit = (CFGNode) expressions[1];
		CFGNode forInc = (CFGNode) expressions[2];

		edgeExists(cfg, cfg.getEntryNode(), forInit);
		edgeExists(cfg, forInit, condition);
		edgeExists(cfg, condition, forInc);
		edgeExists(cfg, condition, cfg.getExitNode());
	}

	@Test
	public void testForEach() throws IOException, InvalidCSVFile
	{
		CFG cfg = getCFGForCSVLines(CSVASTSamples.foreachNodeStr, CSVASTSamples.foreachEdgeStr);
		// TODO
		System.out.println(cfg);
	}

}
