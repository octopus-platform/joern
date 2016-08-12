package octopus.api.database;

import java.io.IOException;

import octopus.api.projects.OctopusProject;

public interface DatabaseManager {

	public Database loadOrCreateForProject(OctopusProject project) throws IOException;
	public void deleteDatabase(Database database);

}
