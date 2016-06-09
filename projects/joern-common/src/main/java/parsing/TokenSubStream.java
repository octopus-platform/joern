package parsing;

import java.util.Stack;

import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenSource;

public class TokenSubStream extends BufferedTokenStream
{
	protected int stopIndex = -1;
	protected int startIndex = 0;

	protected Stack<Integer> stopIndexStack = new Stack<Integer>();
	protected Stack<Integer> startIndexStack = new Stack<Integer>();

	public TokenSubStream(TokenSource tokenSource)
	{
		super(tokenSource);
	}

	public void restrict(int aStartIndex, int aStopIndex)
	{
		startIndexStack.push(index());
		stopIndexStack.push(stopIndex);

		startIndex = aStartIndex;
		stopIndex = aStopIndex;
		seek(aStartIndex);
	}

	public void resetRestriction()
	{
		stopIndex = stopIndexStack.pop();
		startIndex = startIndexStack.pop();
		seek(startIndex);
	}

	@Override
	public void reset()
	{
		seek(startIndex);
	}

	@Override
	public Token LT(int k)
	{
		lazyInit();
		if (k == 0)
			return null;
		if (k < 0)
			return LB(-k);

		int i = p + k - 1;
		sync(i);

		if (i >= tokens.size() || (stopIndex != -1 && i >= stopIndex))
		{ // return EOF token
			// EOF must be last token
			return (Token) tokens.get(tokens.size() - 1);
		}
		return (Token) tokens.get(i);
	}

}
