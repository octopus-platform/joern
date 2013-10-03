package tools.udg.environments;

public class MemberAccessEnvironment extends UseDefEnvironment {

	@Override
	public boolean shouldTraverse()
	{
		if(childType != null && childNum == 1  &&
		   childType.equals("Identifier"))
			return false;				
		
		return true;
	}

}
