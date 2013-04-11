package astnodes.functionDef;

import java.util.Iterator;
import java.util.LinkedList;

import astnodes.ASTNode;
import astnodes.expressions.Identifier;


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
	}
	
	public Identifier [] getNames()
	{
		Identifier retNames [] = new Identifier[parameters.size()];
		for(int i = 0; i < parameters.size(); i++){
			retNames[i] = parameters.get(i).name;
		}
		return retNames;
	}
	
	public String [] getNameStrings()
	{
		String retStrings [] = new String[parameters.size()];
		for(int i = 0; i < parameters.size(); i++){
			retStrings[i] = parameters.get(i).name.getCodeStr();
		}
		return retStrings;
	}
	
	public ParameterType [] getTypes()
	{
		ParameterType retTypes [] = new ParameterType[parameters.size()];
		for(int i = 0; i < parameters.size(); i++){
			retTypes[i] = parameters.get(i).type;
		}
		return retTypes;
	}
	
	public String [] getTypeStrings()
	{
		String retStrings [] = new String[parameters.size()];
		for(int i = 0; i < parameters.size(); i++){
			retStrings[i] = parameters.get(i).type.getCodeStr();
		}
		return retStrings;
	}
	
	private LinkedList<Parameter> parameters = new LinkedList<Parameter>();

	
	@Override
	public String getCodeStr()
	{
		if(codeStr != null)
			return codeStr;
		
		if(parameters.size() == 0){
			codeStr = "";
			return codeStr;
		}
		
		Iterator<Parameter> i = parameters.iterator();
		StringBuilder s = new StringBuilder();
		for(; i.hasNext();){
			Parameter param = i.next();
			s.append(param.getCodeStr() + " , ");
		}
		
		codeStr = s.toString();
		codeStr = codeStr.substring(0, s.length() - 3);
		
		return codeStr;
	}

}
