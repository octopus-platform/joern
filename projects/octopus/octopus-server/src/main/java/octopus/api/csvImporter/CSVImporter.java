package octopus.api.csvImporter;

import octopus.server.csvimporter.ImportCSVRunnable;
import octopus.server.csvimporter.ImportJob;

public class CSVImporter {

	public void importCSV(ImportJob job)
	{
		(new ImportCSVRunnable(job)).run();
	}

}
