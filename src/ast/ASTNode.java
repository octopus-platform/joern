package ast;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import languages.c.parsing.CodeLocation;
import languages.c.parsing.CodeLocationExtractor;

import org.antlr.v4.runtime.ParserRuleContext;

import parsing.ParseTreeUtils;
import ast.expressions.Expression;
import ast.walking.ASTNodeVisitor;

public class ASTNode
{
	private Map<String, String> properties;
	private CodeLocation location = new CodeLocation();

	private boolean isInCFG = false;

	protected LinkedList<ASTNode> children;
	protected int childNumber;

	public ASTNode()
	{
	}

	public ASTNode(ASTNode otherNode)
	{
		copyAttributes(otherNode);
		copyChildren(otherNode);
	}

	private void copyAttributes(ASTNode otherNode)
	{
		setCodeStr(otherNode.getCodeStr());
		location = otherNode.location;
		setChildNumber(otherNode.childNumber);
		if (otherNode.isInCFG())
			markAsCFGNode();
	}

	private void copyChildren(ASTNode otherNode)
	{
		if (otherNode.children != null)
		{
			for (ASTNode n : otherNode.children)
			{
				addChild(new ASTNode(n));
			}
		}
	}

	public void setProperty(String key, String val)
	{
		if (properties == null)
			properties = new HashMap<String, String>();

		properties.put(key, val);
	}

	public String getProperty(String key)
	{
		if (properties == null)
			return null;

		String retval = properties.get(key);
		if (retval == null)
			return null;
		return retval;
	}

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
		if (ctx == null)
			return;
		location = CodeLocationExtractor.extractFromContext(ctx);
		setCodeStr(escapeCodeStr(ParseTreeUtils.childTokenString(ctx)));

	}

	public void setCodeStr(String aCodeStr)
	{
		setProperty(ASTNodeProperties.CODE, aCodeStr);
	}

	public String getEscapedCodeStr()
	{
		return getCodeStr();
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
		return location.toString();
	}

	public CodeLocation getLocation()
	{
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

	protected String getCodeStr()
	{
		return getProperty(ASTNodeProperties.CODE);
	}

}
