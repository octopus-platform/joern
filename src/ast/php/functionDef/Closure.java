package ast.php.functionDef;

import ast.functionDef.FunctionDef;

public class Closure extends FunctionDef
{
	private ClosureUses closureUses = null;

	public ClosureUses getClosureUses()
	{
		return this.closureUses;
	}

	public void setClosureUses(ClosureUses closureUses)
	{
		this.closureUses = closureUses;
		super.addChild(closureUses);
	}
}
