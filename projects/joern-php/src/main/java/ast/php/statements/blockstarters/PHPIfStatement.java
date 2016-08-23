package ast.php.statements.blockstarters;

import java.util.Iterator;
import java.util.LinkedList;

import ast.statements.blockstarters.IfStatementBase;

public class PHPIfStatement extends IfStatementBase implements Iterable<PHPIfElement>
{

	private LinkedList<PHPIfElement> ifElements = new LinkedList<PHPIfElement>();

	public int size()
	{
		return this.ifElements.size();
	}
	
	public PHPIfElement getIfElement(int i) {
		return this.ifElements.get(i);
	}

	public void addIfElement(PHPIfElement ifElement)
	{
		this.ifElements.add(ifElement);
		super.addChild(ifElement);
	}

	@Override
	public Iterator<PHPIfElement> iterator() {
		return this.ifElements.iterator();
	}
}
