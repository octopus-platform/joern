grammar Common;

import Expressions;

@header{
  import java.util.Stack;
}


@parser::members
{
            public boolean skipToEndOfObject()
            {
                Stack<Object> CurlyStack = new Stack<Object>();
                Object o = new Object();
                int t = _input.LA(1);

                while(t != EOF && !(CurlyStack.empty() && t == CLOSING_CURLY)){
                    
                    if(t == PRE_ELSE){
                        Stack<Object> ifdefStack = new Stack<Object>();
                        consume();
                        t = _input.LA(1);
                        
                        while(t != EOF && !(ifdefStack.empty() && (t == PRE_ENDIF))){
                            if(t == PRE_IF)
                                ifdefStack.push(o);
                            else if(t == PRE_ENDIF)
                                ifdefStack.pop();
                            consume();
                            t = _input.LA(1);
                        }
                    }
                    
                    if(t == OPENING_CURLY)
                        CurlyStack.push(o);
                    else if(t == CLOSING_CURLY)
                        CurlyStack.pop();
                    
                    consume();
                    t = _input.LA(1);
                }
                if(t != EOF)
                    consume();
                return true;
            }


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

simple_decl : TYPEDEF? template_decl_start? var_decl;

var_decl : type_name init_declarator_list #declByType
         | class_def init_declarator_list? #declByClass
         ;

init_declarator_list: init_declarator (',' init_declarator)* ';';

// this rule is buggy: we can't match int (foo); or int (*foo)(bar *);
// let's get it running as-is first and then fix bugs.

init_declarator : (ptrs? identifier type_suffix?) (('(' expr? ')') | ('=' assign_expr_w_))?;

// this is new
assign_expr_w_: assign_water*
        (('{' assign_expr_w__l2 '}' | '(' assign_expr_w__l2 ')' | '[' assign_expr_w__l2 ']')
             assign_water*)*;

assign_expr_w__l2: assign_water_l2* (('{' assign_expr_w__l2 '}' | '(' assign_expr_w__l2 ')' | '[' assign_expr_w__l2 ']')
             assign_water_l2*)*;


/*
initializer: assign_expr
           | '{' initializer_list '}'
;
initializer_list: initializer (',' initializer)*;
*/

class_def: class_key class_name? base_classes? OPENING_CURLY {skipToEndOfObject(); } ;
class_name: identifier;
base_classes: ':' base_class (',' base_class)*;
base_class: VIRTUAL? access_specifier? identifier;

type_name : (CV_QUALIFIER* (class_key | UNSIGNED | SIGNED)?
            base_type  ('<' template_param_list '>')? ('::' base_type ('<' template_param_list '>' )?)*)
          | (UNSIGNED | SIGNED);

type_suffix : ('[' constant_expr_w_ ']') | param_type_list;
base_type: (ALPHA_NUMERIC | VOID | LONG | LONG LONG);

// this one is new
constant_expr_w_: no_squares* ('[' constant_expr_w_ ']' no_squares*)*;

// Parameters

param_decl_specifiers : (AUTO | REGISTER)? type_name;
parameter_name: identifier | access_specifier;
param_type_list: '(' VOID ')'
               | '(' (param_type (',' param_type)*)? ')';

param_type: param_decl_specifiers param_type_id;
param_type_id: ptrs? ('(' param_type_id ')' | parameter_name?) type_suffix?;

identifier : ALPHA_NUMERIC ('::' ALPHA_NUMERIC)*;
number: HEX_LITERAL | DECIMAL_LITERAL | OCTAL_LITERAL;

ptrs: ptr_operator+;

unary_operator : '&' | '*' | '+'| '-' | '~' | '!';
relational_operator: ('<'|'>'|'<='|'>=');

constant
    :   HEX_LITERAL
    |   OCTAL_LITERAL
    |   DECIMAL_LITERAL
	|	STRING
    |   CHAR
    |   FLOATING_POINT_LITERAL
    ;

// keywords & operators

function_decl_specifiers: ('inline' | 'virtual' | 'explicit' | 'friend' | 'static');
class_key: ('struct' | 'class' | 'union' | 'enum');
ptr_operator: ('*' | '&');

access_specifier: ('public' | 'private' | 'protected');
operator_function_id: OPERATOR operator;

operator: (('new' | 'delete' ) ('[' ']')?)
  | '+' | '-' | '*' | '/' | '%' |'^' | '&' | '|' | '~'
  | '!' | '=' | '<' | '>' | '+=' | '-=' | '*='
  | '/=' | '%=' | '^=' | '&=' | '|=' | '>>'
  |'<<'| '>>=' | '<<=' | '==' | '!='
  | '<=' | '>=' | '&&' | '||' | '++' | '--'
  | ',' | '->*' | '->' | '(' ')' | '[' ']'
  ;

assignment_operator: '=' | '*=' | '/=' | '%=' | '+=' | '-=' | '<<=' | '>>=' | '&=' | '^=' | '|='; 
equality_operator: ('=='| '!=');

template_decl_start : TEMPLATE '<' template_param_list '>';

// template water
template_param_list : (('<' template_param_list '>') |
                       ('(' template_param_list ')') | 
                       no_angle_brackets_or_brackets)*
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

assign_water: ~('(' | ')' | '{' | '}' | '[' | ']' | ';' | ',');
assign_water_l2: ~('(' | ')' | '{' | '}' | '[' | ']');

water : ~OTHER;


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
                   | do_statement
		   | while_statement
;

for_statement: 'for' '(' for_init_statement condition ';'  expr? ')';
while_statement: 'while' '(' condition ')';
do_statement: 'do'; //  statement 'while' '(' expr ')';

// Don't know why, but: introducing this unused rule results
// in a performance boost.

do_statement1: 'do' statement 'while' '(' expr ')';

for_init_statement : (simple_decl | expr?) ';';

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

statement_water: . ;
condition: expr;
