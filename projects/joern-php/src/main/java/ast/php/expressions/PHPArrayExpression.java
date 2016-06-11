package ast.php.expressions;

import java.util.Iterator;
import java.util.LinkedList;

import ast.expressions.Expression;

public class PHPArrayExpression extends Expression implements Iterable<PHPArrayElement>
{

	private LinkedList<PHPArrayElement> arrayElements = new LinkedList<PHPArrayElement>();

	public int size()
	{
		return this.arrayElements.size();
	}
	
	public PHPArrayElement getArrayElement(int i) {
		return this.arrayElements.get(i);
	}

	public void addArrayElement(PHPArrayElement arrayElement)
	{
		this.arrayElements.add(arrayElement);
		super.addChild(arrayElement);
	}

	@Override
	public Iterator<PHPArrayElement> iterator() {
		return this.arrayElements.iterator();
	}
}
