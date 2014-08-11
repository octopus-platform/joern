package parsing.C.Functions.builder;

import java.util.EmptyStackException;

import org.antlr.v4.runtime.ParserRuleContext;

import parsing.C.Shared.InitDeclContextWrapper;
import parsing.C.Shared.builders.ClassDefBuilder;
import parsing.C.Shared.builders.IdentifierDeclBuilder;
import antlr.C.FunctionParser.Additive_expressionContext;
import antlr.C.FunctionParser.And_expressionContext;
import antlr.C.FunctionParser.ArrayIndexingContext;
import antlr.C.FunctionParser.Assign_exprContext;
import antlr.C.FunctionParser.Bit_and_expressionContext;
import antlr.C.FunctionParser.Block_starterContext;
import antlr.C.FunctionParser.BreakStatementContext;
import antlr.C.FunctionParser.Cast_expressionContext;
import antlr.C.FunctionParser.Cast_targetContext;
import antlr.C.FunctionParser.Closing_curlyContext;
import antlr.C.FunctionParser.ConditionContext;
import antlr.C.FunctionParser.Conditional_expressionContext;
import antlr.C.FunctionParser.ContinueStatementContext;
import antlr.C.FunctionParser.DeclByClassContext;
import antlr.C.FunctionParser.Do_statementContext;
import antlr.C.FunctionParser.Else_statementContext;
import antlr.C.FunctionParser.Equality_expressionContext;
import antlr.C.FunctionParser.Exclusive_or_expressionContext;
import antlr.C.FunctionParser.ExprContext;
import antlr.C.FunctionParser.Expr_statementContext;
import antlr.C.FunctionParser.For_init_statementContext;
import antlr.C.FunctionParser.For_statementContext;
import antlr.C.FunctionParser.FuncCallContext;
import antlr.C.FunctionParser.Function_argumentContext;
import antlr.C.FunctionParser.Function_argument_listContext;
import antlr.C.FunctionParser.GotoStatementContext;
import antlr.C.FunctionParser.IdentifierContext;
import antlr.C.FunctionParser.If_statementContext;
import antlr.C.FunctionParser.IncDecOpContext;
import antlr.C.FunctionParser.Inc_decContext;
import antlr.C.FunctionParser.Inclusive_or_expressionContext;
import antlr.C.FunctionParser.InitDeclSimpleContext;
import antlr.C.FunctionParser.InitDeclWithAssignContext;
import antlr.C.FunctionParser.InitDeclWithCallContext;
import antlr.C.FunctionParser.Initializer_listContext;
import antlr.C.FunctionParser.LabelContext;
import antlr.C.FunctionParser.MemberAccessContext;
import antlr.C.FunctionParser.Multiplicative_expressionContext;
import antlr.C.FunctionParser.Opening_curlyContext;
import antlr.C.FunctionParser.Or_expressionContext;
import antlr.C.FunctionParser.Primary_expressionContext;
import antlr.C.FunctionParser.PtrMemberAccessContext;
import antlr.C.FunctionParser.Relational_expressionContext;
import antlr.C.FunctionParser.ReturnStatementContext;
import antlr.C.FunctionParser.Shift_expressionContext;
import antlr.C.FunctionParser.SizeofContext;
import antlr.C.FunctionParser.Sizeof_expressionContext;
import antlr.C.FunctionParser.Sizeof_operand2Context;
import antlr.C.FunctionParser.Sizeof_operandContext;
import antlr.C.FunctionParser.StatementContext;
import antlr.C.FunctionParser.StatementsContext;
import antlr.C.FunctionParser.Switch_statementContext;
import antlr.C.FunctionParser.Type_nameContext;
import antlr.C.FunctionParser.Unary_expressionContext;
import antlr.C.FunctionParser.Unary_op_and_cast_exprContext;
import antlr.C.FunctionParser.Unary_operatorContext;
import antlr.C.FunctionParser.While_statementContext;
import ast.ASTNode;
import ast.ASTNodeBuilder;
import ast.declarations.ClassDefStatement;
import ast.declarations.IdentifierDecl;
import ast.expressions.AdditiveExpression;
import ast.expressions.AndExpression;
import ast.expressions.Argument;
import ast.expressions.ArgumentList;
import ast.expressions.ArrayIndexing;
import ast.expressions.AssignmentExpr;
import ast.expressions.BitAndExpression;
import ast.expressions.CallExpression;
import ast.expressions.Callee;
import ast.expressions.CastExpression;
import ast.expressions.CastTarget;
import ast.expressions.ConditionalExpression;
import ast.expressions.EqualityExpression;
import ast.expressions.ExclusiveOrExpression;
import ast.expressions.Expression;
import ast.expressions.Identifier;
import ast.expressions.IncDec;
import ast.expressions.IncDecOp;
import ast.expressions.InclusiveOrExpression;
import ast.expressions.InitializerList;
import ast.expressions.MemberAccess;
import ast.expressions.MultiplicativeExpression;
import ast.expressions.OrExpression;
import ast.expressions.PrimaryExpression;
import ast.expressions.PtrMemberAccess;
import ast.expressions.RelationalExpression;
import ast.expressions.ShiftExpression;
import ast.expressions.Sizeof;
import ast.expressions.SizeofExpr;
import ast.expressions.SizeofOperand;
import ast.expressions.UnaryExpression;
import ast.expressions.UnaryOp;
import ast.expressions.UnaryOperator;
import ast.statements.BlockCloser;
import ast.statements.BlockStarter;
import ast.statements.BreakStatement;
import ast.statements.CompoundStatement;
import ast.statements.Condition;
import ast.statements.ContinueStatement;
import ast.statements.DoStatement;
import ast.statements.ElseStatement;
import ast.statements.ExpressionStatement;
import ast.statements.ForInit;
import ast.statements.ForStatement;
import ast.statements.GotoStatement;
import ast.statements.IdentifierDeclStatement;
import ast.statements.IfStatement;
import ast.statements.Label;
import ast.statements.ReturnStatement;
import ast.statements.Statement;
import ast.statements.SwitchStatement;
import ast.statements.WhileStatement;

/**
 * The FunctionContentBuilder is invoked while walking the parse tree to create
 * ASTs for the contents of functions, i.e., the first-level compound statements
 * of functions.
 * 
 * Since the fuzzy parser avoids using nested grammar rules as these rules often
 * require reading all tokens of a file only to realize that the default rule
 * must be taken, the most difficult task this code fulfills is to produce a
 * correctly nested AST.
 */

public class FunctionContentBuilder extends ASTNodeBuilder
{
	ContentBuilderStack stack = new ContentBuilderStack();
	NestingReconstructor nesting = new NestingReconstructor(stack);

	// exitStatements is called when the entire
	// function-content has been walked

	public void exitStatements(StatementsContext ctx)
	{
		if (stack.size() != 1)
			throw new RuntimeException("Broken stack while parsing");

	}

	// For all statements, begin by pushing a Statement Object
	// onto the stack.

	public void enterStatement(StatementContext ctx)
	{
		ASTNode statementItem = new Statement();
		statementItem.initializeFromContext(ctx);
		stack.push(statementItem);
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

	public void enterExprStatement(Expr_statementContext ctx)
	{
		replaceTopOfStack(new ExpressionStatement());
	}

	public void enterIf(If_statementContext ctx)
	{
		replaceTopOfStack(new IfStatement());
	}

	public void enterFor(For_statementContext ctx)
	{
		replaceTopOfStack(new ForStatement());
	}

	public void enterWhile(While_statementContext ctx)
	{
		replaceTopOfStack(new WhileStatement());
	}

	public void enterDo(Do_statementContext ctx)
	{
		replaceTopOfStack(new DoStatement());
	}

	public void enterElse(Else_statementContext ctx)
	{
		replaceTopOfStack(new ElseStatement());
	}

	public void exitStatement(StatementContext ctx)
	{
		if (stack.size() == 0)
			throw new RuntimeException();

		ASTNode itemToRemove = stack.peek();
		itemToRemove.initializeFromContext(ctx);

		if (itemToRemove instanceof BlockCloser)
		{
			closeCompoundStatement();
			return;
		}

		// We keep Block-starters and compound items
		// on the stack. They are removed by following
		// statements.
		if (itemToRemove instanceof BlockStarter
				|| itemToRemove instanceof CompoundStatement)
			return;

		nesting.consolidate();
	}

	private void closeCompoundStatement()
	{
		stack.pop(); // remove 'CloseBlock'

		CompoundStatement compoundItem = (CompoundStatement) stack.pop();
		nesting.consolidateBlockStarters(compoundItem);
	}

	// Expression handling

	public void enterExpression(ExprContext ctx)
	{
		Expression expression = new Expression();
		stack.push(expression);
	}

	public void exitExpression(ExprContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterAssignment(Assign_exprContext ctx)
	{
		AssignmentExpr expr = new AssignmentExpr();
		stack.push(expr);
	}

	public void exitAssignment(Assign_exprContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterConditionalExpr(Conditional_expressionContext ctx)
	{
		ConditionalExpression expr = new ConditionalExpression();
		stack.push(expr);
	}

	public void exitConditionalExpr(Conditional_expressionContext ctx)
	{
		introduceCndNodeForCndExpr();
		nesting.consolidateSubExpression(ctx);
	}

	public void enterOrExpression(Or_expressionContext ctx)
	{
		OrExpression expr = new OrExpression();
		stack.push(expr);
	}

	public void exitrOrExpression(Or_expressionContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterAndExpression(And_expressionContext ctx)
	{
		AndExpression expr = new AndExpression();
		stack.push(expr);
	}

	public void exitAndExpression(And_expressionContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterInclusiveOrExpression(Inclusive_or_expressionContext ctx)
	{
		InclusiveOrExpression expr = new InclusiveOrExpression();
		stack.push(expr);
	}

	public void exitInclusiveOrExpression(Inclusive_or_expressionContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterExclusiveOrExpression(Exclusive_or_expressionContext ctx)
	{
		ExclusiveOrExpression expr = new ExclusiveOrExpression();
		stack.push(expr);
	}

	public void exitExclusiveOrExpression(Exclusive_or_expressionContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterBitAndExpression(Bit_and_expressionContext ctx)
	{
		BitAndExpression expr = new BitAndExpression();
		stack.push(expr);
	}

	public void enterEqualityExpression(Equality_expressionContext ctx)
	{
		EqualityExpression expr = new EqualityExpression();
		stack.push(expr);
	}

	public void exitEqualityExpression(Equality_expressionContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void exitBitAndExpression(Bit_and_expressionContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterRelationalExpression(Relational_expressionContext ctx)
	{
		RelationalExpression expr = new RelationalExpression();
		stack.push(expr);
	}

	public void exitRelationalExpression(Relational_expressionContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterShiftExpression(Shift_expressionContext ctx)
	{
		ShiftExpression expr = new ShiftExpression();
		stack.push(expr);
	}

	public void exitShiftExpression(Shift_expressionContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterAdditiveExpression(Additive_expressionContext ctx)
	{
		AdditiveExpression expr = new AdditiveExpression();
		stack.push(expr);
	}

	public void exitAdditiveExpression(Additive_expressionContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterMultiplicativeExpression(
			Multiplicative_expressionContext ctx)
	{
		MultiplicativeExpression expr = new MultiplicativeExpression();
		stack.push(expr);
	}

	public void exitMultiplicativeExpression(
			Multiplicative_expressionContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterCastExpression(Cast_expressionContext ctx)
	{
		CastExpression expr = new CastExpression();
		stack.push(expr);
	}

	public void exitCastExpression(Cast_expressionContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterCast_target(Cast_targetContext ctx)
	{
		CastTarget expr = new CastTarget();
		stack.push(expr);
	}

	public void exitCast_target(Cast_targetContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterFuncCall(FuncCallContext ctx)
	{
		CallExpression expr = new CallExpression();
		stack.push(expr);
	}

	public void exitFuncCall(FuncCallContext ctx)
	{
		introduceCalleeNode();
		nesting.consolidateSubExpression(ctx);
	}

	public void enterSizeof(SizeofContext ctx)
	{
		Sizeof expr = new Sizeof();
		stack.push(expr);
	}

	public void exitSizeof(SizeofContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	private void introduceCalleeNode()
	{
		CallExpression expr;
		try
		{
			expr = (CallExpression) stack.peek();
		}
		catch (EmptyStackException ex)
		{
			return;
		}

		ASTNode child = expr.getChild(0);
		if (child == null)
			return;

		Callee callee = new Callee();
		callee.addChild(child);
		expr.replaceFirstChild(callee);
	}

	private void introduceCndNodeForCndExpr()
	{
		ConditionalExpression expr;
		try
		{
			expr = (ConditionalExpression) stack.peek();
		}
		catch (EmptyStackException ex)
		{
			return;
		}

		ASTNode child = expr.getChild(0);
		if (child == null)
			return;
		Condition cnd = new Condition();
		cnd.addChild(child);
		expr.replaceFirstChild(cnd);

	}

	public void enterArgumentList(Function_argument_listContext ctx)
	{
		ArgumentList expr = new ArgumentList();
		stack.push(expr);
	}

	public void exitArgumentList(Function_argument_listContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterCondition(ConditionContext ctx)
	{
		Condition expr = new Condition();
		stack.push(expr);
	}

	public void exitCondition(ConditionContext ctx)
	{
		Condition cond = (Condition) stack.pop();
		cond.initializeFromContext(ctx);
		nesting.addItemToParent(cond);
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
		nesting.consolidate();
	}

	public void enterInitDeclSimple(InitDeclSimpleContext ctx)
	{
		ASTNode identifierDecl = buildDeclarator(ctx);
		stack.push(identifierDecl);
	}

	public void exitInitDeclSimple()
	{
		IdentifierDecl identifierDecl = (IdentifierDecl) stack.pop();
		ASTNode stmt = stack.peek();
		stmt.addChild(identifierDecl);
	}

	public void enterInitDeclWithAssign(InitDeclWithAssignContext ctx)
	{
		IdentifierDecl identifierDecl = buildDeclarator(ctx);
		stack.push(identifierDecl);
	}

	public void exitInitDeclWithAssign(InitDeclWithAssignContext ctx)
	{
		IdentifierDecl identifierDecl = (IdentifierDecl) stack.pop();

		Expression lastChild = (Expression) identifierDecl.popLastChild();
		AssignmentExpr assign = new AssignmentExpr();
		assign.initializeFromContext(ctx);

		// watchout here, we're not making a copy.
		// This is also a bit of a hack. As we go up,
		// we introduce an artificial assignment-node.

		assign.addChild(identifierDecl.getName());
		assign.addChild(lastChild);

		identifierDecl.addChild(assign);

		ASTNode stmt = stack.peek();
		stmt.addChild(identifierDecl);
	}

	public void enterInitDeclWithCall(InitDeclWithCallContext ctx)
	{
		ASTNode identifierDecl = buildDeclarator(ctx);
		stack.push(identifierDecl);
	}

	public void exitInitDeclWithCall()
	{
		IdentifierDecl identifierDecl = (IdentifierDecl) stack.pop();
		ASTNode stmt = stack.peek();
		stmt.addChild(identifierDecl);
	}

	private IdentifierDecl buildDeclarator(ParserRuleContext ctx)
	{
		InitDeclContextWrapper wrappedContext = new InitDeclContextWrapper(ctx);
		ParserRuleContext typeName = getTypeFromParent();
		IdentifierDeclBuilder declBuilder = new IdentifierDeclBuilder();
		declBuilder.createNew(ctx);
		declBuilder.setType(wrappedContext, typeName);
		IdentifierDecl identifierDecl = (IdentifierDecl) declBuilder.getItem();
		return identifierDecl;
	}

	private ParserRuleContext getTypeFromParent()
	{
		ASTNode parentItem = stack.peek();
		ParserRuleContext typeName;
		if (parentItem instanceof IdentifierDeclStatement)
			typeName = ((IdentifierDeclStatement) parentItem)
					.getTypeNameContext();
		else if (parentItem instanceof ClassDefStatement)
			typeName = ((ClassDefStatement) parentItem).getName()
					.getParseTreeNodeContext();
		else
			throw new RuntimeException(
					"No matching declaration statement/class definiton for init declarator");
		return typeName;
	}

	public void enterIncDec(Inc_decContext ctx)
	{
		IncDec expr = new IncDec();
		stack.push(expr);
	}

	public void exitIncDec(Inc_decContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterArrayIndexing(ArrayIndexingContext ctx)
	{
		ArrayIndexing expr = new ArrayIndexing();
		stack.push(expr);
	}

	public void exitArrayIndexing(ArrayIndexingContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterMemberAccess(MemberAccessContext ctx)
	{
		MemberAccess expr = new MemberAccess();
		stack.push(expr);
	}

	public void exitMemberAccess(MemberAccessContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterIncDecOp(IncDecOpContext ctx)
	{
		IncDecOp expr = new IncDecOp();
		stack.push(expr);
	}

	public void exitIncDecOp(IncDecOpContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterPrimary(Primary_expressionContext ctx)
	{
		PrimaryExpression expr = new PrimaryExpression();
		stack.push(expr);
	}

	public void exitPrimary(Primary_expressionContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterUnaryExpression(Unary_expressionContext ctx)
	{
		UnaryExpression expr = new UnaryExpression();
		stack.push(expr);
	}

	public void exitUnaryExpression(Unary_expressionContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterIdentifier(IdentifierContext ctx)
	{
		Identifier expr = new Identifier();
		stack.push(expr);
	}

	public void exitIdentifier(IdentifierContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterArgument(Function_argumentContext ctx)
	{
		Argument expr = new Argument();
		stack.push(expr);
	}

	public void exitArgument(Function_argumentContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterInitializerList(Initializer_listContext ctx)
	{
		InitializerList expr = new InitializerList();
		stack.push(expr);
	}

	public void exitInitializerList(Initializer_listContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterPtrMemberAccess(PtrMemberAccessContext ctx)
	{
		PtrMemberAccess expr = new PtrMemberAccess();
		stack.push(expr);
	}

	public void exitPtrMemberAccess(PtrMemberAccessContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterInitFor(For_init_statementContext ctx)
	{
		ForInit expr = new ForInit();
		stack.push(expr);
	}

	public void exitInitFor(For_init_statementContext ctx)
	{
		ASTNode node = stack.pop();
		node.initializeFromContext(ctx);
		ForStatement forStatement = (ForStatement) stack.peek();
		forStatement.addChild(node);
	}

	public void enterSwitchStatement(Switch_statementContext ctx)
	{
		replaceTopOfStack(new SwitchStatement());
	}

	public void enterLabel(LabelContext ctx)
	{
		replaceTopOfStack(new Label());
	}

	public void enterReturnStatement(ReturnStatementContext ctx)
	{
		replaceTopOfStack(new ReturnStatement());
	}

	public void enterBreakStatement(BreakStatementContext ctx)
	{
		replaceTopOfStack(new BreakStatement());
	}

	public void enterContinueStatement(ContinueStatementContext ctx)
	{
		replaceTopOfStack(new ContinueStatement());
	}

	public void enterGotoStatement(GotoStatementContext ctx)
	{
		replaceTopOfStack(new GotoStatement());
	}

	@Override
	public void createNew(ParserRuleContext ctx)
	{
		item = new CompoundStatement();
		CompoundStatement rootItem = (CompoundStatement) item;
		item.initializeFromContext(ctx);
		stack.push(rootItem);
	}

	public void addLocalDecl(IdentifierDecl decl)
	{
		IdentifierDeclStatement declStmt = (IdentifierDeclStatement) stack
				.peek();
		declStmt.addChild(decl);
	}

	public void enterDeclByType(ParserRuleContext ctx,
			Type_nameContext type_nameContext)
	{
		IdentifierDeclStatement declStmt = new IdentifierDeclStatement();
		declStmt.initializeFromContext(ctx);
		declStmt.setTypeNameContext(type_nameContext);

		if (stack.peek() instanceof Statement)
			replaceTopOfStack(declStmt);
		else
			stack.push(declStmt);
	}

	public void exitDeclByType()
	{
		nesting.consolidate();
	}

	protected void replaceTopOfStack(ASTNode item)
	{
		stack.pop();
		stack.push(item);
	}

	public void enterSizeofExpr(Sizeof_expressionContext ctx)
	{
		SizeofExpr expr = new SizeofExpr();
		stack.push(expr);
	}

	public void exitSizeofExpr(Sizeof_expressionContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterSizeofOperand2(Sizeof_operand2Context ctx)
	{
		SizeofOperand expr = new SizeofOperand();
		stack.push(expr);
	}

	public void enterSizeofOperand(Sizeof_operandContext ctx)
	{
		SizeofOperand expr = new SizeofOperand();
		stack.push(expr);
	}

	public void exitSizeofOperand2(Sizeof_operand2Context ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void exitSizeofOperand(Sizeof_operandContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterUnaryOpAndCastExpr(Unary_op_and_cast_exprContext ctx)
	{
		UnaryOp expr = new UnaryOp();
		stack.push(expr);
	}

	public void exitUnaryOpAndCastExpr(Unary_op_and_cast_exprContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterUnaryOperator(Unary_operatorContext ctx)
	{
		UnaryOperator expr = new UnaryOperator();
		stack.push(expr);
	}

	public void exitUnaryOperator(Unary_operatorContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

}
