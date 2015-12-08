package tools.phpast2cfg;

import ast.ASTNode;
import ast.expressions.AndExpression;
import ast.expressions.ArgumentList;
import ast.expressions.ArrayIndexing;
import ast.expressions.AssignmentExpression;
import ast.expressions.AssignmentWithOpExpression;
import ast.expressions.BinaryOperationExpression;
import ast.expressions.CallExpression;
import ast.expressions.CastExpression;
import ast.expressions.ClassConstantExpression;
import ast.expressions.ConditionalExpression;
import ast.expressions.Constant;
import ast.expressions.Expression;
import ast.expressions.ExpressionList;
import ast.expressions.GreaterExpression;
import ast.expressions.GreaterOrEqualExpression;
import ast.expressions.Identifier;
import ast.expressions.IdentifierList;
import ast.expressions.InstanceofExpression;
import ast.expressions.NewExpression;
import ast.expressions.OrExpression;
import ast.expressions.PostDecOperationExpression;
import ast.expressions.PostIncOperationExpression;
import ast.expressions.PreDecOperationExpression;
import ast.expressions.PreIncOperationExpression;
import ast.expressions.PropertyExpression;
import ast.expressions.StaticPropertyExpression;
import ast.expressions.UnaryMinusExpression;
import ast.expressions.UnaryOperationExpression;
import ast.expressions.UnaryPlusExpression;
import ast.expressions.Variable;
import ast.functionDef.FunctionDef;
import ast.functionDef.ParameterList;
import ast.logical.statements.CompoundStatement;
import ast.logical.statements.Label;
import ast.logical.statements.Statement;
import ast.php.declarations.PHPClassDef;
import ast.php.expressions.MethodCallExpression;
import ast.php.expressions.PHPArrayElement;
import ast.php.expressions.PHPArrayExpression;
import ast.php.expressions.PHPAssignmentByRefExpression;
import ast.php.expressions.PHPCloneExpression;
import ast.php.expressions.PHPCoalesceExpression;
import ast.php.expressions.PHPEmptyExpression;
import ast.php.expressions.PHPEncapsListExpression;
import ast.php.expressions.PHPExitExpression;
import ast.php.expressions.PHPIncludeOrEvalExpression;
import ast.php.expressions.PHPIssetExpression;
import ast.php.expressions.PHPListExpression;
import ast.php.expressions.PHPPrintExpression;
import ast.php.expressions.PHPReferenceExpression;
import ast.php.expressions.PHPShellExecExpression;
import ast.php.expressions.PHPSilenceExpression;
import ast.php.expressions.PHPUnpackExpression;
import ast.php.expressions.PHPYieldExpression;
import ast.php.expressions.PHPYieldFromExpression;
import ast.php.expressions.StaticCallExpression;
import ast.php.functionDef.Closure;
import ast.php.functionDef.ClosureUses;
import ast.php.functionDef.ClosureVar;
import ast.php.functionDef.Method;
import ast.php.functionDef.PHPParameter;
import ast.php.functionDef.TopLevelFunctionDef;
import ast.php.statements.ClassConstantDeclaration;
import ast.php.statements.ConstantDeclaration;
import ast.php.statements.ConstantElement;
import ast.php.statements.PHPEchoStatement;
import ast.php.statements.PHPGlobalStatement;
import ast.php.statements.PHPGroupUseStatement;
import ast.php.statements.PHPHaltCompilerStatement;
import ast.php.statements.PHPUnsetStatement;
import ast.php.statements.PropertyDeclaration;
import ast.php.statements.PropertyElement;
import ast.php.statements.StaticVariableDeclaration;
import ast.php.statements.blockstarters.ForEachStatement;
import ast.php.statements.blockstarters.MethodReference;
import ast.php.statements.blockstarters.PHPDeclareStatement;
import ast.php.statements.blockstarters.PHPIfElement;
import ast.php.statements.blockstarters.PHPIfStatement;
import ast.php.statements.blockstarters.PHPSwitchCase;
import ast.php.statements.blockstarters.PHPSwitchList;
import ast.php.statements.blockstarters.PHPSwitchStatement;
import ast.php.statements.blockstarters.PHPTraitAdaptationElement;
import ast.php.statements.blockstarters.PHPTraitAdaptations;
import ast.php.statements.blockstarters.PHPTraitAlias;
import ast.php.statements.blockstarters.PHPTraitPrecedence;
import ast.php.statements.blockstarters.PHPUseTrait;
import ast.php.statements.jump.PHPBreakStatement;
import ast.php.statements.jump.PHPContinueStatement;
import ast.statements.UseElement;
import ast.statements.UseStatement;
import ast.statements.blockstarters.CatchList;
import ast.statements.blockstarters.CatchStatement;
import ast.statements.blockstarters.DoStatement;
import ast.statements.blockstarters.ForStatement;
import ast.statements.blockstarters.NamespaceStatement;
import ast.statements.blockstarters.TryStatement;
import ast.statements.blockstarters.WhileStatement;
import ast.statements.jump.GotoStatement;
import ast.statements.jump.ReturnStatement;
import ast.statements.jump.ThrowStatement;
import inputModules.csv.KeyedCSV.KeyedCSVRow;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import inputModules.csv.csv2ast.ASTUnderConstruction;
import inputModules.csv.csv2ast.CSVRowInterpreter;

public class PHPCSVEdgeInterpreter implements CSVRowInterpreter
{

	@Override
	public long handle(KeyedCSVRow row, ASTUnderConstruction ast)
		throws InvalidCSVFile
	{
		long startId = Long.parseLong(row.getFieldForKey(PHPCSVEdgeTypes.START_ID));
		long endId = Long.parseLong(row.getFieldForKey(PHPCSVEdgeTypes.END_ID));

		ASTNode startNode = ast.getNodeById(startId);
		ASTNode endNode = ast.getNodeById(endId);
		
		// TODO put childnum property into edges file instead of nodes file,
		// then do not add the childnum property to ASTNodes in node interpreter any longer,
		// then introduce some NumberFormatException handling here.
		//int childnum = Integer.parseInt(row.getFieldForKey(PHPCSVEdgeTypes.CHILDNUM));
		int childnum = Integer.parseInt(endNode.getProperty(PHPCSVNodeTypes.CHILDNUM.getName()));

		int errno = 0;
		String type = startNode.getProperty(PHPCSVNodeTypes.TYPE.getName());
		switch (type)
		{
			// special nodes
			case PHPCSVNodeTypes.TYPE_NAME:
				errno = handleName((Identifier)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_CLOSURE_VAR:
				errno = handleClosureVar((ClosureVar)startNode, endNode, childnum);
				break;
				
			// declaration nodes
			case PHPCSVNodeTypes.TYPE_TOPLEVEL:
				errno = handleTopLevelFunction((TopLevelFunctionDef)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_FUNC_DECL:
				errno = handleFunction((FunctionDef)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_CLOSURE:
				errno = handleClosure((Closure)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_METHOD:
				errno = handleMethod((Method)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_CLASS:
				errno = handleClass((PHPClassDef)startNode, endNode, childnum);
				break;

			// nodes with exactly 1 child
			// expressions
			case PHPCSVNodeTypes.TYPE_VAR:
				errno = handleVariable((Variable)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_CONST:
				errno = handleConstant((Constant)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_UNPACK:
				errno = handleUnpack((PHPUnpackExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_UNARY_PLUS:
				errno = handleUnaryPlus((UnaryPlusExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_UNARY_MINUS:
				errno = handleUnaryMinus((UnaryMinusExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_CAST:
				errno = handleCast((CastExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_EMPTY:
				errno = handleEmpty((PHPEmptyExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_ISSET:
				errno = handleIsset((PHPIssetExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_SILENCE:
				errno = handleSilence((PHPSilenceExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_SHELL_EXEC:
				errno = handleShellExec((PHPShellExecExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_CLONE:
				errno = handleClone((PHPCloneExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_EXIT:
				errno = handleExit((PHPExitExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_PRINT:
				errno = handlePrint((PHPPrintExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_INCLUDE_OR_EVAL:
				errno = handleIncludeOrEval((PHPIncludeOrEvalExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_UNARY_OP:
				errno = handleUnaryOperation((UnaryOperationExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_PRE_INC:
				errno = handlePreInc((PreIncOperationExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_PRE_DEC:
				errno = handlePreDec((PreDecOperationExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_POST_INC:
				errno = handlePostInc((PostIncOperationExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_POST_DEC:
				errno = handlePostDec((PostDecOperationExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_YIELD_FROM:
				errno = handleYieldFrom((PHPYieldFromExpression)startNode, endNode, childnum);
				break;
			
			// statements
			case PHPCSVNodeTypes.TYPE_GLOBAL:
				errno = handleGlobal((PHPGlobalStatement)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_UNSET:
				errno = handleUnset((PHPUnsetStatement)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_RETURN:
				errno = handleReturn((ReturnStatement)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_LABEL:
				errno = handleLabel((Label)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_REF:
				errno = handleReference((PHPReferenceExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_HALT_COMPILER:
				errno = handleHaltCompiler((PHPHaltCompilerStatement)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_ECHO:
				errno = handleEcho((PHPEchoStatement)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_THROW:
				errno = handleThrow((ThrowStatement)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_GOTO:
				errno = handleGoto((GotoStatement)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_BREAK:
				errno = handleBreak((PHPBreakStatement)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_CONTINUE:
				errno = handleContinue((PHPContinueStatement)startNode, endNode, childnum);
				break;

			// nodes with exactly 2 children
			// expressions
			case PHPCSVNodeTypes.TYPE_DIM:
				errno = handleArrayIndexing((ArrayIndexing)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_PROP:
				errno = handleProperty((PropertyExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_STATIC_PROP:
				errno = handleStaticProperty((StaticPropertyExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_CALL:
				errno = handleCall((CallExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_CLASS_CONST:
				errno = handleClassConstant((ClassConstantExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_ASSIGN:
				errno = handleAssign((AssignmentExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_ASSIGN_REF:
				errno = handleAssignByRef((PHPAssignmentByRefExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_ASSIGN_OP:
				errno = handleAssignWithOp((AssignmentWithOpExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_BINARY_OP:
				errno = handleBinaryOperation((BinaryOperationExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_GREATER:
				errno = handleGreater((GreaterExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_GREATER_EQUAL:
				errno = handleGreaterOrEqual((GreaterOrEqualExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_AND:
				errno = handleAnd((AndExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_OR:
				errno = handleOr((OrExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_ARRAY_ELEM:
				errno = handleArrayElement((PHPArrayElement)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_NEW:
				errno = handleNew((NewExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_INSTANCEOF:
				errno = handleInstanceof((InstanceofExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_YIELD:
				errno = handleYield((PHPYieldExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_COALESCE:
				errno = handleCoalesce((PHPCoalesceExpression)startNode, endNode, childnum);
				break;

			// statements
			case PHPCSVNodeTypes.TYPE_STATIC:
				errno = handleStaticVariable((StaticVariableDeclaration)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_WHILE:
				errno = handleWhile((WhileStatement)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_DO_WHILE:
				errno = handleDo((DoStatement)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_IF_ELEM:
				errno = handleIfElement((PHPIfElement)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_SWITCH:
				errno = handleSwitch((PHPSwitchStatement)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_SWITCH_CASE:
				errno = handleSwitchCase((PHPSwitchCase)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_PROP_ELEM:
				errno = handlePropertyElement((PropertyElement)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_DECLARE:
				errno = handleDeclare((PHPDeclareStatement)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_CONST_ELEM:
				errno = handleConstantElement((ConstantElement)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_USE_TRAIT:
				errno = handleUseTrait((PHPUseTrait)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_TRAIT_PRECEDENCE:
				errno = handleTraitPrecedence((PHPTraitPrecedence)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_METHOD_REFERENCE:
				errno = handleMethodReference((MethodReference)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_NAMESPACE:
				errno = handleNamespace((NamespaceStatement)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_USE_ELEM:
				errno = handleUseElement((UseElement)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_TRAIT_ALIAS:
				errno = handleTraitAlias((PHPTraitAlias)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_GROUP_USE:
				errno = handleGroupUse((PHPGroupUseStatement)startNode, endNode, childnum);
				break;

			// nodes with exactly 3 children
			// expressions
			case PHPCSVNodeTypes.TYPE_METHOD_CALL:
				errno = handleMethodCall((MethodCallExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_STATIC_CALL:
				errno = handleStaticCall((StaticCallExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_CONDITIONAL:
				errno = handleConditional((ConditionalExpression)startNode, endNode, childnum);
				break;
			
			// statements
			case PHPCSVNodeTypes.TYPE_TRY:
				errno = handleTry((TryStatement)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_CATCH:
				errno = handleCatch((CatchStatement)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_PARAM:
				errno = handleParameter((PHPParameter)startNode, endNode, childnum);
				break;
			
			// nodes with exactly 4 children
			// statements
			case PHPCSVNodeTypes.TYPE_FOR:
				errno = handleFor((ForStatement)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_FOREACH:
				errno = handleForEach((ForEachStatement)startNode, endNode, childnum);
				break;
				
			// nodes with an arbitrary number of children
			case PHPCSVNodeTypes.TYPE_ARG_LIST:
				errno = handleArgumentList((ArgumentList)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_LIST:
				errno = handleList((PHPListExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_ARRAY:
				errno = handleArray((PHPArrayExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_ENCAPS_LIST:
				errno = handleEncapsList((PHPEncapsListExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_EXPR_LIST:
				errno = handleExpressionList((ExpressionList)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_STMT_LIST:
				errno = handleCompound((CompoundStatement)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_IF:
				errno = handleIf((PHPIfStatement)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_SWITCH_LIST:
				errno = handleSwitchList((PHPSwitchList)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_CATCH_LIST:
				errno = handleCatchList((CatchList)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_PARAM_LIST:
				errno = handleParameterList((ParameterList)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_CLOSURE_USES:
				errno = handleClosureUses((ClosureUses)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_PROP_DECL:
				errno = handlePropertyDeclaration((PropertyDeclaration)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_CONST_DECL:
				errno = handleConstantDeclaration((ConstantDeclaration)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_CLASS_CONST_DECL:
				errno = handleClassConstantDeclaration((ClassConstantDeclaration)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_NAME_LIST:
				errno = handleIdentifierList((IdentifierList)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_TRAIT_ADAPTATIONS:
				errno = handleTraitAdaptations((PHPTraitAdaptations)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_USE:
				errno = handleUseStatement((UseStatement)startNode, endNode, childnum);
				break;
				
			default:
				errno = defaultHandler(startNode, endNode, childnum);
		}

		if( 1 == errno)
			throw new InvalidCSVFile("While trying to handle row "
					+ row.toString() + ": Invalid childnum " + childnum
					+ " for start node type " + type + ".");
		
		
		return startId;
	}
	
	private int defaultHandler( ASTNode startNode, ASTNode endNode, int childnum)
	{
		startNode.addChild(endNode);
		
		return 0;
	}
	
	
	/* special nodes */
	
	private int handleName( Identifier startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // name child
				startNode.setNameChild(endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;		
	}
	
	private int handleClosureVar( ClosureVar startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // name child
				startNode.setNameChild(endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;		
	}
	
	
	/* declaration nodes */

	private int handleTopLevelFunction( TopLevelFunctionDef startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // stmts child
				startNode.setContent((CompoundStatement)endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;		
	}

	private int handleFunction( FunctionDef startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // params child
				startNode.setParameterList((ParameterList)endNode);
				break;
			case 1: // NULL child
				startNode.addChild(endNode);
				break;
			case 2: // stmts child
				startNode.setContent((CompoundStatement)endNode);
				break;
			case 3: // returnType child: either Identifier or NULL node
				startNode.setReturnType(endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;		
	}
	
	private int handleClosure( Closure startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // params child
				startNode.setParameterList((ParameterList)endNode);
				break;
			case 1: // uses child: either ClosureUses or NULL node
				startNode.setClosureUses(endNode);
				break;
			case 2: // stmts child
				startNode.setContent((CompoundStatement)endNode);
				break;
			case 3: // returnType child: either Identifier or NULL node
				startNode.setReturnType(endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;		
	}

	private int handleMethod( Method startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // params child
				startNode.setParameterList((ParameterList)endNode);
				break;
			case 1: // NULL child
				startNode.addChild(endNode);
				break;
			case 2: // stmts child: either CompoundStatement or NULL
				startNode.setContent(endNode);
				break;
			case 3: // returnType child: either Identifier or NULL node
				startNode.setReturnType(endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;		
	}
	
	private int handleClass( PHPClassDef startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // extends child: either Identifier or NULL node
				startNode.setExtends(endNode);
				break;
			case 1: // implements child: either IdentifierList or NULL node
				startNode.setImplements(endNode);
				break;
			case 2: // toplevel child
				startNode.setTopLevelFunc((TopLevelFunctionDef)endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;		
	}
	
	
	/* nodes with exactly 1 child */
	
	private int handleVariable( Variable startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // name child
				// TODO cast to PrimaryType once mapping is finished, and change
				// Variable.name and getters and setters accordingly
				startNode.setNameChild(endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;		
	}
	
	private int handleConstant( Constant startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // name child
				startNode.setIdentifier((Identifier)endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;		
	}
	
	private int handleUnpack( PHPUnpackExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // expr child
				// TODO cast to Exression once mapping is finished, and change
				// PHPUnpackExpression.unpackExpression and getters and setters accordingly
				startNode.setExpression(endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;		
	}
	
	private int handleUnaryPlus( UnaryPlusExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // expr child
				// TODO cast to Exression once mapping is finished, and change
				// UnaryOperationExpression.expression and getters and setters accordingly
				startNode.setExpression(endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;		
	}
	
	private int handleUnaryMinus( UnaryMinusExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // expr child
				// TODO cast to Exression once mapping is finished, and change
				// UnaryOperationExpression.expression and getters and setters accordingly
				startNode.setExpression(endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;		
	}
	
	private int handleCast( CastExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // expr child
				// TODO cast to Exression once mapping is finished, and change
				// CastExpression.castExpression and getters and setters accordingly
				startNode.setCastExpression(endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;		
	}
	
	private int handleEmpty( PHPEmptyExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // expr child
				// TODO cast to Exression once mapping is finished, and change
				// UnaryExpression.expression and getters and setters accordingly
				startNode.setExpression(endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;		
	}
	
	private int handleIsset( PHPIssetExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // expr child
				// TODO cast to Exression once mapping is finished, and change
				// UnaryExpression.expression and getters and setters accordingly
				startNode.setVariableExpression(endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;		
	}
	
	private int handleSilence( PHPSilenceExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // expr child
				// TODO cast to Exression once mapping is finished, and change
				// UnaryOperationExpression.expression and getters and setters accordingly
				startNode.setExpression(endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;		
	}

	private int handleShellExec( PHPShellExecExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // expr child
				// TODO cast to Exression once mapping is finished, and change
				// UnaryExpression.expression and getters and setters accordingly
				startNode.setShellCommand(endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;		
	}
	
	private int handleClone( PHPCloneExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // expr child
				// TODO cast to Exression once mapping is finished, and change
				// UnaryExpression.expression and getters and setters accordingly
				startNode.setExpression(endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;		
	}
	
	private int handleExit( PHPExitExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // expr child
				// TODO cast to Exression once mapping is finished, and change
				// UnaryExpression.expression and getters and setters accordingly
				startNode.setExpression(endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;		
	}
	
	private int handlePrint( PHPPrintExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // expr child
				// TODO cast to Exression once mapping is finished, and change
				// UnaryExpression.expression and getters and setters accordingly
				startNode.setExpression(endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;		
	}
	
	private int handleIncludeOrEval( PHPIncludeOrEvalExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // expr child
				// TODO cast to Exression once mapping is finished, and change
				// UnaryExpression.expression and getters and setters accordingly
				startNode.setIncludeOrEvalExpression(endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;		
	}
	
	private int handleUnaryOperation( UnaryOperationExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // expr child
				// TODO cast to Exression once mapping is finished, and change
				// UnaryOperationExpression.expression and getters and setters accordingly
				startNode.setExpression(endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;		
	}
	
	private int handlePreInc( PreIncOperationExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // expr child
				startNode.setVariableExpression((Expression)endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;		
	}

	private int handlePreDec( PreDecOperationExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // expr child
				startNode.setVariableExpression((Expression)endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;		
	}
	
	private int handlePostInc( PostIncOperationExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // expr child
				startNode.setVariableExpression((Expression)endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;		
	}

	private int handlePostDec( PostDecOperationExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // expr child
				startNode.setVariableExpression((Expression)endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;		
	}
	
	private int handleYieldFrom( PHPYieldFromExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // expr child
				// TODO cast to Exression once mapping is finished, and change
				// PHPYieldFromExpression.fromExpression and getters and setters accordingly
				startNode.setFromExpression(endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;		
	}
	
	private int handleGlobal( PHPGlobalStatement startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // var child
				startNode.setVariable((Variable)endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;
	}
	
	private int handleUnset( PHPUnsetStatement startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // var child
				startNode.setVariableExpression((Expression)endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;
	}
	
	private int handleReturn( ReturnStatement startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // expr child
				startNode.setReturnExpression(endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;
	}
	
	private int handleLabel( Label startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // name child
				startNode.setNameChild(endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;
	}
	
	private int handleReference( PHPReferenceExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // var child
				startNode.setVariable((Variable)endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;
	}
	
	private int handleHaltCompiler( PHPHaltCompilerStatement startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // offset child
				startNode.setOffset(endNode);
				// TODO in time, we should be able to cast endNode to PrimaryExpression (or IntegerExpression);
				// then, change PHPHaltCompilerStatement.offset to be a PrimaryExpression instead
				// of a generic ASTNode, and getOffset() and setOffset() accordingly
				break;
				
			default:
				errno = 1;
		}
		
		return errno;
	}
	
	private int handleEcho( PHPEchoStatement startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // expr child
				startNode.setEchoExpression(endNode);
				// TODO in time, we should be able to cast endNode to Expression;
				// then, change PHPEchoStatement.echoExpression to be an Expression instead
				// of a generic ASTNode, and getEchoExpression() and setEchoExpression() accordingly
				break;
				
			default:
				errno = 1;
		}
		
		return errno;
	}
	
	private int handleThrow( ThrowStatement startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // expr child
				startNode.setThrowExpression(endNode);
				// TODO in time, we should be able to cast endNode to Expression;
				// then, change ThrowStatement.throwExpression to be an Expression instead
				// of a generic ASTNode, and getThrowExpression() and setThrowExpression() accordingly
				break;
				
			default:
				errno = 1;
		}
		
		return errno;
	}
	
	private int handleGoto( GotoStatement startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // label child
				startNode.setTargetLabel(endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;
	}
	
	private int handleBreak( PHPBreakStatement startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // depth child
				startNode.setDepth(endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;		
	}
	
	private int handleContinue( PHPContinueStatement startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // depth child
				startNode.setDepth(endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;		
	}


	/* nodes with exactly 2 children */

	private int handleArrayIndexing( ArrayIndexing startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // expr child: Expression node
				// TODO in time, we should be able to cast endNode to Expression;
				// then, change ArrayIndexing.arrayExpression to be an Expression instead
				// of a generic ASTNode, and getArrayExpression() and setArrayExpression() accordingly
				startNode.setArrayExpression(endNode);
				break;
			case 1: // dim child: Expression or NULL node
				// TODO in time, we should be able to cast endNode to Expression,
				// unless it's a null node; then, use case distinction here,
				// change ArrayIndexing.indexExpression to be an Expression instead
				// of a generic ASTNode, and getIndexExpression() and setIndexExpression() accordingly
				startNode.setIndexExpression(endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}
	
	private int handleProperty( PropertyExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // expr child: Expression node
				// TODO in time, we should be able to cast endNode to Expression;
				// then, change PropertyExpression.objectExpression to be an Expression instead
				// of a generic ASTNode, and getObjectExpression() and setObjectExpression() accordingly
				startNode.setObjectExpression(endNode);
				break;
			case 1: // prop child: string node
				startNode.setPropertyName(endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}
	
	private int handleStaticProperty( StaticPropertyExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // class child: Expression node
				// TODO in time, we should be able to cast endNode to Expression;
				// then, change StaticPropertyExpression.classExpression to be an Expression instead
				// of a generic ASTNode, and getClassExpression() and setClassExpression() accordingly
				startNode.setClassExpression(endNode);
				break;
			case 1: // prop child: string node
				startNode.setPropertyName(endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}
	
	private int handleCall( CallExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // expr child: Expression node
				// TODO in time, we should be able to cast endNode to Expression;
				// then, change CallExpression.targetFunc to be an Expression instead
				// of a generic ASTNode, and getTargetFunc() and setTargetFunc() accordingly
				startNode.setTargetFunc(endNode);
				break;
			case 1: // args child: ArgumentList node
				startNode.setArgumentList((ArgumentList)endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}
	
	private int handleClassConstant( ClassConstantExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // class child: Expression node
				// TODO in time, we should be able to cast endNode to Expression;
				// then, change ClassConstantExpression.classExpression to be an Expression instead
				// of a generic ASTNode, and getClassExpression() and setClassExpression() accordingly
				startNode.setClassExpression(endNode);
				break;
			case 1: // const child: string node
				startNode.setConstantName(endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}
	
	private int handleAssign( AssignmentExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // var child: Expression node
				// TODO in time, we should be able to cast endNode to Expression;
				// then, change BinaryExpression.left to be an Expression instead
				// of a generic ASTNode, and getVariable() and setVariable() accordingly
				startNode.setVariable(endNode);
				break;
			case 1: // expr child: Expression node
				// TODO in time, we should be able to cast endNode to Expression;
				// then, change BinaryExpression.right to be an Expression instead
				// of a generic ASTNode, and getAssignExpression() and setAssignExpression() accordingly
				startNode.setAssignExpression(endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}
	
	private int handleAssignByRef( PHPAssignmentByRefExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // var child: Expression node
				// TODO in time, we should be able to cast endNode to Expression;
				// then, change BinaryExpression.left to be an Expression instead
				// of a generic ASTNode, and getVariable() and setVariable() accordingly
				startNode.setVariable(endNode);
				break;
			case 1: // expr child: Expression node
				// TODO in time, we should be able to cast endNode to Expression;
				// then, change BinaryExpression.right to be an Expression instead
				// of a generic ASTNode, and getAssignExpression() and setAssignExpression() accordingly
				startNode.setAssignExpression(endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}
	
	private int handleAssignWithOp( AssignmentWithOpExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // var child: Expression node
				// TODO in time, we should be able to cast endNode to Expression;
				// then, change BinaryExpression.left to be an Expression instead
				// of a generic ASTNode, and getVariable() and setVariable() accordingly
				startNode.setVariable(endNode);
				break;
			case 1: // expr child: Expression node
				// TODO in time, we should be able to cast endNode to Expression;
				// then, change BinaryExpression.right to be an Expression instead
				// of a generic ASTNode, and getAssignExpression() and setAssignExpression() accordingly
				startNode.setAssignExpression(endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}
	
	private int handleBinaryOperation( BinaryOperationExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // left child: Expression node
				// TODO in time, we should be able to cast endNode to Expression;
				// then, change BinaryExpression.left to be an Expression instead
				// of a generic ASTNode, and getLeft() and setLeft() accordingly
				startNode.setLeft(endNode);
				break;
			case 1: // right child: Expression node
				// TODO in time, we should be able to cast endNode to Expression;
				// then, change BinaryExpression.right to be an Expression instead
				// of a generic ASTNode, and getRight() and setRight() accordingly
				startNode.setRight(endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}
	
	private int handleGreater( GreaterExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // left child: Expression node
				// TODO in time, we should be able to cast endNode to Expression;
				// then, change BinaryExpression.left to be an Expression instead
				// of a generic ASTNode, and getLeft() and setLeft() accordingly
				startNode.setLeft(endNode);
				break;
			case 1: // right child: Expression node
				// TODO in time, we should be able to cast endNode to Expression;
				// then, change BinaryExpression.right to be an Expression instead
				// of a generic ASTNode, and getRight() and setRight() accordingly
				startNode.setRight(endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}
	
	private int handleGreaterOrEqual( GreaterOrEqualExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // left child: Expression node
				// TODO in time, we should be able to cast endNode to Expression;
				// then, change BinaryExpression.left to be an Expression instead
				// of a generic ASTNode, and getLeft() and setLeft() accordingly
				startNode.setLeft(endNode);
				break;
			case 1: // right child: Expression node
				// TODO in time, we should be able to cast endNode to Expression;
				// then, change BinaryExpression.right to be an Expression instead
				// of a generic ASTNode, and getRight() and setRight() accordingly
				startNode.setRight(endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}
	
	private int handleAnd( AndExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // left child: Expression node
				// TODO in time, we should be able to cast endNode to Expression;
				// then, change BinaryExpression.left to be an Expression instead
				// of a generic ASTNode, and getLeft() and setLeft() accordingly
				startNode.setLeft(endNode);
				break;
			case 1: // right child: Expression node
				// TODO in time, we should be able to cast endNode to Expression;
				// then, change BinaryExpression.right to be an Expression instead
				// of a generic ASTNode, and getRight() and setRight() accordingly
				startNode.setRight(endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}
	
	private int handleOr( OrExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // left child: Expression node
				// TODO in time, we should be able to cast endNode to Expression;
				// then, change BinaryExpression.left to be an Expression instead
				// of a generic ASTNode, and getLeft() and setLeft() accordingly
				startNode.setLeft(endNode);
				break;
			case 1: // right child: Expression node
				// TODO in time, we should be able to cast endNode to Expression;
				// then, change BinaryExpression.right to be an Expression instead
				// of a generic ASTNode, and getRight() and setRight() accordingly
				startNode.setRight(endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}
	
	private int handleArrayElement( PHPArrayElement startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // value child: Expression node
				// TODO in time, we should be able to cast endNode to Expression;
				// then, change PHPArrayElement.value to be an Expression instead
				// of a generic ASTNode, and getValue() and setValue() accordingly
				startNode.setValue(endNode);
				break;
			case 1: // key child: Expression or NULL node
				// TODO in time, we should be able to ALWAYS cast endNode to Expression,
				// unless it is a NULL node: test that!
				startNode.setKey(endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}
	
	private int handleNew( NewExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // class child: Expression node
				// TODO in time, we should be able to cast endNode to Expression;
				// then, change NewExpression.targetClass to be an Expression instead
				// of a generic ASTNode, and getTargetClass() and setTargetClass() accordingly
				startNode.setTargetClass(endNode);
				break;
			case 1: // args child: ArgumentList node
				startNode.setArgumentList((ArgumentList)endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}
	
	private int handleInstanceof( InstanceofExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // expr child: Expression node
				// TODO in time, we should be able to cast endNode to Expression;
				// then, change InstanceofExpression.instanceExpression to be an Expression instead
				// of a generic ASTNode, and getInstanceExpression() and setInstanceExpression() accordingly
				startNode.setInstanceExpression(endNode);
				break;
			case 1: // class child: Identifier node
				startNode.setClassIdentifier((Identifier)endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}
	
	private int handleYield( PHPYieldExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // value child: Expression or plain or NULL node
				// TODO in time, we should be able to ALWAYS cast endNode to Expression,
				// unless it is a NULL node: test that!
				startNode.setValue(endNode);
				break;
			case 1: // key child: Expression or plain or NULL node
				// TODO in time, we should be able to ALWAYS cast endNode to Expression,
				// unless it is a NULL node: test that!
				startNode.setKey(endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}
	
	private int handleCoalesce( PHPCoalesceExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // left child: Expression or plain node
				startNode.setLeftExpression(endNode);
				break;
			case 1: // right child: Expression or plain node
				startNode.setRightExpression(endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}
	
	private int handleStaticVariable( StaticVariableDeclaration startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // name child: plain node
				startNode.setNameChild(endNode);
				break;
			case 1: // default child: either Expression or NULL node
				// TODO in time, we should be able to cast endNode to Expression;
				// then, change StaticVariableDeclaration.defaultvalue to be an Expression instead
				// of a generic ASTNode, and getDefault() and setDefault() accordingly
				startNode.setDefault(endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;		
	}
	
	private int handleWhile( WhileStatement startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // cond child
				startNode.setCondition(endNode);
				// TODO in time, we should be able to cast endNode to Expression;
				// then, change BlockStarter.condition to be an Expression instead
				// of a generic ASTNode, and getCondition() and setCondition() accordingly
				break;
			case 1: // stmts child: statement node (e.g., AST_STMT_LIST) or NULL node
				if( endNode instanceof Statement)
					startNode.setStatement((Statement)endNode);
				else
					startNode.addChild(endNode);
				// TODO in time, we should be able to ALWAYS cast endNode to Statement,
				// unless it is a NULL node: test that!
				break;

			default:
				errno = 1;
		}

		return errno;
	}
	
	private int handleDo( DoStatement startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // stmts child: statement node (e.g., AST_STMT_LIST) or NULL node
				if( endNode instanceof Statement)
					startNode.setStatement((Statement)endNode);
				else
					startNode.addChild(endNode);
				// TODO in time, we should be able to ALWAYS cast endNode to Statement,
				// unless it is a NULL node: test that!
				break;
			case 1: // cond child
				startNode.setCondition(endNode);
				// TODO in time, we should be able to cast endNode to Expression;
				// then, change BlockStarter.condition to be an Expression instead
				// of a generic ASTNode, and getCondition() and setCondition() accordingly
				break;

			default:
				errno = 1;
		}

		return errno;
	}
	
	private int handleIfElement( PHPIfElement startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // cond child
				startNode.setCondition(endNode);
				// TODO in time, we should be able to cast endNode to Expression;
				// then, change BlockStarter.condition to be an Expression instead
				// of a generic ASTNode, and getCondition() and setCondition() accordingly
				break;
			case 1: // stmts child: statement node (e.g., AST_STMT_LIST) or NULL node
				if( endNode instanceof Statement)
					startNode.setStatement((Statement)endNode);
				else
					startNode.addChild(endNode);
				// TODO in time, we should be able to ALWAYS cast endNode to Statement,
				// unless it is a NULL node: test that!
				break;

			default:
				errno = 1;
		}

		return errno;
	}
	
	private int handleSwitch( PHPSwitchStatement startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // expr child: Expression node
				// TODO in time, we should be able to cast endNode to Expression;
				// then, change PHPSwitchStatement.expression to be an Expression instead
				// of a generic ASTNode, and getExpression() and setExpression() accordingly
				startNode.setExpression(endNode);
				break;
			case 1: // list child: AST_SWITCH_LIST
				startNode.setSwitchList((PHPSwitchList)endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}
	
	private int handleSwitchCase( PHPSwitchCase startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // value child: plain node or NULL
				startNode.setValue(endNode);
				break;
			case 1: // stmts child: AST_STMT_LIST
				startNode.setStatement((CompoundStatement)endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}
	
	private int handleDeclare( PHPDeclareStatement startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // declares child: AST_CONST_DECL node
				startNode.setDeclares((ConstantDeclaration)endNode);
				break;
			case 1: // stmts child: AST_STMT_LIST or NULL node
				if( endNode instanceof CompoundStatement)
					startNode.setContent((CompoundStatement)endNode);
				else
					startNode.addChild(endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}
	
	private int handlePropertyElement( PropertyElement startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // name child: plain node
				startNode.setNameChild(endNode);
				break;
			case 1: // default child: either Expression or NULL node
				// TODO in time, we should be able to cast endNode to Expression;
				// then, change PropertyElement.defaultvalue to be an Expression instead
				// of a generic ASTNode, and getDefault() and setDefault() accordingly
				startNode.setDefault(endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;		
	}
	
	private int handleConstantElement( ConstantElement startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // name child: plain node
				startNode.setNameChild(endNode);
				break;
			case 1: // default child: Expression node
				startNode.setValue(endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;
	}
	
	private int handleUseTrait( PHPUseTrait startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // traits child: IdentifierList node
				startNode.setTraits((IdentifierList)endNode);
				break;
			case 1: // adaptations child: PHPTraitAdaptations or NULL node
				if( endNode instanceof PHPTraitAdaptations)
					startNode.setTraitAdaptations((PHPTraitAdaptations)endNode);
				else
					startNode.addChild(endNode);
				break;
	
			default:
				errno = 1;
		}
		
		return errno;
	}
	
	private int handleTraitPrecedence( PHPTraitPrecedence startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // method child: MethodReference node
				startNode.setMethod((MethodReference)endNode);
				break;
			case 1: // insteadof child: IdentifierList node
				startNode.setInsteadOf((IdentifierList)endNode);
				break;

			default:
				errno = 1;
		}
		
		return errno;
	}
	
	private int handleMethodReference( MethodReference startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // class child: Identifier or NULL node
				if( endNode instanceof Identifier)
					startNode.setClassIdentifier((Identifier)endNode);
				else
					startNode.addChild(endNode);
				break;
			case 1: // method child: string node
				startNode.setMethodName(endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;
	}
	
	private int handleNamespace( NamespaceStatement startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // name child: string or NULL node
				startNode.setName(endNode);
				break;
			case 1: // stmts child: AST_STMT_LIST or NULL node
				if( endNode instanceof CompoundStatement)
					startNode.setContent((CompoundStatement)endNode);
				else
					startNode.addChild(endNode);
				break;

			default:
				errno = 1;
		}
		
		return errno;
	}
	
	private int handleUseElement( UseElement startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // name child: string node
				startNode.setNamespace(endNode);
				break;
			case 1: // alias child: string or NULL node
				// TODO in time, we should be able to cast endNode to a plain
				// node type that extends Expression, unless endNode is a null
				// node; then, adapt UseElement to use a string node and
				// make a case distinction here to use setAlias() or addChild()
				startNode.setAlias(endNode);
				break;

			default:
				errno = 1;
		}
		
		return errno;
	}
	
	private int handleTraitAlias( PHPTraitAlias startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // method child: MethodReference node
				startNode.setMethod((MethodReference)endNode);
				break;
			case 1: // alias child: string or NULL node
				// TODO in time, we should be able to cast endNode to a plain
				// node type that extends Expression, unless endNode is a null
				// node; then, adapt PHPTraitAlias to use a string node and
				// make a case distinction here to use setAlias() or addChild()
				startNode.setAlias(endNode);
				break;

			default:
				errno = 1;
		}
		
		return errno;
	}
	
	private int handleGroupUse( PHPGroupUseStatement startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // prefix child: string node
				startNode.setPrefix(endNode);
				break;
			case 1: // uses child: AST_USE node
				startNode.setUses((UseStatement)endNode);
				break;

			default:
				errno = 1;
		}
		
		return errno;
	}


	/* nodes with exactly 3 children */
	
	private int handleMethodCall( MethodCallExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // expr child: Expression node
				// TODO in time, we should be able to cast endNode to Expression;
				// then, change MethodCallExpression.targetObject to be an Expression instead
				// of a generic ASTNode, and getTargetObject() and setTargetObject() accordingly
				startNode.setTargetObject(endNode);
				break;
			case 1: // method child: "string" node
				// TODO in time, we should be able to cast endNode to Expression;
				// then, change CallExpression.targetFunc to be an Expression instead
				// of a generic ASTNode, and getTargetFunc() and setTargetFunc() accordingly
				startNode.setTargetFunc(endNode);
				break;
			case 2: // args child: ArgumentList node
				startNode.setArgumentList((ArgumentList)endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}
	
	private int handleStaticCall( StaticCallExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // class child: Identifier node
				startNode.setTargetClass((Identifier)endNode);
				break;
			case 1: // method child: "string" node
				// TODO in time, we should be able to cast endNode to a plain
				// node type that extends Expression.
				startNode.setTargetFunc(endNode);
				break;
			case 2: // args child: ArgumentList node
				startNode.setArgumentList((ArgumentList)endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}
	
	private int handleConditional( ConditionalExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // cond child: Expression node
				// TODO in time, we should be able to cast endNode to Expression;
				// then, change ConditionalExpression.condition to be an Expression instead
				// of a generic ASTNode, and getCondition() and setCondition() accordingly
				startNode.setCondition(endNode);
				break;
			case 1: // trueExpr child: Expression node or NULL
				// TODO in time, we should be able to cast endNode to Expression, unless it is NULL;
				// then, use an appropriate case distinction here,
				// and change ConditionalExpression.trueExpression to be an Expression instead
				// of a generic ASTNode, and getTrueExpression() and getTrueExpression() accordingly
				startNode.setTrueExpression(endNode);
				break;
			case 2: // falseExpr child: Expression node
				// TODO in time, we should be able to cast endNode to Expression;
				// then, change ConditionalExpression.falseExpression to be an Expression instead
				// of a generic ASTNode, and getFalseExpression() and getFalseExpression() accordingly
				startNode.setFalseExpression(endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;		
	}
	
	private int handleTry( TryStatement startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // tryStmts child: CompoundStatement node
				startNode.setContent((CompoundStatement)endNode);
				break;
			case 1: // catches child: CatchList node
				startNode.setCatchList((CatchList)endNode);
				break;
			case 2: // finallyStmts child: CompoundStatement or NULL node
				if( endNode instanceof CompoundStatement)
					startNode.setFinallyContent((CompoundStatement)endNode);
				else
					startNode.addChild(endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;		
	}
	
	private int handleCatch( CatchStatement startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // exception child: Identifier node
				startNode.setExceptionIdentifier((Identifier)endNode);
				break;
			case 1: // varName child: plain node
				startNode.setVariableName(endNode);
				break;
			case 2: // stmts child: CompoundStatement node
				startNode.setContent((CompoundStatement)endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;		
	}
	
	private int handleParameter( PHPParameter startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // type child: either Identifier or NULL node
				startNode.setType(endNode);
				break;
			case 1: // name child: plain node
				startNode.setNameChild(endNode);
				break;
			case 2: // default child: either plain or NULL node
				startNode.setDefault(endNode);
				break;
				
			default:
				errno = 1;
		}
		
		return errno;		
	}
	

	/* nodes with exactly 4 children */

	private int handleFor( ForStatement startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // init child: either Expression or NULL node
				startNode.setForInitExpression(endNode);
				break;
			case 1: // cond child: either Expression or NULL node
				// note that the cond child may be NULL, as opposed to while and do-while loops
				startNode.setCondition(endNode);
				break;
			case 2: // loop child: either Expression or NULL node
				startNode.setForLoopExpression(endNode);
				break;
			case 3: // stmts child: statement node (e.g., AST_STMT_LIST) or NULL node
				if( endNode instanceof Statement)
					startNode.setStatement((Statement)endNode);
				else
					startNode.addChild(endNode);
				// TODO in time, we should be able to ALWAYS cast endNode to Statement,
				// unless it is a NULL node: test that!
				break;

			default:
				errno = 1;
		}
		
		return errno;		
	}
	
	private int handleForEach( ForEachStatement startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // expr child: Expression node
				// TODO in time, we should be able to cast endNode to Expression;
				// then, change ForEach.iteratedObject to be an Expression instead
				// of a generic ASTNode, and getIteratedObject() and setIteratedObject() accordingly
				startNode.setIteratedObject(endNode);
				break;
			case 1: // value child: Variable or PHPReferenceExpression node
				startNode.setValueExpression((Expression)endNode);
				break;
			case 2: // key child: either Variable or NULL node
				if( endNode instanceof Variable)
					startNode.setKeyVariable((Variable)endNode);
				else
					startNode.addChild(endNode);
				break;
			case 3: // stmts child: statement node (e.g., AST_STMT_LIST) or NULL node
				if( endNode instanceof Statement)
					startNode.setStatement((Statement)endNode);
				else
					startNode.addChild(endNode);
				// TODO in time, we should be able to ALWAYS cast endNode to Statement,
				// unless it is a NULL node: test that!
				break;

			default:
				errno = 1;
		}
		
		return errno;		
	}
	
	
	/* nodes with an arbitrary number of children */
	
	private int handleArgumentList( ArgumentList startNode, ASTNode endNode, int childnum)
	{
		startNode.addArgument(endNode); // TODO cast to Expression

		return 0;
	}
	
	private int handleList( PHPListExpression startNode, ASTNode endNode, int childnum)
	{
		startNode.addElement(endNode); // TODO cast to Expression

		return 0;
	}
	
	private int handleArray( PHPArrayExpression startNode, ASTNode endNode, int childnum)
	{
		startNode.addArrayElement((PHPArrayElement)endNode);

		return 0;
	}
	
	private int handleEncapsList( PHPEncapsListExpression startNode, ASTNode endNode, int childnum)
	{
		startNode.addElement(endNode); // TODO cast to Expression

		return 0;
	}
	
	private int handleExpressionList( ExpressionList startNode, ASTNode endNode, int childnum)
	{
		startNode.addExpression(endNode); // TODO cast to Expression

		return 0;
	}
	
	private int handleCompound( CompoundStatement startNode, ASTNode endNode, int childnum)
	{
		startNode.addChild(endNode); // TODO introduce addStatement in CompoundStatement (and cast to Statement)

		return 0;
	}
	
	private int handleIf( PHPIfStatement startNode, ASTNode endNode, int childnum)
	{
		startNode.addIfElement((PHPIfElement)endNode);

		return 0;
	}
	
	private int handleSwitchList( PHPSwitchList startNode, ASTNode endNode, int childnum)
	{
		startNode.addSwitchCase((PHPSwitchCase)endNode);

		return 0;
	}
	
	private int handleCatchList( CatchList startNode, ASTNode endNode, int childnum)
	{
		startNode.addCatchStatement((CatchStatement)endNode);

		return 0;
	}
	
	private int handleParameterList( ParameterList startNode, ASTNode endNode, int childnum)
	{
		startNode.addParameter((PHPParameter)endNode);

		return 0;
	}
	
	private int handleClosureUses( ClosureUses startNode, ASTNode endNode, int childnum)
	{
		startNode.addClosureVar((ClosureVar)endNode);

		return 0;
	}
	
	private int handlePropertyDeclaration( PropertyDeclaration startNode, ASTNode endNode, int childnum)
	{
		startNode.addPropertyElement((PropertyElement)endNode);

		return 0;
	}
	
	private int handleConstantDeclaration( ConstantDeclaration startNode, ASTNode endNode, int childnum)
	{
		startNode.addConstantElement((ConstantElement)endNode);

		return 0;
	}
	
	private int handleClassConstantDeclaration( ClassConstantDeclaration startNode, ASTNode endNode, int childnum)
	{
		startNode.addConstantElement((ConstantElement)endNode);

		return 0;
	}
	
	private int handleIdentifierList( IdentifierList startNode, ASTNode endNode, int childnum)
	{
		startNode.addIdentifier((Identifier)endNode);

		return 0;
	}
	
	private int handleTraitAdaptations( PHPTraitAdaptations startNode, ASTNode endNode, int childnum)
	{
		startNode.addTraitAdaptationElement((PHPTraitAdaptationElement)endNode);

		return 0;
	}
	
	private int handleUseStatement( UseStatement startNode, ASTNode endNode, int childnum)
	{
		startNode.addUseElement((UseElement)endNode);

		return 0;
	}
}
