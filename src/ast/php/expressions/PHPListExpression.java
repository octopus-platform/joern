package ast.php.expressions;

import java.util.Iterator;
import java.util.LinkedList;

import ast.ASTNode;
import ast.expressions.Expression;

public class PHPListExpression extends Expression implements Iterable<ASTNode> // TODO make this an Iterable<Expression> once the mapping is finished
{

	private LinkedList<ASTNode> elements = new LinkedList<ASTNode>(); // TODO LinkedList<Expression>

	public int size()
	{
		return this.elements.size();
	}
	
	public ASTNode getElement(int i) { // TODO return type: Expression
		return this.elements.get(i);
	}

	public void addElement(ASTNode element) // TODO take an Expression
	{
		this.elements.add(element);
		super.addChild(element);
	}
	
	@Override
	public Iterator<ASTNode> iterator() {
		return this.elements.iterator();
	}
}
