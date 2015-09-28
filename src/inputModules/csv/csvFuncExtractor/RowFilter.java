package inputModules.csv.csvFuncExtractor;

import java.util.LinkedList;
import java.util.List;

import inputModules.csv.KeyedCSV.KeyedCSVRow;

public class RowFilter
{
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

	List<Range> ranges = new LinkedList<Range>();

	public boolean rowMatches(KeyedCSVRow row)
	{
		return true;
	}

	public boolean lineNoIsInRange(int lineNo)
	{
		for (Range range : ranges)
		{
			if (range.contains(lineNo))
				return true;
		}
		return false;
	}

	public void addRange(int startNo, int endNo)
	{
		ranges.add(new Range(startNo, endNo));
	}

}
