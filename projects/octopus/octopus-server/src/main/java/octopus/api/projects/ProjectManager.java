package octopus.api.projects;

import java.io.IOException;

import octopus.server.projectmanager.OctopusProjectManager;

public class ProjectManager {

	public void create(String projectName)
	{
		try {
			OctopusProjectManager.create(projectName);
		} catch (IOException e) {
			throw new RuntimeException("Error creating project");
		}
	}

	public boolean doesProjectExist(String projectName)
	{
		return OctopusProjectManager.doesProjectExist(projectName);
	}

	public void delete(String projectName)
	{
		try {
			OctopusProjectManager.delete(projectName);
		} catch (IOException e) {
			throw new RuntimeException("Error deleting project");
		}
	}

	public Iterable<String> listProjects()
	{
		return OctopusProjectManager.listProjects();
	}

	public OctopusProject getProjectByName(String name)
	{
		return OctopusProjectManager.getProjectByName(name);
	}

}
