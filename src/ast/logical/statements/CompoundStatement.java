package ast.logical.statements;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import ast.ASTNode;
import ast.walking.ASTNodeVisitor;

public class CompoundStatement extends Statement implements Iterable<ASTNode>
{
	protected static final List<ASTNode> emptyList = new LinkedList<ASTNode>();

	// TODO would it not be better to expose only the iterator instead?
	public List<ASTNode> getStatements()
	{
		return null == children ? emptyList : children;
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
