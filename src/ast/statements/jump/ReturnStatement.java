package ast.statements.jump;

import ast.ASTNode;
import ast.logical.statements.JumpStatement;
import ast.walking.ASTNodeVisitor;

public class ReturnStatement extends JumpStatement
{
	private ASTNode returnExpression = null;
	
	public ASTNode getReturnExpression()
	{
		return this.returnExpression;
	}

	public void setReturnExpression(ASTNode expression)
	{
		this.returnExpression = expression;
		super.addChild(expression);
	}
	
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
