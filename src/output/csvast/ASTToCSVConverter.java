package output.csvast;

import java.util.Stack;

import astnodes.ASTNode;
import astnodes.expressions.BinaryExpression;
import astwalking.ASTNodeVisitor;

public class ASTToCSVConverter extends ASTNodeVisitor
{
	private final String SEPARATOR = "\t";
	Stack<Object> levelStack = new Stack<Object>();
	Object o = new Object();
	
	StringBuilder builder = new StringBuilder();
	
	public void reset()
	{
		builder = new StringBuilder();
	}

	public String getResult()
	{
		return builder.toString();
	} 
	
	public void visit(ASTNode node)
	{
		int level = levelStack.size();
		defaultOut(node, level);		
		levelStack.push(o);
		visitChildren(node);
		levelStack.pop();
	}
	
	private void defaultOut(ASTNode node, int level)
	{    	
		 if(node == null)
			 return;
		 
		 String nodeTypeName = node.getClass().getSimpleName();
		 String output = nodeTypeName + SEPARATOR +
				 node.getLocationString() + SEPARATOR + level;

		 String codeStr = null;
		  
		 if(node instanceof BinaryExpression && node.getChildCount() > 0)
			 codeStr = ((BinaryExpression) node).getOperator();
		 else if(node.getChildCount() == 0)
			 codeStr = node.getEscapedCodeStr();

		 // !NodeBlacklist.isBlackListed(nodeTypeName)
		 
		 if(codeStr != null)
			 output += SEPARATOR + codeStr;
	     else
	    	 output += SEPARATOR + "";
		 builder.append(output + "\n");
	 }
	 
}
