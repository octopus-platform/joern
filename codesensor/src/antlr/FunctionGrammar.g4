grammar FunctionGrammar;
import Expressions;
@header{
	package antlr;
}

statements: statement*;

statement: compound_statement
         | non_compound_statement
;

compound_statement: '{' statement* '}';

non_compound_statement: non_expr_statement
        | expr_statement
        | statement_water
;

non_expr_statement: selection_statement
                  | iteration_statement
                  | jump_statement
                  | try_block
                  | catch_block
                  // | simple_decl
                  | label
;

selection_statement: if_statement
                   | else_statement
                   | switch_statement
;

if_statement: IF '(' condition ')'  statement;
else_statement: ELSE statement;
switch_statement: SWITCH '(' condition ')' statement;


iteration_statement: for_statement
                   | while_statement
                   | do_statement
;

for_statement: 'for' '(' for_init_statement condition ';'  expr? ')' statement;
while_statement: 'while' '(' condition ')' statement;
do_statement: 'do' statement 'while' '(' expr ')';

for_init_statement : simple_decl | expr? ';';

jump_statement: ( break_or_continue | return_statement | goto_statement ) ';';
break_or_continue: ('break' | 'continue');
return_statement: 'return' expr?;
goto_statement: 'goto' identifier;

try_block: TRY compound_statement;
catch_block: CATCH '('param_decl_specifiers parameter_name? ')' compound_statement;

label: (('case'? (identifier | number) ) | access_specifier) ':' ;

expr_statement: {!(_input.LT(1).getText().equals("{"))}? expr ';';

statement_water: identifier | ~(ALPHA_NUMERIC | '::' | '{' | '}');

condition: expr;
