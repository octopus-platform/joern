package inputModules.csv.csvFuncExtractor;

class CSVFunctionExtractorState
{
	int stateId;
	int functionId;
	Range range;

	public CSVFunctionExtractorState(int left, int right)
	{
		range = new Range(left, right);
	}

	public int getCurrentStateId()
	{
		return stateId;
	}

	public int getCurrentFunctionId()
	{
		return functionId;
	}

	public void increaseRightBorder()
	{
		range.endNo++;
	}
}
