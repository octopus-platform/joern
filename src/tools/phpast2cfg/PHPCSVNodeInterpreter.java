package tools.phpast2cfg;

import ast.ASTNode;
import ast.expressions.Identifier;
import ast.functionDef.FunctionDef;
import ast.logical.statements.CompoundStatement;
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
	public void handle(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		String type = row.getFieldForKey("type");
		switch (type)
		{
		case "AST_METHOD":
			handleFunction(row, ast);
			break;
		case "AST_STMT_LIST":
			handleCompound(row, ast);
			break;
		case "AST_IF":
			handleIf(row, ast);
			break;
		case "AST_WHILE":
			handleWhile(row, ast);
			break;
		case "AST_DO_WHILE":
			handleDo(row, ast);
			break;
		case "AST_FOR":
			handleFor(row, ast);
			break;

		default:
			defaultHandler(row, ast);
		}
	}

	private void defaultHandler(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		String type = row.getFieldForKey(PHPCSVNodeTypes.TYPE);
		Long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));

		ASTNode newNode = new ASTNode();
		newNode.setProperty(PHPCSVNodeTypes.TYPE, type);
		ast.addNodeWithId(newNode, id);
	}

	private static void handleFunction(KeyedCSVRow row,
			ASTUnderConstruction ast)
	{
		FunctionDef newNode = new FunctionDef();
		Identifier nameNode = new Identifier();

		String name = row.getFieldForKey(PHPCSVNodeTypes.NAME);
		nameNode.setCodeStr(name);
		newNode.addChild(nameNode);

		Long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ast.addNodeWithId(newNode, id);
		ast.setRootNode(newNode);
	}

	private void handleCompound(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		Long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		CompoundStatement newNode = new CompoundStatement();
		ast.addNodeWithId(newNode, id);
	}

	private void handleIf(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		Long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		IfStatement newNode = new IfStatement();
		ast.addNodeWithId(newNode, id);
	}

	private void handleFor(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		Long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		ForStatement newNode = new ForStatement();
		ast.addNodeWithId(newNode, id);
	}

	private void handleDo(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		Long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		DoStatement newNode = new DoStatement();
		ast.addNodeWithId(newNode, id);
	}

	private void handleWhile(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		Long id = Long.parseLong(row.getFieldForKey(PHPCSVNodeTypes.NODE_ID));
		WhileStatement newNode = new WhileStatement();
		ast.addNodeWithId(newNode, id);
	}

}
