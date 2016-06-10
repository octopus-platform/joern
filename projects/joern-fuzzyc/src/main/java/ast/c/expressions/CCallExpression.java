package ast.c.expressions;

import ast.ASTNode;
import ast.expressions.ArgumentList;
import ast.expressions.CallExpression;
import ast.expressions.Identifier;

public class CCallExpression extends CallExpression
{
	@Override
	public void addChild(ASTNode node)
	{
		if (node instanceof Identifier)
			setTargetFunc((Identifier)node);
		else if (node instanceof ArgumentList)
			setArgumentList((ArgumentList)node);
		else
			super.addChild(node);
	}
}
