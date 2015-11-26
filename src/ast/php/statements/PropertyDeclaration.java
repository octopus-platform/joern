package ast.php.statements;

import java.util.Iterator;
import java.util.LinkedList;

import ast.logical.statements.Statement;

public class PropertyDeclaration extends Statement implements Iterable<PropertyElement>
{

	private LinkedList<PropertyElement> properties = new LinkedList<PropertyElement>();

	public int size()
	{
		return this.properties.size();
	}
	
	public PropertyElement getPropertyElement(int i) {
		return this.properties.get(i);
	}

	public void addPropertyElement(PropertyElement property)
	{
		this.properties.add(property);
		super.addChild(property);
	}

	@Override
	public Iterator<PropertyElement> iterator() {
		return this.properties.iterator();
	}
}
