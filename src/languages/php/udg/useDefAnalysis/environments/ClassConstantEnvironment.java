package languages.php.udg.useDefAnalysis.environments;

import java.util.LinkedList;

import ast.expressions.Identifier;
import ast.expressions.Variable;
import udg.ASTNodeASTProvider;
import udg.ASTProvider;
import udg.useDefAnalysis.environments.UseDefEnvironment;

public class ClassConstantEnvironment extends UseDefEnvironment
{
	private String className;
	private String constName;
	
	// simply return the symbol corresponding to the class constant access,
	// which we determined in addChildSymbols as good as we could
	@Override
	public LinkedList<String> upstreamSymbols()
	{	
		LinkedList<String> retval = new LinkedList<String>();
		retval.add(this.className + "::" + this.constName);
		return retval;
	}
	
	// use a string such as "ClassName::constName" if the class name or the variable
	// containing the class name is known, or else just use "*::constName"
	public void addChildSymbols(LinkedList<String> childSymbols, ASTProvider child)
	{
		int childNum = child.getChildNumber();

		// try to determine symbol for class name
		if( 0 == childNum) {
			
			if( ((ASTNodeASTProvider)child).getASTNode() instanceof Identifier)
				this.className = ((Identifier)((ASTNodeASTProvider)child).getASTNode()).getNameChild().getEscapedCodeStr();
			else if ( ((ASTNodeASTProvider)child).getASTNode() instanceof Variable)
				this.className = ((Variable)((ASTNodeASTProvider)child).getASTNode()).getNameExpression().getEscapedCodeStr();
			else
				this.className = "*"; // neither an identifier nor a variable; we just don't know
		}
		
		// the constant name is always represented by a StringExpression node
		if( 1 == childNum)
			this.constName = child.getEscapedCodeStr();
	}
}
