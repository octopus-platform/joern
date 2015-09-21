package languages.c.parsing.Functions.builder;

import org.antlr.v4.runtime.ParserRuleContext;

import ast.ASTNode;
import ast.expressions.Expression;
import ast.logical.statements.BlockStarter;
import ast.logical.statements.CompoundStatement;
import ast.statements.ExpressionHolder;
import ast.statements.blockstarters.CatchStatement;
import ast.statements.blockstarters.DoStatement;
import ast.statements.blockstarters.ElseStatement;
import ast.statements.blockstarters.IfStatement;
import ast.statements.blockstarters.TryStatement;
import ast.statements.blockstarters.WhileStatement;
import languages.c.parsing.ASTNodeFactory;

public class NestingReconstructor
{

	ContentBuilderStack stack;

	public NestingReconstructor(ContentBuilderStack aStack)
	{
		stack = aStack;
	}

	protected void addItemToParent(ASTNode expression)
	{
		ASTNode topOfStack = stack.peek();
		topOfStack.addChild(expression);
	}

	protected void consolidateSubExpression(ParserRuleContext ctx)
	{
		Expression expression = (Expression) stack.pop();
		ASTNodeFactory.initializeFromContext(expression, ctx);
		if (!(expression instanceof ExpressionHolder))
			expression = pullUpOnlyChild(expression);
		addItemToParent(expression);
	}

	private Expression pullUpOnlyChild(Expression expression)
	{
		if (expression.getChildCount() == 1)
			expression = (Expression) expression.getChild(0);
		return expression;
	}

	protected void consolidate()
	{

		ASTNode stmt = stack.pop();
		ASTNode topOfStack = null;

		if (stack.size() > 0)
			topOfStack = stack.peek();

		if (topOfStack instanceof CompoundStatement)
		{
			CompoundStatement compound = (CompoundStatement) topOfStack;
			compound.addStatement(stmt);
		} else
		{
			consolidateBlockStarters(stmt);
		}

	}

	// Joins consecutive BlockStarters on the stack

	protected void consolidateBlockStarters(ASTNode node)
	{
		while (true)
		{
			try
			{
				BlockStarter curBlockStarter = (BlockStarter) stack.peek();
				curBlockStarter = (BlockStarter) stack.pop();
				curBlockStarter.addChild(node);
				node = curBlockStarter;

				if (curBlockStarter instanceof IfStatement)
				{

					if (stack.size() > 0
							&& stack.peek() instanceof ElseStatement)
					{
						// This is an if inside an else, e.g., 'else if'
						// handling

						BlockStarter elseItem = (BlockStarter) stack.pop();
						elseItem.addChild(curBlockStarter);

						IfStatement lastIf = (IfStatement) stack
								.getIfInElseCase();
						if (lastIf != null)
						{
							lastIf.setElseNode((ElseStatement) elseItem);
						}

						return;
					}

				} else if (curBlockStarter instanceof ElseStatement)
				{
					// add else statement to the previous if-statement,
					// which has already been consolidated so we can return

					IfStatement lastIf = (IfStatement) stack.getIf();
					if (lastIf != null)
						lastIf.setElseNode((ElseStatement) curBlockStarter);
					else
						throw new RuntimeException(
								"Warning: cannot find if for else");

					return;
				} else if (curBlockStarter instanceof WhileStatement)
				{
					// add while statement to the previous do-statement
					// if that exists. Otherwise, do nothing special.

					DoStatement lastDo = stack.getDo();
					if (lastDo != null)
					{
						lastDo.addChild(((WhileStatement) curBlockStarter)
								.getCondition());
						return;
					}
				} else if (curBlockStarter instanceof CatchStatement)
				{
					TryStatement tryStatement = (TryStatement) stack.getTry();
					if (tryStatement != null)
					{
						tryStatement
								.addCatchNode((CatchStatement) curBlockStarter);
					} else
						throw new RuntimeException(
								"Warning: cannot find try for catch");

					return;
				}

			} catch (ClassCastException ex)
			{
				break;
			}
		}
		// Finally, add chain to top compound-item
		ASTNode root = stack.peek();
		root.addChild(node);
	}
}
