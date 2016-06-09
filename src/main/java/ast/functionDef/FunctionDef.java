package ast.functionDef;

import ast.ASTNode;
import ast.expressions.Identifier;
import ast.logical.statements.CompoundStatement;
import ast.walking.ASTNodeVisitor;

public class FunctionDef extends ASTNode
{
	protected ParameterList parameterList = null;
	protected CompoundStatement content = null;

	public ParameterList getParameterList()
	{
		return this.parameterList;
	}

	public void setParameterList(ParameterList parameterList)
	{
		this.parameterList = parameterList;
		super.addChild(parameterList);
	}
	
	public CompoundStatement getContent()
	{
		return this.content;
	}
	
	public void setContent(CompoundStatement content)
	{
		this.content = content;
		super.addChild(content);
	}

	
	/* C world stuff */

	protected Identifier identifier = null; // TODO only used in C world, refactor and create a CFunctionDef
	
	public Identifier getIdentifier()
	{
		return this.identifier;
	}

	private void setIdentifier(Identifier identifier)
	{
		this.identifier = identifier;
		super.addChild(identifier);
	}
	
	public String getFunctionSignature()
	{
		String retval = getIdentifier().getEscapedCodeStr();
		if (getParameterList() != null)
			retval += " (" + getParameterList().getEscapedCodeStr() + ")";
		else
			retval += " ()";
		return retval;
	}
	
	@Override
	public String getEscapedCodeStr()
	{
		setCodeStr(getFunctionSignature());
		return getCodeStr();
	}

	@Override
	public void addChild(ASTNode node)
	{
		if (node instanceof CompoundStatement)
			setContent((CompoundStatement) node);
		else if (node instanceof ParameterList)
			setParameterList((ParameterList) node);
		else if (node instanceof Identifier)
			setIdentifier((Identifier) node);
		else
			super.addChild(node);
	}
	
	@Override
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
