package parsing;

import java.util.Stack;


import org.antlr.v4.runtime.ParserRuleContext;

import astnodes.ASTNode;
import astnodes.ASTNodeBuilder;
import astnodes.statements.CompoundItem;
import astwalking.ASTWalker;

public class CompoundItemAssembler extends ASTWalker {

	private CompoundItem compoundItem;
	
	public CompoundItem getCompoundItem(){ return compoundItem; }
	
	@Override
	public void startOfUnit(ParserRuleContext ctx, String filename)
	{
		compoundItem = new CompoundItem();
	}

	@Override
	public void endOfUnit(ParserRuleContext ctx, String filename) {}

	@Override
	public void processItem(ASTNode item, Stack<ASTNodeBuilder> itemStack)
	{
		compoundItem.addStatement(item);
	}

	@Override public void begin(){}
	@Override public void end(){}

}
