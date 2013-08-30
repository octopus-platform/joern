package tools.udg;


public class UseOrDefRecord{
	public long nodeId;
	public boolean isDef;

	public UseOrDefRecord(long aNodeId, boolean aIsDef)
	{
		nodeId = aNodeId; isDef = aIsDef;
	}

};