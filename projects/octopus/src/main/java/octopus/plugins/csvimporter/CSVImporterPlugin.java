package octopus.plugins.csvimporter;


import octopus.api.csvImporter.CSVImporter;
import octopus.api.plugin.connectors.OctopusProjectConnector;
import octopus.api.plugin.types.OctopusProjectPlugin;
import octopus.api.projects.OctopusProjectWrapper;
import octopus.server.importer.csv.ImportJob;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CSVImporterPlugin extends OctopusProjectPlugin{

    @Override
    public void execute() throws Exception {

        String projectName = getProjectName();
        String pathToProjecDir = getPathToProjectDir();
        String nodeFilename = Paths.get(pathToProjecDir, "nodes.csv").toString();
        String edgeFilename = Paths.get(pathToProjecDir, "edges.csv").toString();

        ImportJob importJob = new ImportJob(nodeFilename, edgeFilename, projectName);
        (new CSVImporter()).importCSV(importJob);
    }

}
