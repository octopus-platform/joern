package udg.useDefAnalysis.environments;

import udg.ASTProvider;
import udg.useDefAnalysis.environments.EmitDefAndUseEnvironment;

public class DeclEnvironment extends EmitDefAndUseEnvironment
{

	public boolean isUse(ASTProvider child)
	{
		return false;
	}

	public boolean isDef(ASTProvider child)
	{
		String type = child.getTypeAsString();
		int childNum = child.getChildNumber();
		return (childNum == 1 && type.equals("Identifier"));
	}

}
