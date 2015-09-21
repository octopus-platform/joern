package ast.functionDef;

import java.util.Iterator;
import java.util.LinkedList;

import ast.ASTNode;
import ast.walking.ASTNodeVisitor;

public class ParameterList extends ASTNode
{

	// TODO: we don't want to give back a reference to the list,
	// we need to provide iterators for type and name

	public LinkedList<Parameter> getParameters()
	{
		return parameters;
	}

	public void addParameter(Parameter aParam)
	{
		parameters.add(aParam);
		this.addChild(aParam);
	}

	private LinkedList<Parameter> parameters = new LinkedList<Parameter>();

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
}
