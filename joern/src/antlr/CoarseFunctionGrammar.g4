grammar CoarseFunctionGrammar;

import CodeSensorLex, Common, Expressions, FineSimpleDecl;

@header{
	package antlr;
}


coarse_content: coarse_content_elem* EOF;

coarse_content_elem: (simple_decl | unary_expression | water);
