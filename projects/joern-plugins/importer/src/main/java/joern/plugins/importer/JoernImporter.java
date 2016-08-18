package joern.plugins.importer;

import java.io.IOException;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fileWalker.OrderedWalker;
import joern.pluginlib.JoernProject;
import joern.pluginlib.plugintypes.JoernProjectPlugin;
import octopus.api.decompressor.Decompressor;

public class JoernImporter extends JoernProjectPlugin {

	private static final Logger logger = LoggerFactory
			.getLogger(JoernImporter.class);

	private boolean uncompress = true;
	private boolean extractcsv = true;
	private boolean importcsv = true;


	@Override
	public void configure(JSONObject settings)
	{
		super.configure(settings);

		if(settings.getString("nouncompress") != null)
			uncompress = false;
		if(settings.getString("noextractcsv") != null)
			extractcsv = false;
		if(settings.getString("noimportcsv") != null)
			importcsv = false;
	}


	 @Override
     public void execute() throws Exception
	 {
		if(uncompress) uncompressArchive();
		if(extractcsv) extractCSVFilesFromSourceCode();
		if(importcsv) importCSVFilesIntoDatabase();
	 }

	private void uncompressArchive() throws IOException
	{

		JoernProject joernProject = (JoernProject) getProjectConnector().getWrapper();

		String tarballFilename = joernProject.getTarballName();
		String outputDirectory = joernProject.getSourceCodeDirectory();

		logger.debug("uncompressing archive: " + tarballFilename);
		logger.debug("output directory: " + outputDirectory);

		new Decompressor().decompressTarball(tarballFilename, outputDirectory);

		logger.debug("decompression successful");
	}

	private void extractCSVFilesFromSourceCode()
	{
		logger.debug("Parsing code");

		JoernProject joernProject = (JoernProject) getProjectConnector().getWrapper();
		String parserOutputDirectory = joernProject.getParserOutputDirectory();
		String sourceCodeDirectory = joernProject.getSourceCodeDirectory();

		CParserWrapper parserWrapper = new CParserWrapper();
		parserWrapper.setMultiFileOutput(false);
		parserWrapper.initialize(parserOutputDirectory);
		parserWrapper.walkCodebase(new String[] { sourceCodeDirectory });

		logger.debug("Parsing complete");
	}

	private void importCSVFilesIntoDatabase() throws IOException
	{
		logger.debug("Importing graph");

		JoernProject joernProject = (JoernProject) getProjectConnector().getWrapper();
		String parserOutputDirectory = joernProject.getParserOutputDirectory();

		OrderedWalker walker = new OrderedWalker();
		walker.setFilenameFilter("*nodes.csv");
		ImporterListener listener = new ImporterListener();
		listener.setProject(joernProject);

		walker.addListener(listener);
		walker.walk(new String[] { parserOutputDirectory } );

		logger.debug("Import complete");
	}

}
