package tools.php.ast2cpg;

import ast.ASTNode;
import ast.NullNode;
import ast.expressions.ArgumentList;
import ast.expressions.ArrayIndexing;
import ast.expressions.AssignmentExpression;
import ast.expressions.AssignmentWithOpExpression;
import ast.expressions.BinaryOperationExpression;
import ast.expressions.CallExpressionBase;
import ast.expressions.CastExpression;
import ast.expressions.ClassConstantExpression;
import ast.expressions.ConditionalExpression;
import ast.expressions.Constant;
import ast.expressions.Expression;
import ast.expressions.ExpressionList;
import ast.expressions.Identifier;
import ast.expressions.IdentifierList;
import ast.expressions.InstanceofExpression;
import ast.expressions.IntegerExpression;
import ast.expressions.NewExpression;
import ast.expressions.PostDecOperationExpression;
import ast.expressions.PostIncOperationExpression;
import ast.expressions.PreDecOperationExpression;
import ast.expressions.PreIncOperationExpression;
import ast.expressions.PropertyExpression;
import ast.expressions.StaticPropertyExpression;
import ast.expressions.StringExpression;
import ast.expressions.UnaryOperationExpression;
import ast.expressions.Variable;
import ast.functionDef.ParameterList;
import ast.logical.statements.CompoundStatement;
import ast.logical.statements.Label;
import ast.logical.statements.Statement;
import ast.php.declarations.ClassDef;
import ast.php.expressions.ClassExpression;
import ast.php.expressions.ClosureExpression;
import ast.php.expressions.MethodCallExpression;
import ast.php.expressions.ArrayElement;
import ast.php.expressions.ArrayExpression;
import ast.php.expressions.AssignmentByRefExpression;
import ast.php.expressions.CloneExpression;
import ast.php.expressions.CoalesceExpression;
import ast.php.expressions.EmptyExpression;
import ast.php.expressions.EncapsListExpression;
import ast.php.expressions.ExitExpression;
import ast.php.expressions.IncludeOrEvalExpression;
import ast.php.expressions.IssetExpression;
import ast.php.expressions.ListExpression;
import ast.php.expressions.PrintExpression;
import ast.php.expressions.ReferenceExpression;
import ast.php.expressions.ShellExecExpression;
import ast.php.expressions.UnpackExpression;
import ast.php.expressions.YieldExpression;
import ast.php.expressions.YieldFromExpression;
import ast.php.expressions.StaticCallExpression;
import ast.php.functionDef.Closure;
import ast.php.functionDef.ClosureUses;
import ast.php.functionDef.ClosureVar;
import ast.php.functionDef.Method;
import ast.php.functionDef.FunctionDef;
import ast.php.functionDef.Parameter;
import ast.php.functionDef.TopLevelFunctionDef;
import ast.php.statements.ClassConstantDeclaration;
import ast.php.statements.ConstantDeclaration;
import ast.php.statements.ConstantElement;
import ast.php.statements.EchoStatement;
import ast.php.statements.GlobalStatement;
import ast.php.statements.GroupUseStatement;
import ast.php.statements.HaltCompilerStatement;
import ast.php.statements.UnsetStatement;
import ast.php.statements.PropertyDeclaration;
import ast.php.statements.PropertyElement;
import ast.php.statements.StaticVariableDeclaration;
import ast.php.statements.blockstarters.DeclareStatement;
import ast.php.statements.blockstarters.IfElement;
import ast.php.statements.blockstarters.IfStatement;
import ast.php.statements.blockstarters.SwitchCase;
import ast.php.statements.blockstarters.SwitchList;
import ast.php.statements.blockstarters.SwitchStatementPHP;
import ast.php.statements.blockstarters.TraitAdaptationElement;
import ast.php.statements.blockstarters.TraitAdaptations;
import ast.php.statements.blockstarters.TraitAlias;
import ast.php.statements.blockstarters.TraitPrecedence;
import ast.php.statements.blockstarters.UseTrait;
import ast.statements.ExpressionStatement;
import ast.statements.UseElement;
import ast.statements.UseStatement;
import ast.statements.blockstarters.CatchList;
import ast.statements.blockstarters.CatchStatement;
import ast.statements.blockstarters.DoStatement;
import ast.statements.blockstarters.ForEachStatement;
import ast.statements.blockstarters.ForStatement;
import ast.statements.blockstarters.MethodReference;
import ast.statements.blockstarters.NamespaceStatement;
import ast.statements.blockstarters.TryStatement;
import ast.statements.blockstarters.WhileStatement;
import ast.statements.jump.BreakStatement;
import ast.statements.jump.ContinueStatement;
import ast.statements.jump.GotoStatement;
import ast.statements.jump.ReturnStatement;
import ast.statements.jump.ThrowStatement;
import inputModules.csv.PHPCSVEdgeTypes;
import inputModules.csv.PHPCSVNodeTypes;
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

		// Special treatment for closures: they are expressions, so we create a ClosureExpression to hold them
		// We cannot do this in the PHPCSVNodeInterpreter, since CSV2AST expects an instance of PHPFunctionDef
		// for the first row of the CSVAST that it converts. (Closure is an instance of PHPFunctionDef and thus
		// cannot be an instance of Expression.)
		if( endNode instanceof Closure)
			endNode = createClosureExpression((Closure)endNode);

		int errno = 0;
		String type = startNode.getProperty(PHPCSVNodeTypes.TYPE.getName());
		switch (type)
		{
			// - null nodes (leafs)
			// - primary expressions (leafs)
			case PHPCSVNodeTypes.TYPE_NULL:
			case PHPCSVNodeTypes.TYPE_INTEGER:
			case PHPCSVNodeTypes.TYPE_DOUBLE:
			case PHPCSVNodeTypes.TYPE_STRING:
				errno = 2;
				break;

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
				errno = handleClass((ClassDef)startNode, endNode, childnum);
				break;

			// nodes without children (leafs)
			// expressions
			case PHPCSVNodeTypes.TYPE_MAGIC_CONST:
			case PHPCSVNodeTypes.TYPE_TYPE:
				errno = 2;
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
				errno = handleUnpack((UnpackExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_CAST:
				errno = handleCast((CastExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_EMPTY:
				errno = handleEmpty((EmptyExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_ISSET:
				errno = handleIsset((IssetExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_SHELL_EXEC:
				errno = handleShellExec((ShellExecExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_CLONE:
				errno = handleClone((CloneExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_EXIT:
				errno = handleExit((ExitExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_PRINT:
				errno = handlePrint((PrintExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_INCLUDE_OR_EVAL:
				errno = handleIncludeOrEval((IncludeOrEvalExpression)startNode, endNode, childnum);
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
				errno = handleYieldFrom((YieldFromExpression)startNode, endNode, childnum);
				break;

			// statements
			case PHPCSVNodeTypes.TYPE_GLOBAL:
				errno = handleGlobal((GlobalStatement)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_UNSET:
				errno = handleUnset((UnsetStatement)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_RETURN:
				errno = handleReturn((ReturnStatement)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_LABEL:
				errno = handleLabel((Label)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_REF:
				errno = handleReference((ReferenceExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_HALT_COMPILER:
				errno = handleHaltCompiler((HaltCompilerStatement)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_ECHO:
				errno = handleEcho((EchoStatement)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_THROW:
				errno = handleThrow((ThrowStatement)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_GOTO:
				errno = handleGoto((GotoStatement)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_BREAK:
				errno = handleBreak((BreakStatement)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_CONTINUE:
				errno = handleContinue((ContinueStatement)startNode, endNode, childnum);
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
				errno = handleCall((CallExpressionBase)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_CLASS_CONST:
				errno = handleClassConstant((ClassConstantExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_ASSIGN:
				errno = handleAssign((AssignmentExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_ASSIGN_REF:
				errno = handleAssignByRef((AssignmentByRefExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_ASSIGN_OP:
				errno = handleAssignWithOp((AssignmentWithOpExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_BINARY_OP:
				errno = handleBinaryOperation((BinaryOperationExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_ARRAY_ELEM:
				errno = handleArrayElement((ArrayElement)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_NEW:
				errno = handleNew((NewExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_INSTANCEOF:
				errno = handleInstanceof((InstanceofExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_YIELD:
				errno = handleYield((YieldExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_COALESCE:
				errno = handleCoalesce((CoalesceExpression)startNode, endNode, childnum);
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
				errno = handleIfElement((IfElement)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_SWITCH:
				errno = handleSwitch((SwitchStatementPHP)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_SWITCH_CASE:
				errno = handleSwitchCase((SwitchCase)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_PROP_ELEM:
				errno = handlePropertyElement((PropertyElement)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_DECLARE:
				errno = handleDeclare((DeclareStatement)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_CONST_ELEM:
				errno = handleConstantElement((ConstantElement)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_USE_TRAIT:
				errno = handleUseTrait((UseTrait)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_TRAIT_PRECEDENCE:
				errno = handleTraitPrecedence((TraitPrecedence)startNode, endNode, childnum);
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
				errno = handleTraitAlias((TraitAlias)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_GROUP_USE:
				errno = handleGroupUse((GroupUseStatement)startNode, endNode, childnum);
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
				errno = handleParameter((Parameter)startNode, endNode, childnum);
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
				errno = handleList((ListExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_ARRAY:
				errno = handleArray((ArrayExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_ENCAPS_LIST:
				errno = handleEncapsList((EncapsListExpression)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_EXPR_LIST:
				errno = handleExpressionList((ExpressionList)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_STMT_LIST:
				errno = handleCompound((CompoundStatement)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_IF:
				errno = handleIf((IfStatement)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_SWITCH_LIST:
				errno = handleSwitchList((SwitchList)startNode, endNode, childnum);
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
				errno = handleTraitAdaptations((TraitAdaptations)startNode, endNode, childnum);
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
		else if( 2 == errno)
			throw new InvalidCSVFile("While trying to handle row "
					+ row.toString() + ": Cannot add child to leaf node "
					+ type + ".");

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
				startNode.setNameChild((StringExpression)endNode);
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
				startNode.setNameChild((StringExpression)endNode);
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
			case 0: // stmts child: either CompoundStatement or NULL
				if( endNode instanceof NullNode)
					startNode.addChild(endNode);
				else
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
				if( endNode instanceof NullNode)
					startNode.addChild(endNode);
				else
					startNode.setReturnType((Identifier)endNode);
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
				if( endNode instanceof NullNode)
					startNode.addChild(endNode);
				else
					startNode.setClosureUses((ClosureUses)endNode);
				break;
			case 2: // stmts child
				startNode.setContent((CompoundStatement)endNode);
				break;
			case 3: // returnType child: either Identifier or NULL node
				if( endNode instanceof NullNode)
					startNode.addChild(endNode);
				else
					startNode.setReturnType((Identifier)endNode);
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
				if( endNode instanceof NullNode)
					startNode.addChild(endNode);
				else
					startNode.setContent((CompoundStatement)endNode);
				break;
			case 3: // returnType child: either Identifier or NULL node
				if( endNode instanceof NullNode)
					startNode.addChild(endNode);
				else
					startNode.setReturnType((Identifier)endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}

	private int handleClass( ClassDef startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // extends child: either Identifier or NULL node
				if( endNode instanceof NullNode)
					startNode.addChild(endNode);
				else
					startNode.setExtends((Identifier)endNode);
				break;
			case 1: // implements child: either IdentifierList or NULL node
				if( endNode instanceof NullNode)
					startNode.addChild(endNode);
				else
					startNode.setImplements((IdentifierList)endNode);
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
				startNode.setNameExpression((Expression)endNode);
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

	private int handleUnpack( UnpackExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // expr child
				startNode.setExpression((Expression)endNode);
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
				startNode.setCastExpression((Expression)endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}

	private int handleEmpty( EmptyExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // expr child
				startNode.setExpression((Expression)endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}

	private int handleIsset( IssetExpression startNode, ASTNode endNode, int childnum)
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

	private int handleShellExec( ShellExecExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // expr child
				startNode.setShellCommand((Expression)endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}

	private int handleClone( CloneExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // expr child
				startNode.setExpression((Expression)endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}

	private int handleExit( ExitExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // expr child: Expression or NULL node
				if( endNode instanceof NullNode)
					startNode.addChild(endNode);
				else
					startNode.setExpression((Expression)endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}

	private int handlePrint( PrintExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // expr child
				startNode.setExpression((Expression)endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}

	private int handleIncludeOrEval( IncludeOrEvalExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // expr child
				startNode.setIncludeOrEvalExpression((Expression)endNode);
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
				startNode.setExpression((Expression)endNode);
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

	private int handleYieldFrom( YieldFromExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // expr child
				startNode.setFromExpression((Expression)endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}

	private int handleGlobal( GlobalStatement startNode, ASTNode endNode, int childnum)
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

	private int handleUnset( UnsetStatement startNode, ASTNode endNode, int childnum)
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
			case 0: // expr child: Expression or null node
				if( endNode instanceof NullNode)
					startNode.addChild(endNode);
				else
					startNode.setReturnExpression((Expression)endNode);
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
				startNode.setNameChild((StringExpression)endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}

	private int handleReference( ReferenceExpression startNode, ASTNode endNode, int childnum)
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

	private int handleHaltCompiler( HaltCompilerStatement startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // offset child
				startNode.setOffset((IntegerExpression)endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}

	private int handleEcho( EchoStatement startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // expr child
				startNode.setEchoExpression((Expression)endNode);
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
				startNode.setThrowExpression((Expression)endNode);
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
				startNode.setTargetLabel((StringExpression)endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}

	private int handleBreak( BreakStatement startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // depth child: IntegerExpression or null node
				if( endNode instanceof NullNode)
					startNode.addChild(endNode);
				else {
					try {
						startNode.setDepth((IntegerExpression)endNode);
					}
					catch( ClassCastException e) {
						// in PHP 5.4, Variable children were allowed and we might still stumble upon
						// such code when using Joern on older PHP programs
						System.err.println("Warning: node " + startNode.getNodeId() + " is a break statement "
								+ "with a non-constant numerical argument. This has been disallowed since PHP 5.4 "
								+ "and is unsupported in Joern. Assuming a numerical argument of 0.");
						// CFG creation will handle this when the depth child is undefined
					}
				}
				break;

			default:
				errno = 1;
		}

		return errno;
	}

	private int handleContinue( ContinueStatement startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // depth child: IntegerExpression or null node
				if( endNode instanceof NullNode)
					startNode.addChild(endNode);
				else
					try {
						startNode.setDepth((IntegerExpression)endNode);
					}
					catch( ClassCastException e) {
						// in PHP 5.4, Variable children were allowed and we might still stumble upon
						// such code when using Joern on older PHP programs
						System.err.println("Warning: node " + startNode.getNodeId() + " is a continue statement "
								+ "with a non-constant numerical argument. This has been disallowed since PHP 5.4 "
								+ "and is unsupported in Joern. Assuming a numerical argument of 0.");
						// CFG creation will handle this when the depth child is undefined
					}
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
				startNode.setArrayExpression((Expression)endNode);
				break;
			case 1: // dim child: Expression or NULL node
				if( endNode instanceof NullNode)
					startNode.addChild(endNode);
				else
					startNode.setIndexExpression((Expression)endNode);
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
				startNode.setObjectExpression((Expression)endNode);
				break;
			case 1: // prop child: Expression node
				startNode.setPropertyExpression((Expression)endNode);
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
				startNode.setClassExpression((Expression)endNode);
				break;
			case 1: // prop child: Expression node
				startNode.setPropertyExpression((Expression)endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}

	private int handleCall( CallExpressionBase startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // expr child: Expression node
				startNode.setTargetFunc((Expression)endNode);
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
				startNode.setClassExpression((Expression)endNode);
				break;
			case 1: // const child: StringExpression node
				startNode.setConstantName((StringExpression)endNode);
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
				startNode.setLeft((Expression)endNode);
				break;
			case 1: // expr child: Expression node
				startNode.setRight((Expression)endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}

	private int handleAssignByRef( AssignmentByRefExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // var child: Expression node
				startNode.setLeft((Expression)endNode);
				break;
			case 1: // expr child: Expression node
				startNode.setRight((Expression)endNode);
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
				startNode.setLeft((Expression)endNode);
				break;
			case 1: // expr child: Expression node
				startNode.setRight((Expression)endNode);
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
				startNode.setLeft((Expression)endNode);
				break;
			case 1: // right child: Expression node
				startNode.setRight((Expression)endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}

	private int handleArrayElement( ArrayElement startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // value child: Expression node
				startNode.setValue((Expression)endNode);
				break;
			case 1: // key child: Expression or null node
				if( endNode instanceof NullNode)
					startNode.addChild(endNode);
				else
					startNode.setKey((Expression)endNode);
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
			case 0: // class child: ClassDef or Expression node
				if( endNode instanceof ClassDef) // the child is a class used as an expression
					startNode.setTargetClass(createClassExpression((ClassDef)endNode));
				else
					startNode.setTargetClass((Expression)endNode);
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
				startNode.setInstanceExpression((Expression)endNode);
				break;
			case 1: // class child: Expression node
				startNode.setClassExpression((Expression)endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}

	private int handleYield( YieldExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // value child: Expression or null node
				if( endNode instanceof NullNode)
					startNode.addChild(endNode);
				else
					startNode.setValue((Expression)endNode);
				break;
			case 1: // key child: Expression or null node
				if( endNode instanceof NullNode)
					startNode.addChild(endNode);
				else
					startNode.setKey((Expression)endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}

	private int handleCoalesce( CoalesceExpression startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // left child: Expression node
				startNode.setLeft((Expression)endNode);
				break;
			case 1: // right child: Expression node
				startNode.setRight((Expression)endNode);
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
			case 0: // name child: StringExpression node
				startNode.setNameChild((Variable)endNode);
				break;
			case 1: // default child: Expression or null node
				if( endNode instanceof NullNode)
					startNode.addChild(endNode);
				else
					startNode.setDefault((Expression)endNode);
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
				startNode.setCondition((Expression)endNode);
				break;
			case 1: // stmts child: Statement or Expression or null node
				if( endNode instanceof NullNode)
					startNode.addChild(endNode);
				else if( endNode instanceof Expression) // the child is an expression used as a statement
					startNode.setStatement(createExpressionStatement((Expression)endNode));
				else
					startNode.setStatement((Statement)endNode);
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
			case 0: // stmts child: Statement or Expression or null node
				if( endNode instanceof NullNode)
					startNode.addChild(endNode);
				else if( endNode instanceof Expression) // the child is an expression used as a statement
					startNode.setStatement(createExpressionStatement((Expression)endNode));
				else
					startNode.setStatement((Statement)endNode);
				break;
			case 1: // cond child
				startNode.setCondition((Expression)endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}

	private int handleIfElement( IfElement startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // cond child: Expression or null node
				if( endNode instanceof NullNode)
					startNode.addChild(endNode);
				else
					startNode.setCondition((Expression)endNode);
				break;
			case 1: // stmts child: Statement or Expression or null node
				if( endNode instanceof NullNode)
					startNode.addChild(endNode);
				else if( endNode instanceof Expression) // the child is an expression used as a statement
					startNode.setStatement(createExpressionStatement((Expression)endNode));
				else
					startNode.setStatement((Statement)endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}

	private int handleSwitch( SwitchStatementPHP startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // expr child: Expression node
				startNode.setExpression((Expression)endNode);
				break;
			case 1: // list child: PHPSwitchList node
				startNode.setSwitchList((SwitchList)endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}

	private int handleSwitchCase( SwitchCase startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // value child: Expression or null node
				if( endNode instanceof NullNode)
					startNode.addChild(endNode);
				else
					startNode.setValue((Expression)endNode);
				break;
			case 1: // stmts child: CompoundStatement node
				startNode.setStatement((CompoundStatement)endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}

	private int handleDeclare( DeclareStatement startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // declares child: ConstantDeclaration node
				startNode.setDeclares((ConstantDeclaration)endNode);
				break;
			case 1: // stmts child: Statement or Expression or null node
				if( endNode instanceof NullNode)
					startNode.addChild(endNode);
				else if( endNode instanceof Expression) // the child is an expression used as a statement
					startNode.setStatement(createExpressionStatement((Expression)endNode));
				else
					startNode.setStatement((Statement)endNode);
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
			case 0: // name child: StringExpression node
				startNode.setNameChild((StringExpression)endNode);
				break;
			case 1: // default child: Expression or null node
				if( endNode instanceof NullNode)
					startNode.addChild(endNode);
				else
					startNode.setDefault((Expression)endNode);
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
			case 0: // name child: StringExpression node
				startNode.setNameChild((StringExpression)endNode);
				break;
			case 1: // value child: Expression node
				startNode.setValue((Expression)endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}

	private int handleUseTrait( UseTrait startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // traits child: IdentifierList node
				startNode.setTraits((IdentifierList)endNode);
				break;
			case 1: // adaptations child: PHPTraitAdaptations or null node
				if( endNode instanceof NullNode)
					startNode.addChild(endNode);
				else
					startNode.setTraitAdaptations((TraitAdaptations)endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}

	private int handleTraitPrecedence( TraitPrecedence startNode, ASTNode endNode, int childnum)
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
			case 0: // class child: Identifier or null node
				if( endNode instanceof NullNode)
					startNode.addChild(endNode);
				else
					startNode.setClassIdentifier((Identifier)endNode);
				break;
			case 1: // method child: StringExpression node
				startNode.setMethodName((StringExpression)endNode);
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
			case 0: // name child: StringExpression or null node
				if( endNode instanceof NullNode)
					startNode.addChild(endNode);
				else
					startNode.setName((StringExpression)endNode);
				break;
			case 1: // stmts child: CompoundStatement or null node
				if( endNode instanceof NullNode)
					startNode.addChild(endNode);
				else
					startNode.setContent((CompoundStatement)endNode);
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
			case 0: // name child: StringExpression node
				startNode.setNamespace((StringExpression)endNode);
				break;
			case 1: // alias child: StringExpression or null node
				if( endNode instanceof NullNode)
					startNode.addChild(endNode);
				else
					startNode.setAlias((StringExpression)endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}

	private int handleTraitAlias( TraitAlias startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // method child: MethodReference node
				startNode.setMethod((MethodReference)endNode);
				break;
			case 1: // alias child: StringExpression or null node
				if( endNode instanceof NullNode)
					startNode.addChild(endNode);
				else
					startNode.setAlias((StringExpression)endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}

	private int handleGroupUse( GroupUseStatement startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // prefix child: StringExpression node
				startNode.setPrefix((StringExpression)endNode);
				break;
			case 1: // uses child: UseStatement node
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
				startNode.setTargetObject((Expression)endNode);
				break;
			case 1: // method child: Expression node
				startNode.setTargetFunc((Expression)endNode);
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
			case 0: // class child: Expression node
				startNode.setTargetClass((Expression)endNode);
				break;
			case 1: // method child: Expression node
				startNode.setTargetFunc((Expression)endNode);
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
				startNode.setCondition((Expression)endNode);
				break;
			case 1: // trueExpr child: Expression or null node
				if( endNode instanceof NullNode)
					startNode.addChild(endNode);
				else
					startNode.setTrueExpression((Expression)endNode);
				break;
			case 2: // falseExpr child: Expression node
				startNode.setFalseExpression((Expression)endNode);
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
			case 2: // finallyStmts child: CompoundStatement or null node
				if( endNode instanceof NullNode)
					startNode.addChild(endNode);
				else
					startNode.setFinallyContent((CompoundStatement)endNode);
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
			case 1: // var child: Variable node
				startNode.setVariable((Variable)endNode);
				break;
			case 2: // stmts child: CompoundStatement node
				startNode.setContent((CompoundStatement)endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}

	private int handleParameter( Parameter startNode, ASTNode endNode, int childnum)
	{
		int errno = 0;

		switch (childnum)
		{
			case 0: // type child: Identifier or null node
				if( endNode instanceof NullNode)
					startNode.addChild(endNode);
				else
					startNode.setType(endNode);
				break;
			case 1: // name child: StringExpression node
				startNode.setNameChild((StringExpression)endNode);
				break;
			case 2: // default child: Expression or null node
				if( endNode instanceof NullNode)
					startNode.addChild(endNode);
				else
					startNode.setDefault((Expression)endNode);
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
			case 0: // init child: ExpressionList or null node
				if( endNode instanceof NullNode)
					startNode.addChild(endNode);
				else
					// Note: can only cast to Expression instead of the more specific ExpressionList
					// because in C world, a ForInit node is used instead (also an Expression)
					startNode.setForInitExpression((Expression)endNode);
				break;
			case 1: // cond child: ExpressionList or null node
				if( endNode instanceof NullNode)
					startNode.addChild(endNode);
				else
					// Note: can only cast to Expression instead of the more specific ExpressionList
					// because in C world, a Condition node is used instead (also an Expression)
					startNode.setCondition((Expression)endNode);
				break;
			case 2: // loop child: ExpressionList or null node
				if( endNode instanceof NullNode)
					startNode.addChild(endNode);
				else
					// Note: can only cast to Expression instead of the more specific ExpressionList
					// because in C world, an Expression node is used instead
					startNode.setForLoopExpression((Expression)endNode);
				break;
			case 3: // stmts child: Statement or Expression or null node
				if( endNode instanceof NullNode)
					startNode.addChild(endNode);
				else if( endNode instanceof Expression) // the child is an expression used as a statement
					startNode.setStatement(createExpressionStatement((Expression)endNode));
				else
					startNode.setStatement((Statement)endNode);
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
				startNode.setIteratedObject((Expression)endNode);
				break;
			case 1: // value child: Expression node
				startNode.setValueExpression((Expression)endNode);
				break;
			case 2: // key child: Expression or null node
				if( endNode instanceof NullNode)
					startNode.addChild(endNode);
				else
					startNode.setKeyExpression((Expression)endNode);
				break;
			case 3: // stmts child: Statement or Expression or null node
				if( endNode instanceof NullNode)
					startNode.addChild(endNode);
				else if( endNode instanceof Expression) // the child is an expression used as a statement
					startNode.setStatement(createExpressionStatement((Expression)endNode));
				else
					startNode.setStatement((Statement)endNode);
				break;

			default:
				errno = 1;
		}

		return errno;
	}


	/* nodes with an arbitrary number of children */

	private int handleArgumentList( ArgumentList startNode, ASTNode endNode, int childnum)
	{
		startNode.addArgument((Expression)endNode);

		return 0;
	}

	private int handleList( ListExpression startNode, ASTNode endNode, int childnum)
	{
		// This should be either a null node or an Expression:
		// There is no closer ancestor than ASTNode itself, so we do not cast endNode
		// to anything more specific here.
		startNode.addElement(endNode);

		return 0;
	}

	private int handleArray( ArrayExpression startNode, ASTNode endNode, int childnum)
	{
		startNode.addArrayElement((ArrayElement)endNode);

		return 0;
	}

	private int handleEncapsList( EncapsListExpression startNode, ASTNode endNode, int childnum)
	{
		startNode.addElement((Expression)endNode);

		return 0;
	}

	private int handleExpressionList( ExpressionList startNode, ASTNode endNode, int childnum)
	{
		startNode.addExpression((Expression)endNode);

		return 0;
	}

	private int handleCompound( CompoundStatement startNode, ASTNode endNode, int childnum)
	{
		// Note: These may be all kinds of AST nodes: instances of Statement, but also
		// instances of Expression, PHPFunctionDef, or even null nodes.
		startNode.addStatement(endNode);

		return 0;
	}

	private int handleIf( IfStatement startNode, ASTNode endNode, int childnum)
	{
		startNode.addIfElement((IfElement)endNode);

		return 0;
	}

	private int handleSwitchList( SwitchList startNode, ASTNode endNode, int childnum)
	{
		startNode.addSwitchCase((SwitchCase)endNode);

		return 0;
	}

	private int handleCatchList( CatchList startNode, ASTNode endNode, int childnum)
	{
		startNode.addCatchStatement((CatchStatement)endNode);

		return 0;
	}

	private int handleParameterList( ParameterList startNode, ASTNode endNode, int childnum)
	{
		startNode.addParameter((Parameter)endNode);

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

	private int handleTraitAdaptations( TraitAdaptations startNode, ASTNode endNode, int childnum)
	{
		startNode.addTraitAdaptationElement((TraitAdaptationElement)endNode);

		return 0;
	}

	private int handleUseStatement( UseStatement startNode, ASTNode endNode, int childnum)
	{
		startNode.addUseElement((UseElement)endNode);

		return 0;
	}

	/* Helper methods */

	/**
	 * Creates an ExpressionStatement wrapper around an Expression node.
	 */
	private ExpressionStatement createExpressionStatement(Expression expression) {

		ExpressionStatement expressionStatement = new ExpressionStatement();
		expressionStatement.setExpression(expression);

		// the ExpressionStatement gets the same NODE_ID as the Expression, this way CFG creation
		// can handle the ExpressionStatement, but the end node that we reference when writing
		// out edges is actually the Expression
		copyProperty( expression, expressionStatement, PHPCSVNodeTypes.NODE_ID.getName());

		return expressionStatement;
	}

	/**
	 * Creates a ClosureExpression wrapper around a Closure node.
	 */
	private ClosureExpression createClosureExpression(Closure closure) {

		ClosureExpression closureExpression = new ClosureExpression();
		closureExpression.setClosure(closure);

		// the ClosureExpression gets the same NODE_ID as the Closure, this way CFG creation
		// can handle the ClosureExpression, but the end node that we reference when writing
		// out edges is actually the Closure
		copyProperty( closure, closureExpression, PHPCSVNodeTypes.NODE_ID.getName());

		return closureExpression;
	}

	/**
	 * Creates a ClassExpression wrapper around a PHPClassDef node (for anonymous classes.)
	 */
	private ClassExpression createClassExpression(ClassDef classDef) {

		ClassExpression classExpression = new ClassExpression();
		classExpression.setClassDef(classDef);

		// the ClassExpression gets the same NODE_ID as the PHPClassDef, this way CFG creation
		// can handle the ClassExpression, but the end node that we reference when writing
		// out edges is actually the PHPClassDef
		copyProperty( classDef, classExpression, PHPCSVNodeTypes.NODE_ID.getName());

		return classExpression;
	}

	/**
	 * Copies a given property from one ASTNode to another.
	 */
	private void copyProperty( ASTNode from, ASTNode to, String property) {

		to.setProperty( property, from.getProperty( property));
	}
}
