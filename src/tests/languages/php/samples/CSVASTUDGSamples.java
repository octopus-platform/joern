package tests.languages.php.samples;

/**
 * Simlarly as CSVASTSamples, this class contains some PHP AST samples in CSV format,
 * optimized for testing def/use analysis.
 */
public class CSVASTUDGSamples extends CSVASTSamples {

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

}
