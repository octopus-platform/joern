package ast.php.functionDef;

import java.util.Iterator;

import ast.ASTNodeProperties;
import ast.expressions.Identifier;
import ast.functionDef.FunctionDef;
import ast.functionDef.Parameter;
import ast.php.expressions.PHPTypeHint;
import tools.phpast2cfg.PHPCSVNodeTypes;

public class PHPFunctionDef extends FunctionDef
{
	protected Identifier returnType = null;

	public String getName() {
		return getProperty(ASTNodeProperties.NAME);
	}
	
	public void setName(String name) {
		setProperty(ASTNodeProperties.NAME, name);
	}
	
	public String getDocComment() {
		return getProperty(ASTNodeProperties.DOCCOMMENT);
	}
	
	public void setDocComment(String doccomment) {
		setProperty(ASTNodeProperties.DOCCOMMENT, doccomment);
	}

	public Identifier getReturnType()
	{
		return this.returnType;
	}
	
	public void setReturnType(Identifier returnType)
	{
		this.returnType = returnType;
		super.addChild(returnType);
	}
	
	@Override
	public String getFunctionSignature()
	{
		String retval = "function " + getName();
		retval += getParamListString();
		retval += getReturnTypeString();
		return retval;
	}

	protected String getParamListString() {
		
		String retval = "(";
		Iterator<Parameter> it = getParameterList().iterator();
		while( it.hasNext()) {
			PHPParameter phpparam = (PHPParameter)it.next();
			retval += getParamTypeString(phpparam);
			retval += " ";
			retval += getParamNameString(phpparam);
			if( it.hasNext())
				retval += ", ";
		}
		retval += ")";
		return retval;
	}

	private String getParamTypeString(PHPParameter phpparam) {
		String retval = "";
		if( null != phpparam.getType()) {
			if( phpparam.getType() instanceof PHPTypeHint) {
				switch( phpparam.getType().getFlags()) {
				case PHPCSVNodeTypes.FLAG_TYPE_ARRAY:
					retval += "array"; break;
				case PHPCSVNodeTypes.FLAG_TYPE_CALLABLE:
					retval += "callable"; break;
				default:
					retval += "UNKNOWN";
				}
			}
			else
				retval += phpparam.getType().getNameChild().getEscapedCodeStr();
		}
		else
			retval += "mixed";
		return retval;
	}

	private String getParamNameString(PHPParameter phpparam) {
		String retval = "";
		if( phpparam.getProperty(PHPCSVNodeTypes.FLAGS.getName()).contains(PHPCSVNodeTypes.FLAG_PARAM_REF))
			retval += "&";
		if( phpparam.getProperty(PHPCSVNodeTypes.FLAGS.getName()).contains(PHPCSVNodeTypes.FLAG_PARAM_VARIADIC))
			retval += "...";
		retval += "$";
		retval += phpparam.getNameChild().getEscapedCodeStr();
		return retval;
	}
	
	protected String getReturnTypeString() {
		String retval = "";
		if( null != getReturnType()) {
			retval += " : ";
			if( getReturnType() instanceof PHPTypeHint) {
				switch( getReturnType().getFlags()) {
				case PHPCSVNodeTypes.FLAG_TYPE_ARRAY:
					retval += "array"; break;
				case PHPCSVNodeTypes.FLAG_TYPE_CALLABLE:
					retval += "callable"; break;
				default:
					retval += "UNKNOWN";
				}
			}
			else
				retval += getReturnType().getNameChild().getEscapedCodeStr();
		}
		return retval;
	}
	
	@Override
	public Identifier getIdentifier()
	{
		throw new RuntimeException("An Identifier is not used for PHP function names, use getName() instead!");
	}
}
