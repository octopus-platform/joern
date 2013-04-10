package astnodes;

import astnodes.expressions.Identifier;

public class DummyName extends Identifier
{
	public DummyName(){ super(); }
	
	public String getCodeStr()
	{
		return "<unnamed>";
	}
}
