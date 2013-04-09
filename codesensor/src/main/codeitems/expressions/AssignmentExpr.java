package main.codeitems.expressions;

import main.codeitems.CodeItemVisitor;

public class AssignmentExpr extends BinaryExpression
{
	public void accept(CodeItemVisitor visitor){ visitor.visit(this); }
}
