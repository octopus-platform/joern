package inputModules.csv.csvFuncExtractor;

import java.io.Reader;
import java.util.LinkedList;
import java.util.List;

import ast.functionDef.FunctionDef;

public class CSVFunctionExtractor
{
	List<Range> functionRanges = new LinkedList<Range>();
	List<Range> topLevelRanges = new LinkedList<Range>();
	int currentFunctionId;

	public void initialize(Reader nodeReader, Reader edgeReader)
	{
		initializeRange(nodeReader, edgeReader);
	}

	private void initializeRange(Reader nodeReader, Reader edgeReader)
	{

	}

	/**
	 * Read nodes, adding them to the top-level function if they don't have a
	 * functionId, and adding them to the current function if they do. Whenever
	 * a new functionId is encountered, emit the current function. If the end of
	 * file is reached, emit the function as well. When get nextFunction is
	 * called once more, emit the top-level function.
	 */

	public FunctionDef getNextFunction()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
