package outputModules.dummy;

import outputModules.OutModASTNodeVisitor;
import ast.declarations.ClassDefStatement;
import ast.functionDef.FunctionDef;
import ast.statements.IdentifierDeclStatement;
import databaseNodes.FunctionDatabaseNode;

public class DummyASTNodeVisitor extends OutModASTNodeVisitor
{
	public void visit(FunctionDef node)
	{
		// Called for each successfully parsed function
		// You can use the following code to generate all other
		// supported representations from the AST:

		try
		{
			FunctionDatabaseNode dbNode = new FunctionDatabaseNode();
			dbNode.initialize(node);
		}
		catch (RuntimeException ex)
		{

		}

	}

	public void visit(ClassDefStatement node)
	{
		// Called for each class/struct definition
	}

	public void visit(IdentifierDeclStatement node)
	{
		// Called for each global declaration
	}

	@Override
	protected void addEdgeFromClassToFunc(long dstNodeId, Long classId)
	{
		// TODO Auto-generated method stub

	}

}
