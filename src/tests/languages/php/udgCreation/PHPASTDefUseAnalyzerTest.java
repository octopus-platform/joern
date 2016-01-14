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
	
	/* -- The "basic" expressions that reference a variable, property, constant, etc. -- */
	/* -- They do not generate defs/uses by themselves. Rather, they generate symbols -- */
	/* -- and their context generates uses from these symbols.                        -- */

	/**
	 * function() use ($foo,$bar) {};
	 */
	@Test
	public void testClosureVariable() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTSamples.closureVariableNodeStr;
		String edgeStr = CSVASTSamples.closureVariableEdgeStr;

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs = analyze(node);

		// a standalone closure variable should generate neither uses nor defs
		assertTrue( useOrDefs.isEmpty());
		
		ASTNode node2 = ast.getNodeById((long)8);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);

		// a standalone closure variable should generate neither uses nor defs
		assertTrue( useOrDefs2.isEmpty());
	}
	
	/**
	 * $foo;
	 * $$bar;
	 */
	@Test
	public void testVariable() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTSamples.variableNodeStr;
		String edgeStr = CSVASTSamples.variableEdgeStr;

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		Collection<UseOrDef> useOrDefs = analyze(node);

		// a standalone variable should generate neither uses nor defs
		assertTrue( useOrDefs.isEmpty());
		
		ASTNode node2 = ast.getNodeById((long)5);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);

		// a standalone variable should generate neither uses nor defs
		assertTrue( useOrDefs2.isEmpty());
	}
	
	/**
	 * FOO;
	 * \BAR\BUZ;
	 */
	@Test
	public void testConstant() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTSamples.constantNodeStr;
		String edgeStr = CSVASTSamples.constantEdgeStr;

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		Collection<UseOrDef> useOrDefs = analyze(node);

		// a standalone constant should generate neither uses nor defs
		assertTrue( useOrDefs.isEmpty());
		
		ASTNode node2 = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);

		// a standalone constant should generate neither uses nor defs
		assertTrue( useOrDefs2.isEmpty());
	}
	
	/**
	 * $foo->bar;
	 * buz()->$qux;
	 */
	@Test
	public void testProperty() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTSamples.propertyNodeStr;
		String edgeStr = CSVASTSamples.propertyEdgeStr;

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		Collection<UseOrDef> useOrDefs = analyze(node);

		// a standalone property access expression should generate neither uses nor defs
		assertTrue( useOrDefs.isEmpty());
		
		ASTNode node2 = ast.getNodeById((long)7);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);

		// a standalone property access expression should generate neither uses nor defs
		assertTrue( useOrDefs2.isEmpty());
	}
	
	/**
	 * Foo::$bar;
	 * $foo::$bar;
	 * buz()::$$qux;
	 */
	@Test
	public void testStaticProperty() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTSamples.staticPropertyNodeStr;
		String edgeStr = CSVASTSamples.staticPropertyEdgeStr;

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		Collection<UseOrDef> useOrDefs = analyze(node);

		// a standalone static property access expression should generate neither uses nor defs
		assertTrue( useOrDefs.isEmpty());
		
		ASTNode node2 = ast.getNodeById((long)7);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);

		// a standalone static property access expression should generate neither uses nor defs
		assertTrue( useOrDefs2.isEmpty());
		
		ASTNode node3 = ast.getNodeById((long)11);
		Collection<UseOrDef> useOrDefs3 = analyze(node3);

		// a standalone static property access expression should generate neither uses nor defs
		assertTrue( useOrDefs3.isEmpty());
	}
	
	/**
	 * Foo::BAR;
	 * $foo::BAR;
	 * buz()::QUX;
	 */
	@Test
	public void testClassConstantProperty() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTSamples.classConstantNodeStr;
		String edgeStr = CSVASTSamples.classConstantEdgeStr;

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		Collection<UseOrDef> useOrDefs = analyze(node);

		// a standalone static property access expression should generate neither uses nor defs
		assertTrue( useOrDefs.isEmpty());
		
		ASTNode node2 = ast.getNodeById((long)7);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);

		// a standalone static property access expression should generate neither uses nor defs
		assertTrue( useOrDefs2.isEmpty());
		
		ASTNode node3 = ast.getNodeById((long)11);
		Collection<UseOrDef> useOrDefs3 = analyze(node3);

		// a standalone static property access expression should generate neither uses nor defs
		assertTrue( useOrDefs3.isEmpty());
	}
	
	
	
	/* -- Expressions/statements that generate DEFs or USEs for symbols by "cleverly" -- */
	/* -- deciding which of its children symbols are DEFs and which are USEs          -- */
	
	/**
	 * $foo = $bar + $buz;
	 * $qux = $$norf;
	 */
	@Test
	public void testAssignUsingVariables() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTDefUseSamples.defUseAssignUsingVariablesNodeStr;
		String edgeStr = CSVASTDefUseSamples.defUseAssignUsingVariablesEdgeStr;

		handle(nodeStr, edgeStr);
		
		ASTNode node = ast.getNodeById((long)3);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertTrue( useOrDefs.size() == 3);
		assertTrue( containsDefSymbol( useOrDefs, node, "foo"));
		assertTrue( containsUseSymbol( useOrDefs, node, "bar"));
		assertTrue( containsUseSymbol( useOrDefs, node, "buz"));
		
		ASTNode node2 = ast.getNodeById((long)11);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);
		
		assertTrue( useOrDefs2.size() == 2);
		assertTrue( containsDefSymbol( useOrDefs2, node2, "qux"));
		assertTrue( containsUseSymbol( useOrDefs2, node2, "norf"));
	}
	
	/**
	 * $foo = FOO + \BAR\BUZ;
	 */
	@Test
	public void testAssignUsingConstants() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTDefUseSamples.defUseAssignUsingConstantsNodeStr;
		String edgeStr = CSVASTDefUseSamples.defUseAssignUsingConstantsEdgeStr;

		handle(nodeStr, edgeStr);
		
		ASTNode node = ast.getNodeById((long)3);
		Collection<UseOrDef> useOrDefs = analyze(node);

		assertTrue( useOrDefs.size() == 3);
		assertTrue( containsDefSymbol( useOrDefs, node, "foo"));
		assertTrue( containsUseSymbol( useOrDefs, node, "FOO"));
		assertTrue( containsUseSymbol( useOrDefs, node, "BAR\\BUZ"));
	}
	
	/**
	 * $foo->bar = $buz->qux + $$norf->nicknack;
	 * $someobj->arrr = somecall()->aye;
	 */
	@Test
	public void testAssignUsingProperties() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTDefUseSamples.defUseAssignUsingPropertiesNodeStr;
		String edgeStr = CSVASTDefUseSamples.defUseAssignUsingPropertiesEdgeStr;

		handle(nodeStr, edgeStr);
		
		ASTNode node = ast.getNodeById((long)3);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertTrue( useOrDefs.size() == 3);
		
		assertTrue( containsDefSymbol( useOrDefs, node, "foo"));
		assertTrue( containsUseSymbol( useOrDefs, node, "buz"));
		assertTrue( containsUseSymbol( useOrDefs, node, "norf"));
		
		ASTNode node2 = ast.getNodeById((long)18);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);
		
		// here we don't know anything about the "used" object,
		// we only know which object is being modified
		assertTrue( useOrDefs2.size() == 1);
		assertTrue( containsDefSymbol( useOrDefs2, node2, "someobj"));
	}
	
	/**
	 * Foo::$bar = $buz::${qux()} + norf()::$$nicknack;
	 */
	@Test
	public void testAssignUsingStaticProperties() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTDefUseSamples.defUseAssignUsingStaticPropertiesNodeStr;
		String edgeStr = CSVASTDefUseSamples.defUseAssignUsingStaticPropertiesEdgeStr;

		handle(nodeStr, edgeStr);
		
		ASTNode node = ast.getNodeById((long)3);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertTrue( useOrDefs.size() == 3);
		assertTrue( containsDefSymbol( useOrDefs, node, "Foo::bar"));
		assertTrue( containsUseSymbol( useOrDefs, node, "buz::*"));
		assertTrue( containsUseSymbol( useOrDefs, node, "*::nicknack"));
	}
	
	/**
	 * $foo = Foo::BAR + $buz::QUX + norf()::NICKNACK;
	 */
	@Test
	public void testAssignUsingClassConstants() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTDefUseSamples.defUseAssignUsingClassConstantsNodeStr;
		String edgeStr = CSVASTDefUseSamples.defUseAssignUsingClassConstantsEdgeStr;

		handle(nodeStr, edgeStr);
		
		ASTNode node = ast.getNodeById((long)3);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertTrue( useOrDefs.size() == 4);
		assertTrue( containsDefSymbol( useOrDefs, node, "foo"));
		assertTrue( containsUseSymbol( useOrDefs, node, "Foo::BAR"));
		assertTrue( containsUseSymbol( useOrDefs, node, "buz::QUX"));
		assertTrue( containsUseSymbol( useOrDefs, node, "*::NICKNACK"));
	}
	
	/**
	 * $foo = [3, $a, $$b, "blah"];
	 */
	@Test
	public void testAssignUsingArrayIndexing() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTDefUseSamples.defUseAssignUsingArrayIndexingNodeStr;
		String edgeStr = CSVASTDefUseSamples.defUseAssignUsingArrayIndexingEdgeStr;

		handle(nodeStr, edgeStr);
		
		ASTNode node = ast.getNodeById((long)3);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertTrue( useOrDefs.size() == 3);
		assertTrue( containsDefSymbol( useOrDefs, node, "foo"));
		assertTrue( containsUseSymbol( useOrDefs, node, "a"));
		assertTrue( containsUseSymbol( useOrDefs, node, "b"));
	}

	/**
	 * $buz = function() use ($foo,$bar) {};
	 */
	@Test
	public void testAssignUsingClosureVariables() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTDefUseSamples.defUseAssignUsingClosureVarNodeStr;
		String edgeStr = CSVASTDefUseSamples.defUseAssignUsingClosureVarEdgeStr;

		handle(nodeStr, edgeStr);
		
		ASTNode node = ast.getNodeById((long)3);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertTrue( useOrDefs.size() == 5);
		assertTrue( containsDefSymbol( useOrDefs, node, "buz"));
		assertTrue( containsUseSymbol( useOrDefs, node, "bar"));
		assertTrue( containsUseSymbol( useOrDefs, node, "foo"));
		// TODO: special case! In this case the following UseOrDef objects contain a reference
		// to the Closure node generated by the closure definition, rather than
		// a reference to the AssignmentExpression. This is because the closure definition is
		// the innermost environment which emits the DEF symbols. Is this a problem,
		// is it actually what we want, or does it not matter?
		// (That's why we pass 'ast.getNodeById((long)6)' instead of 'node' below,
		// at any rate.)
		assertTrue( containsDefSymbol( useOrDefs, ast.getNodeById((long)6), "bar"));
		assertTrue( containsDefSymbol( useOrDefs, ast.getNodeById((long)6), "foo"));
	}
	
	/**
	 * $foo += 42;
	 * $bar .= "bonjour";
	 * $buz ^= $onetimepad;
	 */
	@Test
	public void testAssignWithOp() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTSamples.assignWithOpNodeStr;
		String edgeStr = CSVASTSamples.assignWithOpEdgeStr;

		handle(nodeStr, edgeStr);
		
		ASTNode node = ast.getNodeById((long)3);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertTrue( useOrDefs.size() == 2);
		assertTrue( containsDefSymbol( useOrDefs, node, "foo"));
		assertTrue( containsUseSymbol( useOrDefs, node, "foo"));
		
		ASTNode node2 = ast.getNodeById((long)7);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);
		
		assertTrue( useOrDefs2.size() == 2);
		assertTrue( containsDefSymbol( useOrDefs2, node2, "bar"));
		assertTrue( containsUseSymbol( useOrDefs2, node2, "bar"));
		
		ASTNode node3 = ast.getNodeById((long)11);
		Collection<UseOrDef> useOrDefs3 = analyze(node3);
		
		assertTrue( useOrDefs3.size() == 3);
		assertTrue( containsDefSymbol( useOrDefs3, node3, "buz"));
		assertTrue( containsUseSymbol( useOrDefs3, node3, "buz"));
		assertTrue( containsUseSymbol( useOrDefs3, node3, "onetimepad"));
	}
	
	
	
	/* -- Expressions/statements that generate DEFs *and* USEs for -- */
	/* -- all their children symbols                               -- */
	
	/**
	 * ++$i;
	 */
	@Test
	public void testPreInc() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTDefUseSamples.preIncNodeStr;
		String edgeStr = CSVASTDefUseSamples.preIncEdgeStr;

		handle(nodeStr, edgeStr);
		
		ASTNode node = ast.getNodeById((long)3);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertTrue( useOrDefs.size() == 2);
		assertTrue( containsDefSymbol( useOrDefs, node, "i"));
		assertTrue( containsUseSymbol( useOrDefs, node, "i"));
	}
	
	/**
	 * --$i;
	 */
	@Test
	public void testPreDec() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTDefUseSamples.preDecNodeStr;
		String edgeStr = CSVASTDefUseSamples.preDecEdgeStr;

		handle(nodeStr, edgeStr);
		
		ASTNode node = ast.getNodeById((long)3);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertTrue( useOrDefs.size() == 2);
		assertTrue( containsDefSymbol( useOrDefs, node, "i"));
		assertTrue( containsUseSymbol( useOrDefs, node, "i"));
	}
	
	/**
	 * $i++;
	 */
	@Test
	public void testPostInc() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTDefUseSamples.postIncNodeStr;
		String edgeStr = CSVASTDefUseSamples.postIncEdgeStr;

		handle(nodeStr, edgeStr);
		
		ASTNode node = ast.getNodeById((long)3);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertTrue( useOrDefs.size() == 2);
		assertTrue( containsDefSymbol( useOrDefs, node, "i"));
		assertTrue( containsUseSymbol( useOrDefs, node, "i"));
	}
	
	/**
	 * $i--;
	 */
	@Test
	public void testPostDec() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTDefUseSamples.postDecNodeStr;
		String edgeStr = CSVASTDefUseSamples.postDecEdgeStr;

		handle(nodeStr, edgeStr);
		
		ASTNode node = ast.getNodeById((long)3);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertTrue( useOrDefs.size() == 2);
		assertTrue( containsDefSymbol( useOrDefs, node, "i"));
		assertTrue( containsUseSymbol( useOrDefs, node, "i"));
	}
	
	
	
	/* -- Expressions/statements that generate *only* USEs for -- */
	/* -- all their children symbols                           -- */
	
	/**
	 * empty($foo);
	 * empty(bar());
	 */
	@Test
	public void testEmpty() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTDefUseSamples.emptyNodeStr;
		String edgeStr = CSVASTDefUseSamples.emptyEdgeStr;

		handle(nodeStr, edgeStr);
		
		ASTNode node = ast.getNodeById((long)3);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertTrue( useOrDefs.size() == 1);
		assertTrue( containsUseSymbol( useOrDefs, node, "foo"));
		
		ASTNode node2 = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);
		
		assertTrue( useOrDefs2.isEmpty());
	}
	
	/**
	 * isset($foo);
	 * isset($bar->buz);
	 */
	@Test
	public void testIsset() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTDefUseSamples.issetNodeStr;
		String edgeStr = CSVASTDefUseSamples.issetEdgeStr;

		handle(nodeStr, edgeStr);
		
		ASTNode node = ast.getNodeById((long)3);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertTrue( useOrDefs.size() == 1);
		assertTrue( containsUseSymbol( useOrDefs, node, "foo"));
		
		ASTNode node2 = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);
		
		assertTrue( useOrDefs2.size() == 1);
		assertTrue( containsUseSymbol( useOrDefs2, node2, "bar"));
	}
	
	/**
	 * $output = `cat /var/www/html/.htpasswd`;
	 * $output2 = `$attackerinput`;
	 */
	@Test
	public void testShellExec() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTDefUseSamples.shellExecNodeStr;
		String edgeStr = CSVASTDefUseSamples.shellExecEdgeStr;

		handle(nodeStr, edgeStr);
		
		ASTNode node = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertTrue( useOrDefs.isEmpty());
		
		ASTNode node2 = ast.getNodeById((long)11);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);
		
		assertTrue( useOrDefs2.size() == 1);
		assertTrue( containsUseSymbol( useOrDefs2, node2, "attackerinput"));
	}
	
	/**
	 * clone($foo);
	 * clone(bar());
	 */
	@Test
	public void testClone() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTDefUseSamples.cloneNodeStr;
		String edgeStr = CSVASTDefUseSamples.cloneEdgeStr;

		handle(nodeStr, edgeStr);
		
		ASTNode node = ast.getNodeById((long)3);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertTrue( useOrDefs.size() == 1);
		assertTrue( containsUseSymbol( useOrDefs, node, "foo"));
		
		ASTNode node2 = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);
		
		assertTrue( useOrDefs2.isEmpty());
	}
	
	/**
	 * exit($foo);
	 * exit(bar());
	 */
	@Test
	public void testExit() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTDefUseSamples.exitNodeStr;
		String edgeStr = CSVASTDefUseSamples.exitEdgeStr;

		handle(nodeStr, edgeStr);
		
		ASTNode node = ast.getNodeById((long)3);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertTrue( useOrDefs.size() == 1);
		assertTrue( containsUseSymbol( useOrDefs, node, "foo"));
		
		ASTNode node2 = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);
		
		assertTrue( useOrDefs2.isEmpty());
	}
	
	/**
	 * print($foo);
	 * print(bar());
	 */
	@Test
	public void testPrint() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTDefUseSamples.printNodeStr;
		String edgeStr = CSVASTDefUseSamples.printEdgeStr;

		handle(nodeStr, edgeStr);
		
		ASTNode node = ast.getNodeById((long)3);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertTrue( useOrDefs.size() == 1);
		assertTrue( containsUseSymbol( useOrDefs, node, "foo"));
		
		
		ASTNode node2 = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);
		
		assertTrue( useOrDefs2.isEmpty());
	}
	
	/**
	 * include 'foo.php';
	 * include_once $userinput;
	 * require getuserinput();
	 * require_once "http://".$userinput."bar.php";
	 * eval("{$evilinput}");
	 */
	@Test
	public void testIncludeOrEval() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTDefUseSamples.includeOrEvalNodeStr;
		String edgeStr = CSVASTDefUseSamples.includeOrEvalEdgeStr;

		handle(nodeStr, edgeStr);
		
		ASTNode node = ast.getNodeById((long)3);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertTrue( useOrDefs.isEmpty());
		
		ASTNode node2 = ast.getNodeById((long)5);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);
		
		assertTrue( useOrDefs2.size() == 1);
		assertTrue( containsUseSymbol( useOrDefs2, node2, "userinput"));
		
		ASTNode node3 = ast.getNodeById((long)8);
		Collection<UseOrDef> useOrDefs3 = analyze(node3);
		
		assertTrue( useOrDefs3.isEmpty());
		
		ASTNode node4 = ast.getNodeById((long)13);
		Collection<UseOrDef> useOrDefs4 = analyze(node4);
		
		assertTrue( useOrDefs4.size() == 1);
		assertTrue( containsUseSymbol( useOrDefs4, node4, "userinput"));
		
		ASTNode node5 = ast.getNodeById((long)20);
		Collection<UseOrDef> useOrDefs5 = analyze(node5);
		
		assertTrue( useOrDefs5.size() == 1);
		assertTrue( containsUseSymbol( useOrDefs5, node5, "evilinput"));
	}
	
	/**
	 * function counttothree() {
	 *   $a = [1,2,3];
	 *   yield from $a;
	 * }
	 */
	@Test
	public void testYieldFrom() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTDefUseSamples.defUseYieldFromNodeStr;
		String edgeStr = CSVASTDefUseSamples.defUseYieldFromEdgeStr;

		handle(nodeStr, edgeStr);
		
		ASTNode node = ast.getNodeById((long)20);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertTrue( useOrDefs.size() == 1);
		assertTrue( containsUseSymbol( useOrDefs, node, "a"));
	}
	
	/**
	 * function foo() {
	 *   $a = [1,2,3];
	 *   return $a;
	 * }
	 */
	@Test
	public void testReturn() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTDefUseSamples.defUseReturnNodeStr;
		String edgeStr = CSVASTDefUseSamples.defUseReturnEdgeStr;

		handle(nodeStr, edgeStr);
		
		ASTNode node = ast.getNodeById((long)20);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertTrue( useOrDefs.size() == 1);
		assertTrue( containsUseSymbol( useOrDefs, node, "a"));
	}

	/**
	 * echo $foo, $bar, PHP_EOL;
	 * echo $buz.$qux.PHP_EOL;
	 * echo "{$norf}{$nicknack}";
	 */
	@Test
	public void testEcho() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTDefUseSamples.defUseEchoNodeStr;
		String edgeStr = CSVASTDefUseSamples.defUseEchoEdgeStr;

		handle(nodeStr, edgeStr);
		
		ASTNode node = ast.getNodeById((long)4);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertTrue( useOrDefs.size() == 1);
		assertTrue( containsUseSymbol( useOrDefs, node, "foo"));
		
		ASTNode node2 = ast.getNodeById((long)7);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);
		
		assertTrue( useOrDefs2.size() == 1);
		assertTrue( containsUseSymbol( useOrDefs2, node2, "bar"));
		
		ASTNode node3 = ast.getNodeById((long)10);
		Collection<UseOrDef> useOrDefs3 = analyze(node3);
		
		assertTrue( useOrDefs3.size() == 1);
		assertTrue( containsUseSymbol( useOrDefs3, node3, "PHP_EOL"));
		
		ASTNode node4 = ast.getNodeById((long)15);
		Collection<UseOrDef> useOrDefs4 = analyze(node4);
		
		assertTrue( useOrDefs4.size() == 3);
		assertTrue( containsUseSymbol( useOrDefs4, node4, "buz"));
		assertTrue( containsUseSymbol( useOrDefs4, node4, "qux"));
		assertTrue( containsUseSymbol( useOrDefs4, node4, "PHP_EOL"));
		
		ASTNode node5 = ast.getNodeById((long)26);
		Collection<UseOrDef> useOrDefs5 = analyze(node5);
		
		assertTrue( useOrDefs5.size() == 2);
		assertTrue( containsUseSymbol( useOrDefs5, node5, "norf"));
		assertTrue( containsUseSymbol( useOrDefs5, node5, "nicknack"));
	}
	
	/**
	 * throw new Exception($error);
	 * throw new Foo($bar,$buz);
	 */
	@Test
	public void testThrow() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTDefUseSamples.defUseThrowNodeStr;
		String edgeStr = CSVASTDefUseSamples.defUseThrowEdgeStr;

		handle(nodeStr, edgeStr);
		
		ASTNode node = ast.getNodeById((long)3);
		Collection<UseOrDef> useOrDefs = analyze(node);
		assertTrue( useOrDefs.size() == 1);
		// TODO: special case! In this case the UseOrDef object contains a reference
		// to the NewExpression node generated by the "new" statement, rather than
		// a reference to the ThrowStatement. This is because the NewExpression is
		// the innermost environment which emits the USE symbol. Is this a problem,
		// is it actually what we want, or does it not matter?
		// (That's why we pass 'ast.getNodeById((long)4)' instead of 'node' below,
		// at any rate.)
		assertTrue( containsUseSymbol( useOrDefs, ast.getNodeById((long)4), "error"));
		
		ASTNode node2 = ast.getNodeById((long)10);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);
		
		assertTrue( useOrDefs2.size() == 2);
		// TODO: special case! In this case the UseOrDef object contains a reference
		// to the NewExpression node generated by the "new" statement, rather than
		// a reference to the ThrowStatement. This is because the NewExpression is
		// the innermost environment which emits the USE symbol. Is this a problem,
		// is it actually what we want, or does it not matter?
		// (That's why we pass 'ast.getNodeById((long)11)' instead of 'node2' below,
		// at any rate.)
		assertTrue( containsUseSymbol( useOrDefs2, ast.getNodeById((long)11), "bar"));
		assertTrue( containsUseSymbol( useOrDefs2, ast.getNodeById((long)11), "buz"));
	}
	
	/**
	 * function counttothree() {
	 *   foreach( [1,2,3] as $index => $value)
	 *     yield $index => $value;
	 * }
	 */
	@Test
	public void testYield() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTDefUseSamples.defUseYieldNodeStr;
		String edgeStr = CSVASTDefUseSamples.defUseYieldEdgeStr;

		handle(nodeStr, edgeStr);
		
		ASTNode node = ast.getNodeById((long)22);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertTrue( useOrDefs.size() == 2);
		assertTrue( containsUseSymbol( useOrDefs, node, "index"));
		assertTrue( containsUseSymbol( useOrDefs, node, "value"));
	}
	
	
	
	/* -- Call expressions. They also *only* emit USEs for all their symbols:             -- */
	/* -- Although variables may optionally be passed by reference in function calls,     -- */
	/* -- this is not visible from the call site; rather, this is exclusively determined  -- */
	/* -- by the function definition, which is unknown in the call environment. Therefore -- */
	/* -- we can only:                                                                    -- */
	/* -- (1) assume DEFs *and* USEs for all variables in a function call                 -- */
	/*       (over-approximation -> more false positives)                                 -- */
	/* -- (2) assume *only* USEs for all variables in a function call                     -- */
	/* --     (under-approximation -> more false negatives)                               -- */
	/* -- Here we go for (2).                                                             -- */
	
	/**
	 * foo($bar, "yabadabadoo");
	 * $buz(1);
	 */
	@Test
	public void testCall() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTDefUseSamples.callNodeStr;
		String edgeStr = CSVASTDefUseSamples.callEdgeStr;

		handle(nodeStr, edgeStr);
		
		ASTNode node = ast.getNodeById((long)3);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertTrue( useOrDefs.size() == 1);
		assertTrue( containsUseSymbol( useOrDefs, node, "bar"));
		
		ASTNode node2 = ast.getNodeById((long)10);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);
		
		assertTrue( useOrDefs2.size() == 1);
		assertTrue( containsUseSymbol( useOrDefs2, node2, "buz"));
	}
	
	/**
	 * new Foo($bar);
	 * new $buz();
	 */
	@Test
	public void testNew() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTDefUseSamples.newNodeStr;
		String edgeStr = CSVASTDefUseSamples.newEdgeStr;

		handle(nodeStr, edgeStr);
		
		ASTNode node = ast.getNodeById((long)3);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertTrue( useOrDefs.size() == 1);
		assertTrue( containsUseSymbol( useOrDefs, node, "bar"));
		
		ASTNode node2 = ast.getNodeById((long)9);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);
		
		assertTrue( useOrDefs2.size() == 1);
		assertTrue( containsUseSymbol( useOrDefs2, node2, "buz"));
	}
	
	/**
	 * $buz->foo($bar, "yabadabadoo");
	 * buz()->$foo($bar, "yabadabadoo");
	 */
	@Test
	public void testMethodCall() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTDefUseSamples.methodCallNodeStr;
		String edgeStr = CSVASTDefUseSamples.methodCallEdgeStr;

		handle(nodeStr, edgeStr);
		
		ASTNode node = ast.getNodeById((long)3);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertTrue( useOrDefs.size() == 2);
		assertTrue( containsUseSymbol( useOrDefs, node, "buz"));
		assertTrue( containsUseSymbol( useOrDefs, node, "bar"));
		
		ASTNode node2 = ast.getNodeById((long)11);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);
		
		assertTrue( useOrDefs2.size() == 2);
		assertTrue( containsUseSymbol( useOrDefs2, node2, "foo"));
		assertTrue( containsUseSymbol( useOrDefs2, node2, "bar"));
	}
	
	/**
	 * Foo::bar($buz);
	 * $qux::{norf[42]}();
	 */
	@Test
	public void testStaticCall() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTDefUseSamples.staticCallNodeStr;
		String edgeStr = CSVASTDefUseSamples.staticCallEdgeStr;

		handle(nodeStr, edgeStr);
		
		ASTNode node = ast.getNodeById((long)3);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertTrue( useOrDefs.size() == 1);
		assertTrue( containsUseSymbol( useOrDefs, node, "buz"));
		
		ASTNode node2 = ast.getNodeById((long)10);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);

		assertTrue( useOrDefs2.size() == 2);
		assertTrue( containsUseSymbol( useOrDefs2, node2, "qux"));
		assertTrue( containsUseSymbol( useOrDefs2, node2, "norf"));
	}
	
	
	
	/* -- Expressions/statements that generate *only* DEFs for -- */
	/* -- all their children symbols                           -- */
	
	/**
	 * function foo() {
	 *   global $bar, $buz;
	 * }
	 */
	@Test
	public void testGlobal() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTDefUseSamples.globalNodeStr;
		String edgeStr = CSVASTDefUseSamples.globalEdgeStr;

		handle(nodeStr, edgeStr);
		
		ASTNode node = ast.getNodeById((long)8);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertTrue( useOrDefs.size() == 1);
		assertTrue( containsDefSymbol( useOrDefs, node, "bar"));
		
		ASTNode node2 = ast.getNodeById((long)11);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);
		
		assertTrue( useOrDefs2.size() == 1);
		assertTrue( containsDefSymbol( useOrDefs2, node2, "buz"));
	}
	
	/**
	 * unset($foo,$bar->buz,$qux[42]);
	 */
	@Test
	public void testUnset() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTDefUseSamples.unsetNodeStr;
		String edgeStr = CSVASTDefUseSamples.unsetEdgeStr;

		handle(nodeStr, edgeStr);
		
		ASTNode node = ast.getNodeById((long)4);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertTrue( useOrDefs.size() == 1);
		assertTrue( containsDefSymbol( useOrDefs, node, "foo"));
		
		ASTNode node2 = ast.getNodeById((long)7);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);
		
		assertTrue( useOrDefs2.size() == 1);
		assertTrue( containsDefSymbol( useOrDefs2, node2, "bar"));
		
		ASTNode node3 = ast.getNodeById((long)12);
		Collection<UseOrDef> useOrDefs3 = analyze(node3);
		
		assertTrue( useOrDefs3.size() == 1);
		assertTrue( containsDefSymbol( useOrDefs3, node3, "qux"));
	}
	
	/**
	 * try {}
	 * catch(FooException $f) {}
	 * catch(BarException $b) {}
	 * finally {}
	 */
	@Test
	public void testCatch() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTDefUseSamples.catchNodeStr;
		String edgeStr = CSVASTDefUseSamples.catchEdgeStr;

		handle(nodeStr, edgeStr);
		
		ASTNode node = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertTrue( useOrDefs.size() == 1);
		assertTrue( containsDefSymbol( useOrDefs, node, "f"));
		
		ASTNode node2 = ast.getNodeById((long)11);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);
		
		assertTrue( useOrDefs2.size() == 1);
		assertTrue( containsDefSymbol( useOrDefs2, node2, "b"));
	}
	
	
	/* -- Function definitions. They also *only* emit DEFs for all their parameters:    -- */
	/* -- However, we use an exclusive environment instead of an EmitDefEnvironment as  -- */
	/* -- the latter would traverse all children, including the entire function's body; -- */
	/* -- we are only interested in emitting DEFs for the parameters here.              -- */
	
	/**
	 * function foo($bar,&$buz) {}
	 */
	@Test
	public void testFunctionDef() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTDefUseSamples.defUseFunctionDefNodeStr;
		String edgeStr = CSVASTDefUseSamples.defUseFunctionDefEdgeStr;

		handle(nodeStr, edgeStr);
		
		ASTNode node = ast.getNodeById((long)3);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertTrue( useOrDefs.size() == 2);
		assertTrue( containsDefSymbol( useOrDefs, node, "bar"));
		assertTrue( containsDefSymbol( useOrDefs, node, "buz"));
	}

	/**
	 * function($bar,&$buz) use ($qux,&$norf) {};
	 */
	@Test
	public void testClosure() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTDefUseSamples.defUseClosureNodeStr;
		String edgeStr = CSVASTDefUseSamples.defUseClosureEdgeStr;

		handle(nodeStr, edgeStr);
		
		ASTNode node = ast.getNodeById((long)3);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertTrue( useOrDefs.size() == 4);
		assertTrue( containsDefSymbol( useOrDefs, node, "bar"));
		assertTrue( containsDefSymbol( useOrDefs, node, "buz"));
		assertTrue( containsDefSymbol( useOrDefs, node, "qux"));
		assertTrue( containsDefSymbol( useOrDefs, node, "norf"));
	}
	
	/**
	 * class Foo {
	 *   function foo($bar,&$buz) {}
	 * }
	 */
	@Test
	public void testMethod() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTDefUseSamples.defUseMethodNodeStr;
		String edgeStr = CSVASTDefUseSamples.defUseMethodEdgeStr;

		handle(nodeStr, edgeStr);
		
		ASTNode node = ast.getNodeById((long)8);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertTrue( useOrDefs.size() == 2);
		assertTrue( containsDefSymbol( useOrDefs, node, "bar"));
		assertTrue( containsDefSymbol( useOrDefs, node, "buz"));
	}
}
