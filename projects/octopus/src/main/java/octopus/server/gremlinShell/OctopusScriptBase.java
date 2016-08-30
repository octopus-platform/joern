package octopus.server.gremlinShell;

import java.util.HashSet;
import java.util.Set;

import groovy.lang.Script;


public abstract class OctopusScriptBase extends Script
{

	public Set<String> listSteps()
	{
		// TODO
		return new HashSet<String>();
		// return Gremlin.getStepNames();
	}

	public Set<String> listSteps(String prefix)
	{
		Set<String> steps = listSteps();
		steps.removeIf(step -> !step.startsWith(prefix));
		return steps;
	}

	public Set<?> listVariables()
	{
		return getBinding().getVariables().keySet();
	}

	public void removeVariable(String variable)
	{
		getBinding().getVariables().remove(variable);
	}
}
