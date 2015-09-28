package inputModules.csv.csvFuncExtractor;

import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;

import ast.functionDef.FunctionDef;
import inputModules.csv.KeyedCSV.KeyedCSVReader;
import inputModules.csv.KeyedCSV.KeyedCSVRow;
import tools.phpast2cfg.PHPCSVNodeTypes;

public class CSVFunctionExtractor
{

	List<Range> functionRanges = new LinkedList<Range>();
	List<Range> topLevelRanges = new LinkedList<Range>();

	private static final int TOP_LEVEL_ID = -1;
	CSVFunctionExtractorState state;

	private static final int STATE_TOP_LEVEL = 1;
	private static final int STATE_IN_FUNC = 2;

	public void initialize(Reader nodeReader, Reader edgeReader)
			throws IOException
	{
		cleanTopLevelState();
		initializeRanges(nodeReader, edgeReader);
	}

	private void initializeRanges(Reader nodeReader, Reader edgeReader)
			throws IOException
	{
		initializeNodeRanges(nodeReader);
		// initializeEdgeRanges(edgeReader);
	}

	private void cleanTopLevelState()
	{
		state = new CSVFunctionExtractorState(0, 0);
		state.functionId = TOP_LEVEL_ID;
	}

	private void initializeNodeRanges(Reader reader) throws IOException
	{
		KeyedCSVReader csvReader = new KeyedCSVReader();
		csvReader.init(reader);

		KeyedCSVRow row;
		while ((row = csvReader.getNextRow()) != null)
		{
			processNodeRow(row);
		}
		finishNodeRangeInitialization();
	}

	private void processNodeRow(KeyedCSVRow row)
	{

		Integer functionId = getFunctionId(row);

		switch (state.getCurrentStateId())
		{
		case STATE_TOP_LEVEL:
			if (functionId != TOP_LEVEL_ID)
				changeToNewFunction();
			break;
		case STATE_IN_FUNC:

			if (functionId == TOP_LEVEL_ID)
				changeToTopLevel();
			else if (functionId != state.getCurrentFunctionId())
				changeToNewFunction();
			break;
		}

		updateRange();
	}

	private void changeToTopLevel()
	{
		storeCurrentFunction();
		swapInTopLevelFunction();
	}

	private void storeCurrentFunction()
	{
		// TODO Auto-generated method stub

	}

	private void swapInTopLevelFunction()
	{
		// TODO Auto-generated method stub

	}

	private void changeToNewFunction()
	{
		storeCurrentFunction();
		createNewFunction();
	}

	private void createNewFunction()
	{
		// TODO Auto-generated method stub

	}

	private Integer getFunctionId(KeyedCSVRow row)
	{
		String rowFuncId = row.getFieldForKey(PHPCSVNodeTypes.FUNCID);
		if (rowFuncId == null)
			return TOP_LEVEL_ID;

		return Integer.parseInt((rowFuncId));
	}

	private void updateRange()
	{
		state.increaseRightBorder();
	}

	private void finishNodeRangeInitialization()
	{
		storeCurrentFunction();
	}

	// private void initializeEdgeRanges()
	// {

	// }

	public FunctionDef getNextFunction()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
