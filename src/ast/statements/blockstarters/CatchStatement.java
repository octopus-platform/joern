package ast.statements.blockstarters;

import ast.ASTNode;
import ast.expressions.Identifier;
import ast.logical.statements.BlockStarter;
import ast.logical.statements.CompoundStatement;
import ast.walking.ASTNodeVisitor;

public class CatchStatement extends BlockStarter
{
	private Identifier exceptionIdentifier = null;
	private ASTNode variableName = null;
	private CompoundStatement content = null;

	public Identifier getExceptionIdentifier()
	{
		return this.exceptionIdentifier;
	}
	
	public void setExceptionIdentifier(Identifier exceptionIdentifier)
	{
		this.exceptionIdentifier = exceptionIdentifier;
		super.addChild(exceptionIdentifier);
	}
	
	public ASTNode getVariableName()
	{
		return this.variableName;
	}
	
	public void setVariableName(ASTNode variableName)
	{
		this.variableName = variableName;
		super.addChild(variableName);
	}
	
	public CompoundStatement getContent()
	{
		return this.content;
	}
	
	public void setContent(CompoundStatement content)
	{
		this.content = content;
		super.addChild(content);
	}
	
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}

}
