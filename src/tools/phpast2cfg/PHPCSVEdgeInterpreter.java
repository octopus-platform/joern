package tools.phpast2cfg;

import ast.ASTNode;
import inputModules.csv.KeyedCSV.KeyedCSVRow;
import inputModules.csv.csv2ast.ASTUnderConstruction;
import inputModules.csv.csv2ast.CSVRowInterpreter;

public class PHPCSVEdgeInterpreter implements CSVRowInterpreter
{

	@Override
	public long handle(KeyedCSVRow row, ASTUnderConstruction ast)
	{
		long startId = Long.parseLong(row.getFieldForKey(PHPCSVEdgeTypes.START_ID));
		long endId = Long.parseLong(row.getFieldForKey(PHPCSVEdgeTypes.END_ID));

		ASTNode startNode = ast.getNodeById(startId);
		ASTNode endNode = ast.getNodeById(endId);

		startNode.addChild(endNode);
		
		return startId;
	}

}
