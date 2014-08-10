package tools.index;

import databaseNodes.FileDatabaseNode;

/**
 * IndexerState allows importers to share information, e.g., the
 * Function-importer may need to know the current file node id from the File
 * importer.
 * */

public class IndexerState
{

	protected Indexer indexer;
	private FileDatabaseNode currentFileNode;
	
	public IndexerState(Indexer anIndexer)
	{
		indexer = anIndexer;
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
