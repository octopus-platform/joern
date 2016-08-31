package octopus.server.restServer;

import spark.Request;
import spark.Response;

/**
 * OctopusRestHandlers implement a single method `handle` that
 * receives a request and is tasked to craft a response.
 * In between, it may dispatch the request, read from the
 * environment, and finally make calls to the internal API.
 *
 * REST handlers MUST NOT calls into server components directly!
 *
 * */

public interface OctopusRestHandler {

	public Object handle(Request req, Response resp);

}
