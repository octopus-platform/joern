package main.codeitems.builders;

import java.util.Stack;

import main.codeitems.CodeItem;
import main.codeitems.CodeItemBuilder;
import main.codeitems.declarations.IdentifierDecl;
import main.codeitems.expressions.Expression;
import main.codeitems.statements.BlockStarterItem;
import main.codeitems.statements.CompoundItem;
import main.codeitems.statements.Condition;
import main.codeitems.statements.ExprStatementItem;
import main.codeitems.statements.ExpressionHolder;
import main.codeitems.statements.IdentifierDeclStatement;
import main.codeitems.statements.Statement;

import org.antlr.v4.runtime.ParserRuleContext;

import antlr.CoarseFunctionGrammarParser.Type_nameContext;

public class FunctionContentBuilder extends CodeItemBuilder
{
	Stack<CodeItem> itemStack = new Stack<CodeItem>();
	CompoundItem rootItem;
	
	@Override
	public void createNew(ParserRuleContext ctx)
	{
		item = new CompoundItem();
		rootItem = (CompoundItem) item;
		item.initializeFromContext(ctx);
		itemStack.push(rootItem);
	}

	public void addLocalDecl(IdentifierDecl decl)
	{
		IdentifierDeclStatement declStmt = (IdentifierDeclStatement) itemStack.peek();
		declStmt.addChild(decl);
	}

	public void enterDeclByType(ParserRuleContext ctx)
	{
		IdentifierDeclStatement declStmt = new IdentifierDeclStatement();
		declStmt.setTypeNameContext(ctx);
		if(itemStack.peek() instanceof Statement)
			replaceTopOfStack(declStmt);
		else
			itemStack.push(declStmt);
	}
	
	public void exitDeclByType()
	{
		consolidate();
	}
	
	protected void replaceTopOfStack(CodeItem item)
	{
		itemStack.pop();
		itemStack.push(item);
	}
	
	protected void consolidateSubExpression(ParserRuleContext ctx)
	{
		Expression expression = (Expression) itemStack.pop();
		expression = pullUpOnlyChild(expression);
		expression.initializeFromContext(ctx);
		addItemToParent(expression);
	}

	private Expression pullUpOnlyChild(Expression expression)
	{
		if(expression.getChildCount() == 1)
			expression = (Expression) expression.getChild(0);
		return expression;
	}

	protected void addItemToParent(CodeItem expression)
	{
		CodeItem topOfStack = itemStack.peek();
		topOfStack.addChild(expression);
	}
	
	protected void consolidate()
	{
		
		CodeItem stmt = itemStack.pop();
		CodeItem topOfStack = null;
		
		if(itemStack.size() > 0)
			topOfStack = itemStack.peek();
		
		if(topOfStack instanceof CompoundItem){
			CompoundItem compound = (CompoundItem)topOfStack;
			compound.addStatement(stmt);
		}else{
			consolidateBlockStarters(stmt);
		}
		
	}
	
	// Joins consecutive BlockStarters on the stack
	
	protected void consolidateBlockStarters(CodeItem stmt)
	{
		
		while(true){
			try{
				BlockStarterItem bItem = (BlockStarterItem) itemStack.peek();
				bItem = (BlockStarterItem) itemStack.pop();
				bItem.addChild(stmt);
				stmt = bItem;
			}catch(ClassCastException ex){
				break;
			}
		}
		// Finally, add chain to top compound-item
		CompoundItem root = (CompoundItem) itemStack.peek();
		root.addStatement(stmt);
	}
	
}
