grammar Expressions;

expr: assign_expr (',' expr)?;

assign_expr: conditional_expression (assignment_operator assign_expr)?;
conditional_expression: or_expression #normOr
		      | or_expression ('?' expr ':' conditional_expression) #cndExpr;


or_expression : and_expression ('||' or_expression)?;
and_expression : inclusive_or_expression ('&&' and_expression)?;
inclusive_or_expression: exclusive_or_expression ('|' inclusive_or_expression)?;
exclusive_or_expression: bit_and_expression ('^' exclusive_or_expression)?;
bit_and_expression: equality_expression ('&' bit_and_expression)?;
equality_expression: relational_expression (equality_operator equality_expression)?;
relational_expression: shift_expression (relational_operator relational_expression)?;
shift_expression: additive_expression ( ('<<'|'>>') shift_expression)?;
additive_expression: multiplicative_expression (('+'| '-') additive_expression)?;
multiplicative_expression: cast_expression ( ('*'| '/'| '%') multiplicative_expression)?;

cast_expression: ('(' cast_target ')' cast_expression)
               | unary_expression
;

cast_target: type_name ptr_operator*;

// currently does not implement delete

unary_expression: inc_dec cast_expression
                | unary_op_and_cast_expr
                | sizeof_expression 
                | new_expression
                | postfix_expression
                ;

new_expression: '::'? NEW type_name '[' conditional_expression? ']' 
              | '::'? NEW type_name '(' expr? ')'
              ;

unary_op_and_cast_expr: unary_operator cast_expression;

sizeof_expression: sizeof '(' sizeof_operand ')'
                 | sizeof sizeof_operand2;

sizeof: 'sizeof';

sizeof_operand: type_name ptr_operator *;
sizeof_operand2: unary_expression;

inc_dec: ('--' | '++');

// this is a bit misleading. We're just allowing access_specifiers
// here because C programs can use 'public', 'protected' or 'private'
// as variable names.

postfix_expression: postfix_expression '[' expr ']' #arrayIndexing
                  | postfix_expression '(' function_argument_list ')' #funcCall
                  | postfix_expression '.' TEMPLATE? (identifier) #memberAccess
                  | postfix_expression '->' TEMPLATE? (identifier) #ptrMemberAccess
                  | postfix_expression inc_dec #incDecOp
                  | primary_expression # primaryOnly
                  ;

function_argument_list: ( function_argument (',' function_argument)* )?;
function_argument: assign_expr;


primary_expression: identifier | constant | '(' expr ')';

