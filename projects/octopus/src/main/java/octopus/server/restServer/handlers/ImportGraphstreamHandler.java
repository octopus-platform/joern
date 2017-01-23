package octopus.server.restServer.handlers;

import octopus.api.graphstreamImporter.GraphstreamImporter;
import octopus.server.importer.graphstream.ImportJob;
import octopus.server.restServer.OctopusRestHandler;
import spark.Request;
import spark.Response;

public class ImportGraphstreamHandler implements OctopusRestHandler {

    @Override
    public Object handle(Request req, Response resp)
    {
        ImportJob job = getImportJobFromRequest(req);
        new GraphstreamImporter().importGraphstream(job);
        return "";
    }

    private ImportJob getImportJobFromRequest(Request req)
    {
        String streamFilename = req.params(":streamFilename");
        String projectName = req.params(":projectName");

        if(streamFilename == null)
            streamFilename = "stream.dgs";

        return new ImportJob(streamFilename, projectName);
    }

}
