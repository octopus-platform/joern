package inputModules.csv.csvFuncExtractor;

import java.io.IOException;
import java.io.Reader;

import ast.functionDef.FunctionDef;
import inputModules.csv.KeyedCSV.KeyedCSVReader;
import inputModules.csv.KeyedCSV.KeyedCSVRow;
import inputModules.csv.csv2ast.CSV2AST;

public class CSVFunctionExtractor
{

	String functionId = null;
	KeyedCSVReader nodeReader;
	KeyedCSVReader edgeReader;
	CSVAST csvAST;
	CSVAST topLevelFuncAST = new CSVAST();

	KeyedCSVRow lastNodeRow;

	public void initialize(Reader nodeStrReader, Reader edgeStrReader)
			throws IOException
	{
		nodeReader = new KeyedCSVReader();
		edgeReader = new KeyedCSVReader();
		nodeReader.init(nodeStrReader);
		edgeReader.init(edgeStrReader);
	}

	public FunctionDef getNextFunction() throws IOException
	{

		initCSVAST();
		readNextCSV();

		if (csvAST == null)
			return null;

		System.out.println(csvAST.getNodesAsString());

		CSV2AST csv2ast = new CSV2AST();
		csv2ast.setLanguage("PHP");
		return csv2ast.convert(csvAST);
	}

	private void initCSVAST()
	{
		if (functionId == null)
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

	private void readNextCSV()
	{
		addNodeRowsUntilNextFunctionId();
	}

	private void addNodeRowsUntilNextFunctionId()
	{
		while (nodeReader.hasNextRow())
		{
			lastNodeRow = nodeReader.getNextRow();
			String newFuncId = lastNodeRow.getFieldForKey("funcId");
			if (newFuncId != functionId)
			{
				if (functionId != null)
					break;
				else
				{
					// finished top-level scope
					functionId = newFuncId;
					initCSVAST();
					continue;
				}
			}

			csvAST.addNodeRow(lastNodeRow.toString());
		}

		if (csvAST.getNumberOfNodes() == 0)
			csvAST = null;
	}

}
