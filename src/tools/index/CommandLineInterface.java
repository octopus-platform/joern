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
	
	public void outputHelp()
	{	
		formater.printHelp("joern [SOURCE_DIR1] ...", options);
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

