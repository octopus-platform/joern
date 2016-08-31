package joern.api.plugintypes;

import joern.api.connectors.JoernProjectConnector;
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
