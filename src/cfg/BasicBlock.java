package cfg;

import java.util.LinkedList;
import java.util.List;

import astnodes.ASTNode;

public class BasicBlock {

	List<ASTNode> statements = new LinkedList<ASTNode>();

	// FIXME: Only needed by neo4j-writer
	public long id = -1;
	
	public void appendNode(ASTNode node)
	{
		statements.add(node);
	}

	public List<ASTNode> getStatements()
	{
		return statements;
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
