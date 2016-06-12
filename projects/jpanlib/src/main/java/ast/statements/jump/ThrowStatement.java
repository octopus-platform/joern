package ast.statements.jump;

import ast.ASTNode;
import ast.expressions.Expression;
import ast.logical.statements.JumpStatement;
import ast.walking.ASTNodeVisitor;

public class ThrowStatement extends JumpStatement
{
	private Expression throwExpression = null;
	
	public Expression getThrowExpression()
	{
		return this.throwExpression;
	}

	public void setThrowExpression(Expression expression)
	{
		this.throwExpression = expression;
		super.addChild(expression);
	}
	
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
	
	@Override
	public void addChild(ASTNode node)
	{
		if (node instanceof Expression)
			setThrowExpression((Expression) node);
		else
			super.addChild(node);
	}
}
