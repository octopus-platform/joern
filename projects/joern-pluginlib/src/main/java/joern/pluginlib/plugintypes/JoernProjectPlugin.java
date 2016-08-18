package joern.pluginlib.plugintypes;

import joern.pluginlib.connectors.JoernProjectConnector;
import octopus.api.plugin.types.OctopusProjectPlugin;

public class JoernProjectPlugin extends OctopusProjectPlugin {

	public JoernProjectPlugin()
	{
		setProjectConnector(new JoernProjectConnector());
	}

	@Override
	public void execute() throws Exception
	{

	}
}
