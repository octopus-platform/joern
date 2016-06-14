package octopus.lib.connectors;

import octopus.lib.OctopusProjectWrapper;
import octopus.server.components.projectmanager.OctopusProject;
import octopus.server.components.projectmanager.ProjectManager;

public abstract class OctopusProjectConnector {

	OctopusProjectWrapper wrapper;

	public void connect(String projectName)
	{
		wrapper = openProject(projectName);
	}

	protected OctopusProjectWrapper openProject(String projectName)
	{
		OctopusProject oProject = ProjectManager.getProjectByName(projectName);
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
