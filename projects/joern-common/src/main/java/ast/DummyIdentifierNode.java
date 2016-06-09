package ast;

import ast.expressions.Identifier;

public class DummyIdentifierNode extends Identifier
{
	public DummyIdentifierNode()
	{
		super();
	}

	public String getEscapedCodeStr()
	{
		return "<unnamed>";
	}
}
