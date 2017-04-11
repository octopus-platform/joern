package udg.php.useDefAnalysis;

import java.util.Collection;

import ast.expressions.*;
import udg.ASTProvider;
import udg.php.useDefAnalysis.environments.ArrayIndexingEnvironment;
import udg.php.useDefAnalysis.environments.AssignmentEnvironment;
import udg.php.useDefAnalysis.environments.AssignmentWithOpEnvironment;
import udg.php.useDefAnalysis.environments.CatchEnvironment;
import udg.php.useDefAnalysis.environments.ClassConstantEnvironment;
import udg.php.useDefAnalysis.environments.ClosureVarEnvironment;
import udg.php.useDefAnalysis.environments.ConstantEnvironment;
import udg.useDefAnalysis.ASTDefUseAnalyzer;
import udg.useDefAnalysis.environments.EmitDefEnvironment;
import udg.useDefAnalysis.environments.EmitUseEnvironment;
import udg.php.useDefAnalysis.environments.FieldDeclarationEnvironment;
import udg.php.useDefAnalysis.environments.ForEachEnvironment;
import udg.php.useDefAnalysis.environments.IncDecEnvironment;
import udg.php.useDefAnalysis.environments.ParameterEnvironment;
import udg.php.useDefAnalysis.environments.PropertyEnvironment;
import udg.php.useDefAnalysis.environments.StaticPropertyEnvironment;
import udg.php.useDefAnalysis.environments.StaticVariableDeclarationEnvironment;
import udg.php.useDefAnalysis.environments.SwitchEnvironment;
import udg.useDefAnalysis.environments.UseDefEnvironment;
import udg.php.useDefAnalysis.environments.VariableEnvironment;
import udg.useDefGraph.UseOrDef;

/**
 * PHP-specific implementation of ASTDefUseAnalyzer.
 */
public class PHPASTDefUseAnalyzer extends ASTDefUseAnalyzer
{
	// Determines whether we want to analyze a predicate or a normal statement
	private boolean analyzingPredicate = false;

	/**
	 * Analyze an AST as usual. In case analyzeAST(ASTProvider) was called
	 * on a standalone variable/constant/property, assume we are analyzing
	 * a predicate and set analyzingPredicate to true for this analysis.
	 */
	@Override
	public Collection<UseOrDef> analyzeAST(ASTProvider astProvider)
	{

		String nodeType = astProvider.getTypeAsString();
		if( nodeType.equals(Variable.class.getSimpleName()) ||
			nodeType.equals(Constant.class.getSimpleName()) ||
			nodeType.equals(PropertyExpression.class.getSimpleName()) ||
			nodeType.equals(StaticPropertyExpression.class.getSimpleName()) ||
			nodeType.equals(ClassConstantExpression.class.getSimpleName()) ||
			nodeType.equals(ArrayIndexing.class.getSimpleName()))
			this.analyzingPredicate = true;

		Collection<UseOrDef> retval = super.analyzeAST(astProvider);
		this.analyzingPredicate = false;

		return retval;
	}

	/**
	 * Creates a UseDefEnvironment for a given AST node.
	 */
	@Override
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
			case "AssignmentByRefExpression":
				return new AssignmentEnvironment();

			case "AssignmentWithOpExpression":
				return new AssignmentWithOpEnvironment();

			case "StaticVariableDeclaration":
				return new StaticVariableDeclarationEnvironment();

			case "PropertyElement":
			case "ConstantElement":
				return new FieldDeclarationEnvironment();

			/*
			 * COMMENTED OUT: Actually, these will never be CFG nodes, so these
			 * environments are useless; USEs should be emitted by the predicates
			 * themselves. We have the analyzingPredicate field for this now.
			// environments with predicates: the predicates should emit USEs for the
			// variables used in them

			case "WhileStatement":
				return new WhileEnvironment();

			case "DoStatement":
				return new DoEnvironment();

			case "IfElement":
				return new IfElementEnvironment();

			case "ForStatement":
				return new ForEnvironment();
 			*/

			// TODO This is temporary.
			// Until there is no solution for 'switch' nodes in CFG creation,
			// we cannot really know which nodes should be analyzed in this context,
			// and how to tackle them.
			case "SwitchStatementPHP":
				return new SwitchEnvironment();

			// TODO This is temporary.
			// Until there is no solution for 'foreach' nodes in CFG creation,
			// we cannot really know which nodes should be analyzed in this context,
			// and how to tackle them.
			case "ForEachStatement":
				return new ForEachEnvironment();


			// environments that emit DEFs *and* USEs for all their children symbols

			case "PreIncOperationExpression":
			case "PreDecOperationExpression":
			case "PostIncOperationExpression":
			case "PostDecOperationExpression":
				return new IncDecEnvironment();


			// environments that emit USEs for all their children symbols

			case "EmptyExpression":
			case "IssetExpression":
			case "ShellExecExpression":
			case "CloneExpression":
			case "ExitExpression":
			case "PrintExpression":
			case "IncludeOrEvalExpression":
			case "YieldFromExpression":
			case "ReturnStatement":
			case "EchoStatement":
			case "ThrowStatement":
			case "YieldExpression":
			// All four call environments (see below) also *only* emit USEs for
			// all their symbols: Although variables may optionally be passed
			// by reference in function calls, this is not visible from the call
			// site; rather, this is exclusively determined by the function definition,
			// which is unknown in the call environment. Therefore we can only:
			// (1) assume DEFs *and* USEs for all variables in a function call (over-approximation -> more false positives)
			// (2) assume *only* USEs for all variables in a function call (under-approximation -> more false negatives)
			// Here we go for (2).
			case "CallExpressionBase":
			case "NewExpression":
			case "MethodCallExpression":
			case "StaticCallExpression":
			// the following environments should also emit USEs, as they could
			// be used as standalone expressions as a predicate, i.e., within
			// the guard of some if/while/etc. statement
			case "UnaryOperationExpression":
			case "BinaryOperationExpression":
			case "InstanceofExpression":
				return new EmitUseEnvironment();


			// environments that emit DEFs for all their children symbols

			case "GlobalStatement":
			case "UnsetStatement":
				return new EmitDefEnvironment();
			// A catch statement also only emits a DEF for the variable holding the exception,
			// but we cannot use the EmitDefEnvironment because this variable is not contained
			// within a Variable (AST_VAR) node as usual. This has been changed in version 20
			// of php-ast, see https://github.com/nikic/php-ast#20-current
			// (thus, once we update to version 20, we can use an EmitDefEnvironment for CatchStatement)
			case "CatchStatement":
				return new CatchEnvironment();

			/* COMMENTED OUT: Actually, these will never be CFG nodes, so these
			 * environments are useless. We use the ParameterEnvironment instead,
			 * now that parameters are CFG nodes too.
			case "FunctionDef":
			case "Closure":
			case "Method":
				return new FunctionDefEnvironment();
			*/
			case "Parameter":
				return new ParameterEnvironment();

			// "Base" environments which add symbols to be reported upstream:
			// closure variables, variables, constants, properties, static properties and class constants
			// Also, whenever we are analyzing a predicate instead of a normal statement,
			// these environments should emit USEs of their variables (see according comments
			// in CFGToUDGConverter.convert(CFG))

			case "ClosureVar":
				return new ClosureVarEnvironment();

			case "Variable":
				VariableEnvironment venv = new VariableEnvironment();
				venv.setEmitUse(this.analyzingPredicate);
				this.analyzingPredicate = false;
				return venv;

			case "Constant":
				ConstantEnvironment cenv = new ConstantEnvironment();
				cenv.setEmitUse(this.analyzingPredicate);
				this.analyzingPredicate = false;
				return cenv;

			case "PropertyExpression":
				PropertyEnvironment penv = new PropertyEnvironment();
				penv.setEmitUse(this.analyzingPredicate);
				this.analyzingPredicate = false;
				return penv;

			case "StaticPropertyExpression":
				StaticPropertyEnvironment spenv = new StaticPropertyEnvironment();
				spenv.setEmitUse(this.analyzingPredicate);
				this.analyzingPredicate = false;
				return spenv;

			case "ClassConstantExpression":
				ClassConstantEnvironment ccenv = new ClassConstantEnvironment();
				ccenv.setEmitUse(this.analyzingPredicate);
				this.analyzingPredicate = false;
				return ccenv;

			// array accesses are special in their way:
			// for an expression $foo[$key],
			// - $key is always a USE (yes, even in things like '$foo[$key] = ...;')
			// - $foo is to be reported upstream, but should be emitted as USE when
			//   we are analyzing a predicate (as in: if( $foo[$key]) { ... })
			case "ArrayIndexing":
				ArrayIndexingEnvironment aienv = new ArrayIndexingEnvironment();
				aienv.setEmitUse(this.analyzingPredicate);
				this.analyzingPredicate = false;
				return aienv;


			// default environment

			default:
				return new UseDefEnvironment();
		}
	}

	public void setPredicate( boolean analyzingPredicate) {
		this.analyzingPredicate = analyzingPredicate;
	}
}
