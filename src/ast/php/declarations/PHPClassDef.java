package ast.php.declarations;

import ast.ASTNode;
import ast.ASTNodeProperties;
import ast.DummyIdentifierNode;
import ast.declarations.ClassDefStatement;
import ast.expressions.Identifier;
import ast.php.functionDef.TopLevelFunctionDef;

public class PHPClassDef extends ClassDefStatement
{

	public Identifier parent = new DummyIdentifierNode();
	public TopLevelFunctionDef toplevelfunc = new TopLevelFunctionDef();

	public void addChild(ASTNode node)
	{
		if (node instanceof Identifier)
			parent = (Identifier) node;
		else if (node instanceof TopLevelFunctionDef)
			toplevelfunc = (TopLevelFunctionDef) node;

		super.addChild(node);
	}

	public String getName() {
		return getProperty(ASTNodeProperties.NAME);
	}
	
	public void setName(String name) {
		setProperty(ASTNodeProperties.NAME, name);
	}
	
	public Identifier getExtends()
	{
		return this.parent;
	}
	
	public TopLevelFunctionDef getTopLevelFunc()
	{
		return this.toplevelfunc;
	}
	
	public String getDocComment() {
		return getProperty(ASTNodeProperties.DOCCOMMENT);
	}
	
	public void setDocComment(String doccomment) {
		setProperty(ASTNodeProperties.DOCCOMMENT, doccomment);
	}
}
