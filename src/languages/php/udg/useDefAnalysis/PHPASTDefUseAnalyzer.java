package languages.php.udg.useDefAnalysis;

import languages.php.udg.useDefAnalysis.environments.AssignmentEnvironment;
import languages.php.udg.useDefAnalysis.environments.AssignmentWithOpEnvironment;
import languages.php.udg.useDefAnalysis.environments.CatchEnvironment;
import languages.php.udg.useDefAnalysis.environments.ClassConstantEnvironment;
import languages.php.udg.useDefAnalysis.environments.ClosureVarEnvironment;
import languages.php.udg.useDefAnalysis.environments.ConstantEnvironment;
import languages.php.udg.useDefAnalysis.environments.FunctionDefEnvironment;
import languages.php.udg.useDefAnalysis.environments.IncDecEnvironment;
import languages.php.udg.useDefAnalysis.environments.ParameterEnvironment;
import languages.php.udg.useDefAnalysis.environments.PropertyEnvironment;
import languages.php.udg.useDefAnalysis.environments.StaticPropertyEnvironment;
import languages.php.udg.useDefAnalysis.environments.FieldDeclarationEnvironment;
import languages.php.udg.useDefAnalysis.environments.VariableEnvironment;
import udg.ASTProvider;
import udg.useDefAnalysis.ASTDefUseAnalyzer;
import udg.useDefAnalysis.environments.EmitDefEnvironment;
import udg.useDefAnalysis.environments.EmitUseEnvironment;
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
			// environments that need to "cleverly" decide which of its children symbols
			// are DEFs and which are USEs
		
			case "AssignmentExpression":
			// note that we currently do not handle any kind of aliasing, so currently
			// an assignment by reference behaves like an assignment
			case "PHPAssignmentByRefExpression":
				return new AssignmentEnvironment();
				
			case "AssignmentWithOpExpression":
				return new AssignmentWithOpEnvironment();
				
			case "StaticVariableDeclaration":
			case "PropertyElement":
			case "ConstantElement":
				return new FieldDeclarationEnvironment();
				
				
			// environments that emit DEFs *and* USEs for all their children symbols
				
			case "PreIncOperationExpression":
			case "PreDecOperationExpression":
			case "PostIncOperationExpression":
			case "PostDecOperationExpression":
				return new IncDecEnvironment();
				
				
			// environments that emit USEs for all their children symbols
				
			case "PHPEmptyExpression":
			case "PHPIssetExpression":
			case "PHPShellExecExpression":
			case "PHPCloneExpression":
			case "PHPExitExpression":
			case "PHPPrintExpression":
			case "PHPIncludeOrEvalExpression":
			case "PHPYieldFromExpression":
			case "ReturnStatement":
			case "PHPEchoStatement":
			case "ThrowStatement":
			case "PHPYieldExpression":
			// All four call environments (see below) also *only* emit USEs for
			// all their symbols: Although variables may optionally be passed
			// by reference in function calls, this is not visible from the call
			// site; rather, this is exclusively determined by the function definition,
			// which is unknown in the call environment. Therefore we can only:
			// (1) assume DEFs *and* USEs for all variables in a function call (over-approximation -> more false positives)
			// (2) assume *only* USEs for all variables in a function call (under-approximation -> more false negatives)
			// Here we go for (2).
			case "CallExpression":
			case "NewExpression":
			case "MethodCallExpression":
			case "StaticCallExpression":
				return new EmitUseEnvironment();
				
				
			// environments that emit DEFs for all their children symbols
				
			case "PHPGlobalStatement":
			case "PHPUnsetStatement":
				return new EmitDefEnvironment();
			// A catch statement also only emits a DEF for the variable holding the exception,
			// but we cannot use the EmitDefEnvironment because this variable is not contained
			// within a Variable (AST_VAR) node as usual. This has been changed in version 20
			// of php-ast, see https://github.com/nikic/php-ast#20-current
			// (thus, once we update to version 20, we can use an EmitDefEnvironment for CatchStatement)
			case "CatchStatement":
				return new CatchEnvironment();
			case "PHPFunctionDef":
			case "Closure":
			case "Method":
				return new FunctionDefEnvironment();
				
			
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

			case "PHPParameter":
				return new ParameterEnvironment();
				
				
			// default environment
				
			default:
				return new UseDefEnvironment();
		}
	}
}
