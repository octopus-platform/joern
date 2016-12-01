package joern.api.connectors;

import joern.api.JoernProject;
import octopus.api.plugin.connectors.OctopusProjectConnector;
import octopus.api.projects.OctopusProject;
import octopus.api.projects.OctopusProjectWrapper;

public class JoernProjectConnector extends OctopusProjectConnector {

	@Override
	protected OctopusProjectWrapper wrapNewProject(OctopusProject oProject)
	{
		JoernProject project = new JoernProject();
		project.setWrappedProject(oProject);
		return project;
	}

}
