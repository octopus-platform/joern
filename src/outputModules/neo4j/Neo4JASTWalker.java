package outputModules.neo4j;

import tools.parser.ParserASTWalker;


public class Neo4JASTWalker extends ParserASTWalker
{	
	Neo4JASTWalker()
	{
		astVisitor = new Neo4JASTNodeVisitor();
	}
}
