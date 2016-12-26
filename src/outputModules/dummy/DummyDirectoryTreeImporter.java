package outputModules.dummy;

import outputModules.neo4j.importers.DirectoryTreeImporter;
import databaseNodes.FileDatabaseNode;

public class DummyDirectoryTreeImporter extends DirectoryTreeImporter
{

	@Override
	protected void insertNode(FileDatabaseNode node)
	{
		// Add any code required to insert the file node
		// into the database
	}

	@Override
	protected void linkWithParentDirectory(FileDatabaseNode node)
	{
		// Code to connect file node with other file nodes
		// to form a directory hierarchy. You can access the
		// stack of directories traversed to reach this file
		// via the protected member 'directoryStack' of the
		// base class.
	}
	
}
