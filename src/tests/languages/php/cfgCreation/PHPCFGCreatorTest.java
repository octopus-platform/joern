package tests.languages.php.cfgCreation;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Collection;

import ast.ASTNode;
import cfg.CFG;
import cfg.CFGEdge;
import cfg.nodes.CFGNode;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import languages.php.cfg.PHPCFGFactory;
import tests.languages.php.PHPCSVBasedTest;

public class PHPCFGCreatorTest extends PHPCSVBasedTest {


	protected ASTNode getASTForCSVLines(String nodeLines, String edgeLines)
			throws IOException, InvalidCSVFile
	{
		handle(nodeLines, edgeLines);

		return ast.getNodeWithLowestId();
	}

	protected CFG getCFGForCSVLines(String nodeLines, String edgeLines)
			throws IOException, InvalidCSVFile
	{
		ASTNode anAST = getASTForCSVLines(nodeLines, edgeLines);

		// This is a bit clumsy: to ensure that the structured flow visitor
		// is initialized correctly, we need to create a PHPCFGFactory
		// object despite the fact that we're only using the factory's static
		// methods.

		PHPCFGFactory phpcfgFactory = new PHPCFGFactory();
		return PHPCFGFactory.convert(anAST);
	}

	protected Object [] getNodesOfType(CFG cfg, String typeName)
	{
		Collection<CFGNode> vertices = cfg.getVertices();

		return vertices.stream().
				filter(x -> x.getClass().getSimpleName().equals(typeName))
				.toArray();
	}

	protected void edgeExists(CFG cfg, CFGNode srcNode, CFGNode dstNode)
	{
		Collection<CFGEdge> outgoingEdges = cfg.outgoingEdges(srcNode);

		for(CFGEdge o : outgoingEdges)
		{
			if(o.getDestination() == dstNode)
				return;
		}

		assertTrue(false);
	}

}
