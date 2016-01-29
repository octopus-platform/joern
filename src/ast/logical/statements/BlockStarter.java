package ast.logical.statements;

import ast.ASTNode;
import ast.expressions.Expression;
import ast.php.statements.blockstarters.PHPDeclareStatement;

public class BlockStarter extends Statement
{
	protected Expression condition = null;
	protected Statement statement = null;

	public Expression getCondition()
	{
		return this.condition;
	}

	public void setCondition(Expression expression)
	{
		this.condition = expression;
		super.addChild(expression);
	}

	public Statement getStatement()
	{
		return this.statement;
	}
	
	public void setStatement(Statement statement)
	{
		this.statement = statement;
		super.addChild(statement);
	}

	// TODO:
	// The BlockStarter class needs to be refactored.
	// In particular the addChild(ASTNode) method currently tries to call
	// the appropriate setters according to the type of the node passed as
	// argument, but the way this is done is quite unsatisfactory:
	// - For instance, it actually *hurts* PHP world when creating a PHPDeclareStatement,
	// because *both* children of a PHPDeclareStatement are of type Statement (the first
	// one being a ConstantDeclaration, the second one an arbitrary Statement or null.)
	// - Another example where this method hurts PHP world is when creating a TryStatement;
	// again, *both* the content of the try block and the content of the finally block are
	// instances of Statement.
	// We currently need the ugly hack below to ensure that this method does not call setStatement()
	// when dealing with a PHPDeclareStatement. As for a TryStatement in PHP world, the method getStatement()
	// should never be called in the first place, so we do not care whether setStatement() is called
	// in that case; calling getStatement() on a TryStatement is an error in PHP world anyway.
	// Generally, the clean way to solve these problems is to redesign the hierarchy of blockstarters.
	// Not all classes that inherit from BlockStarter use getCondition()/setCondition().
	// Not all use getStatement()/setStatement().
	// The addChild() method should not force the use of these setters for children that do not use them.
	@Override
	public void addChild(ASTNode node)
	{
		if (node instanceof Condition)
			setCondition((Condition) node);
		else if (node instanceof Statement
				&& !this.getClass().equals(PHPDeclareStatement.class))
			setStatement((Statement) node);
		else
			super.addChild(node);
	}

}
