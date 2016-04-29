package inputModules.csv.KeyedCSV;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class KeyedCSVReader
{
	private CSVKey[] keys;
	private CSVParser parser;
	private Iterator<CSVRecord> iterator;
	private int currentLineNumber;

	public void init(Reader reader) throws IOException
	{
		parser = CSVFormat.TDF.withEscape('\\').parse(reader);
		initKeys();
		currentLineNumber = 0;
	}

	private void initKeys()
	{
		iterator = parser.iterator();
		CSVRecord header = iterator.next();

		keys = new CSVKey[header.size()];

		for (int i = 0; i < header.size(); i++)
		{
			String field = header.get(i);
			keys[i] = createKeyFromFields(field);
		}
	}

	private CSVKey createKeyFromFields(String field)
	{		
		String[] keyParts = field.split(":");
		CSVKey key = new CSVKey(keyParts[0]);
		if (keyParts.length > 1)
			key.setType(keyParts[1]);
		
		return key;
	}

	public KeyedCSVRow getNextRow()
	{
		CSVRecord record;

		try
		{
			record = iterator.next();
		} catch (NoSuchElementException ex)
		{
			return null;
		}
		
		currentLineNumber++;
		KeyedCSVRow keyedRow = new KeyedCSVRow(keys);
		keyedRow.initFromCSVRecord(record);
		return keyedRow;
	}


	public boolean hasNextRow()
	{
		return iterator.hasNext();
	}
	
	public void deinit() throws IOException
	{
		parser.close();
	}

	public int getCurrentLineNumber()
	{
		return currentLineNumber;
	}
	
	public CSVKey[] getKeys()
	{
		return keys;
	}
}