package inputModules.csv.csvFuncExtractor;

import java.io.IOException;
import java.io.Reader;

import ast.functionDef.FunctionDef;
import inputModules.csv.KeyedCSV.KeyedCSVReader;
import inputModules.csv.KeyedCSV.KeyedCSVRow;
import inputModules.csv.csv2ast.CSV2AST;

public class CSVFunctionExtractor
{

	String functionId = "";
	KeyedCSVReader nodeReader;
	KeyedCSVReader edgeReader;
	CSVAST csvAST;
	CSVAST topLevelFuncAST;
	CSV2AST csv2ast = new CSV2AST();

	KeyedCSVRow lastNodeRow;
	private boolean topLevelReturned = false;

	public void setLanguage(String language)
	{
		csv2ast.setLanguage(language);
	}

	public void initialize(Reader nodeStrReader, Reader edgeStrReader)
			throws IOException
	{
		nodeReader = new KeyedCSVReader();
		edgeReader = new KeyedCSVReader();
		nodeReader.init(nodeStrReader);
		edgeReader.init(edgeStrReader);
		initTopLevelFuncAST();
	}

	public FunctionDef getNextFunction() throws IOException
	{

		initCSVAST();
		boolean rowsLeft = readNextCSV();

		if (csvAST != topLevelFuncAST && csvAST.getNumberOfNodes() != 0)
			return csv2ast.convert(csvAST);

		else if (csvAST == topLevelFuncAST && rowsLeft == false
				&& csvAST.getNumberOfNodes() > 1 && !topLevelReturned)
		{
			topLevelReturned = true;
			return csv2ast.convert(topLevelFuncAST);
		}

		return null;
	}

	private void initCSVAST()
	{
		if (functionId.equals(""))
			csvAST = topLevelFuncAST;
		else
		{
			csvAST = new CSVAST();
			csvAST.addNodeRow(nodeReader.getKeyRow());
			csvAST.addEdgeRow(edgeReader.getKeyRow());
		}

		if (lastNodeRow != null)
			csvAST.addNodeRow(lastNodeRow.toString());
	}

	private void initTopLevelFuncAST()
	{
		topLevelFuncAST = new CSVAST();
		topLevelFuncAST.addNodeRow(nodeReader.getKeyRow());
		topLevelFuncAST.addNodeRow("-1,AST_METHOD,,<topLevel>\n");
		topLevelFuncAST.addEdgeRow(edgeReader.getKeyRow());
	}

	private boolean readNextCSV()
	{
		return addNodeRowsUntilNextFunctionId();
	}

	private boolean addNodeRowsUntilNextFunctionId()
	{
		boolean rowsLeft;

		while (true)
		{
			rowsLeft = nodeReader.hasNextRow();
			if (!rowsLeft)
				break;

			lastNodeRow = nodeReader.getNextRow();
			System.out.println(lastNodeRow);
			String newFuncId = lastNodeRow.getFieldForKey("funcId");

			if (!newFuncId.equals(functionId))
			{
				if (!functionId.equals(""))
				{
					// we were last inside a function.
					// By breaking, we just return it.
					functionId = newFuncId;
					break;
				} else
				{
					// finished top-level scope
					functionId = newFuncId;
					initCSVAST();
					continue;
				}
			}

			csvAST.addNodeRow(lastNodeRow.toString());
		}

		return rowsLeft;
	}

}
