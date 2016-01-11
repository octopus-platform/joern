package tests.languages.php.samples;

/**
 * Simlarly as CSVASTSamples, this class contains some PHP AST samples in CSV format,
 * optimized for testing def/use analysis.
 */
public class CSVASTDefUseSamples extends CSVASTSamples {

	/* 
	 * $foo = $bar + $buz;
	 * $qux = $$norf;
	 */
	
	public static final String defUseAssignWithVariablesNodeStr = nodeHeader
			+ "2,AST_STMT_LIST,,1,,0,1,,,\n"
			+ "3,AST_ASSIGN,,3,,0,1,,,\n"
			+ "4,AST_VAR,,3,,0,1,,,\n"
			+ "5,string,,3,\"foo\",0,1,,,\n"
			+ "6,AST_BINARY_OP,BINARY_ADD,3,,1,1,,,\n"
			+ "7,AST_VAR,,3,,0,1,,,\n"
			+ "8,string,,3,\"bar\",0,1,,,\n"
			+ "9,AST_VAR,,3,,1,1,,,\n"
			+ "10,string,,3,\"buz\",0,1,,,\n"
			+ "11,AST_ASSIGN,,4,,1,1,,,\n"
			+ "12,AST_VAR,,4,,0,1,,,\n"
			+ "13,string,,4,\"qux\",0,1,,,\n"
			+ "14,AST_VAR,,4,,1,1,,,\n"
			+ "15,AST_VAR,,4,,0,1,,,\n"
			+ "16,string,,4,\"norf\",0,1,,,\n";
	
	public static final String defUseAssignWithVariablesEdgeStr = edgeHeader
			+ "4,5,PARENT_OF\n"
			+ "3,4,PARENT_OF\n"
			+ "7,8,PARENT_OF\n"
			+ "6,7,PARENT_OF\n"
			+ "9,10,PARENT_OF\n"
			+ "6,9,PARENT_OF\n"
			+ "3,6,PARENT_OF\n"
			+ "2,3,PARENT_OF\n"
			+ "12,13,PARENT_OF\n"
			+ "11,12,PARENT_OF\n"
			+ "15,16,PARENT_OF\n"
			+ "14,15,PARENT_OF\n"
			+ "11,14,PARENT_OF\n"
			+ "2,11,PARENT_OF\n";

	
	/*
	 * $foo = FOO + \BAR\BUZ;
	 */
	
	public static final String defUseAssignWithConstantsNodeStr = nodeHeader
			+ "2,AST_STMT_LIST,,1,,0,1,,,\n"
			+ "3,AST_ASSIGN,,3,,0,1,,,\n"
			+ "4,AST_VAR,,3,,0,1,,,\n"
			+ "5,string,,3,\"foo\",0,1,,,\n"
			+ "6,AST_BINARY_OP,BINARY_ADD,3,,1,1,,,\n"
			+ "7,AST_CONST,,3,,0,1,,,\n"
			+ "8,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n"
			+ "9,string,,3,\"FOO\",0,1,,,\n"
			+ "10,AST_CONST,,3,,1,1,,,\n"
			+ "11,AST_NAME,NAME_FQ,3,,0,1,,,\n"
			+ "12,string,,3,\"BAR\\BUZ\",0,1,,,\n";

	public static final String defUseAssignWithConstantsEdgeStr = edgeHeader
			+ "4,5,PARENT_OF\n"
			+ "3,4,PARENT_OF\n"
			+ "8,9,PARENT_OF\n"
			+ "7,8,PARENT_OF\n"
			+ "6,7,PARENT_OF\n"
			+ "11,12,PARENT_OF\n"
			+ "10,11,PARENT_OF\n"
			+ "6,10,PARENT_OF\n"
			+ "3,6,PARENT_OF\n"
			+ "2,3,PARENT_OF\n";


}
