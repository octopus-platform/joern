package output.csvast;

import java.util.HashMap;

public class NodeBlacklist {

	static final String [] nodeTypeBlacklist = {
	        "CompoundStatement"
	 };
	
	static HashMap<String,Integer> nodeBlacklist;
	
	static
	{   
		initializeNodeBlacklist();
	}

	private static void initializeNodeBlacklist()
	{
		nodeBlacklist = new HashMap<String,Integer>();

		for(int i = 0; i < nodeTypeBlacklist.length; i++){
			nodeBlacklist.put(nodeTypeBlacklist[i], 1);
		}               
	}

	public static boolean isBlackListed(String type)
	{
		return nodeBlacklist.containsKey(type);
	}
}
