package inputModules.csv.KeyedCSV;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.csv.CSVRecord;

public class KeyedCSVRow
{
	private CSVKey[] keys;
	private Map<String, String> values = new HashMap<String, String>();
	private String stringRepr;

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
		stringRepr = "";
		int i = 0;
		Iterator<String> recIt = record.iterator();
		while (recIt.hasNext())
		{
			String r = recIt.next();
			String keyStr = keys[i].getName();
			values.put(keyStr, r);
			stringRepr += r;
			if (recIt.hasNext())
				stringRepr += ",";
			i++;
		}
	}

	@Override
	public String toString()
	{
		return stringRepr;
	}

}
