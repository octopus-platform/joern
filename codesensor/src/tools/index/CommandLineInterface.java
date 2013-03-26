package tools.index;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;


public class CommandLineInterface
{
	private Options options = new Options();
	private CommandLineParser parser = new BasicParser();
	private HelpFormatter formater = new HelpFormatter();
	private CommandLine cmd = null;
	private String [] filenames;
	
	public String [] getFilenames()
	{
		return filenames;
	}
	
	public CommandLineInterface()
	{
		initializeOptions();
	}

	private void initializeOptions()
	{
		Option helpOpt = new Option("h","help", false, "show this help message");
		options.addOption(helpOpt);
	}
	
	public void outputHelp()
	{	
		formater.printHelp("codesensor [OPTION]... [FILE] ...", options);
	}

	public void parseCommandLine(String [] args)
	{
		try {
			cmd = parser.parse(options, args);
			filenames = cmd.getArgs();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
}

