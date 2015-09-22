package inputModules.csv.KeyedCSV;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.csv.CSVRecord;

public class KeyedCSVRow
{
	private CSVKey[] keys;
	private Map<String, String> values = new HashMap<String, String>();

	public KeyedCSVRow(CSVKey[] keys)
	{
		this.keys = keys;
	}

	public String getFieldForKey(String key)
	{
		String val = values.get(key);
		if (val == null)
			return "";
		return val;
	}

	public void initFromCSVRecord(CSVRecord record)
	{
		int i = 0;
		for (String r : record)
		{
			String keyStr = keys[i].getName();
			values.put(keyStr, r);
			i++;
		}

	}

}
