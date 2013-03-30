package main.codeitems.functionContent.builders;

import java.util.Iterator;

import org.antlr.v4.runtime.ParserRuleContext;

import antlr.FineFunctionGrammarParser.Assign_exprContext;
import antlr.FineFunctionGrammarParser.Block_starterContext;
import antlr.FineFunctionGrammarParser.Closing_curlyContext;

import antlr.FineFunctionGrammarParser.And_expressionContext;
import antlr.FineFunctionGrammarParser.Bit_and_expressionContext;
import antlr.FineFunctionGrammarParser.Conditional_expressionContext;
import antlr.FineFunctionGrammarParser.Else_statementContext;
import antlr.FineFunctionGrammarParser.Equality_expressionContext;
import antlr.FineFunctionGrammarParser.Exclusive_or_expressionContext;
import antlr.FineFunctionGrammarParser.ExprContext;
import antlr.FineFunctionGrammarParser.Expr_statementContext;
import antlr.FineFunctionGrammarParser.If_statementContext;
import antlr.FineFunctionGrammarParser.Inclusive_or_expressionContext;
import antlr.FineFunctionGrammarParser.Opening_curlyContext;
import antlr.FineFunctionGrammarParser.Or_expressionContext;
import antlr.FineFunctionGrammarParser.StatementContext;
import antlr.FineFunctionGrammarParser.StatementsContext;

import main.codeitems.CodeItem;
import main.codeitems.expressions.AndExpression;
import main.codeitems.expressions.AssignmentExpr;
import main.codeitems.expressions.BinaryExpression;
import main.codeitems.expressions.BitAndExpression;
import main.codeitems.expressions.ConditionalExpression;
import main.codeitems.expressions.EqualityExpression;
import main.codeitems.expressions.ExclusiveOrExpression;
import main.codeitems.expressions.Expression;
import main.codeitems.expressions.InclusiveOrExpression;
import main.codeitems.expressions.OrExpression;
import main.codeitems.functionContent.BlockStarterItem;
import main.codeitems.functionContent.CloseBlockItem;
import main.codeitems.functionContent.CompoundItem;
import main.codeitems.functionContent.ElseItem;
import main.codeitems.functionContent.ExprStatementItem;
import main.codeitems.functionContent.IfItem;

public class FineFunctionContentBuilder extends FunctionContentBuilder
{
	
	// exitStatements is called when the entire
	// function-content has been walked
	
	public void exitStatements(StatementsContext ctx)
	{
		if(itemStack.size() != 1)
			throw new RuntimeException("Broken stack while parsing");
	
		consolidateIfElse(rootItem);
	}
	
	// For all statements, begin by pushing a CodeItem
	// onto the stack. Once we have implemented
	// handling for all statement types, this can
	// be removed
	
	public void enterStatement(StatementContext ctx)
	{
		CodeItem statementItem = new CodeItem();
		statementItem.initializeFromContext(ctx);
		itemStack.push(statementItem);
	}
	
	// Mapping of grammar-rules to CodeItems.
	
	public void enterOpeningCurly(Opening_curlyContext ctx)
	{
		replaceTopOfStack(new CompoundItem());
	}
	
	public void enterClosingCurly(Closing_curlyContext ctx)
	{
		replaceTopOfStack(new CloseBlockItem());
	}
	
	public void enterBlockStarter(Block_starterContext ctx)
	{
		replaceTopOfStack(new BlockStarterItem());
	}

	// TODO: Still missing:
	// jump-statement, simple-decl, label, water
	
	public void enterExprStatement(Expr_statementContext ctx)
	{
		replaceTopOfStack(new ExprStatementItem());
	}
	
	public void enterIf(If_statementContext ctx)
	{
		replaceTopOfStack(new IfItem());
	}
	
	public void enterElse(Else_statementContext ctx)
	{
		replaceTopOfStack(new ElseItem());
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
	
	// Scans a compoundItem for sequences of if-/else.
	// When found attaches else to if.
	
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

	// Joins consecutive BlockStarters on the stack
	
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
	

	// Expression handling
	
	public void enterExpression(ExprContext ctx)
	{
		Expression expression = new Expression();
		itemStack.push(expression);
	}

	public void exitExpression(ExprContext ctx)
	{
		consolidateSubExpression(ctx);
	}

	public void enterAssignment(Assign_exprContext ctx)
	{	
		AssignmentExpr expr = new AssignmentExpr();
		itemStack.push(expr);
	}
	
	public void exitAssignment(Assign_exprContext ctx)
	{
		consolidateSubExpression(ctx);
	}

	public void enterConditionalExpr(Conditional_expressionContext ctx)
	{
		ConditionalExpression expr = new ConditionalExpression();
		itemStack.push(expr);
	}

	public void exitConditionalExpr(Conditional_expressionContext ctx)
	{
		consolidateSubExpression(ctx);
	}

	public void enterOrExpression(Or_expressionContext ctx)
	{
		OrExpression expr = new OrExpression();
		itemStack.push(expr);
	}

	public void exitrOrExpression(Or_expressionContext ctx)
	{
		consolidateSubExpression(ctx);
	}
	
	public void enterAndExpression(And_expressionContext ctx)
	{
		AndExpression expr = new AndExpression();
		itemStack.push(expr);
	}

	public void exitAndExpression(And_expressionContext ctx)
	{
		consolidateSubExpression(ctx);
	}

	public void enterInclusiveOrExpression(Inclusive_or_expressionContext ctx)
	{
		InclusiveOrExpression expr = new InclusiveOrExpression();
		itemStack.push(expr);
	}

	public void exitInclusiveOrExpression(Inclusive_or_expressionContext ctx)
	{
		consolidateSubExpression(ctx);
	}

	public void enterExclusiveOrExpression(Exclusive_or_expressionContext ctx)
	{
		ExclusiveOrExpression expr = new ExclusiveOrExpression();
		itemStack.push(expr);
	}

	public void exitExclusiveOrExpression(Exclusive_or_expressionContext ctx)
	{
		consolidateSubExpression(ctx);
	}
	
	public void enterBitAndExpression(Bit_and_expressionContext ctx)
	{
		BitAndExpression expr = new BitAndExpression();
		itemStack.push(expr);
	}

	public void enterEqualityExpression(Equality_expressionContext ctx)
	{
		EqualityExpression expr = new EqualityExpression();
		itemStack.push(expr);
	}

	public void exitEqualityExpression(Equality_expressionContext ctx)
	{
		consolidateSubExpression(ctx);
	}

	
	public void exitBitAndExpression(Bit_and_expressionContext ctx)
	{
		consolidateSubExpression(ctx);
	}	
	
	private void consolidateSubExpression(ParserRuleContext ctx)
	{
		Expression expression = (Expression) itemStack.pop();
		
		if(expression.getChildCount() == 1)
			expression = expression.getChild(0);
		
		expression.initializeFromContext(ctx);
		consolidateExpression(expression);
	}

	private void consolidateExpression(Expression expression)
	{
		CodeItem topOfStack = itemStack.peek();
		if(topOfStack instanceof BlockStarterItem)
			((BlockStarterItem) topOfStack).setCondition(expression);
		else if (topOfStack instanceof ExprStatementItem){
			((ExprStatementItem) topOfStack).expr = expression;
		}else if (topOfStack instanceof Expression){
			((Expression) topOfStack).addChildExpression(expression);
		}
	}
}