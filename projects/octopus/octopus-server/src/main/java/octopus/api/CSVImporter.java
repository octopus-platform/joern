package octopus.api;

import octopus.api.csvImporter.ImportCSVRunnable;
import octopus.api.csvImporter.ImportJob;

public class CSVImporter {

	public void importCSV(ImportJob job)
	{
		(new ImportCSVRunnable(job)).run();
	}

}
