package tests.languages.php.samples;

public class CSVASTCallSamples extends CSVASTSamples {

	/*
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
	
    public static final String simpleCallsNodeStr = nodeHeader
            + "0,File,,,,,,,\"foo.php\",\n"
            + "1,AST_TOPLEVEL,TOPLEVEL_FILE,1,,,,14,\"foo.php\",\n"
            + "2,AST_STMT_LIST,,1,,0,1,,,\n"
            + "3,AST_FUNC_DECL,,3,,0,1,6,funcone,\n"
            + "4,AST_PARAM_LIST,,3,,0,3,,,\n"
            + "5,NULL,,3,,1,3,,,\n"
            + "6,AST_STMT_LIST,,3,,2,3,,,\n"
            + "7,AST_CALL,,4,,0,3,,,\n"
            + "8,AST_NAME,NAME_NOT_FQ,4,,0,3,,,\n"
            + "9,string,,4,\"funcone\",0,3,,,\n"
            + "10,AST_ARG_LIST,,4,,1,3,,,\n"
            + "11,AST_CALL,,5,,1,3,,,\n"
            + "12,AST_NAME,NAME_NOT_FQ,5,,0,3,,,\n"
            + "13,string,,5,\"functwo\",0,3,,,\n"
            + "14,AST_ARG_LIST,,5,,1,3,,,\n"
            + "15,string,,5,\"foo\",0,3,,,\n"
            + "16,NULL,,3,,3,3,,,\n"
            + "17,AST_FUNC_DECL,,8,,1,1,11,functwo,\n"
            + "18,AST_PARAM_LIST,,8,,0,17,,,\n"
            + "19,AST_PARAM,,8,,0,17,,,\n"
            + "20,NULL,,8,,0,17,,,\n"
            + "21,string,,8,\"a\",1,17,,,\n"
            + "22,NULL,,8,,2,17,,,\n"
            + "23,NULL,,8,,1,17,,,\n"
            + "24,AST_STMT_LIST,,8,,2,17,,,\n"
            + "25,AST_CALL,,9,,0,17,,,\n"
            + "26,AST_NAME,NAME_NOT_FQ,9,,0,17,,,\n"
            + "27,string,,9,\"funcone\",0,17,,,\n"
            + "28,AST_ARG_LIST,,9,,1,17,,,\n"
            + "29,AST_CALL,,10,,1,17,,,\n"
            + "30,AST_NAME,NAME_NOT_FQ,10,,0,17,,,\n"
            + "31,string,,10,\"functwo\",0,17,,,\n"
            + "32,AST_ARG_LIST,,10,,1,17,,,\n"
            + "33,string,,10,\"bar\",0,17,,,\n"
            + "34,NULL,,8,,3,17,,,\n"
            + "35,AST_CALL,,13,,2,1,,,\n"
            + "36,AST_NAME,NAME_NOT_FQ,13,,0,1,,,\n"
            + "37,string,,13,\"funcone\",0,1,,,\n"
            + "38,AST_ARG_LIST,,13,,1,1,,,\n"
            + "39,AST_CALL,,14,,3,1,,,\n"
            + "40,AST_NAME,NAME_NOT_FQ,14,,0,1,,,\n"
            + "41,string,,14,\"functwo\",0,1,,,\n"
            + "42,AST_ARG_LIST,,14,,1,1,,,\n";

    public static final String simpleCallsEdgeStr = edgeHeader
            + "3,4,PARENT_OF\n"
            + "3,5,PARENT_OF\n"
            + "8,9,PARENT_OF\n"
            + "7,8,PARENT_OF\n"
            + "7,10,PARENT_OF\n"
            + "6,7,PARENT_OF\n"
            + "12,13,PARENT_OF\n"
            + "11,12,PARENT_OF\n"
            + "14,15,PARENT_OF\n"
            + "11,14,PARENT_OF\n"
            + "6,11,PARENT_OF\n"
            + "3,6,PARENT_OF\n"
            + "3,16,PARENT_OF\n"
            + "2,3,PARENT_OF\n"
            + "19,20,PARENT_OF\n"
            + "19,21,PARENT_OF\n"
            + "19,22,PARENT_OF\n"
            + "18,19,PARENT_OF\n"
            + "17,18,PARENT_OF\n"
            + "17,23,PARENT_OF\n"
            + "26,27,PARENT_OF\n"
            + "25,26,PARENT_OF\n"
            + "25,28,PARENT_OF\n"
            + "24,25,PARENT_OF\n"
            + "30,31,PARENT_OF\n"
            + "29,30,PARENT_OF\n"
            + "32,33,PARENT_OF\n"
            + "29,32,PARENT_OF\n"
            + "24,29,PARENT_OF\n"
            + "17,24,PARENT_OF\n"
            + "17,34,PARENT_OF\n"
            + "2,17,PARENT_OF\n"
            + "36,37,PARENT_OF\n"
            + "35,36,PARENT_OF\n"
            + "35,38,PARENT_OF\n"
            + "2,35,PARENT_OF\n"
            + "40,41,PARENT_OF\n"
            + "39,40,PARENT_OF\n"
            + "39,42,PARENT_OF\n"
            + "2,39,PARENT_OF\n";

    
    /*
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

    public static final String twoFilesNodeStr = nodeHeader
    		+ "0,Directory,,,,,,,\"testTwoFiles\",\n"
    		+ "1,File,,,,,,,\"foo.php\",\n"
    		+ "2,AST_TOPLEVEL,TOPLEVEL_FILE,1,,,,7,\"testTwoFiles//foo.php\",\n"
    		+ "3,AST_STMT_LIST,,1,,0,2,,,\n"
    		+ "4,AST_INCLUDE_OR_EVAL,EXEC_INCLUDE_ONCE,3,,0,2,,,\n"
    		+ "5,string,,3,\"bar.php\",0,2,,,\n"
    		+ "6,AST_FUNC_DECL,,5,,1,2,5,foo,\n"
    		+ "7,AST_PARAM_LIST,,5,,0,6,,,\n"
    		+ "8,NULL,,5,,1,6,,,\n"
    		+ "9,AST_STMT_LIST,,5,,2,6,,,\n"
    		+ "10,NULL,,5,,3,6,,,\n"
    		+ "11,AST_CALL,,7,,2,2,,,\n"
    		+ "12,AST_NAME,NAME_NOT_FQ,7,,0,2,,,\n"
    		+ "13,string,,7,\"bar\",0,2,,,\n"
    		+ "14,AST_ARG_LIST,,7,,1,2,,,\n"
    		+ "15,File,,,,,,,\"bar.php\",\n"
    		+ "16,AST_TOPLEVEL,TOPLEVEL_FILE,1,,,,7,\"testTwoFiles//bar.php\",\n"
    		+ "17,AST_STMT_LIST,,1,,0,16,,,\n"
    		+ "18,AST_INCLUDE_OR_EVAL,EXEC_INCLUDE_ONCE,3,,0,16,,,\n"
    		+ "19,string,,3,\"foo.php\",0,16,,,\n"
    		+ "20,AST_FUNC_DECL,,5,,1,16,5,bar,\n"
    		+ "21,AST_PARAM_LIST,,5,,0,20,,,\n"
    		+ "22,NULL,,5,,1,20,,,\n"
    		+ "23,AST_STMT_LIST,,5,,2,20,,,\n"
    		+ "24,NULL,,5,,3,20,,,\n"
    		+ "25,AST_CALL,,7,,2,16,,,\n"
    		+ "26,AST_NAME,NAME_NOT_FQ,7,,0,16,,,\n"
    		+ "27,string,,7,\"foo\",0,16,,,\n"
    		+ "28,AST_ARG_LIST,,7,,1,16,,,\n";

    public static final String twoFilesEdgeStr = edgeHeader
    		+ "4,5,PARENT_OF\n"
    		+ "3,4,PARENT_OF\n"
    		+ "6,7,PARENT_OF\n"
    		+ "6,8,PARENT_OF\n"
    		+ "6,9,PARENT_OF\n"
    		+ "6,10,PARENT_OF\n"
    		+ "3,6,PARENT_OF\n"
    		+ "12,13,PARENT_OF\n"
    		+ "11,12,PARENT_OF\n"
    		+ "11,14,PARENT_OF\n"
    		+ "3,11,PARENT_OF\n"
    		+ "2,3,PARENT_OF\n"
    		+ "1,2,FILE_OF\n"
    		+ "18,19,PARENT_OF\n"
    		+ "17,18,PARENT_OF\n"
    		+ "20,21,PARENT_OF\n"
    		+ "20,22,PARENT_OF\n"
    		+ "20,23,PARENT_OF\n"
    		+ "20,24,PARENT_OF\n"
    		+ "17,20,PARENT_OF\n"
    		+ "26,27,PARENT_OF\n"
    		+ "25,26,PARENT_OF\n"
    		+ "25,28,PARENT_OF\n"
    		+ "17,25,PARENT_OF\n"
    		+ "16,17,PARENT_OF\n"
    		+ "15,16,FILE_OF\n"
    		+ "0,1,DIRECTORY_OF\n"
    		+ "0,15,DIRECTORY_OF\n";

    
}
