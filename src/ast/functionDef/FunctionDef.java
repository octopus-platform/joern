package ast.functionDef;

import ast.ASTNode;
import ast.ASTNodeProperties;
import ast.DummyIdentifierNode;
import ast.expressions.Identifier;
import ast.logical.statements.CompoundStatement;
import ast.walking.ASTNodeVisitor;

public class FunctionDef extends ASTNode
{

	private Identifier identifier = new DummyIdentifierNode();
	private ParameterList parameterList = new ParameterList();
	private CompoundStatement content = new CompoundStatement();

	public void addChild(ASTNode node)
	{
		if (node instanceof CompoundStatement)
			setContent((CompoundStatement) node);
		else if (node instanceof ParameterList)
			setParameterList((ParameterList) node);
		else if (node instanceof Identifier)
			setIdentifier((Identifier) node);

		super.addChild(node);
	}
	
	public String getName() {
		return getProperty(ASTNodeProperties.NAME);
	}
	
	public void setName(String name) {
		setProperty(ASTNodeProperties.NAME, name);
	}
	
	public String getDocComment() {
		return getProperty(ASTNodeProperties.DOCCOMMENT);
	}
	
	public void setDocComment(String doccomment) {
		setProperty(ASTNodeProperties.DOCCOMMENT, doccomment);
	}

	public CompoundStatement getContent()
	{
		return content;
	}
	
	public Identifier getReturnType()
	{
		return this.identifier;
	}

	@Override
	public String getEscapedCodeStr()
	{
		setCodeStr(getFunctionSignature());
		return getCodeStr();
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

	public Identifier getIdentifier()
	{
		return identifier;
	}

	private void setIdentifier(Identifier identifier)
	{
		this.identifier = identifier;
	}

}
