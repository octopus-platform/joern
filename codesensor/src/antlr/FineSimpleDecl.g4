grammar FineSimpleDecl;

import SimpleDecl;

init_declarator : (ptrs? identifier type_suffix?) (('(' expr? ')') | ('=' initializer))?;
type_suffix : ('[' conditional_expression? ']') | param_type_list;

