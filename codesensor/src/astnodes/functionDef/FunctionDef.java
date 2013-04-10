package astnodes.functionDef;

import astnodes.ASTNode;
import astnodes.ASTNodeVisitor;
import astnodes.DummyName;
import astnodes.expressions.Identifier;
import astnodes.statements.CompoundItem;


public class FunctionDef extends ASTNode
{

	public Identifier name = new DummyName();
	public ParameterList parameterList = new ParameterList();
	public ReturnType returnType = new DummyReturnType();
	public CompoundItem content = new CompoundItem();
	
	public void addStatement(ASTNode statement)
	{
		content.addStatement(statement);
	}
	
	public FunctionDef()
	{
		setNodeTypeName("function");
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

	public void setContent(CompoundItem functionContent)
	{
		content = functionContent;
	}
	
	public void accept(ASTNodeVisitor visitor){ visitor.visit(this); }
	
}
