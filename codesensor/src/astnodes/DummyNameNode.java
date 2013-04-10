package astnodes;

import astnodes.expressions.Identifier;

public class DummyNameNode extends Identifier
{
	public DummyNameNode(){ super(); }
	
	public String getCodeStr()
	{
		return "<unnamed>";
	}
}
