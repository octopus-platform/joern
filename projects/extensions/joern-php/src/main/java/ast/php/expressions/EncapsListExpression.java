package ast.php.expressions;

import java.util.Iterator;
import java.util.LinkedList;

import ast.expressions.Expression;

public class EncapsListExpression extends Expression implements Iterable<Expression>
{

	private LinkedList<Expression> elements = new LinkedList<Expression>();

	public int size()
	{
		return this.elements.size();
	}
	
	public Expression getElement(int i) {
		return this.elements.get(i);
	}

	public void addElement(Expression element)
	{
		this.elements.add(element);
		super.addChild(element);
	}
	
	@Override
	public Iterator<Expression> iterator() {
		return this.elements.iterator();
	}
}
