package tools.argumentTainter;

import tools.UtilCommandLineInterface;

public class CommandLineInterface extends UtilCommandLineInterface
{

	public void printHelp()
	{

	}

	public String getSource()
	{
		return cmd.getArgs()[0];
	}

	public int getArgNum()
	{
		return Integer.parseInt(cmd.getArgs()[1]);
	}

	public int getNumberOfArgs()
	{
		return cmd.getArgs().length;
	}

}
