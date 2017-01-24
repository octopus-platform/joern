package octopus.server.restServer;

import static spark.Spark.exception;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import octopus.server.restServer.handlers.*;


public class OctopusRestServer {

	private static final int REST_PORT = 2480;

	public static void start()
	{
		port(REST_PORT);

		/*
		 * This is a complete list of all REST commands. If you want to
		 * add a command, please stick to the following RULES:
		 *
		 * - If you need optional parameters, create multiple routes
		 *   but do NOT use slack. This will ensure that all ways of
		 *   executing commands remain visible in this file.
		 *
		 * - Try to place your command into one of the existing
		 * 	 groups first. Only if none exists that matches, create
		 *   your own group.
		 *
		 * - Choose a group name that describes functionality, not
		 *   code origin.
		 **/

		post("executeplugin/", (req, res) -> {
			return new ExecutePluginHandler().handle(req, res); });

		get("manageprojects/create/:projectName", (req, res) -> {
			return new CreateProjectHandler().handle(req, res);
		});

		get("manageprojects/delete/:projectName", (req, res) -> {
			return new DeleteProjectHandler().handle(req, res);
		});

		get("manageprojects/list", (req, res) -> {
			return new ListProjectsHandler().handle(req, res);
		});

		get("database/importcsv/:projectName", (req, res) -> {
			return new ImportCSVHandler().handle(req, res);
		});

		get("database/importcsv/:projectName/:nodeFilename/:edgeFilename", (req, res) -> {
			return new ImportCSVHandler().handle(req, res);
		});

		get("database/importdgs/:projectName", (req, res) -> {
			return new ImportGraphstreamHandler().handle(req, res);
		});

		get("database/importdgs/:projectName/:streamFilename", (req, res) -> {
			return new ImportGraphstreamHandler().handle(req, res);
		});

		get("database/reset/:projectName", (req, res) -> {
			return new ResetDatabaseHandler().handle(req, res);
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
