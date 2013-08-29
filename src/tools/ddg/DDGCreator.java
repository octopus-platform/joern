package tools.ddg;

import tools.GraphDbWalker;
import tools.ImportedNodeListener;
import tools.ImportedNodeWalker;

public class DDGCreator extends GraphDbWalker {

	static ImportedNodeWalker walker = new ImportedNodeWalker();
	private static ImportedNodeListener listener = new DDGListener();
	
	public static void main(String[] args)
	{
		initializeDatabase();
		
		walker.setType("Function");
		walker.addListener(listener);
		walker.walk();		
		
		shutdownDatabase();
	}
	
}
