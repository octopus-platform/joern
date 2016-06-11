package ast.php.statements;

import java.util.Iterator;
import java.util.LinkedList;

import ast.logical.statements.Statement;

public class ClassConstantDeclaration extends Statement implements Iterable<ConstantElement>
{

	private LinkedList<ConstantElement> constants = new LinkedList<ConstantElement>();

	public int size()
	{
		return this.constants.size();
	}
	
	public ConstantElement getConstantElement(int i) {
		return this.constants.get(i);
	}

	public void addConstantElement(ConstantElement constant)
	{
		this.constants.add(constant);
		super.addChild(constant);
	}

	@Override
	public Iterator<ConstantElement> iterator() {
		return this.constants.iterator();
	}
}
