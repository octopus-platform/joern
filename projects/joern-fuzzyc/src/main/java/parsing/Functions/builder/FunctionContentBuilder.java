package parsing.Functions.builder;

import java.util.EmptyStackException;
import java.util.HashMap;

import org.antlr.v4.runtime.ParserRuleContext;

import antlr.FunctionParser.Additive_expressionContext;
import antlr.FunctionParser.And_expressionContext;
import antlr.FunctionParser.ArrayIndexingContext;
import antlr.FunctionParser.Assign_exprContext;
import antlr.FunctionParser.Bit_and_expressionContext;
import antlr.FunctionParser.Block_starterContext;
import antlr.FunctionParser.BreakStatementContext;
import antlr.FunctionParser.Cast_expressionContext;
import antlr.FunctionParser.Cast_targetContext;
import antlr.FunctionParser.Catch_statementContext;
import antlr.FunctionParser.Closing_curlyContext;
import antlr.FunctionParser.ConditionContext;
import antlr.FunctionParser.Conditional_expressionContext;
import antlr.FunctionParser.ContinueStatementContext;
import antlr.FunctionParser.DeclByClassContext;
import antlr.FunctionParser.Do_statementContext;
import antlr.FunctionParser.Else_statementContext;
import antlr.FunctionParser.Equality_expressionContext;
import antlr.FunctionParser.Exclusive_or_expressionContext;
import antlr.FunctionParser.ExprContext;
import antlr.FunctionParser.Expr_statementContext;
import antlr.FunctionParser.For_init_statementContext;
import antlr.FunctionParser.For_statementContext;
import antlr.FunctionParser.FuncCallContext;
import antlr.FunctionParser.Function_argumentContext;
import antlr.FunctionParser.Function_argument_listContext;
import antlr.FunctionParser.GotoStatementContext;
import antlr.FunctionParser.IdentifierContext;
import antlr.FunctionParser.If_statementContext;
import antlr.FunctionParser.IncDecOpContext;
import antlr.FunctionParser.Inc_decContext;
import antlr.FunctionParser.Inclusive_or_expressionContext;
import antlr.FunctionParser.InitDeclSimpleContext;
import antlr.FunctionParser.InitDeclWithAssignContext;
import antlr.FunctionParser.InitDeclWithCallContext;
import antlr.FunctionParser.Initializer_listContext;
import antlr.FunctionParser.LabelContext;
import antlr.FunctionParser.MemberAccessContext;
import antlr.FunctionParser.Multiplicative_expressionContext;
import antlr.FunctionParser.Opening_curlyContext;
import antlr.FunctionParser.Or_expressionContext;
import antlr.FunctionParser.Primary_expressionContext;
import antlr.FunctionParser.PtrMemberAccessContext;
import antlr.FunctionParser.Relational_expressionContext;
import antlr.FunctionParser.ReturnStatementContext;
import antlr.FunctionParser.Shift_expressionContext;
import antlr.FunctionParser.SizeofContext;
import antlr.FunctionParser.Sizeof_expressionContext;
import antlr.FunctionParser.Sizeof_operand2Context;
import antlr.FunctionParser.Sizeof_operandContext;
import antlr.FunctionParser.StatementContext;
import antlr.FunctionParser.StatementsContext;
import antlr.FunctionParser.Switch_statementContext;
import antlr.FunctionParser.ThrowStatementContext;
import antlr.FunctionParser.Try_statementContext;
import antlr.FunctionParser.Type_nameContext;
import antlr.FunctionParser.Unary_expressionContext;
import antlr.FunctionParser.Unary_op_and_cast_exprContext;
import antlr.FunctionParser.Unary_operatorContext;
import antlr.FunctionParser.While_statementContext;
import ast.ASTNode;
import ast.ASTNodeBuilder;
import ast.c.expressions.CallExpression;
import ast.c.expressions.SizeofExpression;
import ast.c.statements.blockstarters.ElseStatement;
import ast.c.statements.blockstarters.IfStatement;
import ast.declarations.ClassDefStatement;
import ast.declarations.IdentifierDecl;
import ast.declarations.IdentifierDeclType;
import ast.expressions.AdditiveExpression;
import ast.expressions.AndExpression;
import ast.expressions.Argument;
import ast.expressions.ArgumentList;
import ast.expressions.ArrayIndexing;
import ast.expressions.AssignmentExpression;
import ast.expressions.BitAndExpression;
import ast.expressions.Callee;
import ast.expressions.CastExpression;
import ast.expressions.CastTarget;
import ast.expressions.ConditionalExpression;
import ast.expressions.EqualityExpression;
import ast.expressions.ExclusiveOrExpression;
import ast.expressions.Expression;
import ast.expressions.ForInit;
import ast.expressions.Identifier;
import ast.expressions.IncDec;
import ast.expressions.InclusiveOrExpression;
import ast.expressions.InitializerList;
import ast.expressions.MemberAccess;
import ast.expressions.MultiplicativeExpression;
import ast.expressions.OrExpression;
import ast.expressions.PostIncDecOperationExpression;
import ast.expressions.PrimaryExpression;
import ast.expressions.PtrMemberAccess;
import ast.expressions.RelationalExpression;
import ast.expressions.ShiftExpression;
import ast.expressions.Sizeof;
import ast.expressions.SizeofOperand;
import ast.expressions.UnaryExpression;
import ast.expressions.UnaryOperationExpression;
import ast.expressions.UnaryOperator;
import ast.logical.statements.BlockCloser;
import ast.logical.statements.BlockStarter;
import ast.logical.statements.CompoundStatement;
import ast.logical.statements.Condition;
import ast.logical.statements.Label;
import ast.logical.statements.Statement;
import ast.statements.ExpressionStatement;
import ast.statements.IdentifierDeclStatement;
import ast.statements.blockstarters.CatchStatement;
import ast.statements.blockstarters.DoStatement;
import ast.statements.blockstarters.ForStatement;
import ast.statements.blockstarters.SwitchStatement;
import ast.statements.blockstarters.TryStatement;
import ast.statements.blockstarters.WhileStatement;
import ast.statements.jump.BreakStatement;
import ast.statements.jump.ContinueStatement;
import ast.statements.jump.GotoStatement;
import ast.statements.jump.ReturnStatement;
import ast.statements.jump.ThrowStatement;
import parsing.ASTNodeFactory;
import parsing.Shared.InitDeclContextWrapper;
import parsing.Shared.builders.ClassDefBuilder;
import parsing.Shared.builders.IdentifierDeclBuilder;

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
	HashMap<ASTNode, ParserRuleContext> nodeToRuleContext = new HashMap<ASTNode, ParserRuleContext>();

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
		ASTNode statementItem = ASTNodeFactory.create(ctx);
		nodeToRuleContext.put(statementItem, ctx);
		stack.push(statementItem);
	}

	// Mapping of grammar-rules to CodeItems.

	public void enterOpeningCurly(Opening_curlyContext ctx)
	{
		replaceTopOfStack(new CompoundStatement(), ctx);
	}

	public void enterClosingCurly(Closing_curlyContext ctx)
	{
		replaceTopOfStack(new BlockCloser(), ctx);
	}

	public void enterBlockStarter(Block_starterContext ctx)
	{
		replaceTopOfStack(new BlockStarter(), ctx);
	}

	public void enterExprStatement(Expr_statementContext ctx)
	{
		replaceTopOfStack(new ExpressionStatement(), ctx);
	}

	public void enterIf(If_statementContext ctx)
	{
		replaceTopOfStack(new IfStatement(), ctx);
	}

	public void enterFor(For_statementContext ctx)
	{
		replaceTopOfStack(new ForStatement(), ctx);
	}

	public void enterWhile(While_statementContext ctx)
	{
		replaceTopOfStack(new WhileStatement(), ctx);
	}

	public void enterDo(Do_statementContext ctx)
	{
		replaceTopOfStack(new DoStatement(), ctx);
	}

	public void enterElse(Else_statementContext ctx)
	{
		replaceTopOfStack(new ElseStatement(), ctx);
	}

	public void exitStatement(StatementContext ctx)
	{
		if (stack.size() == 0)
			throw new RuntimeException();

		ASTNode itemToRemove = stack.peek();
		ASTNodeFactory.initializeFromContext(itemToRemove, ctx);

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
		nodeToRuleContext.put(expression, ctx);
		stack.push(expression);
	}

	public void exitExpression(ExprContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterAssignment(Assign_exprContext ctx)
	{
		AssignmentExpression expr = new AssignmentExpression();
		nodeToRuleContext.put(expr, ctx);
		stack.push(expr);
	}

	public void exitAssignment(Assign_exprContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterConditionalExpr(Conditional_expressionContext ctx)
	{
		ConditionalExpression expr = new ConditionalExpression();
		nodeToRuleContext.put(expr, ctx);
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
		nodeToRuleContext.put(expr, ctx);
		stack.push(expr);
	}

	public void exitrOrExpression(Or_expressionContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterAndExpression(And_expressionContext ctx)
	{
		AndExpression expr = new AndExpression();
		nodeToRuleContext.put(expr, ctx);
		stack.push(expr);
	}

	public void exitAndExpression(And_expressionContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterInclusiveOrExpression(Inclusive_or_expressionContext ctx)
	{
		InclusiveOrExpression expr = new InclusiveOrExpression();
		nodeToRuleContext.put(expr, ctx);
		stack.push(expr);
	}

	public void exitInclusiveOrExpression(Inclusive_or_expressionContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterExclusiveOrExpression(Exclusive_or_expressionContext ctx)
	{
		ExclusiveOrExpression expr = new ExclusiveOrExpression();
		nodeToRuleContext.put(expr, ctx);
		stack.push(expr);
	}

	public void exitExclusiveOrExpression(Exclusive_or_expressionContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterBitAndExpression(Bit_and_expressionContext ctx)
	{
		BitAndExpression expr = new BitAndExpression();
		nodeToRuleContext.put(expr, ctx);
		stack.push(expr);
	}

	public void enterEqualityExpression(Equality_expressionContext ctx)
	{
		EqualityExpression expr = new EqualityExpression();
		nodeToRuleContext.put(expr, ctx);
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
		nodeToRuleContext.put(expr, ctx);
		stack.push(expr);
	}

	public void exitRelationalExpression(Relational_expressionContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterShiftExpression(Shift_expressionContext ctx)
	{
		ShiftExpression expr = new ShiftExpression();
		nodeToRuleContext.put(expr, ctx);
		stack.push(expr);
	}

	public void exitShiftExpression(Shift_expressionContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterAdditiveExpression(Additive_expressionContext ctx)
	{
		AdditiveExpression expr = new AdditiveExpression();
		nodeToRuleContext.put(expr, ctx);
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
		nodeToRuleContext.put(expr, ctx);
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
		nodeToRuleContext.put(expr, ctx);
		stack.push(expr);
	}

	public void exitCastExpression(Cast_expressionContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterCast_target(Cast_targetContext ctx)
	{
		CastTarget expr = new CastTarget();
		nodeToRuleContext.put(expr, ctx);
		stack.push(expr);
	}

	public void exitCast_target(Cast_targetContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterFuncCall(FuncCallContext ctx)
	{
		CallExpression expr = new CallExpression();
		nodeToRuleContext.put(expr, ctx);
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
		nodeToRuleContext.put(expr, ctx);
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
		} catch (EmptyStackException ex)
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
		} catch (EmptyStackException ex)
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
		nodeToRuleContext.put(expr, ctx);
		stack.push(expr);
	}

	public void exitArgumentList(Function_argument_listContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterCondition(ConditionContext ctx)
	{
		Condition expr = new Condition();
		nodeToRuleContext.put(expr, ctx);
		stack.push(expr);
	}

	public void exitCondition(ConditionContext ctx)
	{
		Condition cond = (Condition) stack.pop();
		ASTNodeFactory.initializeFromContext(cond, ctx);
		nesting.addItemToParent(cond);
	}

	public void enterDeclByClass(DeclByClassContext ctx)
	{
		ClassDefBuilder classDefBuilder = new ClassDefBuilder();
		classDefBuilder.createNew(ctx);
		classDefBuilder.setName(ctx.class_def().class_name());
		replaceTopOfStack(classDefBuilder.getItem(), ctx);
	}

	public void exitDeclByClass()
	{
		nesting.consolidate();
	}

	public void enterInitDeclSimple(InitDeclSimpleContext ctx)
	{
		ASTNode identifierDecl = buildDeclarator(ctx);
		nodeToRuleContext.put(identifierDecl, ctx);
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
		nodeToRuleContext.put(identifierDecl, ctx);
		stack.push(identifierDecl);
	}

	public void exitInitDeclWithAssign(InitDeclWithAssignContext ctx)
	{
		IdentifierDecl identifierDecl = (IdentifierDecl) stack.pop();

		Expression lastChild = (Expression) identifierDecl.popLastChild();
		AssignmentExpression assign = ASTNodeFactory.create(ctx);

		// This is a bit of a hack. As we go up,
		// we introduce an artificial assignment-node.

		assign.addChild(new Identifier(identifierDecl.getName()));
		assign.addChild(lastChild);

		identifierDecl.addChild(assign);

		ASTNode stmt = stack.peek();
		stmt.addChild(identifierDecl);
	}

	public void enterInitDeclWithCall(InitDeclWithCallContext ctx)
	{
		ASTNode identifierDecl = buildDeclarator(ctx);
		nodeToRuleContext.put(identifierDecl, ctx);
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
		{
			IdentifierDeclStatement stmt = ((IdentifierDeclStatement) parentItem);
			IdentifierDeclType type = stmt.getType();
			typeName = nodeToRuleContext.get(type);
		} else if (parentItem instanceof ClassDefStatement)
		{
			Identifier name = ((ClassDefStatement) parentItem).getIdentifier();
			typeName = nodeToRuleContext.get(name);
		} else
			throw new RuntimeException(
					"No matching declaration statement/class definiton for init declarator");
		return typeName;
	}

	public void enterIncDec(Inc_decContext ctx)
	{
		IncDec expr = new IncDec();
		nodeToRuleContext.put(expr, ctx);
		stack.push(expr);
	}

	public void exitIncDec(Inc_decContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterArrayIndexing(ArrayIndexingContext ctx)
	{
		ArrayIndexing expr = new ArrayIndexing();
		nodeToRuleContext.put(expr, ctx);
		stack.push(expr);
	}

	public void exitArrayIndexing(ArrayIndexingContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterMemberAccess(MemberAccessContext ctx)
	{
		MemberAccess expr = new MemberAccess();
		nodeToRuleContext.put(expr, ctx);
		stack.push(expr);
	}

	public void exitMemberAccess(MemberAccessContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterIncDecOp(IncDecOpContext ctx)
	{
		PostIncDecOperationExpression expr = new PostIncDecOperationExpression();
		nodeToRuleContext.put(expr, ctx);
		stack.push(expr);
	}

	public void exitIncDecOp(IncDecOpContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterPrimary(Primary_expressionContext ctx)
	{
		PrimaryExpression expr = new PrimaryExpression();
		nodeToRuleContext.put(expr, ctx);
		stack.push(expr);
	}

	public void exitPrimary(Primary_expressionContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterUnaryExpression(Unary_expressionContext ctx)
	{
		UnaryExpression expr = new UnaryExpression();
		nodeToRuleContext.put(expr, ctx);
		stack.push(expr);
	}

	public void exitUnaryExpression(Unary_expressionContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterIdentifier(IdentifierContext ctx)
	{
		Identifier expr = new Identifier();
		nodeToRuleContext.put(expr, ctx);
		stack.push(expr);
	}

	public void exitIdentifier(IdentifierContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterArgument(Function_argumentContext ctx)
	{
		Argument expr = new Argument();
		nodeToRuleContext.put(expr, ctx);
		stack.push(expr);
	}

	public void exitArgument(Function_argumentContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterInitializerList(Initializer_listContext ctx)
	{
		InitializerList expr = new InitializerList();
		nodeToRuleContext.put(expr, ctx);
		stack.push(expr);
	}

	public void exitInitializerList(Initializer_listContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterPtrMemberAccess(PtrMemberAccessContext ctx)
	{
		PtrMemberAccess expr = new PtrMemberAccess();
		nodeToRuleContext.put(expr, ctx);
		stack.push(expr);
	}

	public void exitPtrMemberAccess(PtrMemberAccessContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterInitFor(For_init_statementContext ctx)
	{
		ForInit expr = new ForInit();
		nodeToRuleContext.put(expr, ctx);
		stack.push(expr);
	}

	public void exitInitFor(For_init_statementContext ctx)
	{
		ASTNode node = stack.pop();
		ASTNodeFactory.initializeFromContext(node, ctx);
		ForStatement forStatement = (ForStatement) stack.peek();
		forStatement.addChild(node);
	}

	public void enterSwitchStatement(Switch_statementContext ctx)
	{
		replaceTopOfStack(new SwitchStatement(), ctx);
	}

	public void enterLabel(LabelContext ctx)
	{
		replaceTopOfStack(new Label(), ctx);
	}

	public void enterReturnStatement(ReturnStatementContext ctx)
	{
		replaceTopOfStack(new ReturnStatement(), ctx);
	}

	public void enterBreakStatement(BreakStatementContext ctx)
	{
		replaceTopOfStack(new BreakStatement(), ctx);
	}

	public void enterContinueStatement(ContinueStatementContext ctx)
	{
		replaceTopOfStack(new ContinueStatement(), ctx);
	}

	public void enterGotoStatement(GotoStatementContext ctx)
	{
		replaceTopOfStack(new GotoStatement(), ctx);
	}

	@Override
	public void createNew(ParserRuleContext ctx)
	{
		item = new CompoundStatement();
		CompoundStatement rootItem = (CompoundStatement) item;
		ASTNodeFactory.initializeFromContext(item, ctx);
		nodeToRuleContext.put(rootItem, ctx);
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
		ASTNodeFactory.initializeFromContext(declStmt, ctx);

		IdentifierDeclType type = new IdentifierDeclType();
		ASTNodeFactory.initializeFromContext(type, type_nameContext);
		nodeToRuleContext.put(type, type_nameContext);
		declStmt.addChild(type);

		if (stack.peek() instanceof Statement)
			replaceTopOfStack(declStmt, ctx);
		else
		{
			nodeToRuleContext.put(declStmt, ctx);
			stack.push(declStmt);
		}
	}

	public void exitDeclByType()
	{
		nesting.consolidate();
	}

	protected void replaceTopOfStack(ASTNode item, ParserRuleContext ctx)
	{
		ASTNode oldNode = stack.pop();
		nodeToRuleContext.put(item, ctx);
		stack.push(item);
	}

	public void enterSizeofExpr(Sizeof_expressionContext ctx)
	{
		SizeofExpression expr = new SizeofExpression();
		nodeToRuleContext.put(expr, ctx);
		stack.push(expr);
	}

	public void exitSizeofExpr(Sizeof_expressionContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterSizeofOperand2(Sizeof_operand2Context ctx)
	{
		SizeofOperand expr = new SizeofOperand();
		nodeToRuleContext.put(expr, ctx);
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
		UnaryOperationExpression expr = new UnaryOperationExpression();
		nodeToRuleContext.put(expr, ctx);
		stack.push(expr);
	}

	public void exitUnaryOpAndCastExpr(Unary_op_and_cast_exprContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterUnaryOperator(Unary_operatorContext ctx)
	{
		UnaryOperator expr = new UnaryOperator();
		nodeToRuleContext.put(expr, ctx);
		stack.push(expr);
	}

	public void exitUnaryOperator(Unary_operatorContext ctx)
	{
		nesting.consolidateSubExpression(ctx);
	}

	public void enterTryStatement(Try_statementContext ctx)
	{
		replaceTopOfStack(new TryStatement(), ctx);
	}

	public void enterCatchStatement(Catch_statementContext ctx)
	{
		replaceTopOfStack(new CatchStatement(), ctx);
	}

	public void enterThrowStatement(ThrowStatementContext ctx)
	{
		replaceTopOfStack(new ThrowStatement(), ctx);
	}

}
