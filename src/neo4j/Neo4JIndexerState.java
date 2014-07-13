package neo4j;

import neo4j.nodes.FileDatabaseNode;
import tools.index.Indexer;
import tools.index.IndexerState;

public class Neo4JIndexerState extends IndexerState
{

	private FileDatabaseNode currentFileNode;

	public Neo4JIndexerState(Indexer anIndexer)
	{
		super(anIndexer);
	}

	public void setCurrentFileNode(FileDatabaseNode node)
	{
		currentFileNode = node;
	}

	public FileDatabaseNode getCurrentFileNode()
	{
		return currentFileNode;
	}

}
