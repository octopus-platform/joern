package udg.useDefAnalysis.environments;

import udg.ASTProvider;
import udg.useDefAnalysis.environments.EmitDefAndUseEnvironment;

public class IncDecEnvironment extends EmitDefAndUseEnvironment
{
	@Override
	public boolean isUse(ASTProvider child)
	{
		return true;
	}

	@Override
	public boolean isDef(ASTProvider child)
	{
		int childNum = child.getChildNumber();

		if (childNum == 0)
			return true;

		return false;
	}

}
