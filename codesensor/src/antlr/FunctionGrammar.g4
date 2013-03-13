grammar FunctionGrammar;

import Common;

@header{
	package antlr;
}

// we are not handling pre-processor conditions yet

statements: statement*;

statement: block_opener
         | block_closer
         | pre_opener
         | pre_closer
         | pre_else 
         | non_expr_statement
         | expr_statement
         | statement_water
;

pre_opener: PRE_IF;
pre_else: PRE_ELSE;
pre_closer: PRE_ENDIF;

block_opener: '{';
block_closer: '}';


non_expr_statement: selection_statement
                  | iteration_statement
                  | try_block
                  | catch_block
                  | jump_statement
                  | simple_decl
                  | label
;

selection_statement: if_statement
                   | else_statement
                   | switch_statement
;

if_statement: IF '(' condition ')';
else_statement: ELSE;
switch_statement: SWITCH '(' condition ')';


iteration_statement: for_statement
                   | while_statement
                   | do_statement
;

for_statement: 'for' '(' for_init_statement condition ';'  expr? ')';
while_statement: 'while' '(' condition ')';
do_statement: 'do' statement 'while' '(' expr ')';

for_init_statement : simple_decl | expr? ';';

jump_statement: ( break_or_continue | return_statement | goto_statement ) ';';
break_or_continue: ('break' | 'continue');
return_statement: 'return' expr?;
goto_statement: 'goto' identifier;

try_block: TRY block_opener;
catch_block: CATCH '('param_decl_specifiers parameter_name? ')' block_opener;

label: (('case'? (identifier | number) ) | access_specifier) ':' ;

expr_statement: expr ';';

statement_water: .;
condition: expr;
