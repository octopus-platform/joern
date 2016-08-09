package octopus.server.components.restServer;

import static spark.Spark.post;

public class OctopusRestServer {

	public static void start()
	{
		post("/executeplugin", (req, res) -> {
			return "";
		});
	}

}
