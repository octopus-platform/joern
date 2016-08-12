package octopus.api.projects;

import java.io.IOException;

import octopus.api.database.Database;
import octopus.api.database.titan.TitanLocalDatabaseManager;

public class OctopusProject
{

	private final String pathToProjectDir;
	private Database database;
	private String name;

	public OctopusProject(String name, String pathToProjectDir) throws IOException
	{
		this.pathToProjectDir = pathToProjectDir;
		this.name = name;

		// TODO: The DatabaseManager to use should be configurable from the outside
		TitanLocalDatabaseManager manager = new TitanLocalDatabaseManager();
		database = manager.loadOrCreateForProject(this);
	}

	public String getPathToProjectDir()
	{
		return pathToProjectDir;
	}

	public Database getDatabase()
	{
		return database;
	}

	public String getName()
	{
		return name;
	}

}
