package main.codeitems.function;

import main.codeitems.CodeItem;

public class ReturnType extends CodeItem
{
	String completeType;
	String baseType;
	
	public ReturnType()
	{
		setNodeTypeName("RETURN_TYPE");
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
