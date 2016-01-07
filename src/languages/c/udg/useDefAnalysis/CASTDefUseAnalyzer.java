package languages.c.udg.useDefAnalysis;

import java.util.List;

import languages.c.udg.useDefAnalysis.environments.ArgumentEnvironment;
import languages.c.udg.useDefAnalysis.environments.ArrayIndexingEnvironment;
import languages.c.udg.useDefAnalysis.environments.AssignmentEnvironment;
import languages.c.udg.useDefAnalysis.environments.CallEnvironment;
import languages.c.udg.useDefAnalysis.environments.DeclEnvironment;
import languages.c.udg.useDefAnalysis.environments.IdentifierEnvironment;
import languages.c.udg.useDefAnalysis.environments.IncDecEnvironment;
import languages.c.udg.useDefAnalysis.environments.MemberAccessEnvironment;
import languages.c.udg.useDefAnalysis.environments.PtrMemberAccessEnvironment;
import languages.c.udg.useDefAnalysis.environments.UnaryOpEnvironment;
import languages.c.udg.useDefAnalysis.environments.UseEnvironment;
import udg.ASTProvider;
import udg.useDefAnalysis.ASTDefUseAnalyzer;
import udg.useDefAnalysis.environments.UseDefEnvironment;

/**
 * C-specific implementation of ASTDefUseAnalyzer.
 */
public class CASTDefUseAnalyzer extends ASTDefUseAnalyzer
{

	TaintSources taintSources = new TaintSources();

	/**
	 * Inform the ASTAnalyzer about (callee, argNum)-pairs that define their
	 * arguments. For example, 'recv' defines its first argument.
	 */
	public void addTaintSource(String callee, int argNum)
	{
		taintSources.add(callee, argNum);
	}

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
		case "PostIncDecOperationExpression":
			return new IncDecEnvironment();
		case "IdentifierDecl":
		case "Parameter":
			return new DeclEnvironment();

		case "CallExpression":
			return createCallEnvironment(astProvider);

		case "Argument":
			return createArgumentEnvironment(astProvider);

		case "PtrMemberAccess":
			return new PtrMemberAccessEnvironment();

		case "MemberAccess":
			return new MemberAccessEnvironment();

		case "Condition":
		case "ReturnStatement":
			return new UseEnvironment();

		case "ArrayIndexing":
			return new ArrayIndexingEnvironment();

		case "UnaryOperationExpression":
			return new UnaryOpEnvironment();

		case "Identifier":
			return new IdentifierEnvironment();

		default:
			return new UseDefEnvironment();
		}
	}

	private UseDefEnvironment createCallEnvironment(ASTProvider astProvider)
	{
		CallEnvironment callEnv = new CallEnvironment();
		// inform calls of any arguments it might taint

		String callee = astProvider.getChild(0).getEscapedCodeStr();
		if (taintSources.isTaintSource(callee))
		{
			List<Integer> taintedArgs = taintSources
					.getTaintedArgsForCallee(callee);
			callEnv.setTaintedArgs(taintedArgs);
		}
		return callEnv;
	}

	private ArgumentEnvironment createArgumentEnvironment(
			ASTProvider astProvider)
	{
		ArgumentEnvironment argEnv = new ArgumentEnvironment();
		CallEnvironment callEnv = (CallEnvironment) environmentStack
				.get(environmentStack.size() - 2);

		if (callEnv.isArgumentTainted(astProvider.getChildNumber()))
			argEnv.setIsTainted();

		return argEnv;
	}
}
