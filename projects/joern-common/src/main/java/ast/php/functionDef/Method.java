package ast.php.functionDef;

import ast.ASTNodeProperties;

public class Method extends PHPFunctionDef
{
	public String getEnclosingClass() {
		return getProperty(ASTNodeProperties.CLASSNAME);
	}
	
	public void setEnclosingClass(String classname) {
		setProperty(ASTNodeProperties.CLASSNAME, classname);
	}
}
