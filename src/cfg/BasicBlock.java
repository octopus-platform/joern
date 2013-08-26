package cfg;

import java.util.LinkedList;
import java.util.List;

import astnodes.ASTNode;

public class BasicBlock {

	List<ASTNode> statements = new LinkedList<ASTNode>();
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
		if(statements.size() == 0 || statements.get(0) == null)
			return "";
		return statements.get(0).getEscapedCodeStr();
	}

	public String getType()
	{
		if(statements.size() == 0 || statements.get(0) == null)
			return "";
		return statements.get(0).getTypeAsString() + "BB";
	}

}
