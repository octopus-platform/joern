package outputModules.neo4j;

import tools.index.IndexerASTWalker;


public class Neo4JASTWalker extends IndexerASTWalker
{	
	Neo4JASTWalker()
	{
		astVisitor = new Neo4JASTNodeVisitor();
	}
}
