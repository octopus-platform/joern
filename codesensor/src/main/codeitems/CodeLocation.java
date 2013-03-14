package main.codeitems;
import org.antlr.v4.runtime.ParserRuleContext;

public class CodeLocation {

	public int startLine;
	public int startPos;
	public int startIndex;
	public int stopIndex;
	
	final private int NOT_SET = -1;
	
	public CodeLocation(ParserRuleContext ctx)
	{
		initializeFromContext(ctx);
	}

	private void initializeFromContext(ParserRuleContext ctx)
	{
		startLine = ctx.start.getLine();
		startPos = ctx.start.getCharPositionInLine();
		startIndex = ctx.start.getStartIndex();
		if(ctx.stop != null)
			stopIndex = ctx.stop.getStopIndex();
		else
			stopIndex = NOT_SET;
	}

}
