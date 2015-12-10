package ast.expressions;

public class Variable extends Expression
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
