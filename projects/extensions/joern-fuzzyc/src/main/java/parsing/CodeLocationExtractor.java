package parsing;

import org.antlr.v4.runtime.ParserRuleContext;

import ast.CodeLocation;

public class CodeLocationExtractor
{

	public static CodeLocation extractFromContext(ParserRuleContext ctx)
	{
		CodeLocation location = new CodeLocation();

		location.startLine = ctx.start.getLine();
		location.startPos = ctx.start.getCharPositionInLine();
		location.startIndex = ctx.start.getStartIndex();
		if (ctx.stop != null)
			location.stopIndex = ctx.stop.getStopIndex();
		else
			location.stopIndex = CodeLocation.NOT_SET;

		return location;
	}
}
