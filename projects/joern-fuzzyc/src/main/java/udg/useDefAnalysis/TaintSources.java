package udg.useDefAnalysis;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TaintSources
{

	Map<String, List<Integer>> calleeToArgIds = new HashMap<String, List<Integer>>();

	public void add(String callee, int argNum)
	{
		List<Integer> l;
		if (!isTaintSource(callee))
		{
			l = new LinkedList<Integer>();

			calleeToArgIds.put(callee, l);
		} else
		{
			l = calleeToArgIds.get(callee);
		}
		l.add(argNum);
	}

	public boolean isTaintSource(String callee)
	{
		return calleeToArgIds.containsKey(callee);
	}

	public List<Integer> getTaintedArgsForCallee(String callee)
	{
		if (!isTaintSource(callee))
			return null;

		return calleeToArgIds.get(callee);
	}

}
