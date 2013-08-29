package cfg;

import astnodes.ASTNode;

public class BasicBlock {

	ASTNode astNode;
	
	public void setASTNode(ASTNode node)
	{
		astNode = node;		
	}

	public ASTNode getASTNode()
	{
		return astNode;
	}

	public String getEscapedCodeStr()
	{
		if(astNode == null)
			return "";
		
		return astNode.getEscapedCodeStr();
	}

	public String getType()
	{
//		if(astNode == null)
//			return "";
//
//		return astNode.getTypeAsString() + "BB";
		return "BasicBlock";
	}

}
