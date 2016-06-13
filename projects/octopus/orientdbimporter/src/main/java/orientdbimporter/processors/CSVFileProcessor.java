package orientdbimporter.processors;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

import orientdbimporter.CSVImporter;

public abstract class CSVFileProcessor
{
	protected final CSVImporter importer;

	public CSVFileProcessor(CSVImporter importer)
	{
		this.importer = importer;
	}

	public void process(String filename) throws IOException
	{
		CSVReader csvReader = getCSVReaderForFile(filename);

		String[] row = csvReader.readNext();
		if (row == null)
			throw new RuntimeException("File must contain at least one line");

		processFirstRow(csvReader, row);

		while ((row = csvReader.readNext()) != null)
		{
			processRow(row);
		}
	}

	protected abstract void processFirstRow(CSVReader csvReader, String[] row)
			throws IOException;

	protected abstract void processRow(String[] row);

	private CSVReader getCSVReaderForFile(String filename)
			throws FileNotFoundException
	{
		CSVReader reader;
		FileReader fileReader = new FileReader(filename);
		reader = new CSVReader(fileReader, '\t');
		return reader;
	}

	protected String[] rowToKeys(String[] row)
	{
		String[] keys = new String[row.length];
		for (int i = 0; i < row.length; i++)
		{
			keys[i] = row[i];
		}
		return keys;
	}

}
