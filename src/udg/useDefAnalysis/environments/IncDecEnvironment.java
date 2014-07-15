package udg.useDefAnalysis.environments;

import udg.ASTProvider;

public class IncDecEnvironment extends EmitDefEnvironment
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
