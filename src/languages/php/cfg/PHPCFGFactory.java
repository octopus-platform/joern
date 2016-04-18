package languages.php.cfg;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import ast.expressions.Expression;
import ast.functionDef.FunctionDef;
import ast.logical.statements.CompoundStatement;
import ast.logical.statements.Statement;
import ast.php.statements.blockstarters.ForEachStatement;
import ast.php.statements.blockstarters.PHPIfElement;
import ast.php.statements.blockstarters.PHPIfStatement;
import ast.statements.blockstarters.CatchStatement;
import ast.statements.blockstarters.IfStatement;
import ast.statements.blockstarters.TryStatement;
import cfg.CFG;
import cfg.CFGEdge;
import cfg.CFGFactory;
import cfg.nodes.ASTNodeContainer;
import cfg.nodes.CFGEntryNode;
import cfg.nodes.CFGExceptionNode;
import cfg.nodes.CFGExitNode;
import cfg.nodes.CFGNode;

public class PHPCFGFactory extends CFGFactory {
	
	// node id offsets for entry and exit nodes of function definitions
	private static final int CFG_ENTRY_OFFSET = 1;
	private static final int CFG_EXIT_OFFSET = 2;
	
	static {
		structuredFlowVisitior = new PHPStructuredFlowVisitor();
	}

	public PHPCFGFactory() {
		structuredFlowVisitior = new PHPStructuredFlowVisitor();
	}

	@Override
	public CFG newInstance(FunctionDef functionDefinition)
	{
		CFG cfg = super.newInstance(functionDefinition);
		
		// for PHP, we additionally set the node ids for the function entry and exit nodes:
		// their ids match the ids of the entry and exit nodes output by the PHP AST parser
		Long id = functionDefinition.getNodeId();
		((CFGEntryNode)cfg.getEntryNode()).setNodeId( id + CFG_ENTRY_OFFSET);
		((CFGExitNode)cfg.getExitNode()).setNodeId( id + CFG_EXIT_OFFSET);
		
		return cfg;
	}
	
	public static CFG newInstance(IfStatement ifStmt)
	{
		try
		{

			PHPIfStatement ifStatement = (PHPIfStatement) ifStmt;
			Iterator<PHPIfElement> iterator = ifStatement.iterator();
			if(!iterator.hasNext())
				return newErrorInstance();

			CFG ifElemCFG = convertIfElem(iterator);
			return ifElemCFG;
		}
		catch (Exception e)
		{
			// e.printStackTrace();
			return newErrorInstance();
		}
	}

	private static CFG convertIfElem(Iterator<PHPIfElement> iterator)
	{
		CFG block = new CFG();

		PHPIfElement ifElem = iterator.next();
		Expression condition = ifElem.getCondition();
		Statement statement = ifElem.getStatement();
		CFG ifBlock = convert(statement);


		if(condition == null)
		{
			// this is the 'else' case
			return ifBlock;
		}

		CFGNode conditionContainer = new ASTNodeContainer(
				condition);

		block.addVertex(conditionContainer);
		block.addEdge(block.getEntryNode(), conditionContainer);

		block.mountCFG(conditionContainer, block.getExitNode(), ifBlock,
				CFGEdge.TRUE_LABEL);

		if(iterator.hasNext())
		{
			CFG elseBlock = convertIfElem(iterator);
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

	public static CFG newInstance(ForEachStatement forEach)
	{
		CFG block = new CFG();
		// TODO: implement me.
		return block;
	}

	public static CFG newInstance(TryStatement tryStatement)
	{
		try
		{
			CFG tryCFG = convert(tryStatement.getContent());
			List<CFGNode> statements = new LinkedList<CFGNode>();

			// Get all nodes within try not connected to an exception node.
			for (CFGNode node : tryCFG.getVertices())
			{
				if (!(node instanceof CFGEntryNode)
						&& !(node instanceof CFGExitNode))
				{
					boolean b = true;
					for (CFGEdge edge : tryCFG.outgoingEdges(node))
					{
						CFGNode destination = edge.getDestination();
						if (destination instanceof CFGExceptionNode)
						{
							b = false;
							break;
						}
					}
					if (b)
						statements.add(node);
				}
			}

			// Add exception node for current try block
			if (!statements.isEmpty())
			{
				CFGExceptionNode exceptionNode = new CFGExceptionNode();
				tryCFG.setExceptionNode(exceptionNode);
				for (CFGNode node : statements)
				{
					tryCFG.addEdge(node, exceptionNode, CFGEdge.EXCEPT_LABEL);
				}
			}

			if (tryStatement.getCatchList().size() == 0)
			{
				System.err.println("warning: cannot find catch for try");
				return tryCFG;
			}

			// Mount exception handlers
			for (CatchStatement catchStatement : tryStatement.getCatchList())
			{
				CFG catchBlock = convert(catchStatement.getStatement());
				tryCFG.mountCFG(tryCFG.getExceptionNode(), tryCFG.getExitNode(),
						catchBlock, CFGEdge.HANDLED_EXCEPT_LABEL);
			}

			// now deal with the finally block

			CompoundStatement finallyContent = tryStatement.getFinallyContent();
			tryCFG.appendCFG(convert(finallyContent));

			return tryCFG;

		}
		catch (Exception e)
		{
			// e.printStackTrace();
			return newErrorInstance();
		}
	}

}
