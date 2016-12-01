package ast.statements.jump;

import ast.expressions.StringExpression;
import ast.logical.statements.JumpStatement;
import ast.walking.ASTNodeVisitor;

public class GotoStatement extends JumpStatement
{
	private StringExpression label = null;

	public void setTargetLabel(StringExpression label) {
		this.label = label;
		super.addChild(label);
	}
	
	public StringExpression getTargetLabel() {
		return this.label;
	}
	
	public String getTargetName()
	{
		// TODO since C world does not use the setTargetLabel() method but
		// instead uses addChild(), we have to use getChild(0) here
		// instead of getTargetLabel()
		return getChild(0).getEscapedCodeStr();
	}

	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
