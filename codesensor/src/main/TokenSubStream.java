package main;

import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenSource;


public class TokenSubStream extends BufferedTokenStream
{
	protected int stopIndex = -1;
	protected int lastStartIndex = -1;
	
	public TokenSubStream(TokenSource tokenSource)
	{
		super(tokenSource);
	}
		
	public void restrict(int aStartIndex, int aStopIndex)
	{
		lastStartIndex = index();
		stopIndex = aStopIndex;
		seek(aStartIndex);
	}
	
	public void resetRestriction()
	{
		stopIndex = -1;
		seek(lastStartIndex);
	}
	
	@Override
	 public Token LT(int k)
	 {
		lazyInit();
		if ( k==0 ) return null;
		if ( k < 0 ) return LB(-k);
		
		int i = p + k - 1;
		sync(i);
		
		if ( i >= tokens.size() || (stopIndex != -1 && i >= stopIndex)) { // return EOF token
			// EOF must be last token
			return tokens.get(tokens.size()-1);
	    }
	    return tokens.get(i);	
	 }
	
}
