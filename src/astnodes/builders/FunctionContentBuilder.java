package astnodes.builders;

import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;

import parsing.InitDeclContextWrapper;
import antlr.FunctionParser.Additive_expressionContext;
import antlr.FunctionParser.And_expressionContext;
import antlr.FunctionParser.ArrayIndexingContext;
import antlr.FunctionParser.Assign_exprContext;
import antlr.FunctionParser.Bit_and_expressionContext;
import antlr.FunctionParser.Block_starterContext;
import antlr.FunctionParser.BreakStatementContext;
import antlr.FunctionParser.Cast_expressionContext;
import antlr.FunctionParser.Cast_targetContext;
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
import antlr.FunctionParser.StatementContext;
import antlr.FunctionParser.StatementsContext;
import antlr.FunctionParser.Switch_statementContext;
import antlr.FunctionParser.Type_nameContext;
import antlr.FunctionParser.Unary_expressionContext;
import antlr.FunctionParser.While_statementContext;
import astnodes.ASTNode;
import astnodes.ASTNodeBuilder;
import astnodes.declarations.ClassDefStatement;
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
import astnodes.expressions.InitializerList;
import astnodes.expressions.MemberAccess;
import astnodes.expressions.MultiplicativeExpression;
import astnodes.expressions.OrExpression;
import astnodes.expressions.PrimaryExpression;
import astnodes.expressions.PtrMemberAccess;
import astnodes.expressions.RelationalExpression;
import astnodes.expressions.ShiftExpression;
import astnodes.expressions.UnaryExpression;
import astnodes.statements.BlockCloser;
import astnodes.statements.BlockStarter;
import astnodes.statements.BreakStatement;
import astnodes.statements.CompoundStatement;
import astnodes.statements.Condition;
import astnodes.statements.ContinueStatement;
import astnodes.statements.DoStatement;
import astnodes.statements.ElseStatement;
import astnodes.statements.ExpressionHolder;
import astnodes.statements.ExpressionStatement;
import astnodes.statements.ForInit;
import astnodes.statements.ForStatement;
import astnodes.statements.GotoStatement;
import astnodes.statements.IdentifierDeclStatement;
import astnodes.statements.IfStatement;
import astnodes.statements.Label;
import astnodes.statements.ReturnStatement;
import astnodes.statements.Statement;
import astnodes.statements.SwitchStatement;
import astnodes.statements.WhileStatement;

public class FunctionContentBuilder extends ASTNodeBuilder
{
	private Stack<ASTNode> itemStack = new Stack<ASTNode>();
	CompoundStatement rootItem;

	Stack<ASTNode> shadowStack = new Stack<ASTNode>();


	private void itemStackPush(ASTNode statementItem)
	{
		if(statementItem instanceof IfStatement || statementItem instanceof DoStatement){
			shadowStack.push(statementItem);

			ASTNode parentCompound = null;
			for(int i = itemStack.size() -1; i >= 0; i--){
				// walk stack from top to bottom
				if(itemStack.get(i) instanceof CompoundStatement){
					parentCompound = itemStack.get(i);
					break;
				}
			}
			
			shadowStack.push(parentCompound);
		}
		itemStack.push(statementItem);
	}
	
	private ASTNode itemStackPop()
	{
		ASTNode topOfItemStack = itemStack.peek();
		
		if(shadowStack.size() > 0 && shadowStack.peek() == topOfItemStack){
			shadowStack.pop();
			shadowStack.pop(); // scope of the block hosting the if closed
		}
			
		return itemStack.pop();
	}

	private ASTNode getIfOrDoInElseCaseFromShadowStack()
	{
		ASTNode topScope = shadowStack.pop(); // scope item
		ASTNode topNode = shadowStack.pop();
	
		shadowStack.pop();
		ASTNode retval = shadowStack.pop();
		shadowStack.push(topNode);
		shadowStack.push(topScope);
		return retval;
	}
	
	private ASTNode getIfOrDoFromShadowStack()
	{
		shadowStack.pop();
		return shadowStack.pop();
	}
	
	// exitStatements is called when the entire
	// function-content has been walked

	public void exitStatements(StatementsContext ctx)
	{
		if(itemStack.size() != 1)
			throw new RuntimeException("Broken stack while parsing");
		
	}
	
	// For all statements, begin by pushing a CodeItem
	// onto the stack. Once we have implemented
	// handling for all statement types, this can
	// be removed

	public void enterStatement(StatementContext ctx)
	{
		ASTNode statementItem = new Statement();
		statementItem.initializeFromContext(ctx);
		itemStackPush(statementItem);
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
		if(itemStack.size() == 0)
			throw new RuntimeException();

		ASTNode itemToRemove = itemStack.peek();
		itemToRemove.initializeFromContext(ctx);

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
		itemStackPop(); // remove 'CloseBlock'
		
		CompoundStatement compoundItem = (CompoundStatement) itemStackPop();
		consolidateBlockStarters(compoundItem);		
	}

	// Expression handling

	public void enterExpression(ExprContext ctx)
	{
		Expression expression = new Expression();
		itemStackPush(expression);
	}

	public void exitExpression(ExprContext ctx)
	{
		consolidateSubExpression(ctx);
	}

	public void enterAssignment(Assign_exprContext ctx)
	{	
		AssignmentExpr expr = new AssignmentExpr();
		itemStackPush(expr);
	}

	public void exitAssignment(Assign_exprContext ctx)
	{
		consolidateSubExpression(ctx);
	}

	public void enterConditionalExpr(Conditional_expressionContext ctx)
	{
		ConditionalExpression expr = new ConditionalExpression();
		itemStackPush(expr);
	}

	public void exitConditionalExpr(Conditional_expressionContext ctx)
	{
		consolidateSubExpression(ctx);
	}

	public void enterOrExpression(Or_expressionContext ctx)
	{
		OrExpression expr = new OrExpression();
		itemStackPush(expr);
	}

	public void exitrOrExpression(Or_expressionContext ctx)
	{
		consolidateSubExpression(ctx);
	}

	public void enterAndExpression(And_expressionContext ctx)
	{
		AndExpression expr = new AndExpression();
		itemStackPush(expr);
	}

	public void exitAndExpression(And_expressionContext ctx)
	{
		consolidateSubExpression(ctx);
	}

	public void enterInclusiveOrExpression(Inclusive_or_expressionContext ctx)
	{
		InclusiveOrExpression expr = new InclusiveOrExpression();
		itemStackPush(expr);
	}

	public void exitInclusiveOrExpression(Inclusive_or_expressionContext ctx)
	{
		consolidateSubExpression(ctx);
	}

	public void enterExclusiveOrExpression(Exclusive_or_expressionContext ctx)
	{
		ExclusiveOrExpression expr = new ExclusiveOrExpression();
		itemStackPush(expr);
	}

	public void exitExclusiveOrExpression(Exclusive_or_expressionContext ctx)
	{
		consolidateSubExpression(ctx);
	}

	public void enterBitAndExpression(Bit_and_expressionContext ctx)
	{
		BitAndExpression expr = new BitAndExpression();
		itemStackPush(expr);
	}

	public void enterEqualityExpression(Equality_expressionContext ctx)
	{
		EqualityExpression expr = new EqualityExpression();
		itemStackPush(expr);
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
		itemStackPush(expr);
	}

	public void exitRelationalExpression(Relational_expressionContext ctx)
	{
		consolidateSubExpression(ctx);
	}

	public void enterShiftExpression(Shift_expressionContext ctx)
	{
		ShiftExpression expr = new ShiftExpression();
		itemStackPush(expr);
	}

	public void exitShiftExpression(Shift_expressionContext ctx)
	{
		consolidateSubExpression(ctx);
	}

	public void enterAdditiveExpression(Additive_expressionContext ctx)
	{
		AdditiveExpression expr = new AdditiveExpression();
		itemStackPush(expr);
	}

	public void exitAdditiveExpression(Additive_expressionContext ctx)
	{
		consolidateSubExpression(ctx);
	}	

	public void enterMultiplicativeExpression(Multiplicative_expressionContext ctx)
	{
		MultiplicativeExpression expr = new MultiplicativeExpression();
		itemStackPush(expr);
	}

	public void exitMultiplicativeExpression(Multiplicative_expressionContext ctx)
	{
		consolidateSubExpression(ctx);
	}

	public void enterCastExpression(Cast_expressionContext ctx)
	{
		CastExpression expr = new CastExpression();
		itemStackPush(expr);
	}

	public void exitCastExpression(Cast_expressionContext ctx)
	{
		consolidateSubExpression(ctx);
	}

	public void enterCast_target(Cast_targetContext ctx)
	{
		CastTarget expr = new CastTarget();
		itemStackPush(expr);
	}

	public void exitCast_target(Cast_targetContext ctx)
	{
		consolidateSubExpression(ctx);
	}

	public void enterFuncCall(FuncCallContext ctx)
	{
		CallExpression expr = new CallExpression();
		itemStackPush(expr);
	}

	public void exitFuncCall(FuncCallContext ctx)
	{
		consolidateSubExpression(ctx);
	}

	public void enterArgumentList(Function_argument_listContext ctx)
	{
		ArgumentList expr = new ArgumentList();
		itemStackPush(expr);
	}

	public void exitArgumentList(Function_argument_listContext ctx)
	{
		consolidateSubExpression(ctx);
	}

	public void enterCondition(ConditionContext ctx)
	{
		Condition expr = new Condition();
		itemStackPush(expr);
	}

	public void exitCondition(ConditionContext ctx)
	{	
		Condition cond = (Condition) itemStackPop();
		cond.initializeFromContext(ctx);
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

	public void enterInitDeclSimple(InitDeclSimpleContext ctx)
	{				
		ASTNode identifierDecl = buildDeclarator(ctx);
		itemStackPush(identifierDecl);	
	}

	public void exitInitDeclSimple()
	{
		IdentifierDecl identifierDecl = (IdentifierDecl) itemStackPop();
		ASTNode stmt =  itemStack.peek();
		stmt.addChild(identifierDecl);
	}

	public void enterInitDeclWithAssign(InitDeclWithAssignContext ctx)
	{
		IdentifierDecl identifierDecl = buildDeclarator(ctx);				
		itemStackPush(identifierDecl);	
	}

	public void exitInitDeclWithAssign(InitDeclWithAssignContext ctx)
	{
		IdentifierDecl identifierDecl = (IdentifierDecl) itemStackPop();

		Expression lastChild = (Expression) identifierDecl.popLastChild();
		AssignmentExpr assign = new AssignmentExpr();
		assign.initializeFromContext(ctx);

		// watchout here, we're not making a copy.
		// This is also a bit of a hack. As we go up,
		// we introduce an artificial assignment-node.

		assign.addChild(identifierDecl.getName());
		assign.addChild(lastChild);

		identifierDecl.addChild(assign);

		ASTNode stmt =  itemStack.peek();
		stmt.addChild(identifierDecl);
	}

	public void enterInitDeclWithCall(InitDeclWithCallContext ctx)
	{
		ASTNode identifierDecl = buildDeclarator(ctx);
		itemStackPush(identifierDecl);	
	}

	public void exitInitDeclWithCall()
	{
		IdentifierDecl identifierDecl = (IdentifierDecl) itemStackPop();
		ASTNode stmt =  itemStack.peek();
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
		ASTNode parentItem =  itemStack.peek();
		ParserRuleContext typeName;
		if(parentItem instanceof IdentifierDeclStatement)
			typeName = ((IdentifierDeclStatement) parentItem).getTypeNameContext();
		else if (parentItem instanceof ClassDefStatement)
			typeName = ((ClassDefStatement) parentItem).getName().getParseTreeNodeContext();
		else
			throw new RuntimeException("No matching declaration statement/class definiton for init declarator");
		return typeName;
	}

	public void enterIncDec(Inc_decContext ctx)
	{
		IncDec expr = new IncDec();
		itemStackPush(expr);
	}

	public void exitIncDec(Inc_decContext ctx)
	{
		consolidateSubExpression(ctx);
	}

	public void enterArrayIndexing(ArrayIndexingContext ctx)
	{
		ArrayIndexing expr = new ArrayIndexing();
		itemStackPush(expr);
	}

	public void exitArrayIndexing(ArrayIndexingContext ctx)
	{
		consolidateSubExpression(ctx);
	}

	public void enterMemberAccess(MemberAccessContext ctx)
	{
		MemberAccess expr = new MemberAccess();
		itemStackPush(expr);
	}

	public void exitMemberAccess(MemberAccessContext ctx)
	{
		consolidateSubExpression(ctx);
	}

	public void enterIncDecOp(IncDecOpContext ctx)
	{
		IncDecOp expr = new IncDecOp();
		itemStackPush(expr);
	}

	public void exitIncDecOp(IncDecOpContext ctx)
	{
		consolidateSubExpression(ctx);
	}

	public void enterPrimary(Primary_expressionContext ctx)
	{
		PrimaryExpression expr = new PrimaryExpression();
		itemStackPush(expr);
	}

	public void exitPrimary(Primary_expressionContext ctx)
	{
		consolidateSubExpression(ctx);
	}

	public void enterUnaryExpression(Unary_expressionContext ctx)
	{
		UnaryExpression expr = new UnaryExpression();
		itemStackPush(expr);
	}

	public void exitUnaryExpression(Unary_expressionContext ctx)
	{
		consolidateSubExpression(ctx);
	}

	public void enterIdentifier(IdentifierContext ctx)
	{
		Identifier expr = new Identifier();
		itemStackPush(expr);
	}

	public void exitIdentifier(IdentifierContext ctx)
	{
		consolidateSubExpression(ctx);
	}

	public void enterArgument(Function_argumentContext ctx)
	{
		Argument expr = new Argument();
		itemStackPush(expr);
	}

	public void exitArgument(Function_argumentContext ctx)
	{
		consolidateSubExpression(ctx);
	}

	public void enterInitializerList(Initializer_listContext ctx)
	{
		InitializerList expr = new InitializerList();
		itemStackPush(expr);
	}

	public void exitInitializerList(Initializer_listContext ctx)
	{
		consolidateSubExpression(ctx);
	}

	public void enterPtrMemberAccess(PtrMemberAccessContext ctx)
	{
		PtrMemberAccess expr = new PtrMemberAccess();
		itemStackPush(expr);
	}

	public void exitPtrMemberAccess(PtrMemberAccessContext ctx)
	{
		consolidateSubExpression(ctx);
	}

	public void enterInitFor(For_init_statementContext ctx)
	{
		ForInit expr = new ForInit();
		itemStackPush(expr);
	}

	public void exitInitFor(For_init_statementContext ctx)
	{
		ASTNode node = itemStackPop();
		node.initializeFromContext(ctx);
		ForStatement forStatement = (ForStatement) itemStack.peek();
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
		rootItem = (CompoundStatement) item;
		item.initializeFromContext(ctx);
		itemStackPush(rootItem);
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
			itemStackPush(declStmt);
	}

	public void exitDeclByType()
	{
		consolidate();
	}

	protected void replaceTopOfStack(ASTNode item)
	{
		itemStackPop();
		itemStackPush(item);
	}

	protected void consolidateSubExpression(ParserRuleContext ctx)
	{
		Expression expression = (Expression) itemStackPop();
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

		ASTNode stmt = itemStackPop();
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
				bItem = (BlockStarter) itemStackPop();
				bItem.addChild(stmt);
				stmt = bItem;

				
				if(bItem instanceof IfStatement){

					if(itemStack.size() > 0 && itemStack.peek() instanceof ElseStatement){

						BlockStarter elseItem = (BlockStarter) itemStackPop();
						elseItem.addChild(bItem);

						IfStatement lastIf = (IfStatement) getIfOrDoInElseCaseFromShadowStack();
						if( lastIf != null){
							lastIf.setElseNode((ElseStatement) elseItem);
						}
							
						
						return;
					}
					
				}else if(bItem instanceof ElseStatement){
					// add else statement to the previous if-statement,
					// which has already been consolidated so we can return
					
					IfStatement lastIf = (IfStatement) getIfOrDoFromShadowStack();
					if(lastIf != null)
						lastIf.setElseNode((ElseStatement) bItem);
					lastIf = null;
					return;
				}else if(bItem instanceof WhileStatement){
					// add while statement to the previous do-statement
					// if that exists. Otherwise, do nothing special.
					
					DoStatement lastDo;
					try{
						lastDo = (DoStatement) getIfOrDoFromShadowStack();
					}catch(RuntimeException ex){
						break;
					}
					
					if(lastDo != null){
						lastDo.addChild( ((WhileStatement) bItem).getCondition() );
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
