package ast.php.expressions;

import java.util.Iterator;
import java.util.LinkedList;

import ast.expressions.Expression;

public class ArrayExpression extends Expression implements Iterable<ArrayElement>
{

	private LinkedList<ArrayElement> arrayElements = new LinkedList<ArrayElement>();

	public int size()
	{
		return this.arrayElements.size();
	}
	
	public ArrayElement getArrayElement(int i) {
		return this.arrayElements.get(i);
	}

	public void addArrayElement(ArrayElement arrayElement)
	{
		this.arrayElements.add(arrayElement);
		super.addChild(arrayElement);
	}

	@Override
	public Iterator<ArrayElement> iterator() {
		return this.arrayElements.iterator();
	}
}
