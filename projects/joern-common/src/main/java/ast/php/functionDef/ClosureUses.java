package ast.php.functionDef;

import java.util.Iterator;
import java.util.LinkedList;

import ast.ASTNode;

public class ClosureUses extends ASTNode implements Iterable<ClosureVar>
{
	private LinkedList<ClosureVar> closurevars = new LinkedList<ClosureVar>();

	public int size()
	{
		return this.closurevars.size();
	}
	
	public ClosureVar getClosureVar(int i) {
		return this.closurevars.get(i);
	}

	public void addClosureVar(ClosureVar closurevar)
	{
		this.closurevars.add(closurevar);
		super.addChild(closurevar);
	}

	@Override
	public Iterator<ClosureVar> iterator() {
		return this.closurevars.iterator();
	}
}
