package ast.expressions;

public class Constant extends Expression
{
	private Identifier identifier = null;
	
	public void setIdentifier(Identifier identifier) {
		this.identifier = identifier;
		super.addChild(identifier);
	}
	
	public Identifier getIdentifier() {
		return this.identifier;
	}
}
