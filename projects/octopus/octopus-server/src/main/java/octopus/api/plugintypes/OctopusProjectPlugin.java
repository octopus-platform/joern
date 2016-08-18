package octopus.api.plugintypes;

import org.json.JSONObject;

import octopus.api.connectors.OctopusProjectConnector;
import octopus.server.components.pluginInterface.Plugin;

/**
 * A plugin that is associated with an Octopus Project.
 *
 **/

public abstract class OctopusProjectPlugin implements Plugin
{

	private OctopusProjectConnector projectConnector;

	@Override
	public void configure(JSONObject settings)
	{
		String projectName = settings.getString("projectName");
		getProjectConnector().connect(projectName);
	}

	protected void setProjectConnector(OctopusProjectConnector connector)
	{
		this.projectConnector = connector;
	}

	protected OctopusProjectConnector getProjectConnector()
	{
		return projectConnector;
	}

}
