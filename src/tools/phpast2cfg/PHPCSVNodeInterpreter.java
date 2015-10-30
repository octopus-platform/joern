package tools.phpast2cfg;

import ast.ASTNode;
import ast.expressions.Identifier;
import ast.functionDef.FunctionDef;
import ast.logical.statements.CompoundStatement;
import ast.php.functionDef.TopLevelFunctionDef;
import ast.statements.blockstarters.DoStatement;
import ast.statements.blockstarters.ForStatement;
import ast.statements.blockstarters.IfStatement;
import ast.statements.blockstarters.WhileStatement;
import inputModules.csv.KeyedCSV.KeyedCSVRow;
import inputModules.csv.csv2ast.ASTUnderConstruction;
import inputModules.csv.csv2ast.CSVRowInterpreter;

public class PHPCSVNodeInterpreter implements CSVRowInterpreter
{

	@Override
	public long handle(KeyedCSVRow row, ASTUnderConstruction ast)
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
		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));

		ASTNode newNode = new ASTNode();
		newNode.setProperty(PHPCSVNodeTypes.TYPE, type);
		ast.addNodeWithId(newNode, id);
		
		return id;
	}

	private static long handleTopLevelFunction(KeyedCSVRow row,
			ASTUnderConstruction ast)
	{
		TopLevelFunctionDef newNode = new TopLevelFunctionDef();
		Identifier nameNode = new Identifier();

		String name = row.getFieldForKey(PHPCSVNodeTypes.NAME);
		nameNode.setCodeStr(name);
		newNode.addChild(nameNode);
		
		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		
		return id;
	}
	
	private static long handleFunction(KeyedCSVRow row,
			ASTUnderConstruction ast)
	{
		FunctionDef newNode = new FunctionDef();
		Identifier nameNode = new Identifier();

		String name = row.getFieldForKey(PHPCSVNodeTypes.NAME);
		nameNode.setCodeStr(name);
		newNode.addChild(nameNode);

		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		
		return id;
	}

	private long handleCompound(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		CompoundStatement newNode = new CompoundStatement();
		ast.addNodeWithId(newNode, id);
		
		return id;
	}

	private long handleIf(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		IfStatement newNode = new IfStatement();
		ast.addNodeWithId(newNode, id);
		
		return id;
	}

	private long handleFor(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ForStatement newNode = new ForStatement();
		ast.addNodeWithId(newNode, id);
		
		return id;
	}

	private long handleDo(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		DoStatement newNode = new DoStatement();
		ast.addNodeWithId(newNode, id);
		
		return id;
	}

	private long handleWhile(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		WhileStatement newNode = new WhileStatement();
		ast.addNodeWithId(newNode, id);
		
		return id;
	}

}
