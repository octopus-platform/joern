package tools.phpast2cfg;

import inputModules.csv.KeyedCSV.KeyedCSVRow;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import inputModules.csv.csv2ast.ASTUnderConstruction;
import inputModules.csv.csv2ast.CSVRowInterpreter;
import ast.ASTNode;
import ast.CodeLocation;
import ast.expressions.AndExpression;
import ast.expressions.ArgumentList;
import ast.expressions.ArrayIndexing;
import ast.expressions.AssignmentExpression;
import ast.expressions.AssignmentWithOpExpression;
import ast.expressions.BinaryOperationExpression;
import ast.expressions.CallExpression;
import ast.expressions.ClassConstantExpression;
import ast.expressions.ConditionalExpression;
import ast.expressions.ExpressionList;
import ast.expressions.GreaterExpression;
import ast.expressions.GreaterOrEqualExpression;
import ast.expressions.Identifier;
import ast.expressions.IdentifierList;
import ast.expressions.InstanceofExpression;
import ast.expressions.NewExpression;
import ast.expressions.OrExpression;
import ast.expressions.PropertyExpression;
import ast.expressions.StaticPropertyExpression;
import ast.expressions.Variable;
import ast.functionDef.FunctionDef;
import ast.functionDef.ParameterList;
import ast.logical.statements.CompoundStatement;
import ast.logical.statements.Label;
import ast.php.declarations.PHPClassDef;
import ast.php.expressions.MethodCallExpression;
import ast.php.expressions.PHPArrayElement;
import ast.php.expressions.PHPArrayExpression;
import ast.php.expressions.PHPAssignmentByRefExpression;
import ast.php.expressions.PHPCoalesceExpression;
import ast.php.expressions.PHPEncapsListExpression;
import ast.php.expressions.PHPListExpression;
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
import ast.php.statements.PHPGroupUseStatement;
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

			// nodes with exactly 1 child
			// expressions
			case PHPCSVNodeTypes.TYPE_VAR:
				retval = handleVariable(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_YIELD_FROM:
				retval = handleYieldFrom(row, ast);
				break;
			
			// statements
			case PHPCSVNodeTypes.TYPE_RETURN:
				retval = handleReturn(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_LABEL:
				retval = handleLabel(row, ast);
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
			case PHPCSVNodeTypes.TYPE_GREATER:
				retval = handleGreater(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_GREATER_EQUAL:
				retval = handleGreaterOrEqual(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_AND:
				retval = handleAnd(row, ast);
				break;
			case PHPCSVNodeTypes.TYPE_OR:
				retval = handleOr(row, ast);
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

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);

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

		return id;
	}

	private static long handleFunction(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		FunctionDef newNode = new FunctionDef();

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

		return id;
	}

	private static long handleMethod(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		Method newNode = new Method();

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

		return id;
	}
	
	private static long handleClass(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		PHPClassDef newNode = new PHPClassDef();

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

		return id;
	}
	
	private long handleYieldFrom(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		PHPYieldFromExpression newNode = new PHPYieldFromExpression();

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

		return id;
	}
	
	private long handleBreak(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		PHPBreakStatement newNode = new PHPBreakStatement();

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

		return id;
	}
	
	private long handleContinue(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		PHPContinueStatement newNode = new PHPContinueStatement();

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

		return id;
	}
	
	private long handleCall(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		CallExpression newNode = new CallExpression();

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

		return id;
	}
	
	private long handleAssignByRef(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		PHPAssignmentByRefExpression newNode = new PHPAssignmentByRefExpression();

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

		return id;
	}
	
	private long handleGreater(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		GreaterExpression newNode = new GreaterExpression();

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

		return id;
	}
	
	private long handleGreaterOrEqual(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		GreaterOrEqualExpression newNode = new GreaterOrEqualExpression();

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

		return id;
	}
	
	private long handleAnd(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		AndExpression newNode = new AndExpression();

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

		return id;
	}
	
	private long handleOr(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		OrExpression newNode = new OrExpression();

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

		return id;
	}
	
	private long handleArrayElement(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		PHPArrayElement newNode = new PHPArrayElement();

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

		return id;
	}
	
	private long handleYield(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		PHPYieldExpression newNode = new PHPYieldExpression();

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

		return id;
	}
	
	private long handleCoalesce(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		PHPCoalesceExpression newNode = new PHPCoalesceExpression();

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

		return id;
	}
	
	private long handleIfElement(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		PHPIfElement newNode = new PHPIfElement();

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

		return id;
	}
	
	private long handleSwitch(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		PHPSwitchStatement newNode = new PHPSwitchStatement();

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

		return id;
	}
	
	private long handleSwitchCase(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		PHPSwitchCase newNode = new PHPSwitchCase();

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

		return id;
	}
	
	private long handleDeclare(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		PHPDeclareStatement newNode = new PHPDeclareStatement();

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

		return id;
	}
	
	private long handlePropertyElement(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		PropertyElement newNode = new PropertyElement();

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

		return id;
	}
	
	private long handleUseTrait(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		PHPUseTrait newNode = new PHPUseTrait();

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

		return id;
	}
	
	private long handleTraitPrecedence(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		PHPTraitPrecedence newNode = new PHPTraitPrecedence();

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

		return id;
	}
	
	private long handleTraitAlias(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		PHPTraitAlias newNode = new PHPTraitAlias();

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

		return id;
	}
	
	private long handleGroupUse(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		PHPGroupUseStatement newNode = new PHPGroupUseStatement();

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

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setProperty(PHPCSVNodeTypes.CHILDNUM.getName(), childnum);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);

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

		return id;
	}
	
	private long handleParameter(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		PHPParameter newNode = new PHPParameter();

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

		return id;
	}
	
	private long handleList(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		PHPListExpression newNode = new PHPListExpression();

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

		return id;
	}
	
	private long handleArray(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		PHPArrayExpression newNode = new PHPArrayExpression();

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

		return id;
	}
	
	private long handleEncapsList(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		PHPEncapsListExpression newNode = new PHPEncapsListExpression();

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

		return id;
	}

	private long handleIf(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		PHPIfStatement newNode = new PHPIfStatement();

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

		return id;
	}
	
	private long handleSwitchList(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		PHPSwitchList newNode = new PHPSwitchList();

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

		return id;
	}
	
	private long handleTraitAdaptations(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		PHPTraitAdaptations newNode = new PHPTraitAdaptations();

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

		return id;
	}
}
