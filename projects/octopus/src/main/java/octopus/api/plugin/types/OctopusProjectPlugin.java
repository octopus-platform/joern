package octopus.api.plugin.types;

import org.json.JSONObject;

import octopus.api.plugin.Plugin;
import octopus.api.plugin.connectors.OctopusProjectConnector;

/**
 * A plugin that is associated with an Octopus Project.
 *
 **/

public abstract class OctopusProjectPlugin implements Plugin
{

	private OctopusProjectConnector projectConnector;

	public OctopusProjectPlugin()
	{
		setProjectConnector(new OctopusProjectConnector());
	}

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

	protected String getProjectName()
	{
		return projectConnector.getWrapper().getName();
	}

	protected String getPathToProjectDir()
	{
		return projectConnector.getWrapper().getPathToProjectDir();
	}

}
