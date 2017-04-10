package udg.php.useDefAnalysis.environments;

import udg.ASTProvider;
import udg.useDefAnalysis.environments.EmitUseEnvironment;

public class ForEnvironment extends EmitUseEnvironment
{
	// a ForStatement should emit USEs for its predicate,
	// which is its second child;
	// the initialization directive and the increment directive,
	// as well as the statements in its body will be analyzed on their own,
	// no need to traverse them here
	@Override
	public boolean shouldTraverse(ASTProvider child)
	{
		int childNum = child.getChildNumber();
		return 1 == childNum ? true : false;
	}
}
