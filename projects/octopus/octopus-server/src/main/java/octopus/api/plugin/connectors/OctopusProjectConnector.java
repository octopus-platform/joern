package octopus.api.plugin.connectors;

import octopus.api.projects.OctopusProject;
import octopus.api.projects.OctopusProjectWrapper;
import octopus.server.projectmanager.OctopusProjectManager;

public abstract class OctopusProjectConnector {

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

	protected abstract OctopusProjectWrapper wrapNewProject(OctopusProject oProject);

	public void disconnect()
	{
		// TODO Auto-generated method stub
	}

	public OctopusProjectWrapper getWrapper()
	{
		return wrapper;
	}


}
