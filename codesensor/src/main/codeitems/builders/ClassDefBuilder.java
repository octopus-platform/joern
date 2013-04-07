package main.codeitems.builders;

import main.codeitems.CodeItemBuilder;
import main.codeitems.Identifier;
import main.codeitems.declarations.ClassDef;
import main.codeitems.statements.CompoundItem;

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

	// TODO: merge the following two by introducing a wrapper
	public void setName(Class_nameContext ctx)
	{
		thisItem.name = new Identifier();
		thisItem.name.initializeFromContext(ctx);
	}

	public void setName(
			antlr.FineFunctionGrammarParser.Class_nameContext ctx)
	{
		thisItem.name = new Identifier();
		thisItem.name.initializeFromContext(ctx);
	}
	
	public void setContent(CompoundItem content)
	{
		thisItem.content = content;
	}

	
}
