package udg;

import ast.ASTNode;

public class ASTNodeASTProvider extends ASTProvider
{

	ASTNode node;

	public void setNode(ASTNode astNode)
	{
		node = astNode;
	}

	public ASTNode getASTNode()
	{
		return node;
	}

	@Override
	public String getTypeAsString()
	{
		return node.getTypeAsString();
	}

	@Override
	public ASTProvider getChild(int i)
	{
		ASTNodeASTProvider childProvider = new ASTNodeASTProvider();
		childProvider.setNode(node.getChild(i));
		return childProvider;
	}

	@Override
	public int getChildCount()
	{
		return node.getChildCount();
	}

	@Override
	public String getEscapedCodeStr()
	{
		return node.getEscapedCodeStr();
	}

	@Override
	public int getChildNumber()
	{
		return node.getChildNumber();
	}

	@Override
	public boolean equals(Object o)
	{
		ASTNodeASTProvider other = (ASTNodeASTProvider) o;
		return (getASTNode() == other.getASTNode());
	}

	@Override
	public String getOperatorCode()
	{
		return node.getOperatorCode();
	}

}
