package tests.languages.php.samples;

public class CSVASTSamples {

	// See {@link http://neo4j.com/docs/stable/import-tool-header-format.html} for detailed
	// information about the header file format
	public static final String nodeHeader = "id:ID,type,flags:string[],lineno:int,code,childnum:int,funcid:int,endlineno:int,name,doccomment\n";
	public static final String edgeHeader = ":START_ID,:END_ID,:TYPE\n";

	public static final String primaryExpressionNodeStr = nodeHeader +
			"3,integer,,1,42,0,1,,,\n" +
			"4,double,,1,3.14,1,1,,,\n" +
			"5,string,,1,\"Hello World!\",2,1,,,\n";


	public static final String nameEdgeStr = edgeHeader +
			"4,5,PARENT_OF\n"
			+"3,4,PARENT_OF\n"
			+"7,8,PARENT_OF\n"
			+"6,7,PARENT_OF\n"
			+"3,6,PARENT_OF\n"
			+"9,10,PARENT_OF\n"
			+"3,9,PARENT_OF\n";

	public static final String nameNodeStr = nodeHeader
			+ "3,AST_CLASS,,3,,0,1,3,foo,\n"
			+ "4,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n"
			+ "5,string,,3,\"bar\",0,1,,,\n"
			+ "6,AST_NAME_LIST,,3,,1,1,,,\n"
			+ "7,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n"
			+ "8,string,,3,\"buz\",0,1,,,\n"
			+ "9,AST_TOPLEVEL,TOPLEVEL_CLASS,3,,2,1,3,\"foo\",\n"
			+ "10,AST_STMT_LIST,,3,,0,9,,,\n";


	/* if($foo) {}
	 * elseif($bar) {}
	 * elseif($buz) {}
	 * else {}
	 */

	public static final String ifStatementNodeStr = nodeHeader
			+"3,AST_IF,,3,,0,1,,,\n"
			+"4,AST_IF_ELEM,,3,,0,1,,,\n"
			+"5,AST_VAR,,3,,0,1,,,\n"
			+"6,string,,3,\"foo\",0,1,,,\n"
			+"7,AST_STMT_LIST,,3,,1,1,,,\n"
			+"8,AST_IF_ELEM,,4,,1,1,,,\n"
			+"9,AST_VAR,,4,,0,1,,,\n"
			+"10,string,,4,\"bar\",0,1,,,\n"
			+"11,AST_STMT_LIST,,4,,1,1,,,\n"
			+"12,AST_IF_ELEM,,5,,2,1,,,\n"
			+"13,AST_VAR,,5,,0,1,,,\n"
			+"14,string,,5,\"buz\",0,1,,,\n"
			+"15,AST_STMT_LIST,,5,,1,1,,,\n"
			+"16,AST_IF_ELEM,,6,,3,1,,,\n"
			+"17,NULL,,6,,0,1,,,\n"
			+"18,AST_STMT_LIST,,6,,1,1,,,\n";

	public static final String ifStatementEdgeStr = edgeHeader
			+ "5,6,PARENT_OF\n"
			+ "4,5,PARENT_OF\n"
			+ "4,7,PARENT_OF\n"
			+ "3,4,PARENT_OF\n"
			+ "9,10,PARENT_OF\n"
			+ "8,9,PARENT_OF\n"
			+ "8,11,PARENT_OF\n"
			+ "3,8,PARENT_OF\n"
			+ "13,14,PARENT_OF\n"
			+ "12,13,PARENT_OF\n"
			+ "12,15,PARENT_OF\n"
			+ "3,12,PARENT_OF\n"
			+ "16,17,PARENT_OF\n"
			+ "16,18,PARENT_OF\n"
			+ "3,16,PARENT_OF\n";

	/*
		function foo() : int {}
	*/

	public static final String funcNodeStr =  CSVASTSamples.nodeHeader
			+ "3,AST_FUNC_DECL,,3,,0,1,3,foo,\n"
			+ "4,AST_PARAM_LIST,,3,,0,3,,,\n"
			+ "5,NULL,,3,,1,3,,,\n"
			+ "6,AST_STMT_LIST,,3,,2,3,,,\n"
			+ "7,AST_NAME,NAME_NOT_FQ,3,,3,3,,,\n"
			+ "8,string,,3,\"int\",0,3,,,\n";

	public static final String funcEdgeStr = CSVASTSamples.edgeHeader
			+ "3,4,PARENT_OF\n"
			+ "3,5,PARENT_OF\n"
			+ "3,6,PARENT_OF\n"
			+ "7,8,PARENT_OF\n"
			+ "3,7,PARENT_OF\n";

	/*
	 * while($foo) {}
	 * while(true) {}
	 * while(somecall()) {}
	 * while($var === 1) {}
	 */

	public static final String whileNodeStr = CSVASTSamples.nodeHeader
			+ "3,AST_WHILE,,3,,0,1,,,\n"
			+ "4,AST_VAR,,3,,0,1,,,\n"
			+ "5,string,,3,\"foo\",0,1,,,\n"
			+ "6,AST_STMT_LIST,,3,,1,1,,,\n"
			+ "7,AST_WHILE,,4,,1,1,,,\n"
			+ "8,AST_CONST,,4,,0,1,,,\n"
			+ "9,AST_NAME,NAME_NOT_FQ,4,,0,1,,,\n"
			+ "10,string,,4,\"true\",0,1,,,\n"
			+ "11,AST_STMT_LIST,,4,,1,1,,,\n"
			+ "12,AST_WHILE,,5,,2,1,,,\n"
			+ "13,AST_CALL,,5,,0,1,,,\n"
			+ "14,AST_NAME,NAME_NOT_FQ,5,,0,1,,,\n"
			+ "15,string,,5,\"somecall\",0,1,,,\n"
			+ "16,AST_ARG_LIST,,5,,1,1,,,\n"
			+ "17,AST_STMT_LIST,,5,,1,1,,,\n"
			+ "18,AST_WHILE,,6,,3,1,,,\n"
			+ "19,AST_BINARY_OP,BINARY_IS_IDENTICAL,6,,0,1,,,\n"
			+ "20,AST_VAR,,6,,0,1,,,\n"
			+ "21,string,,6,\"var\",0,1,,,\n"
			+ "22,integer,,6,1,1,1,,,\n"
			+ "23,AST_STMT_LIST,,6,,1,1,,,\n";

	public static final String whileEdgeStr = CSVASTSamples.edgeHeader
			+ "4,5,PARENT_OF\n"
			+ "3,4,PARENT_OF\n"
			+ "3,6,PARENT_OF\n"
			+ "9,10,PARENT_OF\n"
			+ "8,9,PARENT_OF\n"
			+ "7,8,PARENT_OF\n"
			+ "7,11,PARENT_OF\n"
			+ "14,15,PARENT_OF\n"
			+ "13,14,PARENT_OF\n"
			+ "13,16,PARENT_OF\n"
			+ "12,13,PARENT_OF\n"
			+ "12,17,PARENT_OF\n"
			+ "20,21,PARENT_OF\n"
			+ "19,20,PARENT_OF\n"
			+ "19,22,PARENT_OF\n"
			+ "18,19,PARENT_OF\n"
			+ "18,23,PARENT_OF\n";

	/*
	 * do {} while($foo);
	 * do {} while(true);
	 * do {} while(somecall());
	 * do {} while($var === 1);
	 */

	public static final String doNodeStr = 	CSVASTSamples.nodeHeader
			+ "3,AST_DO_WHILE,,3,,0,1,,,\n"
			+ "4,AST_STMT_LIST,,3,,0,1,,,\n"
			+ "5,AST_VAR,,3,,1,1,,,\n"
			+ "6,string,,3,\"foo\",0,1,,,\n"
			+ "7,AST_DO_WHILE,,4,,1,1,,,\n"
			+ "8,AST_STMT_LIST,,4,,0,1,,,\n"
			+ "9,AST_CONST,,4,,1,1,,,\n"
			+ "10,AST_NAME,NAME_NOT_FQ,4,,0,1,,,\n"
			+ "11,string,,4,\"true\",0,1,,,\n"
			+ "12,AST_DO_WHILE,,5,,2,1,,,\n"
			+ "13,AST_STMT_LIST,,5,,0,1,,,\n"
			+ "14,AST_CALL,,5,,1,1,,,\n"
			+ "15,AST_NAME,NAME_NOT_FQ,5,,0,1,,,\n"
			+ "16,string,,5,\"somecall\",0,1,,,\n"
			+ "17,AST_ARG_LIST,,5,,1,1,,,\n"
			+ "18,AST_DO_WHILE,,6,,3,1,,,\n"
			+ "19,AST_STMT_LIST,,6,,0,1,,,\n"
			+ "20,AST_BINARY_OP,BINARY_IS_IDENTICAL,6,,1,1,,,\n"
			+ "21,AST_VAR,,6,,0,1,,,\n"
			+ "22,string,,6,\"var\",0,1,,,\n"
			+ "23,integer,,6,1,1,1,,,\n";

	public static final String doEdgeStr = 	CSVASTSamples.edgeHeader
			+ "3,4,PARENT_OF\n"
			+ "5,6,PARENT_OF\n"
			+ "3,5,PARENT_OF\n"
			+ "7,8,PARENT_OF\n"
			+ "10,11,PARENT_OF\n"
			+ "9,10,PARENT_OF\n"
			+ "7,9,PARENT_OF\n"
			+ "12,13,PARENT_OF\n"
			+ "15,16,PARENT_OF\n"
			+ "14,15,PARENT_OF\n"
			+ "14,17,PARENT_OF\n"
			+ "12,14,PARENT_OF\n"
			+ "18,19,PARENT_OF\n"
			+ "21,22,PARENT_OF\n"
			+ "20,21,PARENT_OF\n"
			+ "20,23,PARENT_OF\n"
			+ "18,20,PARENT_OF\n";

	/*
	 * for ($i = 0, $j = 1; $i < 3; $i++, $j++) {}
	 */

	public static final String forNodeStr = CSVASTSamples.nodeHeader
			+ "3,AST_FOR,,3,,0,1,,,\n"
			+ "4,AST_EXPR_LIST,,3,,0,1,,,\n"
			+ "5,AST_ASSIGN,,3,,0,1,,,\n"
			+ "6,AST_VAR,,3,,0,1,,,\n"
			+ "7,string,,3,\"i\",0,1,,,\n"
			+ "8,integer,,3,0,1,1,,,\n"
			+ "9,AST_ASSIGN,,3,,1,1,,,\n"
			+ "10,AST_VAR,,3,,0,1,,,\n"
			+ "11,string,,3,\"j\",0,1,,,\n"
			+ "12,integer,,3,1,1,1,,,\n"
			+ "13,AST_EXPR_LIST,,3,,1,1,,,\n"
			+ "14,AST_BINARY_OP,BINARY_IS_SMALLER,3,,0,1,,,\n"
			+ "15,AST_VAR,,3,,0,1,,,\n"
			+ "16,string,,3,\"i\",0,1,,,\n"
			+ "17,integer,,3,3,1,1,,,\n"
			+ "18,AST_EXPR_LIST,,3,,2,1,,,\n"
			+ "19,AST_POST_INC,,3,,0,1,,,\n"
			+ "20,AST_VAR,,3,,0,1,,,\n"
			+ "21,string,,3,\"i\",0,1,,,\n"
			+ "22,AST_POST_INC,,3,,1,1,,,\n"
			+ "23,AST_VAR,,3,,0,1,,,\n"
			+ "24,string,,3,\"j\",0,1,,,\n"
			+ "25,AST_STMT_LIST,,3,,3,1,,,\n";

	public static final String forEdgeStr = CSVASTSamples.edgeHeader
			+ "6,7,PARENT_OF\n"
			+ "5,6,PARENT_OF\n"
			+ "5,8,PARENT_OF\n"
			+ "4,5,PARENT_OF\n"
			+ "10,11,PARENT_OF\n"
			+ "9,10,PARENT_OF\n"
			+ "9,12,PARENT_OF\n"
			+ "4,9,PARENT_OF\n"
			+ "3,4,PARENT_OF\n"
			+ "15,16,PARENT_OF\n"
			+ "14,15,PARENT_OF\n"
			+ "14,17,PARENT_OF\n"
			+ "13,14,PARENT_OF\n"
			+ "3,13,PARENT_OF\n"
			+ "20,21,PARENT_OF\n"
			+ "19,20,PARENT_OF\n"
			+ "18,19,PARENT_OF\n"
			+ "23,24,PARENT_OF\n"
			+ "22,23,PARENT_OF\n"
			+ "18,22,PARENT_OF\n"
			+ "3,18,PARENT_OF\n"
			+ "3,25,PARENT_OF\n";

}
