package outputModules.common;

import java.util.Map;

public interface WriterImpl
{

	public long writeNode(Object node, Map<String, Object> properties);

	public void writeEdge(long srcId, long dstId,
			Map<String, Object> properties, String edgeType);

	public void changeOutputDir(String dirNameForFileNode);

	public void shutdown();

}
