package tools.phpast2cfg.KeyedCSV;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

import tools.phpast2cfg.KeyedCSV.exceptions.InvalidCSVFile;

public class KeyedCSVReader
{
	private CSVReader csvReader;
	CSVKey[] keys;
	char separator = '\t';

	public void setSeparator(char separator)
	{
		this.separator = separator;
	}

	public void open(String filename) throws InvalidCSVFile, IOException
	{
		initializeCSVReader(filename);
		readKeysFromFirstRow();
	}

	public KeyedCSVRow getNextRow() throws IOException
	{
		String[] row = csvReader.readNext();
		if (row == null)
			return null;

		KeyedCSVRow keyedRow = new KeyedCSVRow(keys);
		keyedRow.initFromRow(row);
		return keyedRow;
	}

	public void close() throws IOException
	{
		csvReader.close();
	}

	private void initializeCSVReader(String filename)
			throws FileNotFoundException
	{
		FileReader fileReader = new FileReader(filename);
		csvReader = new CSVReader(fileReader, separator);
	}

	private void readKeysFromFirstRow() throws InvalidCSVFile, IOException
	{
		String[] row = csvReader.readNext();
		if (row == null)
			throw new InvalidCSVFile();

		initializeKeysFromRow(row);
	}

	private void initializeKeysFromRow(String[] row)
	{
		int numberOfKeys = row.length;
		keys = new CSVKey[numberOfKeys];
		for (int i = 0; i < numberOfKeys; i++)
			keys[i].setName(row[i]);

		// TODO: key parsing: we need to split at ':'
		// to separate name, type and nodeIndex.
	}

}
