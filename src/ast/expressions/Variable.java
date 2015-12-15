package ast.expressions;

public class Variable extends Expression
{
	private Expression name = null;
	
	public void setNameExpression(Expression name) {
		this.name = name;
		super.addChild(name);
	}
	
	public Expression getNameExpression() {
		return this.name;
	}
}
