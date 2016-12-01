package outputModules.csv;

import java.io.File;
import java.util.Map;

import databaseNodes.FileDatabaseNode;
import outputModules.common.DirectoryTreeImporter;
import outputModules.common.Writer;

public class MultiDirCSVDirectoryTreeImporter extends DirectoryTreeImporter
{

	@Override
	protected void insertNode(FileDatabaseNode node)
	{
		String dirNameForFileNode = genDirNameForFileNode(node);
		createDirForFileNode(dirNameForFileNode);
		Writer.changeOutputDir(dirNameForFileNode);
		Writer.reset();

		Map<String, Object> properties = node.createProperties();
		long nodeId = Writer.addNode(node, properties);
		node.setId(nodeId);
	}

	private void createDirForFileNode(String dirNameForFileNode)
	{
		File file = new File(dirNameForFileNode);
		file.mkdirs();
	}

	private String genDirNameForFileNode(FileDatabaseNode node)
	{
		String pathInSourceTree = node.getPath();
		String outPathForFile = outputDir + File.separator + pathInSourceTree;
		return outPathForFile;
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
