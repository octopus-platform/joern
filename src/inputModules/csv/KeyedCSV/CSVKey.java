package inputModules.csv.KeyedCSV;

public class CSVKey
{
	private String name;
	private String type;
	private String nodeIndex;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public void setNodeIndex(String nodeIndex)
	{
		this.nodeIndex = nodeIndex;
	}

	public String getType()
	{
		return type;
	}

	public String getIndex()
	{
		return nodeIndex;
	}

}
