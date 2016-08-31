package octopus.server.importer.csv.titan;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

public class CSVFile {

	CSVReader csvReader;

	public void openFile(String filename) throws IOException
	{
		csvReader = getCSVReaderForFile(filename);
	}

	private CSVReader getCSVReaderForFile(String filename)
			throws FileNotFoundException
	{
		CSVReader reader;
		FileReader fileReader = new FileReader(filename);
		reader = new CSVReader(fileReader, '\t');
		return reader;
	}

	public String [] getNextRow() throws IOException
	{
		return csvReader.readNext();
	}

}
