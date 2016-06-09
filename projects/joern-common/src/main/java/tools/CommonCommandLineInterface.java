package tools;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

public class CommonCommandLineInterface
{
	public CommonCommandLineInterface()
	{
		initializeOptions();
	}

	protected void initializeOptions()
	{
	}

	protected Options options = new Options();
	protected CommandLineParser parser = new BasicParser();
	protected HelpFormatter formatter = new HelpFormatter();
	protected CommandLine cmd = null;

}
