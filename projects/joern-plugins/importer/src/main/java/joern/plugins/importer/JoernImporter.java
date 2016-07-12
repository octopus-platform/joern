package joern.plugins.importer;

import java.io.IOException;

import fileWalker.OrderedWalker;
import joern.pluginlib.JoernProject;
import joern.pluginlib.plugintypes.JoernProjectPlugin;

public class JoernImporter extends JoernProjectPlugin {

	 @Override
     public void execute() throws Exception
	 {
		 raiseIfDatabaseForProjectExists();
		 uncompressArchive();
		 extractCSVFilesFromSourceCode();
		 importCSVFilesIntoDatabase();
	 }

	private void uncompressArchive() throws IOException
	{
		JoernProject joernProject = (JoernProject) getProjectConnector().getWrapper();

		String tarballFilename = joernProject.getTarballName();
		String outputDirectory = joernProject.getSourceCodeDirectory();

		new TarballDecompressor().decompress(tarballFilename, outputDirectory);
	}

	private void extractCSVFilesFromSourceCode()
	{
		JoernProject joernProject = (JoernProject) getProjectConnector().getWrapper();
		String parserOutputDirectory = joernProject.getParserOutputDirectory();
		String sourceCodeDirectory = joernProject.getSourceCodeDirectory();

		CParserWrapper parserWrapper = new CParserWrapper();
		parserWrapper.setMultiFileOutput(false);
		parserWrapper.initialize(parserOutputDirectory);
		parserWrapper.walkCodebase(new String[] { sourceCodeDirectory });
	}

	private void importCSVFilesIntoDatabase() throws IOException
	{
		JoernProject joernProject = (JoernProject) getProjectConnector().getWrapper();
		String parserOutputDirectory = joernProject.getParserOutputDirectory();

		OrderedWalker walker = new OrderedWalker();
		walker.setFilenameFilter("*nodes.csv");
		ImporterListener listener = new ImporterListener();
		listener.setProject(joernProject);

		walker.addListener(listener);
		walker.walk(new String[] { parserOutputDirectory } );

	}

}
