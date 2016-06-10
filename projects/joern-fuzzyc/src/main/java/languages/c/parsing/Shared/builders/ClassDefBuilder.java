package languages.c.parsing.Shared.builders;

import org.antlr.v4.runtime.ParserRuleContext;

import ast.ASTNodeBuilder;
import ast.declarations.ClassDefStatement;
import ast.expressions.Identifier;
import ast.logical.statements.CompoundStatement;
import languages.c.antlr.ModuleParser.Class_nameContext;
import languages.c.parsing.ASTNodeFactory;

public class ClassDefBuilder extends ASTNodeBuilder
{
	ClassDefStatement thisItem;

	@Override
	public void createNew(ParserRuleContext ctx)
	{
		item = new ClassDefStatement();
		thisItem = (ClassDefStatement) item;
		ASTNodeFactory.initializeFromContext(thisItem, ctx);
	}

	// TODO: merge the following two by introducing a wrapper
	public void setName(Class_nameContext ctx)
	{
		thisItem.identifier = new Identifier();
		ASTNodeFactory.initializeFromContext(thisItem.identifier, ctx);
	}

	public void setName(languages.c.antlr.FunctionParser.Class_nameContext ctx)
	{
		thisItem.identifier = new Identifier();
		ASTNodeFactory.initializeFromContext(thisItem.identifier, ctx);
	}

	public void setContent(CompoundStatement content)
	{
		thisItem.content = content;
	}

}
