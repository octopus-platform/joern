package ast.walking;

import java.util.Observable;
import java.util.Observer;
import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;

import ast.ASTNode;
import ast.ASTNodeBuilder;

public abstract class ASTWalker implements Observer
{

	public void update(Observable obj, Object arg)
	{
		ASTWalkerEvent event = (ASTWalkerEvent) arg;
		switch (event.id)
		{
			case BEGIN:
				begin();
				break;
			case START_OF_UNIT:
				startOfUnit(event.ctx, event.filename);
				break;
			case END_OF_UNIT:
				endOfUnit(event.ctx, event.filename);
				break;
			case PROCESS_ITEM:
				processItem(event.item, event.itemStack);
				break;
			case END:
				end();
				break;
		}
		;
	}

	public abstract void startOfUnit(ParserRuleContext ctx, String filename);

	public abstract void endOfUnit(ParserRuleContext ctx, String filename);

	public abstract void processItem(ASTNode node,
			Stack<ASTNodeBuilder> nodeStack);

	public void begin(){}
	public void end(){}

}
