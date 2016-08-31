package octopus.api.projects;

import java.io.IOException;
import java.nio.file.Paths;

import octopus.api.database.Database;
import octopus.server.database.titan.TitanLocalDatabaseManager;

public class OctopusProject
{

	private final String pathToProjectDir;
	private String name;

	public OctopusProject(String name, String pathToProjectDir) throws IOException
	{
		this.pathToProjectDir = pathToProjectDir;
		this.name = name;
	}

	public String getPathToProjectDir()
	{
		return pathToProjectDir;
	}

	public String getName()
	{
		return name;
	}

	public String getDBConfigFile()
	{
		return Paths.get(pathToProjectDir, "db").toAbsolutePath().toString();
	}

	public Database getNewDatabaseInstance()
	{
		return new TitanLocalDatabaseManager().getDatabaseInstanceForProject(this);
	}

}
