package ast.php.functionDef;

import ast.ASTNodeProperties;
import ast.expressions.Identifier;
import ast.functionDef.FunctionDef;

public class PHPFunctionDef extends FunctionDef
{
	protected Identifier returnType = null;

	public String getName() {
		return getProperty(ASTNodeProperties.NAME);
	}
	
	public void setName(String name) {
		setProperty(ASTNodeProperties.NAME, name);
	}
	
	public String getDocComment() {
		return getProperty(ASTNodeProperties.DOCCOMMENT);
	}
	
	public void setDocComment(String doccomment) {
		setProperty(ASTNodeProperties.DOCCOMMENT, doccomment);
	}

	public Identifier getReturnType()
	{
		return this.returnType;
	}
	
	public void setReturnType(Identifier returnType)
	{
		this.returnType = returnType;
		super.addChild(returnType);
	}
	
	@Override
	public Identifier getIdentifier()
	{
		throw new RuntimeException("An Identifier is not used for PHP function names, use getName() instead!");
	}
}
