package tools.index;

/**
 * IndexerState allows importers to share information, e.g., the
 * Function-importer may need to know the current file node id from the File
 * importer.
 * */

public class IndexerState
{

	protected Indexer indexer;

	public IndexerState(Indexer anIndexer)
	{
		indexer = anIndexer;
	}

}
