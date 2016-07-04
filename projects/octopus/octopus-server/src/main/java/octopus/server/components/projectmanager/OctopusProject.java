package octopus.server.components.projectmanager;

public class OctopusProject
{

	private final String pathToProjectDir;
	private final String databaseName;

	public OctopusProject(String pathToProjectDir, String databaseName)
	{
		this.pathToProjectDir = pathToProjectDir;
		this.databaseName = databaseName;
	}

	public String getPathToProjectDir()
	{
		return pathToProjectDir;
	}

	public String getDatabaseName()
	{
		return databaseName;
	}

}
