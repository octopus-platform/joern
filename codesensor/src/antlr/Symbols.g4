grammar Symbols;

import CodeSensorLex, Common, Expressions, SimpleDecl;

@header{
	package antlr;
}


coarse_content: coarse_elem* EOF;

coarse_elem: simple_decl
            |  unary_expression
            | water
;

