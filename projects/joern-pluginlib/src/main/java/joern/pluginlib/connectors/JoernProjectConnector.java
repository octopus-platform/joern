package joern.pluginlib.connectors;

import joern.pluginlib.JoernProject;
import octopus.lib.OctopusProjectWrapper;
import octopus.lib.connectors.OctopusProjectConnector;
import octopus.server.components.projectmanager.OctopusProject;

public class JoernProjectConnector extends OctopusProjectConnector {

	@Override
	protected OctopusProjectWrapper createNewProject(OctopusProject oProject)
	{
		JoernProject project = new JoernProject();
		project.setWrappedProject(oProject);
		return project;
	}

}
