package cfg;

import ast.c.statements.blockstarters.IfStatement;
import ast.statements.blockstarters.IfStatementBase;
import cfg.CFG;
import cfg.CFGEdge;
import cfg.CFGFactory;
import cfg.nodes.ASTNodeContainer;
import cfg.nodes.CFGNode;

public class CCFGFactory extends CFGFactory
{

	static{
		structuredFlowVisitior = new CStructuredFlowVisitor();
	}

	public CCFGFactory()
	{
		structuredFlowVisitior = new CStructuredFlowVisitor();
	}

	public static CFG newInstance(IfStatementBase ifStmt)
	{
		try
		{
			IfStatement ifStatement = (IfStatement)ifStmt;

			CFG block = new CFG();
			CFGNode conditionContainer = new ASTNodeContainer(
					ifStatement.getCondition());
			block.addVertex(conditionContainer);
			block.addEdge(block.getEntryNode(), conditionContainer);

			CFG ifBlock = convert(ifStatement.getStatement());
			block.mountCFG(conditionContainer, block.getExitNode(), ifBlock,
					CFGEdge.TRUE_LABEL);

			if (ifStatement.getElseNode() != null)
			{
				CFG elseBlock = convert(
						ifStatement.getElseNode().getStatement());
				block.mountCFG(conditionContainer, block.getExitNode(),
						elseBlock, CFGEdge.FALSE_LABEL);
			}
			else
			{
				block.addEdge(conditionContainer, block.getExitNode(),
						CFGEdge.FALSE_LABEL);
			}

			return block;
		}
		catch (Exception e)
		{
			// e.printStackTrace();
			return newErrorInstance();
		}
	}

}
