package tools.phpast2cfg;

import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.cli.ParseException;

import ast.php.functionDef.PHPFunctionDef;
import cfg.CFG;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import inputModules.csv.csv2ast.CSV2AST;
import inputModules.csv.csvFuncExtractor.CSVFunctionExtractor;
import languages.php.cfg.PHPCFGFactory;
import outputModules.common.Writer;
import outputModules.csv.CSVWriterImpl;

public class Main
{
	static CommandLineInterface cmdLine = new CommandLineInterface();
	static CSV2AST csv2astConverter = new CSV2AST();
	static PHPCFGFactory cfgFactory = new PHPCFGFactory();

	public static void main(String[] args) throws InvalidCSVFile, IOException
	{
		Writer.setWriterImpl(new CSVWriterImpl());

		parseCommandLine(args);

		String nodeFilename = cmdLine.getNodeFile();
		String edgeFilename = cmdLine.getEdgeFile();
		FileReader nodeFileReader = new FileReader(nodeFilename);
		FileReader edgeFileReader = new FileReader(edgeFilename);

		CSVFunctionExtractor extractor = new CSVFunctionExtractor();
		extractor.setLanguage("PHP");
		extractor.initialize(nodeFileReader, edgeFileReader);

		PHPFunctionDef funcAST;
		while ((funcAST = (PHPFunctionDef)extractor.getNextFunction()) != null)
		{
			CFG cfg = cfgFactory.newInstance(funcAST);
			System.out.println(cfg);
		}
	}

	private static void parseCommandLine(String[] args)
	{
		try
		{
			cmdLine.parseCommandLine(args);
		} catch (RuntimeException | ParseException e)
		{
			printHelpAndTerminate(e);
		}
	}

	private static void printHelpAndTerminate(Exception e)
	{
		System.err.println(e.getMessage());
		cmdLine.printHelp();
		System.exit(0);
	}

}
