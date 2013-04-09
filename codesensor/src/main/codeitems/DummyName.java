package main.codeitems;

import main.codeitems.expressions.Identifier;

public class DummyName extends Identifier
{
	public DummyName(){ super(); }
	
	public String getCodeStr()
	{
		return "<unnamed>";
	}
}
