package ast.functionDef;

import ast.ASTNode;
import ast.DummyNameNode;
import ast.expressions.Identifier;
import ast.statements.CompoundStatement;
import ast.walking.ASTNodeVisitor;

public class FunctionDef extends ASTNode
{

	public Identifier name = new DummyNameNode();
	private ParameterList parameterList = new ParameterList();
	// private ReturnType returnType = new DummyReturnType();

	CompoundStatement content = new CompoundStatement();

	public CompoundStatement getContent()
	{
		return content;
	}

	public void addStatement(ASTNode statement)
	{
		content.addStatement(statement);
	}

	public void addParameter(Parameter aParameter)
	{
		getParameterList().addParameter(aParameter);
	}

	@Override
	public String getEscapedCodeStr()
	{
		// check if codeStr has already been generated
		if (codeStr != null)
			return codeStr;
		codeStr = getFunctionSignature();
		return codeStr;
	}

	public String getFunctionSignature()
	{
		String retval = name.getEscapedCodeStr();
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
		// this.returnType = returnType;
		this.addChild(returnType);
	}

}
