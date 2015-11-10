package ast.php.functionDef;

import ast.ASTNode;
import ast.expressions.Identifier;
import ast.functionDef.Parameter;

public class PHPParameter extends Parameter
{
	private Identifier type = null;
	private ASTNode name = null;
	private ASTNode defaultvalue = null;

	public void addChild(ASTNode node)
	{	
		// Note: 3 children for PHP ASTs: Identifier and two plain ASTNode's.
		// (TODO which I want to make into ast.php.expressions.PlainType sometime,
		//  but that's a whole other story...)
		// The Identifier is the type, *not* the name of the parameter!
		// The two plain ASTNode's correspond to 'name' and 'default', respectively.
		// Here we can only distinguish the two by the order in which they are added.
		if( node instanceof Identifier)
			this.type = (Identifier)node;
		else if( null == this.name)
				this.name = node;
		else
			this.defaultvalue = node;

		super.addChild(node);
	}

	@Override
	public Identifier getType()
	{
		return this.type;
	}
	
	public ASTNode getNameChild() {
		return this.name;
	}
	
	public ASTNode getDefault()
	{
		return this.defaultvalue;
	}
}
