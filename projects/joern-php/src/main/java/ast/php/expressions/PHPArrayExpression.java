package ast.php.expressions;

import java.util.Iterator;
import java.util.LinkedList;

import ast.expressions.Expression;

public class PHPArrayExpression extends Expression implements Iterable<ArrayElementPHP>
{

	private LinkedList<ArrayElementPHP> arrayElements = new LinkedList<ArrayElementPHP>();

	public int size()
	{
		return this.arrayElements.size();
	}
	
	public ArrayElementPHP getArrayElement(int i) {
		return this.arrayElements.get(i);
	}

	public void addArrayElement(ArrayElementPHP arrayElement)
	{
		this.arrayElements.add(arrayElement);
		super.addChild(arrayElement);
	}

	@Override
	public Iterator<ArrayElementPHP> iterator() {
		return this.arrayElements.iterator();
	}
}
