package ast.statements.jump;

import ast.ASTNode;
import ast.logical.statements.JumpStatement;
import ast.walking.ASTNodeVisitor;

public class ThrowStatement extends JumpStatement
{
	private ASTNode throwExpression = null;
	
	public ASTNode getThrowExpression()
	{
		return this.throwExpression;
	}

	public void setThrowExpression(ASTNode expression)
	{
		this.throwExpression = expression;
		super.addChild(expression);
	}
	
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
