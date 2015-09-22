package tools.phpast2cfg;

import ast.ASTNode;
import inputModules.csv.KeyedCSV.KeyedCSVRow;
import inputModules.csv.csv2ast.ASTUnderConstruction;
import inputModules.csv.csv2ast.CSVRowInterpreter;

public class PHPCSVEdgeInterpreter implements CSVRowInterpreter
{

	@Override
	public void handle(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		Long startId = Long.parseLong(row.getFieldForKey("START_ID"));
		Long endId = Long.parseLong(row.getFieldForKey("END_ID"));

		ASTNode startNode = ast.getNodeById(startId);
		ASTNode endNode = ast.getNodeById(endId);

		startNode.addChild(endNode);
	}

}
