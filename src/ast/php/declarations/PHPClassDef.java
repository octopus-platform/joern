package ast.php.declarations;

import ast.ASTNode;
import ast.ASTNodeProperties;
import ast.declarations.ClassDefStatement;
import ast.expressions.Identifier;
import ast.expressions.IdentifierList;
import ast.php.functionDef.TopLevelFunctionDef;

public class PHPClassDef extends ClassDefStatement
{

	private Identifier parent = null;
	private IdentifierList interfaces = null;
	private TopLevelFunctionDef toplevelfunc = null;

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
	
	public Identifier getExtends()
	{
		return this.parent;
	}
	
	public void setExtends(ASTNode parent)
	{
		if( parent instanceof Identifier)
			this.parent = (Identifier)parent;
		super.addChild(parent);
	}
	
	public IdentifierList getImplements()
	{
		return this.interfaces;
	}
	
	public void setImplements(ASTNode interfaces)
	{
		if( interfaces instanceof IdentifierList)
			this.interfaces = (IdentifierList)interfaces;
		super.addChild(interfaces);
	}
	
	public TopLevelFunctionDef getTopLevelFunc()
	{
		return this.toplevelfunc;
	}
	
	public void setTopLevelFunc(TopLevelFunctionDef toplevelfunc)
	{
		this.toplevelfunc = toplevelfunc;
		super.addChild(toplevelfunc);
	}
}
