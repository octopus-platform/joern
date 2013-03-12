package main;


import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenSource;


public class TokenSubStream extends CommonTokenStream
{
	protected int stopIndex = -1;
	
	public TokenSubStream(TokenSource tokenSource)
	{
		super(tokenSource);
	}
	
	void setStopIndex(int aStartIndex, int aStopIndex)
	{
		stopIndex = aStopIndex;
		seek(aStartIndex);
	}
	
	@Override
	protected int adjustSeekIndex(int i)
	{
		if(stopIndex == -1 || i < stopIndex)
			return nextTokenOnChannel(i, channel);
		else
			return EOF;
	}

}
