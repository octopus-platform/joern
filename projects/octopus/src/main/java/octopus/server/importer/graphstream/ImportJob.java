package octopus.server.importer.graphstream;

public class ImportJob
{
    private final String streamFilename;
    private final String projectName;

    public ImportJob(String streamFilename, String projectName)
    {
        this.streamFilename = streamFilename;
        this.projectName = projectName;
    }

    public String getStreamFilename()
    {
        return streamFilename;
    }

    public String getProjectName()
    {
        return projectName;
    }

}
