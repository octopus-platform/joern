package cfg;

import astnodes.ASTNode;

public class CFGNode {

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

}
