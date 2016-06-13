package octopus.server.components.gremlinShell;

import groovy.lang.GroovyShell;
import octopus.server.Constants;
import octopus.server.components.gremlinShell.fileWalker.OrderedWalker;
import octopus.server.components.gremlinShell.fileWalker.SourceFileWalker;

import java.io.IOException;

import com.tinkerpop.blueprints.impls.orient.OrientGraphNoTx;
import com.tinkerpop.gremlin.groovy.Gremlin;

public class OctopusGremlinShell
{

	private GroovyShell shell;
	private int port;
	private final String dbName;

	static
	{
		Gremlin.load();
	}

	public OctopusGremlinShell(String dbName)
	{
		this.dbName = dbName;
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
		openDatabaseConnection(dbName);
		loadStandardQueryLibrary();
		registerMethodMissingHandler();
	}

	private void loadStandardQueryLibrary()
	{
		try
		{
			loadRecursively(System.getProperty("OCTOPUS_HOME") + "/querylib/");
		}
		catch (IOException e)
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
		walker.walk(new String[] { queryLibDir });
	}

	private void openDatabaseConnection(String dbName)
	{
		// TODO: We should check whether the database exists

		OrientGraphNoTx g = new OrientGraphNoTx(
				"plocal:" + System.getProperty("ORIENTDB_HOME") + "/databases/" + dbName);
		this.shell.setVariable("g", g);
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
		}
		catch (Exception ex)
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

	public String getDbName()
	{
		return dbName;
	}

	public GroovyShell getShell()
	{
		return shell;
	}
}
