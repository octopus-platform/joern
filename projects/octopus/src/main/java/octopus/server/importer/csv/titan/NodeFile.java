package octopus.server.importer.csv.titan;

import java.io.IOException;
import java.util.Arrays;

public class NodeFile extends CSVFile {

	private String[] keys;

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
		// remove first key, it's the command
		keys = Arrays.copyOfRange(keys, 1, keys.length);
	}

	public String[] getKeys()
	{
		return keys;
	}

}
