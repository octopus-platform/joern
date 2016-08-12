package joern.plugins.importer;

import java.io.File;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fileWalker.SourceFileListener;
import joern.pluginlib.JoernProject;
import octopus.api.csvImporter.ImportCSVRunnable;
import octopus.api.csvImporter.ImportJob;

public class ImporterListener extends SourceFileListener {

	private JoernProject joernProject;

	private static final Logger logger = LoggerFactory
			.getLogger(ImporterListener.class);

	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitFile(Path filename)
	{
		String basePath = filename.getParent().toString();
		String nodeFilename = basePath + File.separator + "nodes.csv";
		String edgeFilename = basePath + File.separator + "edges.csv";

		String name = joernProject.getName();

		logger.debug("Importing " + nodeFilename + " " + edgeFilename + " into " + name);

		ImportJob importJob = new ImportJob(nodeFilename, edgeFilename, name);
        (new ImportCSVRunnable(importJob)).run();
	}

	@Override
	public void preVisitDirectory(Path dir) {
		// TODO Auto-generated method stub

	}

	@Override
	public void postVisitDirectory(Path dir) {
		// TODO Auto-generated method stub

	}

	public void setProject(JoernProject project)
	{
		this.joernProject = project;
	}

}
