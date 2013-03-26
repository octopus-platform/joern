package main.codeitems;

import main.codeitems.declarations.ClassDef;
import main.codeitems.function.FunctionDef;

public interface CodeItemVisitor
{
	public void visit(CodeItem item);
	public void visit(FunctionDef item);
	public void visit(ClassDef item);
}
