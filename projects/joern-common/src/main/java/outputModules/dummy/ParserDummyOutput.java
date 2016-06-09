package outputModules.dummy;

import tools.parser.Parser;

public class ParserDummyOutput extends Parser
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
		dirTreeImporter = new DummyDirectoryTreeImporter();
	}

	@Override
	protected void initializeWalker()
	{
		astWalker = new DummyASTWalker();
	}

}
