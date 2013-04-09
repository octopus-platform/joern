package main.codeitems.expressions;

import main.codeitems.CodeItemVisitor;
import main.codeitems.statements.ExpressionHolder;

public class Argument extends ExpressionHolder {
	public void accept(CodeItemVisitor visitor){ visitor.visit(this); }	
}
