package main.codeitems.expressions;

import main.codeitems.CodeItemVisitor;

public class MemberAccess extends PostfixExpression
{
	public void accept(CodeItemVisitor visitor){ visitor.visit(this); }	
}
