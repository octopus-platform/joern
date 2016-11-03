// Encompasses declarations in the module scope, e.g. variable declarations in C++ classes

grammar CoarseSimpleDecl;

import SimpleDecl;

// The following two contain 'water'-rules for expressions

init_declarator : declarator (('(' expr? ')') | ('=' assign_expr_w_))?;
declarator: ptrs? identifier type_suffix? |
            ptrs? '(' func_ptrs identifier ')' type_suffix;

type_suffix : ('[' constant_expr_w_ ']') | param_type_list;

// water rules for expressions

assign_expr_w_: assign_water*
        (('{' assign_expr_w__l2 '}' | '(' assign_expr_w__l2 ')' | '[' assign_expr_w__l2 ']')
             assign_water*)*;

assign_expr_w__l2: assign_water_l2* (('{' assign_expr_w__l2 '}' | '(' assign_expr_w__l2 ')' | '[' assign_expr_w__l2 ']')
             assign_water_l2*)*;

constant_expr_w_: no_squares* ('[' constant_expr_w_ ']' no_squares*)*;

