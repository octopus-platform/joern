package octopus.server.components.orientdbImporter;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import orientdbimporter.CSVImporter;

public class ImportCSVRunnable implements Runnable
{

	private static final Logger logger = LoggerFactory
			.getLogger(ImportCSVRunnable.class);

	private final ImportJob importJob;

	public ImportCSVRunnable(ImportJob importJob)
	{
		this.importJob = importJob;
	}

	@Override
	public void run()
	{

		CSVImporter csvBatchImporter = new CSVImporter();

		String nodeFilename = importJob.getNodeFilename();
		String edgeFilename = importJob.getEdgeFilename();

		String dbName = importJob.getDbName();

		try
		{
			csvBatchImporter.setDbName(dbName);
			csvBatchImporter.importCSVFiles(nodeFilename, edgeFilename);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		logger.warn("Import finished");
	}

}
