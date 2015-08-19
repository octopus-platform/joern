package outputModules.common;

import java.util.HashMap;
import java.util.Map;

public class Writer
{
	static WriterImpl writerImpl;
	static Map<Object, Long> objectToId = new HashMap<Object, Long>();

	public static void setWriterImpl(WriterImpl impl)
	{
		writerImpl = impl;
	}

	public static void reset()
	{
		objectToId.clear();
	}

	static public Long getIdForObject(Object o)
	{
		return objectToId.get(o);
	}

	public static void changeOutputDir(String dirNameForFileNode)
	{
		writerImpl.changeOutputDir(dirNameForFileNode);
	}

	public static long addNode(Object node, Map<String, Object> properties)
	{
		long nodeId = writerImpl.writeNode(node, properties);

		if (node != null)
			objectToId.put(node, nodeId);

		return nodeId;
	}

	public static void addEdge(long srcId, long dstId,
			Map<String, Object> properties, String edgeType)
	{
		writerImpl.writeEdge(srcId, dstId, properties, edgeType);
	}

}
