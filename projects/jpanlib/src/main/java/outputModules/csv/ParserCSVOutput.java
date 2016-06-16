package outputModules.csv;

import java.io.File;

import outputModules.CSVASTWalker;
import outputModules.common.Writer;
import outputModules.csv.exporters.CSVFunctionExporter;
import outputModules.parser.Parser;


public abstract class ParserCSVOutput extends Parser
{

	private CSVFunctionExporter functionExporter;

	@Override
	public void initialize()
	{
		Writer.setWriterImpl(new CSVWriterImpl());
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

	}

	@Override
	protected void initializeDirectoryImporter()
	{
		dirTreeImporter = new CSVDirectoryTreeImporter();
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
