package tests.languages.php.samples;

/**
 * Simlarly as CSVASTSamples, this class contains some PHP AST samples in CSV format,
 * optimized for testing def/use analysis.
 */
public class CSVASTUDGAndDDGSamples extends CSVASTSamples {

	/*
	 * $x = source();
	 * if( $x < MAX) {
	 *   $y = 2*$x;
	 *   sink($y);
	 * }
	 */

	public static final String simpleFunctionNodeStr = nodeHeader
			+ "2,AST_STMT_LIST,,1,,0,1,,,\n"
			+ "3,AST_ASSIGN,,3,,0,1,,,\n"
			+ "4,AST_VAR,,3,,0,1,,,\n"
			+ "5,string,,3,\"x\",0,1,,,\n"
			+ "6,AST_CALL,,3,,1,1,,,\n"
			+ "7,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n"
			+ "8,string,,3,\"source\",0,1,,,\n"
			+ "9,AST_ARG_LIST,,3,,1,1,,,\n"
			+ "10,AST_IF,,7,,1,1,,,\n"
			+ "11,AST_IF_ELEM,,4,,0,1,,,\n"
			+ "12,AST_BINARY_OP,BINARY_IS_SMALLER,4,,0,1,,,\n"
			+ "13,AST_VAR,,4,,0,1,,,\n"
			+ "14,string,,4,\"x\",0,1,,,\n"
			+ "15,AST_CONST,,4,,1,1,,,\n"
			+ "16,AST_NAME,NAME_NOT_FQ,4,,0,1,,,\n"
			+ "17,string,,4,\"MAX\",0,1,,,\n"
			+ "18,AST_STMT_LIST,,4,,1,1,,,\n"
			+ "19,AST_ASSIGN,,5,,0,1,,,\n"
			+ "20,AST_VAR,,5,,0,1,,,\n"
			+ "21,string,,5,\"y\",0,1,,,\n"
			+ "22,AST_BINARY_OP,BINARY_MUL,5,,1,1,,,\n"
			+ "23,integer,,5,2,0,1,,,\n"
			+ "24,AST_VAR,,5,,1,1,,,\n"
			+ "25,string,,5,\"x\",0,1,,,\n"
			+ "26,AST_CALL,,6,,1,1,,,\n"
			+ "27,AST_NAME,NAME_NOT_FQ,6,,0,1,,,\n"
			+ "28,string,,6,\"sink\",0,1,,,\n"
			+ "29,AST_ARG_LIST,,6,,1,1,,,\n"
			+ "30,AST_VAR,,6,,0,1,,,\n"
			+ "31,string,,6,\"y\",0,1,,,\n";

	public static final String simpleFunctionEdgeStr = edgeHeader
			+ "4,5,PARENT_OF\n"
			+ "3,4,PARENT_OF\n"
			+ "7,8,PARENT_OF\n"
			+ "6,7,PARENT_OF\n"
			+ "6,9,PARENT_OF\n"
			+ "3,6,PARENT_OF\n"
			+ "2,3,PARENT_OF\n"
			+ "13,14,PARENT_OF\n"
			+ "12,13,PARENT_OF\n"
			+ "16,17,PARENT_OF\n"
			+ "15,16,PARENT_OF\n"
			+ "12,15,PARENT_OF\n"
			+ "11,12,PARENT_OF\n"
			+ "20,21,PARENT_OF\n"
			+ "19,20,PARENT_OF\n"
			+ "22,23,PARENT_OF\n"
			+ "24,25,PARENT_OF\n"
			+ "22,24,PARENT_OF\n"
			+ "19,22,PARENT_OF\n"
			+ "18,19,PARENT_OF\n"
			+ "27,28,PARENT_OF\n"
			+ "26,27,PARENT_OF\n"
			+ "30,31,PARENT_OF\n"
			+ "29,30,PARENT_OF\n"
			+ "26,29,PARENT_OF\n"
			+ "18,26,PARENT_OF\n"
			+ "11,18,PARENT_OF\n"
			+ "10,11,PARENT_OF\n"
			+ "2,10,PARENT_OF\n";

	/*
	 * $flag = source();
	 * if( $flag) {
	 *   $y++;
	 *   sink($y);
	 * }
	 */

	public static final String standaloneFlagNodeStr = nodeHeader
			+ "2,AST_STMT_LIST,,1,,0,1,,,\n"
			+ "3,AST_ASSIGN,,3,,0,1,,,\n"
			+ "4,AST_VAR,,3,,0,1,,,\n"
			+ "5,string,,3,\"flag\",0,1,,,\n"
			+ "6,AST_CALL,,3,,1,1,,,\n"
			+ "7,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n"
			+ "8,string,,3,\"source\",0,1,,,\n"
			+ "9,AST_ARG_LIST,,3,,1,1,,,\n"
			+ "10,AST_IF,,7,,1,1,,,\n"
			+ "11,AST_IF_ELEM,,4,,0,1,,,\n"
			+ "12,AST_VAR,,4,,0,1,,,\n"
			+ "13,string,,4,\"flag\",0,1,,,\n"
			+ "14,AST_STMT_LIST,,4,,1,1,,,\n"
			+ "15,AST_POST_INC,,5,,0,1,,,\n"
			+ "16,AST_VAR,,5,,0,1,,,\n"
			+ "17,string,,5,\"y\",0,1,,,\n"
			+ "18,AST_CALL,,6,,1,1,,,\n"
			+ "19,AST_NAME,NAME_NOT_FQ,6,,0,1,,,\n"
			+ "20,string,,6,\"sink\",0,1,,,\n"
			+ "21,AST_ARG_LIST,,6,,1,1,,,\n"
			+ "22,AST_VAR,,6,,0,1,,,\n"
			+ "23,string,,6,\"y\",0,1,,,\n";

	public static final String standaloneFlagEdgeStr = edgeHeader
			+ "4,5,PARENT_OF\n"
			+ "3,4,PARENT_OF\n"
			+ "7,8,PARENT_OF\n"
			+ "6,7,PARENT_OF\n"
			+ "6,9,PARENT_OF\n"
			+ "3,6,PARENT_OF\n"
			+ "2,3,PARENT_OF\n"
			+ "12,13,PARENT_OF\n"
			+ "11,12,PARENT_OF\n"
			+ "16,17,PARENT_OF\n"
			+ "15,16,PARENT_OF\n"
			+ "14,15,PARENT_OF\n"
			+ "19,20,PARENT_OF\n"
			+ "18,19,PARENT_OF\n"
			+ "22,23,PARENT_OF\n"
			+ "21,22,PARENT_OF\n"
			+ "18,21,PARENT_OF\n"
			+ "14,18,PARENT_OF\n"
			+ "11,14,PARENT_OF\n"
			+ "10,11,PARENT_OF\n"
			+ "2,10,PARENT_OF\n";
	
    /*
     * const MAX = 10;
     * 
     * function foo() {
     *   $x = source();
     *   if( $x < MAX) {
     *     $y = 2*$x;
     *     sink($y);
     *   }
     * }
     * 
     * function source() {
     *   global $argv;
     *   return $argv[1];
     * }
     * 
     * function sink($arg) {
     *   echo $arg, PHP_EOL;
     * }
     * 
     * foo();
     */

    public static final String simpleCompleteProgramNodeStr = nodeHeader
            + "0,File,,,,,,,\"foo.php\",\n"
            + "1,AST_TOPLEVEL,TOPLEVEL_FILE,1,,,,22,\"foo.php\",\n"
            + "2,AST_STMT_LIST,,1,,0,1,,,\n"
            + "3,AST_CONST_DECL,,3,,0,1,,,\n"
            + "4,AST_CONST_ELEM,,3,,0,1,,,\n"
            + "5,string,,3,\"MAX\",0,1,,,\n"
            + "6,integer,,3,10,1,1,,,\n"
            + "7,AST_FUNC_DECL,,5,,1,1,11,foo,\n"
            + "8,AST_PARAM_LIST,,5,,0,7,,,\n"
            + "9,NULL,,5,,1,7,,,\n"
            + "10,AST_STMT_LIST,,5,,2,7,,,\n"
            + "11,AST_ASSIGN,,6,,0,7,,,\n"
            + "12,AST_VAR,,6,,0,7,,,\n"
            + "13,string,,6,\"x\",0,7,,,\n"
            + "14,AST_CALL,,6,,1,7,,,\n"
            + "15,AST_NAME,NAME_NOT_FQ,6,,0,7,,,\n"
            + "16,string,,6,\"source\",0,7,,,\n"
            + "17,AST_ARG_LIST,,6,,1,7,,,\n"
            + "18,AST_IF,,10,,1,7,,,\n"
            + "19,AST_IF_ELEM,,7,,0,7,,,\n"
            + "20,AST_BINARY_OP,BINARY_IS_SMALLER,7,,0,7,,,\n"
            + "21,AST_VAR,,7,,0,7,,,\n"
            + "22,string,,7,\"x\",0,7,,,\n"
            + "23,AST_CONST,,7,,1,7,,,\n"
            + "24,AST_NAME,NAME_NOT_FQ,7,,0,7,,,\n"
            + "25,string,,7,\"MAX\",0,7,,,\n"
            + "26,AST_STMT_LIST,,7,,1,7,,,\n"
            + "27,AST_ASSIGN,,8,,0,7,,,\n"
            + "28,AST_VAR,,8,,0,7,,,\n"
            + "29,string,,8,\"y\",0,7,,,\n"
            + "30,AST_BINARY_OP,BINARY_MUL,8,,1,7,,,\n"
            + "31,integer,,8,2,0,7,,,\n"
            + "32,AST_VAR,,8,,1,7,,,\n"
            + "33,string,,8,\"x\",0,7,,,\n"
            + "34,AST_CALL,,9,,1,7,,,\n"
            + "35,AST_NAME,NAME_NOT_FQ,9,,0,7,,,\n"
            + "36,string,,9,\"sink\",0,7,,,\n"
            + "37,AST_ARG_LIST,,9,,1,7,,,\n"
            + "38,AST_VAR,,9,,0,7,,,\n"
            + "39,string,,9,\"y\",0,7,,,\n"
            + "40,NULL,,5,,3,7,,,\n"
            + "41,AST_FUNC_DECL,,13,,2,1,16,source,\n"
            + "42,AST_PARAM_LIST,,13,,0,41,,,\n"
            + "43,NULL,,13,,1,41,,,\n"
            + "44,AST_STMT_LIST,,13,,2,41,,,\n"
            + "45,AST_STMT_LIST,,14,,0,41,,,\n"
            + "46,AST_GLOBAL,,14,,0,41,,,\n"
            + "47,AST_VAR,,14,,0,41,,,\n"
            + "48,string,,14,\"argv\",0,41,,,\n"
            + "49,AST_RETURN,,15,,1,41,,,\n"
            + "50,AST_DIM,,15,,0,41,,,\n"
            + "51,AST_VAR,,15,,0,41,,,\n"
            + "52,string,,15,\"argv\",0,41,,,\n"
            + "53,integer,,15,1,1,41,,,\n"
            + "54,NULL,,13,,3,41,,,\n"
            + "55,AST_FUNC_DECL,,18,,3,1,20,sink,\n"
            + "56,AST_PARAM_LIST,,18,,0,55,,,\n"
            + "57,AST_PARAM,,18,,0,55,,,\n"
            + "58,NULL,,18,,0,55,,,\n"
            + "59,string,,18,\"arg\",1,55,,,\n"
            + "60,NULL,,18,,2,55,,,\n"
            + "61,NULL,,18,,1,55,,,\n"
            + "62,AST_STMT_LIST,,18,,2,55,,,\n"
            + "63,AST_STMT_LIST,,19,,0,55,,,\n"
            + "64,AST_ECHO,,19,,0,55,,,\n"
            + "65,AST_VAR,,19,,0,55,,,\n"
            + "66,string,,19,\"arg\",0,55,,,\n"
            + "67,AST_ECHO,,19,,1,55,,,\n"
            + "68,AST_CONST,,19,,0,55,,,\n"
            + "69,AST_NAME,NAME_NOT_FQ,19,,0,55,,,\n"
            + "70,string,,19,\"PHP_EOL\",0,55,,,\n"
            + "71,NULL,,18,,3,55,,,\n"
            + "72,AST_CALL,,22,,4,1,,,\n"
            + "73,AST_NAME,NAME_NOT_FQ,22,,0,1,,,\n"
            + "74,string,,22,\"foo\",0,1,,,\n"
            + "75,AST_ARG_LIST,,22,,1,1,,,\n";

    public static final String simpleCompleteProgramEdgeStr = edgeHeader
            + "4,5,PARENT_OF\n"
            + "4,6,PARENT_OF\n"
            + "3,4,PARENT_OF\n"
            + "2,3,PARENT_OF\n"
            + "7,8,PARENT_OF\n"
            + "7,9,PARENT_OF\n"
            + "12,13,PARENT_OF\n"
            + "11,12,PARENT_OF\n"
            + "15,16,PARENT_OF\n"
            + "14,15,PARENT_OF\n"
            + "14,17,PARENT_OF\n"
            + "11,14,PARENT_OF\n"
            + "10,11,PARENT_OF\n"
            + "21,22,PARENT_OF\n"
            + "20,21,PARENT_OF\n"
            + "24,25,PARENT_OF\n"
            + "23,24,PARENT_OF\n"
            + "20,23,PARENT_OF\n"
            + "19,20,PARENT_OF\n"
            + "28,29,PARENT_OF\n"
            + "27,28,PARENT_OF\n"
            + "30,31,PARENT_OF\n"
            + "32,33,PARENT_OF\n"
            + "30,32,PARENT_OF\n"
            + "27,30,PARENT_OF\n"
            + "26,27,PARENT_OF\n"
            + "35,36,PARENT_OF\n"
            + "34,35,PARENT_OF\n"
            + "38,39,PARENT_OF\n"
            + "37,38,PARENT_OF\n"
            + "34,37,PARENT_OF\n"
            + "26,34,PARENT_OF\n"
            + "19,26,PARENT_OF\n"
            + "18,19,PARENT_OF\n"
            + "10,18,PARENT_OF\n"
            + "7,10,PARENT_OF\n"
            + "7,40,PARENT_OF\n"
            + "2,7,PARENT_OF\n"
            + "41,42,PARENT_OF\n"
            + "41,43,PARENT_OF\n"
            + "47,48,PARENT_OF\n"
            + "46,47,PARENT_OF\n"
            + "45,46,PARENT_OF\n"
            + "44,45,PARENT_OF\n"
            + "51,52,PARENT_OF\n"
            + "50,51,PARENT_OF\n"
            + "50,53,PARENT_OF\n"
            + "49,50,PARENT_OF\n"
            + "44,49,PARENT_OF\n"
            + "41,44,PARENT_OF\n"
            + "41,54,PARENT_OF\n"
            + "2,41,PARENT_OF\n"
            + "57,58,PARENT_OF\n"
            + "57,59,PARENT_OF\n"
            + "57,60,PARENT_OF\n"
            + "56,57,PARENT_OF\n"
            + "55,56,PARENT_OF\n"
            + "55,61,PARENT_OF\n"
            + "65,66,PARENT_OF\n"
            + "64,65,PARENT_OF\n"
            + "63,64,PARENT_OF\n"
            + "69,70,PARENT_OF\n"
            + "68,69,PARENT_OF\n"
            + "67,68,PARENT_OF\n"
            + "63,67,PARENT_OF\n"
            + "62,63,PARENT_OF\n"
            + "55,62,PARENT_OF\n"
            + "55,71,PARENT_OF\n"
            + "2,55,PARENT_OF\n"
            + "73,74,PARENT_OF\n"
            + "72,73,PARENT_OF\n"
            + "72,75,PARENT_OF\n"
            + "2,72,PARENT_OF\n"
            + "1,2,PARENT_OF\n"
            + "0,1,FILE_OF\n";


}
