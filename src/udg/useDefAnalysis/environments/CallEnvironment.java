package udg.useDefAnalysis.environments;

import java.util.Collection;
import java.util.List;

public class CallEnvironment extends UseDefEnvironment
{

	Collection<Integer> taintedArgs;

	public void setTaintedArgs(List<Integer> taintedArgs)
	{
		this.taintedArgs = taintedArgs;
	}

	public boolean isArgumentTainted(int argN)
	{
		if (taintedArgs == null)
			return false;
		return taintedArgs.contains(argN);
	}

}
