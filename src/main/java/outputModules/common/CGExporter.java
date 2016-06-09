package outputModules.common;

import java.util.Map;

import cg.CGEdge;

public abstract class CGExporter {

	protected abstract void addCGEdge(CGEdge cgEdge, Map<String, Object> properties);
}
