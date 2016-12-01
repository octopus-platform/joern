package outputModules.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

import databaseNodes.EdgeKeys;
import databaseNodes.NodeKeys;
import outputModules.common.WriterImpl;

public abstract class CSVWriterImpl implements WriterImpl {

	final String SEPARATOR = "\t";

	final String[] nodeProperties = { NodeKeys.NODE_TYPE, NodeKeys.CODE,
			NodeKeys.LOCATION, NodeKeys.FUNCTION_ID,
			NodeKeys.CHILD_NUMBER, NodeKeys.IS_CFG_NODE , NodeKeys.OPERATOR,
			NodeKeys.BASE_TYPE, NodeKeys.COMPLETE_TYPE, NodeKeys.IDENTIFIER
	};

	final String[] edgeProperties = { EdgeKeys.VAR };

	long lastNodeId = 0;

	PrintWriter nodeWriter;
	PrintWriter edgeWriter;

	@Override
	public abstract void changeOutputDir(String dirNameForFileNode);

	@Override
	public long writeNode(Object node, Map<String, Object> properties)
	{
		nodeWriter.write("ANR");
		nodeWriter.write(SEPARATOR);
		nodeWriter.write((new Long(lastNodeId)).toString());
		for (String property : nodeProperties)
		{
			nodeWriter.write(SEPARATOR);
			String propValue = (String) properties.get(property);
			if (propValue != null)
				nodeWriter.write(escape(propValue));
		}
		nodeWriter.write("\n");
		lastNodeId++;
		return lastNodeId - 1;

	}

	private static String escape(String propValue)
	{
		return StringEscapeUtils.escapeCsv(propValue.replace("\\", "\\\\"));
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
			String propValue = (null == properties) ? null : (String) properties.get(property);
			if (propValue != null)
				edgeWriter.write(escape(propValue));
		}
		edgeWriter.write("\n");

	}

	protected void openNodeFile(String outDir)
	{
		String path = outDir + File.separator + "nodes.csv";
		nodeWriter = createWriter(path);
		writeNodePropertyNames();
	}

	protected void writeNodePropertyNames()
	{
		String joined = "command" + SEPARATOR + "key" + SEPARATOR
				+ StringUtils.join(nodeProperties, SEPARATOR);
		nodeWriter.println(joined);
	}

	protected void writeEdgePropertyNames()
	{
		String joined = "start" + SEPARATOR + "end" + SEPARATOR + "type"
				+ SEPARATOR + StringUtils.join(edgeProperties, SEPARATOR);
		edgeWriter.println(joined);
	}

	protected void openEdgeFile(String outDir)
	{
		openEdgeFile(outDir, "edges.csv");
	}

	public void openEdgeFile(String outDir, String fileName)
	{
		String path = outDir + File.separator + fileName;
		edgeWriter = createWriter(path);
		writeEdgePropertyNames();
	}

	protected PrintWriter createWriter(String path)
	{
		try
		{
			return new PrintWriter(path);
		} catch (FileNotFoundException e)
		{
			throw new RuntimeException("Cannot create file: " + path);
		}
	}

	protected void closeNodeFile()
	{
		if (nodeWriter != null)
			nodeWriter.close();
	}

	public void closeEdgeFile()
	{
		if (edgeWriter != null)
			edgeWriter.close();
	}


}
