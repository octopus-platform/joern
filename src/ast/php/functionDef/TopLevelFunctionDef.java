package ast.php.functionDef;

import ast.ASTNode;
import ast.functionDef.FunctionDef;
import ast.functionDef.ParameterList;

public class TopLevelFunctionDef extends FunctionDef
{

	public void addChild(ASTNode node)
	{
		// do not allow ParameterList's in top-level functions
		if (!(node instanceof ParameterList))
			super.addChild(node);
	}

	@Override
	public String getFunctionSignature()
	{
		return getName().getEscapedCodeStr();
	}

	@Override
	public ParameterList getParameterList()
	{
		return null;
	}

}
