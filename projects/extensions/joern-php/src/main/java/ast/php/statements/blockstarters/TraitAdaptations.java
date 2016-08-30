package ast.php.statements.blockstarters;

import java.util.Iterator;
import java.util.LinkedList;

import ast.logical.statements.BlockStarter;

public class TraitAdaptations extends BlockStarter implements Iterable<TraitAdaptationElement>
{

	private LinkedList<TraitAdaptationElement> traitAdaptations = new LinkedList<TraitAdaptationElement>();

	public int size()
	{
		return this.traitAdaptations.size();
	}
	
	public TraitAdaptationElement getTraitAdaptationElement(int i) {
		return this.traitAdaptations.get(i);
	}

	public void addTraitAdaptationElement(TraitAdaptationElement traitAdaptation)
	{
		this.traitAdaptations.add(traitAdaptation);
		super.addChild(traitAdaptation);
	}

	@Override
	public Iterator<TraitAdaptationElement> iterator() {
		return this.traitAdaptations.iterator();
	}
}
