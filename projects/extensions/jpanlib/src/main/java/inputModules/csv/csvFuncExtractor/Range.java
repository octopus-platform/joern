package inputModules.csv.csvFuncExtractor;

class Range
{
	public Range(int startNo, int endNo)
	{
		this.startNo = startNo;
		this.endNo = endNo;
	}

	int startNo;
	int endNo;

	public boolean contains(int lineNo)
	{
		return (lineNo >= startNo && lineNo <= endNo);
	}
}