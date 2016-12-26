package outputModules.dummy;

import tools.index.IndexerASTWalker;

public class DummyASTWalker extends IndexerASTWalker
{
	DummyASTWalker()
	{
		astVisitor = new DummyASTNodeVisitor();
	}
}
