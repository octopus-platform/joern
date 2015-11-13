package ast.php.functionDef;

import ast.ASTNode;
import ast.functionDef.FunctionDef;
import ast.logical.statements.CompoundStatement;

public class Method extends FunctionDef
{
	public void setContent(ASTNode content)
	{
		if( content instanceof CompoundStatement)
			this.content = (CompoundStatement)content;
		super.addChild(content);
	}
}
