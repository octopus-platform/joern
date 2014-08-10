package ast.statements;

import ast.ASTNode;
import ast.expressions.Expression;
import ast.walking.ASTNodeVisitor;

public class ForStatement extends BlockStarter
{
	private ASTNode forInitStatement = null;
	private ASTNode expression = null;

	public ASTNode getForInitStatement()
	{
		return forInitStatement;
	}

	public void setForInitStatement(ASTNode forInitStatement)
	{
		this.forInitStatement = forInitStatement;
	}

	public ASTNode getExpression()
	{
		return expression;
	}

	public void setExpression(ASTNode expression)
	{
		this.expression = expression;
	}

	@Override
	public void addChild(ASTNode node)
	{
		if (node instanceof Condition)
			setCondition((Condition) node);
		else if(node instanceof ForInit)
			setForInitStatement(node);
		else if(node instanceof Expression)
			setExpression(node);
		else if (node instanceof Statement)
			setStatement((Statement) node);
		super.addChild(node);
	}

	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
