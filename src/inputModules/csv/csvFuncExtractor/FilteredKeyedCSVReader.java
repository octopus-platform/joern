package inputModules.csv.csvFuncExtractor;

import java.io.IOException;
import java.io.Reader;

import inputModules.csv.KeyedCSV.KeyedCSVReader;
import inputModules.csv.KeyedCSV.KeyedCSVRow;

/**
 * A KeyedCSVReader that returns rows only if they meet a given criteria.
 */

public class FilteredKeyedCSVReader extends KeyedCSVReader
{

	protected RowFilter filterFunc;
	protected int lineNo;

	@Override
	public void init(Reader reader) throws IOException
	{
		super.init(reader);
		lineNo = 0;
	}

	public KeyedCSVRow getNextRow()
	{
		lineNo++;

		// skip lines that are not in range.
		while (!filterFunc.lineNoIsInRange(lineNo))
		{
			KeyedCSVRow nextRow = super.getNextRow();
			if (nextRow == null)
				return null;
		}

		return super.getNextRow();
	}

	public void setFilter(RowFilter filterFunction)
	{
		filterFunc = filterFunction;
	}

}
