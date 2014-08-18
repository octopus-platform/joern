package ast.declarations;

import ast.ASTNode;

public class IdentifierDeclType extends ASTNode
{
	public String baseType;
	public String completeType;

	public String getEscapedCodeStr()
	{
		return completeType;
	}

}
