package tools.icfg;

import tools.GraphDbWalker;
import tools.ImportedNodeListener;
import tools.ImportedNodeWalker;

public class ICFGMain extends GraphDbWalker {

	static ImportedNodeWalker walker = new ImportedNodeWalker();
	static ImportedNodeListener listener = new ICFGListener();
	
	public static void main(String[] args)
	{
		initializeDatabase();
		
		walker.setType("CallExpression");
		walker.addListener(listener);
		walker.walk();
		
		shutdownDatabase();
	}	
	
}
