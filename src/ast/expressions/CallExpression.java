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
		if (this.getClass().equals(CallExpression.class) &&
				node instanceof Identifier)
			// TODO refactor C world:
			// 1. create a CCallExpression extending CallExpression
			// 2. move addChild method to CCallExpression
			// 3. remove ugly this.getClass().equals(CallExpression.class) condition above
			// -> The only reason why we have to use that condition above is that we only want to call
			// setTarget((Identifier)node) here to set the target method name of CallExpressions in C world,
			// but not in PHP world (PHP world calls setTarget(ASTNode) directly).
			// That is, the addChild(ASTNode) override is unnecessary in PHP world, and in particular
			// its presence even *hurts* for PHP's StaticCallExpression, since there, without the ugly
			// condition above to make sure we are not in a subclass, it would have the
			// effect of calling the setTarget() method with the *class* name of the called method;
			// see StaticCallExpression.setTargetClass(Identifier)
			setTarget((Identifier)node);
		else if (node instanceof ArgumentList)
			setArgumentList((ArgumentList)node);
		else
			super.addChild(node);
	}
}
