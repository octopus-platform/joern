package tools.php.ast2cpg;

import ast.ASTNode;
import ast.CodeLocation;
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
import ast.expressions.DoubleExpression;
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
import ast.php.declarations.ClassDef;
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
import ast.php.expressions.MagicConstant;
import ast.php.expressions.PrintExpression;
import ast.php.expressions.ReferenceExpression;
import ast.php.expressions.ShellExecExpression;
import ast.php.expressions.TypeHint;
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
import ast.php.statements.blockstarters.TraitAdaptations;
import ast.php.statements.blockstarters.TraitAlias;
import ast.php.statements.blockstarters.TraitPrecedence;
import ast.php.statements.blockstarters.UseTrait;
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
import cg.PHPCGFactory;
import inputModules.csv.PHPCSVNodeTypes;
import inputModules.csv.KeyedCSV.KeyedCSVRow;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import inputModules.csv.csv2ast.ASTUnderConstruction;
import inputModules.csv.csv2ast.CSVRowInterpreter;

public class PHPCSVNodeInterpreter implements CSVRowInterpreter
{

	@Override
	public long handle(KeyedCSVRow row, ASTUnderConstruction ast)
			throws InvalidCSVFile
	{
		long retval = -1;
		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		switch (type)
		{
			// null nodes (leafs)
			case PHPCSVNodeTypes.TYPE_NULL:
				retval = handleNull(row, ast);
				break;

			// primary expressions (leafs)
			case PHPCSVNodeTypes.TYPE_INTEGER:
				retval = handleInteger(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_DOUBLE:
				retval = handleDouble(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_STRING:
				retval = handleString(row, ast);
				break;

			// special nodes
			case PHPCSVNodeTypes.TYPE_NAME:
				retval = handleName(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_CLOSURE_VAR:
				retval = handleClosureVar(row, ast);
				break;

			// declaration nodes
			case PHPCSVNodeTypes.TYPE_TOPLEVEL:
				retval = handleTopLevelFunction(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_FUNC_DECL:
				retval = handleFunction(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_CLOSURE:
				retval = handleClosure(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_METHOD:
				retval = handleMethod(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_CLASS:
				retval = handleClass(row, ast);
				break;

			// nodes without children (leafs)
			// expressions
			case PHPCSVNodeTypes.TYPE_MAGIC_CONST:
				retval = handleMagicConst(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_TYPE:
				retval = handleTypeHint(row, ast);
				break;

			// nodes with exactly 1 child
			// expressions
			case PHPCSVNodeTypes.TYPE_VAR:
				retval = handleVariable(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_CONST:
				retval = handleConstant(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_UNPACK:
				retval = handleUnpack(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_CAST:
				retval = handleCast(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_EMPTY:
				retval = handleEmpty(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_ISSET:
				retval = handleIsset(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_SHELL_EXEC:
				retval = handleShellExec(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_CLONE:
				retval = handleClone(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_EXIT:
				retval = handleExit(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_PRINT:
				retval = handlePrint(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_INCLUDE_OR_EVAL:
				retval = handleIncludeOrEval(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_UNARY_OP:
				retval = handleUnaryOperation(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_PRE_INC:
				retval = handlePreInc(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_PRE_DEC:
				retval = handlePreDec(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_POST_INC:
				retval = handlePostInc(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_POST_DEC:
				retval = handlePostDec(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_YIELD_FROM:
				retval = handleYieldFrom(row, ast);
				break;

			// statements
			case PHPCSVNodeTypes.TYPE_GLOBAL:
				retval = handleGlobal(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_UNSET:
				retval = handleUnset(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_RETURN:
				retval = handleReturn(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_LABEL:
				retval = handleLabel(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_REF:
				retval = handleReference(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_HALT_COMPILER:
				retval = handleHaltCompiler(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_ECHO:
				retval = handleEcho(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_THROW:
				retval = handleThrow(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_GOTO:
				retval = handleGoto(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_BREAK:
				retval = handleBreak(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_CONTINUE:
				retval = handleContinue(row, ast);
				break;

			// nodes with exactly 2 children
			// expressions
			case PHPCSVNodeTypes.TYPE_DIM:
				retval = handleArrayIndexing(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_PROP:
				retval = handleProperty(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_STATIC_PROP:
				retval = handleStaticProperty(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_CALL:
				retval = handleCall(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_CLASS_CONST:
				retval = handleClassConstant(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_ASSIGN:
				retval = handleAssign(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_ASSIGN_REF:
				retval = handleAssignByRef(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_ASSIGN_OP:
				retval = handleAssignWithOp(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_BINARY_OP:
				retval = handleBinaryOperation(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_ARRAY_ELEM:
				retval = handleArrayElement(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_NEW:
				retval = handleNew(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_INSTANCEOF:
				retval = handleInstanceof(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_YIELD:
				retval = handleYield(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_COALESCE:
				retval = handleCoalesce(row, ast);
				break;

			// statements
			case PHPCSVNodeTypes.TYPE_STATIC:
				retval = handleStaticVariable(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_WHILE:
				retval = handleWhile(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_DO_WHILE:
				retval = handleDo(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_IF_ELEM:
				retval = handleIfElement(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_SWITCH:
				retval = handleSwitch(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_SWITCH_CASE:
				retval = handleSwitchCase(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_DECLARE:
				retval = handleDeclare(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_PROP_ELEM:
				retval = handlePropertyElement(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_CONST_ELEM:
				retval = handleConstantElement(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_USE_TRAIT:
				retval = handleUseTrait(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_TRAIT_PRECEDENCE:
				retval = handleTraitPrecedence(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_METHOD_REFERENCE:
				retval = handleMethodReference(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_NAMESPACE:
				retval = handleNamespace(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_USE_ELEM:
				retval = handleUseElement(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_TRAIT_ALIAS:
				retval = handleTraitAlias(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_GROUP_USE:
				retval = handleGroupUse(row, ast);
				break;

			// nodes with exactly 3 children
			// expressions
			case PHPCSVNodeTypes.TYPE_METHOD_CALL:
				retval = handleMethodCall(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_STATIC_CALL:
				retval = handleStaticCall(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_CONDITIONAL:
				retval = handleConditional(row, ast);
				break;

			// statements
			case PHPCSVNodeTypes.TYPE_TRY:
				retval = handleTry(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_CATCH:
				retval = handleCatch(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_PARAM:
				retval = handleParameter(row, ast);
				break;

			// nodes with exactly 4 children
			// statements
			case PHPCSVNodeTypes.TYPE_FOR:
				retval = handleFor(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_FOREACH:
				retval = handleForEach(row, ast);
				break;

			// nodes with an arbitrary number of children
			case PHPCSVNodeTypes.TYPE_ARG_LIST:
				retval = handleArgumentList(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_LIST:
				retval = handleList(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_ARRAY:
				retval = handleArray(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_ENCAPS_LIST:
				retval = handleEncapsList(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_EXPR_LIST:
				retval = handleExpressionList(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_STMT_LIST:
				retval = handleCompound(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_IF:
				retval = handleIf(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_SWITCH_LIST:
				retval = handleSwitchList(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_CATCH_LIST:
				retval = handleCatchList(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_PARAM_LIST:
				retval = handleParameterList(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_CLOSURE_USES:
				retval = handleClosureUses(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_PROP_DECL:
				retval = handlePropertyDeclaration(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_CONST_DECL:
				retval = handleConstantDeclaration(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_CLASS_CONST_DECL:
				retval = handleClassConstantDeclaration(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_NAME_LIST:
				retval = handleIdentifierList(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_TRAIT_ADAPTATIONS:
				retval = handleTraitAdaptations(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_USE:
				retval = handleUseStatement(row, ast);
				break;

			default:
				retval = defaultHandler(row, ast);
		}

		return retval;
	}

	private long defaultHandler(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		ASTNode newNode = new ASTNode();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String code = row.getFieldForKey(PHPCSVNodeTypes.CODE);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setCodeStr(code);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}


	/* null nodes (leafs) */

	private long handleNull(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		NullNode newNode = new NullNode();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}


	/* primary expressions (leafs) */

	private long handleInteger(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		IntegerExpression newNode = new IntegerExpression();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String code = row.getFieldForKey(PHPCSVNodeTypes.CODE);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setCodeStr(code);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleDouble(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		DoubleExpression newNode = new DoubleExpression();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String code = row.getFieldForKey(PHPCSVNodeTypes.CODE);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setCodeStr(code);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleString(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		StringExpression newNode = new StringExpression();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String code = row.getFieldForKey(PHPCSVNodeTypes.CODE);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setCodeStr(code);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}


	/* special nodes */

	private long handleName(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		Identifier newNode = new Identifier();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);
		String namespace = row.getFieldForKey(PHPCSVNodeTypes.NAMESPACE);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);
		newNode.setEnclosingNamespace(namespace);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleClosureVar(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		ClosureVar newNode = new ClosureVar();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}


	/* declaration nodes */

	private static long handleTopLevelFunction(KeyedCSVRow row,
			ASTUnderConstruction ast) throws InvalidCSVFile
	{
		TopLevelFunctionDef newNode = new TopLevelFunctionDef();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);
		String endlineno = row.getFieldForKey(PHPCSVNodeTypes.ENDLINENO);
		String name = row.getFieldForKey(PHPCSVNodeTypes.NAME);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		codeloc.endLine = Integer.parseInt(endlineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);
		if (flags.contains(PHPCSVNodeTypes.FLAG_TOPLEVEL_FILE))
			newNode.setName("<" + name + ">");
		else if (flags.contains(PHPCSVNodeTypes.FLAG_TOPLEVEL_CLASS))
			newNode.setName("[" + name + "]");
		else
			throw new InvalidCSVFile("While trying to handle row "
					+ row.toString() + ": " + "Invalid toplevel flags " + flags
					+ ".");

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private static long handleFunction(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		FunctionDef newNode = new FunctionDef();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);
		String namespace = row.getFieldForKey(PHPCSVNodeTypes.NAMESPACE);
		String endlineno = row.getFieldForKey(PHPCSVNodeTypes.ENDLINENO);
		String name = row.getFieldForKey(PHPCSVNodeTypes.NAME);
		String doccomment = row.getFieldForKey(PHPCSVNodeTypes.DOCCOMMENT);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		codeloc.endLine = Integer.parseInt(endlineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);
		newNode.setEnclosingNamespace(namespace);
		newNode.setName(name);
		newNode.setDocComment(doccomment);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private static long handleClosure(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		Closure newNode = new Closure();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);
		String endlineno = row.getFieldForKey(PHPCSVNodeTypes.ENDLINENO);
		String name = row.getFieldForKey(PHPCSVNodeTypes.NAME);
		String doccomment = row.getFieldForKey(PHPCSVNodeTypes.DOCCOMMENT);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		codeloc.endLine = Integer.parseInt(endlineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);
		newNode.setName(name);
		newNode.setDocComment(doccomment);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private static long handleMethod(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		Method newNode = new Method();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);
		String classname = row.getFieldForKey(PHPCSVNodeTypes.CLASSNAME);
		String namespace = row.getFieldForKey(PHPCSVNodeTypes.NAMESPACE);
		String endlineno = row.getFieldForKey(PHPCSVNodeTypes.ENDLINENO);
		String name = row.getFieldForKey(PHPCSVNodeTypes.NAME);
		String doccomment = row.getFieldForKey(PHPCSVNodeTypes.DOCCOMMENT);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		codeloc.endLine = Integer.parseInt(endlineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);
		newNode.setEnclosingClass(classname);
		newNode.setEnclosingNamespace(namespace);
		newNode.setName(name);
		newNode.setDocComment(doccomment);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private static long handleClass(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		ClassDef newNode = new ClassDef();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);
		String endlineno = row.getFieldForKey(PHPCSVNodeTypes.ENDLINENO);
		String name = row.getFieldForKey(PHPCSVNodeTypes.NAME);
		String doccomment = row.getFieldForKey(PHPCSVNodeTypes.DOCCOMMENT);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		codeloc.endLine = Integer.parseInt(endlineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);
		newNode.setName(name);
		newNode.setDocComment(doccomment);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}


	/* nodes without children (leafs) */

	private long handleMagicConst(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		MagicConstant newNode = new MagicConstant();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleTypeHint(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		TypeHint newNode = new TypeHint();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}


	/* nodes with exactly 1 child */

	private long handleVariable(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		Variable newNode = new Variable();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleConstant(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		Constant newNode = new Constant();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleUnpack(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		UnpackExpression newNode = new UnpackExpression();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleCast(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		CastExpression newNode = new CastExpression();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleEmpty(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		EmptyExpression newNode = new EmptyExpression();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleIsset(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		IssetExpression newNode = new IssetExpression();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleShellExec(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		ShellExecExpression newNode = new ShellExecExpression();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleClone(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		CloneExpression newNode = new CloneExpression();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleExit(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		ExitExpression newNode = new ExitExpression();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handlePrint(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		PrintExpression newNode = new PrintExpression();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleIncludeOrEval(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		IncludeOrEvalExpression newNode = new IncludeOrEvalExpression();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleUnaryOperation(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		UnaryOperationExpression newNode = new UnaryOperationExpression();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handlePreInc(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		PreIncOperationExpression newNode = new PreIncOperationExpression();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handlePreDec(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		PreDecOperationExpression newNode = new PreDecOperationExpression();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handlePostInc(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		PostIncOperationExpression newNode = new PostIncOperationExpression();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handlePostDec(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		PostDecOperationExpression newNode = new PostDecOperationExpression();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleYieldFrom(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		YieldFromExpression newNode = new YieldFromExpression();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleGlobal(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		GlobalStatement newNode = new GlobalStatement();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleUnset(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		UnsetStatement newNode = new UnsetStatement();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleReturn(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		ReturnStatement newNode = new ReturnStatement();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleLabel(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		Label newNode = new Label();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleReference(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		ReferenceExpression newNode = new ReferenceExpression();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleHaltCompiler(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		HaltCompilerStatement newNode = new HaltCompilerStatement();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleEcho(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		EchoStatement newNode = new EchoStatement();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleThrow(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		ThrowStatement newNode = new ThrowStatement();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleGoto(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		GotoStatement newNode = new GotoStatement();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleBreak(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		BreakStatement newNode = new BreakStatement();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleContinue(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		ContinueStatement newNode = new ContinueStatement();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}


	/* nodes with exactly 2 children */

	private long handleArrayIndexing(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		ArrayIndexing newNode = new ArrayIndexing();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleProperty(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		PropertyExpression newNode = new PropertyExpression();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleStaticProperty(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		StaticPropertyExpression newNode = new StaticPropertyExpression();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleCall(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		CallExpressionBase newNode = new CallExpressionBase();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		// special in the case of function calls:
		// we add the created node to the PHP call graph factory's list of function calls;
		// hence we get a list of all function calls without any additional traversals of
		// the final AST
		PHPCGFactory.addFunctionCall(newNode);
		
		return id;
	}

	private long handleClassConstant(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		ClassConstantExpression newNode = new ClassConstantExpression();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleAssign(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		AssignmentExpression newNode = new AssignmentExpression();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleAssignByRef(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		AssignmentByRefExpression newNode = new AssignmentByRefExpression();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleAssignWithOp(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		AssignmentWithOpExpression newNode = new AssignmentWithOpExpression();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleBinaryOperation(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		BinaryOperationExpression newNode = new BinaryOperationExpression();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleArrayElement(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		ArrayElement newNode = new ArrayElement();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleNew(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		NewExpression newNode = new NewExpression();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);
		
		// special in the case of constructor calls:
		// we add the created node to the PHP call graph factory's list of constructor calls;
		// hence we get a list of all constructor calls without any additional traversals of
		// the final AST
		PHPCGFactory.addFunctionCall(newNode);

		return id;
	}

	private long handleInstanceof(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		InstanceofExpression newNode = new InstanceofExpression();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleYield(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		YieldExpression newNode = new YieldExpression();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleCoalesce(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		CoalesceExpression newNode = new CoalesceExpression();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleStaticVariable(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		StaticVariableDeclaration newNode = new StaticVariableDeclaration();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleWhile(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		WhileStatement newNode = new WhileStatement();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleDo(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		DoStatement newNode = new DoStatement();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleIfElement(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		IfElement newNode = new IfElement();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleSwitch(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		SwitchStatementPHP newNode = new SwitchStatementPHP();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleSwitchCase(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		SwitchCase newNode = new SwitchCase();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleDeclare(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		DeclareStatement newNode = new DeclareStatement();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handlePropertyElement(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		PropertyElement newNode = new PropertyElement();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);
		String doccomment = row.getFieldForKey(PHPCSVNodeTypes.DOCCOMMENT);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);
		newNode.setDocComment(doccomment);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleConstantElement(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		ConstantElement newNode = new ConstantElement();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleUseTrait(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		UseTrait newNode = new UseTrait();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleTraitPrecedence(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		TraitPrecedence newNode = new TraitPrecedence();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleMethodReference(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		MethodReference newNode = new MethodReference();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleNamespace(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		NamespaceStatement newNode = new NamespaceStatement();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleUseElement(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		UseElement newNode = new UseElement();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleTraitAlias(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		TraitAlias newNode = new TraitAlias();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleGroupUse(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		GroupUseStatement newNode = new GroupUseStatement();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}


	/* nodes with exactly 3 children */

	private long handleMethodCall(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		MethodCallExpression newNode = new MethodCallExpression();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);
		String classname = row.getFieldForKey(PHPCSVNodeTypes.CLASSNAME);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);
		newNode.setEnclosingClass(classname);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		// special in the case of non-static method calls:
		// we add the created node to the PHP call graph factory's list of non-static method calls;
		// hence we get a list of all non-static method calls without any additional traversals of
		// the final AST
		PHPCGFactory.addFunctionCall(newNode);

		return id;
	}

	private long handleStaticCall(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		StaticCallExpression newNode = new StaticCallExpression();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		// special in the case of static method calls:
		// we add the created node to the PHP call graph factory's list of static method calls;
		// hence we get a list of all static method calls without any additional traversals of
		// the final AST
		PHPCGFactory.addFunctionCall(newNode);
		
		return id;
	}

	private long handleConditional(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		ConditionalExpression newNode = new ConditionalExpression();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleTry(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		TryStatement newNode = new TryStatement();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleCatch(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		CatchStatement newNode = new CatchStatement();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleParameter(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		Parameter newNode = new Parameter();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}


	/* nodes with exactly 4 children */

	private long handleFor(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		ForStatement newNode = new ForStatement();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleForEach(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		ForEachStatement newNode = new ForEachStatement();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}


	/* nodes with an arbitrary number of children */

	private long handleArgumentList(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		ArgumentList newNode = new ArgumentList();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleList(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		ListExpression newNode = new ListExpression();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleArray(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		ArrayExpression newNode = new ArrayExpression();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleEncapsList(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		EncapsListExpression newNode = new EncapsListExpression();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleExpressionList(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		ExpressionList newNode = new ExpressionList();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleCompound(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		CompoundStatement newNode = new CompoundStatement();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleIf(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		IfStatement newNode = new IfStatement();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleSwitchList(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		SwitchList newNode = new SwitchList();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleCatchList(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		CatchList newNode = new CatchList();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleParameterList(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		ParameterList newNode = new ParameterList();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleClosureUses(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		ClosureUses newNode = new ClosureUses();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handlePropertyDeclaration(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		PropertyDeclaration newNode = new PropertyDeclaration();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleConstantDeclaration(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		ConstantDeclaration newNode = new ConstantDeclaration();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleClassConstantDeclaration(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		ClassConstantDeclaration newNode = new ClassConstantDeclaration();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleIdentifierList(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		IdentifierList newNode = new IdentifierList();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleTraitAdaptations(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		TraitAdaptations newNode = new TraitAdaptations();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}

	private long handleUseStatement(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		UseStatement newNode = new UseStatement();

		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String childnum = row.getFieldForKey(PHPCSVNodeTypes.CHILDNUM);

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		newNode.setNodeId(id);

		return id;
	}
}
