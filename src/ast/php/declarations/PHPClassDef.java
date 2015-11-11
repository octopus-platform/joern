package ast.php.declarations;

import ast.ASTNode;
import ast.ASTNodeProperties;
import ast.DummyIdentifierNode;
import ast.declarations.ClassDefStatement;
import ast.expressions.Identifier;
import ast.php.functionDef.TopLevelFunctionDef;

public class PHPClassDef extends ClassDefStatement
{

	private Identifier parent = new DummyIdentifierNode();
	private TopLevelFunctionDef toplevelfunc = new TopLevelFunctionDef();

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
