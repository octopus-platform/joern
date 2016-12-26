package udg.useDefAnalysis.environments;

import udg.ASTProvider;

public class DeclEnvironment extends EmitDefEnvironment
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
