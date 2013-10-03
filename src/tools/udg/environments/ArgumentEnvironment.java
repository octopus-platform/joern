package tools.udg.environments;


public class ArgumentEnvironment extends EmitDefEnvironment {

	boolean isTainted = false;
	
	public boolean isUse()
	{
		return true;
	}
	
	public boolean isDef()
	{
		return isTainted;
	}
	
	public void setIsTainted() {
		isTainted = true;
	}
	
}
