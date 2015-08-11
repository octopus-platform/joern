package outputModules.csv;

import tools.parser.ParserASTWalker;

public class CSVASTWalker extends ParserASTWalker
{
	CSVASTWalker()
	{
		astVisitor = new CSVASTNodeVisitor();
	}
}
