package outputModules.csv;

import outputModules.neo4j.importers.DirectoryTreeImporter;
import databaseNodes.FileDatabaseNode;

public class CSVDirectoryTreeImporter extends DirectoryTreeImporter
{

	@Override
	protected void insertNode(FileDatabaseNode node)
	{
		createDirForFileNode(node);
	}

	private void createDirForFileNode(FileDatabaseNode node)
	{
		System.out.println(outputDir);
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
