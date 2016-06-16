package joern.plugins.importer;

import java.io.IOException;

import fileWalker.OrderedWalker;
import fileWalker.SourceFileWalker;
import outputModules.parser.Parser;
import tools.parser.CParserCSVOutput;

public class CParserWrapper {

	private static SourceFileWalker sourceFileWalker = new OrderedWalker();
	private static Parser parser = new CParserCSVOutput();

	public void initialize(String outputDir)
	{
		parser.setOutputDir(outputDir);
		parser.initialize();
		sourceFileWalker.addListener(parser);
	}

	public void walkCodebase(String[] fileAndDirNames)
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
