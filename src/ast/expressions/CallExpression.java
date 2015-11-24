package ast.expressions;

import ast.ASTNode;

public class CallExpression extends PostfixExpression
{
	private ASTNode target = null; // TODO change type to Expression once the mapping is finished
	private ArgumentList argumentList = null;
	
	public ASTNode getTarget() // TODO change type to Expression
	{
		return this.target;
	}
	
	public void setTarget(ASTNode target) // TODO change type to Expression
	{
		this.target = target;
		super.addChild(target);
	}
	
	public ArgumentList getArgumentList()
	{
		return this.argumentList;
	}
	
	public void setArgumentList(ArgumentList argumentList)
	{
		this.argumentList = argumentList;
		super.addChild(argumentList);
	}
	
	@Override
	public void addChild(ASTNode node)
	{
		if (node instanceof Identifier)
			setTarget((Identifier)node);
		else if (node instanceof ArgumentList)
			setArgumentList((ArgumentList)node);
		else
			super.addChild(node);
	}
}
