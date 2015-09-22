package inputModules.csv.csv2ast;

import inputModules.csv.KeyedCSV.KeyedCSVRow;

public interface CSVNodeInterpreter
{
	// TODO, will need to provide a way to add edges as well.
	public void handle(KeyedCSVRow row, ASTUnderConstruction ast);
}
