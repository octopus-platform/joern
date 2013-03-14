package main.codeitems.declarations;

import org.antlr.v4.runtime.ParserRuleContext;

import antlr.CodeSensorParser.Class_nameContext;

import main.codeitems.CodeItemBuilder;
import main.codeitems.Name;

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
