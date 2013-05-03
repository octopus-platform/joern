package tools.retrieve;

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

	private String query;
	private String indexDir;
	
	
	public String getQuery()
	{
		return query;
	}
	
	public String getIndexDir()
	{
		return indexDir;
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
		formater.printHelp("retrieve [OPTION]... <query> <indexDir>", options);
	}

	public void parseCommandLine(String [] args) throws RuntimeException, ParseException
	{
		cmd = parser.parse(options, args);	
		String[] arguments = cmd.getArgs();
		if(arguments.length != 2){
			throw new RuntimeException("Not enough arguments");
		}
	
		query = arguments[0];
		indexDir = arguments[1];
	}
	
}

