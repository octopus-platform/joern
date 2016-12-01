package octopus.server.restServer.handlers;

import octopus.api.projects.ProjectManager;
import octopus.server.restServer.OctopusRestHandler;
import spark.Request;
import spark.Response;

public class ListProjectsHandler implements OctopusRestHandler {

	@Override
	public Object handle(Request req, Response resp)
	{
		Iterable<String> projects = (new ProjectManager()).listProjects();

		StringBuilder sb = new StringBuilder();
		for (String name : projects)
		{
			sb.append(name);
			sb.append('\n');
		}
		return sb.toString();
	}

}
