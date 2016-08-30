package joern.plugins.importer;

import java.io.File;
import java.nio.file.Path;

import octopus.api.csvImporter.CSVImporter;
import octopus.server.importer.csv.ImportJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fileWalker.SourceFileListener;
import joern.api.JoernProject;


public class ImporterListener extends SourceFileListener {

	private JoernProject joernProject;

	private static final Logger logger = LoggerFactory
			.getLogger(ImporterListener.class);

	@Override
	public void visitFile(Path filename)
	{
		String basePath = filename.getParent().toString();
		String nodeFilename = basePath + File.separator + "nodes.csv";
		String edgeFilename = basePath + File.separator + "edges.csv";

		String name = joernProject.getName();

		logger.debug("Importing " + nodeFilename + " " + edgeFilename + " into " + name);

		ImportJob importJob = new ImportJob(nodeFilename, edgeFilename, name);

		(new CSVImporter()).importCSV(importJob);
	}

	public void setProject(JoernProject project)
	{
		this.joernProject = project;
	}

	@Override public void initialize() { }
	@Override public void shutdown() { }
	@Override public void preVisitDirectory(Path dir) { }
	@Override public void postVisitDirectory(Path dir) { }

}
