package ast.php.statements.blockstarters;

import java.util.Iterator;
import java.util.LinkedList;

import ast.logical.statements.BlockStarter;

public class SwitchList extends BlockStarter implements Iterable<SwitchCase>
{

	private LinkedList<SwitchCase> switchCases = new LinkedList<SwitchCase>();

	public int size()
	{
		return this.switchCases.size();
	}
	
	public SwitchCase getSwitchCase(int i) {
		return this.switchCases.get(i);
	}

	public void addSwitchCase(SwitchCase switchCase)
	{
		this.switchCases.add(switchCase);
		super.addChild(switchCase);
	}

	@Override
	public Iterator<SwitchCase> iterator() {
		return this.switchCases.iterator();
	}
}
