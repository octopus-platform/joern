package octopus.lib.plugintypes;

import org.json.JSONObject;

import octopus.lib.connectors.OrientDBConnector;
import octopus.server.components.pluginInterface.Plugin;

public abstract class OrientGraphConnectionPlugin extends Plugin
{
	private String databaseName;
	protected OrientDBConnector orientConnector = new OrientDBConnector();

	@Override
	public void configure(JSONObject settings)
	{
		databaseName = settings.getString("database");
	}

	@Override
	public void beforeExecution() throws Exception
	{
		orientConnector.connect(databaseName);
	}

	@Override
	public void afterExecution() throws Exception
	{
		orientConnector.disconnect();
	}


	public String getDatabaseName()
	{
		return databaseName;
	}

}

