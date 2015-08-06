package outputModules.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import databaseNodes.DatabaseNode;

public class CSVWriter
{
	final static String SEPARATOR = "\t";

	final static String[] nodeProperties = { "type", "code", "location",
			"functionId", "name", "filepath" };

	static PrintWriter nodeWriter;
	static PrintWriter edgeWriter;
	static long lastNodeId = 0;
	private static long curFunctionId = -1;

	public static void changeOutputDir(String dirNameForFileNode)
	{
		closeEdgeFile();
		closeNodeFile();
		openNodeFile(dirNameForFileNode);
		openEdgeFile(dirNameForFileNode);
	}

	public static void addNode(DatabaseNode dbNode,
			Map<String, Object> properties)
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
	}

	public static void addEdge(long nodeId, Map<String, String> properties,
			String edgeType)
	{

	}

	private static void openNodeFile(String outDir)
	{
		String path = outDir + File.separator + "nodes.csv";
		nodeWriter = createWriter(path);
		writeNodePropertyNames();
	}

	private static void writeNodePropertyNames()
	{
		String joined = "id" + SEPARATOR
				+ StringUtils.join(nodeProperties, SEPARATOR);
		nodeWriter.println(joined);
	}

	private static void openEdgeFile(String outDir)
	{
		String path = outDir + File.separator + "edges.csv";
		edgeWriter = createWriter(path);
	}

	private static PrintWriter createWriter(String path)
	{
		try
		{
			return new PrintWriter(path);
		}
		catch (FileNotFoundException e)
		{
			throw new RuntimeException("Cannot create file: " + path);
		}
	}

	private static void closeNodeFile()
	{
		if (nodeWriter != null)
			nodeWriter.close();
	}

	private static void closeEdgeFile()
	{
		if (edgeWriter != null)
			edgeWriter.close();
	}

	public static Long getCurFunctionId()
	{
		return curFunctionId;
	}

	public static void setCurFunctionId()
	{
		CSVWriter.curFunctionId = lastNodeId;
	}

}
