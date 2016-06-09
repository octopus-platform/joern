package outputModules.dummy;

import tools.parser.ParserASTWalker;

public class DummyASTWalker extends ParserASTWalker
{
	DummyASTWalker()
	{
		astVisitor = new DummyASTNodeVisitor();
	}
}
