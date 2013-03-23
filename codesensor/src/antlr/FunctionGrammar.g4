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
         | water
        ;

pre_opener: PRE_IF;
pre_else: PRE_ELSE;
pre_closer: PRE_ENDIF;
opening_curly: '{';
closing_curly: '}';
                
block_starter: selection_or_iteration;

selection_or_iteration: TRY                      #Try_statement
                      | CATCH '(' param_type ')' #Catch_statement
                      | IF '(' condition ')' #If_statement
                      | ELSE                 #Else_statement
                      | SWITCH '(' condition ')' #Switch_statement
                      | FOR '(' for_init_statement condition ';'  expr? ')' #For_statement
                      | DO #Do_statement
                      | WHILE '(' condition ')' #While_statement
;

// Don't know why, but: introducing this unused rule results
// in a performance boost.

do_statement1: DO statement WHILE '(' expr ')';

for_init_statement : simple_decl
                   | expr? ';';

jump_statement: ( break_or_continue | return_statement | goto_statement ) ';';
break_or_continue: BREAK | CONTINUE;
return_statement: RETURN expr?;
goto_statement: GOTO identifier;

label: ((CASE? (identifier | number) ) | access_specifier) ':' ;

expr_statement: expr ';';

condition: expr;
