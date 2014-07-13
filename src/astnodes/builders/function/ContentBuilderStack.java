package astnodes.builders.function;

import java.util.Stack;

import astnodes.ASTNode;
import astnodes.statements.DoStatement;
import astnodes.statements.IfStatement;

public class ContentBuilderStack
{
	private Stack<ASTNode> itemStack = new Stack<ASTNode>();
	private ShadowStack shadowStack = new ShadowStack(itemStack);

	public void push(ASTNode statementItem)
	{
		shadowStack.push(statementItem);
		itemStack.push(statementItem);
	}

	public ASTNode pop()
	{
		shadowStack.pop();
		return itemStack.pop();
	}

	public int size()
	{
		return itemStack.size();
	}

	public ASTNode peek()
	{
		return itemStack.peek();
	}

	public IfStatement getIfInElseCase()
	{
		return shadowStack.getIfInElseCase();
	}

	public IfStatement getIf()
	{
		return shadowStack.getIf();
	}

	public DoStatement getDo()
	{
		return shadowStack.getDo();
	}
}
