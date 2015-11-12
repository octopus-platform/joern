package tools.phpast2cfg;

import ast.ASTNode;
import ast.expressions.Identifier;
import ast.expressions.IdentifierList;
import ast.functionDef.FunctionDef;
import ast.functionDef.ParameterList;
import ast.logical.statements.CompoundStatement;
import ast.php.declarations.PHPClassDef;
import ast.php.functionDef.Closure;
import ast.php.functionDef.ClosureUses;
import ast.php.functionDef.ClosureVar;
import ast.php.functionDef.Method;
import ast.php.functionDef.PHPParameter;
import ast.php.functionDef.TopLevelFunctionDef;
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
		// then do not add the childnum property to ASTNodes in node interpreter any longer
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
				
			// nodes with exactly 3 children
			case PHPCSVNodeTypes.TYPE_PARAM:
				errno = handleParameter((PHPParameter)startNode, endNode, childnum);
				break;
				
			// nodes with an arbitrary number of children
			case PHPCSVNodeTypes.TYPE_STMT_LIST:
				errno = handleCompound((CompoundStatement)startNode, endNode, childnum);
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
	

	/* nodes with an arbitrary number of children */
	
	private int handleCompound( CompoundStatement startNode, ASTNode endNode, int childnum)
	{
		startNode.addChild(endNode);

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
