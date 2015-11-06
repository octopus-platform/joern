package inputModules.csv.csv2ast;

import inputModules.csv.KeyedCSV.KeyedCSVRow;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;

public interface CSVRowInterpreter
{
	public long handle(KeyedCSVRow row, ASTUnderConstruction ast) throws InvalidCSVFile;
}
