package cfg.C;

import java.util.Map.Entry;

import ast.ASTNode;
import ast.functionDef.FunctionDef;
import ast.functionDef.Parameter;
import ast.functionDef.ParameterList;
import ast.statements.BreakStatement;
import ast.statements.CompoundStatement;
import ast.statements.ContinueStatement;
import ast.statements.DoStatement;
import ast.statements.ForStatement;
import ast.statements.GotoStatement;
import ast.statements.IfStatement;
import ast.statements.Label;
import ast.statements.ReturnStatement;
import ast.statements.SwitchStatement;
import ast.statements.WhileStatement;
import cfg.CFG;
import cfg.CFGEdge;
import cfg.CFGFactory;
import cfg.nodes.ASTNodeContainer;
import cfg.nodes.CFGErrorNode;
import cfg.nodes.CFGNode;
import cfg.nodes.InfiniteForNode;

public class CCFGFactory extends CFGFactory
{
	private static StructuredFlowVisitor structuredFlowVisitior = new StructuredFlowVisitor();
	
	@Override
	public CFG newInstance(FunctionDef functionDefinition)
	{
		try
		{
			CCFG function = newInstance();
			CCFG parameterBlock = convert(functionDefinition.getParameterList());
			CCFG functionBody = convert(functionDefinition.getContent());
			parameterBlock.appendCFG(functionBody);
			function.appendCFG(parameterBlock);
			fixGotoStatements(function);
			fixReturnStatements(function);
			if (!function.getBreakStatements().isEmpty())
			{
				System.err.println("warning: unresolved break statement");
				fixBreakStatements(function, function.getErrorNode());
			}
			if (!function.getContinueStatements().isEmpty())
			{
				System.err.println("warning: unresolved continue statement");
				fixContinueStatement(function, function.getErrorNode());
			}
			return function;
		}
		catch (Exception e)
		{
			// e.printStackTrace();
			return newErrorInstance();
		}
	}

	public static CCFG newInstance(ASTNode... nodes)
	{
		try
		{
			CCFG block = new CCFG();
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
			// e.printStackTrace();
			return newErrorInstance();
		}
	}

	public static CCFG newErrorInstance()
	{
		CCFG errorBlock = new CCFG();
		CFGNode errorNode = new CFGErrorNode();
		errorBlock.addVertex(errorNode);
		errorBlock.addEdge(errorBlock.getEntryNode(), errorNode);
		errorBlock.addEdge(errorNode, errorBlock.getExitNode());
		return errorBlock;
	}
	
	public static CFG newInstance(IfStatement ifStatement)
	{
		try
		{
			CCFG block = new CCFG();
			CFGNode conditionContainer = new ASTNodeContainer(
					ifStatement.getCondition());
			block.addVertex(conditionContainer);
			block.addEdge(block.getEntryNode(), conditionContainer);

			CFG ifBlock = convert(ifStatement.getStatement());
			block.mountCFG(conditionContainer, block.getExitNode(), ifBlock,
					CFGEdge.TRUE_LABEL);

			if (ifStatement.getElseNode() != null)
			{
				CFG elseBlock = convert(ifStatement.getElseNode()
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
			// e.printStackTrace();
			return newErrorInstance();
		}
	}

	public static CFG newInstance(WhileStatement whileStatement)
	{
		try
		{
			CCFG whileBlock = new CCFG();
			CFGNode conditionContainer = new ASTNodeContainer(
					whileStatement.getCondition());
			whileBlock.addVertex(conditionContainer);
			whileBlock.addEdge(whileBlock.getEntryNode(), conditionContainer);

			CFG whileBody = convert(whileStatement.getStatement());

			whileBlock.mountCFG(conditionContainer, conditionContainer,
					whileBody, CFGEdge.TRUE_LABEL);
			whileBlock.addEdge(conditionContainer, whileBlock.getExitNode(),
					CFGEdge.FALSE_LABEL);

			fixBreakStatements(whileBlock, whileBlock.getExitNode());
			fixContinueStatement(whileBlock, conditionContainer);

			return whileBlock;
		}
		catch (Exception e)
		{
			// e.printStackTrace();
			return newErrorInstance();
		}
	}

	public static CFG newInstance(ForStatement forStatement)
	{
		try
		{
			CCFG forBlock = new CCFG();

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

			fixBreakStatements(forBlock, forBlock.getExitNode());
			fixContinueStatement(forBlock, conditionContainer);

			return forBlock;
		}
		catch (Exception e)
		{
			// e.printStackTrace();
			return newErrorInstance();
		}
	}

	public static CFG newInstance(DoStatement doStatement)
	{
		try
		{
			CCFG doBlock = new CCFG();

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

			fixBreakStatements(doBlock, doBlock.getExitNode());
			fixContinueStatement(doBlock, conditionContainer);

			return doBlock;
		}
		catch (Exception e)
		{
			// e.printStackTrace();
			return newErrorInstance();
		}
	}

	public static CFG newInstance(SwitchStatement switchStatement)
	{
		try
		{
			CCFG switchBlock = new CCFG();
			CFGNode conditionContainer = new ASTNodeContainer(
					switchStatement.getCondition());
			switchBlock.addVertex(conditionContainer);
			switchBlock.addEdge(switchBlock.getEntryNode(), conditionContainer);

			CCFG switchBody = convert(switchStatement.getStatement());

			switchBlock.addCFG(switchBody);

			boolean defaultLabel = false;

			for (Entry<String, CFGNode> block : switchBody.getLabels().entrySet())
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

			fixBreakStatements(switchBlock, switchBlock.getExitNode());

			return switchBlock;
		}
		catch (Exception e)
		{
			// e.printStackTrace();
			return newErrorInstance();
		}
	}

	public static CFG newInstance(ParameterList paramList)
	{
		try
		{
			CFG parameterListBlock = newInstance();
			for (Parameter parameter : paramList.getParameters())
			{
				parameterListBlock.appendCFG(convert(parameter));
			}
			return parameterListBlock;
		}
		catch (Exception e)
		{
			// e.printStackTrace();
			return newErrorInstance();
		}
	}

	public static CFG newInstance(CompoundStatement content)
	{
		try
		{
			CFG compoundBlock = newInstance();
			for (ASTNode statement : content.getStatements())
			{
				compoundBlock.appendCFG(convert(statement));
			}
			return compoundBlock;
		}
		catch (Exception e)
		{
			// e.printStackTrace();
			return newErrorInstance();
		}
	}

	public static CFG newInstance(ReturnStatement returnStatement)
	{
		try
		{
			CCFG returnBlock = new CCFG();
			CFGNode returnContainer = new ASTNodeContainer(returnStatement);
			returnBlock.addVertex(returnContainer);
			returnBlock.addEdge(returnBlock.getEntryNode(), returnContainer);
			returnBlock.addEdge(returnContainer, returnBlock.getExitNode());
			returnBlock.addReturnStatement(returnContainer);
			return returnBlock;
		}
		catch (Exception e)
		{
			// e.printStackTrace();
			return newErrorInstance();
		}
	}

	public static CFG newInstance(GotoStatement gotoStatement)
	{
		try
		{
			CCFG gotoBlock = new CCFG();
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
			// e.printStackTrace();
			return newErrorInstance();
		}
	}

	public static CFG newInstance(Label labelStatement)
	{
		try
		{
			CCFG continueBlock = new CCFG();
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
			// e.printStackTrace();
			return newErrorInstance();
		}
	}

	public static CFG newInstance(ContinueStatement continueStatement)
	{
		try
		{
			CCFG continueBlock = new CCFG();
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
			// e.printStackTrace();
			return newErrorInstance();
		}
	}

	public static CFG newInstance(BreakStatement breakStatement)
	{
		try
		{
			CCFG breakBlock = new CCFG();
			CFGNode breakContainer = new ASTNodeContainer(breakStatement);
			breakBlock.addVertex(breakContainer);
			breakBlock.addEdge(breakBlock.getEntryNode(), breakContainer);
			breakBlock.addEdge(breakContainer, breakBlock.getExitNode());
			breakBlock.addBreakStatement(breakContainer);
			return breakBlock;
		}
		catch (Exception e)
		{
			// e.printStackTrace();
			return newErrorInstance();
		}
	}
	
	public static CCFG convert(ASTNode node)
	{
		CCFG cfg;
		if (node != null)
		{
			node.accept(structuredFlowVisitior);
			cfg = (CCFG) structuredFlowVisitior.getCFG();
		}
		else
		{
			cfg = newInstance();
		}
		return cfg;
	}
	
	
	public static void fixBreakStatements(CCFG thisCFG, CFGNode target)
	{
		for (CFGNode breakStatement : thisCFG.getBreakStatements())
		{
			thisCFG.removeEdgesFrom(breakStatement);
			thisCFG.addEdge(breakStatement, target);
		}
		thisCFG.getBreakStatements().clear();
	}

	public static void fixContinueStatement(CCFG thisCFG, CFGNode target)
	{
		for (CFGNode continueStatement : thisCFG.getContinueStatements())
		{
			thisCFG.removeEdgesFrom(continueStatement);
			thisCFG.addEdge(continueStatement, target);
		}
		thisCFG.getContinueStatements().clear();
	}

	public static void fixGotoStatements(CCFG thisCFG)
	{
		for (Entry<CFGNode, String> entry : thisCFG.getGotoStatements().entrySet())
		{
			CFGNode gotoStatement = entry.getKey();
			String label = entry.getValue();
			thisCFG.removeEdgesFrom(gotoStatement);
			thisCFG.addEdge(gotoStatement, thisCFG.getBlockByLabel(label));
		}
		thisCFG.getGotoStatements().clear();
	}

	public static void fixReturnStatements(CCFG thisCFG)
	{
		for (CFGNode returnStatement : thisCFG.getReturnStatements())
		{
			thisCFG.removeEdgesFrom(returnStatement);
			thisCFG.addEdge(returnStatement, thisCFG.getExitNode());
		}
		thisCFG.getReturnStatements().clear();
	}
	
}
