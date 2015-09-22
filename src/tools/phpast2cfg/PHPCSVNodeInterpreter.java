package tools.phpast2cfg;

import ast.ASTNode;
import ast.expressions.Identifier;
import ast.functionDef.FunctionDef;
import ast.logical.statements.CompoundStatement;
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

		default:
			defaultHandler(row, ast);
		}
	}

	private void defaultHandler(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		String type = row.getFieldForKey("type");
		Long id = Long.parseLong(row.getFieldForKey("nodeId"));

		ASTNode newNode = new ASTNode();
		newNode.setProperty("type", type);
		ast.addNodeWithId(newNode, id);
	}

	private static void handleFunction(KeyedCSVRow row,
			ASTUnderConstruction ast)
	{
		FunctionDef newNode = new FunctionDef();
		Identifier nameNode = new Identifier();

		String name = row.getFieldForKey("name");
		nameNode.setCodeStr(name);
		newNode.addChild(nameNode);

		Long id = Long.parseLong(row.getFieldForKey("nodeId"));
		ast.addNodeWithId(newNode, id);
		ast.setRootNode(newNode);
	}

	private void handleCompound(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		Long id = Long.parseLong(row.getFieldForKey("nodeId"));
		CompoundStatement compound = new CompoundStatement();
		ast.addNodeWithId(compound, id);
	}

}
