package tools.php.ast2cfgddg;

import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.cli.ParseException;

import ast.functionDef.FunctionDef;
import cfg.ASTToCFGConverter;
import cfg.CFG;
import ddg.CFGAndUDGToDefUseCFG;
import ddg.DDGCreator;
import ddg.DataDependenceGraph.DDG;
import ddg.DefUseCFG.DefUseCFG;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import inputModules.csv.csvFuncExtractor.CSVFunctionExtractor;
import languages.php.cfg.PHPCFGFactory;
import outputModules.common.Writer;
import outputModules.csv.CSVWriterImpl;
import outputModules.csv.exporters.CSVCFGExporter;
import outputModules.csv.exporters.CSVDDGExporter;
import udg.CFGToUDGConverter;
import udg.useDefGraph.UseDefGraph;

public class Main
{
	// command line interface
	static CommandLineInterface cmdLine = new CommandLineInterface();

	// converters
	static CSVFunctionExtractor extractor = new CSVFunctionExtractor();
	static PHPCFGFactory cfgFactory = new PHPCFGFactory();
	static CFGToUDGConverter cfgToUDG = new CFGToUDGConverter();
	static CFGAndUDGToDefUseCFG udgAndCfgToDefUseCFG = new CFGAndUDGToDefUseCFG();
	static DDGCreator ddgCreator = new DDGCreator();

	// exporters
	static CSVCFGExporter csvCFGExporter = new CSVCFGExporter();
	static CSVDDGExporter csvDDGExporter = new CSVDDGExporter();

	public static void main(String[] args) throws InvalidCSVFile, IOException
	{
		// parse command line
		parseCommandLine(args);

		// initialize readers
		String nodeFilename = cmdLine.getNodeFile();
		String edgeFilename = cmdLine.getEdgeFile();
		FileReader nodeFileReader = new FileReader(nodeFilename);
		FileReader edgeFileReader = new FileReader(edgeFilename);

		// initialize converters
		extractor.setLanguage("PHP");
		extractor.initialize(nodeFileReader, edgeFileReader);
		cfgToUDG.setLanguage("PHP");
		ASTToCFGConverter ast2cfgConverter = new ASTToCFGConverter();
		ast2cfgConverter.setLanguage("PHP");


		// initialize writers
		CSVWriterImpl csvWriter = new CSVWriterImpl();
		csvWriter.openEdgeFile( ".", "cfg_ddg_edges.csv");
		Writer.setWriterImpl( csvWriter);

		// let's go...
		FunctionDef rootnode;
		while ((rootnode = extractor.getNextFunction()) != null)
		{
			CFG cfg = ast2cfgConverter.convert(rootnode);
			csvCFGExporter.writeCFGEdges(cfg);

			UseDefGraph udg = cfgToUDG.convert(cfg);
			DefUseCFG defUseCFG = udgAndCfgToDefUseCFG.convert(cfg, udg);
			DDG ddg = ddgCreator.createForDefUseCFG(defUseCFG);
			csvDDGExporter.writeDDGEdges(ddg);
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
