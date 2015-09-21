package inputModules.csv.KeyedCSV;

import java.util.HashMap;

public class KeyedCSVRow
{
	private CSVKey[] keys;
	private HashMap<String, String> values = new HashMap<String, String>();

	public KeyedCSVRow(CSVKey[] keys)
	{
		this.keys = keys;
	}

	public void initFromRow(String[] row)
	{
		if (row.length > keys.length)
			throw new RuntimeException("Error: row too long");

		for (int i = 0; i < row.length; i++)
		{
			values.put(keys[i].getName(), row[i]);
		}
	}

	public String lookup(String key)
	{
		return values.get(key);
	}

}
