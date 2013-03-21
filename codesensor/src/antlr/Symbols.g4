grammar Symbols;

import Expressions;

symbols: symbol*;

symbol:  simple_decl
	 | postfix_expression
	 ;

symbol_water: .;
