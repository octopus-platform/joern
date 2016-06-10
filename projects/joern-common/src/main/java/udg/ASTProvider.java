package udg;

public abstract class ASTProvider
{

	public abstract String getTypeAsString();

	public abstract ASTProvider getChild(int i);

	public abstract int getChildCount();

	public abstract String getEscapedCodeStr();

	public abstract int getChildNumber();

	public abstract String getOperatorCode();

}
