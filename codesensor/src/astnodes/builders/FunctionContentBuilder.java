package astnodes.builders;

import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;


import astnodes.ASTNode;
import astnodes.ASTNodeBuilder;
import astnodes.declarations.IdentifierDecl;
import astnodes.expressions.Expression;
import astnodes.statements.BlockStarter;
import astnodes.statements.CompoundStatement;
import astnodes.statements.ExpressionHolder;
import astnodes.statements.ForInit;
import astnodes.statements.ForStatement;
import astnodes.statements.IdentifierDeclStatement;
import astnodes.statements.Statement;

public class FunctionContentBuilder extends ASTNodeBuilder
{
	Stack<ASTNode> itemStack = new Stack<ASTNode>();
	CompoundStatement rootItem;
	
	@Override
	public void createNew(ParserRuleContext ctx)
	{
		item = new CompoundStatement();
		rootItem = (CompoundStatement) item;
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
		declStmt.initializeFromContext(ctx);
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
		expression.initializeFromContext(ctx);
		if(!(expression instanceof ExpressionHolder))
			expression = pullUpOnlyChild(expression);
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
		
		if(topOfStack instanceof CompoundStatement){
			CompoundStatement compound = (CompoundStatement)topOfStack;
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
				BlockStarter bItem = (BlockStarter) itemStack.peek();
				bItem = (BlockStarter) itemStack.pop();
				bItem.addChild(stmt);
				stmt = bItem;
			}catch(ClassCastException ex){
				break;
			}
		}
		// Finally, add chain to top compound-item
		ASTNode root = itemStack.peek();
		root.addChild(stmt);
	}
	
}
