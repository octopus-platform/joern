package tests.languages.php.samples;

/**
 * Simlarly as CSVASTSamples, this class contains some PHP AST samples in CSV format,
 * optimized for testing def/use analysis.
 */
public class CSVASTDefUseSamples extends CSVASTSamples {

	/*
	 * function foo($bar,&$buz) {}
	 */

	public static final String defUseFunctionDefNodeStr = nodeHeader
			+ "2,AST_STMT_LIST,,1,,0,1,,,\n"
			+ "3,AST_FUNC_DECL,,3,,0,1,3,foo,\n"
			+ "4,AST_PARAM_LIST,,3,,0,3,,,\n"
			+ "5,AST_PARAM,,3,,0,3,,,\n"
			+ "6,NULL,,3,,0,3,,,\n"
			+ "7,string,,3,\"bar\",1,3,,,\n"
			+ "8,NULL,,3,,2,3,,,\n"
			+ "9,AST_PARAM,PARAM_REF,3,,1,3,,,\n"
			+ "10,NULL,,3,,0,3,,,\n"
			+ "11,string,,3,\"buz\",1,3,,,\n"
			+ "12,NULL,,3,,2,3,,,\n"
			+ "13,NULL,,3,,1,3,,,\n"
			+ "14,AST_STMT_LIST,,3,,2,3,,,\n"
			+ "15,NULL,,3,,3,3,,,\n";

	public static final String defUseFunctionDefEdgeStr = edgeHeader
			+ "5,6,PARENT_OF\n"
			+ "5,7,PARENT_OF\n"
			+ "5,8,PARENT_OF\n"
			+ "4,5,PARENT_OF\n"
			+ "9,10,PARENT_OF\n"
			+ "9,11,PARENT_OF\n"
			+ "9,12,PARENT_OF\n"
			+ "4,9,PARENT_OF\n"
			+ "3,4,PARENT_OF\n"
			+ "3,13,PARENT_OF\n"
			+ "3,14,PARENT_OF\n"
			+ "3,15,PARENT_OF\n"
			+ "2,3,PARENT_OF\n";
	
	
	/*
	 * function($bar,&$buz) use ($qux,&$norf) {};
	 */

	public static final String defUseClosureNodeStr = nodeHeader
			+ "2,AST_STMT_LIST,,1,,0,1,,,\n"
			+ "3,AST_CLOSURE,,3,,0,1,3,{closure},\n"
			+ "4,AST_PARAM_LIST,,3,,0,3,,,\n"
			+ "5,AST_PARAM,,3,,0,3,,,\n"
			+ "6,NULL,,3,,0,3,,,\n"
			+ "7,string,,3,\"bar\",1,3,,,\n"
			+ "8,NULL,,3,,2,3,,,\n"
			+ "9,AST_PARAM,PARAM_REF,3,,1,3,,,\n"
			+ "10,NULL,,3,,0,3,,,\n"
			+ "11,string,,3,\"buz\",1,3,,,\n"
			+ "12,NULL,,3,,2,3,,,\n"
			+ "13,AST_CLOSURE_USES,,3,,1,3,,,\n"
			+ "14,AST_CLOSURE_VAR,,3,,0,3,,,\n"
			+ "15,string,,3,\"qux\",0,3,,,\n"
			+ "16,AST_CLOSURE_VAR,BY_REFERENCE,3,,1,3,,,\n"
			+ "17,string,,3,\"norf\",0,3,,,\n"
			+ "18,AST_STMT_LIST,,3,,2,3,,,\n"
			+ "19,NULL,,3,,3,3,,,\n";


	public static final String defUseClosureEdgeStr = edgeHeader
			+ "5,6,PARENT_OF\n"
			+ "5,7,PARENT_OF\n"
			+ "5,8,PARENT_OF\n"
			+ "4,5,PARENT_OF\n"
			+ "9,10,PARENT_OF\n"
			+ "9,11,PARENT_OF\n"
			+ "9,12,PARENT_OF\n"
			+ "4,9,PARENT_OF\n"
			+ "3,4,PARENT_OF\n"
			+ "14,15,PARENT_OF\n"
			+ "13,14,PARENT_OF\n"
			+ "16,17,PARENT_OF\n"
			+ "13,16,PARENT_OF\n"
			+ "3,13,PARENT_OF\n"
			+ "3,18,PARENT_OF\n"
			+ "3,19,PARENT_OF\n"
			+ "2,3,PARENT_OF\n";
	
	
	/*
	 * class Foo {
	 *   function foo($bar,&$buz) {}
	 * }
	 */
	
	public static final String defUseMethodNodeStr = nodeHeader
			+ "2,AST_STMT_LIST,,1,,0,1,,,\n"
			+ "3,AST_CLASS,,3,,0,1,5,Foo,\n"
			+ "4,NULL,,3,,0,1,,,\n"
			+ "5,NULL,,3,,1,1,,,\n"
			+ "6,AST_TOPLEVEL,TOPLEVEL_CLASS,3,,2,1,5,\"Foo\",\n"
			+ "7,AST_STMT_LIST,,3,,0,6,,,\n"
			+ "8,AST_METHOD,MODIFIER_PUBLIC,4,,0,6,4,foo,\n"
			+ "9,AST_PARAM_LIST,,4,,0,8,,,\n"
			+ "10,AST_PARAM,,4,,0,8,,,\n"
			+ "11,NULL,,4,,0,8,,,\n"
			+ "12,string,,4,\"bar\",1,8,,,\n"
			+ "13,NULL,,4,,2,8,,,\n"
			+ "14,AST_PARAM,PARAM_REF,4,,1,8,,,\n"
			+ "15,NULL,,4,,0,8,,,\n"
			+ "16,string,,4,\"buz\",1,8,,,\n"
			+ "17,NULL,,4,,2,8,,,\n"
			+ "18,NULL,,4,,1,8,,,\n"
			+ "19,AST_STMT_LIST,,4,,2,8,,,\n"
			+ "20,NULL,,4,,3,8,,,\n";

	public static final String defUseMethodEdgeStr = edgeHeader
			+ "3,4,PARENT_OF\n"
			+ "3,5,PARENT_OF\n"
			+ "10,11,PARENT_OF\n"
			+ "10,12,PARENT_OF\n"
			+ "10,13,PARENT_OF\n"
			+ "9,10,PARENT_OF\n"
			+ "14,15,PARENT_OF\n"
			+ "14,16,PARENT_OF\n"
			+ "14,17,PARENT_OF\n"
			+ "9,14,PARENT_OF\n"
			+ "8,9,PARENT_OF\n"
			+ "8,18,PARENT_OF\n"
			+ "8,19,PARENT_OF\n"
			+ "8,20,PARENT_OF\n"
			+ "7,8,PARENT_OF\n"
			+ "6,7,PARENT_OF\n"
			+ "3,6,PARENT_OF\n"
			+ "2,3,PARENT_OF\n";

	
	/*
	 * function counttothree() {
	 *   $a = [1,2,3];
	 *   yield from $a;
	 * }
	 */
	
	public static final String defUseYieldFromNodeStr = nodeHeader
			+ "2,AST_STMT_LIST,,1,,0,1,,,\n"
			+ "3,AST_FUNC_DECL,,3,,0,1,6,counttothree,\n"
			+ "4,AST_PARAM_LIST,,3,,0,3,,,\n"
			+ "5,NULL,,3,,1,3,,,\n"
			+ "6,AST_STMT_LIST,,3,,2,3,,,\n"
			+ "7,AST_ASSIGN,,4,,0,3,,,\n"
			+ "8,AST_VAR,,4,,0,3,,,\n"
			+ "9,string,,4,\"a\",0,3,,,\n"
			+ "10,AST_ARRAY,,4,,1,3,,,\n"
			+ "11,AST_ARRAY_ELEM,,4,,0,3,,,\n"
			+ "12,integer,,4,1,0,3,,,\n"
			+ "13,NULL,,4,,1,3,,,\n"
			+ "14,AST_ARRAY_ELEM,,4,,1,3,,,\n"
			+ "15,integer,,4,2,0,3,,,\n"
			+ "16,NULL,,4,,1,3,,,\n"
			+ "17,AST_ARRAY_ELEM,,4,,2,3,,,\n"
			+ "18,integer,,4,3,0,3,,,\n"
			+ "19,NULL,,4,,1,3,,,\n"
			+ "20,AST_YIELD_FROM,,5,,1,3,,,\n"
			+ "21,AST_VAR,,5,,0,3,,,\n"
			+ "22,string,,5,\"a\",0,3,,,\n"
			+ "23,NULL,,3,,3,3,,,\n";
	
	public static final String defUseYieldFromEdgeStr = edgeHeader
			+ "3,4,PARENT_OF\n"
			+ "3,5,PARENT_OF\n"
			+ "8,9,PARENT_OF\n"
			+ "7,8,PARENT_OF\n"
			+ "11,12,PARENT_OF\n"
			+ "11,13,PARENT_OF\n"
			+ "10,11,PARENT_OF\n"
			+ "14,15,PARENT_OF\n"
			+ "14,16,PARENT_OF\n"
			+ "10,14,PARENT_OF\n"
			+ "17,18,PARENT_OF\n"
			+ "17,19,PARENT_OF\n"
			+ "10,17,PARENT_OF\n"
			+ "7,10,PARENT_OF\n"
			+ "6,7,PARENT_OF\n"
			+ "21,22,PARENT_OF\n"
			+ "20,21,PARENT_OF\n"
			+ "6,20,PARENT_OF\n"
			+ "3,6,PARENT_OF\n"
			+ "3,23,PARENT_OF\n"
			+ "2,3,PARENT_OF\n";

	
	/*
	 * function foo() {
	 *   $a = [1,2,3];
	 *   return $a;
	 * }
	 */
	
	public static final String defUseReturnNodeStr = nodeHeader
			+ "2,AST_STMT_LIST,,1,,0,1,,,\n"
			+ "3,AST_FUNC_DECL,,3,,0,1,6,foo,\n"
			+ "4,AST_PARAM_LIST,,3,,0,3,,,\n"
			+ "5,NULL,,3,,1,3,,,\n"
			+ "6,AST_STMT_LIST,,3,,2,3,,,\n"
			+ "7,AST_ASSIGN,,4,,0,3,,,\n"
			+ "8,AST_VAR,,4,,0,3,,,\n"
			+ "9,string,,4,\"a\",0,3,,,\n"
			+ "10,AST_ARRAY,,4,,1,3,,,\n"
			+ "11,AST_ARRAY_ELEM,,4,,0,3,,,\n"
			+ "12,integer,,4,1,0,3,,,\n"
			+ "13,NULL,,4,,1,3,,,\n"
			+ "14,AST_ARRAY_ELEM,,4,,1,3,,,\n"
			+ "15,integer,,4,2,0,3,,,\n"
			+ "16,NULL,,4,,1,3,,,\n"
			+ "17,AST_ARRAY_ELEM,,4,,2,3,,,\n"
			+ "18,integer,,4,3,0,3,,,\n"
			+ "19,NULL,,4,,1,3,,,\n"
			+ "20,AST_RETURN,,5,,1,3,,,\n"
			+ "21,AST_VAR,,5,,0,3,,,\n"
			+ "22,string,,5,\"a\",0,3,,,\n"
			+ "23,NULL,,3,,3,3,,,\n";

	public static final String defUseReturnEdgeStr = edgeHeader
			+ "3,4,PARENT_OF\n"
			+ "3,5,PARENT_OF\n"
			+ "8,9,PARENT_OF\n"
			+ "7,8,PARENT_OF\n"
			+ "11,12,PARENT_OF\n"
			+ "11,13,PARENT_OF\n"
			+ "10,11,PARENT_OF\n"
			+ "14,15,PARENT_OF\n"
			+ "14,16,PARENT_OF\n"
			+ "10,14,PARENT_OF\n"
			+ "17,18,PARENT_OF\n"
			+ "17,19,PARENT_OF\n"
			+ "10,17,PARENT_OF\n"
			+ "7,10,PARENT_OF\n"
			+ "6,7,PARENT_OF\n"
			+ "21,22,PARENT_OF\n"
			+ "20,21,PARENT_OF\n"
			+ "6,20,PARENT_OF\n"
			+ "3,6,PARENT_OF\n"
			+ "3,23,PARENT_OF\n"
			+ "2,3,PARENT_OF\n";


	/*
	 * echo $foo, $bar, PHP_EOL;
	 * echo $buz.$qux.PHP_EOL;
	 * echo "{$norf}{$nicknack}";
	 */

	public static final String defUseEchoNodeStr = nodeHeader
			+ "2,AST_STMT_LIST,,1,,0,1,,,\n"
			+ "3,AST_STMT_LIST,,3,,0,1,,,\n"
			+ "4,AST_ECHO,,3,,0,1,,,\n"
			+ "5,AST_VAR,,3,,0,1,,,\n"
			+ "6,string,,3,\"foo\",0,1,,,\n"
			+ "7,AST_ECHO,,3,,1,1,,,\n"
			+ "8,AST_VAR,,3,,0,1,,,\n"
			+ "9,string,,3,\"bar\",0,1,,,\n"
			+ "10,AST_ECHO,,3,,2,1,,,\n"
			+ "11,AST_CONST,,3,,0,1,,,\n"
			+ "12,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n"
			+ "13,string,,3,\"PHP_EOL\",0,1,,,\n"
			+ "14,AST_STMT_LIST,,4,,1,1,,,\n"
			+ "15,AST_ECHO,,4,,0,1,,,\n"
			+ "16,AST_BINARY_OP,BINARY_CONCAT,4,,0,1,,,\n"
			+ "17,AST_BINARY_OP,BINARY_CONCAT,4,,0,1,,,\n"
			+ "18,AST_VAR,,4,,0,1,,,\n"
			+ "19,string,,4,\"buz\",0,1,,,\n"
			+ "20,AST_VAR,,4,,1,1,,,\n"
			+ "21,string,,4,\"qux\",0,1,,,\n"
			+ "22,AST_CONST,,4,,1,1,,,\n"
			+ "23,AST_NAME,NAME_NOT_FQ,4,,0,1,,,\n"
			+ "24,string,,4,\"PHP_EOL\",0,1,,,\n"
			+ "25,AST_STMT_LIST,,5,,2,1,,,\n"
			+ "26,AST_ECHO,,5,,0,1,,,\n"
			+ "27,AST_ENCAPS_LIST,,5,,0,1,,,\n"
			+ "28,AST_VAR,,5,,0,1,,,\n"
			+ "29,string,,5,\"norf\",0,1,,,\n"
			+ "30,AST_VAR,,5,,1,1,,,\n"
			+ "31,string,,5,\"nicknack\",0,1,,,\n";

	public static final String defUseEchoEdgeStr = edgeHeader
			+ "5,6,PARENT_OF\n"
			+ "4,5,PARENT_OF\n"
			+ "3,4,PARENT_OF\n"
			+ "8,9,PARENT_OF\n"
			+ "7,8,PARENT_OF\n"
			+ "3,7,PARENT_OF\n"
			+ "12,13,PARENT_OF\n"
			+ "11,12,PARENT_OF\n"
			+ "10,11,PARENT_OF\n"
			+ "3,10,PARENT_OF\n"
			+ "2,3,PARENT_OF\n"
			+ "18,19,PARENT_OF\n"
			+ "17,18,PARENT_OF\n"
			+ "20,21,PARENT_OF\n"
			+ "17,20,PARENT_OF\n"
			+ "16,17,PARENT_OF\n"
			+ "23,24,PARENT_OF\n"
			+ "22,23,PARENT_OF\n"
			+ "16,22,PARENT_OF\n"
			+ "15,16,PARENT_OF\n"
			+ "14,15,PARENT_OF\n"
			+ "2,14,PARENT_OF\n"
			+ "28,29,PARENT_OF\n"
			+ "27,28,PARENT_OF\n"
			+ "30,31,PARENT_OF\n"
			+ "27,30,PARENT_OF\n"
			+ "26,27,PARENT_OF\n"
			+ "25,26,PARENT_OF\n"
			+ "2,25,PARENT_OF\n";

	
	/*
	 * throw new Exception($error);
	 * throw new Foo($bar,$buz);
	 */

	public static final String defUseThrowNodeStr = nodeHeader
			+ "2,AST_STMT_LIST,,1,,0,1,,,\n"
			+ "3,AST_THROW,,3,,0,1,,,\n"
			+ "4,AST_NEW,,3,,0,1,,,\n"
			+ "5,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n"
			+ "6,string,,3,\"Exception\",0,1,,,\n"
			+ "7,AST_ARG_LIST,,3,,1,1,,,\n"
			+ "8,AST_VAR,,3,,0,1,,,\n"
			+ "9,string,,3,\"error\",0,1,,,\n"
			+ "10,AST_THROW,,4,,1,1,,,\n"
			+ "11,AST_NEW,,4,,0,1,,,\n"
			+ "12,AST_NAME,NAME_NOT_FQ,4,,0,1,,,\n"
			+ "13,string,,4,\"Foo\",0,1,,,\n"
			+ "14,AST_ARG_LIST,,4,,1,1,,,\n"
			+ "15,AST_VAR,,4,,0,1,,,\n"
			+ "16,string,,4,\"bar\",0,1,,,\n"
			+ "17,AST_VAR,,4,,1,1,,,\n"
			+ "18,string,,4,\"buz\",0,1,,,\n";

	public static final String defUseThrowEdgeStr = edgeHeader
			+ "5,6,PARENT_OF\n"
			+ "4,5,PARENT_OF\n"
			+ "8,9,PARENT_OF\n"
			+ "7,8,PARENT_OF\n"
			+ "4,7,PARENT_OF\n"
			+ "3,4,PARENT_OF\n"
			+ "2,3,PARENT_OF\n"
			+ "12,13,PARENT_OF\n"
			+ "11,12,PARENT_OF\n"
			+ "15,16,PARENT_OF\n"
			+ "14,15,PARENT_OF\n"
			+ "17,18,PARENT_OF\n"
			+ "14,17,PARENT_OF\n"
			+ "11,14,PARENT_OF\n"
			+ "10,11,PARENT_OF\n"
			+ "2,10,PARENT_OF\n";

	
	/*
	 * function counttothree() {
	 *   foreach( [1,2,3] as $index => $value)
	 *     yield $index => $value;
	 * }
	 */
	
	public static final String defUseYieldNodeStr = nodeHeader
			+ "2,AST_STMT_LIST,,1,,0,1,,,\n"
			+ "3,AST_FUNC_DECL,,3,,0,1,6,counttothree,\n"
			+ "4,AST_PARAM_LIST,,3,,0,3,,,\n"
			+ "5,NULL,,3,,1,3,,,\n"
			+ "6,AST_STMT_LIST,,3,,2,3,,,\n"
			+ "7,AST_FOREACH,,4,,0,3,,,\n"
			+ "8,AST_ARRAY,,4,,0,3,,,\n"
			+ "9,AST_ARRAY_ELEM,,4,,0,3,,,\n"
			+ "10,integer,,4,1,0,3,,,\n"
			+ "11,NULL,,4,,1,3,,,\n"
			+ "12,AST_ARRAY_ELEM,,4,,1,3,,,\n"
			+ "13,integer,,4,2,0,3,,,\n"
			+ "14,NULL,,4,,1,3,,,\n"
			+ "15,AST_ARRAY_ELEM,,4,,2,3,,,\n"
			+ "16,integer,,4,3,0,3,,,\n"
			+ "17,NULL,,4,,1,3,,,\n"
			+ "18,AST_VAR,,4,,1,3,,,\n"
			+ "19,string,,4,\"value\",0,3,,,\n"
			+ "20,AST_VAR,,4,,2,3,,,\n"
			+ "21,string,,4,\"index\",0,3,,,\n"
			+ "22,AST_YIELD,,5,,3,3,,,\n"
			+ "23,AST_VAR,,5,,0,3,,,\n"
			+ "24,string,,5,\"value\",0,3,,,\n"
			+ "25,AST_VAR,,5,,1,3,,,\n"
			+ "26,string,,5,\"index\",0,3,,,\n"
			+ "27,NULL,,3,,3,3,,,\n";

	public static final String defUseYieldEdgeStr = edgeHeader
			+ "3,4,PARENT_OF\n"
			+ "3,5,PARENT_OF\n"
			+ "9,10,PARENT_OF\n"
			+ "9,11,PARENT_OF\n"
			+ "8,9,PARENT_OF\n"
			+ "12,13,PARENT_OF\n"
			+ "12,14,PARENT_OF\n"
			+ "8,12,PARENT_OF\n"
			+ "15,16,PARENT_OF\n"
			+ "15,17,PARENT_OF\n"
			+ "8,15,PARENT_OF\n"
			+ "7,8,PARENT_OF\n"
			+ "18,19,PARENT_OF\n"
			+ "7,18,PARENT_OF\n"
			+ "20,21,PARENT_OF\n"
			+ "7,20,PARENT_OF\n"
			+ "23,24,PARENT_OF\n"
			+ "22,23,PARENT_OF\n"
			+ "25,26,PARENT_OF\n"
			+ "22,25,PARENT_OF\n"
			+ "7,22,PARENT_OF\n"
			+ "6,7,PARENT_OF\n"
			+ "3,6,PARENT_OF\n"
			+ "3,27,PARENT_OF\n"
			+ "2,3,PARENT_OF\n";

	
	/*
	 * function foo() {
	 *   static $foo = $bar, $buz = $qux->norf;
	 * }
	 */

	public static final String defUseStaticVariableNodeStr = nodeHeader
			+ "2,AST_STMT_LIST,,1,,0,1,,,\n"
			+ "3,AST_FUNC_DECL,,3,,0,1,5,foo,\n"
			+ "4,AST_PARAM_LIST,,3,,0,3,,,\n"
			+ "5,NULL,,3,,1,3,,,\n"
			+ "6,AST_STMT_LIST,,3,,2,3,,,\n"
			+ "7,AST_STMT_LIST,,4,,0,3,,,\n"
			+ "8,AST_STATIC,,4,,0,3,,,\n"
			+ "9,string,,4,\"foo\",0,3,,,\n"
			+ "10,AST_VAR,,4,,1,3,,,\n"
			+ "11,string,,4,\"bar\",0,3,,,\n"
			+ "12,AST_STATIC,,4,,1,3,,,\n"
			+ "13,string,,4,\"buz\",0,3,,,\n"
			+ "14,AST_PROP,,4,,1,3,,,\n"
			+ "15,AST_VAR,,4,,0,3,,,\n"
			+ "16,string,,4,\"qux\",0,3,,,\n"
			+ "17,string,,4,\"norf\",1,3,,,\n"
			+ "18,NULL,,3,,3,3,,,\n";

	public static final String defUseStaticVariableEdgeStr = edgeHeader
			+ "3,4,PARENT_OF\n"
			+ "3,5,PARENT_OF\n"
			+ "8,9,PARENT_OF\n"
			+ "10,11,PARENT_OF\n"
			+ "8,10,PARENT_OF\n"
			+ "7,8,PARENT_OF\n"
			+ "12,13,PARENT_OF\n"
			+ "15,16,PARENT_OF\n"
			+ "14,15,PARENT_OF\n"
			+ "14,17,PARENT_OF\n"
			+ "12,14,PARENT_OF\n"
			+ "7,12,PARENT_OF\n"
			+ "6,7,PARENT_OF\n"
			+ "3,6,PARENT_OF\n"
			+ "3,18,PARENT_OF\n"
			+ "2,3,PARENT_OF\n";

	
	/*
	 * class Foo {
	 *   public $foo = $bar, $buz = $qux->norf;
	 * }
	 */
	
	public static final String defUsePropertyElementNodeStr = nodeHeader
			+ "2,AST_STMT_LIST,,1,,0,1,,,\n"
			+ "3,AST_CLASS,,3,,0,1,5,Foo,\n"
			+ "4,NULL,,3,,0,1,,,\n"
			+ "5,NULL,,3,,1,1,,,\n"
			+ "6,AST_TOPLEVEL,TOPLEVEL_CLASS,3,,2,1,5,\"Foo\",\n"
			+ "7,AST_STMT_LIST,,3,,0,6,,,\n"
			+ "8,AST_PROP_DECL,MODIFIER_PUBLIC,4,,0,6,,,\n"
			+ "9,AST_PROP_ELEM,,4,,0,6,,,\n"
			+ "10,string,,4,\"foo\",0,6,,,\n"
			+ "11,AST_VAR,,4,,1,6,,,\n"
			+ "12,string,,4,\"bar\",0,6,,,\n"
			+ "13,AST_PROP_ELEM,,4,,1,6,,,\n"
			+ "14,string,,4,\"buz\",0,6,,,\n"
			+ "15,AST_PROP,,4,,1,6,,,\n"
			+ "16,AST_VAR,,4,,0,6,,,\n"
			+ "17,string,,4,\"qux\",0,6,,,\n"
			+ "18,string,,4,\"norf\",1,6,,,\n";

	public static final String defUsePropertyElementEdgeStr = edgeHeader
			+ "3,4,PARENT_OF\n"
			+ "3,5,PARENT_OF\n"
			+ "9,10,PARENT_OF\n"
			+ "11,12,PARENT_OF\n"
			+ "9,11,PARENT_OF\n"
			+ "8,9,PARENT_OF\n"
			+ "13,14,PARENT_OF\n"
			+ "16,17,PARENT_OF\n"
			+ "15,16,PARENT_OF\n"
			+ "15,18,PARENT_OF\n"
			+ "13,15,PARENT_OF\n"
			+ "8,13,PARENT_OF\n"
			+ "7,8,PARENT_OF\n"
			+ "6,7,PARENT_OF\n"
			+ "3,6,PARENT_OF\n"
			+ "2,3,PARENT_OF\n";

	
	/*
	 * const FOO = $bar, BUZ = $qux->norf;
	 */

	public static final String defUseConstantElementNodeStr = nodeHeader
			+ "2,AST_STMT_LIST,,1,,0,1,,,\n"
			+ "3,AST_CONST_DECL,,3,,0,1,,,\n"
			+ "4,AST_CONST_ELEM,,3,,0,1,,,\n"
			+ "5,string,,3,\"FOO\",0,1,,,\n"
			+ "6,AST_VAR,,3,,1,1,,,\n"
			+ "7,string,,3,\"bar\",0,1,,,\n"
			+ "8,AST_CONST_ELEM,,3,,1,1,,,\n"
			+ "9,string,,3,\"BUZ\",0,1,,,\n"
			+ "10,AST_PROP,,3,,1,1,,,\n"
			+ "11,AST_VAR,,3,,0,1,,,\n"
			+ "12,string,,3,\"qux\",0,1,,,\n"
			+ "13,string,,3,\"norf\",1,1,,,\n";

	public static final String defUseConstantElementEdgeStr = edgeHeader
			+ "4,5,PARENT_OF\n"
			+ "6,7,PARENT_OF\n"
			+ "4,6,PARENT_OF\n"
			+ "3,4,PARENT_OF\n"
			+ "8,9,PARENT_OF\n"
			+ "11,12,PARENT_OF\n"
			+ "10,11,PARENT_OF\n"
			+ "10,13,PARENT_OF\n"
			+ "8,10,PARENT_OF\n"
			+ "3,8,PARENT_OF\n"
			+ "2,3,PARENT_OF\n";

	
	/*
	 * $foo[$bar];
	 * $buz[qux()];
	 * norf()[$nicknack];
	 */

	public static final String defUseArrayIndexingNodeStr = nodeHeader
			+ "2,AST_STMT_LIST,,1,,0,1,,,\n"
			+ "3,AST_DIM,,3,,0,1,,,\n"
			+ "4,AST_VAR,,3,,0,1,,,\n"
			+ "5,string,,3,\"foo\",0,1,,,\n"
			+ "6,AST_VAR,,3,,1,1,,,\n"
			+ "7,string,,3,\"bar\",0,1,,,\n"
			+ "8,AST_DIM,,4,,1,1,,,\n"
			+ "9,AST_VAR,,4,,0,1,,,\n"
			+ "10,string,,4,\"buz\",0,1,,,\n"
			+ "11,AST_CALL,,4,,1,1,,,\n"
			+ "12,AST_NAME,NAME_NOT_FQ,4,,0,1,,,\n"
			+ "13,string,,4,\"qux\",0,1,,,\n"
			+ "14,AST_ARG_LIST,,4,,1,1,,,\n"
			+ "15,AST_DIM,,5,,2,1,,,\n"
			+ "16,AST_CALL,,5,,0,1,,,\n"
			+ "17,AST_NAME,NAME_NOT_FQ,5,,0,1,,,\n"
			+ "18,string,,5,\"norf\",0,1,,,\n"
			+ "19,AST_ARG_LIST,,5,,1,1,,,\n"
			+ "20,AST_VAR,,5,,1,1,,,\n"
			+ "21,string,,5,\"nicknack\",0,1,,,\n";

	public static final String defUseArrayIndexingEdgeStr = edgeHeader
			+ "4,5,PARENT_OF\n"
			+ "3,4,PARENT_OF\n"
			+ "6,7,PARENT_OF\n"
			+ "3,6,PARENT_OF\n"
			+ "2,3,PARENT_OF\n"
			+ "9,10,PARENT_OF\n"
			+ "8,9,PARENT_OF\n"
			+ "12,13,PARENT_OF\n"
			+ "11,12,PARENT_OF\n"
			+ "11,14,PARENT_OF\n"
			+ "8,11,PARENT_OF\n"
			+ "2,8,PARENT_OF\n"
			+ "17,18,PARENT_OF\n"
			+ "16,17,PARENT_OF\n"
			+ "16,19,PARENT_OF\n"
			+ "15,16,PARENT_OF\n"
			+ "20,21,PARENT_OF\n"
			+ "15,20,PARENT_OF\n"
			+ "2,15,PARENT_OF\n";


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
	
	public static final String defUseAssignUsingArrayNodeStr = nodeHeader
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
	
	public static final String defUseAssignUsingArrayEdgeStr = edgeHeader
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
	 * $foo[$bar] = $buz;
	 * $qux = $norf[$nicknack->slurp];
	 */

	public static final String defUseAssignUsingArrayIndexingNodeStr = nodeHeader
			+ "2,AST_STMT_LIST,,1,,0,1,,,\n"
			+ "3,AST_ASSIGN,,3,,0,1,,,\n"
			+ "4,AST_DIM,,3,,0,1,,,\n"
			+ "5,AST_VAR,,3,,0,1,,,\n"
			+ "6,string,,3,\"foo\",0,1,,,\n"
			+ "7,AST_VAR,,3,,1,1,,,\n"
			+ "8,string,,3,\"bar\",0,1,,,\n"
			+ "9,AST_VAR,,3,,1,1,,,\n"
			+ "10,string,,3,\"buz\",0,1,,,\n"
			+ "11,AST_ASSIGN,,4,,1,1,,,\n"
			+ "12,AST_VAR,,4,,0,1,,,\n"
			+ "13,string,,4,\"qux\",0,1,,,\n"
			+ "14,AST_DIM,,4,,1,1,,,\n"
			+ "15,AST_VAR,,4,,0,1,,,\n"
			+ "16,string,,4,\"norf\",0,1,,,\n"
			+ "17,AST_PROP,,4,,1,1,,,\n"
			+ "18,AST_VAR,,4,,0,1,,,\n"
			+ "19,string,,4,\"nicknack\",0,1,,,\n"
			+ "20,string,,4,\"slurp\",1,1,,,\n";

	public static final String defUseAssignUsingArrayIndexingEdgeStr = edgeHeader
			+ "5,6,PARENT_OF\n"
			+ "4,5,PARENT_OF\n"
			+ "7,8,PARENT_OF\n"
			+ "4,7,PARENT_OF\n"
			+ "3,4,PARENT_OF\n"
			+ "9,10,PARENT_OF\n"
			+ "3,9,PARENT_OF\n"
			+ "2,3,PARENT_OF\n"
			+ "12,13,PARENT_OF\n"
			+ "11,12,PARENT_OF\n"
			+ "15,16,PARENT_OF\n"
			+ "14,15,PARENT_OF\n"
			+ "18,19,PARENT_OF\n"
			+ "17,18,PARENT_OF\n"
			+ "17,20,PARENT_OF\n"
			+ "14,17,PARENT_OF\n"
			+ "11,14,PARENT_OF\n"
			+ "2,11,PARENT_OF\n";
			
	
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

	
	/*
	 * $foo =& $bar;
	 */

	public static final String defUseAssignByRefNodeStr = nodeHeader
			+ "2,AST_STMT_LIST,,1,,0,1,,,\n"
			+ "3,AST_ASSIGN_REF,,3,,0,1,,,\n"
			+ "4,AST_VAR,,3,,0,1,,,\n"
			+ "5,string,,3,\"foo\",0,1,,,\n"
			+ "6,AST_VAR,,3,,1,1,,,\n"
			+ "7,string,,3,\"bar\",0,1,,,\n";

	public static final String defUseAssignByRefEdgeStr = edgeHeader
			+ "4,5,PARENT_OF\n"
			+ "3,4,PARENT_OF\n"
			+ "6,7,PARENT_OF\n"
			+ "3,6,PARENT_OF\n"
			+ "2,3,PARENT_OF\n";
}
