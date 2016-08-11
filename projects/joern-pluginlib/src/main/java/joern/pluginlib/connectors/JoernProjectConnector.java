package joern.pluginlib.connectors;

import joern.pluginlib.JoernProject;
import octopus.lib.connectors.OctopusProjectConnector;
import octopus.lib.projects.OctopusProject;
import octopus.lib.projects.OctopusProjectWrapper;

public class JoernProjectConnector extends OctopusProjectConnector {

	@Override
	protected OctopusProjectWrapper createNewProject(OctopusProject oProject)
	{
		JoernProject project = new JoernProject();
		project.setWrappedProject(oProject);
		return project;
	}

}
