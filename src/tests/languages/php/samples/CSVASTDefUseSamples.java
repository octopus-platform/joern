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
	
	public static final String defUseAssignUsingVariablesNodeStr = nodeHeader
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
	
	public static final String defUseAssignUsingVariablesEdgeStr = edgeHeader
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
	
	public static final String defUseAssignUsingConstantsNodeStr = nodeHeader
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

	public static final String defUseAssignUsingConstantsEdgeStr = edgeHeader
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

	
	/*
	 * $foo->bar = $buz->qux + $$norf->nicknack;
	 * $someobj->arrr = somecall()->aye;
	 */
	
	public static final String defUseAssignUsingPropertiesNodeStr = nodeHeader
			+ "2,AST_STMT_LIST,,1,,0,1,,,\n"
			+ "3,AST_ASSIGN,,3,,0,1,,,\n"
			+ "4,AST_PROP,,3,,0,1,,,\n"
			+ "5,AST_VAR,,3,,0,1,,,\n"
			+ "6,string,,3,\"foo\",0,1,,,\n"
			+ "7,string,,3,\"bar\",1,1,,,\n"
			+ "8,AST_BINARY_OP,BINARY_ADD,3,,1,1,,,\n"
			+ "9,AST_PROP,,3,,0,1,,,\n"
			+ "10,AST_VAR,,3,,0,1,,,\n"
			+ "11,string,,3,\"buz\",0,1,,,\n"
			+ "12,string,,3,\"qux\",1,1,,,\n"
			+ "13,AST_PROP,,3,,1,1,,,\n"
			+ "14,AST_VAR,,3,,0,1,,,\n"
			+ "15,AST_VAR,,3,,0,1,,,\n"
			+ "16,string,,3,\"norf\",0,1,,,\n"
			+ "17,string,,3,\"nicknack\",1,1,,,\n"
			+ "18,AST_ASSIGN,,4,,1,1,,,\n"
			+ "19,AST_PROP,,4,,0,1,,,\n"
			+ "20,AST_VAR,,4,,0,1,,,\n"
			+ "21,string,,4,\"someobj\",0,1,,,\n"
			+ "22,string,,4,\"arrr\",1,1,,,\n"
			+ "23,AST_PROP,,4,,1,1,,,\n"
			+ "24,AST_CALL,,4,,0,1,,,\n"
			+ "25,AST_NAME,NAME_NOT_FQ,4,,0,1,,,\n"
			+ "26,string,,4,\"somecall\",0,1,,,\n"
			+ "27,AST_ARG_LIST,,4,,1,1,,,\n"
			+ "28,string,,4,\"aye\",1,1,,,\n";
	
	public static final String defUseAssignUsingPropertiesEdgeStr = edgeHeader
			+ "5,6,PARENT_OF\n"
			+ "4,5,PARENT_OF\n"
			+ "4,7,PARENT_OF\n"
			+ "3,4,PARENT_OF\n"
			+ "10,11,PARENT_OF\n"
			+ "9,10,PARENT_OF\n"
			+ "9,12,PARENT_OF\n"
			+ "8,9,PARENT_OF\n"
			+ "15,16,PARENT_OF\n"
			+ "14,15,PARENT_OF\n"
			+ "13,14,PARENT_OF\n"
			+ "13,17,PARENT_OF\n"
			+ "8,13,PARENT_OF\n"
			+ "3,8,PARENT_OF\n"
			+ "2,3,PARENT_OF\n"
			+ "20,21,PARENT_OF\n"
			+ "19,20,PARENT_OF\n"
			+ "19,22,PARENT_OF\n"
			+ "18,19,PARENT_OF\n"
			+ "25,26,PARENT_OF\n"
			+ "24,25,PARENT_OF\n"
			+ "24,27,PARENT_OF\n"
			+ "23,24,PARENT_OF\n"
			+ "23,28,PARENT_OF\n"
			+ "18,23,PARENT_OF\n"
			+ "2,18,PARENT_OF\n";

	
	/**
	 * Foo::$bar = $buz::${qux()} + norf()::$$nicknack;
	 */
	
	public static final String defUseAssignUsingStaticPropertiesNodeStr = nodeHeader
			+ "2,AST_STMT_LIST,,1,,0,1,,,\n"
			+ "3,AST_ASSIGN,,3,,0,1,,,\n"
			+ "4,AST_STATIC_PROP,,3,,0,1,,,\n"
			+ "5,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n"
			+ "6,string,,3,\"Foo\",0,1,,,\n"
			+ "7,string,,3,\"bar\",1,1,,,\n"
			+ "8,AST_BINARY_OP,BINARY_ADD,3,,1,1,,,\n"
			+ "9,AST_STATIC_PROP,,3,,0,1,,,\n"
			+ "10,AST_VAR,,3,,0,1,,,\n"
			+ "11,string,,3,\"buz\",0,1,,,\n"
			+ "12,AST_CALL,,3,,1,1,,,\n"
			+ "13,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n"
			+ "14,string,,3,\"qux\",0,1,,,\n"
			+ "15,AST_ARG_LIST,,3,,1,1,,,\n"
			+ "16,AST_STATIC_PROP,,3,,1,1,,,\n"
			+ "17,AST_CALL,,3,,0,1,,,\n"
			+ "18,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n"
			+ "19,string,,3,\"norf\",0,1,,,\n"
			+ "20,AST_ARG_LIST,,3,,1,1,,,\n"
			+ "21,AST_VAR,,3,,1,1,,,\n"
			+ "22,string,,3,\"nicknack\",0,1,,,\n";

	public static final String defUseAssignUsingStaticPropertiesEdgeStr = edgeHeader
			+ "5,6,PARENT_OF\n"
			+ "4,5,PARENT_OF\n"
			+ "4,7,PARENT_OF\n"
			+ "3,4,PARENT_OF\n"
			+ "10,11,PARENT_OF\n"
			+ "9,10,PARENT_OF\n"
			+ "13,14,PARENT_OF\n"
			+ "12,13,PARENT_OF\n"
			+ "12,15,PARENT_OF\n"
			+ "9,12,PARENT_OF\n"
			+ "8,9,PARENT_OF\n"
			+ "18,19,PARENT_OF\n"
			+ "17,18,PARENT_OF\n"
			+ "17,20,PARENT_OF\n"
			+ "16,17,PARENT_OF\n"
			+ "21,22,PARENT_OF\n"
			+ "16,21,PARENT_OF\n"
			+ "8,16,PARENT_OF\n"
			+ "3,8,PARENT_OF\n"
			+ "2,3,PARENT_OF\n";

	
	/*
	 * $foo = Foo::BAR + $buz::QUX + norf()::NICKNACK;
	 */
	
	public static final String defUseAssignUsingClassConstantsNodeStr = nodeHeader
			+ "2,AST_STMT_LIST,,1,,0,1,,,\n"
			+ "3,AST_ASSIGN,,3,,0,1,,,\n"
			+ "4,AST_VAR,,3,,0,1,,,\n"
			+ "5,string,,3,\"foo\",0,1,,,\n"
			+ "6,AST_BINARY_OP,BINARY_ADD,3,,1,1,,,\n"
			+ "7,AST_BINARY_OP,BINARY_ADD,3,,0,1,,,\n"
			+ "8,AST_CLASS_CONST,,3,,0,1,,,\n"
			+ "9,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n"
			+ "10,string,,3,\"Foo\",0,1,,,\n"
			+ "11,string,,3,\"BAR\",1,1,,,\n"
			+ "12,AST_CLASS_CONST,,3,,1,1,,,\n"
			+ "13,AST_VAR,,3,,0,1,,,\n"
			+ "14,string,,3,\"buz\",0,1,,,\n"
			+ "15,string,,3,\"QUX\",1,1,,,\n"
			+ "16,AST_CLASS_CONST,,3,,1,1,,,\n"
			+ "17,AST_CALL,,3,,0,1,,,\n"
			+ "18,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n"
			+ "19,string,,3,\"norf\",0,1,,,\n"
			+ "20,AST_ARG_LIST,,3,,1,1,,,\n"
			+ "21,string,,3,\"NICKNACK\",1,1,,,\n";

	public static final String defUseAssignUsingClassConstantsEdgeStr = edgeHeader
			+ "4,5,PARENT_OF\n"
			+ "3,4,PARENT_OF\n"
			+ "9,10,PARENT_OF\n"
			+ "8,9,PARENT_OF\n"
			+ "8,11,PARENT_OF\n"
			+ "7,8,PARENT_OF\n"
			+ "13,14,PARENT_OF\n"
			+ "12,13,PARENT_OF\n"
			+ "12,15,PARENT_OF\n"
			+ "7,12,PARENT_OF\n"
			+ "6,7,PARENT_OF\n"
			+ "18,19,PARENT_OF\n"
			+ "17,18,PARENT_OF\n"
			+ "17,20,PARENT_OF\n"
			+ "16,17,PARENT_OF\n"
			+ "16,21,PARENT_OF\n"
			+ "6,16,PARENT_OF\n"
			+ "3,6,PARENT_OF\n"
			+ "2,3,PARENT_OF\n";

	
	/*
	 * $foo = [3, $a, $$b, "blah"];
	 */
	
	public static final String defUseAssignUsingArrayIndexingNodeStr = nodeHeader
			+ "2,AST_STMT_LIST,,1,,0,1,,,\n"
			+ "3,AST_ASSIGN,,3,,0,1,,,\n"
			+ "4,AST_VAR,,3,,0,1,,,\n"
			+ "5,string,,3,\"foo\",0,1,,,\n"
			+ "6,AST_ARRAY,,3,,1,1,,,\n"
			+ "7,AST_ARRAY_ELEM,,3,,0,1,,,\n"
			+ "8,integer,,3,3,0,1,,,\n"
			+ "9,NULL,,3,,1,1,,,\n"
			+ "10,AST_ARRAY_ELEM,,3,,1,1,,,\n"
			+ "11,AST_VAR,,3,,0,1,,,\n"
			+ "12,string,,3,\"a\",0,1,,,\n"
			+ "13,NULL,,3,,1,1,,,\n"
			+ "14,AST_ARRAY_ELEM,,3,,2,1,,,\n"
			+ "15,AST_VAR,,3,,0,1,,,\n"
			+ "16,AST_VAR,,3,,0,1,,,\n"
			+ "17,string,,3,\"b\",0,1,,,\n"
			+ "18,NULL,,3,,1,1,,,\n"
			+ "19,AST_ARRAY_ELEM,,3,,3,1,,,\n"
			+ "20,string,,3,\"blah\",0,1,,,\n"
			+ "21,NULL,,3,,1,1,,,\n";
	
	public static final String defUseAssignUsingArrayIndexingEdgeStr = edgeHeader
			+ "4,5,PARENT_OF\n"
			+ "3,4,PARENT_OF\n"
			+ "7,8,PARENT_OF\n"
			+ "7,9,PARENT_OF\n"
			+ "6,7,PARENT_OF\n"
			+ "11,12,PARENT_OF\n"
			+ "10,11,PARENT_OF\n"
			+ "10,13,PARENT_OF\n"
			+ "6,10,PARENT_OF\n"
			+ "16,17,PARENT_OF\n"
			+ "15,16,PARENT_OF\n"
			+ "14,15,PARENT_OF\n"
			+ "14,18,PARENT_OF\n"
			+ "6,14,PARENT_OF\n"
			+ "19,20,PARENT_OF\n"
			+ "19,21,PARENT_OF\n"
			+ "6,19,PARENT_OF\n"
			+ "3,6,PARENT_OF\n"
			+ "2,3,PARENT_OF\n";

	
	/*
	 * $buz = function() use ($foo,$bar) {};
	 */
	
	public static final String defUseAssignUsingClosureVarNodeStr = nodeHeader
			+ "2,AST_STMT_LIST,,1,,0,1,,,\n"
			+ "3,AST_ASSIGN,,3,,0,1,,,\n"
			+ "4,AST_VAR,,3,,0,1,,,\n"
			+ "5,string,,3,\"buz\",0,1,,,\n"
			+ "6,AST_CLOSURE,,3,,1,1,3,{closure},\n"
			+ "7,AST_PARAM_LIST,,3,,0,6,,,\n"
			+ "8,AST_CLOSURE_USES,,3,,1,6,,,\n"
			+ "9,AST_CLOSURE_VAR,,3,,0,6,,,\n"
			+ "10,string,,3,\"foo\",0,6,,,\n"
			+ "11,AST_CLOSURE_VAR,,3,,1,6,,,\n"
			+ "12,string,,3,\"bar\",0,6,,,\n"
			+ "13,AST_STMT_LIST,,3,,2,6,,,\n"
			+ "14,NULL,,3,,3,6,,,\n";

	public static final String defUseAssignUsingClosureVarEdgeStr = edgeHeader
			+ "4,5,PARENT_OF\n"
			+ "3,4,PARENT_OF\n"
			+ "6,7,PARENT_OF\n"
			+ "9,10,PARENT_OF\n"
			+ "8,9,PARENT_OF\n"
			+ "11,12,PARENT_OF\n"
			+ "8,11,PARENT_OF\n"
			+ "6,8,PARENT_OF\n"
			+ "6,13,PARENT_OF\n"
			+ "6,14,PARENT_OF\n"
			+ "3,6,PARENT_OF\n"
			+ "2,3,PARENT_OF\n";


}
