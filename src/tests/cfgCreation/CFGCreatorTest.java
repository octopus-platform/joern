package tests.cfgCreation;

import java.util.List;

import org.junit.Before;

import tests.parseTreeToAST.FunctionContentTestUtil;
import astnodes.ASTNode;
import astnodes.statements.CompoundStatement;
import cfg.ASTToCFGConverter;
import cfg.CFG;
import cfg.nodes.ASTNodeContainer;
import cfg.nodes.CFGNode;

public class CFGCreatorTest
{
	ASTToCFGConverter converter;

	@Before
	public void init()
	{
		converter = new ASTToCFGConverter();
	}

	public CFG getCFGForCode(String input)
	{
		CompoundStatement contentItem = (CompoundStatement) FunctionContentTestUtil
				.parseAndWalk(input);
		// return converter.convertCompoundStatement(contentItem);
		return CFG.newInstance(contentItem);
	}

	protected ASTNode getConditionNode(CFG cfg)
	{
		List<CFGNode> statements = cfg.getVertices();
		CFGNode conditionBlock = statements.get(0);
		ASTNode astNode = ((ASTNodeContainer) conditionBlock).getASTNode();
		return astNode;
	}

}
