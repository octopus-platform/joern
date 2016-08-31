package ast.php.expressions;

import ast.expressions.UnaryOperationExpression;

public class SilenceExpression extends UnaryOperationExpression
{
	// TODO remove this class once phpjoern uses version 20 of Niki's php-ast extension,
	// as "silence" expressions will then be consistently mapped onto a UnaryOperationExpression
	// with an appropriate flag.
}
