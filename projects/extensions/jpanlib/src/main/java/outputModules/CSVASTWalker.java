package outputModules;

import outputModules.csv.CSVASTNodeVisitor;
import outputModules.csv.exporters.CSVFunctionExporter;
import outputModules.parser.ParserASTWalker;

public class CSVASTWalker extends ParserASTWalker
{
	public CSVASTWalker(CSVFunctionExporter functionExporter)
	{
		astVisitor = new CSVASTNodeVisitor();
		((CSVASTNodeVisitor) astVisitor).setFunctionExporter(functionExporter);
	}
}
