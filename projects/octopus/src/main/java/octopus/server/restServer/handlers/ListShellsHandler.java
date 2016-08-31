package octopus.server.restServer.handlers;

import octopus.api.shell.ShellManager;
import octopus.server.gremlinShell.OctopusGremlinShell;
import octopus.server.restServer.OctopusRestHandler;
import spark.Request;
import spark.Response;

public class ListShellsHandler implements OctopusRestHandler {

	@Override
	public Object handle(Request req, Response resp)
	{

		ShellManager shellManager = new ShellManager();

		StringBuilder sb = new StringBuilder();
		for (OctopusGremlinShell shell : shellManager.getActiveShells())
		{
			sb.append(rowForShell(shell));
			sb.append('\n');

		}

		return sb.toString();
	}

	private Object rowForShell(OctopusGremlinShell shell)
	{
		return String.format("%d\t%s\t%s\t%s", shell.getPort(), shell.getProjectName()  , shell.getName(), shell.isOccupied());
	}


}
