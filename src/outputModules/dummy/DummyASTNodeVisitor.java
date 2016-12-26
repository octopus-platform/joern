package outputModules.dummy;

import ast.declarations.ClassDefStatement;
import ast.functionDef.FunctionDef;
import ast.statements.IdentifierDeclStatement;
import ast.walking.ASTNodeVisitor;
import databaseNodes.FunctionDatabaseNode;

public class DummyASTNodeVisitor extends ASTNodeVisitor
{
	public void visit(FunctionDef node)
	{
		// Called for each successfully parsed function
		// You can use the following code to generate all other
		// supported representations from the AST:
		
		try{ 
			FunctionDatabaseNode dbNode = new FunctionDatabaseNode();
			dbNode.initialize(node);
		}catch (RuntimeException ex){
			
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

}
