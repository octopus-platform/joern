package joern.plugins.importer;

import java.io.IOException;

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
		JoernProject joernProject = (JoernProject) getBjoernProjectConnector().getWrapper();

		String tarballFilename = joernProject.getTarballName();
		String outputDirectory = joernProject.getSourceCodeDirectory();

		new TarballDecompressor().decompress(tarballFilename, outputDirectory);
	}

	private void extractCSVFilesFromSourceCode()
	{
		JoernProject joernProject = (JoernProject) getBjoernProjectConnector().getWrapper();
		String parserOutputDirectory = joernProject.getParserOutputDirectory();
		String sourceCodeDirectory = joernProject.getSourceCodeDirectory();

		CParserWrapper parserWrapper = new CParserWrapper();
		parserWrapper.initialize(parserOutputDirectory);
		parserWrapper.walkCodebase(new String[] { sourceCodeDirectory });
	}

	private void importCSVFilesIntoDatabase()
	{
		// TODO Auto-generated method stub
	}

}
