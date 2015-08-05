package outputModules.csv;

import tools.index.IndexerASTWalker;

public class CSVASTWalker extends IndexerASTWalker
{
	CSVASTWalker()
	{
		astVisitor = new CSVASTNodeVisitor();
	}
}
