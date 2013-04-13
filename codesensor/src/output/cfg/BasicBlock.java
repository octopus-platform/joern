package output.cfg;

import java.util.LinkedList;
import java.util.List;

import astnodes.ASTNode;

public class BasicBlock {

	List<ASTNode> statements = new LinkedList<ASTNode>();
	
	public void appendNode(ASTNode node)
	{
		statements.add(node);
	}

	public List<ASTNode> getStatements()
	{
		return statements;
	}

}
