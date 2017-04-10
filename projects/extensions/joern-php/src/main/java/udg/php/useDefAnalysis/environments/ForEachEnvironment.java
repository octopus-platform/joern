package udg.php.useDefAnalysis.environments;

import udg.ASTProvider;
import udg.useDefAnalysis.environments.EmitDefAndUseEnvironment;

public class ForEachEnvironment extends EmitDefAndUseEnvironment
{
	// the second and third children of a ForEachStatement correspond
	// to the two variables DEF'ed by the statement
	@Override
	public boolean isDef( ASTProvider child)
	{
		int childNum = child.getChildNumber();
		return 1 == childNum || 2 == childNum ? true : false;
	}
	
	// the first child of a ForEachStatement corresponds
	// to the variable USE'd to iterate
	@Override
	public boolean isUse( ASTProvider child)
	{
		int childNum = child.getChildNumber();
		return 0 == childNum ? true : false;
	}
	
	// a ForStatement should emit a USE for the object it is iterating over,
	// and DEFs for the two variables it initializes;
	// the statements in its body will be analyzed on their own
	// no need to traverse them here
	@Override
	public boolean shouldTraverse(ASTProvider child)
	{
		int childNum = child.getChildNumber();
		return (0 <= childNum && childNum <= 2) ? true : false;
	}
}
