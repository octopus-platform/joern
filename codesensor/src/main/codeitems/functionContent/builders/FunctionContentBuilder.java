package main.codeitems.functionContent.builders;

import java.util.Stack;

import main.codeitems.CodeItem;
import main.codeitems.CodeItemBuilder;
import main.codeitems.declarations.IdentifierDecl;
import main.codeitems.expressions.Expression;
import main.codeitems.functionContent.BlockStarterItem;
import main.codeitems.functionContent.CompoundItem;
import main.codeitems.functionContent.ExprStatementItem;
import main.codeitems.functionContent.IdentifierDeclStatement;

import org.antlr.v4.runtime.ParserRuleContext;

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
		declStmt.addDeclaration(decl);
	}

	public void enterDeclByType()
	{
		replaceTopOfStack(new IdentifierDeclStatement());
	}
	
	protected void replaceTopOfStack(CodeItem item)
	{
		itemStack.pop();
		itemStack.push(item);
	}
	
	protected void consolidateSubExpression(ParserRuleContext ctx)
	{
		Expression expression = (Expression) itemStack.pop();
		
		if(expression.getChildCount() == 1)
			expression = expression.getChild(0);
		
		expression.initializeFromContext(ctx);
		consolidateExpression(expression);
	}

	protected void consolidateExpression(Expression expression)
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
			consolidateBlockStarters(topOfStack);
		}
		
	}
	
	// Joins consecutive BlockStarters on the stack
	
	protected void consolidateBlockStarters(CodeItem topOfStack)
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
	
}
