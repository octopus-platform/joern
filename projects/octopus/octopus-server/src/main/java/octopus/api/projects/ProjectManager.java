package octopus.api.projects;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import octopus.server.components.projectmanager.OctopusProjectManager;

public class ProjectManager {

	String projectDir;

	public ProjectManager()
	{
		projectDir = System.getProperty("octopus.projectdir");
		Path path = Paths.get(System.getProperty("OCTOPUS_HOME"), projectDir);
		initializeProjectManager(path);
	}

	private void initializeProjectManager(Path path)
	{
		try {
			OctopusProjectManager.initialize(path);
		} catch (IOException e) {
			throw new RuntimeException("Error initializating project manager");
		}
	}

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
