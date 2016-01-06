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

		Object[] array =  vertices.stream().
				filter(x -> x.getClass().getSimpleName().equals("ASTNodeContainer"))
				.toArray();
		assertEquals(array.length, 3);
	}

	@Test
	public void testWhile() throws IOException, InvalidCSVFile
	{
		CFG cfg = getCFGForCSVLines(CSVASTSamples.whileNodeStr, CSVASTSamples.whileEdgeStr);

		System.out.println(cfg);
		System.out.println(cfg.size());
	}

}
