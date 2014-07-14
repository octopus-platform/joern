package cfg;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import astnodes.ASTNode;
import astnodes.functionDef.FunctionDef;
import astnodes.functionDef.ParameterList;
import astnodes.statements.CompoundStatement;

public class ASTToCFGConverter
{

	private StructuredFlowVisitor structuredFlowVisitor = new StructuredFlowVisitor();
	private JumpStatementVisitor jumpStatementVisitor = new JumpStatementVisitor();

	public CFG convert(FunctionDef node)
	{
		CFG cfg = convertFunctionDef(node);
		markCFGNodes(cfg);
		return cfg;
	}

	private void markCFGNodes(CFG cfg)
	{
		List<CFGNode> statements = cfg.getVertices();
		for (CFGNode statement : statements)
			statement.markAsCFGNode();
	}

	private CFG convertFunctionDef(FunctionDef node)
	{
		// create a CFG for the parameter list

		ParameterList parameterList = node.getParameterList();
		CFG cfg = convertParameterList(parameterList);
		CFGNode lastParamDefBlock = cfg.getLastStatement();

		// create a CFG for the compound statement

		CompoundStatement content = node.getContent();
		CFG compoundCFG = convertCompoundStatement(content);
		CFGNode firstCompoundStmtBlock = compoundCFG.getFirstStatement();

		// add compound statement cfg to parameter list CFG

		cfg.addCFG(compoundCFG);

		// create an edge from the last parameter to the first
		// statement from the compound statement if necessary.

		if (lastParamDefBlock != null && firstCompoundStmtBlock != null)
		{
			cfg.addEdge(lastParamDefBlock, firstCompoundStmtBlock);
		}

		return cfg;
	}

	private CFG convertParameterList(ParameterList parameterList)
	{
		parameterList.accept(structuredFlowVisitor);
		CFG cfg = structuredFlowVisitor.getCFG();
		return cfg;
	}

	public CFG convertCompoundStatement(CompoundStatement content)
	{
		content.accept(structuredFlowVisitor);
		CFG cfg = structuredFlowVisitor.getCFG();
		honorJumpStatements(cfg);
		return cfg;
	}

	private void honorJumpStatements(CFG cfg)
	{
		fixJumps(cfg);
		fixSwitchBlocks(cfg);
	}

	private void fixSwitchBlocks(CFG cfg)
	{
		Iterator<Entry<CFGNode, List<CFGNode>>> it = cfg.getSwitchLabels()
				.getEntrySetIterator();

		while (it.hasNext())
		{
			Entry<CFGNode, List<CFGNode>> entry = it.next();
			CFGNode switchBlock = (CFGNode) entry.getKey();
			List<CFGNode> labeledBlocks = entry.getValue();

			for (CFGNode labeledBlock : labeledBlocks)
				cfg.addEdge(switchBlock, labeledBlock);
		}
	}

	private void fixJumps(CFG cfg)
	{
		Collection<? extends CFGNode> jumpStatements = cfg.getJumpStatements();
		Iterator<? extends CFGNode> it = jumpStatements.iterator();

		CFGNode emptyStatement = new CFGNode();
		if (cfg.getLastStatement() != null)
		{
			CFGNode last = cfg.getLastStatement();
			cfg.addVertex(emptyStatement);
			cfg.addEdge(last, emptyStatement);
		}
		else
		{
			cfg.addVertex(emptyStatement);
		}

		while (it.hasNext())
		{
			CFGNode stmt = it.next();
			ASTNode statement = stmt.getASTNode();

			jumpStatementVisitor.setCFG(cfg);
			jumpStatementVisitor.setStatement(stmt);

			try
			{
				statement.accept(jumpStatementVisitor);
			}
			catch (RuntimeException ex)
			{
				System.err.println("While fixing jumps: " + ex.getMessage());
			}

		}
	}
}
