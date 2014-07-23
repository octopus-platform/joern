package cfg;

import graphutils.AbstractTwoWayGraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import astnodes.ASTNode;
import astnodes.functionDef.FunctionDef;
import astnodes.functionDef.Parameter;
import astnodes.functionDef.ParameterList;
import astnodes.statements.BreakStatement;
import astnodes.statements.CompoundStatement;
import astnodes.statements.ContinueStatement;
import astnodes.statements.DoStatement;
import astnodes.statements.ForStatement;
import astnodes.statements.GotoStatement;
import astnodes.statements.IfStatement;
import astnodes.statements.Label;
import astnodes.statements.ReturnStatement;
import astnodes.statements.SwitchStatement;
import astnodes.statements.WhileStatement;
import cfg.nodes.ASTNodeContainer;
import cfg.nodes.CFGEntryNode;
import cfg.nodes.CFGErrorNode;
import cfg.nodes.CFGExitNode;
import cfg.nodes.CFGNode;
import cfg.nodes.InfiniteForNode;

public class CFG extends AbstractTwoWayGraph<CFGNode, CFGEdge>
{
	private static StructuredFlowVisitor structuredFlowVisitior = new StructuredFlowVisitor();

	private List<CFGNode> breakStatements;
	private List<CFGNode> continueStatements;
	private List<CFGNode> returnStatements;
	private HashMap<CFGNode, String> gotoStatements;
	private HashMap<String, CFGNode> labels;

	private CFGEntryNode entry;
	private CFGExitNode exit;
	private CFGErrorNode error;

	private CFG()
	{
		breakStatements = new LinkedList<CFGNode>();
		continueStatements = new LinkedList<CFGNode>();
		returnStatements = new LinkedList<CFGNode>();
		gotoStatements = new HashMap<CFGNode, String>();
		labels = new HashMap<String, CFGNode>();
		entry = new CFGEntryNode();
		exit = new CFGExitNode();
		addVertex(entry);
		addVertex(exit);
	}

	public static CFG newInstance(FunctionDef functionDefinition)
	{
		try
		{
			CFG function = CFG.newInstance();
			CFG parameterBlock = convert(functionDefinition.getParameterList());
			CFG functionBody = convert(functionDefinition.getContent());
			parameterBlock.appendCFG(functionBody);
			function.appendCFG(parameterBlock);
			function.fixGotoStatements();
			function.fixReturnStatements();
			if (!function.breakStatements.isEmpty())
			{
				System.err.println("warning: unresolved break statement");
				function.fixBreakStatements(function.getErrorNode());
			}
			if (!function.continueStatements.isEmpty())
			{
				System.err.println("warning: unresolved continue statement");
				function.fixContinueStatement(function.getErrorNode());
			}
			return function;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return CFG.newErrorInstance();
		}
	}

	public static CFG newErrorInstance()
	{
		CFG errorBlock = new CFG();
		CFGNode errorNode = new CFGErrorNode();
		errorBlock.addVertex(errorNode);
		errorBlock.addEdge(errorBlock.getEntryNode(), errorNode);
		errorBlock.addEdge(errorNode, errorBlock.getExitNode());
		return errorBlock;
	}

	public static CFG newInstance(ASTNode... nodes)
	{
		try
		{
			CFG block = new CFG();
			CFGNode last = block.getEntryNode();
			for (ASTNode node : nodes)
			{
				CFGNode container = new ASTNodeContainer(node);
				block.addVertex(container);
				block.addEdge(last, container);
				last = container;
			}
			block.addEdge(last, block.getExitNode());
			return block;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return CFG.newErrorInstance();
		}
	}

	public static CFG newInstance(IfStatement ifStatement)
	{
		try
		{
			CFG block = new CFG();
			CFGNode conditionContainer = new ASTNodeContainer(
					ifStatement.getCondition());
			block.addVertex(conditionContainer);
			block.addEdge(block.getEntryNode(), conditionContainer);

			CFG ifBlock = CFG.convert(ifStatement.getStatement());
			block.mountCFG(conditionContainer, block.getExitNode(), ifBlock,
					CFGEdge.TRUE_LABEL);

			if (ifStatement.getElseNode() != null)
			{
				CFG elseBlock = CFG.convert(ifStatement.getElseNode()
						.getStatement());
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
			e.printStackTrace();
			return CFG.newErrorInstance();
		}
	}

	public static CFG newInstance(WhileStatement whileStatement)
	{
		try
		{
			CFG whileBlock = new CFG();
			CFGNode conditionContainer = new ASTNodeContainer(
					whileStatement.getCondition());
			whileBlock.addVertex(conditionContainer);
			whileBlock.addEdge(whileBlock.getEntryNode(), conditionContainer);

			CFG whileBody = CFG.convert(whileStatement.getStatement());

			whileBlock.mountCFG(conditionContainer, conditionContainer,
					whileBody, CFGEdge.TRUE_LABEL);
			whileBlock.addEdge(conditionContainer, whileBlock.getExitNode(),
					CFGEdge.FALSE_LABEL);

			whileBlock.fixBreakStatements(whileBlock.getExitNode());
			whileBlock.fixContinueStatement(conditionContainer);

			return whileBlock;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return CFG.newErrorInstance();
		}
	}

	public static CFG newInstance(ForStatement forStatement)
	{
		try
		{
			CFG forBlock = new CFG();

			ASTNode initialization = forStatement.getForInitStatement();
			ASTNode condition = forStatement.getCondition();
			ASTNode expression = forStatement.getExpression();

			CFG forBody = convert(forStatement.getStatement());
			CFGNode conditionContainer;

			if (condition != null)
			{
				conditionContainer = new ASTNodeContainer(condition);
			}
			else
			{
				conditionContainer = new InfiniteForNode();
			}

			forBlock.addVertex(conditionContainer);
			forBlock.addEdge(conditionContainer, forBlock.getExitNode(),
					CFGEdge.FALSE_LABEL);

			if (initialization != null)
			{
				CFGNode initializationContainer = new ASTNodeContainer(
						initialization);
				forBlock.addVertex(initializationContainer);
				forBlock.addEdge(forBlock.getEntryNode(),
						initializationContainer);
				forBlock.addEdge(initializationContainer, conditionContainer);
			}
			else
			{
				forBlock.addEdge(forBlock.getEntryNode(), conditionContainer);
			}
			
			if (expression != null)
			{
				CFGNode expressionContainer = new ASTNodeContainer(expression);
				forBlock.addVertex(expressionContainer);
				forBlock.addEdge(expressionContainer, conditionContainer);
				forBlock.mountCFG(conditionContainer, expressionContainer,
						forBody, CFGEdge.TRUE_LABEL);
			}
			else
			{
				forBlock.mountCFG(conditionContainer, conditionContainer,
						forBody, CFGEdge.TRUE_LABEL);
			}

			forBlock.fixBreakStatements(forBlock.getExitNode());
			forBlock.fixContinueStatement(conditionContainer);

			return forBlock;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return CFG.newErrorInstance();
		}
	}

	public static CFG newInstance(DoStatement doStatement)
	{
		try
		{
			CFG doBlock = new CFG();

			CFGNode conditionContainer = new ASTNodeContainer(
					doStatement.getCondition());

			doBlock.addVertex(conditionContainer);
			doBlock.addEdge(conditionContainer, doBlock.getExitNode(),
					CFGEdge.FALSE_LABEL);

			CFG doBody = convert(doStatement.getStatement());

			doBlock.mountCFG(doBlock.getEntryNode(), conditionContainer,
					doBody, CFGEdge.EMPTY_LABEL);

			for (CFGEdge edge : doBody.outgoingEdges(doBody.getEntryNode()))
			{
				doBlock.addEdge(conditionContainer, edge.getDestination(),
						CFGEdge.TRUE_LABEL);
			}

			doBlock.fixBreakStatements(doBlock.getExitNode());
			doBlock.fixContinueStatement(conditionContainer);

			return doBlock;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return CFG.newErrorInstance();
		}
	}

	public static CFG newInstance(SwitchStatement switchStatement)
	{
		try
		{
			CFG switchBlock = new CFG();
			CFGNode conditionContainer = new ASTNodeContainer(
					switchStatement.getCondition());
			switchBlock.addVertex(conditionContainer);
			switchBlock.addEdge(switchBlock.getEntryNode(), conditionContainer);

			CFG switchBody = convert(switchStatement.getStatement());

			switchBlock.addCFG(switchBody);

			boolean defaultLabel = false;

			for (Entry<String, CFGNode> block : switchBody.labels.entrySet())
			{
				if (block.getKey().equals("default"))
				{
					defaultLabel = true;
				}
				switchBlock.addEdge(conditionContainer, block.getValue(),
						block.getKey());
			}
			for (CFGEdge edge : switchBody.ingoingEdges(switchBody
					.getExitNode()))
			{
				switchBlock
						.addEdge(edge.getSource(), switchBlock.getExitNode());
			}
			if (!defaultLabel)
			{
				switchBlock.addEdge(conditionContainer,
						switchBlock.getExitNode());
			}

			switchBlock.fixBreakStatements(switchBlock.getExitNode());

			return switchBlock;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return CFG.newErrorInstance();
		}
	}

	public static CFG newInstance(ParameterList paramList)
	{
		try
		{
			CFG parameterListBlock = CFG.newInstance();
			for (Parameter parameter : paramList.getParameters())
			{
				parameterListBlock.appendCFG(convert(parameter));
			}
			return parameterListBlock;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return CFG.newErrorInstance();
		}
	}

	public static CFG newInstance(CompoundStatement content)
	{
		try
		{
			CFG compoundBlock = CFG.newInstance();
			for (ASTNode statement : content.getStatements())
			{
				compoundBlock.appendCFG(convert(statement));
			}
			return compoundBlock;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return CFG.newErrorInstance();
		}
	}

	public static CFG newInstance(ReturnStatement returnStatement)
	{
		try
		{
			CFG returnBlock = new CFG();
			CFGNode returnContainer = new ASTNodeContainer(returnStatement);
			returnBlock.addVertex(returnContainer);
			returnBlock.addEdge(returnBlock.getEntryNode(), returnContainer);
			returnBlock.addEdge(returnContainer, returnBlock.getExitNode());
			returnBlock.addReturnStatement(returnContainer);
			return returnBlock;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return CFG.newErrorInstance();
		}
	}

	public static CFG newInstance(GotoStatement gotoStatement)
	{
		try
		{
			CFG gotoBlock = new CFG();
			CFGNode gotoContainer = new ASTNodeContainer(gotoStatement);
			gotoBlock.addVertex(gotoContainer);
			gotoBlock.addEdge(gotoBlock.getEntryNode(), gotoContainer);
			gotoBlock.addEdge(gotoContainer, gotoBlock.getExitNode());
			gotoBlock
					.addGotoStatement(gotoContainer, gotoStatement.getTarget());
			return gotoBlock;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return CFG.newErrorInstance();
		}
	}

	public static CFG newInstance(Label labelStatement)
	{
		try
		{
			CFG continueBlock = new CFG();
			CFGNode labelContainer = new ASTNodeContainer(labelStatement);
			continueBlock.addVertex(labelContainer);
			continueBlock.addEdge(continueBlock.getEntryNode(), labelContainer);
			continueBlock.addEdge(labelContainer, continueBlock.getExitNode());
			String label = labelStatement.getEscapedCodeStr();
			label = label.substring(0, label.length() - 2);
			continueBlock.addBlockLabel(label, labelContainer);
			return continueBlock;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return CFG.newErrorInstance();
		}
	}

	public static CFG newInstance(ContinueStatement continueStatement)
	{
		try
		{
			CFG continueBlock = new CFG();
			CFGNode continueContainer = new ASTNodeContainer(continueStatement);
			continueBlock.addVertex(continueContainer);
			continueBlock.addEdge(continueBlock.getEntryNode(),
					continueContainer);
			continueBlock.addEdge(continueContainer,
					continueBlock.getExitNode());
			continueBlock.addContinueStatement(continueContainer);
			return continueBlock;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return CFG.newErrorInstance();
		}
	}

	public static CFG newInstance(BreakStatement breakStatement)
	{
		try
		{
			CFG breakBlock = new CFG();
			CFGNode breakContainer = new ASTNodeContainer(breakStatement);
			breakBlock.addVertex(breakContainer);
			breakBlock.addEdge(breakBlock.getEntryNode(), breakContainer);
			breakBlock.addEdge(breakContainer, breakBlock.getExitNode());
			breakBlock.addBreakStatement(breakContainer);
			return breakBlock;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return CFG.newErrorInstance();
		}
	}

	@Override
	public boolean isEmpty()
	{
		// do not count entry and exit node, since they do not provide any
		// additional information.
		return size() == 2;
	}

	public CFGNode getExitNode()
	{
		return exit;
	}

	public CFGNode getEntryNode()
	{
		return entry;
	}

	public CFGNode getErrorNode()
	{
		if (error == null)
		{
			error = new CFGErrorNode();
			addVertex(error);
		}
		return error;
	}

	public static CFG convert(ASTNode node)
	{
		CFG cfg;
		if (node != null)
		{
			node.accept(structuredFlowVisitior);
			cfg = structuredFlowVisitior.getCFG();
		}
		else
		{
			cfg = CFG.newInstance();
		}
		return cfg;

	}

	private void addCFG(CFG otherCFG)
	{
		addVertices(otherCFG);
		addEdges(otherCFG);

		breakStatements.addAll(otherCFG.breakStatements);
		continueStatements.addAll(otherCFG.continueStatements);
		returnStatements.addAll(otherCFG.returnStatements);
		gotoStatements.putAll(otherCFG.gotoStatements);
		labels.putAll(otherCFG.labels);
	}

	private void appendCFG(CFG otherCFG)
	{
		addCFG(otherCFG);
		if (!otherCFG.isEmpty())
		{
			for (CFGEdge edge1 : ingoingEdges(getExitNode()))
			{
				for (CFGEdge edge2 : otherCFG.outgoingEdges(otherCFG
						.getEntryNode()))
				{
					addEdge(edge1.getSource(), edge2.getDestination(),
							edge1.getLabel());
				}
			}
			removeEdgesTo(getExitNode());
			for (CFGEdge edge : otherCFG.ingoingEdges(otherCFG.getExitNode()))
			{
				addEdge(edge.getSource(), getExitNode(), edge.getLabel());
			}
		}
	}

	private void mountCFG(CFGNode branchNode, CFGNode mergeNode, CFG cfg,
			String label)
	{
		if (!cfg.isEmpty())
		{
			addCFG(cfg);
			for (CFGEdge edge : cfg.outgoingEdges(cfg.getEntryNode()))
			{
				addEdge(branchNode, edge.getDestination(), label);
			}
			for (CFGEdge edge : cfg.ingoingEdges(cfg.getExitNode()))
			{
				addEdge(edge.getSource(), mergeNode, edge.getLabel());
			}
		}
		else
		{
			addEdge(branchNode, mergeNode, label);
		}
	}

	private void addVertices(CFG cfg)
	{
		for (CFGNode vertex : cfg.getVertices())
		{
			// do not add entry and exit node
			if (!(vertex.equals(cfg.getEntryNode()) || vertex.equals(cfg
					.getExitNode())))
			{
				addVertex(vertex);
			}
		}
	}

	private void addEdges(CFG cfg)
	{
		for (CFGNode vertex : cfg.getVertices())
		{
			for (CFGEdge edge : cfg.outgoingEdges(vertex))
			{
				if (!(edge.getSource().equals(cfg.getEntryNode()) || edge
						.getDestination().equals(cfg.getExitNode())))
				{
					addEdge(edge);
				}
			}
		}
	}

	private void fixBreakStatements(CFGNode target)
	{
		for (CFGNode breakStatement : breakStatements)
		{
			removeEdgesFrom(breakStatement);
			addEdge(breakStatement, target);
		}
		breakStatements.clear();
	}

	private void fixContinueStatement(CFGNode target)
	{
		for (CFGNode continueStatement : continueStatements)
		{
			removeEdgesFrom(continueStatement);
			addEdge(continueStatement, target);
		}
		continueStatements.clear();
	}

	private void fixGotoStatements()
	{
		for (Entry<CFGNode, String> entry : gotoStatements.entrySet())
		{
			CFGNode gotoStatement = entry.getKey();
			String label = entry.getValue();
			removeEdgesFrom(gotoStatement);
			addEdge(gotoStatement, getBlockByLabel(label));
		}
		gotoStatements.clear();
	}

	private void fixReturnStatements()
	{
		for (CFGNode returnStatement : returnStatements)
		{
			removeEdgesFrom(returnStatement);
			addEdge(returnStatement, getExitNode());
		}
		returnStatements.clear();
	}

	private void addEdge(CFGNode srcBlock, CFGNode dstBlock)
	{
		addEdge(srcBlock, dstBlock, CFGEdge.EMPTY_LABEL);
	}

	private void addEdge(CFGNode srcBlock, CFGNode dstBlock, String label)
	{
		CFGEdge edge = new CFGEdge(srcBlock, dstBlock, label);
		addEdge(edge);
	}

	private void addBlockLabel(String label, CFGNode block)
	{
		labels.put(label, block);
	}

	private void addBreakStatement(CFGNode statement)
	{
		breakStatements.add(statement);
	}

	private void addContinueStatement(CFGNode statement)
	{
		continueStatements.add(statement);
	}

	private void addGotoStatement(CFGNode gotoStatement, String gotoTarget)
	{
		gotoStatements.put(gotoStatement, gotoTarget);
	}

	private void addReturnStatement(CFGNode returnStatement)
	{
		returnStatements.add(returnStatement);
	}

	private CFGNode getBlockByLabel(String label)
	{
		CFGNode block = labels.get(label);
		if (block == null)
		{
			System.err.println("warning : can not find block for label "
					+ label);
			return getErrorNode();
		}
		return block;
	}

}
