lexer grammar CodeSensorLex;

ALPHA_NUMERIC: [a-zA-Z_~][a-zA-Z0-9_]*;

CPPCOMMENT : '//' .*? '\n' -> skip;
COMMENT :       '/*'  (.*?) '*/' -> skip;

STRING : ('\'' ( ('\\' . ) | ~('\\' | '\'') )* '\'' )
        |('"'  ( ('\\' . ) | ~('\\' | '"') )* '"') ;

PREPROC : '#'  ( (.*?) ~('\\') '\n') -> skip;

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

WHITESPACE: (' ' | '\t' | '\n' | '\r')+ -> skip;
OTHER : .  -> skip;
