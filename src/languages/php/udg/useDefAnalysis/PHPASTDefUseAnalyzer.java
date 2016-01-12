package languages.php.udg.useDefAnalysis;

import languages.php.udg.useDefAnalysis.environments.AssignmentEnvironment;
import languages.php.udg.useDefAnalysis.environments.ClassConstantEnvironment;
import languages.php.udg.useDefAnalysis.environments.ClosureVarEnvironment;
import languages.php.udg.useDefAnalysis.environments.ConstantEnvironment;
import languages.php.udg.useDefAnalysis.environments.IncDecEnvironment;
import languages.php.udg.useDefAnalysis.environments.PropertyEnvironment;
import languages.php.udg.useDefAnalysis.environments.StaticPropertyEnvironment;
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
				
			case "PreIncOperationExpression":
			case "PreDecOperationExpression":
			case "PostIncOperationExpression":
			case "PostDecOperationExpression":
				return new IncDecEnvironment();
				
			
			// "base" environments which add symbols to be reported upstream:
			// closure variables, variables, constants, properties, static properties and class constants
			
			case "ClosureVar":
				return new ClosureVarEnvironment();
				
			case "Variable":
				return new VariableEnvironment();
				
			case "Constant":
				return new ConstantEnvironment();

			case "PropertyExpression":
				return new PropertyEnvironment();
				
			case "StaticPropertyExpression":
				return new StaticPropertyEnvironment();
				
			case "ClassConstantExpression":
				return new ClassConstantEnvironment();


			// default environment
				
			default:
				return new UseDefEnvironment();
		}
	}
}
