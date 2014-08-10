package parsing;

import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;

import ast.ASTNode;
import ast.ASTNodeBuilder;
import ast.statements.CompoundStatement;
import ast.walking.ASTWalker;

public class CompoundItemAssembler extends ASTWalker
{

	private CompoundStatement compoundItem;

	public CompoundStatement getCompoundItem()
	{
		return compoundItem;
	}

	@Override
	public void startOfUnit(ParserRuleContext ctx, String filename)
	{
		compoundItem = new CompoundStatement();
	}

	@Override
	public void endOfUnit(ParserRuleContext ctx, String filename)
	{
	}

	@Override
	public void processItem(ASTNode item, Stack<ASTNodeBuilder> itemStack)
	{
		compoundItem.addStatement(item);
	}


}
