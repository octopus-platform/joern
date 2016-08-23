package ast.php.expressions;

import java.util.Iterator;
import java.util.LinkedList;

import ast.ASTNode;
import ast.NullNode;
import ast.expressions.Expression;

public class ListExpression extends Expression implements Iterable<Expression>
{

	private LinkedList<Expression> elements = new LinkedList<Expression>();

	public int size()
	{
		return this.elements.size();
	}
	
	public Expression getElement(int i) {
		return this.elements.get(i);
	}

	// we expect either a null node or an Expression
	public void addElement(ASTNode element)
	{
		// This is a very special case; on the one hand PHPListExpression is "null-tolerant",
		// but on the other ASTNode.addChild(ASTNode) is not. So we add null to elements,
		// but NullNode to the list of children in ASTNode.
		
		if( element instanceof NullNode)
			this.elements.add(null);
		else if( element instanceof Expression)
			this.elements.add((Expression)element);
		else
			throw new RuntimeException("Trying to add element to PHP list expression that is neither an Expression"
					+ "nor a null node!");
		
		super.addChild(element);
	}
	
	@Override
	public Iterator<Expression> iterator() {
		return this.elements.iterator();
	}
}
