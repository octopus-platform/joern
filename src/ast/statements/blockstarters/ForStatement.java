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
	private ASTNode forInitExpression = null; // TODO make this an ExpressionList sometime (might need to create a PHPForStatement)
	private ASTNode forLoopExpression = null; // TODO make this an ExpressionList sometime (might need to create a PHPForStatement)

	public ASTNode getForInitExpression()
	{
		return forInitExpression;
	}

	public void setForInitExpression(ASTNode expression)
	{
		this.forInitExpression = expression;
		super.addChild(expression);
	}

	public ASTNode getForLoopExpression()
	{
		return forLoopExpression;
	}

	public void setForLoopExpression(ASTNode expression)
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
			setForInitExpression(node);
		else if (node instanceof Expression)
			setForLoopExpression(node);
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
