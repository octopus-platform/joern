package ast.php.functionDef;

public class Closure extends PHPFunctionDef
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
