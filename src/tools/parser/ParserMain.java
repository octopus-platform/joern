package tools.parser;

import java.io.IOException;

import org.apache.commons.cli.ParseException;

import outputModules.csv.ParserCSVOutput;
import outputModules.neo4j.ParserNeo4JOutput;
import fileWalker.OrderedWalker;
import fileWalker.SourceFileWalker;

/**
 * Main Class for the parser: This class processes command line arguments and
 * configures the parser in accordance. It then uses a SourceFileWalker to visit
 * source-files and directories and report them to the parser.
 * */

public class ParserMain
{

	private static ImporterCmdLineInterface cmd = new ImporterCmdLineInterface();
	// private static SourceFileWalker sourceFileWalker = new UnorderedWalker();
	private static SourceFileWalker sourceFileWalker = new OrderedWalker();

	private static Parser indexer;

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
		}
		catch (RuntimeException | ParseException ex)
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
			indexer = new ParserNeo4JOutput();
		else if (outputFormat.equals("csv"))
			indexer = new ParserCSVOutput();
		else
			throw new RuntimeException("unknown output format");

		String outputDir = cmd.getOutputDir();
		indexer.setOutputDir(outputDir);
		indexer.initialize();
		sourceFileWalker.addListener(indexer);
	}

	private static void walkCodebase(String[] fileAndDirNames)
	{
		try
		{
			sourceFileWalker.walk(fileAndDirNames);
		}
		catch (IOException err)
		{
			System.err.println("Error walking source files: "
					+ err.getMessage());
		}
		finally
		{
			indexer.shutdown();
		}
	}
}
