package tools.parser;

import databaseNodes.FileDatabaseNode;

/**
 * ParserState allows importers to share information, e.g., the
 * Function-importer may need to know the current file node id from the File
 * importer.
 * */

public class ParserState
{

	protected Parser indexer;
	private FileDatabaseNode currentFileNode;

	public ParserState(Parser anIndexer)
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
