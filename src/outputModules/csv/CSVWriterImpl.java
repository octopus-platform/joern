package outputModules.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import databaseNodes.NodeKeys;
import outputModules.common.WriterImpl;

public class CSVWriterImpl implements WriterImpl
{
	final String SEPARATOR = "\t";

	final String[] nodeProperties = { NodeKeys.TYPE, NodeKeys.CODE,
			NodeKeys.LOCATION, NodeKeys.FUNCTION_ID, NodeKeys.NAME,
			NodeKeys.FILEPATH, NodeKeys.CHILD_NUMBER };

	final String[] edgeProperties = {};

	long lastNodeId = 0;

	PrintWriter nodeWriter;
	PrintWriter edgeWriter;

	public long writeNode(Object node, Map<String, Object> properties)
	{
		nodeWriter.write((new Long(lastNodeId)).toString());
		for (String property : nodeProperties)
		{
			nodeWriter.write(SEPARATOR);
			String propValue = (String) properties.get(property);
			if (propValue != null)
				nodeWriter.write(propValue);
		}
		nodeWriter.write("\n");
		lastNodeId++;
		return lastNodeId - 1;

	}

	@Override
	public void writeEdge(long srcId, long dstId,
			Map<String, Object> properties, String edgeType)
	{
		edgeWriter.print(srcId);
		edgeWriter.print(SEPARATOR);
		edgeWriter.print(dstId);
		edgeWriter.print(SEPARATOR);
		edgeWriter.print(edgeType);

		for (String property : edgeProperties)
		{
			edgeWriter.write(SEPARATOR);
			String propValue = (String) properties.get(property);
			if (propValue != null)
				edgeWriter.write(propValue);
		}
		edgeWriter.write("\n");

	}

	@Override
	public void changeOutputDir(String dirNameForFileNode)
	{
		closeEdgeFile();
		closeNodeFile();
		openNodeFile(dirNameForFileNode);
		openEdgeFile(dirNameForFileNode);
	}

	private void openNodeFile(String outDir)
	{
		String path = outDir + File.separator + "nodes.csv";
		nodeWriter = createWriter(path);
		writeNodePropertyNames();
	}

	private void writeNodePropertyNames()
	{
		String joined = "id" + SEPARATOR
				+ StringUtils.join(nodeProperties, SEPARATOR);
		nodeWriter.println(joined);
	}

	private void writeEdgePropertyNames()
	{
		String joined = "start" + SEPARATOR + "end" + SEPARATOR + "type"
				+ SEPARATOR + StringUtils.join(edgeProperties, SEPARATOR);
		edgeWriter.println(joined);
	}

	private void openEdgeFile(String outDir)
	{
		String path = outDir + File.separator + "edges.csv";
		edgeWriter = createWriter(path);
		writeEdgePropertyNames();
	}

	private PrintWriter createWriter(String path)
	{
		try
		{
			return new PrintWriter(path);
		} catch (FileNotFoundException e)
		{
			throw new RuntimeException("Cannot create file: " + path);
		}
	}

	private void closeNodeFile()
	{
		if (nodeWriter != null)
			nodeWriter.close();
	}

	private void closeEdgeFile()
	{
		if (edgeWriter != null)
			edgeWriter.close();
	}
}
