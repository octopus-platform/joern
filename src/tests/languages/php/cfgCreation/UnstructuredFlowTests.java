package tests.languages.php.cfgCreation;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Collection;

import org.junit.Test;

import cfg.CFG;
import cfg.CFGFactory;
import cfg.nodes.CFGNode;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import tests.languages.php.samples.CSVASTSamples;

public class UnstructuredFlowTests extends PHPCFGCreatorTest {

	@Test
	public void testRet() throws IOException, InvalidCSVFile
	{

		CFG cfg = getCFGForCSVLines(CSVASTSamples.retNodeStr , CSVASTSamples.retEdgeStr);
		Collection<CFGNode> vertices = cfg.getVertices();

		assertEquals(4, vertices.size());

		Object[] nodes = getNodesOfType(cfg, "ASTNodeContainer");

		CFGNode condition = (CFGNode) nodes[0];
		CFGNode bodyNode = (CFGNode) nodes[1];

		edgeExists(cfg, cfg.getEntryNode(), condition);
		edgeExists(cfg, condition, bodyNode);
		edgeExists(cfg, bodyNode, cfg.getExitNode());
		edgeExists(cfg, condition, cfg.getExitNode());

	}

	@Test
	public void testGoto() throws IOException, InvalidCSVFile
	{

		CFG cfg = getCFGForCSVLines(CSVASTSamples.gotoNodeStr , CSVASTSamples.gotoEdgeStr);

		// Since the code is not wrapped in a function, we need
		// to call fixGotoStatements manually.

		CFGFactory.fixGotoStatements(cfg);

		Collection<CFGNode> vertices = cfg.getVertices();

		assertEquals(6, vertices.size());

		Object[] nodes = getNodesOfType(cfg, "ASTNodeContainer");

		CFGNode gotoNode = (CFGNode) nodes[0];
		CFGNode fooNode = (CFGNode) nodes[1];
		CFGNode labelNode = (CFGNode) nodes[2];
		CFGNode barNode = (CFGNode) nodes[3];

		edgeExists(cfg, cfg.getEntryNode(), gotoNode);
		edgeExists(cfg, fooNode, labelNode);
		edgeExists(cfg, labelNode, barNode);
		edgeExists(cfg, barNode, cfg.getExitNode());

		edgeDoesNotExist(cfg, gotoNode, fooNode);
		edgeExists(cfg, gotoNode, labelNode);

	}

}
