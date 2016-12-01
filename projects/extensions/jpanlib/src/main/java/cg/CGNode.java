package cg;

import ast.ASTNode;
import ast.expressions.CallExpressionBase;
import ast.functionDef.FunctionDefBase;

/**
 *  A CGNode is a container for either a call expression (caller) or a function definition (callee).
 */
public class CGNode {
	
	private ASTNode astNode;
	private boolean isCallee;

	public CGNode( FunctionDefBase node) {
		init( node);
		setIsCallee( true);
	}
	
	public CGNode( CallExpressionBase node) {
		init( node);
		setIsCallee( false);
	}
	
	private void init( ASTNode node) {

		if( null == node)
			throw new IllegalArgumentException( "Cannot construct a CGNode with a null node.");

		setASTNode( node);
	}

	private void setASTNode( ASTNode astNode) {
		this.astNode = astNode;
	}

	public ASTNode getASTNode()	{
		return this.astNode;
	}

	private void setIsCallee( boolean isCallee) {
		this.isCallee = isCallee;
	}

	public boolean isCallee() {
		return this.isCallee;
	}
	
	public String getEscapedCodeStr() {
		return getASTNode().getEscapedCodeStr();
	}

	@Override
	public int hashCode() {
		return getASTNode().hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if( o instanceof CGNode)
			return getASTNode().equals( ((CGNode)o).getASTNode());
		return false;
	}
	
	@Override
	public String toString() {
		return getASTNode().toString();
	}
}
