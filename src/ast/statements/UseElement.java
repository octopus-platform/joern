package ast.statements;

import ast.expressions.StringExpression;
import ast.logical.statements.Statement;

public class UseElement extends Statement
{
	private StringExpression namespace = null;
	private StringExpression alias = null;
	
	public StringExpression getNamespace()
	{
		return this.namespace;
	}

	public void setNamespace(StringExpression namespace)
	{
		this.namespace = namespace;
		super.addChild(namespace);
	}
	
	public StringExpression getAlias()
	{
		return this.alias;
	}

	public void setAlias(StringExpression alias)
	{
		this.alias = alias;
		super.addChild(alias);
	}
}
