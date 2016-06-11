package ast.php.statements.blockstarters;

import java.util.Iterator;
import java.util.LinkedList;

import ast.logical.statements.BlockStarter;

public class PHPTraitAdaptations extends BlockStarter implements Iterable<PHPTraitAdaptationElement>
{

	private LinkedList<PHPTraitAdaptationElement> traitAdaptations = new LinkedList<PHPTraitAdaptationElement>();

	public int size()
	{
		return this.traitAdaptations.size();
	}
	
	public PHPTraitAdaptationElement getTraitAdaptationElement(int i) {
		return this.traitAdaptations.get(i);
	}

	public void addTraitAdaptationElement(PHPTraitAdaptationElement traitAdaptation)
	{
		this.traitAdaptations.add(traitAdaptation);
		super.addChild(traitAdaptation);
	}

	@Override
	public Iterator<PHPTraitAdaptationElement> iterator() {
		return this.traitAdaptations.iterator();
	}
}
