package ast.walking;

import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;

import ast.ASTNode;
import ast.ASTNodeBuilder;

public class ASTWalkerEvent
{

	public enum eventID {
		BEGIN, START_OF_UNIT, END_OF_UNIT, PROCESS_ITEM, END
	};

	public ASTWalkerEvent(eventID aId)
	{
		id = aId;
	}

	public eventID id;
	public ParserRuleContext ctx;
	public String filename;
	public Stack<ASTNodeBuilder> itemStack;
	public ASTNode item;
}
