package tools.phpast2cfg;

import ast.expressions.Identifier;
import ast.functionDef.FunctionDef;
import inputModules.csv.KeyedCSV.KeyedCSVRow;
import inputModules.csv.csv2ast.ASTUnderConstruction;
import inputModules.csv.csv2ast.CSVNodeInterpreter;

public class PHPCSVNodeInterpreter implements CSVNodeInterpreter
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
		}
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

}
