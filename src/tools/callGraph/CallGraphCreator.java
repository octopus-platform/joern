package tools.callGraph;

import tools.GraphDbWalker;
import tools.ImportedNodeWalker;

public class CallGraphCreator extends GraphDbWalker{

	private static ImportedNodeWalker functionWalker = new ImportedNodeWalker();
	private static CallGraphListener listener = new CallGraphListener();
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		initializeDatabase();
		
		functionWalker.addListener(listener);
		functionWalker.walk();
		
		shutdownDatabase();
	}

}
