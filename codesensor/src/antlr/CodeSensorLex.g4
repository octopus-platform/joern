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

CV_QUALIFIER :  'const' | 'volatile';

ALPHA_NUMERIC: [a-zA-Z_~][a-zA-Z0-9_]*;
OPENING_CURLY: '{';
CLOSING_CURLY: '}';

// pre-processor directives

PRE_IF: ('#if' | '#ifdef' | '#ifndef') ~[\r\n]* '\r'? '\n';
PRE_ELSE: ('#else' | '#elif') ~[\r\n]* '\r'? '\n';
PRE_ENDIF: '#endif' ~[\r\n]* '\r'? '\n';
// PREPROC : '#' ~[\r\n]* '\r'? '\n' -> skip;


HEX_LITERAL : '0' ('x'|'X') HexDigit+ IntegerTypeSuffix? ;
DECIMAL_LITERAL : ('0' | '1'..'9' '0'..'9'*) IntegerTypeSuffix? ;
OCTAL_LITERAL : '0' ('0'..'7')+ IntegerTypeSuffix? ;

FLOATING_POINT_LITERAL
    :   ('0'..'9')+ '.' ('0'..'9')* Exponent? FloatTypeSuffix?
    |   '.' ('0'..'9')+ Exponent? FloatTypeSuffix?
    |   ('0'..'9')+ Exponent FloatTypeSuffix?
    |   ('0'..'9')+ Exponent? FloatTypeSuffix
	;

CHAR
    :   '\'' ( EscapeSequence | ~('\''|'\\') ) '\''
    ;

STRING
    :  '"' ( EscapeSequence | ~('\\'|'"') )* '"'
    ;


fragment
IntegerTypeSuffix
	:	('u'|'U')? ('l'|'L')
	|	('u'|'U')  ('l'|'L')?
	;

fragment
Exponent : ('e'|'E') ('+'|'-')? ('0'..'9')+;

fragment
FloatTypeSuffix : ('f'|'F'|'d'|'D');


fragment
EscapeSequence
    :   '\\' .
    |   UnicodeEscape
    |   OctalEscape
    ;

fragment
OctalEscape
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UnicodeEscape
    :   '\\' 'u' HexDigit HexDigit HexDigit HexDigit
    ;

fragment
HexDigit : ('0'..'9'|'a'..'f'|'A'..'F') ;

COMMENT
    :   '/*' .*? '*/'    -> skip 
    ;
WHITESPACE  :   [ \r\t\u000C\n]+ -> skip
    ;

CPPCOMMENT
    : '//' ~[\r\n]* '\r'? '\n' -> skip
    ;

OTHER : . -> skip ;
