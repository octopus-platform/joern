package astnodes.statements;

import astwalking.ASTNodeVisitor;

public class GotoStatement extends JumpStatement
{
	public String getTarget()
	{
		return parseTreeNodeContext.getChild(1).getText();
	}
	
	public void accept(ASTNodeVisitor visitor){ visitor.visit(this); }
}
