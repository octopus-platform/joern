grammar Expressions;

expr: assign_expr (',' expr)?;
assign_expr: conditional_expression (assignment_operator assign_expr)?;
conditional_expression: or_expression ('?' expr ':' conditional_expression)?;
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

cast_expression: ('(' type_name ptr_operator* ')' cast_expression)
               | unary_expression
;

unary_expression: inc_dec unary_operators field (('<' template_param_list '>')? function_argument_list) #funcCall
                | inc_dec unary_operators field #fieldOnly
;

inc_dec: ('--' | '++')*;
unary_operators: unary_operator*; 

field: primary_expression postfix*;

function_argument_list: '(' ( function_argument (',' function_argument)* )? ')';
function_argument: assign_expr;

postfix: ('.' identifier
       	 | '->' identifier
       	 | '[' expr ']')
         | '++'
         | '--'
;

primary_expression: identifier | constant | '(' expr ')';

