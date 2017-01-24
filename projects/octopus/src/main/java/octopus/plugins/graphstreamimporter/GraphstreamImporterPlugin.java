package octopus.plugins.graphstreamimporter;


import java.nio.file.Paths;

import octopus.api.graphstreamImporter.GraphstreamImporter;
import octopus.api.plugin.types.OctopusProjectPlugin;
import octopus.server.importer.graphstream.ImportJob;

public class GraphstreamImporterPlugin extends OctopusProjectPlugin {

    @Override
    public void execute() throws Exception {
        String projectName = getProjectName();
        String pathToProjectDir = getPathToProjectDir();
        String streamFilename = Paths.get(pathToProjectDir, "stream.dgs").toString();

        ImportJob importJob = new ImportJob(streamFilename, projectName);
        (new GraphstreamImporter()).importGraphstream(importJob);
    }

}