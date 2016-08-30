package ast.expressions;

import java.util.Iterator;
import java.util.LinkedList;

import ast.ASTNode;

public class IdentifierList extends ASTNode implements Iterable<Identifier>
{
	private LinkedList<Identifier> identifiers = new LinkedList<Identifier>();

	public int size()
	{
		return this.identifiers.size();
	}
	
	public Identifier getIdentifier(int i) {
		return this.identifiers.get(i);
	}

	public void addIdentifier(Identifier identifier)
	{
		this.identifiers.add(identifier);
		super.addChild(identifier);
	}

	@Override
	public Iterator<Identifier> iterator() {
		return this.identifiers.iterator();
	}
}
