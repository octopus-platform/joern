package ast.php.functionDef;

import ast.ASTNode;
import ast.expressions.Identifier;
import ast.functionDef.FunctionDef;
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
	public void setReturnType(ASTNode returnType)
	{
	}
}
