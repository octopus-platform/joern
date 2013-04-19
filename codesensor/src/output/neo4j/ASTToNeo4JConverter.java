package output.neo4j;

import cfg.ASTToCFGConverter;
import cfg.CFG;
import astnodes.functionDef.FunctionDef;
import astwalking.ASTNodeVisitor;

public class ASTToNeo4JConverter extends ASTNodeVisitor
{

	Neo4JDatabase database = new Neo4JDatabase();
	
	
	public void setIndexDirectoryName(String dirName)
	{
		database.setIndexDirectoryName(dirName);
	}
	
	public void visit(FunctionDef node)
	{
		ASTToCFGConverter astToCFG = new ASTToCFGConverter();
		
		try{
			CFG cfg = astToCFG.convert(node);
		}catch(RuntimeException ex)
		{
			ex.printStackTrace();
			System.err.println("Error creating CFG from AST for function: " + node.name.getCodeStr());
		}
	}

	public void begin()
	{
		database.start();
	}

	public void end()
	{
		// TODO Auto-generated method stub	
	}

	
}
