package octopus.lib.plugintypes;

import java.io.IOException;

import org.json.JSONObject;

import com.orientechnologies.orient.client.remote.OServerAdmin;

import octopus.lib.connectors.OctopusProjectConnector;
import octopus.server.components.pluginInterface.Plugin;
import orientdbimporter.Constants;

public class OctopusProjectPlugin extends Plugin {

	private OctopusProjectConnector projectConnector;

	protected void setProjectConnector(OctopusProjectConnector connector)
	{
		this.projectConnector = connector;
	}

	@Override
	public void configure(JSONObject settings)
	{
		String projectName = settings.getString("projectName");
		getBjoernProjectConnector().connect(projectName);
	}

	protected void raiseIfDatabaseForProjectExists()
	{
		String dbName = getBjoernProjectConnector().getWrapper().getDatabaseName();

		boolean databaseExists = doesDatabaseExist(dbName);
		if(databaseExists)
			throw new RuntimeException("Database already exists. Skipping.");
	}

	private boolean doesDatabaseExist(String dbName)
	{
		try {
			return new OServerAdmin("localhost/" + dbName).connect(
					Constants.DB_USERNAME, Constants.DB_PASSWORD).existsDatabase();

		} catch (IOException e) {
			throw new RuntimeException("Error determining whether database exists");
		}
	}

	protected OctopusProjectConnector getBjoernProjectConnector() {
		return projectConnector;
	}

	protected void setBjoernProjectConnector(OctopusProjectConnector bjoernProjectConnector) {
		this.projectConnector = bjoernProjectConnector;
	}


}
