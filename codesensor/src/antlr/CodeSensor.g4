grammar CodeSensor;

import Common;

/*
    Copyright (C) 2013 Fabian 'fabs' Yamaguchi <fabs@phenoelit.de>
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

@header{
	package antlr;
    import java.util.Stack;
}

code : part*;

part : declaration
    | water
    ;

declaration : function_def
            | simple_decl
            | using_directive;


function_def : template_decl_start? return_type? function_name
            function_param_list ctor_list? compound_statement;

return_type : (function_decl_specifiers* type_name) ptr_operator*;

function_param_list : '(' parameter_decl_clause? ')' cv_qualifier* exception_specification?;

parameter_decl_clause: (parameter_decl (',' parameter_decl)*) (',' '...')?
    | 'void';
parameter_decl : param_decl_specifiers parameter_id;
parameter_id: ptrs? ('(' parameter_id ')' | parameter_name) type_suffix?;

compound_statement: '{' { skipToEndOfObject(); };

ctor_list: ':'  ctor_initializer (',' ctor_initializer)*;
ctor_initializer:  initializer_id ctor_expr;
initializer_id : '::'? identifier;
ctor_expr:  '(' expr? ')';

function_name: '(' function_name ')' | identifier | operator_function_id;

exception_specification : 'throw' '(' type_id_list ')';
type_id_list: no_brackets* ('(' type_id_list ')' no_brackets*)*;

using_directive: 'using' 'namespace' identifier ';';

