package udg.useDefAnalysis.environments;

import udg.ASTProvider;

public class AssignmentEnvironment extends EmitDefEnvironment
{

	@Override
	public boolean isUse(ASTProvider child)
	{
		int childNum = child.getChildNumber();

		if (childNum == 0)
		{

			String operatorCode = astProvider.getOperatorCode();
			if (operatorCode != null && !operatorCode.equals("="))
				return true;
			else
				return false;
		}

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
