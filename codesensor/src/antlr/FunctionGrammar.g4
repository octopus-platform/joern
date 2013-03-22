grammar FunctionGrammar;
import CodeSensorLex, Common, Expressions, FineSimpleDecl;

@header{
	package antlr;
}

statements: (pre_opener
            | pre_closer
            | pre_else {preProcSkipToEnd(); }
            | statement)*;

statement: opening_curly
         | closing_curly
         | block_starter
         | jump_statement
         | simple_decl
         | label
         | expr_statement
         | statement_water
        ;

statement_water: .;

pre_opener: PRE_IF;
pre_else: PRE_ELSE;
pre_closer: PRE_ENDIF;
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


iteration_statement: for_statement
                   | do_statement
		   | while_statement
;

for_statement: 'for' '(' for_init_statement condition ';'  expr? ')';
while_statement: 'while' '(' condition ')';
do_statement: 'do'; //  statement 'while' '(' expr ')';

// Don't know why, but: introducing this unused rule results
// in a performance boost.

do_statement1: 'do' statement 'while' '(' expr ')';

for_init_statement : simple_decl
                   | expr? ';';

jump_statement: ( break_or_continue | return_statement | goto_statement ) ';';
break_or_continue: ('break' | 'continue');
return_statement: 'return' expr?;
goto_statement: 'goto' identifier;

try_block: TRY; // opening_curly;

//// Workaround
// if we use 'type_name' here, we get a crash.
// Seems like a bug in antlr.
catch_block: CATCH '(' param_type2 ')';
////
param_type2: param_decl_specifiers2 param_type_id;
param_decl_specifiers2 : (AUTO | REGISTER)? type_name2;
type_name2 : (CV_QUALIFIER* (class_key | UNSIGNED | SIGNED)?
            base_type  ('<' template_param_list '>')? ('::' base_type ('<' template_param_list '>' )?)*)
          | (UNSIGNED | SIGNED);
/////


label: (('case'? (identifier | number) ) | access_specifier) ':' ;

expr_statement: expr ';';

condition: expr;
