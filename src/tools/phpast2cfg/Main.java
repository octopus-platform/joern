package tools.phpast2cfg;

import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.cli.ParseException;

import ast.functionDef.FunctionDef;
import ast.php.functionDef.PHPFunctionDef;
import cfg.CFG;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import inputModules.csv.csv2ast.CSV2AST;
import inputModules.csv.csvFuncExtractor.CSVFunctionExtractor;
import languages.php.cfg.PHPCFGFactory;
import outputModules.common.Writer;
import outputModules.csv.CSVWriterImpl;
import outputModules.csv.exporters.CSVCFGExporter;

public class Main
{
	static CommandLineInterface cmdLine = new CommandLineInterface();
	static CSV2AST csv2astConverter = new CSV2AST();
	static PHPCFGFactory cfgFactory = new PHPCFGFactory();

	static CSVCFGExporter csvCFGExporter = new CSVCFGExporter();

	public static void main(String[] args) throws InvalidCSVFile, IOException
	{
		CSVWriterImpl csvWriter = new CSVWriterImpl();
		csvWriter.openEdgeFile(".", "cfg_edges.csv");
		Writer.setWriterImpl( csvWriter);

		parseCommandLine(args);

		String nodeFilename = cmdLine.getNodeFile();
		String edgeFilename = cmdLine.getEdgeFile();
		FileReader nodeFileReader = new FileReader(nodeFilename);
		FileReader edgeFileReader = new FileReader(edgeFilename);

		CSVFunctionExtractor extractor = new CSVFunctionExtractor();
		extractor.setLanguage("PHP");
		extractor.initialize(nodeFileReader, edgeFileReader);

		FunctionDef rootnode;
		while ((rootnode = extractor.getNextFunction()) != null)
		{
			// TODO: it is weird that we should pass rootnode.getContent() to the
			// CFG factory. Rather, it would be cleaner to pass rootnode itself.
			// However, if we do this, currently the CFG factory does not return
			// meaningful results.
			CFG cfg = cfgFactory.convert(rootnode.getContent());
			csvCFGExporter.writeCFGEdges(cfg);

		
		}
		
		csvWriter.closeEdgeFile();
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
