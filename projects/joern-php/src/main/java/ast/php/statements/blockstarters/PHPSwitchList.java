package ast.php.statements.blockstarters;

import java.util.Iterator;
import java.util.LinkedList;

import ast.logical.statements.BlockStarter;

public class PHPSwitchList extends BlockStarter implements Iterable<PHPSwitchCase>
{

	private LinkedList<PHPSwitchCase> switchCases = new LinkedList<PHPSwitchCase>();

	public int size()
	{
		return this.switchCases.size();
	}
	
	public PHPSwitchCase getSwitchCase(int i) {
		return this.switchCases.get(i);
	}

	public void addSwitchCase(PHPSwitchCase switchCase)
	{
		this.switchCases.add(switchCase);
		super.addChild(switchCase);
	}

	@Override
	public Iterator<PHPSwitchCase> iterator() {
		return this.switchCases.iterator();
	}
}
