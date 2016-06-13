package octopus.server.components.gremlinShell;

import groovy.lang.Script;

import java.util.Set;

import com.tinkerpop.gremlin.groovy.Gremlin;

public abstract class OctopusScriptBase extends Script
{

	public Set<String> listSteps()
	{
		return Gremlin.getStepNames();
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
