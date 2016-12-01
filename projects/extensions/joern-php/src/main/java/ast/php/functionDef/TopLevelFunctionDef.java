package ast.php.functionDef;

import ast.expressions.Identifier;
import ast.functionDef.ParameterList;

public class TopLevelFunctionDef extends FunctionDef
{
	@Override
	public ParameterList getParameterList()
	{
		return null;
	}

	@Override
	public void setParameterList(ParameterList parameterList)
	{
	}

	@Override
	public Identifier getReturnType()
	{
		return null;
	}

	@Override
	public void setReturnType(Identifier returnType)
	{
	}


}
