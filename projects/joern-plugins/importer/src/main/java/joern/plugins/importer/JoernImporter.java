package joern.plugins.importer;

import java.io.IOException;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fileWalker.OrderedWalker;
import joern.pluginlib.JoernProject;
import joern.pluginlib.plugintypes.JoernProjectPlugin;

public class JoernImporter extends JoernProjectPlugin {

	private static final Logger logger = LoggerFactory
			.getLogger(JoernImporter.class);

	private String importCSVDirectory = "";

	@Override
	public void configure(JSONObject settings)
	{
		super.configure(settings);
		if(settings.has("importCSVDirectory"))
			this.importCSVDirectory = settings.getString("importCSVDirectory");
	}

	 @Override
     public void execute() throws Exception
	 {
		 if(this.importCSVDirectory.isEmpty()) {
			 uncompressArchive();
			 extractCSVFilesFromSourceCode();
		 }
		 importCSVFilesIntoDatabase();
	 }

	private void uncompressArchive() throws IOException
	{

		JoernProject joernProject = (JoernProject) getProjectConnector().getWrapper();

		String tarballFilename = joernProject.getTarballName();
		String outputDirectory = joernProject.getSourceCodeDirectory();

		logger.debug("uncompressing archive: " + tarballFilename);
		logger.debug("output directory: " + outputDirectory);

		new TarballDecompressor().decompress(tarballFilename, outputDirectory);

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
		String parserOutputDirectory =
				this.importCSVDirectory.isEmpty() ? joernProject.getParserOutputDirectory() : this.importCSVDirectory;

		OrderedWalker walker = new OrderedWalker();
		walker.setFilenameFilter("*nodes.csv");
		ImporterListener listener = new ImporterListener();
		listener.setProject(joernProject);

		walker.addListener(listener);
		walker.walk(new String[] { parserOutputDirectory } );

		logger.debug("Import complete");
	}

}
