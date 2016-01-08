package tests.languages.php.cfgCreation;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Collection;

import org.junit.Test;

import cfg.CFG;
import cfg.nodes.CFGNode;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import tests.languages.php.samples.CSVASTSamples;

public class UnstructuredFlowTests extends PHPCFGCreatorTest {

	@Test
	public void testRet() throws IOException, InvalidCSVFile
	{

		CFG cfg = getCFGForCSVLines(CSVASTSamples.retNodeStr , CSVASTSamples.retEdgeStr);
		Collection<CFGNode> vertices = cfg.getVertices();

		assertEquals(vertices.size(), 4);

		Object[] nodes = getNodesOfType(cfg, "ASTNodeContainer");

		CFGNode condition = (CFGNode) nodes[0];
		CFGNode bodyNode = (CFGNode) nodes[1];

		edgeExists(cfg, cfg.getEntryNode(), condition);
		edgeExists(cfg, condition, bodyNode);
		edgeExists(cfg, bodyNode, cfg.getExitNode());
		edgeExists(cfg, condition, cfg.getExitNode());

	}

}
