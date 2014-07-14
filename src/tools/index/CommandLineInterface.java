package tools.index;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.ParseException;

import tools.CommonCommandLineInterface;

public class CommandLineInterface extends CommonCommandLineInterface
{

	private String[] filenames;

	String outputDir = ".joernIndex/";

	public String[] getFilenames()
	{
		return filenames;
	}

	public String getOutputDir()
	{
		return outputDir;
	}

	public CommandLineInterface()
	{
		super();
	}

	@Override
	protected void initializeOptions()
	{
		super.initializeOptions();

		Option outputDirectory = OptionBuilder
				.withArgName("outdir")
				.hasArg()
				.withDescription(
						"specifies where the neo4j database will be written")
				.create("outdir");

		options.addOption(outputDirectory);

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
	}

	public void printHelp()
	{
		formater.printHelp("joern [SOURCE_DIR1] ...", options);
	}

}
