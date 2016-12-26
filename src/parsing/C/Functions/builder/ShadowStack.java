package parsing.C.Functions.builder;

import java.util.EmptyStackException;
import java.util.Stack;

import ast.ASTNode;
import ast.statements.CompoundStatement;
import ast.statements.DoStatement;
import ast.statements.IfStatement;

public class ShadowStack
{

	private Stack<StackItem> stack = new Stack<StackItem>();
	private Stack<ASTNode> itemStack;

	private class StackItem
	{

		public ASTNode parentCompound;
		public ASTNode ifOrDo;

		public StackItem(ASTNode item, ASTNode parent)
		{
			ifOrDo = item;
			parentCompound = parent;
		}

	}

	public ShadowStack(Stack<ASTNode> aItemStack)
	{
		itemStack = aItemStack;
	}

	public void push(ASTNode statementItem)
	{
		if (statementItem instanceof IfStatement
				|| statementItem instanceof DoStatement)
		{
			ASTNode parentCompound = parentCompoundFromItemStack(itemStack);

			stack.push(new StackItem(statementItem, parentCompound));
		}
	}

	public void pop()
	{
		ASTNode topOfItemStack = itemStack.peek();

		while (stack.size() > 0
				&& stack.peek().parentCompound == topOfItemStack)
		{
			stack.pop();
		}
	}

	public IfStatement getIfInElseCase()
	{
		if (stack.size() < 2)
			return null;

		StackItem topItem = stack.pop();
		StackItem returnItem = stack.pop();
		stack.push(topItem);
		return (IfStatement) returnItem.ifOrDo;
	}

	public IfStatement getIf()
	{
		IfStatement retval;
		StackItem item = null;

		try
		{
			item = stack.pop();
			retval = (IfStatement) item.ifOrDo;
		}
		catch (EmptyStackException ex)
		{
			return null;
		}
		catch (ClassCastException ex)
		{
			stack.push(item);
			return null;
		}

		return retval;
	}

	public DoStatement getDo()
	{
		DoStatement retval;
		StackItem item = null;

		try
		{
			item = stack.pop();
			retval = (DoStatement) item.ifOrDo;

			if (itemStack.contains(retval))
			{
				stack.push(item);
				return null;
			}

		}
		catch (EmptyStackException ex)
		{
			return null;
		}
		catch (ClassCastException ex)
		{
			stack.push(item);
			return null;
		}

		return retval;
	}

	private ASTNode parentCompoundFromItemStack(Stack<ASTNode> itemStack)
	{
		// Watchout: we are assuming that this function is never
		// called when 0 compound statements are on the stack.
		// If this ever happens, null is returned.

		ASTNode parentCompound = null;
		// walk stack from top to bottom
		for (int i = itemStack.size() - 1; i >= 0; i--)
		{
			if (itemStack.get(i) instanceof CompoundStatement)
			{
				parentCompound = itemStack.get(i);
				break;
			}
		}
		return parentCompound;
	}

}
