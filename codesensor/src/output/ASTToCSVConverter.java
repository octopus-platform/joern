package output;

import astnodes.ASTNode;
import astwalking.ASTNodeVisitor;

public class ASTToCSVConverter extends ASTNodeVisitor
{
	private final String SEPARATOR = "\t";
	
	public void visit(ASTNode item)
	{
		visitChildren(item);
	}
	
	private void defaultOut(ASTNode node, int level)
	{    	
		 if(node == null) return;
		 
		 String output = node.getNodeTypeName() + SEPARATOR;
		 output += node.getLocationString() + SEPARATOR + level;
		 String codeStr = node.getCodeStr();
		 if(codeStr != null)
			 output += SEPARATOR + escapeCodeStr(codeStr);
	     else
	    	 output += SEPARATOR + "";
		 System.out.println(output);
	 }
	 
	 private String escapeCodeStr(String codeStr)
	 {
		 String retval = codeStr;
		 retval = retval.replace("\n", "\\n");
		 retval = retval.replace("\t", "\\t");
		 return retval;
	 }
}
