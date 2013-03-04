package main;
import org.antlr.v4.runtime.ParserRuleContext;


public class CodeLocation {
	
	public CodeLocation(ParserRuleContext ctx)
	{
		startLine = ctx.start.getLine();
		startPos = ctx.start.getCharPositionInLine();
		startIndex = ctx.start.getStartIndex();
		if(ctx.stop != null)
			stopIndex = ctx.stop.getStopIndex();
		else
			stopIndex = -1;
	}

	public int startLine;
	public int startPos;
	public int startIndex;
	public int stopIndex;
	
}
