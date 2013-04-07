package main.codeitems.expressions;

import main.codeitems.CodeItemVisitor;

public class CallExpression extends UnaryExpression {

	public Expression getTarget()
	{
		return field;
	}

	public void accept(CodeItemVisitor visitor){ visitor.visit(this); }
}
