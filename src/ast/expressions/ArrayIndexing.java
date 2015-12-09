package ast.expressions;

public class ArrayIndexing extends Expression
{
	private Expression array = null;
	private Expression index = null;

	public Expression getArrayExpression()
	{
		return this.array;
	}

	public void setArrayExpression(Expression array)
	{
		this.array = array;
		super.addChild(array);
	}
	
	public Expression getIndexExpression()
	{
		return this.index;
	}

	public void setIndexExpression(Expression index)
	{
		this.index = index;
		super.addChild(index);
	}
}
