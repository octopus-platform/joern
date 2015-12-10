package ast.logical.statements;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import ast.ASTNode;
import ast.walking.ASTNodeVisitor;

public class CompoundStatement extends Statement implements Iterable<ASTNode> // TODO make this an Iterable<Statement>
{
	protected static final List<ASTNode> emptyList = new LinkedList<ASTNode>();

	// TODO would it not be better to expose only the iterator instead?
	public List<ASTNode> getStatements()
	{
		return null == children ? emptyList : children;
	}

	public int size()
	{
		return getStatements().size();
	}
	
	public ASTNode getStatement(int i) {
		return getStatements().get(i);
	}

	public void addStatement(ASTNode statement)
	{
		super.addChild(statement);
	}
	
	
	public String getEscapedCodeStr()
	{
		return "";
	}

	@Override
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}

	@Override
	public Iterator<ASTNode> iterator() {
		return getStatements().iterator();
	}
}
