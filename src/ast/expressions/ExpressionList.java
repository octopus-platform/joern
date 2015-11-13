package ast.expressions;

import java.util.Iterator;
import java.util.LinkedList;

import ast.ASTNode;

public class ExpressionList extends ASTNode implements Iterable<ASTNode>
{
	private LinkedList<ASTNode> expressions = new LinkedList<ASTNode>();
	// TODO eventually, of course, this has to be a LinkedList<Expression>
	// However, until we have completed the PHP AST -> Joern mapping, we must
	// use ASTNode or we will get ClassCastException's

	public int size()
	{
		return this.expressions.size();
	}
	
	public ASTNode getExpression(int i) {
		return this.expressions.get(i);
	}

	public void addExpression(ASTNode expression)
	{
		this.expressions.add(expression);
		super.addChild(expression);
	}

	@Override
	public Iterator<ASTNode> iterator() {
		return this.expressions.iterator();
	}
}
