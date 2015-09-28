package inputModules.csv.csvFuncExtractor;

import inputModules.csv.KeyedCSV.KeyedCSVReader;
import inputModules.csv.KeyedCSV.KeyedCSVRow;

/**
 * A KeyedCSVReader that returns rows only if they meet a given criteria.
 */

public class FilteredKeyedCSVReader extends KeyedCSVReader
{

	protected RowFilter filterFunc;

	public KeyedCSVRow getNextRow()
	{

		// skip lines that are not in range.
		while (!filterFunc.lineNoIsInRange(getCurrentLineNumber() + 1))
		{
			// TODO: Optimization: skip the row instead of parsing it
			// and then discarding it.
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
