package ast.functionDef;

import ast.ASTNode;
import ast.DummyNameNode;
import ast.expressions.Identifier;
import ast.logical.statements.CompoundStatement;
import ast.walking.ASTNodeVisitor;

public class FunctionDef extends ASTNode
{

	private Identifier name = new DummyNameNode();
	private ParameterList parameterList = new ParameterList();
	private CompoundStatement content = new CompoundStatement();

	public CompoundStatement getContent()
	{
		return content;
	}

	@Override
	public String getEscapedCodeStr()
	{
		setCodeStr(getFunctionSignature());
		return getCodeStr();
	}

	public String getFunctionSignature()
	{
		String retval = getName().getEscapedCodeStr();
		if (getParameterList() != null)
			retval += " (" + getParameterList().getEscapedCodeStr() + ")";
		else
			retval += " ()";
		return retval;
	}

	public void setContent(CompoundStatement functionContent)
	{
		content = functionContent;
		addChild(content);
	}

	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}

	public ParameterList getParameterList()
	{
		return parameterList;
	}

	public void setParameterList(ParameterList parameterList)
	{
		this.parameterList = parameterList;
		this.addChild(this.parameterList);
	}

	public void setReturnType(ReturnType returnType)
	{
		this.addChild(returnType);
	}

	public Identifier getName()
	{
		return name;
	}

	public void setName(Identifier name)
	{
		this.name = name;
	}

}
