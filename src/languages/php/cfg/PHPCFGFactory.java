package languages.php.cfg;

import java.util.Iterator;

import ast.expressions.Expression;
import ast.logical.statements.Statement;
import ast.php.statements.blockstarters.ForEachStatement;
import ast.php.statements.blockstarters.PHPIfElement;
import ast.php.statements.blockstarters.PHPIfStatement;
import ast.statements.blockstarters.IfStatement;
import cfg.CFG;
import cfg.CFGEdge;
import cfg.CFGFactory;
import cfg.nodes.ASTNodeContainer;
import cfg.nodes.CFGNode;

public class PHPCFGFactory extends CFGFactory
{
	static{
		structuredFlowVisitior = new PHPStructuredFlowVisitor();
	}

	public PHPCFGFactory()
	{
		structuredFlowVisitior = new PHPStructuredFlowVisitor();
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

}
