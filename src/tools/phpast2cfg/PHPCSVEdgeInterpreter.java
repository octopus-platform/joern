package tools.phpast2cfg;

import ast.ASTNode;
import ast.expressions.ExpressionList;
import ast.expressions.Identifier;
import ast.expressions.IdentifierList;
import ast.expressions.Variable;
import ast.functionDef.FunctionDef;
import ast.functionDef.ParameterList;
import ast.logical.statements.CompoundStatement;
import ast.logical.statements.Statement;
import ast.php.declarations.PHPClassDef;
import ast.php.functionDef.Closure;
import ast.php.functionDef.ClosureUses;
import ast.php.functionDef.ClosureVar;
import ast.php.functionDef.Method;
import ast.php.functionDef.PHPParameter;
import ast.php.functionDef.TopLevelFunctionDef;
import ast.php.statements.blockstarters.ForEachStatement;
import ast.php.statements.blockstarters.PHPIfElement;
import ast.php.statements.blockstarters.PHPIfStatement;
import ast.php.statements.blockstarters.PHPSwitchCase;
import ast.php.statements.blockstarters.PHPSwitchList;
import ast.php.statements.blockstarters.PHPSwitchStatement;
import ast.php.statements.jump.PHPBreakStatement;
import ast.statements.blockstarters.DoStatement;
import ast.statements.blockstarters.ForStatement;
import ast.statements.blockstarters.WhileStatement;
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
			case PHPCSVNodeTypes.TYPE_VAR:
				errno = handleVariable((Variable)startNode, endNode, childnum);
				break;
				
			case PHPCSVNodeTypes.TYPE_BREAK:
				errno = handleBreak((PHPBreakStatement)startNode, endNode, childnum);
				break;

			// nodes with exactly 2 children
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

			// nodes with exactly 3 children
			case PHPCSVNodeTypes.TYPE_PARAM:
				errno = handleParameter((PHPParameter)startNode, endNode, childnum);
				break;
			
			// nodes with exactly 4 children
			case PHPCSVNodeTypes.TYPE_FOR:
				errno = handleFor((ForStatement)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_FOREACH:
				errno = handleForEach((ForEachStatement)startNode, endNode, childnum);
				break;
				
			// nodes with an arbitrary number of children
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
			case PHPCSVNodeTypes.TYPE_PARAM_LIST:
				errno = handleParameterList((ParameterList)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_CLOSURE_USES:
				errno = handleClosureUses((ClosureUses)startNode, endNode, childnum);
				break;
			case PHPCSVNodeTypes.TYPE_NAME_LIST:
				errno = handleIdentifierList((IdentifierList)startNode, endNode, childnum);
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
				startNode.setNameChild(endNode);
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


	/* nodes with exactly 2 children */

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


	/* nodes with exactly 3 children */
	
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
			case 1: // value child: Variable node
				startNode.setValueVar((Variable)endNode);
				break;
			case 2: // key child: either Variable or NULL node
				startNode.setKeyVar(endNode);
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
	
	private int handleIdentifierList( IdentifierList startNode, ASTNode endNode, int childnum)
	{
		startNode.addIdentifier((Identifier)endNode);

		return 0;
	}
}
