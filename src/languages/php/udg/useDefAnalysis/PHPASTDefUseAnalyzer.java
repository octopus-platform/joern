package languages.php.udg.useDefAnalysis;

import languages.php.udg.useDefAnalysis.environments.AssignmentEnvironment;
import languages.php.udg.useDefAnalysis.environments.VariableEnvironment;
import udg.ASTProvider;
import udg.useDefAnalysis.ASTDefUseAnalyzer;
import udg.useDefAnalysis.environments.UseDefEnvironment;

/**
 * PHP-specific implementation of ASTDefUseAnalyzer.
 */
public class PHPASTDefUseAnalyzer extends ASTDefUseAnalyzer
{
	
	/**
	 * Creates a UseDefEnvironment for a given AST node.
	 */
	protected UseDefEnvironment createUseDefEnvironment(ASTProvider astProvider)
	{
		String nodeType = astProvider.getTypeAsString();

		switch (nodeType)
		{
			case "AssignmentExpression":
				return new AssignmentEnvironment();
				
			case "Variable":
				return new VariableEnvironment();

			default:
				return new UseDefEnvironment();
		}
	}
}
