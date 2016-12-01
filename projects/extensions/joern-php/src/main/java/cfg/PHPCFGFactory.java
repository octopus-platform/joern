package cfg;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import ast.expressions.Expression;
import ast.functionDef.FunctionDefBase;
import ast.logical.statements.CompoundStatement;
import ast.logical.statements.Statement;
import ast.php.statements.blockstarters.IfElement;
import ast.php.statements.blockstarters.IfStatement;
import ast.php.statements.blockstarters.SwitchCase;
import ast.php.statements.blockstarters.SwitchStatementPHP;
import ast.statements.blockstarters.CatchStatement;
import ast.statements.blockstarters.ForEachStatement;
import ast.statements.blockstarters.IfStatementBase;
import ast.statements.blockstarters.SwitchStatement;
import ast.statements.blockstarters.TryStatement;
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
	public CFG newInstance(FunctionDefBase functionDefinition)
	{
		CFG cfg = super.newInstance(functionDefinition);
		
		// for PHP, we additionally set the node ids for the function entry and exit nodes:
		// their ids match the ids of the entry and exit nodes output by the PHP AST parser
		Long id = functionDefinition.getNodeId();
		((CFGEntryNode)cfg.getEntryNode()).setNodeId( id + CFG_ENTRY_OFFSET);
		((CFGExitNode)cfg.getExitNode()).setNodeId( id + CFG_EXIT_OFFSET);
		
		return cfg;
	}
	
	public static CFG newInstance(IfStatementBase ifStatement)
	{
		try
		{
			IfStatement phpIfStatement = (IfStatement)ifStatement;
			
			Iterator<IfElement> iterator = phpIfStatement.iterator();
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

	private static CFG convertIfElem(Iterator<IfElement> iterator)
	{
		CFG block = new CFG();

		IfElement ifElem = iterator.next();
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

	public static CFG newInstance(SwitchStatement switchStatement)
	{
		try
		{
			SwitchStatementPHP phpSwitchStatement = (SwitchStatementPHP)switchStatement;

			// create new CFG block
			CFG switchBlock = new CFG();

			// "head" vertex: the expression to be compared to the individual cases
			CFGNode conditionContainer = new ASTNodeContainer(
					phpSwitchStatement.getExpression());
			switchBlock.addVertex(conditionContainer);
			switchBlock.addEdge(switchBlock.getEntryNode(), conditionContainer);

			// create a CFG block for each case and connect them
			boolean defaultExists = false;
			for( SwitchCase switchCase : phpSwitchStatement.getSwitchList()) {
				
				// convert case block and add to main switch block
				CFG caseBody = convert(switchCase.getStatement());
				switchBlock.appendCFG(caseBody);
				
				// determine label
				String label = switchCase.getValue() != null
						? switchCase.getValue().getEscapedCodeStr()
						: "default";
				if( label.equals("default")) defaultExists = true;
				
				// connect condition to first statement of case
				// if case is empty, simply connect to current exit node
				if( !caseBody.isEmpty()) {
					for( CFGEdge caseEntryEdge : caseBody.outgoingEdges( caseBody.getEntryNode())) {
						switchBlock.addEdge( conditionContainer, caseEntryEdge.getDestination(), label);
					}
				}
				else {
					switchBlock.addEdge( conditionContainer, switchBlock.getExitNode(), label);
				}
			}
			// default edge to exit node (if no default case is found)
			if( !defaultExists) {
				switchBlock.addEdge( conditionContainer, switchBlock.getExitNode(), "default");
			}

			// finally, fix break statements and rejoice, for we are done
			fixBreakStatements( switchBlock, switchBlock.getExitNode());

			return switchBlock;
		}
		catch (Exception e)
		{
			//e.printStackTrace();
			return newErrorInstance();
		}
	}
	
	public static CFG newInstance(ForEachStatement forEachStatement)
	{
		try
		{
			CFG forEachBlock = new CFG();
			// for now, let's consider the iterated object as the condition only
			// TODO actually, it would be nicer to have the ForEachCondition explicitly
			// be a part of the AST
			CFGNode conditionContainer = new ASTNodeContainer(
					forEachStatement.getCondition().getIteratedObject());
			forEachBlock.addVertex(conditionContainer);
			forEachBlock.addEdge(forEachBlock.getEntryNode(), conditionContainer);

			CFG forEachBody = convert(forEachStatement.getStatement());

			forEachBlock.mountCFG(conditionContainer, conditionContainer,
					forEachBody, CFGEdge.NEXT_LABEL);
			forEachBlock.addEdge(conditionContainer, forEachBlock.getExitNode(),
					CFGEdge.COMPLETE_LABEL);

			fixBreakStatements(forEachBlock, forEachBlock.getExitNode());
			fixContinueStatement(forEachBlock, conditionContainer);

			return forEachBlock;
		}
		catch (Exception e)
		{
			// e.printStackTrace();
			return newErrorInstance();
		}
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
