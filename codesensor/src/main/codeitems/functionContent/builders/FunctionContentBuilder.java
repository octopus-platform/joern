package main.codeitems.functionContent.builders;

import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;

import main.codeitems.CodeItem;
import main.codeitems.CodeItemBuilder;
import main.codeitems.declarations.IdentifierDecl;
import main.codeitems.functionContent.CompoundItem;
import main.codeitems.functionContent.IdentifierDeclStatement;

public class FunctionContentBuilder extends CodeItemBuilder
{
	Stack<CodeItem> itemStack = new Stack<CodeItem>();
	CompoundItem rootItem;
	
	@Override
	public void createNew(ParserRuleContext ctx)
	{
		item = new CompoundItem();
		rootItem = (CompoundItem) item;
		item.initializeFromContext(ctx);
		itemStack.push(rootItem);
	}

	public void addLocalDecl(IdentifierDecl decl)
	{
		IdentifierDeclStatement declStmt = (IdentifierDeclStatement) itemStack.peek();
		declStmt.addDeclaration(decl);
	}

	public void enterDeclByType()
	{
		replaceTopOfStack(new IdentifierDeclStatement());
	}
	
	protected void replaceTopOfStack(CodeItem item)
	{
		itemStack.pop();
		itemStack.push(item);
	}
	
}
