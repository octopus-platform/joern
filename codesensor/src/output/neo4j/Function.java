package output.neo4j;

import cfg.ASTToCFGConverter;
import cfg.CFG;

import astnodes.ASTNode;
import astnodes.functionDef.FunctionDef;

public class Function
{
	FunctionDef astRoot;
	CFG cfg;
	
	ASTToCFGConverter astToCFG = new ASTToCFGConverter();
	
	Function(FunctionDef root)
	{
		astRoot = root;
		cfg = astToCFG.convert(root);
	}

	public ASTNode getASTRoot()
	{
		return astRoot;
	}

	public CFG getCFG()
	{
		return cfg;
	}

}
