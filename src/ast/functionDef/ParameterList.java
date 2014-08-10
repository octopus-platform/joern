package ast.functionDef;

import java.util.Iterator;
import java.util.LinkedList;

import ast.ASTNode;
import ast.expressions.Identifier;
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

	public Identifier[] getNames()
	{
		Identifier retNames[] = new Identifier[parameters.size()];
		for (int i = 0; i < parameters.size(); i++)
		{
			retNames[i] = parameters.get(i).name;
		}
		return retNames;
	}

	public String[] getNameStrings()
	{
		String retStrings[] = new String[parameters.size()];
		for (int i = 0; i < parameters.size(); i++)
		{
			retStrings[i] = parameters.get(i).name.getEscapedCodeStr();
		}
		return retStrings;
	}

	public ParameterType[] getTypes()
	{
		ParameterType retTypes[] = new ParameterType[parameters.size()];
		for (int i = 0; i < parameters.size(); i++)
		{
			retTypes[i] = parameters.get(i).type;
		}
		return retTypes;
	}

	public String[] getTypeStrings()
	{
		String retStrings[] = new String[parameters.size()];
		for (int i = 0; i < parameters.size(); i++)
		{
			retStrings[i] = parameters.get(i).type.getEscapedCodeStr();
		}
		return retStrings;
	}

	private LinkedList<Parameter> parameters = new LinkedList<Parameter>();

	@Override
	public String getEscapedCodeStr()
	{
		if (codeStr != null)
			return codeStr;

		if (parameters.size() == 0)
		{
			codeStr = "";
			return codeStr;
		}

		Iterator<Parameter> i = parameters.iterator();
		StringBuilder s = new StringBuilder();
		for (; i.hasNext();)
		{
			Parameter param = i.next();
			s.append(param.getEscapedCodeStr() + " , ");
		}

		codeStr = s.toString();
		codeStr = codeStr.substring(0, s.length() - 3);

		return codeStr;
	}

	@Override
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
