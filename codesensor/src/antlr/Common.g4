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
                    
                    if(t == PRE_IF){
                        Stack<Object> ifdefStack = new Stack<Object>();
                        consume();
                        t = _input.LA(1);
                        
                        while(t != EOF && !(ifdefStack.empty() && (t == PRE_ELSE || t == PRE_ENDIF))){
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
}

simple_decl : 'typedef'? template_decl_start? var_decl;

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
base_class: 'virtual'? access_specifier? identifier;

type_name : (cv_qualifier* (class_key | 'unsigned' | 'signed')?
            base_type  ('<' template_param_list '>')? ('::' base_type ('<' template_param_list '>' )?)*)
          | ('unsigned' | 'signed');

type_suffix : ('[' constant_expr_w_ ']') | param_type_list;
base_type: (ALPHA_NUMERIC | 'void' | 'long' | 'long' 'long');

// this one is new
constant_expr_w_: no_squares* ('[' constant_expr_w_ ']' no_squares*)*;

// Parameters

param_decl_specifiers : ('auto' | 'register')? type_name;
parameter_name: identifier | access_specifier;
param_type_list: '(' 'void' ')'
               | '(' (param_type (',' param_type)*)? ')';

param_type: param_decl_specifiers param_type_id?;
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
    |   FLOATING_POINT_LITERAL
    ;

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
equality_operator: ('=='| '!=');

template_decl_start : 'template' '<' template_param_list '>';

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
