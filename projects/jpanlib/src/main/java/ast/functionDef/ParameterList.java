package ast.functionDef;

import java.util.Iterator;
import java.util.LinkedList;

import ast.ASTNode;
import ast.walking.ASTNodeVisitor;

public class ParameterList extends ASTNode implements Iterable<Parameter>
{
	private LinkedList<Parameter> parameters = new LinkedList<Parameter>();

	public void addChild(ASTNode node)
	{
		if (node instanceof Parameter)
			addParameter((Parameter) node);
		else
			super.addChild(node);
	}

	public int size()
	{
		return this.parameters.size();
	}
	
	public Parameter getParameter(int i) {
		return this.parameters.get(i);
	}

	public void addParameter(Parameter parameter)
	{
		this.parameters.add(parameter);
		super.addChild(parameter);
	}

	@Override
	public String getEscapedCodeStr()
	{

		if (parameters.size() == 0)
		{
			setCodeStr("");
			return getCodeStr();
		}

		Iterator<Parameter> i = parameters.iterator();
		StringBuilder s = new StringBuilder();
		for (; i.hasNext();)
		{
			Parameter param = i.next();
			s.append(param.getEscapedCodeStr() + " , ");
		}

		setCodeStr(s.toString());
		setCodeStr(getCodeStr().substring(0, s.length() - 3));

		return getCodeStr();
	}

	@Override
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}

	@Override
	public Iterator<Parameter> iterator() {
		return this.parameters.iterator();
	}
}
