package inputModules.csv.KeyedCSV;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.csv.CSVRecord;

public class KeyedCSVRow
{
	private CSVKey[] keys;
	private Map<CSVKey,String> values = new HashMap<CSVKey,String>();
	private String stringRepr;

	public KeyedCSVRow(CSVKey[] keys)
	{
		this.keys = keys;
	}

	public void initFromCSVRecord(CSVRecord record)
	{
		stringRepr = "";
		int i = 0;
		Iterator<String> recIt = record.iterator();
		while (recIt.hasNext())
		{
			String r = recIt.next();
			values.put(keys[i], r);
			stringRepr += r;
			if (recIt.hasNext())
				stringRepr += ",";
			i++;
		}
	}

	public String getFieldForKey(CSVKey key)
	{
		String val = values.get(key);
		return (null == val) ? "" : val;
	}
	
	@Override
	public String toString()
	{
		return stringRepr;
	}

}
