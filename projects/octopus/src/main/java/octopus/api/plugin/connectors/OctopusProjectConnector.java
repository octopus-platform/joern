package octopus.api.plugin.connectors;

import octopus.api.OctopusPlainProject;
import octopus.api.projects.OctopusProject;
import octopus.api.projects.OctopusProjectWrapper;
import octopus.server.projectmanager.OctopusProjectManager;

public class OctopusProjectConnector {

	OctopusProjectWrapper wrapper;

	public void connect(String projectName)
	{
		wrapper = openProject(projectName);
	}

	protected OctopusProjectWrapper openProject(String projectName)
	{
		OctopusProject oProject = OctopusProjectManager.getProjectByName(projectName);
		if(oProject == null)
			throw new RuntimeException("Error: project does not exist");

		return wrapNewProject(oProject);
	}

	protected OctopusProjectWrapper wrapNewProject(OctopusProject oProject)
	{
		OctopusPlainProject project = new OctopusPlainProject();
        project.setWrappedProject(oProject);
        return project;

	}

	public void disconnect()
	{
		// TODO Auto-generated method stub
	}

	public OctopusProjectWrapper getWrapper()
	{
		return wrapper;
	}


}
