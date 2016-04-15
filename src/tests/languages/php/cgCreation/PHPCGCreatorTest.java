package tests.languages.php.cgCreation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

import ast.ASTNode;
import ast.expressions.CallExpression;
import ast.php.functionDef.PHPFunctionDef;
import cg.CG;
import cg.CGEdge;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import inputModules.csv.csvFuncExtractor.CSVFunctionExtractor;
import languages.php.cg.PHPCGFactory;
import tests.languages.php.samples.CSVASTCallSamples;

public class PHPCGCreatorTest {

	CSVFunctionExtractor extractor;

	@Before
	public void init() {
		this.extractor = new CSVFunctionExtractor();
		this.extractor.setLanguage("PHP");		
	}
	
	/**
	 * Initializes the function extractor for two given CSV strings (nodes and edges).
	 */
	protected void initFunctionExtractor(String nodeLines, String edgeLines)
			throws IOException, InvalidCSVFile {
		
		StringReader nodeReader = new StringReader(nodeLines);
		StringReader edgeReader = new StringReader(edgeLines);
		
		this.extractor.initialize(nodeReader, edgeReader);
	}
	
	/**
	 * For two given CSV strings, initializes a function extractor, extracts all
	 * functions and stores them in the PHPCGFactory, then uses the PHPCGFactory
	 * to build a call graph and returns it.
	 */
	private CG buildCallGraph(String nodeStr, String edgeStr) throws IOException, InvalidCSVFile {

		initFunctionExtractor(nodeStr, edgeStr);
		
		PHPFunctionDef rootnode;
		while( (rootnode = (PHPFunctionDef)extractor.getNextFunction()) != null) {			
			PHPCGFactory.addFunctionDef( rootnode);
		}
		
		CG cg = PHPCGFactory.newInstance();
		
		System.out.println();
		System.out.println("CG\n~~");
		System.out.println(cg);

		return cg;
	}
	
	/**
	 * Checks whether an edge exists in a given DDG from a given
	 * source node to a given destination node for a given symbol.
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
		String nodeStr = CSVASTCallSamples.simpleCallsNodeStr;
		String edgeStr = CSVASTCallSamples.simpleCallsEdgeStr;

		CG cg = buildCallGraph(nodeStr, edgeStr);
		
		// 8 nodes: 6 calls and 2 definitions
		assertEquals(8, cg.size());
		assertEquals(6, cg.numberOfCallers());
		assertEquals(2, cg.numberOfCallees());
		
		assertEquals(cg.numberOfEdges(), cg.numberOfCallers());

		assertTrue( edgeExists( cg, 7, 3));
		assertTrue( edgeExists( cg, 11, 17));
		assertTrue( edgeExists( cg, 25, 3));
		assertTrue( edgeExists( cg, 29, 17));
		assertTrue( edgeExists( cg, 35, 3));
		assertTrue( edgeExists( cg, 39, 17));
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
		String nodeStr = CSVASTCallSamples.twoFilesNodeStr;
		String edgeStr = CSVASTCallSamples.twoFilesEdgeStr;

		CG cg = buildCallGraph(nodeStr, edgeStr);
		
		// 4 nodes: 2 calls and 2 definitions
		assertEquals(4, cg.size());
		assertEquals(2, cg.numberOfCallers());
		assertEquals(2, cg.numberOfCallees());
		
		assertEquals(cg.numberOfEdges(), cg.numberOfCallers());

		assertTrue( edgeExists( cg, 11, 20));
		assertTrue( edgeExists( cg, 25, 6));
	}

}
