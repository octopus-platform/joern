package tests.languages.php.cgCreation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import ast.ASTNode;
import ast.expressions.CallExpression;
import ast.php.functionDef.PHPFunctionDef;
import cg.CG;
import cg.CGEdge;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import languages.php.cg.PHPCGFactory;
import tests.languages.php.PHPCSVFunctionExtractorBasedTest;

public class PHPCGCreatorTest extends PHPCSVFunctionExtractorBasedTest {

	// set sample directory
	@Before
	public void setSampleDir() {
		super.setSampleDir( "cgCreation");
	}
	
	
	/**
	 * For two CSV files in a given folder, initializes a function extractor, extracts all
	 * functions and stores them in the PHPCGFactory, then uses the PHPCGFactory
	 * to build a call graph and returns it.
	 */
	private CG buildCallGraph(String testDir) throws IOException, InvalidCSVFile {

		HashMap<String,PHPFunctionDef> funcs = getAllFuncASTs( testDir);

		for( PHPFunctionDef func : funcs.values())
			PHPCGFactory.addFunctionDef( func);

		CG cg = PHPCGFactory.newInstance();
		
		System.out.println();
		System.out.println("CG\n~~");
		System.out.println(cg);

		return cg;
	}
	
	/**
	 * Checks whether an edge exists in a given CG from a given
	 * source node to a given destination node.
	 */
	private boolean edgeExists( CG cg, long srcid, long dstid) {
			
		for (CGEdge cgEdge : cg.getEdges()) {
			
			ASTNode srcNode = cgEdge.getSource().getASTNode();
			ASTNode dstNode = cgEdge.getDestination().getASTNode();
					
			assert srcNode instanceof CallExpression;
			assert dstNode instanceof PHPFunctionDef;

			if( srcNode.getNodeId().equals( srcid) && dstNode.getNodeId().equals( dstid))
				return true;
		}

		return false;
	}
	
	
	/* **************** *
	 * The actual tests *
	 * **************** */
	
	/**
	 * function funcone() {
	 *   funcone();
	 *   functwo("foo");
	 * }
	 * 
	 * function functwo($a) {
	 *   funcone();
	 *   functwo("bar");
	 * }
	 * 
	 * funcone();
	 * functwo();
	 */
	@Test
	public void testSimpleCalls() throws IOException, InvalidCSVFile
	{
		CG cg = buildCallGraph( "testSimpleCalls");
		
		// 8 nodes: 6 calls and 2 definitions
		assertEquals(8, cg.size());
		assertEquals(6, cg.numberOfCallers());
		assertEquals(2, cg.numberOfCallees());
		
		assertEquals(cg.numberOfEdges(), cg.numberOfCallers());

		assertTrue( edgeExists( cg, 12, 6));
		assertTrue( edgeExists( cg, 16, 22));
		assertTrue( edgeExists( cg, 32, 6));
		assertTrue( edgeExists( cg, 36, 22));
		assertTrue( edgeExists( cg, 42, 6));
		assertTrue( edgeExists( cg, 46, 22));
	}

	/**
     * foo.php
     * -------
     * 
     * include_once "bar.php";
     * 
     * function foo() {}
     * 
     * bar();
     * 
     * bar.php
     * -------
     * 
     * include_once "foo.php";
     * 
     * function bar() {}
     * 
     * foo();
	 */
	@Test
	public void testTwoFiles() throws IOException, InvalidCSVFile
	{
		CG cg = buildCallGraph( "testTwoFiles");
		
		// 4 nodes: 2 calls and 2 definitions
		assertEquals(4, cg.size());
		assertEquals(2, cg.numberOfCallers());
		assertEquals(2, cg.numberOfCallees());
		
		assertEquals(cg.numberOfEdges(), cg.numberOfCallers());

		assertTrue( edgeExists( cg, 15, 26));
		assertTrue( edgeExists( cg, 33, 8));
	}

}
