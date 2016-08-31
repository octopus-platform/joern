package ast.php.statements.blockstarters;

import java.util.Iterator;
import java.util.LinkedList;

import ast.statements.blockstarters.IfStatementBase;

public class IfStatement extends IfStatementBase implements Iterable<IfElement>
{

	private LinkedList<IfElement> ifElements = new LinkedList<IfElement>();

	public int size()
	{
		return this.ifElements.size();
	}
	
	public IfElement getIfElement(int i) {
		return this.ifElements.get(i);
	}

	public void addIfElement(IfElement ifElement)
	{
		this.ifElements.add(ifElement);
		super.addChild(ifElement);
	}

	@Override
	public Iterator<IfElement> iterator() {
		return this.ifElements.iterator();
	}
}
