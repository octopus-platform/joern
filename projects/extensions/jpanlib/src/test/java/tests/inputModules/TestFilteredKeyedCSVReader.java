package tests.inputModules;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.StringReader;

import org.junit.Test;

import inputModules.csv.csvFuncExtractor.FilteredKeyedCSVReader;
import inputModules.csv.csvFuncExtractor.RowFilter;

public class TestFilteredKeyedCSVReader
{

	@Test
	public void testRangeLimit() throws IOException
	{
		FilteredKeyedCSVReader reader = new FilteredKeyedCSVReader();
		StringReader stringReader = new StringReader("foo,bar\n1,2\n3,4\n");
		reader.init(stringReader);

		int startNo = 0;
		int endNo = 1;

		RowFilter rowFilter = new RowFilter();
		rowFilter.addRange(startNo, endNo);
		reader.setFilter(rowFilter);

		assertTrue(reader.getNextRow() != null);
		assertTrue(reader.getNextRow() == null);

	}

}
