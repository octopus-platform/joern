package ast.php.statements.blockstarters;

import ast.ASTNode;
import ast.statements.blockstarters.SwitchStatement;

public class PHPSwitchStatement extends SwitchStatement
{
	private ASTNode expression = null; // TODO change type to Expression
	protected PHPSwitchList switchList = null;

	public ASTNode getExpression()
	{
		return this.expression;
	}

	public void setExpression(ASTNode expression)
	{
		this.expression = expression;
		super.addChild(expression);
	}
	
	public PHPSwitchList getSwitchList()
	{
		return this.switchList;
	}
	
	public void setSwitchList(PHPSwitchList switchList)
	{
		this.switchList = switchList;
		super.addChild(switchList);
	}
}
