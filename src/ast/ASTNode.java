package ast;

import java.util.LinkedList;

import org.antlr.v4.runtime.ParserRuleContext;

import parsing.ParseTreeUtils;
import ast.expressions.BinaryExpression;
import ast.expressions.Expression;
import ast.walking.ASTNodeVisitor;

public class ASTNode
{

	protected String codeStr = null;
	protected ParserRuleContext parseTreeNodeContext;
	private CodeLocation location = new CodeLocation();

	private boolean isInCFG = false;

	protected LinkedList<ASTNode> children;
	protected int childNumber;

	public void addChild(ASTNode node)
	{
		if (children == null)
			children = new LinkedList<ASTNode>();
		node.setChildNumber(children.size());
		children.add(node);
	}

	public int getChildCount()
	{
		if (children == null)
			return 0;
		return children.size();
	}

	public ASTNode getChild(int i)
	{
		if (children == null)
			return null;

		ASTNode retval;
		try
		{
			retval = children.get(i);
		}
		catch (IndexOutOfBoundsException ex)
		{
			return null;
		}
		return retval;
	}

	public ASTNode popLastChild()
	{
		return children.removeLast();
	}

	private void setChildNumber(int num)
	{
		childNumber = num;
	}

	public int getChildNumber()
	{
		return childNumber;
	}

	public void initializeFromContext(ParserRuleContext ctx)
	{
		parseTreeNodeContext = ctx;
	}

	public void setLocation(ParserRuleContext ctx)
	{
		if (ctx == null)
			return;
		location = new CodeLocation(ctx);
	}

	public void setCodeStr(String aCodeStr)
	{
		codeStr = aCodeStr;
	}

	public String getEscapedCodeStr()
	{
		if (codeStr != null)
			return codeStr;

		codeStr = escapeCodeStr(ParseTreeUtils
				.childTokenString(parseTreeNodeContext));
		return codeStr;
	}

	private String escapeCodeStr(String codeStr)
	{
		String retval = codeStr;
		retval = retval.replace("\n", "\\n");
		retval = retval.replace("\t", "\\t");
		return retval;
	}

	public String getLocationString()
	{
		setLocation(parseTreeNodeContext);
		return location.toString();
	}

	public CodeLocation getLocation()
	{
		setLocation(parseTreeNodeContext);
		return location;
	}

	
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}

	public boolean isLeaf()
	{
		return (children.size() == 0);
	}

	public String getTypeAsString()
	{
		return this.getClass().getSimpleName();
	}

	public void markAsCFGNode()
	{
		isInCFG = true;
	}

	public boolean isInCFG()
	{
		return isInCFG;
	}

	public String getOperatorCode()
	{
		if (Expression.class.isAssignableFrom(this.getClass()))
		{
			return ((Expression) this).getOperator();
		}
		return null;
	}

}
