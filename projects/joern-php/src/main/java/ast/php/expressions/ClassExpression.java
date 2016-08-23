package ast.php.expressions;

import ast.expressions.Expression;
import ast.php.declarations.ClassDef;

public class ClassExpression extends Expression
{
	private ClassDef classDef = null;

	public ClassDef getClassDef()
	{
		return this.classDef;
	}
	
	public void setClassDef(ClassDef classDef)
	{	
		this.classDef = classDef;
		super.addChild(classDef);
	}
	
	// TODO probably, more methods than only getEscapedCodeStr() should "forward" the call
	// to the PHPClassDef. For instance, calls to obtain the node id, etc. Test this!
	public String getEscapedCodeStr() {
		return this.classDef.getEscapedCodeStr();
	}

}
