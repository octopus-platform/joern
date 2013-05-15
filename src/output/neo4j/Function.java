package output.neo4j;

import astnodes.ASTNode;
import astnodes.functionDef.FunctionDef;
import cfg.ASTToCFGConverter;
import cfg.CFG;

public class Function
{
	FunctionDef astRoot;
	CFG cfg;
	String filename;
	String signature;
	String name;
	
	ASTToCFGConverter astToCFG = new ASTToCFGConverter();
	
	Function(FunctionDef root)
	{
		astRoot = root;
		cfg = astToCFG.convert(root);
	
		setSignature(astRoot);
	}

	public String getName()
	{
		return astRoot.name.getEscapedCodeStr();
	}

	private void setSignature(FunctionDef node)
	{
		signature = node.getFunctionSignature();
	}

	public ASTNode getASTRoot()
	{
		return astRoot;
	}

	public CFG getCFG()
	{
		return cfg;
	}

	public void setFilename(String aFilename)
	{
		filename = aFilename;
	}

	public String getFilename()
	{
		return filename;
	}
	
	public String getLocation()
	{
		return astRoot.getLocationString();
	}

	public String getSignature()
	{
		return signature;
	}
}
