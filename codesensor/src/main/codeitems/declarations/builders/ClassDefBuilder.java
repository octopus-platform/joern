package main.codeitems.declarations.builders;

import main.codeitems.CodeItemBuilder;
import main.codeitems.Name;
import main.codeitems.declarations.ClassDef;

import org.antlr.v4.runtime.ParserRuleContext;

import antlr.CodeSensorParser.Class_nameContext;

public class ClassDefBuilder extends CodeItemBuilder
{
	ClassDef thisItem;
	
	@Override
	public void createNew(ParserRuleContext ctx)
	{
		item = new ClassDef();
		thisItem = (ClassDef) item;
		thisItem.initializeFromContext(ctx);
	}

	public void setName(Class_nameContext ctx)
	{
		thisItem.name = new Name();
		thisItem.name.initializeFromContext(ctx);
	}
	
}
