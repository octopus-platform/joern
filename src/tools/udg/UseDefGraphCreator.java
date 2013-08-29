package tools.udg;

import tools.GraphDbWalker;
import tools.ImportedNodeListener;
import tools.ImportedNodeWalker;

public class UseDefGraphCreator extends GraphDbWalker {
	
	static ImportedNodeWalker walker = new ImportedNodeWalker();
	private static ImportedNodeListener listener = new UseDefGraphListener();
	
	public static void main(String[] args)
	{
		initializeDatabase();
		
		walker.setType("Function");
		walker.addListener(listener);
		walker.walk();		
		
		shutdownDatabase();
	}
			
}
