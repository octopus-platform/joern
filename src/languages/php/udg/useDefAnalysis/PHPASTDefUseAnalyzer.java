package languages.php.udg.useDefAnalysis;

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
				return null; // TODO continue here
				
			case "Variable":
				return null; // TODO create "leaf" environment to get actual symbol name

			default:
				return new UseDefEnvironment();
		}
	}
}
