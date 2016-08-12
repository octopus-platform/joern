package octopus.lib.database;

import java.io.IOException;

import octopus.lib.projects.OctopusProject;

public interface DatabaseManager {

	public Database loadOrCreateForProject(OctopusProject project) throws IOException;
	public void deleteDatabase(Database database);

}
