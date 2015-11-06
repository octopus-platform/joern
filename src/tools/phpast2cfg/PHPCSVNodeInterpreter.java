package tools.phpast2cfg;

import ast.ASTNode;
import ast.functionDef.FunctionDef;
import ast.logical.statements.CompoundStatement;
import ast.php.functionDef.Closure;
import ast.php.functionDef.Method;
import ast.php.functionDef.TopLevelFunctionDef;
import ast.statements.blockstarters.DoStatement;
import ast.statements.blockstarters.ForStatement;
import ast.statements.blockstarters.IfStatement;
import ast.statements.blockstarters.WhileStatement;
import inputModules.csv.KeyedCSV.KeyedCSVRow;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import inputModules.csv.csv2ast.ASTUnderConstruction;
import inputModules.csv.csv2ast.CSVRowInterpreter;
import languages.c.parsing.CodeLocation;

public class PHPCSVNodeInterpreter implements CSVRowInterpreter
{

	@Override
	public long handle(KeyedCSVRow row, ASTUnderConstruction ast) throws InvalidCSVFile
	{
		long retval = -1;
		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		switch (type)
		{
		case PHPCSVNodeTypes.TYPE_TOPLEVEL:
			retval = handleTopLevelFunction(row, ast);
			break;
		case PHPCSVNodeTypes.TYPE_FUNC_DECL:
			retval = handleFunction(row, ast);
			break;
		case PHPCSVNodeTypes.TYPE_METHOD:
			retval = handleMethod(row, ast);
			break;
		case PHPCSVNodeTypes.TYPE_CLOSURE:
			retval = handleClosure(row, ast);
			break;
		case PHPCSVNodeTypes.TYPE_STMT_LIST:
			retval = handleCompound(row, ast);
			break;
		case PHPCSVNodeTypes.TYPE_IF:
			retval = handleIf(row, ast);
			break;
		case PHPCSVNodeTypes.TYPE_WHILE:
			retval = handleWhile(row, ast);
			break;
		case PHPCSVNodeTypes.TYPE_DO_WHILE:
			retval = handleDo(row, ast);
			break;
		case PHPCSVNodeTypes.TYPE_FOR:
			retval = handleFor(row, ast);
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

		newNode.setProperty(PHPCSVNodeTypes.TYPE.getName(), type);
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		newNode.setCodeStr(code);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		
		return id;
	}

	private static long handleTopLevelFunction(KeyedCSVRow row,
			ASTUnderConstruction ast) throws InvalidCSVFile
	{
		TopLevelFunctionDef newNode = new TopLevelFunctionDef();

		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String name = row.getFieldForKey(PHPCSVNodeTypes.NAME);
		String endlineno = row.getFieldForKey(PHPCSVNodeTypes.ENDLINENO);
		
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		codeloc.endLine = Integer.parseInt(endlineno);
		newNode.setLocation(codeloc);
		if( flags.contains(PHPCSVNodeTypes.FLAG_TOPLEVEL_FILE))
			newNode.setName("<" + name + ">");
		else if( flags.contains(PHPCSVNodeTypes.FLAG_TOPLEVEL_CLASS))
			newNode.setName("[" + name + "]");
		else
			throw new InvalidCSVFile("While trying to handle row " + row.toString() + ": "
					+ "Invalid toplevel flags " + flags + ".");
		
		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		
		return id;
	}
	
	private static long handleFunction(KeyedCSVRow row,
			ASTUnderConstruction ast)
	{
		FunctionDef newNode = new FunctionDef();

		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String name = row.getFieldForKey(PHPCSVNodeTypes.NAME);
		String endlineno = row.getFieldForKey(PHPCSVNodeTypes.ENDLINENO);
		
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		codeloc.endLine = Integer.parseInt(endlineno);
		newNode.setLocation(codeloc);
		newNode.setName(name);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		
		return id;
	}
	
	private static long handleMethod(KeyedCSVRow row,
			ASTUnderConstruction ast)
	{
		Method newNode = new Method();

		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String name = row.getFieldForKey(PHPCSVNodeTypes.NAME);
		String endlineno = row.getFieldForKey(PHPCSVNodeTypes.ENDLINENO);
		
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		codeloc.endLine = Integer.parseInt(endlineno);
		newNode.setLocation(codeloc);
		newNode.setName(name);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		
		return id;
	}

	private static long handleClosure(KeyedCSVRow row,
			ASTUnderConstruction ast)
	{
		Closure newNode = new Closure();

		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		String name = row.getFieldForKey(PHPCSVNodeTypes.NAME);
		String endlineno = row.getFieldForKey(PHPCSVNodeTypes.ENDLINENO);
		
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		codeloc.endLine = Integer.parseInt(endlineno);
		newNode.setLocation(codeloc);
		newNode.setName(name);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);

		return id;
	}

	private long handleCompound(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		CompoundStatement newNode = new CompoundStatement();

		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		
		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		
		return id;
	}

	private long handleIf(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		IfStatement newNode = new IfStatement();

		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		
		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		
		return id;
	}

	private long handleFor(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		ForStatement newNode = new ForStatement();
		
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		
		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		
		return id;
	}

	private long handleDo(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		DoStatement newNode = new DoStatement();
		
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		
		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		
		return id;
	}

	private long handleWhile(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		WhileStatement newNode = new WhileStatement();
		
		String flags = row.getFieldForKey(PHPCSVNodeTypes.FLAGS);
		String lineno = row.getFieldForKey(PHPCSVNodeTypes.LINENO);
		
		newNode.setFlags(flags);
		CodeLocation codeloc = new CodeLocation();
		codeloc.startLine = Integer.parseInt(lineno);
		newNode.setLocation(codeloc);
		
		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		
		return id;
	}

}
