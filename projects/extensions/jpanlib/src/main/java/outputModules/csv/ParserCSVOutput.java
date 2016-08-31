package outputModules.csv;

import java.io.File;

import outputModules.CSVASTWalker;
import outputModules.common.Writer;
import outputModules.csv.exporters.CSVFunctionExporter;
import outputModules.parser.Parser;


public abstract class ParserCSVOutput extends Parser
{

	private CSVFunctionExporter functionExporter;
	boolean multiFileOutput = true;

	public void setMultiFileOutput(boolean multiFileOutput)
	{
		this.multiFileOutput = multiFileOutput;
	}

	@Override
	public void initialize()
	{
		if(multiFileOutput)
			Writer.setWriterImpl(new MultiPairCSVWriterImpl());
		else
			Writer.setWriterImpl(new SinglePairCSVWriterImpl());

		super.initialize();
	}

	@Override
	protected void initializeDatabase()
	{
		createOutputDirectory();
	}

	private void createOutputDirectory()
	{
		File outputDirectory = new File(outputDir);
		if (outputDirectory.exists())
			throw new RuntimeException("Output directory already exists");

		try
		{
			outputDirectory.mkdirs();
		} catch (SecurityException ex)
		{
			throw new RuntimeException(
					"Cannot create output directory, permission denied.");
		}
	}

	@Override
	protected void shutdownDatabase()
	{
		Writer.getWriterImpl().shutdown();
	}

	@Override
	protected void initializeDirectoryImporter()
	{
		if(multiFileOutput)
			dirTreeImporter = new MultiDirCSVDirectoryTreeImporter();
		else
			dirTreeImporter = new SingleDirCSVDirectoryTreeImporter();
	}

	@Override
	protected void initializeWalker()
	{
		astWalker = new CSVASTWalker(getFunctionExporter());
	}

	public CSVFunctionExporter getFunctionExporter()
	{
		return functionExporter;
	}

	public void setFunctionExporter(CSVFunctionExporter functionExporter)
	{
		this.functionExporter = functionExporter;
	}

}
