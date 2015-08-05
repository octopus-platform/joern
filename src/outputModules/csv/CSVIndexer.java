package outputModules.csv;

import tools.index.Indexer;

public class CSVIndexer extends Indexer
{
	@Override
	protected void initializeDatabase()
	{
		// Add any code you need to setup the database
	}

	@Override
	protected void shutdownDatabase()
	{
		// Add code to shutdown the database
	}
	
	@Override
	protected void initializeDirectoryImporter()
	{
		dirTreeImporter = new CSVDirectoryTreeImporter();
	}
	
	@Override
	protected void initializeWalker()
	{
		astWalker = new CSVASTWalker();
	}

	

}

