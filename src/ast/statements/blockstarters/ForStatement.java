package ast.statements.blockstarters;

import ast.ASTNode;
import ast.expressions.Expression;
import ast.expressions.ForInit;
import ast.logical.statements.BlockStarter;
import ast.logical.statements.Condition;
import ast.logical.statements.Statement;
import ast.walking.ASTNodeVisitor;

public class ForStatement extends BlockStarter
{
	private Expression forInitExpression = null; // TODO make this an ExpressionList sometime (might need to create a PHPForStatement)
	private Expression forLoopExpression = null; // TODO make this an ExpressionList sometime (might need to create a PHPForStatement)

	public Expression getForInitExpression()
	{
		return forInitExpression;
	}

	public void setForInitExpression(Expression expression)
	{
		this.forInitExpression = expression;
		super.addChild(expression);
	}

	public Expression getForLoopExpression()
	{
		return forLoopExpression;
	}

	public void setForLoopExpression(Expression expression)
	{
		this.forLoopExpression = expression;
		super.addChild(expression);
	}

	@Override
	public void addChild(ASTNode node)
	{
		if (node instanceof Condition)
			setCondition((Condition) node);
		else if (node instanceof ForInit)
			setForInitExpression((Expression)node);
		else if (node instanceof Expression)
			setForLoopExpression((Expression)node);
		else if (node instanceof Statement)
			setStatement((Statement) node);
		else
			super.addChild(node);
	}

	@Override
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
