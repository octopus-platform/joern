package udg.useDefAnalysis.environments;


public class ArgumentEnvironment extends EmitDefAndUseEnvironment {

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
