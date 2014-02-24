package astnodes.statements;

import astnodes.ASTNode;
import astnodes.DummyASTNode;
import astwalking.ASTNodeVisitor;

public class ForStatement extends BlockStarter
{
	private ASTNode forInitStatement = new DummyASTNode();
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
	public void addChild(ASTNode item)
	{	
		if(forInitStatement instanceof DummyASTNode)
			forInitStatement = item;
		else if(expression instanceof DummyASTNode && condition != null)
			expression = item;
		super.addChild(item);
	}

	public void accept(ASTNodeVisitor visitor){ visitor.visit(this); }
}
