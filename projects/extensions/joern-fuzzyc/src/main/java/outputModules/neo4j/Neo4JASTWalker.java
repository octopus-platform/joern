package outputModules.neo4j;

import outputModules.parser.ParserASTWalker;

public class Neo4JASTWalker extends ParserASTWalker
{
	Neo4JASTWalker()
	{
		astVisitor = new Neo4JASTNodeVisitor();
	}
}
