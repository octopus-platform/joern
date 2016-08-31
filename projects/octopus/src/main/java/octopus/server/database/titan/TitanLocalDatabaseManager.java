package octopus.server.database.titan;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;

import com.thinkaurelius.titan.core.schema.Mapping;
import org.apache.commons.io.FileUtils;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.Vertex;

import com.thinkaurelius.titan.core.PropertyKey;
import com.thinkaurelius.titan.core.TitanFactory;
import com.thinkaurelius.titan.core.TitanGraph;
import com.thinkaurelius.titan.core.schema.TitanManagement;
import com.thinkaurelius.titan.core.util.TitanCleanup;

import octopus.api.database.Database;
import octopus.api.database.DatabaseManager;
import octopus.api.projects.OctopusProject;

public class TitanLocalDatabaseManager implements DatabaseManager {

	@Override
	public void initializeDatabaseForProject(OctopusProject project) throws IOException
	{
		String pathToProject = project.getPathToProjectDir();
		String configFilename = createConfigurationFile(pathToProject);
		initializeDatabaseSchema(configFilename);
	}

	private String createConfigurationFile(String pathToProject) throws IOException
	{
		String dbPath = Paths.get(pathToProject, "database").toAbsolutePath().toString();
		String indexPath = Paths.get(pathToProject, "index").toAbsolutePath().toString();
		String dbConfigFile = Paths.get(pathToProject, "db").toAbsolutePath().toString();

		PrintWriter writer;
		writer = new PrintWriter(dbConfigFile, "UTF-8");
		writer.println("storage.backend=berkeleyje");
		writer.println("index.search.backend=lucene");
		writer.println(String.format("storage.directory=%s", dbPath));
		writer.println(String.format("index.search.directory=%s", indexPath));
		writer.close();
		return dbConfigFile;
	}

	private void initializeDatabaseSchema(String configFilename)
	{
		TitanGraph graph = TitanFactory.open(configFilename);
		TitanManagement schema = graph.openManagement();

		PropertyKey extIdKey = schema.makePropertyKey("_key").dataType(String.class).make();
		PropertyKey typeKey = schema.makePropertyKey("type").dataType(String.class).make();

		// At import, we only create separate composite indices for key and type.
		// Additional indices should be built by plugins.

		schema.buildIndex("byKey", Vertex.class).addKey(extIdKey).unique().buildCompositeIndex();
		schema.buildIndex("byType", Vertex.class).addKey(typeKey).buildCompositeIndex();

		// Lucene indices can be built as follows:
		// This would be how to build a STRING index
		PropertyKey codeKey = schema.makePropertyKey("code").dataType(String.class).make();
		schema.buildIndex("byValue", Vertex.class)
				.addKey(codeKey, Mapping.STRING.asParameter()).buildMixedIndex("search");

		// And this is how to build a TEXT index
		// schema.buildIndex("byTypeAndValue", Vertex.class).addKey(typeKey).
		// addKey(valueKey).buildMixedIndex("search");

		schema.commit();
		graph.close();
	}

	@Override
	public Database getDatabaseInstanceForProject(OctopusProject project)
	{
		TitanLocalDatabase database = new TitanLocalDatabase();
		String dbConfigFile = project.getDBConfigFile();
		TitanGraph graph = TitanFactory.open(dbConfigFile);
		database.setGraph(graph);
		return database;
	}

	@Override
	public void deleteDatabaseForProject(OctopusProject project)
	{
		Database database = getDatabaseInstanceForProject(project);
		TitanLocalDatabase titanDatabase = (TitanLocalDatabase) database;
		String dbPathName = titanDatabase.getPathToDatabase();
		String indexPathName = titanDatabase.getPathToIndex();

		try {
			FileUtils.deleteDirectory(new File(dbPathName));
			FileUtils.deleteDirectory(new File(indexPathName));
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			database.closeInstance();
		}

	}

	@Override
	public void resetDatabase(OctopusProject project)
	{
		Database database = getDatabaseInstanceForProject(project);
		Graph graph = database.getGraph();
		try {
			graph.close();
			TitanCleanup.clear((TitanGraph) graph);
			initializeDatabaseForProject(project);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
