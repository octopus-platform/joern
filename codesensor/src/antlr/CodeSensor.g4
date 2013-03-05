grammar CodeSensor;
import CodeSensorLex;

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
}

code : part*;

part : declaration
     | water
     ;

declaration : simple_decl
            | function_def
            | using_directive;


simple_decl : 'typedef'? template_decl_start? var_decl ';' ;

var_decl : type_name init_declarator_list   #declByType
         | class_def init_declarator_list?  #declByClass
         ;

init_declarator_list: init_declarator (',' init_declarator)*;

// this rule is buggy: we can't match int (foo); or int (*foo)(bar *);
// let's get it running as-is first and then fix bugs.

init_declarator : (ptrs? identifier type_suffix?) (('(' expr? ')') | ('=' assign_expr))?;

class_def: class_key class_name? base_classes? '{' class_content '}';
class_name: identifier;
base_classes: ':' base_class (',' base_class)*;
base_class: 'virtual'? access_specifier? identifier;

class_content: ( simple_decl
                | function_def
                | label
                | '{' class_content '}'
                | no_curlies)*
                ;

label: (('case'? (identifier | number) ) | access_specifier) ':' ;

function_def : template_decl_start? return_type? function_name
            function_param_list ctor_list? compound_statement;

return_type : (function_decl_specifiers* type_name) function_decl_specifiers* ptr_operator*;
type_name : (cv_qualifier* class_key? ('unsigned' | 'signed')?
        ALPHA_NUMERIC ('<' template_param_list '>')? ('::' ALPHA_NUMERIC ('<' template_param_list '>' )?)*)
    | ('unsigned' | 'signed');


template_decl_start : 'template' '<' template_param_list '>';

// this is new
assign_expr: no_comma_or_semicolon+;

// this is just water
template_param_list : template_param_list_elem*;
template_param_list_elem :  ('<' template_param_list '>')
    | ('(' template_param_list ')')
    | no_angle_brackets_or_brackets
;

function_param_list : '(' parameter_decl_clause? ')' cv_qualifier* exception_specification?;

parameter_decl_clause: parameter_decl (',' parameter_decl)*;
parameter_decl : param_decl_specifiers parameter_id;

parameter_id: ptrs? '(' parameter_id ')' type_suffix?
    | ptrs? parameter_name type_suffix?;

ptrs: ptr_operator+;

param_decl_specifiers : ('auto' | 'register')? type_name;
type_suffix : ('[' constant_expr ']') | param_type_list;

param_type_list: '(' (param_type (',' param_type)*)? ')';
param_type: param_decl_specifiers ptrs? parameter_name? type_suffix?;

// this one is new
constant_expr: no_squares* ('[' constant_expr ']' no_squares*)*;
expr: no_brackets* ('(' expr ')' no_brackets*)*;
compound_statement: '{' no_curlies* (compound_statement no_curlies*)* '}';


parameter_name: x=parameter_name_start s=type_suffix?;
parameter_name_start: ('(' parameter_name ')' | identifier);

ctor_list: ':'  ctor_initializer (',' ctor_initializer)*;
ctor_initializer:  initializer_id ctor_expr;
initializer_id : '::'? identifier;
ctor_expr:  '(' expr? ')';

function_name: '(' function_name ')' | identifier | operator_function_id;

exception_specification : 'throw' '(' type_id_list ')';
type_id_list: no_brackets* ('(' type_id_list ')' no_brackets*)*;

using_directive: 'using' 'namespace' identifier ';';

unary_operator
	: '&'
	| '*'
	| '+'
	| '-'
	| '~'
	| '!'
	;

constant
    :   HEX_LITERAL
    |   OCTAL_LITERAL
    |   DECIMAL_LITERAL
	|	STRING
    |   FLOATING_POINT_LITERAL
    ;

// water

no_brackets: ~('(' | ')');
no_brackets_curlies_or_squares: ~('(' | ')' | '{' | '}' | '[' | ']');
no_brackets_or_semicolon: ~('(' | ')' | ';');
no_angle_brackets_or_brackets : ~('<' | '>' | '(' | ')');
no_curlies: ~('{' | '}');
no_squares: ~('[' | ']');
no_squares_or_semicolon: ~('[' | ']' | ';');
no_comma_or_semicolon: ~(',' | ';');

// keywords & operators

cv_qualifier :  'const' | 'volatile';
function_decl_specifiers: ('inline' | 'virtual' | 'explicit' | 'friend' | 'static');
class_key: ('struct' | 'class' | 'union' | 'enum');
ptr_operator: ('*' | '&');

access_specifier: ('public' | 'private' | 'protected');
operator_function_id: 'operator' operator;

operator: (('new' | 'delete' ) ('[' ']')?)
  | '+' | '-' | '*' | '/' | '%' |'^' | '&' | '|' | '~'
  | '!' | '=' | '<' | '>' | '+=' | '-=' | '*='
  | '/=' | '%=' | '^=' | '&=' | '|=' | '>>'
  |'<<'| '>>=' | '<<=' | '==' | '!='
  | '<=' | '>=' | '&&' | '||' | '++' | '--'
  | ',' | '->*' | '->' | '(' ')' | '[' ']'
  ;

assignment_operator: '=' | '*=' | '/=' | '%=' | '+=' | '-=' | '<<=' | '>>=' | '&=' | '^=' | '|='; 
identifier : ALPHA_NUMERIC ('::' ALPHA_NUMERIC)*;
number: HEX_LITERAL | DECIMAL_LITERAL | OCTAL_LITERAL;
water : ~OTHER;
