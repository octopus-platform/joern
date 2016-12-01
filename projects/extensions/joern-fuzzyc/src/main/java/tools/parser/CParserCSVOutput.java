package tools.parser;

import java.nio.file.Path;

import outputModules.csv.ParserCSVOutput;
import outputModules.csv.exporters.CCSVFunctionExporter;
import parsing.ModuleParser;
import parsing.Modules.ANTLRCModuleParserDriver;

public class CParserCSVOutput extends ParserCSVOutput {

	ANTLRCModuleParserDriver driver = new ANTLRCModuleParserDriver();
	ModuleParser parser = new ModuleParser(driver);

	@Override
	public void visitFile(Path pathToFile)
	{
		dirTreeImporter.enterFile(pathToFile);
		parser.parseFile(pathToFile.toString());
	}

	@Override
	public void initialize()
	{
		this.setFunctionExporter(new CCSVFunctionExporter());
		super.initialize();
		parser.addObserver(astWalker);
	}

}
