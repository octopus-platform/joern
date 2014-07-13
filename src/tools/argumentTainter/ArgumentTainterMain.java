package tools.argumentTainter;

import org.apache.commons.cli.ParseException;

// Parse command line and hand over to to ArgumentTainter

public class ArgumentTainterMain
{

	static String source = "memset";
	static int taintedArg = 0;
	static String databaseDir;

	static CommandLineInterface cmd = new CommandLineInterface();

	public static void main(String[] args)
	{
		parseCommandLine(args);

		ArgumentTainter argumentTainter = new ArgumentTainter();
		argumentTainter.initialize(databaseDir);

		argumentTainter.setSourceToPatch(source);
		argumentTainter.setArgToPatch(taintedArg);
		argumentTainter.patch();

		argumentTainter.shutdown();

	}

	private static void printHelpAndTerminate(Exception ex)
	{
		System.err.println(ex.getMessage());
		cmd.printHelp();
		System.exit(1);
	}

	private static void parseCommandLine(String[] args)
	{

		try
		{
			cmd.parseCommandLine(args);
		}
		catch (RuntimeException | ParseException ex)
		{
			printHelpAndTerminate(ex);
		}

		if (cmd.getNumberOfArgs() != 2)
			printUsageAndExit();

		source = cmd.getSource();
		taintedArg = cmd.getArgNum();
		databaseDir = cmd.getDatabaseDir();

	}

	private static void printUsageAndExit()
	{
		System.err.println("usage: <sourceFunction> <argument>");
		System.exit(0);
	}

}
