package parsing.Functions.builder;

import java.util.EmptyStackException;
import java.util.Stack;

import ast.ASTNode;
import ast.c.statements.blockstarters.IfStatement;
import ast.logical.statements.CompoundStatement;
import ast.statements.blockstarters.DoStatement;
import ast.statements.blockstarters.TryStatement;

public class ShadowStack
{

	private Stack<StackItem> stack = new Stack<StackItem>();
	private Stack<ASTNode> itemStack;

	private class StackItem
	{

		public ASTNode parentCompound;
		public ASTNode ifOrDoOrTry;

		public StackItem(ASTNode item, ASTNode parent)
		{
			ifOrDoOrTry = item;
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
				|| statementItem instanceof DoStatement
				|| statementItem instanceof TryStatement)
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
		return (IfStatement) returnItem.ifOrDoOrTry;
	}

	public IfStatement getIf()
	{
		IfStatement retval;
		StackItem item = null;

		try
		{
			item = stack.pop();
			retval = (IfStatement) item.ifOrDoOrTry;
		} catch (EmptyStackException ex)
		{
			return null;
		} catch (ClassCastException ex)
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
			retval = (DoStatement) item.ifOrDoOrTry;

			if (itemStack.contains(retval))
			{
				stack.push(item);
				return null;
			}

		} catch (EmptyStackException ex)
		{
			return null;
		} catch (ClassCastException ex)
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

	public TryStatement getTry()
	{
		TryStatement retval;
		StackItem item = null;

		try
		{
			// keep try statement on stack for further catch expressions
			item = stack.peek();
			retval = (TryStatement) item.ifOrDoOrTry;

			if (itemStack.contains(retval))
			{
				stack.push(item);
				return null;
			}

		} catch (EmptyStackException ex)
		{
			return null;
		} catch (ClassCastException ex)
		{
			stack.push(item);
			return null;
		}

		return retval;
	}

}
