package ast.expressions;

import java.util.Iterator;
import java.util.LinkedList;

import ast.statements.ExpressionHolder;

public class ArgumentList extends ExpressionHolder implements Iterable<Expression>
{
	
	private LinkedList<Expression> arguments = new LinkedList<Expression>();

	public int size()
	{
		return this.arguments.size();
	}
	
	public Expression getArgument(int i) {
		return this.arguments.get(i);
	}

	public void addArgument(Expression argument)
	{
		this.arguments.add(argument);
		super.addChild(argument);
	}
	
	@Override
	public Iterator<Expression> iterator() {
		return this.arguments.iterator();
	}
}
