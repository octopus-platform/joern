package main.codeitems.statements;

import tools.index.ParseTreeUtils;
import main.codeitems.CodeItemVisitor;

public class Condition extends ExpressionHolder
{	
	public void accept(CodeItemVisitor visitor){ visitor.visit(this); }
}
