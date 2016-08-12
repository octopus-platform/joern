package octopus.api.plugintypes;

import org.json.JSONObject;

import octopus.api.connectors.OctopusProjectConnector;
import octopus.server.components.pluginInterface.Plugin;

public abstract class OctopusProjectPlugin implements Plugin
{

	private OctopusProjectConnector projectConnector;

	protected void setProjectConnector(OctopusProjectConnector connector)
	{
		this.projectConnector = connector;
	}

	@Override
	public void configure(JSONObject settings)
	{
		String projectName = settings.getString("projectName");
		getProjectConnector().connect(projectName);
	}

	protected OctopusProjectConnector getProjectConnector()
	{
		return projectConnector;
	}

}
