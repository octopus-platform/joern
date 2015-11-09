package ast.declarations;

import ast.ASTNode;
import ast.ASTNodeProperties;
import ast.DummyIdentifierNode;
import ast.expressions.Identifier;
import ast.logical.statements.CompoundStatement;
import ast.logical.statements.Statement;
import ast.php.functionDef.TopLevelFunctionDef;

public class ClassDefStatement extends Statement
{

	public Identifier identifier = new DummyIdentifierNode();
	public TopLevelFunctionDef toplevelfunc = new TopLevelFunctionDef();
	public CompoundStatement content = new CompoundStatement();

	public void addChild(ASTNode expression)
	{
		if (expression instanceof Identifier)
			identifier = (Identifier) expression;
		else if (expression instanceof TopLevelFunctionDef)
			toplevelfunc = (TopLevelFunctionDef) expression;
		else
			super.addChild(expression);
	}

	public Identifier getIdentifier()
	{
		return identifier;
	}

	public String getName() {
		return getProperty(ASTNodeProperties.NAME);
	}
	
	public void setName(String name) {
		setProperty(ASTNodeProperties.NAME, name);
	}
	
	public Identifier getExtends()
	{
		return this.identifier;
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
