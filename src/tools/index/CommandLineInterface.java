package tools.index;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
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
		
	}
	
	public void parseCommandLine(String [] args) throws ParseException
	{
		if(args.length == 0)
			throw new RuntimeException("At least one file needs to be supplied for parsing.");
		
		cmd = parser.parse(options, args);
		filenames = cmd.getArgs();
	
	}
	
	public void outputHelp()
	{	
		formater.printHelp("joern [SOURCE_DIR1] ...", options);
	}

	
	
}

