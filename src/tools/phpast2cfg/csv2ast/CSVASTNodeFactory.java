package tools.phpast2cfg.csv2ast;

import ast.ASTNode;
import ast.expressions.Identifier;
import ast.functionDef.FunctionDef;
import tools.phpast2cfg.KeyedCSV.KeyedCSVRow;

public class CSVASTNodeFactory
{
	private CSVASTNodeTypes nodeTypes;

	public CSVASTNodeFactory(CSVASTNodeTypes nodeTypes)
	{
		this.nodeTypes = nodeTypes;
	}

	public ASTNode createNode(KeyedCSVRow keyedRow)
	{
		String nodeType = keyedRow.lookup("type");

		if (nodeTypes.functionDef().contains(nodeType))
			return createNewFunctionDef(keyedRow);

		// TODO: Add handling of additional node types.

		return null;
	}

	private ASTNode createNewFunctionDef(KeyedCSVRow keyedRow)
	{
		FunctionDef newNode = new FunctionDef();
		newNode.name = new Identifier();
		newNode.name.setCodeStr(keyedRow.lookup("name"));
		return newNode;
	}
}
