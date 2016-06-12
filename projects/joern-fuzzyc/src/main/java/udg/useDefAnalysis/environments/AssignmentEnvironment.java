package udg.useDefAnalysis.environments;

import udg.ASTProvider;
import udg.useDefAnalysis.environments.EmitDefAndUseEnvironment;

public class AssignmentEnvironment extends EmitDefAndUseEnvironment
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
