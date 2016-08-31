package inputModules.csv.csv2ast;

import java.util.Iterator;

import inputModules.csv.PHPCSVNodeTypes;
import inputModules.csv.KeyedCSV.KeyedCSVRow;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;

public class PHPCSV2AST extends CSV2AST {

	@Override
	protected void createASTNodes(CSVAST csvAST, ASTUnderConstruction ast) throws InvalidCSVFile
	{
		Iterator<KeyedCSVRow> nodeRows = csvAST.nodeIterator();
		KeyedCSVRow keyedRow = getFirstKeyedRow(nodeRows);

		// first row must be a function type;
		// otherwise we cannot create a function node
		if( !PHPCSVNodeTypes.funcTypes.contains(keyedRow.getFieldForKey(PHPCSVNodeTypes.TYPE)))
			throw new InvalidCSVFile( "Type of first row is not a function declaration.");

		createASTForFunction(ast, nodeRows, keyedRow);
	}

}
