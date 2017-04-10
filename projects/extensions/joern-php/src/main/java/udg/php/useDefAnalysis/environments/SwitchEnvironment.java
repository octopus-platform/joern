package udg.php.useDefAnalysis.environments;

import udg.ASTProvider;
import udg.useDefAnalysis.environments.EmitUseEnvironment;

public class SwitchEnvironment extends EmitUseEnvironment
{
	// a SwitchStatement should emit USEs for its predicate;
	// the statements in its body will be analyzed on their own,
	// no need to traverse them here
	@Override
	public boolean shouldTraverse(ASTProvider child)
	{
		int childNum = child.getChildNumber();
		return 0 == childNum ? true : false;
	}
}
