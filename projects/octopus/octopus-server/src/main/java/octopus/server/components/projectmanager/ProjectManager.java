package octopus.server.components.projectmanager;

import com.orientechnologies.orient.client.remote.OServerAdmin;
import orientdbimporter.Constants;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

public class ProjectManager
{

	private static Path projectsDir;
	private static Map<String, OctopusProject> nameToProject = new HashMap<String, OctopusProject>();

	public static void setProjectDir(Path newProjectsDir) throws IOException
	{
		if (!newProjectsDir.isAbsolute())
		{
			newProjectsDir = newProjectsDir.toAbsolutePath();
		}
		projectsDir = newProjectsDir.normalize();
		openProjectsDir();
		loadProjects();
	}

	private static void openProjectsDir() throws IOException
	{
		if (Files.notExists(projectsDir))
		{
			Files.createDirectories(projectsDir);
		}
	}

	private static void loadProjects() throws IOException
	{
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(projectsDir))
		{
			for (Path path : stream)
			{
				if (Files.isDirectory(path))
				{
					loadProject(path);
				}
			}
		}
	}

	private static void loadProject(Path projectDir) throws IOException
	{
		String projectName = projectDir.getFileName().toString();
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

	public static Path getPathToProject(String name)
	{
		if (projectsDir == null)
			throw new IllegalStateException("Error: projectDir not set");

		return Paths.get(projectsDir.toString(), name);
	}

	public static void create(String name) throws IOException
	{
		if (projectsDir == null)
			throw new IllegalStateException("Error: projectDir not set");

		if (doesProjectExist(name))
			throw new RuntimeException("Project already exists");

		OctopusProject project = createOctopusProjectForName(name);
		nameToProject.put(name, project);
	}

	public static void delete(String name) throws IOException
	{
		if (projectsDir == null)
			throw new IllegalStateException("Error: projectDir not set");

		deleteProjectWithName(name);
	}

	public static Iterable<String> listProjects()
	{
		return nameToProject.keySet();
	}

	private static OctopusProject createOctopusProjectForName(String name) throws IOException
	{
		Path pathToProject = getPathToProject(name);
		Files.createDirectories(pathToProject);

		OctopusProject newProject = new OctopusProject(pathToProject.toString(), name);
		return newProject;
	}

	private static void deleteProjectWithName(String name) throws IOException
	{
		removeDatabaseIfExists(name);
		deleteProjectFiles(name);
		nameToProject.remove(name);
	}

	private static void deleteProjectFiles(String name) throws IOException
	{
		Path pathToProject = getPathToProject(name);
		Files.walkFileTree(pathToProject, new SimpleFileVisitor<Path>()
		{
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
			{
				Files.delete(file);
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException
			{
				Files.delete(dir);
				return FileVisitResult.CONTINUE;
			}
		});
	}

	private static void removeDatabaseIfExists(String dbName) throws IOException
	{
		OServerAdmin admin;
		admin = new OServerAdmin("localhost/" + dbName).connect(
				Constants.DB_USERNAME, Constants.DB_PASSWORD);
		if (admin.existsDatabase())
		{
			admin.dropDatabase("plocal");
		}
	}

}
