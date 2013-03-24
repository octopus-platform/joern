grammar CoarseFunctionGrammar;

import CodeSensorLex, Common, Expressions, FineSimpleDecl;

@header{
	package antlr;
}


coarse_content: (simple_decl | unary_expression | water)* EOF;


