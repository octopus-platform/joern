package octopus.lib.connectors;

import octopus.lib.projects.OctopusProject;
import octopus.lib.projects.OctopusProjectWrapper;
import octopus.server.components.projectmanager.OctopusProjectManager;

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

		return createNewProject(oProject);
	}

	protected abstract OctopusProjectWrapper createNewProject(OctopusProject oProject);

	public void disconnect()
	{
		// TODO Auto-generated method stub
	}

	public OctopusProjectWrapper getWrapper()
	{
		return wrapper;
	}


}
