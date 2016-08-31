package octopus.server.importer.csv;

public class ImportJob
{
	private final String nodeFilename;
	private final String edgeFilename;
	private final String projectName;

	public ImportJob(String nodeFilename, String edgeFilename, String projectName)
	{
		this.nodeFilename = nodeFilename;
		this.edgeFilename = edgeFilename;
		this.projectName = projectName;
	}

	public String getNodeFilename()
	{
		return nodeFilename;
	}

	public String getEdgeFilename()
	{
		return edgeFilename;
	}

	public String getProjectName()
	{
		return projectName;
	}

}