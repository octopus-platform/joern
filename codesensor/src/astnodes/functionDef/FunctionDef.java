package astnodes.functionDef;

import astnodes.ASTNode;
import astnodes.DummyNameNode;
import astnodes.expressions.Identifier;
import astnodes.statements.CompoundStatement;
import astwalking.ASTNodeVisitor;


public class FunctionDef extends ASTNode
{

	public Identifier name = new DummyNameNode();
	public ParameterList parameterList = new ParameterList();
	public ReturnType returnType = new DummyReturnType();
	
	CompoundStatement content = new CompoundStatement();
	
	public CompoundStatement getContent()
	{
		return content;
	}
	
	public void addStatement(ASTNode statement)
	{
		content.addStatement(statement);
	}
	
	// let the content item be the only child
	public int getChildCount() { return 1; }
	public ASTNode getChild(int i){ return content; }
	
	public void addParameter(Parameter aParameter)
	{
		parameterList.addParameter(aParameter);
	}
	
	@Override
	public String getCodeStr()
	{
		// check if codeStr has already been generated
		if(codeStr != null)
			return codeStr;
		codeStr = getFunctionSignature();
		return codeStr;
	}
	
	public String getFunctionSignature()
	{
		String retval = name.getCodeStr();
		if(parameterList != null)
			retval += " (" + parameterList.getCodeStr() + ")";
		else
			retval += " ()";
		return retval;
	}

	public void setContent(CompoundStatement functionContent)
	{
		content = functionContent;
	}
	
	public void accept(ASTNodeVisitor visitor){ visitor.visit(this); }
	
}
