package ast.expressions;

import java.util.Iterator;
import java.util.LinkedList;

import ast.ASTNode;
import ast.statements.ExpressionHolder;

public class ArgumentList extends ExpressionHolder implements Iterable<ASTNode> // TODO make this an Iterable<Expression> once the mapping is finished
{
	
	private LinkedList<ASTNode> arguments = new LinkedList<ASTNode>(); // TODO LinkedList<Expression>

	public int size()
	{
		return this.arguments.size();
	}
	
	public ASTNode getArgument(int i) { // TODO return type: Expression
		return this.arguments.get(i);
	}

	public void addArgument(ASTNode argument) // TODO take an Expression
	{
		this.arguments.add(argument);
		super.addChild(argument);
	}
	
	@Override
	public Iterator<ASTNode> iterator() {
		return this.arguments.iterator();
	}
}
