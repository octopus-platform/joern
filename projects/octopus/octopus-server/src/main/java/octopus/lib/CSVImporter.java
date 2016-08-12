package octopus.lib;

import octopus.lib.csvImporter.ImportCSVRunnable;
import octopus.lib.csvImporter.ImportJob;

public class CSVImporter {

	public void importCSV(ImportJob job)
	{
		(new ImportCSVRunnable(job)).run();
	}

}
