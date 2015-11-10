package ast.php.functionDef;

import ast.ASTNode;
import ast.expressions.Identifier;
import ast.functionDef.FunctionDef;
import ast.functionDef.ParameterList;
import ast.logical.statements.CompoundStatement;

public class TopLevelFunctionDef extends FunctionDef
{

	public void addChild(ASTNode node)
	{
		// only allow CompoundStatements as children
		if (node instanceof CompoundStatement)
			super.addChild(node);
	}

	@Override
	public ParameterList getParameterList()
	{
		return null;
	}
	
	@Override
	public Identifier getReturnTypeIdentifier()
	{
		return null;
	}
}
