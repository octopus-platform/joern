package astnodes.builders;

import java.util.Iterator;

import org.antlr.v4.runtime.ParserRuleContext;

import parsing.InitDeclContextWrapper;


import antlr.FineFunctionGrammarParser.Additive_expressionContext;
import antlr.FineFunctionGrammarParser.And_expressionContext;
import antlr.FineFunctionGrammarParser.ArrayIndexingContext;
import antlr.FineFunctionGrammarParser.Assign_exprContext;
import antlr.FineFunctionGrammarParser.Bit_and_expressionContext;
import antlr.FineFunctionGrammarParser.Block_starterContext;
import antlr.FineFunctionGrammarParser.Cast_expressionContext;
import antlr.FineFunctionGrammarParser.Cast_targetContext;
import antlr.FineFunctionGrammarParser.Closing_curlyContext;
import antlr.FineFunctionGrammarParser.ConditionContext;
import antlr.FineFunctionGrammarParser.Conditional_expressionContext;
import antlr.FineFunctionGrammarParser.DeclByClassContext;
import antlr.FineFunctionGrammarParser.Else_statementContext;
import antlr.FineFunctionGrammarParser.Equality_expressionContext;
import antlr.FineFunctionGrammarParser.Exclusive_or_expressionContext;
import antlr.FineFunctionGrammarParser.ExprContext;
import antlr.FineFunctionGrammarParser.Expr_statementContext;
import antlr.FineFunctionGrammarParser.For_statementContext;
import antlr.FineFunctionGrammarParser.FuncCallContext;
import antlr.FineFunctionGrammarParser.Function_argumentContext;
import antlr.FineFunctionGrammarParser.Function_argument_listContext;
import antlr.FineFunctionGrammarParser.IdentifierContext;
import antlr.FineFunctionGrammarParser.If_statementContext;
import antlr.FineFunctionGrammarParser.IncDecOpContext;
import antlr.FineFunctionGrammarParser.Inc_decContext;
import antlr.FineFunctionGrammarParser.Inclusive_or_expressionContext;
import antlr.FineFunctionGrammarParser.Init_declaratorContext;
import antlr.FineFunctionGrammarParser.MemberAccessContext;
import antlr.FineFunctionGrammarParser.Multiplicative_expressionContext;
import antlr.FineFunctionGrammarParser.Opening_curlyContext;
import antlr.FineFunctionGrammarParser.Or_expressionContext;
import antlr.FineFunctionGrammarParser.Primary_expressionContext;
import antlr.FineFunctionGrammarParser.Relational_expressionContext;
import antlr.FineFunctionGrammarParser.Shift_expressionContext;
import antlr.FineFunctionGrammarParser.StatementContext;
import antlr.FineFunctionGrammarParser.StatementsContext;
import antlr.FineFunctionGrammarParser.Unary_expressionContext;
import astnodes.ASTNode;
import astnodes.declarations.ClassDef;
import astnodes.declarations.IdentifierDecl;
import astnodes.expressions.AdditiveExpression;
import astnodes.expressions.AndExpression;
import astnodes.expressions.Argument;
import astnodes.expressions.ArgumentList;
import astnodes.expressions.ArrayIndexing;
import astnodes.expressions.AssignmentExpr;
import astnodes.expressions.BitAndExpression;
import astnodes.expressions.CallExpression;
import astnodes.expressions.CastExpression;
import astnodes.expressions.CastTarget;
import astnodes.expressions.ConditionalExpression;
import astnodes.expressions.EqualityExpression;
import astnodes.expressions.ExclusiveOrExpression;
import astnodes.expressions.Expression;
import astnodes.expressions.Identifier;
import astnodes.expressions.IncDec;
import astnodes.expressions.IncDecOp;
import astnodes.expressions.InclusiveOrExpression;
import astnodes.expressions.MemberAccess;
import astnodes.expressions.MultiplicativeExpression;
import astnodes.expressions.OrExpression;
import astnodes.expressions.PrimaryExpression;
import astnodes.expressions.RelationalExpression;
import astnodes.expressions.ShiftExpression;
import astnodes.expressions.UnaryExpression;
import astnodes.statements.BlockStarter;
import astnodes.statements.BlockCloser;
import astnodes.statements.CompoundStatement;
import astnodes.statements.Condition;
import astnodes.statements.ElseStatement;
import astnodes.statements.ExprStatement;
import astnodes.statements.ForStatement;
import astnodes.statements.IdentifierDeclStatement;
import astnodes.statements.IfStatement;
import astnodes.statements.Statement;

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
		ASTNode statementItem = new Statement();
		statementItem.initializeFromContext(ctx);
		itemStack.push(statementItem);
	}
	
	// Mapping of grammar-rules to CodeItems.
	
	public void enterOpeningCurly(Opening_curlyContext ctx)
	{
		replaceTopOfStack(new CompoundStatement());
	}
	
	public void enterClosingCurly(Closing_curlyContext ctx)
	{
		replaceTopOfStack(new BlockCloser());
	}
	
	public void enterBlockStarter(Block_starterContext ctx)
	{
		replaceTopOfStack(new BlockStarter());
	}

	// TODO: Still missing:
	// jump-statement, simple-decl, label, water
	
	public void enterExprStatement(Expr_statementContext ctx)
	{
		replaceTopOfStack(new ExprStatement());
	}
	
	public void enterIf(If_statementContext ctx)
	{
		replaceTopOfStack(new IfStatement());
	}
	
	public void enterFor(For_statementContext ctx)
	{
		replaceTopOfStack(new ForStatement());
	}
	
	public void enterElse(Else_statementContext ctx)
	{
		replaceTopOfStack(new ElseStatement());
	}
	
	public void exitStatement(StatementContext ctx)
	{
		if(itemStack.size() == 0)
			throw new RuntimeException();
	
		ASTNode itemToRemove = itemStack.peek();
		
		if(itemToRemove instanceof BlockCloser){
			closeCompoundStatement();
			return;
		}
		
		// We keep Block-starters and compound items
		// on the stack. They are removed by following
		// statements.
		if(itemToRemove instanceof BlockStarter ||
		   itemToRemove instanceof CompoundStatement)
			return;
		
		consolidate();	
	}

	private void closeCompoundStatement()
	{
		itemStack.pop(); // remove 'CloseBlock'
		
		CompoundStatement compoundItem = (CompoundStatement) itemStack.pop();
		consolidateIfElse(compoundItem);
		consolidateBlockStarters(compoundItem);		
	}
	
	// Scans a compoundItem for sequences of if-/else.
	// When found attaches else to if.
	
	private void consolidateIfElse(CompoundStatement compoundItem)
	{
		Iterator<ASTNode> it = compoundItem.getStatements().iterator();
		ASTNode prev = null;
		while(it.hasNext()){
			
			ASTNode cur = it.next();
			if(prev != null && cur instanceof ElseStatement){
				if(prev instanceof IfStatement){
					IfStatement ifItem = (IfStatement) prev;
					ifItem.elseItem = (ElseStatement) cur;
					it.remove();
				}
			}
			prev = cur;
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
	
	public void enterRelationalExpression(Relational_expressionContext ctx)
	{
		RelationalExpression expr = new RelationalExpression();
		itemStack.push(expr);
	}
	
	public void exitRelationalExpression(Relational_expressionContext ctx)
	{
		consolidateSubExpression(ctx);
	}
	
	public void enterShiftExpression(Shift_expressionContext ctx)
	{
		ShiftExpression expr = new ShiftExpression();
		itemStack.push(expr);
	}

	public void exitShiftExpression(Shift_expressionContext ctx)
	{
		consolidateSubExpression(ctx);
	}

	public void enterAdditiveExpression(Additive_expressionContext ctx)
	{
		AdditiveExpression expr = new AdditiveExpression();
		itemStack.push(expr);
	}

	public void exitAdditiveExpression(Additive_expressionContext ctx)
	{
		consolidateSubExpression(ctx);
	}	
	
	public void enterMultiplicativeExpression(Multiplicative_expressionContext ctx)
	{
		MultiplicativeExpression expr = new MultiplicativeExpression();
		itemStack.push(expr);
	}

	public void exitMultiplicativeExpression(Multiplicative_expressionContext ctx)
	{
		consolidateSubExpression(ctx);
	}

	public void enterCastExpression(Cast_expressionContext ctx)
	{
		CastExpression expr = new CastExpression();
		itemStack.push(expr);
	}

	public void exitCastExpression(Cast_expressionContext ctx)
	{
		consolidateSubExpression(ctx);
	}

	public void enterCast_target(Cast_targetContext ctx)
	{
		CastTarget expr = new CastTarget();
		itemStack.push(expr);
	}

	public void exitCast_target(Cast_targetContext ctx)
	{
		consolidateSubExpression(ctx);
	}
	
	public void enterFuncCall(FuncCallContext ctx)
	{
		CallExpression expr = new CallExpression();
		itemStack.push(expr);
	}

	public void exitFuncCall(FuncCallContext ctx)
	{
		consolidateSubExpression(ctx);
	}
	
	public void enterArgumentList(Function_argument_listContext ctx)
	{
		ArgumentList expr = new ArgumentList();
		itemStack.push(expr);
	}

	public void exitArgumentList(Function_argument_listContext ctx)
	{
		consolidateSubExpression(ctx);
	}
	
	public void enterCondition(ConditionContext ctx)
	{
		Condition expr = new Condition();
		itemStack.push(expr);
	}

	public void exitCondition(ConditionContext ctx)
	{	
		Condition cond = (Condition) itemStack.pop();
		addItemToParent(cond);
	}

	public void enterDeclByClass(DeclByClassContext ctx)
	{
		ClassDefBuilder classDefBuilder = new ClassDefBuilder();
		classDefBuilder.createNew(ctx);
		classDefBuilder.setName(ctx.class_def().class_name());
		replaceTopOfStack(classDefBuilder.getItem());
	}

	public void exitDeclByClass()
	{
		consolidate();
	}
	
	public void enterInitDeclarator(Init_declaratorContext ctx)
	{		
				
		InitDeclContextWrapper wrappedContext = new InitDeclContextWrapper(ctx);
		IdentifierDeclBuilder declBuilder = new IdentifierDeclBuilder();
		
		
		ASTNode parentItem =  itemStack.peek();
		
		ParserRuleContext typeName;
		
		if(parentItem instanceof IdentifierDeclStatement)
			typeName = ((IdentifierDeclStatement) parentItem).getTypeNameContext();
		else if (parentItem instanceof ClassDef)
			typeName = ((ClassDef) parentItem).getName().getParseTreeNodeContext();
		else
			throw new RuntimeException("No matching declaration statement/class definiton for init declarator");
		
		declBuilder.createNew(ctx);
		declBuilder.setName(wrappedContext);
		declBuilder.setType(wrappedContext, typeName);
		
		ASTNode identifierDecl = declBuilder.getItem();
		itemStack.push(identifierDecl);	
	}

	public void exitInitDeclarator()
	{
		IdentifierDecl identifierDecl = (IdentifierDecl) itemStack.pop();
		ASTNode stmt =  itemStack.peek();
		stmt.addChild(identifierDecl);
	}

	public void enterIncDec(Inc_decContext ctx)
	{
		IncDec expr = new IncDec();
		itemStack.push(expr);
	}

	public void exitIncDec(Inc_decContext ctx)
	{
		consolidateSubExpression(ctx);
	}
	
	public void enterArrayIndexing(ArrayIndexingContext ctx)
	{
		ArrayIndexing expr = new ArrayIndexing();
		itemStack.push(expr);
	}

	public void exitArrayIndexing(ArrayIndexingContext ctx)
	{
		consolidateSubExpression(ctx);
	}

	public void enterMemberAccess(MemberAccessContext ctx)
	{
		MemberAccess expr = new MemberAccess();
		itemStack.push(expr);
	}

	public void exitMemberAccess(MemberAccessContext ctx)
	{
		consolidateSubExpression(ctx);
	}

	public void enterIncDecOp(IncDecOpContext ctx)
	{
		IncDecOp expr = new IncDecOp();
		itemStack.push(expr);
	}

	public void exitIncDecOp(IncDecOpContext ctx)
	{
		consolidateSubExpression(ctx);
	}

	public void enterPrimary(Primary_expressionContext ctx)
	{
		PrimaryExpression expr = new PrimaryExpression();
		itemStack.push(expr);
	}

	public void exitPrimary(Primary_expressionContext ctx)
	{
		consolidateSubExpression(ctx);
	}

	public void enterUnaryExpression(Unary_expressionContext ctx)
	{
		UnaryExpression expr = new UnaryExpression();
		itemStack.push(expr);
	}

	public void exitUnaryExpression(Unary_expressionContext ctx)
	{
		consolidateSubExpression(ctx);
	}

	public void enterIdentifier(IdentifierContext ctx)
	{
		Identifier expr = new Identifier();
		itemStack.push(expr);
	}

	public void exitIdentifier(IdentifierContext ctx)
	{
		consolidateSubExpression(ctx);
	}

	public void enterArgument(Function_argumentContext ctx)
	{
		Argument expr = new Argument();
		itemStack.push(expr);
	}

	public void exitArgument(Function_argumentContext ctx)
	{
		consolidateSubExpression(ctx);
	}

}