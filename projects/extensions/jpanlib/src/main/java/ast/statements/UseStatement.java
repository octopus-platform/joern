package ast.statements;

import java.util.Iterator;
import java.util.LinkedList;

import ast.logical.statements.Statement;

public class UseStatement extends Statement implements Iterable<UseElement>
{

	private LinkedList<UseElement> useElements = new LinkedList<UseElement>();

	public int size()
	{
		return this.useElements.size();
	}
	
	public UseElement getUseElement(int i) {
		return this.useElements.get(i);
	}

	public void addUseElement(UseElement useElement)
	{
		this.useElements.add(useElement);
		super.addChild(useElement);
	}

	@Override
	public Iterator<UseElement> iterator() {
		return this.useElements.iterator();
	}
}
