package octopus.server.importer.csv.titan;

import java.io.IOException;

public class EdgeFile extends CSVFile
{
	String [] keys;

	@Override
	public void openFile(String filename) throws IOException
	{
		super.openFile(filename);
		initPropertyNames();
	}

	private void initPropertyNames() throws IOException
	{
		String[] row = getNextRow();
		if(row == null)
			throw new RuntimeException("File does not contain a complete line");

		keys = row;
	}

	public String[] getKeys()
	{
		return keys;
	}


}
