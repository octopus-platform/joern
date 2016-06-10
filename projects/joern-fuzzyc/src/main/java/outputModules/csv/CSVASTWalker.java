package outputModules.csv;

import outputModules.parser.ParserASTWalker;

public class CSVASTWalker extends ParserASTWalker
{
	CSVASTWalker()
	{
		astVisitor = new CSVASTNodeVisitor();
	}
}
