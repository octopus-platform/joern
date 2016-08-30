package ast.c.expressions;

import ast.ASTNode;
import ast.expressions.ArgumentList;
import ast.expressions.CallExpressionBase;
import ast.expressions.Identifier;

public class CallExpression extends CallExpressionBase
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
