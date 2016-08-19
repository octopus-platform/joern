package octopus.server.gremlinShell;

import java.io.IOException;

import org.apache.tinkerpop.gremlin.groovy.loaders.GremlinLoader;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Graph;

import groovy.lang.GroovyShell;
import octopus.api.database.Database;
import octopus.api.projects.OctopusProject;
import octopus.api.projects.ProjectManager;
import octopus.server.gremlinShell.fileWalker.OrderedWalker;
import octopus.server.gremlinShell.fileWalker.SourceFileWalker;

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
		GremlinLoader.load();
	}

	public OctopusGremlinShell(String projectName)
	{
		this.projectName = projectName;
	}

	private void registerMethodMissingHandler()
	{
		String cmd = "GremlinGroovyPipeline.metaClass.methodMissing =";
		cmd += "{String name, args -> Gremlin.compose(delegate, \"$name\"(args))}";
		execute(cmd);
	}

	public void initShell()
	{
		this.shell = new GroovyShell(new OctopusCompilerConfiguration());
		openDatabaseConnection(projectName);
		loadStandardQueryLibrary();
		registerMethodMissingHandler();
	}

	private void openDatabaseConnection(String projectName)
	{
		OctopusProject project = new ProjectManager().getProjectByName(projectName);
		database =  project.getNewDatabaseInstance();
		this.projectName = projectName;

		graph = database.getGraph();
		g = graph.traversal();
		this.shell.setVariable("graph", graph);
		this.shell.setVariable("g", g);
	}

	private void loadStandardQueryLibrary()
	{
		try
		{
			loadRecursively(System.getProperty("OCTOPUS_HOME") + "/querylib/");
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private void loadRecursively(String queryLibDir) throws IOException
	{
		SourceFileWalker walker = new OrderedWalker();
		GroovyFileLoader listener = new GroovyFileLoader();
		listener.setGroovyShell(this.getShell());

		walker.setFilenameFilter("*.groovy");
		walker.addListener(listener);
		walker.walk(new String[]{queryLibDir});
	}

	public Object execute(String code)
	{
		if (code.equals("querylib_reload"))
		{
			loadStandardQueryLibrary();
			return new String("");
		}

		try
		{
			return shell.evaluate(code);
		} catch (Exception ex)
		{
			return String.format("[%s] %s", ex.getClass().getSimpleName(),
					ex.getMessage());
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

}
