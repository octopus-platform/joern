package outputModules.csv;

import java.util.Map;

import databaseNodes.EdgeTypes;
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
		long srcId = getSourceIdFromStack();
		long dstId = node.getId();
		Writer.addEdge(srcId, dstId, null, EdgeTypes.IS_PARENT_DIR_OF);
	}

}
