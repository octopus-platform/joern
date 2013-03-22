grammar FunctionGrammar;
import CodeSensorLex, Common, Expressions, FineSimpleDecl;

@header{
	package antlr;
}

statements: statement* EOF;

statement: PRE_ELSE {preProcSkipToEnd(); }
         | opening_curly
         | closing_curly
         | block_starter
         | jump_statement
         | simple_decl
         | label
         | expr_statement
         | water
        ;

opening_curly: '{';
closing_curly: '}';

block_starter: selection_statement
             | iteration_statement
             | try_block
             | catch_block
;


selection_statement: if_statement
                   | else_statement
                   | switch_statement
;

if_statement: IF '(' condition ')';
else_statement: ELSE;
switch_statement: SWITCH '(' condition ')';

/*
selection_statement: IF '(' condition ')' #ifStatement
                   | SWITCH '(' condition ')' #switchStatement
                   | ELSE #elseStatement
;
*/

iteration_statement: for_statement
                   | do_statement
                   | while_statement
;

for_statement: FOR '(' for_init_statement condition ';'  expr? ')';
while_statement: WHILE '(' condition ')';
do_statement: DO;

// Don't know why, but: introducing this unused rule results
// in a performance boost.

do_statement1: 'do' statement 'while' '(' expr ')';

for_init_statement : simple_decl
                   | expr? ';';

jump_statement: ( break_or_continue | return_statement | goto_statement ) ';';
break_or_continue: ('break' | 'continue');
return_statement: 'return' expr?;
goto_statement: 'goto' identifier;

try_block: TRY;
catch_block: CATCH '(' param_type ')';

//// Workaround
// if we use 'type_name' here, we get a crash.
// Seems like a bug in antlr.
////
// param_type2: param_decl_specifiers2 param_type_id;
// param_decl_specifiers2 : (AUTO | REGISTER)? type_name2;
// type_name2 : (CV_QUALIFIER* (class_key | UNSIGNED | SIGNED)?
//            base_type  ('<' template_param_list '>')? ('::' base_type ('<' template_param_list '>' )?)*)
//          | (UNSIGNED | SIGNED);
/////

label: (('case'? (identifier | number) ) | access_specifier) ':' ;

expr_statement: expr ';';
condition: expr;
