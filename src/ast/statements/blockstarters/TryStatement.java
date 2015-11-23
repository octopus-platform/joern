package ast.statements.blockstarters;

import java.util.LinkedList;
import java.util.List;

import ast.ASTNode;
import ast.logical.statements.BlockStarter;
import ast.logical.statements.CompoundStatement;
import ast.walking.ASTNodeVisitor;

public class TryStatement extends BlockStarter
{
	private CompoundStatement content = null;
	private CatchList catchList = null;
	private CompoundStatement finallyContent = null;
	
	public CompoundStatement getContent()
	{
		return this.content;
	}
	
	public void setContent(CompoundStatement content)
	{
		this.content = content;
		super.addChild(content);
	}
	
	public CatchList getCatchList()
	{
		return this.catchList;
	}
	
	public void setCatchList(CatchList catchList)
	{
		this.catchList = catchList;
		super.addChild(catchList);
	}
	
	public CompoundStatement getFinallyContent()
	{
		return this.finallyContent;
	}
	
	public void setFinallyContent(CompoundStatement finallyContent)
	{
		this.finallyContent = finallyContent;
		super.addChild(finallyContent);
	}
	
	@Override
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
	
	/*
	 * TODO the fields catchNodes as well as the associated methods below should
	 * be removed. It would be best for the outer world to only use getCatchList()
	 * above, and use whatever methods the class CatchList offers, instead of having
	 * the following methods handle catch nodes directly.
	 */
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

	/*
	 * TODO exactly as with IfStatement which also overrides the
	 * methods getChildCount() and getChild(int), the following two
	 * overrides should be moved to an extending class CTryStatement or
	 * similar since their behavior is inconsistent with the usual behavior
	 * of these methods in ASTNode and confuses PHP world. What's worse, in
	 * this case I cannot even create a PHPTryStatement that extends TryStatement
	 * as there is no good reason for this except to restore the original behavior
	 * of these methods, but that would be the wrong way to go about it (rather,
	 * CTryStatement should override them on its own if it needs to.)
	 * See comments in PHPIfStatement.
	 */
	
	@Override
	public int getChildCount()
	{
		return super.getChildCount() + getCatchNodes().size();
	}

	@Override
	public ASTNode getChild(int i)
	{
		if (i == 0)
			return getStatement();
		else
			try
			{
				return getCatchNode(i - 1);
			} catch (IndexOutOfBoundsException e)
			{
				throw new RuntimeException(
						"Invalid child number for try statement");
			}
	}

}
