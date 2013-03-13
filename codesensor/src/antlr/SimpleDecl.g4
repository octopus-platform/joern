grammar SimpleDecl;
import CodeSensorLex;

simple_decl : 'typedef'? template_decl_start? var_decl;

var_decl : type_name init_declarator_list #declByType
         | class_def init_declarator_list? #declByClass
         ;

init_declarator_list: init_declarator (',' init_declarator)* ';';

// this rule is buggy: we can't match int (foo); or int (*foo)(bar *);
// let's get it running as-is first and then fix bugs.

init_declarator : (ptrs? identifier type_suffix?) (('(' expr_w_? ')') | ('=' assign_expr_w_))?;

class_def: class_key class_name? base_classes? OPENING_CURLY {skipToEndOfObject(); } ;
class_name: identifier;
base_classes: ':' base_class (',' base_class)*;
base_class: 'virtual'? access_specifier? identifier;

// this is new
assign_expr_w_: assign_water*
        (('{' assign_expr_w__l2 '}' | '(' assign_expr_w__l2 ')' | '[' assign_expr_w__l2 ']')
             assign_water*)*;

assign_expr_w__l2: assign_water_l2* (('{' assign_expr_w__l2 '}' | '(' assign_expr_w__l2 ')' | '[' assign_expr_w__l2 ']')
             assign_water_l2*)*;
