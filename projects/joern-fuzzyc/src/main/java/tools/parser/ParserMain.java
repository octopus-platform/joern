package tools.parser;

import java.io.IOException;

import org.apache.commons.cli.ParseException;

import fileWalker.OrderedWalker;
import fileWalker.SourceFileWalker;
import outputModules.parser.Parser;

/**
 * Main Class for the parser: This class processes command line arguments and
 * configures the parser in accordance. It then uses a SourceFileWalker to visit
 * source-files and directories and report them to the parser.
 */

public class ParserMain
{

	private static ParserCmdLineInterface cmd = new ParserCmdLineInterface();
	private static SourceFileWalker sourceFileWalker = new OrderedWalker();

	private static Parser parser;

	public static void main(String[] args)
	{
		parseCommandLine(args);
		String[] fileAndDirNames = getFileAndDirNamesFromCommandLine();
		setupIndexer();
		walkCodebase(fileAndDirNames);
	}

	private static void parseCommandLine(String[] args)
	{
		try
		{
			cmd.parseCommandLine(args);
		} catch (RuntimeException | ParseException ex)
		{
			printHelpAndTerminate(ex);
		}
	}

	private static void printHelpAndTerminate(Exception ex)
	{
		System.err.println(ex.getMessage());
		cmd.printHelp();
		System.exit(1);
	}

	private static String[] getFileAndDirNamesFromCommandLine()
	{
		return cmd.getFilenames();
	}

	private static void setupIndexer()
	{

		String outputFormat = cmd.getOutputFormat();
		if (outputFormat.equals("neo4j"))
			parser = new CParserNeo4JOuput();
		else if (outputFormat.equals("csv"))
			parser = new CParserCSVOutput();
		else
			throw new RuntimeException("unknown output format");

		String outputDir = cmd.getOutputDir();
		parser.setOutputDir(outputDir);
		parser.initialize();
		sourceFileWalker.addListener(parser);
	}

	private static void walkCodebase(String[] fileAndDirNames)
	{
		try
		{
			sourceFileWalker.walk(fileAndDirNames);
		} catch (IOException err)
		{
			System.err
					.println("Error walking source files: " + err.getMessage());
		} finally
		{
			parser.shutdown();
		}
	}
}
