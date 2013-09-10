package astnodes.builders;

import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;

import antlr.FunctionParser.Type_nameContext;
import astnodes.ASTNode;
import astnodes.ASTNodeBuilder;
import astnodes.declarations.IdentifierDecl;
import astnodes.expressions.Expression;
import astnodes.statements.BlockStarter;
import astnodes.statements.CompoundStatement;
import astnodes.statements.DoStatement;
import astnodes.statements.ElseStatement;
import astnodes.statements.ExpressionHolder;
import astnodes.statements.IdentifierDeclStatement;
import astnodes.statements.IfStatement;
import astnodes.statements.Statement;
import astnodes.statements.WhileStatement;

public class FunctionContentBuilder extends ASTNodeBuilder
{
	Stack<ASTNode> itemStack = new Stack<ASTNode>();
	CompoundStatement rootItem;
	IfStatement lastIf;
	DoStatement lastDo;
	
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

	public void enterDeclByType(ParserRuleContext ctx, Type_nameContext type_nameContext)
	{
		IdentifierDeclStatement declStmt = new IdentifierDeclStatement();
		declStmt.initializeFromContext(ctx);
		declStmt.setTypeNameContext(type_nameContext);
		
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
			
				if(bItem instanceof IfStatement){
					
					if(itemStack.size() > 0 && itemStack.peek() instanceof ElseStatement){
						
						BlockStarter elseItem = (BlockStarter) itemStack.pop();
						elseItem.addChild(bItem);
					
						if(lastIf != null)
							lastIf.setElseNode((ElseStatement) elseItem);
						
						stmt = elseItem;
						// save a pointer to the last IfStatement
						lastIf = (IfStatement) bItem;
						return;
					}
					// save a pointer to the last IfStatement
					lastIf = (IfStatement) bItem;
				}else if(bItem instanceof DoStatement){
					// save a pointer to the last DoStatement
					lastDo = (DoStatement) bItem;
				}else if(bItem instanceof ElseStatement){
					// add else statement to the previous if-statement,
					// which has already been consolidated so we can return
					if(lastIf != null)
						lastIf.setElseNode((ElseStatement) bItem);
					lastIf = null;
					return;
				}else if(bItem instanceof WhileStatement){
					// add while statement to the previous do-statement
					// if that exists. Otherwise, do nothing special.
					if(lastDo != null){
						lastDo.addChild( ((WhileStatement) bItem).getCondition() );
						lastDo = null;
						return;
					}
				}
				
			}catch(ClassCastException ex){
				break;
			}
		}
		// Finally, add chain to top compound-item
		ASTNode root = itemStack.peek();
		root.addChild(stmt);
	}
	
}
