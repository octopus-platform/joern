package ast.php.functionDef;

import java.util.Iterator;

import inputModules.csv.PHPCSVNodeTypes;

public class Closure extends FunctionDef
{
	private ClosureUses closureUses = null;

	public ClosureUses getClosureUses()
	{
		return this.closureUses;
	}

	public void setClosureUses(ClosureUses closureUses)
	{
		this.closureUses = closureUses;
		super.addChild(closureUses);
	}

	@Override
	public String getFunctionSignature()
	{
		String retval = "function";
		retval += getParamListString();
		retval += getClosureUsesString();
		retval += getReturnTypeString();
		return retval;
	}

	private String getClosureUsesString() {
		if( null == getClosureUses())
			return "";
		String retval = " use (";
		Iterator<ClosureVar> it = getClosureUses().iterator();
		while( it.hasNext()) {
			ClosureVar use = it.next();
			retval += getClosureVarNameString(use);
			if( it.hasNext())
				retval += ", ";
		}
		retval += ")";
		return retval;
	}

	private String getClosureVarNameString(ClosureVar use) {
		String retval = "";
		if( use.getProperty(PHPCSVNodeTypes.FLAGS.getName()).contains(PHPCSVNodeTypes.FLAG_BY_REFERENCE))
			retval += "&";
		retval += "$";
		retval += use.getNameChild().getEscapedCodeStr();
		return retval;
	}
}
