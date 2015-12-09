package ast.php.functionDef;

import ast.ASTNode;
import ast.expressions.StringExpression;

public class ClosureVar extends ASTNode
{
	private StringExpression name = null;
	
	public void setNameChild(StringExpression name) {
		this.name = name;
		super.addChild(name);
	}
	
	public StringExpression getNameChild() {
		return this.name;
	}
}
