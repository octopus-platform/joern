package tests.inputModules;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.StringReader;

import org.junit.Test;

import inputModules.csv.KeyedCSV.CSVKey;
import inputModules.csv.KeyedCSV.KeyedCSVReader;
import inputModules.csv.KeyedCSV.KeyedCSVRow;

public class TestKeyedCSVReader
{

	@Test
	public void testSimpleHeaderParsing() throws IOException
	{
		KeyedCSVReader csvReader = initReaderWithString("foo,bar\n1,2");
		CSVKey[] keys = csvReader.getKeys();
		assertEquals(keys.length, 2);
		assertEquals("foo", keys[0].getName());
		assertEquals("bar", keys[1].getName());
	}

	@Test
	public void testHeaderWithTypeParsing() throws IOException
	{
		KeyedCSVReader csvReader = initReaderWithString("foo:type,bar\n1,2");
		CSVKey[] keys = csvReader.getKeys();
		assertEquals("foo", keys[0].getName());
		assertEquals("type", keys[0].getType());
	}

	@Test
	public void testHeaderWithTypeAndIndexParsing() throws IOException
	{
		KeyedCSVReader csvReader = initReaderWithString(
				"foo:type:nodeIndex,bar\n1,2");
		CSVKey[] keys = csvReader.getKeys();
		assertEquals("foo", keys[0].getName());
		assertEquals("type", keys[0].getType());
		assertEquals("nodeIndex", keys[0].getIndex());
	}

	@Test
	public void testFieldRetrieval() throws IOException
	{
		KeyedCSVReader csvReader = initReaderWithString("foo,bar\n1,2");
		KeyedCSVRow row = csvReader.getNextRow();

		String field = row.getFieldForKey("foo");
		assertEquals("1", field);
	}

	@Test
	public void testEOF() throws IOException
	{
		KeyedCSVReader csvReader = initReaderWithString("foo,bar");
		KeyedCSVRow row = csvReader.getNextRow();
		assertEquals(row, null);
	}

	@Test
	public void testQuoting() throws IOException
	{
		KeyedCSVReader csvReader = initReaderWithString("foo,bar\n\"1\",2");
		KeyedCSVRow row = csvReader.getNextRow();
		assertEquals("1", row.getFieldForKey("foo"));
	}

	@Test
	public void testQuoteInQuote() throws IOException
	{
		KeyedCSVReader csvReader = initReaderWithString("foo,bar\n\"\\\"1\",2");
		KeyedCSVRow row = csvReader.getNextRow();
		assertEquals("\"1", row.getFieldForKey("foo"));
	}

	private KeyedCSVReader initReaderWithString(String str) throws IOException
	{
		KeyedCSVReader csvReader = new KeyedCSVReader();
		StringReader reader = new StringReader(str);
		csvReader.init(reader);
		return csvReader;
	}

}
