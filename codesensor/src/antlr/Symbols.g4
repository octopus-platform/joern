grammar Symbols;
import CodeSensorLex, SimpleDecl, Common, Expressions;

@header{
	package antlr;
}


coarse_content: (simple_decl | function_call | field | water)*;

function_call: field function_call_tail;