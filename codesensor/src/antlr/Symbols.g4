grammar Symbols;

import CodeSensorLex, Common, Expressions, SimpleDecl;

@header{
	package antlr;
}


coarse_content: coarse_elem* EOF;

coarse_elem: unary_expression
            | simple_decl
            | water
;

