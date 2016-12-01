package ast.c.functionDef;

import ast.ASTNode;

public class ParameterType extends ASTNode
{
	String completeType = "";
	String baseType = "";

	@Override
	public String getEscapedCodeStr()
	{
		setCodeStr(completeType);
		return getCodeStr();
	}

	public void setCompleteType(String aCompleteType)
	{
		completeType = aCompleteType;
	}

	public void setBaseType(String aBaseType)
	{
		baseType = aBaseType;
	}

}
