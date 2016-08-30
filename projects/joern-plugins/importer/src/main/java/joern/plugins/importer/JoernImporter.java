package joern.plugins.importer;

import java.io.IOException;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fileWalker.OrderedWalker;
import joern.api.JoernProject;
import joern.api.plugintypes.JoernProjectPlugin;
import octopus.api.decompressor.Decompressor;

public class JoernImporter extends JoernProjectPlugin {

	private static final Logger logger = LoggerFactory
			.getLogger(JoernImporter.class);

	private boolean uncompress = true;
	private boolean parsecode = true;
	private boolean importcsv = true;

	private JoernProject joernProject;


	@Override
	public void configure(JSONObject settings)
	{
		super.configure(settings);

		if(settings.has("nouncompress"))
			uncompress = false;
		if(settings.has("noparsecode"))
			parsecode = false;
		if(settings.has("noimportcsv"))
			importcsv = false;
	}


	 @Override
     public void execute() throws Exception
	 {
		openProject();

		if(uncompress) uncompressArchive();
		if(parsecode) parseSourceCode();
		if(importcsv) importCSVFilesIntoDatabase();
	 }

	private void openProject()
	{
		joernProject = (JoernProject) getProjectConnector().getWrapper();
	}


	private void uncompressArchive() throws IOException
	{
		String tarballFilename = joernProject.getTarballName();
		String outputDirectory = joernProject.getSourceCodeDirectory();

		logger.debug("uncompressing archive: " + tarballFilename);
		logger.debug("output directory: " + outputDirectory);

		new Decompressor().decompressTarball(tarballFilename, outputDirectory);

		logger.debug("decompression successful");
	}

	private void parseSourceCode()
	{
		logger.debug("Parsing code");

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
