lexer grammar CodeSensorLex;


// keywords

IF: 'if'; ELSE: 'else'; FOR: 'for'; WHILE: 'while';
SWITCH: 'switch'; CONTINUE: 'continue'; BREAK: 'break';
GOTO: 'goto'; RETURN: 'return'; CASE: 'case';
TRY: 'try'; CATCH: 'catch'; THROW: 'throw';
VOID: 'void'; USING: 'using';
NAMESPACE: 'namespace'; TYPEDEF: 'typedef';
VIRTUAL: 'virtual';
UNSIGNED: 'unsigned'; SIGNED: 'signed';
LONG: 'long';
AUTO: 'auto'; REGISTER: 'register';
OPERATOR: 'operator'; TEMPLATE: 'template';

ALPHA_NUMERIC: [a-zA-Z_~][a-zA-Z0-9_]*;

// pre-processor directives

PRE_IF: ('#if' | '#ifdef' | '#ifndef') ( (.*?) ~('\\') '\n');
PRE_ELSE: '#else' | '#elif';
PRE_ENDIF: '#endif';
INCLUDE: '#include ' ( (.*?) ~('\\') '\n');

OPENING_CURLY: '{';
CLOSING_CURLY: '}';

HEX_LITERAL : '0' ('x'|'X') HexDigit+ IntegerTypeSuffix? ;
DECIMAL_LITERAL : ('0' | '1'..'9' '0'..'9'*) IntegerTypeSuffix? ;
OCTAL_LITERAL : '0' ('0'..'7')+ IntegerTypeSuffix? ;

fragment
HexDigit : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
IntegerTypeSuffix
	:	('u'|'U')? ('l'|'L')
	|	('u'|'U')  ('l'|'L')?
	;

FLOATING_POINT_LITERAL
    :   ('0'..'9')+ '.' ('0'..'9')* Exponent? FloatTypeSuffix?
    |   '.' ('0'..'9')+ Exponent? FloatTypeSuffix?
    |   ('0'..'9')+ Exponent FloatTypeSuffix?
    |   ('0'..'9')+ Exponent? FloatTypeSuffix
	;

fragment
Exponent : ('e'|'E') ('+'|'-')? ('0'..'9')+;

fragment
FloatTypeSuffix : ('f'|'F'|'d'|'D');

// PREPROC : '#'  ( (.*?) ~('\\') '\n') -> skip;

CPPCOMMENT : '//' .*? '\n' -> skip;
COMMENT :       '/*'  (.*?) '*/' -> skip;

STRING : ('\'' ( ('\\' . ) | ~('\\' | '\'') )* '\'' )
        |('"'  ( ('\\' . ) | ~('\\' | '"') )* '"') ;

WHITESPACE: (' ' | '\t' | '\n' | '\r')+ -> skip;
OTHER : .  -> skip;
