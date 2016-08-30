package octopus.api.database;

import java.io.IOException;

import octopus.api.projects.OctopusProject;

public interface DatabaseManager {

	public void initializeDatabaseForProject(OctopusProject project) throws IOException;
	public Database getDatabaseInstanceForProject(OctopusProject project);
	public void deleteDatabaseForProject(OctopusProject project);
	public void resetDatabase(OctopusProject project);

}
