package astnodes.builders;

import org.antlr.v4.runtime.ParserRuleContext;

import antlr.ModuleParser.Class_nameContext;
import astnodes.ASTNodeBuilder;
import astnodes.declarations.ClassDefStatement;
import astnodes.expressions.Identifier;
import astnodes.statements.CompoundStatement;

public class ClassDefBuilder extends ASTNodeBuilder
{
	ClassDefStatement thisItem;

	@Override
	public void createNew(ParserRuleContext ctx)
	{
		item = new ClassDefStatement();
		thisItem = (ClassDefStatement) item;
		thisItem.initializeFromContext(ctx);
	}

	// TODO: merge the following two by introducing a wrapper
	public void setName(Class_nameContext ctx)
	{
		thisItem.name = new Identifier();
		thisItem.name.initializeFromContext(ctx);
	}

	public void setName(antlr.FunctionParser.Class_nameContext ctx)
	{
		thisItem.name = new Identifier();
		thisItem.name.initializeFromContext(ctx);
	}

	public void setContent(CompoundStatement content)
	{
		thisItem.content = content;
	}

}
