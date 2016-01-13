package tests.languages.php.samples;

public class CSVASTSamples {

	// See {@link http://neo4j.com/docs/stable/import-tool-header-format.html} for detailed
	// information about the header file format
	public static final String nodeHeader = "id:ID,type,flags:string[],lineno:int,code,childnum:int,funcid:int,endlineno:int,name,doccomment\n";
	public static final String edgeHeader = ":START_ID,:END_ID,:TYPE\n";

	/*
	 * 42;
	 * 3.14;
	 * "Hello World!";
	 */

	public static final String primaryExpressionNodeStr = nodeHeader
			+ "3,integer,,1,42,0,1,,,\n"
			+ "4,double,,1,3.14,1,1,,,\n"
			+ "5,string,,1,\"Hello World!\",2,1,,,\n";


	/*
	 * class foo extends bar implements buz {}
	 */

	public static final String nameNodeStr = nodeHeader
			+ "3,AST_CLASS,,3,,0,1,3,foo,\n"
			+ "4,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n"
			+ "5,string,,3,\"bar\",0,1,,,\n"
			+ "6,AST_NAME_LIST,,3,,1,1,,,\n"
			+ "7,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n"
			+ "8,string,,3,\"buz\",0,1,,,\n"
			+ "9,AST_TOPLEVEL,TOPLEVEL_CLASS,3,,2,1,3,\"foo\",\n"
			+ "10,AST_STMT_LIST,,3,,0,9,,,\n";

	public static final String nameEdgeStr = edgeHeader
			+ "4,5,PARENT_OF\n"
			+ "3,4,PARENT_OF\n"
			+ "7,8,PARENT_OF\n"
			+ "6,7,PARENT_OF\n"
			+ "3,6,PARENT_OF\n"
			+ "9,10,PARENT_OF\n"
			+ "3,9,PARENT_OF\n";
	
	
	/*
	 * function() use ($foo,$bar) {};
	 */
	
	public static final String closureVariableNodeStr = nodeHeader
			+ "3,AST_CLOSURE,,3,,0,1,3,{closure},\n"
			+ "4,AST_PARAM_LIST,,3,,0,3,,,\n"
			+ "5,AST_CLOSURE_USES,,3,,1,3,,,\n"
			+ "6,AST_CLOSURE_VAR,,3,,0,3,,,\n"
			+ "7,string,,3,\"foo\",0,3,,,\n"
			+ "8,AST_CLOSURE_VAR,,3,,1,3,,,\n"
			+ "9,string,,3,\"bar\",0,3,,,\n"
			+ "10,AST_STMT_LIST,,3,,2,3,,,\n"
			+ "11,NULL,,3,,3,3,,,\n";
	
	public static final String closureVariableEdgeStr = edgeHeader
			+ "3,4,PARENT_OF\n"
			+ "6,7,PARENT_OF\n"
			+ "5,6,PARENT_OF\n"
			+ "8,9,PARENT_OF\n"
			+ "5,8,PARENT_OF\n"
			+ "3,5,PARENT_OF\n"
			+ "3,10,PARENT_OF\n"
			+ "3,11,PARENT_OF\n";


	 /*
	  * $foo;
	  * $$bar;
	  */
	
	public static final String variableNodeStr = nodeHeader
			+ "2,AST_STMT_LIST,,1,,0,1,,,\n"
			+ "3,AST_VAR,,3,,0,1,,,\n"
			+ "4,string,,3,\"foo\",0,1,,,\n"
			+ "5,AST_VAR,,4,,1,1,,,\n"
			+ "6,AST_VAR,,4,,0,1,,,\n"
			+ "7,string,,4,\"bar\",0,1,,,\n";
	
	public static final String variableEdgeStr = edgeHeader
			+ "3,4,PARENT_OF\n"
			+ "2,3,PARENT_OF\n"
			+ "6,7,PARENT_OF\n"
			+ "5,6,PARENT_OF\n"
			+ "2,5,PARENT_OF\n";
	
	/*
	 * FOO;
	 * \BAR\BUZ;
	 */
	
	public static final String constantNodeStr = nodeHeader
			+ "3,AST_CONST,,3,,0,1,,,\n"
			+ "4,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n"
			+ "5,string,,3,\"FOO\",0,1,,,\n"
			+ "6,AST_CONST,,4,,1,1,,,\n"
			+ "7,AST_NAME,NAME_FQ,4,,0,1,,,\n"
			+ "8,string,,4,\"BAR\\BUZ\",0,1,,,\n";

	public static final String constantEdgeStr = edgeHeader
			+ "4,5,PARENT_OF\n"
			+ "3,4,PARENT_OF\n"
			+ "7,8,PARENT_OF\n"
			+ "6,7,PARENT_OF\n";
	
	
	/*
	 * empty($foo);
	 * empty(bar());
	 */
	
	public static final String emptyNodeStr = nodeHeader
			+ "3,AST_EMPTY,,3,,0,1,,,\n"
			+ "4,AST_VAR,,3,,0,1,,,\n"
			+ "5,string,,3,\"foo\",0,1,,,\n"
			+ "6,AST_EMPTY,,4,,1,1,,,\n"
			+ "7,AST_CALL,,4,,0,1,,,\n"
			+ "8,AST_NAME,NAME_NOT_FQ,4,,0,1,,,\n"
			+ "9,string,,4,\"bar\",0,1,,,\n"
			+ "10,AST_ARG_LIST,,4,,1,1,,,\n";	
	
	public static final String emptyEdgeStr = edgeHeader
			+ "4,5,PARENT_OF\n"
			+ "3,4,PARENT_OF\n"
			+ "8,9,PARENT_OF\n"
			+ "7,8,PARENT_OF\n"
			+ "7,10,PARENT_OF\n"
			+ "6,7,PARENT_OF\n";
	
	
	/*
	 * isset($foo);
	 * isset($bar->buz);
	 */
	
	public static final String issetNodeStr = nodeHeader
			+ "3,AST_ISSET,,3,,0,1,,,\n"
			+ "4,AST_VAR,,3,,0,1,,,\n"
			+ "5,string,,3,\"foo\",0,1,,,\n"
			+ "6,AST_ISSET,,4,,1,1,,,\n"
			+ "7,AST_PROP,,4,,0,1,,,\n"
			+ "8,AST_VAR,,4,,0,1,,,\n"
			+ "9,string,,4,\"bar\",0,1,,,\n"
			+ "10,string,,4,\"buz\",1,1,,,\n";

	public static final String issetEdgeStr = edgeHeader
			+ "4,5,PARENT_OF\n"
			+ "3,4,PARENT_OF\n"
			+ "8,9,PARENT_OF\n"
			+ "7,8,PARENT_OF\n"
			+ "7,10,PARENT_OF\n"
			+ "6,7,PARENT_OF\n";
	
	
	/*
	 * $output = `cat /var/www/html/.htpasswd`;
	 * $output2 = `$attackerinput`;
	 */

	public static final String shellExecNodeStr = nodeHeader
			+ "3,AST_ASSIGN,,3,,0,1,,,\n"
			+ "4,AST_VAR,,3,,0,1,,,\n"
			+ "5,string,,3,\"output\",0,1,,,\n"
			+ "6,AST_SHELL_EXEC,,3,,1,1,,,\n"
			+ "7,string,,3,\"cat /var/www/html/.htpasswd\",0,1,,,\n"
			+ "8,AST_ASSIGN,,4,,1,1,,,\n"
			+ "9,AST_VAR,,4,,0,1,,,\n"
			+ "10,string,,4,\"output2\",0,1,,,\n"
			+ "11,AST_SHELL_EXEC,,4,,1,1,,,\n"
			+ "12,AST_ENCAPS_LIST,,4,,0,1,,,\n"
			+ "13,AST_VAR,,4,,0,1,,,\n"
			+ "14,string,,4,\"attackerinput\",0,1,,,\n";

	public static final String shellExecEdgeStr = edgeHeader
			+ "4,5,PARENT_OF\n"
			+ "3,4,PARENT_OF\n"
			+ "6,7,PARENT_OF\n"
			+ "3,6,PARENT_OF\n"
			+ "9,10,PARENT_OF\n"
			+ "8,9,PARENT_OF\n"
			+ "13,14,PARENT_OF\n"
			+ "12,13,PARENT_OF\n"
			+ "11,12,PARENT_OF\n"
			+ "8,11,PARENT_OF\n";
			
	
	/*
	 * clone($foo);
	 * clone(bar());
	 */
	public static final String cloneNodeStr = nodeHeader
			+ "3,AST_CLONE,,3,,0,1,,,\n"
			+ "4,AST_VAR,,3,,0,1,,,\n"
			+ "5,string,,3,\"foo\",0,1,,,\n"
			+ "6,AST_CLONE,,4,,1,1,,,\n"
			+ "7,AST_CALL,,4,,0,1,,,\n"
			+ "8,AST_NAME,NAME_NOT_FQ,4,,0,1,,,\n"
			+ "9,string,,4,\"bar\",0,1,,,\n"
			+ "10,AST_ARG_LIST,,4,,1,1,,,\n";

	public static final String cloneEdgeStr = edgeHeader
			+ "4,5,PARENT_OF\n"
			+ "3,4,PARENT_OF\n"
			+ "8,9,PARENT_OF\n"
			+ "7,8,PARENT_OF\n"
			+ "7,10,PARENT_OF\n"
			+ "6,7,PARENT_OF\n";

	
	/*
 	 * ++$i;
	 */
	public static final String preIncNodeStr = nodeHeader
			+ "3,AST_PRE_INC,,3,,0,1,,,\n"
			+ "4,AST_VAR,,3,,0,1,,,\n"
			+ "5,string,,3,\"i\",0,1,,,\n";
	
	public static final String preIncEdgeStr = edgeHeader
			+ "4,5,PARENT_OF\n"
			+ "3,4,PARENT_OF\n";


	/*
	 * --$i;
	 */
	
	public static final String preDecNodeStr = nodeHeader
			+ "3,AST_PRE_DEC,,3,,0,1,,,\n"
			+ "4,AST_VAR,,3,,0,1,,,\n"
			+ "5,string,,3,\"i\",0,1,,,\n";
	
	public static final String preDecEdgeStr = edgeHeader
			+ "4,5,PARENT_OF\n"
			+ "3,4,PARENT_OF\n";
	
	
	/*
	 * $i++;
	 */
	
	public static final String postIncNodeStr = nodeHeader
			+ "3,AST_POST_INC,,3,,0,1,,,\n"
			+ "4,AST_VAR,,3,,0,1,,,\n"
			+ "5,string,,3,\"i\",0,1,,,\n";
	
	public static final String postIncEdgeStr = edgeHeader
			+ "4,5,PARENT_OF\n"
			+ "3,4,PARENT_OF\n";


	/*
	 * $i--;
	 */
	
	public static final String postDecNodeStr = nodeHeader
			+ "3,AST_POST_DEC,,3,,0,1,,,\n"
			+ "4,AST_VAR,,3,,0,1,,,\n"
			+ "5,string,,3,\"i\",0,1,,,\n";
	
	public static final String postDecEdgeStr = edgeHeader
			+ "4,5,PARENT_OF\n"
			+ "3,4,PARENT_OF\n";

	
	/*
	 * function foo() {
	 *   global $bar, $buz;
	 * }
	 */

	public static final String globalNodeStr = nodeHeader
			+ "3,AST_FUNC_DECL,,3,,0,1,5,foo,\n"
			+ "4,AST_PARAM_LIST,,3,,0,3,,,\n"
			+ "5,NULL,,3,,1,3,,,\n"
			+ "6,AST_STMT_LIST,,3,,2,3,,,\n"
			+ "7,AST_STMT_LIST,,4,,0,3,,,\n"
			+ "8,AST_GLOBAL,,4,,0,3,,,\n"
			+ "9,AST_VAR,,4,,0,3,,,\n"
			+ "10,string,,4,\"bar\",0,3,,,\n"
			+ "11,AST_GLOBAL,,4,,1,3,,,\n"
			+ "12,AST_VAR,,4,,0,3,,,\n"
			+ "13,string,,4,\"buz\",0,3,,,\n"
			+ "14,NULL,,3,,3,3,,,\n";

	public static final String globalEdgeStr = edgeHeader
			+ "3,4,PARENT_OF\n"
			+ "3,5,PARENT_OF\n"
			+ "9,10,PARENT_OF\n"
			+ "8,9,PARENT_OF\n"
			+ "7,8,PARENT_OF\n"
			+ "12,13,PARENT_OF\n"
			+ "11,12,PARENT_OF\n"
			+ "7,11,PARENT_OF\n"
			+ "6,7,PARENT_OF\n"
			+ "3,6,PARENT_OF\n"
			+ "3,14,PARENT_OF\n";
	

	/*
	 * unset($foo,$bar->buz,$qux[42]);
	 */
	
	public static final String unsetNodeStr = nodeHeader
			+ "3,AST_STMT_LIST,,3,,0,1,,,\n"
			+ "4,AST_UNSET,,3,,0,1,,,\n"
			+ "5,AST_VAR,,3,,0,1,,,\n"
			+ "6,string,,3,\"foo\",0,1,,,\n"
			+ "7,AST_UNSET,,3,,1,1,,,\n"
			+ "8,AST_PROP,,3,,0,1,,,\n"
			+ "9,AST_VAR,,3,,0,1,,,\n"
			+ "10,string,,3,\"bar\",0,1,,,\n"
			+ "11,string,,3,\"buz\",1,1,,,\n"
			+ "12,AST_UNSET,,3,,2,1,,,\n"
			+ "13,AST_DIM,,3,,0,1,,,\n"
			+ "14,AST_VAR,,3,,0,1,,,\n"
			+ "15,string,,3,\"qux\",0,1,,,\n"
			+ "16,integer,,3,42,1,1,,,\n";

	public static final String unsetEdgeStr = edgeHeader
			+ "5,6,PARENT_OF\n"
			+ "4,5,PARENT_OF\n"
			+ "3,4,PARENT_OF\n"
			+ "9,10,PARENT_OF\n"
			+ "8,9,PARENT_OF\n"
			+ "8,11,PARENT_OF\n"
			+ "7,8,PARENT_OF\n"
			+ "3,7,PARENT_OF\n"
			+ "14,15,PARENT_OF\n"
			+ "13,14,PARENT_OF\n"
			+ "13,16,PARENT_OF\n"
			+ "12,13,PARENT_OF\n"
			+ "3,12,PARENT_OF\n";
	
	
	/*
	 * $foo->bar;
	 * buz()->$qux;
	 */
	
	public static final String propertyNodeStr = nodeHeader
			+ "3,AST_PROP,,3,,0,1,,,\n"
			+ "4,AST_VAR,,3,,0,1,,,\n"
			+ "5,string,,3,\"foo\",0,1,,,\n"
			+ "6,string,,3,\"bar\",1,1,,,\n"
			+ "7,AST_PROP,,4,,1,1,,,\n"
			+ "8,AST_CALL,,4,,0,1,,,\n"
			+ "9,AST_NAME,NAME_NOT_FQ,4,,0,1,,,\n"
			+ "10,string,,4,\"buz\",0,1,,,\n"
			+ "11,AST_ARG_LIST,,4,,1,1,,,\n"
			+ "12,AST_VAR,,4,,1,1,,,\n"
			+ "13,string,,4,\"qux\",0,1,,,\n";
	
	public static final String propertyEdgeStr = edgeHeader
			+ "4,5,PARENT_OF\n"
			+ "3,4,PARENT_OF\n"
			+ "3,6,PARENT_OF\n"
			+ "9,10,PARENT_OF\n"
			+ "8,9,PARENT_OF\n"
			+ "8,11,PARENT_OF\n"
			+ "7,8,PARENT_OF\n"
			+ "12,13,PARENT_OF\n"
			+ "7,12,PARENT_OF\n";

	
	/*
	 * Foo::$bar;
	 * $foo::$bar;
	 * buz()::$$qux;
	 */
	
	public static final String staticPropertyNodeStr = nodeHeader
			+ "2,AST_STMT_LIST,,1,,0,1,,,\n"
			+ "3,AST_STATIC_PROP,,3,,0,1,,,\n"
			+ "4,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n"
			+ "5,string,,3,\"Foo\",0,1,,,\n"
			+ "6,string,,3,\"bar\",1,1,,,\n"
			+ "7,AST_STATIC_PROP,,4,,1,1,,,\n"
			+ "8,AST_VAR,,4,,0,1,,,\n"
			+ "9,string,,4,\"foo\",0,1,,,\n"
			+ "10,string,,4,\"bar\",1,1,,,\n"
			+ "11,AST_STATIC_PROP,,5,,2,1,,,\n"
			+ "12,AST_CALL,,5,,0,1,,,\n"
			+ "13,AST_NAME,NAME_NOT_FQ,5,,0,1,,,\n"
			+ "14,string,,5,\"buz\",0,1,,,\n"
			+ "15,AST_ARG_LIST,,5,,1,1,,,\n"
			+ "16,AST_VAR,,5,,1,1,,,\n"
			+ "17,string,,5,\"qux\",0,1,,,\n";
	
	public static final String staticPropertyEdgeStr = edgeHeader
			+ "4,5,PARENT_OF\n"
			+ "3,4,PARENT_OF\n"
			+ "3,6,PARENT_OF\n"
			+ "2,3,PARENT_OF\n"
			+ "8,9,PARENT_OF\n"
			+ "7,8,PARENT_OF\n"
			+ "7,10,PARENT_OF\n"
			+ "2,7,PARENT_OF\n"
			+ "13,14,PARENT_OF\n"
			+ "12,13,PARENT_OF\n"
			+ "12,15,PARENT_OF\n"
			+ "11,12,PARENT_OF\n"
			+ "16,17,PARENT_OF\n"
			+ "11,16,PARENT_OF\n"
			+ "2,11,PARENT_OF\n";
	
	
	/*
	 * Foo::BAR;
	 * $foo::BAR;
	 * buz()::QUX;
	 */

	public static final String classConstantNodeStr = nodeHeader
			+ "3,AST_CLASS_CONST,,3,,0,1,,,\n"
			+ "4,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n"
			+ "5,string,,3,\"Foo\",0,1,,,\n"
			+ "6,string,,3,\"BAR\",1,1,,,\n"
			+ "7,AST_CLASS_CONST,,4,,1,1,,,\n"
			+ "8,AST_VAR,,4,,0,1,,,\n"
			+ "9,string,,4,\"foo\",0,1,,,\n"
			+ "10,string,,4,\"BAR\",1,1,,,\n"
			+ "11,AST_CLASS_CONST,,5,,2,1,,,\n"
			+ "12,AST_CALL,,5,,0,1,,,\n"
			+ "13,AST_NAME,NAME_NOT_FQ,5,,0,1,,,\n"
			+ "14,string,,5,\"buz\",0,1,,,\n"
			+ "15,AST_ARG_LIST,,5,,1,1,,,\n"
			+ "16,string,,5,\"QUX\",1,1,,,\n";
	
	public static final String classConstantEdgeStr = edgeHeader
			+ "4,5,PARENT_OF\n"
			+ "3,4,PARENT_OF\n"
			+ "3,6,PARENT_OF\n"
			+ "8,9,PARENT_OF\n"
			+ "7,8,PARENT_OF\n"
			+ "7,10,PARENT_OF\n"
			+ "13,14,PARENT_OF\n"
			+ "12,13,PARENT_OF\n"
			+ "12,15,PARENT_OF\n"
			+ "11,12,PARENT_OF\n"
			+ "11,16,PARENT_OF\n";
		
	
	/*
	 * $foo += 42;
	 * $bar .= "bonjour";
	 * $buz ^= $onetimepad;
	 */
	
	public static final String assignWithOpNodeStr = nodeHeader
			+ "3,AST_ASSIGN_OP,ASSIGN_ADD,3,,0,1,,,\n"
			+ "4,AST_VAR,,3,,0,1,,,\n"
			+ "5,string,,3,\"foo\",0,1,,,\n"
			+ "6,integer,,3,42,1,1,,,\n"
			+ "7,AST_ASSIGN_OP,ASSIGN_CONCAT,4,,1,1,,,\n"
			+ "8,AST_VAR,,4,,0,1,,,\n"
			+ "9,string,,4,\"bar\",0,1,,,\n"
			+ "10,string,,4,\"bonjour\",1,1,,,\n"
			+ "11,AST_ASSIGN_OP,ASSIGN_BITWISE_XOR,5,,2,1,,,\n"
			+ "12,AST_VAR,,5,,0,1,,,\n"
			+ "13,string,,5,\"buz\",0,1,,,\n"
			+ "14,AST_VAR,,5,,1,1,,,\n"
			+ "15,string,,5,\"onetimepad\",0,1,,,\n";
	
	public static final String assignWithOpEdgeStr = edgeHeader
			+ "4,5,PARENT_OF\n"
			+ "3,4,PARENT_OF\n"
			+ "3,6,PARENT_OF\n"
			+ "8,9,PARENT_OF\n"
			+ "7,8,PARENT_OF\n"
			+ "7,10,PARENT_OF\n"
			+ "12,13,PARENT_OF\n"
			+ "11,12,PARENT_OF\n"
			+ "14,15,PARENT_OF\n"
			+ "11,14,PARENT_OF\n";
			
	
	/*
	 * if($foo) {}
	 * elseif($bar) {}
	 * elseif($buz) {}
	 * else {}
	 */

	public static final String ifStatementNodeStr = nodeHeader
			+ "3,AST_IF,,3,,0,1,,,\n"
			+ "4,AST_IF_ELEM,,3,,0,1,,,\n"
			+ "5,AST_VAR,,3,,0,1,,,\n"
			+ "6,string,,3,\"foo\",0,1,,,\n"
			+ "7,AST_STMT_LIST,,3,,1,1,,,\n"
			+ "8,AST_IF_ELEM,,4,,1,1,,,\n"
			+ "9,AST_VAR,,4,,0,1,,,\n"
			+ "10,string,,4,\"bar\",0,1,,,\n"
			+ "11,AST_STMT_LIST,,4,,1,1,,,\n"
			+ "12,AST_IF_ELEM,,5,,2,1,,,\n"
			+ "13,AST_VAR,,5,,0,1,,,\n"
			+ "14,string,,5,\"buz\",0,1,,,\n"
			+ "15,AST_STMT_LIST,,5,,1,1,,,\n"
			+ "16,AST_IF_ELEM,,6,,3,1,,,\n"
			+ "17,NULL,,6,,0,1,,,\n"
			+ "18,AST_STMT_LIST,,6,,1,1,,,\n";

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
	 * function foo() : int {}
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

	public static final String foreachNodeStr = CSVASTSamples.nodeHeader
			+ "3,AST_FOREACH,,3,,0,1,,,\n"
			+ "4,AST_VAR,,3,,0,1,,,\n"
			+ "5,string,,3,\"somearray\",0,1,,,\n"
			+ "6,AST_VAR,,3,,1,1,,,\n"
			+ "7,string,,3,\"foo\",0,1,,,\n"
			+ "8,NULL,,3,,2,1,,,\n"
			+ "9,AST_STMT_LIST,,3,,3,1,,,\n"
			+ "10,AST_FOREACH,,4,,1,1,,,\n"
			+ "11,AST_CALL,,4,,0,1,,,\n"
			+ "12,AST_NAME,NAME_NOT_FQ,4,,0,1,,,\n"
			+ "13,string,,4,\"somecall\",0,1,,,\n"
			+ "14,AST_ARG_LIST,,4,,1,1,,,\n"
			+ "15,AST_VAR,,4,,1,1,,,\n"
			+ "16,string,,4,\"foo\",0,1,,,\n"
			+ "17,AST_VAR,,4,,2,1,,,\n"
			+ "18,string,,4,\"bar\",0,1,,,\n"
			+ "19,AST_STMT_LIST,,4,,3,1,,,\n";

	public static final String foreachEdgeStr = CSVASTSamples.edgeHeader
			+ "4,5,PARENT_OF\n"
			+ "3,4,PARENT_OF\n"
			+ "6,7,PARENT_OF\n"
			+ "3,6,PARENT_OF\n"
			+ "3,8,PARENT_OF\n"
			+ "3,9,PARENT_OF\n"
			+ "12,13,PARENT_OF\n"
			+ "11,12,PARENT_OF\n"
			+ "11,14,PARENT_OF\n"
			+ "10,11,PARENT_OF\n"
			+ "15,16,PARENT_OF\n"
			+ "10,15,PARENT_OF\n"
			+ "17,18,PARENT_OF\n"
			+ "10,17,PARENT_OF\n"
			+ "10,19,PARENT_OF\n";

	/*
	<?php

	if($foo){
	    return;
	}
	bar();

	?> 	*/
	public static final String retNodeStr = CSVASTSamples.nodeHeader
		+ "2,AST_IF,,5,,0,,,,\n"
		+ "3,AST_IF_ELEM,,3,,0,,,,\n"
		+ "4,AST_VAR,,3,,0,,,,\n"
		+ "5,string,,3,\"foo\",0,,,,\n"
		+ "6,AST_STMT_LIST,,3,,1,,,,\n"
		+ "7,AST_RETURN,,4,,0,,,,\n"
		+ "8,NULL,,4,,0,,,,\n"
		+ "9,AST_CALL,,6,,1,,,,\n"
		+ "10,AST_NAME,NAME_NOT_FQ,6,,0,,,,\n"
		+ "11,string,,6,\"bar\",0,,,,\n"
		+ "12,AST_ARG_LIST,,6,,1,,,,\n"
		+ "13,NULL,,1,,2,,,,\n"
		;

	public static final String retEdgeStr = CSVASTSamples.edgeHeader
		+ "4,5,PARENT_OF\n"
		+ "3,4,PARENT_OF\n"
		+ "7,8,PARENT_OF\n"
		+ "6,7,PARENT_OF\n"
		+ "3,6,PARENT_OF\n"
		+ "2,3,PARENT_OF\n"
		+ "10,11,PARENT_OF\n"
		+ "9,10,PARENT_OF\n"
		+ "9,12,PARENT_OF\n"
		;

	/*
	<?php
	goto a;
	foo();
	a:
	bar();
	?> 	*/
	public static final String gotoNodeStr = CSVASTSamples.nodeHeader
		+ "1,AST_STMT_LIST,,1,,0,,,,\n"
		+ "2,AST_GOTO,,2,,0,,,,\n"
		+ "3,string,,2,\"a\",0,,,,\n"
		+ "4,AST_CALL,,3,,1,,,,\n"
		+ "5,AST_NAME,NAME_NOT_FQ,3,,0,,,,\n"
		+ "6,string,,3,\"foo\",0,,,,\n"
		+ "7,AST_ARG_LIST,,3,,1,,,,\n"
		+ "8,AST_LABEL,,4,,2,,,,\n"
		+ "9,string,,4,\"a\",0,,,,\n"
		+ "10,AST_CALL,,5,,3,,,,\n"
		+ "11,AST_NAME,NAME_NOT_FQ,5,,0,,,,\n"
		+ "12,string,,5,\"bar\",0,,,,\n"
		+ "13,AST_ARG_LIST,,5,,1,,,,\n"
		;

	public static final String gotoEdgeStr = CSVASTSamples.edgeHeader
		+ "2,3,PARENT_OF\n"
		+ "1,2,PARENT_OF\n"
		+ "5,6,PARENT_OF\n"
		+ "4,5,PARENT_OF\n"
		+ "4,7,PARENT_OF\n"
		+ "1,4,PARENT_OF\n"
		+ "8,9,PARENT_OF\n"
		+ "1,8,PARENT_OF\n"
		+ "11,12,PARENT_OF\n"
		+ "10,11,PARENT_OF\n"
		+ "10,13,PARENT_OF\n"
		+ "1,10,PARENT_OF\n"
		;


	/*
	<?php

	while($foo){

	    if($bar)
	        continue;

	    $foo = call();
	}
	*/
	public static final String continueNodeStr = CSVASTSamples.nodeHeader
		+ "1,AST_STMT_LIST,,1,,0,,,,\n"
		+ "2,AST_WHILE,,3,,0,,,,\n"
		+ "3,AST_VAR,,3,,0,,,,\n"
		+ "4,string,,3,\"foo\",0,,,,\n"
		+ "5,AST_STMT_LIST,,3,,1,,,,\n"
		+ "6,AST_IF,,6,,0,,,,\n"
		+ "7,AST_IF_ELEM,,5,,0,,,,\n"
		+ "8,AST_VAR,,5,,0,,,,\n"
		+ "9,string,,5,\"bar\",0,,,,\n"
		+ "10,AST_CONTINUE,,6,,1,,,,\n"
		+ "11,NULL,,6,,0,,,,\n"
		+ "12,AST_ASSIGN,,8,,1,,,,\n"
		+ "13,AST_VAR,,8,,0,,,,\n"
		+ "14,string,,8,\"foo\",0,,,,\n"
		+ "15,AST_CALL,,8,,1,,,,\n"
		+ "16,AST_NAME,NAME_NOT_FQ,8,,0,,,,\n"
		+ "17,string,,8,\"call\",0,,,,\n"
		+ "18,AST_ARG_LIST,,8,,1,,,,\n"
		;

	public static final String continueEdgeStr = CSVASTSamples.edgeHeader
		+ "3,4,PARENT_OF\n"
		+ "2,3,PARENT_OF\n"
		+ "8,9,PARENT_OF\n"
		+ "7,8,PARENT_OF\n"
		+ "10,11,PARENT_OF\n"
		+ "7,10,PARENT_OF\n"
		+ "6,7,PARENT_OF\n"
		+ "5,6,PARENT_OF\n"
		+ "13,14,PARENT_OF\n"
		+ "12,13,PARENT_OF\n"
		+ "16,17,PARENT_OF\n"
		+ "15,16,PARENT_OF\n"
		+ "15,18,PARENT_OF\n"
		+ "12,15,PARENT_OF\n"
		+ "5,12,PARENT_OF\n"
		+ "2,5,PARENT_OF\n"
		+ "1,2,PARENT_OF\n"
		;

	/*
	<?php

	while($foo){

	    if($bar)
	        break;

	    $foo = call();
	}
	*/
	public static final String breakNodeStr = CSVASTSamples.nodeHeader
		+ "1,AST_STMT_LIST,,1,,0,,,,\n"
		+ "2,AST_WHILE,,3,,0,,,,\n"
		+ "3,AST_VAR,,3,,0,,,,\n"
		+ "4,string,,3,\"foo\",0,,,,\n"
		+ "5,AST_STMT_LIST,,3,,1,,,,\n"
		+ "6,AST_IF,,6,,0,,,,\n"
		+ "7,AST_IF_ELEM,,5,,0,,,,\n"
		+ "8,AST_VAR,,5,,0,,,,\n"
		+ "9,string,,5,\"bar\",0,,,,\n"
		+ "10,AST_BREAK,,6,,1,,,,\n"
		+ "11,NULL,,6,,0,,,,\n"
		+ "12,AST_ASSIGN,,8,,1,,,,\n"
		+ "13,AST_VAR,,8,,0,,,,\n"
		+ "14,string,,8,\"foo\",0,,,,\n"
		+ "15,AST_CALL,,8,,1,,,,\n"
		+ "16,AST_NAME,NAME_NOT_FQ,8,,0,,,,\n"
		+ "17,string,,8,\"call\",0,,,,\n"
		+ "18,AST_ARG_LIST,,8,,1,,,,\n"
		;

	public static final String breakEdgeStr = CSVASTSamples.edgeHeader
		+ "3,4,PARENT_OF\n"
		+ "2,3,PARENT_OF\n"
		+ "8,9,PARENT_OF\n"
		+ "7,8,PARENT_OF\n"
		+ "10,11,PARENT_OF\n"
		+ "7,10,PARENT_OF\n"
		+ "6,7,PARENT_OF\n"
		+ "5,6,PARENT_OF\n"
		+ "13,14,PARENT_OF\n"
		+ "12,13,PARENT_OF\n"
		+ "16,17,PARENT_OF\n"
		+ "15,16,PARENT_OF\n"
		+ "15,18,PARENT_OF\n"
		+ "12,15,PARENT_OF\n"
		+ "5,12,PARENT_OF\n"
		+ "2,5,PARENT_OF\n"
		+ "1,2,PARENT_OF\n"
		;

	/*
	<?php

	try{
	    bar();
	} catch(Exception $e) {
	    exceptionHandler();
	}
	*/
	public static final String tryNodeStr = CSVASTSamples.nodeHeader
		+ "1,AST_STMT_LIST,,1,,0,,,,\n"
		+ "2,AST_TRY,,3,,0,,,,\n"
		+ "3,AST_STMT_LIST,,3,,0,,,,\n"
		+ "4,AST_CALL,,4,,0,,,,\n"
		+ "5,AST_NAME,NAME_NOT_FQ,4,,0,,,,\n"
		+ "6,string,,4,\"bar\",0,,,,\n"
		+ "7,AST_ARG_LIST,,4,,1,,,,\n"
		+ "8,AST_CATCH_LIST,,5,,1,,,,\n"
		+ "9,AST_CATCH,,5,,0,,,,\n"
		+ "10,AST_NAME,NAME_NOT_FQ,5,,0,,,,\n"
		+ "11,string,,5,\"Exception\",0,,,,\n"
		+ "12,string,,5,\"e\",1,,,,\n"
		+ "13,AST_STMT_LIST,,5,,2,,,,\n"
		+ "14,AST_CALL,,6,,0,,,,\n"
		+ "15,AST_NAME,NAME_NOT_FQ,6,,0,,,,\n"
		+ "16,string,,6,\"exceptionHandler\",0,,,,\n"
		+ "17,AST_ARG_LIST,,6,,1,,,,\n"
		+ "18,NULL,,3,,2,,,,\n"
		;

	public static final String tryEdgeStr = CSVASTSamples.edgeHeader
		+ "5,6,PARENT_OF\n"
		+ "4,5,PARENT_OF\n"
		+ "4,7,PARENT_OF\n"
		+ "3,4,PARENT_OF\n"
		+ "2,3,PARENT_OF\n"
		+ "10,11,PARENT_OF\n"
		+ "9,10,PARENT_OF\n"
		+ "9,12,PARENT_OF\n"
		+ "15,16,PARENT_OF\n"
		+ "14,15,PARENT_OF\n"
		+ "14,17,PARENT_OF\n"
		+ "13,14,PARENT_OF\n"
		+ "9,13,PARENT_OF\n"
		+ "8,9,PARENT_OF\n"
		+ "2,8,PARENT_OF\n"
		+ "2,18,PARENT_OF\n"
		+ "1,2,PARENT_OF\n"
		;


}
