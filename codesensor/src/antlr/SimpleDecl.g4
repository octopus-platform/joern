grammar SimpleDecl;

simple_decl : TYPEDEF? template_decl_start? var_decl;

var_decl : type_name init_declarator_list #declByType
         | class_def init_declarator_list? #declByClass
         ;

init_declarator_list: init_declarator (',' init_declarator)* ';';

init_declarator : (ptrs? identifier type_suffix?) (('(' expr? ')') | ('=' assign_expr_w_))?;

assign_expr_w_: assign_water*
        (('{' assign_expr_w__l2 '}' | '(' assign_expr_w__l2 ')' | '[' assign_expr_w__l2 ']')
             assign_water*)*;

assign_expr_w__l2: assign_water_l2* (('{' assign_expr_w__l2 '}' | '(' assign_expr_w__l2 ')' | '[' assign_expr_w__l2 ']')
             assign_water_l2*)*;

constant_expr_w_: no_squares* ('[' constant_expr_w_ ']' no_squares*)*;

initializer: assign_expr
           | '{' initializer_list '}'
;
initializer_list: initializer (',' initializer)*;


class_def: class_key class_name? base_classes? OPENING_CURLY {skipToEndOfObject(); } ;
class_name: identifier;
base_classes: ':' base_class (',' base_class)*;
base_class: VIRTUAL? access_specifier? identifier;

type_name : (CV_QUALIFIER* (class_key | UNSIGNED | SIGNED)?
            base_type  ('<' template_param_list '>')? ('::' base_type ('<' template_param_list '>' )?)*)
          | (UNSIGNED | SIGNED);

type_suffix : ('[' constant_expr_w_ ']') | param_type_list;
base_type: (ALPHA_NUMERIC | VOID | LONG | LONG LONG);

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
