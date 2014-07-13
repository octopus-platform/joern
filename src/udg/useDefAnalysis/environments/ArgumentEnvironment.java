package udg.useDefAnalysis.environments;

import udg.ASTProvider;

public class ArgumentEnvironment extends EmitDefAndUseEnvironment
{

	boolean isTainted = false;

	public boolean isUse(ASTProvider child)
	{
		return true;
	}

	public boolean isDef(ASTProvider child)
	{
		return isTainted;
	}

	public void setIsTainted()
	{
		isTainted = true;
	}

}
