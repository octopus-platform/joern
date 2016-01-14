package tests.languages.php.samples;

public class CSVASTControlFlowSamples extends CSVASTSamples {

	/*
	<?php

	if($foo){
	    return;
	}
	bar();

	?> 	*/
	public static final String retNodeStr = CSVASTControlFlowSamples.nodeHeader
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

	public static final String retEdgeStr = CSVASTControlFlowSamples.edgeHeader
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
	public static final String gotoNodeStr = CSVASTControlFlowSamples.nodeHeader
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

	public static final String gotoEdgeStr = CSVASTControlFlowSamples.edgeHeader
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
	public static final String continueNodeStr = CSVASTControlFlowSamples.nodeHeader
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

	public static final String continueEdgeStr = CSVASTControlFlowSamples.edgeHeader
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
	public static final String breakNodeStr = CSVASTControlFlowSamples.nodeHeader
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

	public static final String breakEdgeStr = CSVASTControlFlowSamples.edgeHeader
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
	public static final String tryNodeStr = CSVASTControlFlowSamples.nodeHeader
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

	public static final String tryEdgeStr = CSVASTControlFlowSamples.edgeHeader
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
