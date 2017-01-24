package octopus.api.graphstreamImporter;

import octopus.server.importer.graphstream.ImportGraphstreamRunnable;
import octopus.server.importer.graphstream.ImportJob;

public class GraphstreamImporter {

    public void importGraphstream(ImportJob job)
    {
        (new ImportGraphstreamRunnable(job)).run();
    }

}
