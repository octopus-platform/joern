package ast.statements;

import java.util.LinkedList;
import java.util.List;

import ast.ASTNode;
import ast.walking.ASTNodeVisitor;

public class TryStatement extends BlockStarter
{

	private List<CatchStatement> catchNodes = new LinkedList<CatchStatement>();

	public void addCatchNode(CatchStatement catchNode)
	{
		getCatchNodes().add(catchNode);
	}

	public List<CatchStatement> getCatchNodes()
	{
		return this.catchNodes;
	}

	public CatchStatement getCatchNode(int index)
	{
		return getCatchNodes().get(index);
	}

	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}

	public int getChildCount()
	{
		return super.getChildCount() + getCatchNodes().size();
	}

	public ASTNode getChild(int i)
	{
		if (i == 0)
			return getStatement();
		else
			try
			{
				return getCatchNode(i - 1);
			}
			catch (IndexOutOfBoundsException e)
			{
				throw new RuntimeException(
						"Invalid child number for try statement");
			}
	}

}
