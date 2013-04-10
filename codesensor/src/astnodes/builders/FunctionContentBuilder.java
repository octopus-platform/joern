package astnodes.builders;

import java.util.Stack;


import org.antlr.v4.runtime.ParserRuleContext;

import antlr.CoarseFunctionGrammarParser.Type_nameContext;
import astnodes.ASTNode;
import astnodes.ASTNodeBuilder;
import astnodes.declarations.IdentifierDecl;
import astnodes.expressions.Expression;
import astnodes.statements.BlockStarterItem;
import astnodes.statements.CompoundItem;
import astnodes.statements.Condition;
import astnodes.statements.ExprStatementItem;
import astnodes.statements.ExpressionHolder;
import astnodes.statements.IdentifierDeclStatement;
import astnodes.statements.Statement;

public class FunctionContentBuilder extends ASTNodeBuilder
{
	Stack<ASTNode> itemStack = new Stack<ASTNode>();
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
	
	protected void replaceTopOfStack(ASTNode item)
	{
		itemStack.pop();
		itemStack.push(item);
	}
	
	protected void consolidateSubExpression(ParserRuleContext ctx)
	{
		Expression expression = (Expression) itemStack.pop();
		if(!(expression instanceof ExpressionHolder))
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

	protected void addItemToParent(ASTNode expression)
	{
		ASTNode topOfStack = itemStack.peek();
		topOfStack.addChild(expression);
	}
	
	protected void consolidate()
	{
		
		ASTNode stmt = itemStack.pop();
		ASTNode topOfStack = null;
		
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
	
	protected void consolidateBlockStarters(ASTNode stmt)
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
