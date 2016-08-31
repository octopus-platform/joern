package tools.parser;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.ParseException;

import tools.CommonCommandLineInterface;

public class ParserCmdLineInterface extends CommonCommandLineInterface
{

	private String[] filenames;

	String outputDir = ".joernIndex/";
	String outputFormat = "neo4j";

	public String[] getFilenames()
	{
		return filenames;
	}

	public String getOutputDir()
	{
		return outputDir;
	}

	public String getOutputFormat()
	{
		return outputFormat;
	}

	public ParserCmdLineInterface()
	{
		super();
	}

	@Override
	protected void initializeOptions()
	{
		super.initializeOptions();

		Option outputDirectory = OptionBuilder.withArgName("outdir").hasArg()
				.withDescription("the directory the output will be written to")
				.create("outdir");

		Option outputFormat = OptionBuilder.withArgName("outformat").hasArg()
				.withDescription("the output format: \"neo4j\" or \"csv\" ")
				.create("outformat");

		options.addOption(outputDirectory);
		options.addOption(outputFormat);

	}

	public void parseCommandLine(String[] args) throws ParseException
	{
		if (args.length == 0)
			throw new RuntimeException(
					"At least one file needs to be supplied for parsing.");

		cmd = parser.parse(options, args);
		filenames = cmd.getArgs();

		if (cmd.hasOption("outdir"))
			outputDir = cmd.getOptionValue("outdir");

		if (cmd.hasOption("outformat"))
			outputFormat = cmd.getOptionValue("outformat");

	}

	public void printHelp()
	{
		formatter.printHelp("joern [SOURCE_DIR1] ...", options);
	}

}
