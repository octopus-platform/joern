package octopus.lib.csvImporter;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import octopus.lib.projects.OctopusProject;
import octopus.lib.projects.ProjectManager;
import titanimporter.CSVImporter;

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
		String projectName = importJob.getProjectName();

		ProjectManager projectManager = new ProjectManager();
		OctopusProject project = projectManager.getProjectByName(projectName);
		if(project == null)
			throw new RuntimeException("Error: project dos not exist");

		try
		{
			csvBatchImporter.setGraph(project.getDatabase().getGraph());
			csvBatchImporter.importCSVFiles(nodeFilename, edgeFilename);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		logger.warn("Import finished");
	}

}
