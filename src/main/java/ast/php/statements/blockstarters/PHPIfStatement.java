package ast.php.statements.blockstarters;

import java.util.Iterator;
import java.util.LinkedList;

import ast.ASTNode;
import ast.statements.blockstarters.ElseStatement;
import ast.statements.blockstarters.IfStatement;

public class PHPIfStatement extends IfStatement implements Iterable<PHPIfElement>
{

	private LinkedList<PHPIfElement> ifElements = new LinkedList<PHPIfElement>();

	public int size()
	{
		return this.ifElements.size();
	}
	
	public PHPIfElement getIfElement(int i) {
		return this.ifElements.get(i);
	}

	public void addIfElement(PHPIfElement ifElement)
	{
		this.ifElements.add(ifElement);
		super.addChild(ifElement);
	}

	@Override
	public Iterator<PHPIfElement> iterator() {
		return this.ifElements.iterator();
	}
	
	// Need to override getChildCount() and getChild(int) because they are also overridden
	// by IfStatement, and we want to restore the original behavior from ASTNode.
	// TODO this is really ugly: we should create a class CIfStatement that implements if-statements
	// for C, and have the base class IfStatement abstract from both CIfStatement and PHPIfStatement.
	// Then, CIfStatement can override getChildCount() and getChild(int) on its own and
	// without imposing its behavior to if-statements for other languages that would
	// like to inherit from IfStatement.
	@Override
	public int getChildCount()
	{
		if (children == null)
			return 0;
		return children.size();
	}
	
	@Override
	public ASTNode getChild(int i)
	{
		if (children == null)
			return null;

		ASTNode retval;
		try
		{
			retval = children.get(i);
		} catch (IndexOutOfBoundsException ex)
		{
			return null;
		}
		return retval;
	}

	// Same as for getChildCount() and getChild(int), we have to override
	// getElseNode() and setElseNode(ElseStatement) as we do not want them for PHP
	@Override
	public ElseStatement getElseNode()
	{
		throw new RuntimeException("Error: else nodes are not used by PHP if-statements!");
	}

	@Override
	public void setElseNode(ElseStatement elseNode)
	{
		throw new RuntimeException("Error: else nodes are not used by PHP if-statements!");
	}
}
