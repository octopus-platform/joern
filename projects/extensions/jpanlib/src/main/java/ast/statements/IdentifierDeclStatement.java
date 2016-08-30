package ast.statements;

import java.util.List;

import ast.ASTNode;
import ast.declarations.IdentifierDeclType;
import ast.logical.statements.Statement;
import ast.walking.ASTNodeVisitor;

public class IdentifierDeclStatement extends Statement
{

	private IdentifierDeclType type = new IdentifierDeclType();

	public void addChild(ASTNode node)
	{
		if (node instanceof IdentifierDeclType)
		{
			setType((IdentifierDeclType) node);
			return; // Do NOT add type to children.
		}
		super.addChild(node);
	}

	private void setType(IdentifierDeclType node)
	{
		type = node;
	}

	public IdentifierDeclType getType()
	{
		return type;
	}

	public List<ASTNode> getIdentifierDeclList()
	{
		return children;
	}

	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}

}
