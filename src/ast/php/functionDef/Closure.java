package ast.php.functionDef;

import ast.ASTNode;
import ast.functionDef.FunctionDef;

public class Closure extends FunctionDef
{
	private ClosureUses closureUses = null;

	public ClosureUses getClosureUses()
	{
		return this.closureUses;
	}

	public void setClosureUses(ASTNode closureUses)
	{
		if( closureUses instanceof ClosureUses)
			this.closureUses = (ClosureUses)closureUses;
		super.addChild(closureUses);
	}
}
