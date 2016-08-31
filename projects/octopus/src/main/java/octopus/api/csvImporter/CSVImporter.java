package octopus.api.csvImporter;

import octopus.server.importer.csv.ImportCSVRunnable;
import octopus.server.importer.csv.ImportJob;

public class CSVImporter {

	public void importCSV(ImportJob job)
	{
		(new ImportCSVRunnable(job)).run();
	}

}
