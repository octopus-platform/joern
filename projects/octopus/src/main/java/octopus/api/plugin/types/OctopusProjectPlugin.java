package octopus.api.plugin.types;

import org.json.JSONObject;

import octopus.api.plugin.Plugin;
import octopus.api.plugin.connectors.OctopusProjectConnector;
import octopus.api.projects.OctopusProjectWrapper;

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
		OctopusProjectWrapper wrapper = projectConnector.getWrapper();

		return projectConnector;
	}

}
