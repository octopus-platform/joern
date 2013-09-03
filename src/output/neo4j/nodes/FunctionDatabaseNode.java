package output.neo4j.nodes;

import java.util.HashMap;
import java.util.Map;

import astnodes.ASTNode;
import astnodes.functionDef.FunctionDef;
import cfg.ASTToCFGConverter;
import cfg.CFG;

public class FunctionDatabaseNode extends DatabaseNode
{
	FunctionDef astRoot;
	CFG cfg;
	
	ASTPseudoNode astPseudoNode;
	CFGPseudoNode cfgPseudoNode;
	
	String signature;
	String name;
	
	ASTToCFGConverter astToCFG = new ASTToCFGConverter();
	
	@Override
	public void initialize(Object node)
	{
		astRoot = (FunctionDef) node;
		cfg = astToCFG.convert(astRoot);
		setSignature(astRoot);
		
		createPseudoNodes();
	}

	@Override public Map<String, Object> createProperties()
	{
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("type", "Function");
		
		properties.put("signature", this.getSignature());
		properties.put("location", this.getLocation());
		properties.put("functionName", this.getName());
		return properties;
	}
	
	public String getName()
	{
		return astRoot.name.getEscapedCodeStr();
	}

	public ASTNode getASTRoot()
	{
		return astRoot;
	}

	public CFG getCFG()
	{
		return cfg;
	}
	
	public String getLocation()
	{
		return astRoot.getLocationString();
	}

	public String getSignature()
	{
		return signature;
	}
	
	public ASTPseudoNode getASTPseudoNode()
	{
		return astPseudoNode;
	}
	
	public CFGPseudoNode getCFGPseudoNode()
	{
		return cfgPseudoNode;
	}

	private void createPseudoNodes()
	{
		createASTPseudoNode();
		createCFGPseudoNode();
	}

	private void setSignature(FunctionDef node)
	{
		signature = node.getFunctionSignature();
	}
	
	private void createASTPseudoNode()
	{
		astPseudoNode = new ASTPseudoNode();
		astPseudoNode.initialize(null);
	}
	
	private void createCFGPseudoNode()
	{
		cfgPseudoNode = new CFGPseudoNode();
		cfgPseudoNode.initialize(null);
	}
	
}
