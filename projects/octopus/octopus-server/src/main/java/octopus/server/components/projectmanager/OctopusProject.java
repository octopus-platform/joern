package octopus.server.components.projectmanager;

public class OctopusProject {

	private String pathToProjectDir;
	private String databaseName;

	public String getPathToProjectDir()
	{
		return pathToProjectDir;
	}

	public void setPathToProjectDir(String pathToProjectDir)
	{
		this.pathToProjectDir = pathToProjectDir;
	}

	public String getDatabaseName()
	{
		return databaseName;
	}

	public void setDatabaseName(String databaseName)
	{
		this.databaseName = databaseName;
	}


}
