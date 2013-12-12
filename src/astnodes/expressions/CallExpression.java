package astnodes.expressions;

import astnodes.ASTNode;
import astwalking.ASTNodeVisitor;

public class CallExpression extends PostfixExpression {

	public Expression getTarget()
	{
		if(children == null) return null;
		return (Expression) children.get(0);
	}

	public void accept(ASTNodeVisitor visitor){ visitor.visit(this); }

	public void replaceFirstChild(ASTNode node)
	{
		children.removeFirst();
		children.addFirst(node);
	}

}
