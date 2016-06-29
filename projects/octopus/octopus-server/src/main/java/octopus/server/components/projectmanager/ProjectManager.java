package octopus.server.components.projectmanager;

import com.orientechnologies.orient.client.remote.OServerAdmin;
import org.apache.commons.io.FileUtils;
import orientdbimporter.Constants;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ProjectManager
{

	private static String projectsDir;
	private static Map<String, OctopusProject> nameToProject = new HashMap<String, OctopusProject>();

	public static void setProjectDir(String newProjectsDir) throws IOException
	{
		projectsDir = new File(newProjectsDir).getCanonicalPath();
		openProjectsDir();
		loadProjects();
	}

	private static void openProjectsDir()
	{
		if (Files.notExists(Paths.get(projectsDir)))
		{
			new File(projectsDir).mkdirs();
		}
	}

	private static void loadProjects()
	{
		File projectsDirHandle = new File(projectsDir);
		File[] files = projectsDirHandle.listFiles();
		for (File projectDir : files)
		{
			if (!projectDir.isDirectory())
				continue;
			loadProject(projectDir);
		}
	}

	private static void loadProject(File projectDir)
	{
		String projectName = projectDir.getName();
		OctopusProject newProject = createOctopusProjectForName(projectName);
		nameToProject.put(projectName, newProject);
	}

	public static boolean doesProjectExist(String name)
	{
		return nameToProject.containsKey(name);
	}

	public static OctopusProject getProjectByName(String name)
	{
		return nameToProject.get(name);
	}

	public static String getPathToProject(String name)
	{
		return projectsDir + File.separator + name;
	}

	public static void create(String name)
	{
		if (projectsDir == null)
			throw new RuntimeException("Error: projectDir not set");

		if (doesProjectExist(name))
			throw new RuntimeException("Project already exists");

		OctopusProject project = createOctopusProjectForName(name);
		nameToProject.put(name, project);
	}

	public static void delete(String name)
	{
		if (projectsDir == null)
			throw new RuntimeException("Error: projectDir not set");

		deleteProjectWithName(name);
	}

	public static Iterable<String> listProjects()
	{
		return nameToProject.keySet();

	}

	private static OctopusProject createOctopusProjectForName(String name)
	{
		String pathToProject = getPathToProject(name);
		File dir = new File(pathToProject);
		dir.mkdirs();

		OctopusProject newProject = new OctopusProject();
		newProject.setPathToProjectDir(pathToProject);
		newProject.setDatabaseName(name);
		return newProject;
	}

	private static void deleteProjectWithName(String name)
	{
		File dir = new File(getPathToProject(name));
		try
		{
			FileUtils.deleteDirectory(dir);
			nameToProject.remove(name);
			removeDatabase(name);
		} catch (IOException e)
		{
			throw new RuntimeException("IO Exception on delete");
		}
	}

	private static void removeDatabase(String dbName) throws IOException
	{
		OServerAdmin admin;
		admin = new OServerAdmin("localhost/" + dbName).connect(
				Constants.DB_USERNAME, Constants.DB_PASSWORD);
		admin.dropDatabase("plocal");
	}

}
