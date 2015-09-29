package inputModules.csv.csvFuncExtractor;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class CSVAST
{

	List<String> nodeRows = new LinkedList<String>();
	List<String> edgeRows = new LinkedList<String>();

	public void addNodeRow(String str)
	{
		nodeRows.add(str);
	}

	public void addEdgeRow(String str)
	{
		edgeRows.add(str);
	}

	public String getNodesAsString()
	{
		return StringUtils.join(nodeRows, "\n");
	}

	public String getEdgesAsString()
	{
		return StringUtils.join(edgeRows, "\n");
	}

	public int getNumberOfNodes()
	{
		return nodeRows.size() - 1;
	}

}
