package octopus.server.restServer.handlers;

import octopus.lib.CSVImporter;
import octopus.lib.csvImporter.ImportJob;
import octopus.server.restServer.OctopusRestHandler;
import spark.Request;
import spark.Response;

public class ImportCSVHandler implements OctopusRestHandler {

	@Override
	public Object handle(Request req, Response resp)
	{
		ImportJob job = getImportJobFromRequest(req);
		new CSVImporter().importCSV(job);
		return "";
	}

	private ImportJob getImportJobFromRequest(Request req)
	{
		String nodeFilename = req.params(":nodeFilename");
		String edgeFilename = req.params(":edgeFilename");
		String projectName = req.params(":projectName");

		return new ImportJob(nodeFilename, edgeFilename, projectName);
	}

}
