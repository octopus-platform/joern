package tools.udg.environments;


public class DeclEnvironment extends EmitDefEnvironment {
	
	public boolean isUse()
	{
		return false;
	}
	public boolean isDef()
	{
		return (childNum == 1 && childType.equals("Identifier"));
	}
	
}
