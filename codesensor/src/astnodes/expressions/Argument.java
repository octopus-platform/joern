package astnodes.expressions;

import astnodes.ASTNodeVisitor;
import astnodes.statements.ExpressionHolder;

public class Argument extends ExpressionHolder {
	public void accept(ASTNodeVisitor visitor){ visitor.visit(this); }	
}
