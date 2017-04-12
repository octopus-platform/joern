package ast.php.functionDef;

import java.util.Iterator;

import ast.ASTNodeProperties;
import ast.expressions.Identifier;
import ast.functionDef.FunctionDefBase;
import ast.functionDef.ParameterBase;
import ast.php.expressions.TypeHint;
import inputModules.csv.PHPCSVNodeTypes;

public class FunctionDef extends FunctionDefBase
{
	protected Identifier returnType = null;

	public String getEnclosingNamespace() {
		return getProperty(ASTNodeProperties.NAMESPACE);
	}

	public void setEnclosingNamespace(String namespace) {
		setProperty(ASTNodeProperties.NAMESPACE, namespace);
	}

	@Override
	public String getName() {
		return getProperty(ASTNodeProperties.CODE);
	}

	public void setName(String name) {
		setProperty(ASTNodeProperties.CODE, name);
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
		String retval = "";
		if( getProperty(PHPCSVNodeTypes.FLAGS.getName()).contains(PHPCSVNodeTypes.FLAG_RETURNS_REF))
			retval += "&";
		retval += "function " + getName();
		retval += getParamListString();
		retval += getReturnTypeString();
		return retval;
	}

	protected String getParamListString() {

		// this should not happen:
		if( null == getParameterList())
			return "(ERROR)";

		String retval = "(";
		Iterator<ParameterBase> it = getParameterList().iterator();
		while( it.hasNext()) {
			Parameter phpparam = (Parameter)it.next();
			retval += getParamTypeString(phpparam);
			retval += " ";
			retval += getParamNameString(phpparam);
			if( it.hasNext())
				retval += ", ";
		}
		retval += ")";
		return retval;
	}

	private String getParamTypeString(Parameter phpparam) {
		String retval = "";
		if( null != phpparam.getType()) {
			if( phpparam.getType() instanceof TypeHint) {
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

	private String getParamNameString(Parameter phpparam) {
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
			if( getReturnType() instanceof TypeHint) {
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

	public Identifier getIdentifier() {
		throw new RuntimeException("An Identifier is not used for PHP function names, use getName() instead!");
	}
	
	@Override
	public String getEscapedCodeStr() {
		return getCodeStr();
	}
}
