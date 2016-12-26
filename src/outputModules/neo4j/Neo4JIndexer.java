package outputModules.neo4j;

import java.util.Map;

import neo4j.batchInserter.ConfigurationGenerator;
import neo4j.batchInserter.Neo4JBatchInserter;
import tools.index.Indexer;


public class Neo4JIndexer extends Indexer
{

	@Override
	protected void initializeWalker()
	{
		astWalker = new Neo4JASTWalker();
	}

	@Override
	protected void initializeDirectoryImporter()
	{
		dirTreeImporter = new Neo4JDirectoryTreeImporter();
	}

	@Override
	protected void initializeDatabase()
	{
		Neo4JBatchInserter.setIndexDirectoryName(outputDir);
		Map<String, String> config = ConfigurationGenerator
				.generateConfiguration();
		Neo4JBatchInserter.setBatchInserterConfig(config);
		Neo4JBatchInserter.openDatabase();
	}

	@Override
	protected void shutdownDatabase()
	{
		Neo4JBatchInserter.closeDatabase();
	}

}
