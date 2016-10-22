package octopus.server.gremlinShell;

import groovy.lang.Closure;
import groovy.lang.GroovyShell;
import octopus.OctopusEnvironment;
import octopus.api.database.Database;
import octopus.api.projects.OctopusProject;
import octopus.api.projects.ProjectManager;
import octopus.server.gremlinShell.fileWalker.OrderedWalker;
import octopus.server.gremlinShell.fileWalker.SourceFileWalker;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Graph;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;

public class OctopusGremlinShell
{

	private GroovyShell shell;
	private int port;
	Database database;
	private String name;
	private boolean occupied = false;
	private Graph graph;
	private String projectName;
	private GraphTraversalSource g;

	static
	{

	}

	public OctopusGremlinShell(String projectName)
	{
		this.projectName = projectName;
	}

	private void octopusSugarLoad()
	{
		String cmd = "GremlinLoader.load();";
		execute(cmd);

		// This is the code responsible for the execution of session steps
		cmd = "DefaultGraphTraversal.metaClass.methodMissing = { final String name, final def args -> def closure = getStep(name); if (closure != null) { closure.delegate = delegate; return closure(args); } else { throw new MissingMethodException(name, this.class, args) } }";
		execute(cmd);
	}

	public void initShell()
	{
		this.shell = new GroovyShell(new OctopusCompilerConfiguration());
		openDatabaseConnection(projectName);
		octopusSugarLoad();
		loadStandardQueryLibrary();
	}

	private void openDatabaseConnection(String projectName)
	{
		OctopusProject project = new ProjectManager().getProjectByName(projectName);
		database = project.getNewDatabaseInstance();
		this.projectName = projectName;

		graph = database.getGraph();
		g = graph.traversal();
		this.shell.setVariable("graph", graph);
		this.shell.setVariable("g", g);
		this.shell.setVariable("sessionSteps", new HashMap<String, Closure>());
	}

	private void loadStandardQueryLibrary()
	{
		try
		{
			Path languagesDir = OctopusEnvironment.LANGUAGES_DIR;
			loadRecursively(languagesDir.toString());
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private void loadRecursively(String languagesDir) throws IOException
	{
		SourceFileWalker walker = new OrderedWalker();
		GroovyFileLoader listener = new GroovyFileLoader();
		listener.setGroovyShell(this.getShell());

		walker.setFilenameFilter("*.groovy");
		walker.addListener(listener);
		walker.walk(new String[]{languagesDir});
	}

	public Object execute(String code)
	{

		try
		{
			return shell.evaluate(code);
		} catch (Exception ex)
		{
			return String.format("[%s] %s\n", ex.getClass().getSimpleName(), ex.getMessage());
		}
	}

	public int getPort()
	{
		return port;
	}

	public void setPort(int port)
	{
		this.port = port;
	}

	public GroovyShell getShell()
	{
		return shell;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return this.name;
	}

	public void markAsOccupied()
	{
		occupied = true;
	}

	public void markAsFree()
	{
		occupied = false;
	}

	public boolean isOccupied()
	{
		return occupied;
	}

	public void shutdownDBInstance()
	{
		database.closeInstance();
	}

	public String getProjectName()
	{
		return projectName;
	}

	public Graph getGraph()
	{
		return graph;
	}

}
