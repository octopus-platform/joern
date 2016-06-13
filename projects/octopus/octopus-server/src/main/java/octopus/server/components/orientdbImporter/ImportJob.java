package octopus.server.components.orientdbImporter;

public class ImportJob
{
	private final String nodeFilename;
	private final String edgeFilename;
	private final String dbName;

	public ImportJob(String nodeFilename, String edgeFilename, String dbName)
	{
		this.nodeFilename = nodeFilename;
		this.edgeFilename = edgeFilename;
		this.dbName = dbName;
	}

	public String getNodeFilename()
	{
		return nodeFilename;
	}

	public String getEdgeFilename()
	{
		return edgeFilename;
	}


	public String getDbName()
	{
		return dbName;
	}

}