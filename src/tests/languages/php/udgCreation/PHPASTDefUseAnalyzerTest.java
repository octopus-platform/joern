package tests.languages.php.udgCreation;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Collection;

import org.junit.Test;

import ast.ASTNode;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import languages.php.udg.useDefAnalysis.PHPASTDefUseAnalyzer;
import tests.languages.php.PHPCSVBasedTest;
import tests.languages.php.samples.CSVASTDefUseSamples;
import tests.languages.php.samples.CSVASTSamples;
import udg.ASTNodeASTProvider;
import udg.useDefGraph.UseOrDef;

public class PHPASTDefUseAnalyzerTest extends PHPCSVBasedTest {

	private PHPASTDefUseAnalyzer analyzer = new PHPASTDefUseAnalyzer();
	
	/**
	 * For a given node, runs a def/use analysis and returns a collection of
	 * use/def elements.
	 */
	private Collection<UseOrDef> analyze(ASTNode node) {
		
		ASTNodeASTProvider provider = new ASTNodeASTProvider();
		provider.setNode(node);
		
		return analyzer.analyzeAST(provider);
	}

	/**
	 * Convenience method for checking whether a collection of UseOrDef elements contains
	 * a definition of a given symbol for a given node.
	 */
	private boolean containsDefSymbol( Collection<UseOrDef> useOrDefs, ASTNode node, String symbol) {
		return containsUseOrDefSymbol( useOrDefs, node, symbol, true);
	}
	
	/**
	 * Convenience method for checking whether a collection of UseOrDef elements contains
	 * a use of a given symbol for a given node.
	 */
	private boolean containsUseSymbol( Collection<UseOrDef> useOrDefs, ASTNode node, String symbol) {
		return containsUseOrDefSymbol( useOrDefs, node, symbol, false);
	}
	
	/**
	 * Checks whether a collection of UseOrDef elements contains a definition/use
	 * of a given symbol for a given node.
	 */
	private boolean containsUseOrDefSymbol( Collection<UseOrDef> useOrDefs, ASTNode node, String symbol, boolean isDef) {

		for( UseOrDef useOrDef : useOrDefs) {
			if( ((ASTNodeASTProvider)useOrDef.astProvider).getASTNode().equals( node)
					&& useOrDef.symbol.equals(symbol)
					&& useOrDef.isDef == isDef)
				return true;
		}
		return false;
	}

	
	/* **************** *
	 * The actual tests *
	 * **************** */
	
	/**
	 * $foo;
	 */
	@Test
	public void testVariable() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTSamples.nodeHeader;
		nodeStr += "3,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "4,string,,3,\"foo\",0,1,,,\n";

		String edgeStr = CSVASTSamples.edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		// a standalone variable should generate neither uses nor defs
		assertTrue( useOrDefs.isEmpty());
	}
	
	/**
	 * $foo = $bar + $buz;
	 */
	@Test
	public void testAssign() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTDefUseSamples.defUseAssignNodeStr;
		String edgeStr = CSVASTDefUseSamples.defUseAssignEdgeStr;

		handle(nodeStr, edgeStr);
		
		ASTNode node = ast.getNodeById((long)3);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertTrue( useOrDefs.size() == 3);
		
		assertTrue( containsDefSymbol( useOrDefs, node, "foo"));
		assertTrue( containsUseSymbol( useOrDefs, node, "bar"));
		assertTrue( containsUseSymbol( useOrDefs, node, "buz"));
	}

}
