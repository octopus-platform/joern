package tools.icfg;

import tools.UtilCommandLineInterface;

public class ICFGCommandLineInterface extends UtilCommandLineInterface
{

	public void printHelp()
	{
		formatter.printHelp("icfg", options);
	}
}
