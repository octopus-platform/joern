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

	private KeyedCSVReader initReaderWithString(String str) throws IOException
	{
		KeyedCSVReader csvReader = new KeyedCSVReader();
		StringReader reader = new StringReader(str);
		csvReader.init(reader);
		return csvReader;
	}
	
	@Test
	public void testSimpleHeaderParsing() throws IOException
	{
		String csvStr = "foo\tbar\n";
		csvStr += "1\t2";
		KeyedCSVReader csvReader = initReaderWithString(csvStr);
		CSVKey[] keys = csvReader.getKeys();
		assertEquals(keys.length, 2);
		assertEquals("foo", keys[0].getName());
		assertEquals("bar", keys[1].getName());
	}

	@Test
	public void testHeaderWithTypeParsing() throws IOException
	{
		String csvStr = "foo:type\tbar\n";
		csvStr += "1\t2";
		KeyedCSVReader csvReader = initReaderWithString(csvStr);
		CSVKey[] keys = csvReader.getKeys();
		assertEquals("foo", keys[0].getName());
		assertEquals("type", keys[0].getType());
		assertEquals("bar", keys[1].getName());
		assertEquals("string", keys[1].getType());
	}

	@Test
	public void testFieldRetrieval() throws IOException
	{
		String csvStr = "foo\tbar:int\t:unnamedtype\n";
		csvStr += "1\t2\t3";
		KeyedCSVReader csvReader = initReaderWithString(csvStr);
		KeyedCSVRow row = csvReader.getNextRow();

		String field = row.getFieldForKey(new CSVKey("foo"));
		String samefield = row.getFieldForKey(new CSVKey("foo", "string"));
		String field2 = row.getFieldForKey(new CSVKey("bar", "int"));
		String field3 = row.getFieldForKey(new CSVKey("", "unnamedtype"));

		assertEquals("1", field);
		assertEquals("1", samefield);
		assertEquals("2", field2);
		assertEquals("3", field3);
	}

	@Test
	public void testEOF() throws IOException
	{
		String csvStr = "foo,bar";
		KeyedCSVReader csvReader = initReaderWithString(csvStr);
		KeyedCSVRow row = csvReader.getNextRow();
		assertEquals(row, null);
	}

	@Test
	public void testQuoting() throws IOException
	{
		String csvStr = "foo\tbar\n";
		csvStr += "\"1\"\t2";

		KeyedCSVReader csvReader = initReaderWithString(csvStr);
		KeyedCSVRow row = csvReader.getNextRow();
		assertEquals("1", row.getFieldForKey(new CSVKey("foo")));
	}

	@Test
	public void testQuoteInQuote() throws IOException
	{
		String csvStr = "foo\tbar\n";
		csvStr += "\"\\\"1\"\t2";
		
		KeyedCSVReader csvReader = initReaderWithString(csvStr);
		KeyedCSVRow row = csvReader.getNextRow();
		assertEquals("\"1", row.getFieldForKey(new CSVKey("foo")));
	}
}
