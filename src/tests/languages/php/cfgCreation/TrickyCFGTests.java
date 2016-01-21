package tests.languages.php.cfgCreation;


import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import cfg.CFG;
import cfg.nodes.CFGExceptionNode;
import cfg.nodes.CFGNode;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import tests.languages.php.samples.CSVASTSamples;

public class TrickyCFGTests extends PHPCFGCreatorTest {


	/* **************** *
	 * The actual tests *
	 * **************** */

	/**
	 * try {
	 *   foo();
	 *   bar();
	 * }
	 * catch(FooException $f) {
	 *   buz();
	 * }
	 * catch(BarException $b) {
	 *   qux();
	 * }
	 * finally {
	 *   norf();
	 * }
	 */
	@Test
	public void testCFGTryCatchFinally() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTSamples.nodeHeader;
		nodeStr += "2,AST_STMT_LIST,,1,,0,1,,,\n";
		nodeStr += "3,AST_TRY,,3,,0,1,,,\n";
		nodeStr += "4,AST_STMT_LIST,,3,,0,1,,,\n";
		nodeStr += "5,AST_CALL,,4,,0,1,,,\n";
		nodeStr += "6,AST_NAME,NAME_NOT_FQ,4,,0,1,,,\n";
		nodeStr += "7,string,,4,\"foo\",0,1,,,\n";
		nodeStr += "8,AST_ARG_LIST,,4,,1,1,,,\n";
		nodeStr += "9,AST_CALL,,5,,1,1,,,\n";
		nodeStr += "10,AST_NAME,NAME_NOT_FQ,5,,0,1,,,\n";
		nodeStr += "11,string,,5,\"bar\",0,1,,,\n";
		nodeStr += "12,AST_ARG_LIST,,5,,1,1,,,\n";
		nodeStr += "13,AST_CATCH_LIST,,6,,1,1,,,\n";
		nodeStr += "14,AST_CATCH,,7,,0,1,,,\n";
		nodeStr += "15,AST_NAME,NAME_NOT_FQ,7,,0,1,,,\n";
		nodeStr += "16,string,,7,\"FooException\",0,1,,,\n";
		nodeStr += "17,string,,7,\"f\",1,1,,,\n";
		nodeStr += "18,AST_STMT_LIST,,7,,2,1,,,\n";
		nodeStr += "19,AST_CALL,,8,,0,1,,,\n";
		nodeStr += "20,AST_NAME,NAME_NOT_FQ,8,,0,1,,,\n";
		nodeStr += "21,string,,8,\"buz\",0,1,,,\n";
		nodeStr += "22,AST_ARG_LIST,,8,,1,1,,,\n";
		nodeStr += "23,AST_CATCH,,10,,1,1,,,\n";
		nodeStr += "24,AST_NAME,NAME_NOT_FQ,10,,0,1,,,\n";
		nodeStr += "25,string,,10,\"BarException\",0,1,,,\n";
		nodeStr += "26,string,,10,\"b\",1,1,,,\n";
		nodeStr += "27,AST_STMT_LIST,,10,,2,1,,,\n";
		nodeStr += "28,AST_CALL,,11,,0,1,,,\n";
		nodeStr += "29,AST_NAME,NAME_NOT_FQ,11,,0,1,,,\n";
		nodeStr += "30,string,,11,\"qux\",0,1,,,\n";
		nodeStr += "31,AST_ARG_LIST,,11,,1,1,,,\n";
		nodeStr += "32,AST_STMT_LIST,,13,,2,1,,,\n";
		nodeStr += "33,AST_CALL,,14,,0,1,,,\n";
		nodeStr += "34,AST_NAME,NAME_NOT_FQ,14,,0,1,,,\n";
		nodeStr += "35,string,,14,\"norf\",0,1,,,\n";
		nodeStr += "36,AST_ARG_LIST,,14,,1,1,,,\n";

		String edgeStr = CSVASTSamples.edgeHeader;
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "5,6,PARENT_OF\n";
		edgeStr += "5,8,PARENT_OF\n";
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "10,11,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "9,12,PARENT_OF\n";
		edgeStr += "4,9,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "15,16,PARENT_OF\n";
		edgeStr += "14,15,PARENT_OF\n";
		edgeStr += "14,17,PARENT_OF\n";
		edgeStr += "20,21,PARENT_OF\n";
		edgeStr += "19,20,PARENT_OF\n";
		edgeStr += "19,22,PARENT_OF\n";
		edgeStr += "18,19,PARENT_OF\n";
		edgeStr += "14,18,PARENT_OF\n";
		edgeStr += "13,14,PARENT_OF\n";
		edgeStr += "24,25,PARENT_OF\n";
		edgeStr += "23,24,PARENT_OF\n";
		edgeStr += "23,26,PARENT_OF\n";
		edgeStr += "29,30,PARENT_OF\n";
		edgeStr += "28,29,PARENT_OF\n";
		edgeStr += "28,31,PARENT_OF\n";
		edgeStr += "27,28,PARENT_OF\n";
		edgeStr += "23,27,PARENT_OF\n";
		edgeStr += "13,23,PARENT_OF\n";
		edgeStr += "3,13,PARENT_OF\n";
		edgeStr += "34,35,PARENT_OF\n";
		edgeStr += "33,34,PARENT_OF\n";
		edgeStr += "33,36,PARENT_OF\n";
		edgeStr += "32,33,PARENT_OF\n";
		edgeStr += "3,32,PARENT_OF\n";
		edgeStr += "2,3,PARENT_OF\n";

		CFG cfg = getCFGForCSVLines(nodeStr, edgeStr);
		CFGExceptionNode exceptionNode = cfg.getExceptionNode();


		Object[] calls = getNodesOfType(cfg, "ASTNodeContainer");

		assertEquals(5, calls.length);

		CFGNode foo = (CFGNode) calls[0];
		CFGNode bar = (CFGNode) calls[1];
		CFGNode buz = (CFGNode) calls[2];
		CFGNode qux = (CFGNode) calls[3];
		CFGNode norf = (CFGNode) calls[4];

		edgeExists(cfg, foo, bar);
		edgeExists(cfg, bar, norf);
		edgeExists(cfg, foo, exceptionNode);
		edgeExists(cfg, bar, exceptionNode);

		edgeExists(cfg, exceptionNode, buz);
		edgeExists(cfg, exceptionNode, qux);

		edgeExists(cfg, buz, norf);
		edgeExists(cfg, qux, norf);

	}

	/**
	 * foo();
	 * while(true) {
	 *   while(true) {
	 *     break 2;
	 *   }
	 *   bar();
	 * }
	 * buz();
	 */
	@Test
	public void testCFGBreak() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTSamples.nodeHeader;
		nodeStr += "2,AST_STMT_LIST,,1,,0,1,,,\n";
		nodeStr += "3,AST_CALL,,3,,0,1,,,\n";
		nodeStr += "4,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"foo\",0,1,,,\n";
		nodeStr += "6,AST_ARG_LIST,,3,,1,1,,,\n";
		nodeStr += "7,AST_WHILE,,4,,1,1,,,\n";
		nodeStr += "8,AST_CONST,,4,,0,1,,,\n";
		nodeStr += "9,AST_NAME,NAME_NOT_FQ,4,,0,1,,,\n";
		nodeStr += "10,string,,4,\"true\",0,1,,,\n";
		nodeStr += "11,AST_STMT_LIST,,4,,1,1,,,\n";
		nodeStr += "12,AST_WHILE,,5,,0,1,,,\n";
		nodeStr += "13,AST_CONST,,5,,0,1,,,\n";
		nodeStr += "14,AST_NAME,NAME_NOT_FQ,5,,0,1,,,\n";
		nodeStr += "15,string,,5,\"true\",0,1,,,\n";
		nodeStr += "16,AST_STMT_LIST,,5,,1,1,,,\n";
		nodeStr += "17,AST_BREAK,,6,,0,1,,,\n";
		nodeStr += "18,integer,,6,2,0,1,,,\n";
		nodeStr += "19,AST_CALL,,8,,1,1,,,\n";
		nodeStr += "20,AST_NAME,NAME_NOT_FQ,8,,0,1,,,\n";
		nodeStr += "21,string,,8,\"bar\",0,1,,,\n";
		nodeStr += "22,AST_ARG_LIST,,8,,1,1,,,\n";
		nodeStr += "23,AST_CALL,,10,,2,1,,,\n";
		nodeStr += "24,AST_NAME,NAME_NOT_FQ,10,,0,1,,,\n";
		nodeStr += "25,string,,10,\"buz\",0,1,,,\n";
		nodeStr += "26,AST_ARG_LIST,,10,,1,1,,,\n";

		String edgeStr = CSVASTSamples.edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "2,3,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "14,15,PARENT_OF\n";
		edgeStr += "13,14,PARENT_OF\n";
		edgeStr += "12,13,PARENT_OF\n";
		edgeStr += "17,18,PARENT_OF\n";
		edgeStr += "16,17,PARENT_OF\n";
		edgeStr += "12,16,PARENT_OF\n";
		edgeStr += "11,12,PARENT_OF\n";
		edgeStr += "20,21,PARENT_OF\n";
		edgeStr += "19,20,PARENT_OF\n";
		edgeStr += "19,22,PARENT_OF\n";
		edgeStr += "11,19,PARENT_OF\n";
		edgeStr += "7,11,PARENT_OF\n";
		edgeStr += "2,7,PARENT_OF\n";
		edgeStr += "24,25,PARENT_OF\n";
		edgeStr += "23,24,PARENT_OF\n";
		edgeStr += "23,26,PARENT_OF\n";
		edgeStr += "2,23,PARENT_OF\n";

		// Problem:
		// edge from 17 to 19 should not be there;
		// instead, there should be an edge from 17 to 23
		System.out.println(getCFGForCSVLines(nodeStr, edgeStr));
	}

	/**
	 * foo();
	 * while(true) {
	 *   while(true) {
	 *     while(true) {
	 *       continue 3;
	 *     }
	 *     bar();
	 *   }
	 *   buz();
	 * }
	 * qux();
	 */
	@Test
	public void testCFGContinue() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTSamples.nodeHeader;
		nodeStr += "2,AST_STMT_LIST,,1,,0,1,,,\n";
		nodeStr += "3,AST_CALL,,3,,0,1,,,\n";
		nodeStr += "4,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"foo\",0,1,,,\n";
		nodeStr += "6,AST_ARG_LIST,,3,,1,1,,,\n";
		nodeStr += "7,AST_WHILE,,4,,1,1,,,\n";
		nodeStr += "8,AST_CONST,,4,,0,1,,,\n";
		nodeStr += "9,AST_NAME,NAME_NOT_FQ,4,,0,1,,,\n";
		nodeStr += "10,string,,4,\"true\",0,1,,,\n";
		nodeStr += "11,AST_STMT_LIST,,4,,1,1,,,\n";
		nodeStr += "12,AST_WHILE,,5,,0,1,,,\n";
		nodeStr += "13,AST_CONST,,5,,0,1,,,\n";
		nodeStr += "14,AST_NAME,NAME_NOT_FQ,5,,0,1,,,\n";
		nodeStr += "15,string,,5,\"true\",0,1,,,\n";
		nodeStr += "16,AST_STMT_LIST,,5,,1,1,,,\n";
		nodeStr += "17,AST_WHILE,,6,,0,1,,,\n";
		nodeStr += "18,AST_CONST,,6,,0,1,,,\n";
		nodeStr += "19,AST_NAME,NAME_NOT_FQ,6,,0,1,,,\n";
		nodeStr += "20,string,,6,\"true\",0,1,,,\n";
		nodeStr += "21,AST_STMT_LIST,,6,,1,1,,,\n";
		nodeStr += "22,AST_CONTINUE,,7,,0,1,,,\n";
		nodeStr += "23,integer,,7,3,0,1,,,\n";
		nodeStr += "24,AST_CALL,,9,,1,1,,,\n";
		nodeStr += "25,AST_NAME,NAME_NOT_FQ,9,,0,1,,,\n";
		nodeStr += "26,string,,9,\"bar\",0,1,,,\n";
		nodeStr += "27,AST_ARG_LIST,,9,,1,1,,,\n";
		nodeStr += "28,AST_CALL,,11,,1,1,,,\n";
		nodeStr += "29,AST_NAME,NAME_NOT_FQ,11,,0,1,,,\n";
		nodeStr += "30,string,,11,\"buz\",0,1,,,\n";
		nodeStr += "31,AST_ARG_LIST,,11,,1,1,,,\n";
		nodeStr += "32,AST_CALL,,13,,2,1,,,\n";
		nodeStr += "33,AST_NAME,NAME_NOT_FQ,13,,0,1,,,\n";
		nodeStr += "34,string,,13,\"qux\",0,1,,,\n";
		nodeStr += "35,AST_ARG_LIST,,13,,1,1,,,\n";

		String edgeStr = CSVASTSamples.edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "2,3,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "14,15,PARENT_OF\n";
		edgeStr += "13,14,PARENT_OF\n";
		edgeStr += "12,13,PARENT_OF\n";
		edgeStr += "19,20,PARENT_OF\n";
		edgeStr += "18,19,PARENT_OF\n";
		edgeStr += "17,18,PARENT_OF\n";
		edgeStr += "22,23,PARENT_OF\n";
		edgeStr += "21,22,PARENT_OF\n";
		edgeStr += "17,21,PARENT_OF\n";
		edgeStr += "16,17,PARENT_OF\n";
		edgeStr += "25,26,PARENT_OF\n";
		edgeStr += "24,25,PARENT_OF\n";
		edgeStr += "24,27,PARENT_OF\n";
		edgeStr += "16,24,PARENT_OF\n";
		edgeStr += "12,16,PARENT_OF\n";
		edgeStr += "11,12,PARENT_OF\n";
		edgeStr += "29,30,PARENT_OF\n";
		edgeStr += "28,29,PARENT_OF\n";
		edgeStr += "28,31,PARENT_OF\n";
		edgeStr += "11,28,PARENT_OF\n";
		edgeStr += "7,11,PARENT_OF\n";
		edgeStr += "2,7,PARENT_OF\n";
		edgeStr += "33,34,PARENT_OF\n";
		edgeStr += "32,33,PARENT_OF\n";
		edgeStr += "32,35,PARENT_OF\n";
		edgeStr += "2,32,PARENT_OF\n";

		// Problem:
		// edge from 22 to 18 should not be there;
		// instead, there should be an edge from 22 to 8
		System.out.println(getCFGForCSVLines(nodeStr, edgeStr));
	}

	/**
	 * true ? "foo" : "bar";
	 */
	@Test
	public void testCFGConditional() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTSamples.nodeHeader;
		nodeStr += "3,AST_CONDITIONAL,,3,,0,1,,,\n";
		nodeStr += "4,AST_CONST,,3,,0,1,,,\n";
		nodeStr += "5,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n";
		nodeStr += "6,string,,3,\"true\",0,1,,,\n";
		nodeStr += "7,string,,3,\"foo\",1,1,,,\n";
		nodeStr += "8,string,,3,\"bar\",2,1,,,\n";

		String edgeStr = CSVASTSamples.edgeHeader;
		edgeStr += "5,6,PARENT_OF\n";
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,7,PARENT_OF\n";
		edgeStr += "3,8,PARENT_OF\n";

		// Problem:
		// treated as a normal statement;
		// instead of a CFG node for 3,
		// there should be three CFG nodes for nodes 4, 7 and 8,
		// with a [true] edge from 4 to 7 and a [false] edge from 4 to 8.
		System.out.println(getCFGForCSVLines(nodeStr, edgeStr));
	}

	/**
	 * foo();
	 * switch ($i) {
	 *   case "foo":
	 *     break;
	 *   case 1.42:
	 *   case 2:
	 *     break;
	 *   default:
	 *     buz();
	 *   }
	 * bar();
	 */
	@Test
	public void testCFGSwitch() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTSamples.nodeHeader;
		nodeStr += "2,AST_STMT_LIST,,1,,0,1,,,\n";
		nodeStr += "3,AST_CALL,,3,,0,1,,,\n";
		nodeStr += "4,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"foo\",0,1,,,\n";
		nodeStr += "6,AST_ARG_LIST,,3,,1,1,,,\n";
		nodeStr += "7,AST_SWITCH,,4,,1,1,,,\n";
		nodeStr += "8,AST_VAR,,4,,0,1,,,\n";
		nodeStr += "9,string,,4,\"i\",0,1,,,\n";
		nodeStr += "10,AST_SWITCH_LIST,,5,,1,1,,,\n";
		nodeStr += "11,AST_SWITCH_CASE,,5,,0,1,,,\n";
		nodeStr += "12,string,,5,\"foo\",0,1,,,\n";
		nodeStr += "13,AST_STMT_LIST,,5,,1,1,,,\n";
		nodeStr += "14,AST_BREAK,,6,,0,1,,,\n";
		nodeStr += "15,NULL,,6,,0,1,,,\n";
		nodeStr += "16,AST_SWITCH_CASE,,7,,1,1,,,\n";
		nodeStr += "17,double,,7,1.42,0,1,,,\n";
		nodeStr += "18,AST_STMT_LIST,,7,,1,1,,,\n";
		nodeStr += "19,AST_SWITCH_CASE,,8,,2,1,,,\n";
		nodeStr += "20,integer,,8,2,0,1,,,\n";
		nodeStr += "21,AST_STMT_LIST,,8,,1,1,,,\n";
		nodeStr += "22,AST_BREAK,,9,,0,1,,,\n";
		nodeStr += "23,NULL,,9,,0,1,,,\n";
		nodeStr += "24,AST_SWITCH_CASE,,10,,3,1,,,\n";
		nodeStr += "25,NULL,,10,,0,1,,,\n";
		nodeStr += "26,AST_STMT_LIST,,10,,1,1,,,\n";
		nodeStr += "27,AST_CALL,,11,,0,1,,,\n";
		nodeStr += "28,AST_NAME,NAME_NOT_FQ,11,,0,1,,,\n";
		nodeStr += "29,string,,11,\"buz\",0,1,,,\n";
		nodeStr += "30,AST_ARG_LIST,,11,,1,1,,,\n";
		nodeStr += "31,AST_CALL,,13,,2,1,,,\n";
		nodeStr += "32,AST_NAME,NAME_NOT_FQ,13,,0,1,,,\n";
		nodeStr += "33,string,,13,\"bar\",0,1,,,\n";
		nodeStr += "34,AST_ARG_LIST,,13,,1,1,,,\n";

		String edgeStr = CSVASTSamples.edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "2,3,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "11,12,PARENT_OF\n";
		edgeStr += "14,15,PARENT_OF\n";
		edgeStr += "13,14,PARENT_OF\n";
		edgeStr += "11,13,PARENT_OF\n";
		edgeStr += "10,11,PARENT_OF\n";
		edgeStr += "16,17,PARENT_OF\n";
		edgeStr += "16,18,PARENT_OF\n";
		edgeStr += "10,16,PARENT_OF\n";
		edgeStr += "19,20,PARENT_OF\n";
		edgeStr += "22,23,PARENT_OF\n";
		edgeStr += "21,22,PARENT_OF\n";
		edgeStr += "19,21,PARENT_OF\n";
		edgeStr += "10,19,PARENT_OF\n";
		edgeStr += "24,25,PARENT_OF\n";
		edgeStr += "28,29,PARENT_OF\n";
		edgeStr += "27,28,PARENT_OF\n";
		edgeStr += "27,30,PARENT_OF\n";
		edgeStr += "26,27,PARENT_OF\n";
		edgeStr += "24,26,PARENT_OF\n";
		edgeStr += "10,24,PARENT_OF\n";
		edgeStr += "7,10,PARENT_OF\n";
		edgeStr += "2,7,PARENT_OF\n";
		edgeStr += "32,33,PARENT_OF\n";
		edgeStr += "31,32,PARENT_OF\n";
		edgeStr += "31,34,PARENT_OF\n";
		edgeStr += "2,31,PARENT_OF\n";

		// Problem:
		// no CFG nodes at all generated for switch statement or anything inside it;
		// instead, an [ERROR] node is generated for the entire switch statement
		System.out.println(getCFGForCSVLines(nodeStr, edgeStr));
	}

	/**
	 * "foo" ?? "bar";
	 */
	@Test
	public void testCFGCoalesce() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTSamples.nodeHeader;
		nodeStr += "3,AST_COALESCE,,3,,0,1,,,\n";
		nodeStr += "4,string,,3,\"foo\",0,1,,,\n";
		nodeStr += "5,string,,3,\"bar\",1,1,,,\n";

		String edgeStr = CSVASTSamples.edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";

		// Problem:
		// treated as a normal statement; can we do better?
		System.out.println(getCFGForCSVLines(nodeStr, edgeStr));
	}



	/**
	 * foo();
	 * foreach( $x as $y) { buz(); }
	 * bar();
	 */
	@Test
	public void testCFGForEach() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTSamples.nodeHeader;
		nodeStr += "2,AST_STMT_LIST,,1,,0,1,,,\n";
		nodeStr += "3,AST_CALL,,3,,0,1,,,\n";
		nodeStr += "4,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"foo\",0,1,,,\n";
		nodeStr += "6,AST_ARG_LIST,,3,,1,1,,,\n";
		nodeStr += "7,AST_FOREACH,,4,,1,1,,,\n";
		nodeStr += "8,AST_VAR,,4,,0,1,,,\n";
		nodeStr += "9,string,,4,\"x\",0,1,,,\n";
		nodeStr += "10,AST_VAR,,4,,1,1,,,\n";
		nodeStr += "11,string,,4,\"y\",0,1,,,\n";
		nodeStr += "12,NULL,,4,,2,1,,,\n";
		nodeStr += "13,AST_STMT_LIST,,4,,3,1,,,\n";
		nodeStr += "14,AST_CALL,,4,,0,1,,,\n";
		nodeStr += "15,AST_NAME,NAME_NOT_FQ,4,,0,1,,,\n";
		nodeStr += "16,string,,4,\"buz\",0,1,,,\n";
		nodeStr += "17,AST_ARG_LIST,,4,,1,1,,,\n";
		nodeStr += "18,AST_CALL,,5,,2,1,,,\n";
		nodeStr += "19,AST_NAME,NAME_NOT_FQ,5,,0,1,,,\n";
		nodeStr += "20,string,,5,\"bar\",0,1,,,\n";
		nodeStr += "21,AST_ARG_LIST,,5,,1,1,,,\n";

		String edgeStr = CSVASTSamples.edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "2,3,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "10,11,PARENT_OF\n";
		edgeStr += "7,10,PARENT_OF\n";
		edgeStr += "7,12,PARENT_OF\n";
		edgeStr += "15,16,PARENT_OF\n";
		edgeStr += "14,15,PARENT_OF\n";
		edgeStr += "14,17,PARENT_OF\n";
		edgeStr += "13,14,PARENT_OF\n";
		edgeStr += "7,13,PARENT_OF\n";
		edgeStr += "2,7,PARENT_OF\n";
		edgeStr += "19,20,PARENT_OF\n";
		edgeStr += "18,19,PARENT_OF\n";
		edgeStr += "18,21,PARENT_OF\n";
		edgeStr += "2,18,PARENT_OF\n";

		// Problem:
		// not even treated as a normal statement, the foreach node completely
		// disappears as if it had never been there in the first place; can we do better?
		System.out.println(getCFGForCSVLines(nodeStr, edgeStr));
	}

	/**
	 * //function foo() {
	 *   yield 42;
	 *   yield $somekey => bar();
	 *   buz();
	 * //}
	 *
	 * //foo();
	 */
	@Test
	public void testCFGYield() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTSamples.nodeHeader;
		//nodeStr += "2,AST_STMT_LIST,,1,,0,1,,,\n";
		//nodeStr += "3,AST_FUNC_DECL,,3,,0,1,7,foo,\n";
		//nodeStr += "4,AST_PARAM_LIST,,3,,0,3,,,\n";
		//nodeStr += "5,NULL,,3,,1,3,,,\n";
		nodeStr += "6,AST_STMT_LIST,,3,,2,3,,,\n";
		nodeStr += "7,AST_YIELD,,4,,0,3,,,\n";
		nodeStr += "8,integer,,4,42,0,3,,,\n";
		nodeStr += "9,NULL,,4,,1,3,,,\n";
		nodeStr += "10,AST_YIELD,,5,,1,3,,,\n";
		nodeStr += "11,AST_CALL,,5,,0,3,,,\n";
		nodeStr += "12,AST_NAME,NAME_NOT_FQ,5,,0,3,,,\n";
		nodeStr += "13,string,,5,\"bar\",0,3,,,\n";
		nodeStr += "14,AST_ARG_LIST,,5,,1,3,,,\n";
		nodeStr += "15,AST_VAR,,5,,1,3,,,\n";
		nodeStr += "16,string,,5,\"somekey\",0,3,,,\n";
		nodeStr += "17,AST_CALL,,6,,2,3,,,\n";
		nodeStr += "18,AST_NAME,NAME_NOT_FQ,6,,0,3,,,\n";
		nodeStr += "19,string,,6,\"buz\",0,3,,,\n";
		nodeStr += "20,AST_ARG_LIST,,6,,1,3,,,\n";
		//nodeStr += "21,NULL,,3,,3,3,,,\n";
		//nodeStr += "22,AST_CALL,,9,,1,1,,,\n";
		//nodeStr += "23,AST_NAME,NAME_NOT_FQ,9,,0,1,,,\n";
		//nodeStr += "24,string,,9,\"foo\",0,1,,,\n";
		//nodeStr += "25,AST_ARG_LIST,,9,,1,1,,,\n";

		String edgeStr = CSVASTSamples.edgeHeader;
		//edgeStr += "3,4,PARENT_OF\n";
		//edgeStr += "3,5,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "7,9,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "12,13,PARENT_OF\n";
		edgeStr += "11,12,PARENT_OF\n";
		edgeStr += "11,14,PARENT_OF\n";
		edgeStr += "10,11,PARENT_OF\n";
		edgeStr += "15,16,PARENT_OF\n";
		edgeStr += "10,15,PARENT_OF\n";
		edgeStr += "6,10,PARENT_OF\n";
		edgeStr += "18,19,PARENT_OF\n";
		edgeStr += "17,18,PARENT_OF\n";
		edgeStr += "17,20,PARENT_OF\n";
		edgeStr += "6,17,PARENT_OF\n";
		//edgeStr += "3,6,PARENT_OF\n";
		//edgeStr += "3,21,PARENT_OF\n";
		//edgeStr += "2,3,PARENT_OF\n";
		//edgeStr += "23,24,PARENT_OF\n";
		//edgeStr += "22,23,PARENT_OF\n";
		//edgeStr += "22,25,PARENT_OF\n";
		//edgeStr += "2,22,PARENT_OF\n";

		// Problem:
		// epsilon edges from 7 to 10 and from 10 to 17 are there which is correct in a sense,
		// but somehow should there perhaps be edges from 7 to [EXIT] and from 10 to [EXIT] too?
		System.out.println(getCFGForCSVLines(nodeStr, edgeStr));
	}

	/**
	 * //function foo() {
	 *   bar();
	 *   yield from norf();
	 *   buz();
	 * //}
	 *
	 * //foo();
	 */
	@Test
	public void testCFGYieldFrom() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTSamples.nodeHeader;
		//nodeStr += "2,AST_STMT_LIST,,1,,0,1,,,\n";
		//nodeStr += "3,AST_FUNC_DECL,,3,,0,1,7,foo,\n";
		//nodeStr += "4,AST_PARAM_LIST,,3,,0,3,,,\n";
		//nodeStr += "5,NULL,,3,,1,3,,,\n";
		nodeStr += "6,AST_STMT_LIST,,3,,2,3,,,\n";
		nodeStr += "7,AST_CALL,,4,,0,3,,,\n";
		nodeStr += "8,AST_NAME,NAME_NOT_FQ,4,,0,3,,,\n";
		nodeStr += "9,string,,4,\"bar\",0,3,,,\n";
		nodeStr += "10,AST_ARG_LIST,,4,,1,3,,,\n";
		nodeStr += "11,AST_YIELD_FROM,,5,,1,3,,,\n";
		nodeStr += "12,AST_CALL,,5,,0,3,,,\n";
		nodeStr += "13,AST_NAME,NAME_NOT_FQ,5,,0,3,,,\n";
		nodeStr += "14,string,,5,\"norf\",0,3,,,\n";
		nodeStr += "15,AST_ARG_LIST,,5,,1,3,,,\n";
		nodeStr += "16,AST_CALL,,6,,2,3,,,\n";
		nodeStr += "17,AST_NAME,NAME_NOT_FQ,6,,0,3,,,\n";
		nodeStr += "18,string,,6,\"buz\",0,3,,,\n";
		nodeStr += "19,AST_ARG_LIST,,6,,1,3,,,\n";
		//nodeStr += "20,NULL,,3,,3,3,,,\n";
		//nodeStr += "21,AST_CALL,,9,,1,1,,,\n";
		//nodeStr += "22,AST_NAME,NAME_NOT_FQ,9,,0,1,,,\n";
		//nodeStr += "23,string,,9,\"foo\",0,1,,,\n";
		//nodeStr += "24,AST_ARG_LIST,,9,,1,1,,,\n";

		String edgeStr = CSVASTSamples.edgeHeader;
		//edgeStr += "3,4,PARENT_OF\n";
		//edgeStr += "3,5,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "7,10,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "13,14,PARENT_OF\n";
		edgeStr += "12,13,PARENT_OF\n";
		edgeStr += "12,15,PARENT_OF\n";
		edgeStr += "11,12,PARENT_OF\n";
		edgeStr += "6,11,PARENT_OF\n";
		edgeStr += "17,18,PARENT_OF\n";
		edgeStr += "16,17,PARENT_OF\n";
		edgeStr += "16,19,PARENT_OF\n";
		edgeStr += "6,16,PARENT_OF\n";
		//edgeStr += "3,6,PARENT_OF\n";
		//edgeStr += "3,20,PARENT_OF\n";
		//edgeStr += "2,3,PARENT_OF\n";
		//edgeStr += "22,23,PARENT_OF\n";
		//edgeStr += "21,22,PARENT_OF\n";
		//edgeStr += "21,24,PARENT_OF\n";
		//edgeStr += "2,21,PARENT_OF\n";

		// Problem:
		// epsilon edge from 11 to 16 which is correct in a sense,
		// but somehow should there perhaps be an edge from 11 to [EXIT] too?
		// Or, actually, is this more a matter for call graph construction? (from 11 to definition of norf()?)
		// But then what about 'yield from' with iterables, like 'yield from [1,2];' ?
		System.out.println(getCFGForCSVLines(nodeStr, edgeStr));
	}


}
