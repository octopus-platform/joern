package ast.logical.statements;

import ast.expressions.StringExpression;
import ast.walking.ASTNodeVisitor;

public class Label extends Statement
{
	private StringExpression name = null;

	public void setNameChild(StringExpression name) {
		this.name = name;
		super.addChild(name);
	}
	
	public StringExpression getNameChild() {
		return this.name;
	}
	
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
