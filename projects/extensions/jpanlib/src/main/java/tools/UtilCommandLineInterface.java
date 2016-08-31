package tools;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.ParseException;

public class UtilCommandLineInterface extends CommonCommandLineInterface
{

	String dbDir = ".joernIndex";

	public String getDatabaseDir()
	{
		return dbDir;
	}

	public UtilCommandLineInterface()
	{
		super();
	}

	@Override
	protected void initializeOptions()
	{
		super.initializeOptions();

		Option outputDirectory = OptionBuilder.withArgName("dbdir").hasArg()
				.withDescription("specifies the database directory")
				.create("dbdir");

		options.addOption(outputDirectory);

	}

	public void parseCommandLine(String[] args) throws ParseException
	{
		cmd = parser.parse(options, args);

		if (cmd.hasOption("dbdir"))
			dbDir = cmd.getOptionValue("dbdir");
	}

}
