package udg.useDefGraph;

import ast.ASTNode;
import ast.ASTNodeProperties;

public class UseOrDefRecord
{
	private ASTNode astNode;
	private boolean isDef;

	public UseOrDefRecord(ASTNode anASTNode, boolean aIsDef)
	{
		setAstNode(anASTNode);
		setDef(aIsDef);
	}

	public ASTNode getAstNode()
	{
		return astNode;
	}

	public void setAstNode(ASTNode astNode)
	{
		this.astNode = astNode;
	}

	public boolean isDef()
	{
		return isDef;
	}

	public void setDef(boolean isDef)
	{
		this.isDef = isDef;
	}
	
	@Override
	public String toString() {
		
		if( null != astNode.getEscapedCodeStr() && null != astNode.getProperty(ASTNodeProperties.NODE_ID))
			return "[" + (this.isDef ? "DEF" : "USE") + " @ (" + astNode.getProperty(ASTNodeProperties.NODE_ID) + ") " + astNode.getEscapedCodeStr() + "]";
		if( null != astNode.getEscapedCodeStr())
			return "[" + (this.isDef ? "DEF" : "USE") + " @ " + astNode.getEscapedCodeStr() + "]";
		if( null != astNode.getProperty(ASTNodeProperties.NODE_ID))
			return "[" + (this.isDef ? "DEF" : "USE") + " @ " + astNode.getProperty(ASTNodeProperties.NODE_ID) + "]";
		
		return super.toString();
	}

};
