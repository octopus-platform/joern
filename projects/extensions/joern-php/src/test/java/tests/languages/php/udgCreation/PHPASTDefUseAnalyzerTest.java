package tests.languages.php.udgCreation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import ast.ASTNode;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import tests.languages.php.PHPCSVBasedTest;
import udg.ASTNodeASTProvider;
import udg.php.useDefAnalysis.PHPASTDefUseAnalyzer;
import udg.useDefGraph.UseOrDef;

public class PHPASTDefUseAnalyzerTest extends PHPCSVBasedTest {

	private PHPASTDefUseAnalyzer analyzer = new PHPASTDefUseAnalyzer();
	
	// set sample directory
	@Before
	public void setSampleDir() {
		super.setSampleDir( "udgCreation");
	}
	
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
		handleCSVFiles( "testClosureVariable");

		ASTNode node = ast.getNodeById((long)11);
		Collection<UseOrDef> useOrDefs = analyze(node);

		// a standalone closure variable should generate neither uses nor defs
		assertTrue( useOrDefs.isEmpty());
		
		ASTNode node2 = ast.getNodeById((long)13);
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
		handleCSVFiles( "testVariable");

		ASTNode node = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs = analyze(node);

		// a *standalone* variable should generate a USE; this is because
		// it might appear as a predicate inside an if/while/etc. guard
		assertEquals( 1, useOrDefs.size());
		assertTrue( containsUseSymbol( useOrDefs, node, "foo"));

		ASTNode node2 = ast.getNodeById((long)8);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);

		// a *standalone* variable should generate a USE; this is because
		// it might appear as a predicate inside an if/while/etc. guard
		assertEquals( 1, useOrDefs2.size());
		assertTrue( containsUseSymbol( useOrDefs2, node2, "bar"));
	}
	
	/**
	 * FOO;
	 * \BAR\BUZ;
	 */
	@Test
	public void testConstant() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testConstant");

		ASTNode node = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs = analyze(node);

		// a *standalone* constant should generate a USE; this is because
		// it might appear as a predicate inside an if/while/etc. guard
		assertEquals( 1, useOrDefs.size());
		assertTrue( containsUseSymbol( useOrDefs, node, "FOO"));
		
		ASTNode node2 = ast.getNodeById((long)9);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);

		// a *standalone* constant should generate a USE; this is because
		// it might appear as a predicate inside an if/while/etc. guard
		assertEquals( 1, useOrDefs.size());
		assertTrue( containsUseSymbol( useOrDefs2, node2, "BAR\\BUZ"));
	}
	
	/**
	 * $foo->bar;
	 * buz()->$qux;
	 */
	@Test
	public void testProperty() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testProperty");

		ASTNode node = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs = analyze(node);

		// a *standalone* property should generate a USE; this is because
		// it might appear as a predicate inside an if/while/etc. guard
		assertEquals( 1, useOrDefs.size());
		assertTrue( containsUseSymbol( useOrDefs, node, "foo"));
		
		ASTNode node2 = ast.getNodeById((long)10);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);

		// If we do not know the object being accessed, we can only under-approximate;
		// no USE is emitted.
		// Note that we intentionally do not add "qux" as a USE'd symbol here.
		// For property accesses, we are always only interested in the object.
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
		handleCSVFiles( "testStaticProperty");

		ASTNode node = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		// a *standalone* static property should generate a USE; this is because
		// it might appear as a predicate inside an if/while/etc. guard
		assertEquals( 1, useOrDefs.size());
		assertTrue( containsUseSymbol( useOrDefs, node, "Foo::bar"));
		
		ASTNode node2 = ast.getNodeById((long)10);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);

		// a *standalone* static property should generate a USE; this is because
		// it might appear as a predicate inside an if/while/etc. guard
		assertEquals( 1, useOrDefs2.size());
		assertTrue( containsUseSymbol( useOrDefs2, node2, "foo::bar"));
		
		ASTNode node3 = ast.getNodeById((long)14);
		Collection<UseOrDef> useOrDefs3 = analyze(node3);

		// a *standalone* static property should generate a USE; this is because
		// it might appear as a predicate inside an if/while/etc. guard
		assertEquals( 1, useOrDefs3.size());
		assertTrue( containsUseSymbol( useOrDefs3, node3, "*::qux"));
	}
	
	/**
	 * Foo::BAR;
	 * $foo::BAR;
	 * buz()::QUX;
	 */
	@Test
	public void testClassConstantProperty() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testClassConstant");

		ASTNode node = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs = analyze(node);

		// a *standalone* class constant should generate a USE; this is because
		// it might appear as a predicate inside an if/while/etc. guard
		assertEquals( 1, useOrDefs.size());
		assertTrue( containsUseSymbol( useOrDefs, node, "Foo::BAR"));
		
		ASTNode node2 = ast.getNodeById((long)10);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);

		// a *standalone* class constant should generate a USE; this is because
		// it might appear as a predicate inside an if/while/etc. guard
		assertEquals( 1, useOrDefs2.size());
		assertTrue( containsUseSymbol( useOrDefs2, node2, "foo::BAR"));
		
		ASTNode node3 = ast.getNodeById((long)14);
		Collection<UseOrDef> useOrDefs3 = analyze(node3);

		// a *standalone* class constant should generate a USE; this is because
		// it might appear as a predicate inside an if/while/etc. guard
		assertEquals( 1, useOrDefs3.size());
		assertTrue( containsUseSymbol( useOrDefs3, node3, "*::QUX"));
	}
	
	/**
	 * $foo[$bar];
	 * $buz[qux()];
	 * norf()[$nicknack];
	 */
	@Test
	public void testArrayIndexing() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testArrayIndexing");

		ASTNode node = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		// a *standalone* array access should generate a USE for the array's name;
		// this is because it might appear as a predicate inside an if/while/etc. guard
		assertEquals( 2, useOrDefs.size());
		assertTrue( containsUseSymbol( useOrDefs, node, "foo"));
		assertTrue( containsUseSymbol( useOrDefs, node, "bar"));
		
		ASTNode node2 = ast.getNodeById((long)11);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);
		
		// a *standalone* array access should generate a USE for the array's name;
		// this is because it might appear as a predicate inside an if/while/etc. guard
		assertEquals( 1, useOrDefs2.size());
		assertTrue( containsUseSymbol( useOrDefs2, node2, "buz"));
		
		ASTNode node3 = ast.getNodeById((long)18);
		Collection<UseOrDef> useOrDefs3 = analyze(node3);
		
		// a *standalone* array access should generate a USE for the array's name;
		// this is because it might appear as a predicate inside an if/while/etc. guard
		assertEquals( 1, useOrDefs3.size());
		assertTrue( containsUseSymbol( useOrDefs3, node3, "nicknack"));
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
		handleCSVFiles( "testAssignUsingVariables");

		ASTNode node = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertEquals( 3, useOrDefs.size());
		assertTrue( containsDefSymbol( useOrDefs, node, "foo"));
		assertTrue( containsUseSymbol( useOrDefs, ast.getNodeById((long)9), "bar"));
		assertTrue( containsUseSymbol( useOrDefs, ast.getNodeById((long)9), "buz"));
		
		ASTNode node2 = ast.getNodeById((long)14);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);
		
		assertEquals( 2, useOrDefs2.size());
		assertTrue( containsDefSymbol( useOrDefs2, node2, "qux"));
		assertTrue( containsUseSymbol( useOrDefs2, node2, "norf"));
	}
	
	/**
	 * $foo = FOO + \BAR\BUZ;
	 */
	@Test
	public void testAssignUsingConstants() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testAssignUsingConstants");

		ASTNode node = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs = analyze(node);

		assertEquals( 3, useOrDefs.size());
		assertTrue( containsDefSymbol( useOrDefs, node, "foo"));
		assertTrue( containsUseSymbol( useOrDefs, ast.getNodeById((long)9), "FOO"));
		assertTrue( containsUseSymbol( useOrDefs, ast.getNodeById((long)9), "BAR\\BUZ"));
	}
	
	/**
	 * $foo->bar = $buz->qux + $$norf->nicknack;
	 * $someobj->arrr = somecall()->aye;
	 */
	@Test
	public void testAssignUsingProperties() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testAssignUsingProperties");

		ASTNode node = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertEquals( 3, useOrDefs.size());
		
		assertTrue( containsDefSymbol( useOrDefs, node, "foo"));
		assertTrue( containsUseSymbol( useOrDefs, ast.getNodeById((long)11), "buz"));
		assertTrue( containsUseSymbol( useOrDefs, ast.getNodeById((long)11), "norf"));
		
		ASTNode node2 = ast.getNodeById((long)21);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);
		
		// here we don't know anything about the "used" object,
		// we only know which object is being modified
		assertEquals( 1, useOrDefs2.size());
		assertTrue( containsDefSymbol( useOrDefs2, node2, "someobj"));
	}
	
	/**
	 * Foo::$bar = $buz::${qux()} + norf()::$$nicknack;
	 */
	@Test
	public void testAssignUsingStaticProperties() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testAssignUsingStaticProperties");

		ASTNode node = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertEquals( 3, useOrDefs.size());
		assertTrue( containsDefSymbol( useOrDefs, node, "Foo::bar"));
		assertTrue( containsUseSymbol( useOrDefs, ast.getNodeById((long)11), "buz::*"));
		assertTrue( containsUseSymbol( useOrDefs, ast.getNodeById((long)11), "*::nicknack"));
	}
	
	/**
	 * $foo = Foo::BAR + $buz::QUX + norf()::NICKNACK;
	 */
	@Test
	public void testAssignUsingClassConstants() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testAssignUsingClassConstants");

		ASTNode node = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertEquals( 4, useOrDefs.size());
		assertTrue( containsDefSymbol( useOrDefs, node, "foo"));
		assertTrue( containsUseSymbol( useOrDefs, ast.getNodeById((long)10), "Foo::BAR"));
		assertTrue( containsUseSymbol( useOrDefs, ast.getNodeById((long)10), "buz::QUX"));
		assertTrue( containsUseSymbol( useOrDefs, ast.getNodeById((long)9), "*::NICKNACK"));
	}
	
	/**
	 * $foo = [3, $a, $$b, "blah"];
	 */
	@Test
	public void testAssignUsingArray() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testAssignUsingArray");

		ASTNode node = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertEquals( 3, useOrDefs.size());
		assertTrue( containsDefSymbol( useOrDefs, node, "foo"));
		assertTrue( containsUseSymbol( useOrDefs, node, "a"));
		assertTrue( containsUseSymbol( useOrDefs, node, "b"));
	}
	
	/**
	 * $foo[$bar] = $buz;
	 * $qux = $norf[$nicknack->slurp];
	 */
	@Test
	public void testAssignUsingArrayIndexing() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testAssignUsingArrayIndexing");

		ASTNode node = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertEquals( 3, useOrDefs.size());
		assertTrue( containsDefSymbol( useOrDefs, node, "foo"));
		assertTrue( containsUseSymbol( useOrDefs, ast.getNodeById((long)7), "bar"));
		assertTrue( containsUseSymbol( useOrDefs, node, "buz"));
		
		ASTNode node2 = ast.getNodeById((long)14);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);
		
		assertEquals( 3, useOrDefs2.size());
		assertTrue( containsDefSymbol( useOrDefs2, node2, "qux"));
		assertTrue( containsUseSymbol( useOrDefs2, node2, "norf"));
		assertTrue( containsUseSymbol( useOrDefs2, ast.getNodeById((long)17), "nicknack"));
	}

	/**
	 * $buz = function() use ($foo,$bar) {};
	 */
	@Test
	public void testAssignUsingClosureVariables() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testAssignUsingClosureVariables");

		ASTNode node = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertEquals( 3, useOrDefs.size());
		assertTrue( containsDefSymbol( useOrDefs, node, "buz"));
		assertTrue( containsUseSymbol( useOrDefs, node, "bar"));
		assertTrue( containsUseSymbol( useOrDefs, node, "foo"));
	}
	
	/**
	 * $foo += 42;
	 * $bar .= "bonjour";
	 * $buz ^= $onetimepad;
	 */
	@Test
	public void testAssignWithOp() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testAssignWithOp");

		ASTNode node = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertEquals( 2, useOrDefs.size());
		assertTrue( containsDefSymbol( useOrDefs, node, "foo"));
		assertTrue( containsUseSymbol( useOrDefs, node, "foo"));
		
		ASTNode node2 = ast.getNodeById((long)10);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);
		
		assertEquals( 2, useOrDefs2.size());
		assertTrue( containsDefSymbol( useOrDefs2, node2, "bar"));
		assertTrue( containsUseSymbol( useOrDefs2, node2, "bar"));
		
		ASTNode node3 = ast.getNodeById((long)14);
		Collection<UseOrDef> useOrDefs3 = analyze(node3);
		
		assertEquals( 3, useOrDefs3.size());
		assertTrue( containsDefSymbol( useOrDefs3, node3, "buz"));
		assertTrue( containsUseSymbol( useOrDefs3, node3, "buz"));
		assertTrue( containsUseSymbol( useOrDefs3, node3, "onetimepad"));
	}
	
	/**
	 * $foo =& $bar;
	 */
	@Test
	public void testAssignByRef() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testAssignByRef");

		ASTNode node = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertEquals( 2, useOrDefs.size());
		assertTrue( containsDefSymbol( useOrDefs, node, "foo"));
		assertTrue( containsUseSymbol( useOrDefs, node, "bar"));
	}
	
	/**
	 * function foo() {
	 *   static $foo = $bar, $buz = $qux->norf;
	 * }
	 */
	@Test
	public void testStaticVariable() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testStaticVariable");

		ASTNode node = ast.getNodeById((long)12);
		Collection<UseOrDef> useOrDefs = analyze(node);
			
		assertEquals( 2, useOrDefs.size());
		assertTrue( containsDefSymbol( useOrDefs, node, "foo"));
		assertTrue( containsUseSymbol( useOrDefs, node, "bar"));
		
		ASTNode node2 = ast.getNodeById((long)17);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);
		
		assertEquals( 2, useOrDefs2.size());
		assertTrue( containsDefSymbol( useOrDefs2, node2, "buz"));
		assertTrue( containsUseSymbol( useOrDefs2, node2, "qux"));
	}
	
	/**
	 * class Foo {
	 *   public $foo = $bar, $buz = $qux->norf;
	 * }
	 */
	@Test
	public void testPropertyElement() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testPropertyElement");

		ASTNode node = ast.getNodeById((long)14);
		Collection<UseOrDef> useOrDefs = analyze(node);

		assertEquals( 2, useOrDefs.size());
		assertTrue( containsDefSymbol( useOrDefs, node, "foo"));
		assertTrue( containsUseSymbol( useOrDefs, node, "bar"));
		
		ASTNode node2 = ast.getNodeById((long)18);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);

		assertEquals( 2, useOrDefs2.size());
		assertTrue( containsDefSymbol( useOrDefs2, node2, "buz"));
		assertTrue( containsUseSymbol( useOrDefs2, node2, "qux"));
	}
	
	/**
	 * const FOO = $bar, BUZ = $qux->norf;
	 */
	@Test
	public void testConstantElement() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testConstantElement");

		ASTNode node = ast.getNodeById((long)7);
		Collection<UseOrDef> useOrDefs = analyze(node);

		assertEquals( 2, useOrDefs.size());
		assertTrue( containsDefSymbol( useOrDefs, node, "FOO"));
		assertTrue( containsUseSymbol( useOrDefs, node, "bar"));
		
		ASTNode node2 = ast.getNodeById((long)11);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);

		assertEquals( 2, useOrDefs2.size());
		assertTrue( containsDefSymbol( useOrDefs2, node2, "BUZ"));
		assertTrue( containsUseSymbol( useOrDefs2, node2, "qux"));
	}
	
	/**
	 * while($foo) {}
	 * while(true) {}
	 * while(somecall()) {}
	 * while($var === 1) {}
	 */
	@Test
	public void testWhile() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testWhile");

		ASTNode node = ast.getNodeById((long)7);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertEquals( 1, useOrDefs.size());
		assertTrue( containsUseSymbol( useOrDefs, node, "foo"));
		
		ASTNode node2 = ast.getNodeById((long)11);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);
		
		assertEquals( 1, useOrDefs2.size());
		assertTrue( containsUseSymbol( useOrDefs2, node2, "true"));
		
		ASTNode node3 = ast.getNodeById((long)16);
		Collection<UseOrDef> useOrDefs3 = analyze(node3);

		assertTrue( useOrDefs3.isEmpty());
		
		ASTNode node4 = ast.getNodeById((long)22);
		Collection<UseOrDef> useOrDefs4 = analyze(node4);

		assertEquals( 1, useOrDefs4.size());
		assertTrue( containsUseSymbol( useOrDefs4, node4, "var"));
	}
	
	/**
	 * do {} while($foo);
	 * do {} while(true);
	 * do {} while(somecall());
	 * do {} while($var === 1);
	 */
	@Test
	public void testDo() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testDo");

		ASTNode node = ast.getNodeById((long)8);
		Collection<UseOrDef> useOrDefs = analyze(node);

		assertEquals( 1, useOrDefs.size());
		assertTrue( containsUseSymbol( useOrDefs, node, "foo"));
		
		ASTNode node2 = ast.getNodeById((long)12);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);

		assertEquals( 1, useOrDefs2.size());
		assertTrue( containsUseSymbol( useOrDefs2, node2, "true"));
		
		ASTNode node3 = ast.getNodeById((long)17);
		Collection<UseOrDef> useOrDefs3 = analyze(node3);

		assertTrue( useOrDefs3.isEmpty());
		
		ASTNode node4 = ast.getNodeById((long)23);
		Collection<UseOrDef> useOrDefs4 = analyze(node4);

		assertEquals( 1, useOrDefs4.size());
		assertTrue( containsUseSymbol( useOrDefs4, node4, "var"));
	}
	
	/**
	 * if($foo) {}
	 * elseif($bar) {}
	 * elseif($buz) {}
	 * else {}
	 */
	@Test
	public void testIfElement() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testIf");

		ASTNode node = ast.getNodeById((long)8);
		Collection<UseOrDef> useOrDefs = analyze(node);

		assertEquals( 1, useOrDefs.size());
		assertTrue( containsUseSymbol( useOrDefs, node, "foo"));
		
		ASTNode node2 = ast.getNodeById((long)12);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);

		assertEquals( 1, useOrDefs2.size());
		assertTrue( containsUseSymbol( useOrDefs2, node2, "bar"));
		
		ASTNode node3 = ast.getNodeById((long)16);
		Collection<UseOrDef> useOrDefs3 = analyze(node3);
		
		assertEquals( 1, useOrDefs3.size());
		assertTrue( containsUseSymbol( useOrDefs3, node3, "buz"));
		
		ASTNode node4 = ast.getNodeById((long)20);
		Collection<UseOrDef> useOrDefs4 = analyze(node4);

		assertTrue( useOrDefs4.isEmpty());
	}
	
	/**
	 * switch ($i) {
	 *   case "foo":
	 *     break;
	 *   case 1.42:
	 *   case 2:
	 *     break;
	 *   default:
	 *     buz();
	 * }
	 */
	@Test
	public void testSwitch() throws IOException, InvalidCSVFile
	{
		// TODO This is temporary.
		// Until there is no solution for 'switch' nodes in CFG creation,
		// we cannot really know which nodes should be analyzed in this context,
		// and how to tackle them.
		
		handleCSVFiles( "testSwitch");

		ASTNode node = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertEquals( 1, useOrDefs.size());
		assertTrue( containsUseSymbol( useOrDefs, node, "i"));
	}
	
	/**
	 * for ($i = 0, $j = 1; $i < 3; $i++, $j++) {}
	 */
	@Test
	public void testFor() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testFor");

		ASTNode node = ast.getNodeById((long)16);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertEquals( 1, useOrDefs.size());
		assertTrue( containsUseSymbol( useOrDefs, ast.getNodeById((long)17), "i"));
	}
	
	/**
	 * foreach ($somearray as $foo) {}
	 * foreach (somecall() as $bar => $buz) {}
	 * foreach ($someobj->qux as $someobj->norf => $someobj->nicknack) {}
	 */
	@Test
	public void testForEach() throws IOException, InvalidCSVFile
	{
		// TODO This is temporary.
		// Currently CFG generation ignores the defined key/value pairs and
		// considers only the iterated object as condition. This should be
		// improved by introducing an explicit ForEachCondition object in the
		// AST that can then be tested here instead of the whole ForEachStatement.
		
		handleCSVFiles( "testForEach");

		ASTNode node = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertEquals( 2, useOrDefs.size());
		assertTrue( containsUseSymbol( useOrDefs, node, "somearray"));
		assertTrue( containsDefSymbol( useOrDefs, node, "foo"));
		
		ASTNode node2 = ast.getNodeById((long)13);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);
		
		assertEquals( 2, useOrDefs2.size());
		assertTrue( containsDefSymbol( useOrDefs2, node2, "bar"));
		assertTrue( containsDefSymbol( useOrDefs2, node2, "buz"));
		
		ASTNode node3 = ast.getNodeById((long)23);
		Collection<UseOrDef> useOrDefs3 = analyze(node3);
		
		assertEquals( 2, useOrDefs3.size());
		assertTrue( containsDefSymbol( useOrDefs3, node3, "someobj"));
		assertTrue( containsDefSymbol( useOrDefs3, node3, "someobj"));
	}
	
	
	
	/* -- Expressions/statements that generate DEFs *and* USEs for -- */
	/* -- all their children symbols                               -- */
	
	/**
	 * ++$i;
	 */
	@Test
	public void testPreInc() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testPreInc");

		ASTNode node = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertEquals( 2, useOrDefs.size());
		assertTrue( containsDefSymbol( useOrDefs, node, "i"));
		assertTrue( containsUseSymbol( useOrDefs, node, "i"));
	}
	
	/**
	 * --$i;
	 */
	@Test
	public void testPreDec() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testPreDec");

		ASTNode node = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertEquals( 2, useOrDefs.size());
		assertTrue( containsDefSymbol( useOrDefs, node, "i"));
		assertTrue( containsUseSymbol( useOrDefs, node, "i"));
	}
	
	/**
	 * $i++;
	 */
	@Test
	public void testPostInc() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testPostInc");

		ASTNode node = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertEquals( 2, useOrDefs.size());
		assertTrue( containsDefSymbol( useOrDefs, node, "i"));
		assertTrue( containsUseSymbol( useOrDefs, node, "i"));
	}
	
	/**
	 * $i--;
	 */
	@Test
	public void testPostDec() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testPostDec");

		ASTNode node = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertEquals( 2, useOrDefs.size());
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
		handleCSVFiles( "testEmpty");

		ASTNode node = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertEquals( 1, useOrDefs.size());
		assertTrue( containsUseSymbol( useOrDefs, node, "foo"));
		
		ASTNode node2 = ast.getNodeById((long)9);
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
		handleCSVFiles( "testIsset");

		ASTNode node = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertEquals( 1, useOrDefs.size());
		assertTrue( containsUseSymbol( useOrDefs, node, "foo"));
		
		ASTNode node2 = ast.getNodeById((long)9);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);
		
		assertEquals( 1, useOrDefs2.size());
		assertTrue( containsUseSymbol( useOrDefs2, node2, "bar"));
	}
	
	/**
	 * $output = `cat /var/www/html/.htpasswd`;
	 * $output2 = `$attackerinput`;
	 */
	@Test
	public void testShellExec() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testShellExec");

		ASTNode node = ast.getNodeById((long)9);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertTrue( useOrDefs.isEmpty());
		
		ASTNode node2 = ast.getNodeById((long)14);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);
		
		assertEquals( 1, useOrDefs2.size());
		assertTrue( containsUseSymbol( useOrDefs2, node2, "attackerinput"));
	}
	
	/**
	 * clone($foo);
	 * clone(bar());
	 */
	@Test
	public void testClone() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testClone");

		ASTNode node = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertEquals( 1, useOrDefs.size());
		assertTrue( containsUseSymbol( useOrDefs, node, "foo"));
		
		ASTNode node2 = ast.getNodeById((long)9);
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
		handleCSVFiles( "testExit");

		ASTNode node = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertEquals( 1, useOrDefs.size());
		assertTrue( containsUseSymbol( useOrDefs, node, "foo"));
		
		ASTNode node2 = ast.getNodeById((long)9);
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
		handleCSVFiles( "testPrint");

		ASTNode node = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertEquals( 1, useOrDefs.size());
		assertTrue( containsUseSymbol( useOrDefs, node, "foo"));
		
		
		ASTNode node2 = ast.getNodeById((long)9);
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
		handleCSVFiles( "testIncludeOrEval");

		ASTNode node = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertTrue( useOrDefs.isEmpty());
		
		ASTNode node2 = ast.getNodeById((long)8);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);
		
		assertEquals( 1, useOrDefs2.size());
		assertTrue( containsUseSymbol( useOrDefs2, node2, "userinput"));
		
		ASTNode node3 = ast.getNodeById((long)11);
		Collection<UseOrDef> useOrDefs3 = analyze(node3);
		
		assertTrue( useOrDefs3.isEmpty());
		
		ASTNode node4 = ast.getNodeById((long)16);
		Collection<UseOrDef> useOrDefs4 = analyze(node4);
		
		assertEquals( 1, useOrDefs4.size());
		assertTrue( containsUseSymbol( useOrDefs4, ast.getNodeById((long)18), "userinput"));
		
		ASTNode node5 = ast.getNodeById((long)23);
		Collection<UseOrDef> useOrDefs5 = analyze(node5);
		
		assertEquals( 1, useOrDefs5.size());
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
		handleCSVFiles( "testYieldFrom");

		ASTNode node = ast.getNodeById((long)25);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertEquals( 1, useOrDefs.size());
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
		handleCSVFiles( "testReturn");

		ASTNode node = ast.getNodeById((long)25);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertEquals( 1, useOrDefs.size());
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
		handleCSVFiles( "testEcho");

		ASTNode node = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertEquals( 1, useOrDefs.size());
		assertTrue( containsUseSymbol( useOrDefs, node, "foo"));
		
		ASTNode node2 = ast.getNodeById((long)9);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);
		
		assertEquals( 1, useOrDefs2.size());
		assertTrue( containsUseSymbol( useOrDefs2, node2, "bar"));
		
		ASTNode node3 = ast.getNodeById((long)12);
		Collection<UseOrDef> useOrDefs3 = analyze(node3);
		
		assertEquals( 1, useOrDefs3.size());
		assertTrue( containsUseSymbol( useOrDefs3, node3, "PHP_EOL"));
		
		ASTNode node4 = ast.getNodeById((long)16);
		Collection<UseOrDef> useOrDefs4 = analyze(node4);
		
		assertEquals( 3, useOrDefs4.size());
		assertTrue( containsUseSymbol( useOrDefs4, ast.getNodeById((long)18), "buz"));
		assertTrue( containsUseSymbol( useOrDefs4, ast.getNodeById((long)18), "qux"));
		assertTrue( containsUseSymbol( useOrDefs4, ast.getNodeById((long)17), "PHP_EOL"));
		
		ASTNode node5 = ast.getNodeById((long)26);
		Collection<UseOrDef> useOrDefs5 = analyze(node5);
		
		assertEquals( 2, useOrDefs5.size());
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
		handleCSVFiles( "testThrow");

		ASTNode node = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs = analyze(node);
		assertEquals( 1, useOrDefs.size());
		// TODO: special case! In this case the UseOrDef object contains a reference
		// to the NewExpression node generated by the "new" statement, rather than
		// a reference to the ThrowStatement. This is because the NewExpression is
		// the innermost environment which emits the USE symbol. Is this a problem,
		// is it actually what we want, or does it not matter?
		// (That's why we pass 'ast.getNodeById((long)7)' instead of 'node' below,
		// at any rate.)
		assertTrue( containsUseSymbol( useOrDefs, ast.getNodeById((long)7), "error"));
		
		ASTNode node2 = ast.getNodeById((long)13);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);
		
		assertEquals( 2, useOrDefs2.size());
		// TODO: special case! In this case the UseOrDef object contains a reference
		// to the NewExpression node generated by the "new" statement, rather than
		// a reference to the ThrowStatement. This is because the NewExpression is
		// the innermost environment which emits the USE symbol. Is this a problem,
		// is it actually what we want, or does it not matter?
		// (That's why we pass 'ast.getNodeById((long)11)' instead of 'node2' below,
		// at any rate.)
		assertTrue( containsUseSymbol( useOrDefs2, ast.getNodeById((long)14), "bar"));
		assertTrue( containsUseSymbol( useOrDefs2, ast.getNodeById((long)14), "buz"));
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
		handleCSVFiles( "testYield");

		ASTNode node = ast.getNodeById((long)27);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertEquals( 2, useOrDefs.size());
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
		handleCSVFiles( "testCall");

		ASTNode node = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs = analyze(node);

		assertEquals( 1, useOrDefs.size());
		assertTrue( containsUseSymbol( useOrDefs, node, "bar"));
		
		ASTNode node2 = ast.getNodeById((long)13);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);
		
		assertEquals( 1, useOrDefs2.size());
		assertTrue( containsUseSymbol( useOrDefs2, node2, "buz"));
	}
	
	/**
	 * new Foo($bar);
	 * new $buz();
	 * new class() extends A implements B, C {};
	 */
	@Test
	public void testNew() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testNew");

		ASTNode node = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertEquals( 1, useOrDefs.size());
		assertTrue( containsUseSymbol( useOrDefs, node, "bar"));
		
		ASTNode node2 = ast.getNodeById((long)12);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);
		
		assertEquals( 1, useOrDefs2.size());
		assertTrue( containsUseSymbol( useOrDefs2, node2, "buz"));
		
		ASTNode node3 = ast.getNodeById((long)16);
		Collection<UseOrDef> useOrDefs3 = analyze(node3);
		
		assertTrue( useOrDefs3.isEmpty());
	}
	
	/**
	 * $buz->foo($bar, "yabadabadoo");
	 * buz()->$foo($bar, "yabadabadoo");
	 */
	@Test
	public void testMethodCall() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testMethodCall");

		ASTNode node = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertEquals( 2, useOrDefs.size());
		assertTrue( containsUseSymbol( useOrDefs, node, "buz"));
		assertTrue( containsUseSymbol( useOrDefs, node, "bar"));
		
		ASTNode node2 = ast.getNodeById((long)14);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);
		
		assertEquals( 2, useOrDefs2.size());
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
		handleCSVFiles( "testStaticCall");

		ASTNode node = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertEquals( 1, useOrDefs.size());
		assertTrue( containsUseSymbol( useOrDefs, node, "buz"));
		
		ASTNode node2 = ast.getNodeById((long)13);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);

		assertEquals( 2, useOrDefs2.size());
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
		handleCSVFiles( "testGlobal");

		ASTNode node = ast.getNodeById((long)12);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertEquals( 1, useOrDefs.size());
		assertTrue( containsDefSymbol( useOrDefs, node, "bar"));
		
		ASTNode node2 = ast.getNodeById((long)15);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);
		
		assertEquals( 1, useOrDefs2.size());
		assertTrue( containsDefSymbol( useOrDefs2, node2, "buz"));
	}
	
	/**
	 * unset($foo,$bar->buz,$qux[42]);
	 */
	@Test
	public void testUnset() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testUnset");

		ASTNode node = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertEquals( 1, useOrDefs.size());
		assertTrue( containsDefSymbol( useOrDefs, node, "foo"));
		
		ASTNode node2 = ast.getNodeById((long)9);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);
		
		assertEquals( 1, useOrDefs2.size());
		assertTrue( containsDefSymbol( useOrDefs2, node2, "bar"));
		
		ASTNode node3 = ast.getNodeById((long)14);
		Collection<UseOrDef> useOrDefs3 = analyze(node3);
		
		assertEquals( 1, useOrDefs3.size());
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
		handleCSVFiles( "testCatch");

		ASTNode node = ast.getNodeById((long)9);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertEquals( 1, useOrDefs.size());
		assertTrue( containsDefSymbol( useOrDefs, node, "f"));
		
		ASTNode node2 = ast.getNodeById((long)15);
		Collection<UseOrDef> useOrDefs2 = analyze(node2);
		
		assertEquals( 1, useOrDefs2.size());
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
		handleCSVFiles( "testFunctionDef");

		ASTNode node = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertEquals( 2, useOrDefs.size());
		assertTrue( containsDefSymbol( useOrDefs, ast.getNodeById((long)10), "bar"));
		assertTrue( containsDefSymbol( useOrDefs, ast.getNodeById((long)14), "buz"));
	}

	/**
	 * function($bar,&$buz) use ($qux,&$norf) {};
	 */
	@Test
	public void testClosure() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testClosure");

		ASTNode node = ast.getNodeById((long)6);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertEquals( 2, useOrDefs.size());
		assertTrue( containsDefSymbol( useOrDefs, ast.getNodeById((long)10), "bar"));
		assertTrue( containsDefSymbol( useOrDefs, ast.getNodeById((long)14), "buz"));
		// TODO: think about how to handle closure variables; when analyzing
		// a closure itself, the use variables should emit DEFs, like parameters;
		// but when analyzing a function which simply contains a closure declaration,
		// the use variables should emit neither USEs nor DEFs (actually, the same
		// is true for a closure's parameters)
		//assertTrue( containsDefSymbol( useOrDefs, node, "qux"));
		//assertTrue( containsDefSymbol( useOrDefs, node, "norf"));
	}
	
	/**
	 * class Foo {
	 *   function foo($bar,&$buz) {}
	 * }
	 */
	@Test
	public void testMethod() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testMethod");

		ASTNode node = ast.getNodeById((long)13);
		Collection<UseOrDef> useOrDefs = analyze(node);
		
		assertEquals( 2, useOrDefs.size());
		assertTrue( containsDefSymbol( useOrDefs, ast.getNodeById((long)17), "bar"));
		assertTrue( containsDefSymbol( useOrDefs, ast.getNodeById((long)21), "buz"));
	}
}
