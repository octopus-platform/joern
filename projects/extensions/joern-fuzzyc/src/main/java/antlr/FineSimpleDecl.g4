// Encompasses declarations in the function scope, e.g. local variable declarations

grammar FineSimpleDecl;

import SimpleDecl;

init_declarator: declarator '(' expr? ')' #initDeclWithCall
               | declarator '=' initializer #initDeclWithAssign
               | declarator #initDeclSimple
               ;

declarator: ptrs? identifier type_suffix? |
            ptrs? '(' func_ptrs identifier ')' type_suffix;

type_suffix : ('[' conditional_expression? ']') | param_type_list;

