package ast.statements;

import ast.ASTNode;
import ast.logical.statements.Statement;

public class UseElement extends Statement
{
	private ASTNode namespace = null;
	private ASTNode alias = null;
	
	public ASTNode getNamespace()
	{
		return this.namespace;
	}

	public void setNamespace(ASTNode namespace)
	{
		this.namespace = namespace;
		super.addChild(namespace);
	}
	
	public ASTNode getAlias()
	{
		return this.alias;
	}

	public void setAlias(ASTNode alias)
	{
		this.alias = alias;
		super.addChild(alias);
	}
}
