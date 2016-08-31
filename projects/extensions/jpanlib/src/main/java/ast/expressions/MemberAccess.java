package ast.expressions;

import ast.walking.ASTNodeVisitor;

public class MemberAccess extends PostfixExpression
{
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
