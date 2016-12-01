package tests.inputModules;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.HashMap;

import org.junit.Test;

import inputModules.csv.KeyedCSV.CSVKey;

public class TestCSVKey
{

	@Test
	public void testCSVKeyEquality()
	{
		CSVKey key1 = new CSVKey("foo", "bar");
		CSVKey key2 = new CSVKey("foo", "bar");

		assertEquals(key1, key2);
	}
	
	@Test
	public void testCSVKeyInEquality()
	{
		CSVKey key1 = new CSVKey("foo", "bar");
		CSVKey key2 = new CSVKey("foo", "buz");
		CSVKey key3 = new CSVKey("qux", "bar");

		assertNotEquals(key1, key2);
		assertNotEquals(key1, key3);
		assertNotEquals(key2, key3);
	}

	@Test
	public void testCSVKeyHashMap()
	{
		HashMap<CSVKey,String> values = new HashMap<CSVKey,String>();
		CSVKey key1 = new CSVKey("foo", "bar");
		CSVKey key2 = new CSVKey("foo", "bar");
		CSVKey key3 = new CSVKey("foo", "buz");
		
		values.put(key1, "one");
		values.put(key2, "two");
		values.put(key3, "three");

		assertEquals(values.size(), 2);
		assertEquals(values.get(key1), "two");
		assertEquals(values.get(key2), "two");
		assertEquals(values.get(key3), "three");
	}
	
}
