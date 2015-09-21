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

	public void addChild(ASTNode node)
	{
		if (node instanceof CompoundStatement)
			setContent((CompoundStatement) node);
		else if (node instanceof ParameterList)
			setParameterList((ParameterList) node);
		else if (node instanceof Identifier)
			setName((Identifier) node);

		super.addChild(node);
	}

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

	private void setContent(CompoundStatement functionContent)
	{
		this.content = functionContent;
	}

	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}

	public ParameterList getParameterList()
	{
		return parameterList;
	}

	private void setParameterList(ParameterList parameterList)
	{
		this.parameterList = parameterList;
	}

	public Identifier getName()
	{
		return name;
	}

	private void setName(Identifier name)
	{
		this.name = name;
	}

}
