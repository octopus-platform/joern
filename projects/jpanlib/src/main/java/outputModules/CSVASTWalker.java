package outputModules;

import outputModules.csv.CSVASTNodeVisitor;
import outputModules.parser.ParserASTWalker;

public class CSVASTWalker extends ParserASTWalker
{
	public CSVASTWalker()
	{
		astVisitor = new CSVASTNodeVisitor();
	}
}
