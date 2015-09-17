package tools.phpast2cfg.csv2ast;

import java.util.HashMap;
import java.util.Map;

public abstract class NodeTypeMapper
{
	protected Map<String, String> stringMap = new HashMap<String, String>();

	protected abstract void initMap();

	public NodeTypeMapper()
	{
		initMap();
	}

	public String map(String x)
	{
		String y = stringMap.get(x);
		if (y != null)
			return y;
		return x;
	}

}
