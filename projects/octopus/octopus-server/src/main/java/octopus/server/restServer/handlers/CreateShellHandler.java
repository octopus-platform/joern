package octopus.server.restServer.handlers;

import java.io.IOException;

import octopus.lib.ShellManager;
import octopus.server.restServer.OctopusRestHandler;
import spark.Request;
import spark.Response;

public class CreateShellHandler implements OctopusRestHandler {

	String projectName;
	String shellName = "(shell)";

	@Override
	public Object handle(Request req, Response resp) {

		extractParameters(req);
		int port = createNewShell();
		return String.format("%d\n", port);
	}

	private void extractParameters(Request req)
	{
		projectName = req.params(":projectName");
		String[] splat = req.splat();

		if(splat.length > 0)
			shellName = splat[0];
	}

	private int createNewShell()
	{
		int port;
		try {
			port = (new ShellManager()).createNewShellThread(projectName, shellName);
		} catch (IOException e) {
			throw new RuntimeException("Error creating new shell thread");
		}
		return port;
	}

}
