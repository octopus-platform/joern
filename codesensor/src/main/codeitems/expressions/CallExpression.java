package main.codeitems.expressions;

import main.codeitems.CodeItemVisitor;

public class CallExpression extends PostfixExpression {

	public Expression getTarget()
	{
		if(children == null) return null;
		return (Expression) children.get(0);
	}

	public void accept(CodeItemVisitor visitor){ visitor.visit(this); }
}
