package outputModules.csv;

import java.util.Map;

import databaseNodes.FileDatabaseNode;
import outputModules.common.DirectoryTreeImporter;
import outputModules.common.Writer;

public class SingleDirCSVDirectoryTreeImporter extends DirectoryTreeImporter {

	@Override
	protected void insertNode(FileDatabaseNode node) {

		Writer.changeOutputDir(outputDir);
		Writer.reset();

		Map<String, Object> properties = node.createProperties();
		long nodeId = Writer.addNode(node, properties);
		node.setId(nodeId);
	}

	@Override
	protected void linkWithParentDirectory(FileDatabaseNode node) {
		// TODO Auto-generated method stub

	}

}
