package octopus.server.restServer;

import static spark.Spark.exception;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import octopus.server.restServer.handlers.CreateProjectHandler;
import octopus.server.restServer.handlers.CreateShellHandler;
import octopus.server.restServer.handlers.DeleteProjectHandler;
import octopus.server.restServer.handlers.ExecutePluginHandler;
import octopus.server.restServer.handlers.ImportCSVHandler;
import octopus.server.restServer.handlers.ListProjectsHandler;
import octopus.server.restServer.handlers.ListShellsHandler;

public class OctopusRestServer {

	private static final int REST_PORT = 2480;

	public static void start()
	{
		port(REST_PORT);


		post("executeplugin/", (req, res) -> {
			return new ExecutePluginHandler().handle(req, res); });

		get("importcsv/:nodeFilename/:edgeFilename/:projectName", (req, res) -> {
			return new ImportCSVHandler().handle(req, res);
		});

		get("manageprojects/create/:projectName", (req, res) -> {
			return new CreateProjectHandler().handle(req, res);
		});

		get("manageprojects/delete/:projectName", (req, res) -> {
			return new DeleteProjectHandler().handle(req, res);
		});

		get("manageprojects/list", (req, res) -> {
			return new ListProjectsHandler().handle(req, res);
		});

		get("manageshells/list", (req, res) -> {
			return new ListShellsHandler().handle(req, res);
		});

		get("manageshells/create/:projectName/:shellName", (req, res) -> {
			return new CreateShellHandler().handle(req,res);
		});

		exception(RuntimeException.class, (e, req, res) -> {
			res.status(400);
			res.body("Runtime Exception: " + e.getMessage());
		});

	}

}
