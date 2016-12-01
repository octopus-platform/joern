package octopus.server.restServer.handlers;

import octopus.api.projects.ProjectManager;
import octopus.server.restServer.OctopusRestHandler;
import spark.Request;
import spark.Response;

public class DeleteProjectHandler implements OctopusRestHandler {

	@Override
	public Object handle(Request req, Response resp)
	{
		String projectName = req.params(":projectName");
		ProjectManager manager = new ProjectManager();
		if(!manager.doesProjectExist(projectName))
			return "Project does not exist.";
		manager.delete(projectName);
		return "Project deleted.";
	}

}
