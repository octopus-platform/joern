package udg.php.useDefAnalysis.environments;

import java.util.Collection;
import java.util.LinkedList;

import ast.expressions.Identifier;
import ast.expressions.StringExpression;
import ast.expressions.Variable;
import udg.ASTNodeASTProvider;
import udg.ASTProvider;
import udg.useDefAnalysis.environments.UseDefEnvironment;
import udg.useDefGraph.UseOrDef;

public class StaticPropertyEnvironment extends UseDefEnvironment
{
	private String className;
	private String propName;
	
	private boolean emitUse = false;
	
	// simply return the symbol corresponding to the static property access,
	// which we determined in addChildSymbols as good as we could
	@Override
	public LinkedList<String> upstreamSymbols()
	{	
		LinkedList<String> retval = new LinkedList<String>();
		retval.add(this.className + "::" + this.propName);
		return retval;
	}
	
	// add a string such as "ClassName::fieldName" if both are known, or try
	// to use a "best try" approximation in the style of "*::fieldName" or
	// "ClassName::*" if we cannot determine them. If we cannot determine
	// either, give up and don't generate symbols (instead of generating, e.g.,
	// "*::*").
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
		
		// try to determine symbol for property name
		if( 1 == childNum) {
			if( ((ASTNodeASTProvider)child).getASTNode() instanceof StringExpression)
				this.propName = child.getEscapedCodeStr();
			else if ( ((ASTNodeASTProvider)child).getASTNode() instanceof Variable)
				this.propName = ((Variable)((ASTNodeASTProvider)child).getASTNode()).getNameExpression().getEscapedCodeStr();
			else
				this.propName = "*"; // neither a string nor a variable; we just don't know
		}
	}
	
	public Collection<UseOrDef> useOrDefsFromSymbols(ASTProvider child)
	{
		// only add USE for a standalone static property once we visited all children
		if( this.emitUse && null != this.className && null != this.propName) {
			LinkedList<UseOrDef> retval = createUsesForAllSymbols(upstreamSymbols());
			return retval;
		}
		else
			return super.useOrDefsFromSymbols(child);
	}
	
	public void setEmitUse( boolean emitUse) {
		this.emitUse = emitUse;
	}
}
