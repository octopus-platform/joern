package main.codeitems.functionContent.builders;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import antlr.FineFunctionGrammarParser.Assign_exprContext;
import antlr.FineFunctionGrammarParser.Block_starterContext;
import antlr.FineFunctionGrammarParser.Closing_curlyContext;
import antlr.FineFunctionGrammarParser.ConditionContext;
import antlr.FineFunctionGrammarParser.Conditional_expressionContext;
import antlr.FineFunctionGrammarParser.Else_statementContext;
import antlr.FineFunctionGrammarParser.ExprContext;
import antlr.FineFunctionGrammarParser.Expr_statementContext;
import antlr.FineFunctionGrammarParser.If_statementContext;
import antlr.FineFunctionGrammarParser.Opening_curlyContext;
import antlr.FineFunctionGrammarParser.StatementContext;
import antlr.FineFunctionGrammarParser.StatementsContext;

import main.codeitems.CodeItem;
import main.codeitems.expressions.AssignmentExpr;
import main.codeitems.expressions.ExpressionItem;
import main.codeitems.functionContent.BlockStarterItem;
import main.codeitems.functionContent.CloseBlockItem;
import main.codeitems.functionContent.CompoundItem;
import main.codeitems.functionContent.ElseItem;
import main.codeitems.functionContent.ExprStatementItem;
import main.codeitems.functionContent.IfItem;

public class FineFunctionContentBuilder extends FunctionContentBuilder
{
	
	public void exitStatements(StatementsContext ctx)
	{
		if(itemStack.size() != 1)
			throw new RuntimeException("Broken stack while parsing");
	
		consolidateIfElse(rootItem);
	}
	
	public void enterStatement(StatementContext ctx)
	{
		CodeItem statementItem = new CodeItem();
		statementItem.initializeFromContext(ctx);
		itemStack.push(statementItem);
	}
	
	public void enterBlockStarter(Block_starterContext ctx)
	{
		replaceTopOfStack(new BlockStarterItem());
	}

	public void enterExpression(ExprContext ctx)
	{
		ExpressionItem expression = new ExpressionItem();
		expression.initializeFromContext(ctx);
		itemStack.push(expression);
	}

	public void exitExpression(ExprContext ctx)
	{
		ExpressionItem expression = (ExpressionItem) itemStack.pop();
		
		CodeItem topOfStack = itemStack.peek();
		if(topOfStack instanceof BlockStarterItem)
			((BlockStarterItem) topOfStack).setCondition(expression);
		else if (topOfStack instanceof ExprStatementItem){
			((ExprStatementItem) topOfStack).expr = expression;
		}else if (topOfStack instanceof ExpressionItem){
			((ExpressionItem) topOfStack).addSubExpression(expression);
		}
	}
	
	public void enterAssignment(Assign_exprContext ctx)
	{
		if(ctx.assignment_operator().size() == 0)
			return;
		
		ExpressionItem expr = createAssignmentExprFromContext(ctx);
		replaceTopOfStack(expr);
	}

	private ExpressionItem createAssignmentExprFromContext(
			Assign_exprContext ctx)
	{
		
		AssignmentExpr assignExpr = new AssignmentExpr();
		
		List<Conditional_expressionContext> vals = ctx.conditional_expression();
		ListIterator<Conditional_expressionContext> it = vals.listIterator(vals.size());
		
		
		// There must be at least a right-most value since the 
		// assignment-operator was matched
		
		Conditional_expressionContext rvalExpr = it.previous();
		while(it.hasPrevious()){
			Conditional_expressionContext lvalExpr = it.previous();
			assignExpr.addAssignment(lvalExpr, rvalExpr);
		}
		
		return assignExpr;
	}
	
	public void enterIf(If_statementContext ctx)
	{
		replaceTopOfStack(new IfItem());
	}
	
	public void enterElse(Else_statementContext ctx)
	{
		replaceTopOfStack(new ElseItem());
	}

	public void enterOpeningCurly(Opening_curlyContext ctx)
	{
		replaceTopOfStack(new CompoundItem());
	}
	
	public void enterClosingCurly(Closing_curlyContext ctx)
	{
		replaceTopOfStack(new CloseBlockItem());
	}
	
	public void exitStatement(StatementContext ctx)
	{
		if(itemStack.size() == 0)
			throw new RuntimeException();
	
		CodeItem itemToRemove = itemStack.peek();
		
		if(itemToRemove instanceof CloseBlockItem){
			closeCompoundStatement();
			return;
		}
		
		// We keep Block-starters and compound items
		// on the stack. They are removed by following
		// statements.
		if(itemToRemove instanceof BlockStarterItem ||
		   itemToRemove instanceof CompoundItem)
			return;
		
		consolidate();	
	}

	private void closeCompoundStatement()
	{
		itemStack.pop(); // remove 'CloseBlock'
		
		CompoundItem compoundItem = (CompoundItem) itemStack.pop();
		consolidateIfElse(compoundItem);
		consolidateBlockStarters(compoundItem);		
	}
	
	private void consolidateIfElse(CompoundItem compoundItem)
	{
		Iterator<CodeItem> it = compoundItem.statements.iterator();
		CodeItem prev = null;
		while(it.hasNext()){
			
			CodeItem cur = it.next();
			if(prev != null && cur instanceof ElseItem){
				if(prev instanceof IfItem){
					IfItem ifItem = (IfItem) prev;
					ifItem.elseItem = (ElseItem) cur;
					it.remove();
				}
			}
			prev = cur;
		}
	}

	private void consolidateBlockStarters(CodeItem topOfStack)
	{
		while(true){
			try{
				BlockStarterItem bItem = (BlockStarterItem) itemStack.peek();
				bItem = (BlockStarterItem) itemStack.pop();
				bItem.setStatement(topOfStack);
				topOfStack = bItem;
			}catch(ClassCastException ex){
				break;
			}
		}
		CompoundItem root = (CompoundItem) itemStack.peek();
		root.addStatement(topOfStack);
	}
	
	private void consolidate()
	{
		
		CodeItem stmt = itemStack.pop();
		CodeItem topOfStack = null;
		
		if(itemStack.size() > 0)
			topOfStack = itemStack.peek();
		
		if(topOfStack instanceof CompoundItem){
			CompoundItem compound = (CompoundItem)topOfStack;
			compound.addStatement(stmt);
		}else{
			consolidateBlockStarters(topOfStack);
		}
		
	}

	public void enterExprStatement(Expr_statementContext ctx)
	{
		replaceTopOfStack(new ExprStatementItem());
	}
	
}