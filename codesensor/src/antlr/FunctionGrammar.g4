grammar FunctionGrammar;

import Common;

@header{
	package antlr;
}

@parser::members
{
            public boolean preProcSkipToEnd()
            {
                Stack<Object> CurlyStack = new Stack<Object>();
                Object o = new Object();
                int t = _input.LA(1);

                while(t != EOF && !(CurlyStack.empty() && t == PRE_ENDIF)){
                                        
                    if(t == PRE_IF)
                        CurlyStack.push(o);
                    else if(t == PRE_ENDIF)
                        CurlyStack.pop();
                    
                    consume();
                    t = _input.LA(1);
                }
                if(t != EOF)
                    consume();
                return true;
            }
}

statements: (pre_opener
            | pre_closer
            | pre_else {preProcSkipToEnd(); }
            | statement)*;

statement: opening_curly
         | closing_curly
         | non_expr_statement
         | expr_statement
         | statement_water
        ;
// catch [ParseCancellationException re] {
//   consume();
// }


pre_opener: PRE_IF;
pre_else: PRE_ELSE;
pre_closer: PRE_ENDIF;

opening_curly: '{';
closing_curly: '}';


non_expr_statement: block_starter
                  | non_block_starter
;

block_starter: selection_statement
             | iteration_statement
             | try_block
             | catch_block
;

non_block_starter: jump_statement
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

try_block: TRY opening_curly;
catch_block: CATCH '('param_decl_specifiers parameter_name? ')' opening_curly;

label: (('case'? (identifier | number) ) | access_specifier) ':' ;

expr_statement: expr ';';

statement_water: .;
condition: expr;
