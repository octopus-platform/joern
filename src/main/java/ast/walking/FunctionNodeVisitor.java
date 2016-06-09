package ast.walking;

import ast.functionDef.FunctionDef;
import ast.statements.IdentifierDeclStatement;

public class FunctionNodeVisitor extends ASTNodeVisitor
{
	ASTNodeVisitor functionNodeVisitor;

	public void setFunctionNodeVisitor(ASTNodeVisitor aNodeVisitor)
	{
		functionNodeVisitor = aNodeVisitor;
	}

	public ASTNodeVisitor getFunctionNodeVisitor()
	{
		return functionNodeVisitor;
	}

	public void visit(FunctionDef node)
	{
		node.accept(functionNodeVisitor);
	}

	public void visit(IdentifierDeclStatement statementItem)
	{
		// don't expand identifier declarations
	}

}
