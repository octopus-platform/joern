package tests.udg;

import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;

import parsing.ModuleParser;
import astnodes.ASTNode;
import astnodes.ASTNodeBuilder;
import astnodes.functionDef.FunctionDef;
import astwalking.ASTNodeVisitor;
import astwalking.ASTWalker;
import cfg.ASTToCFGConverter;
import cfg.CFG;

public class CFGCreator
{

	private class NodeVisitor extends ASTNodeVisitor
	{
		private CFG cfg;
		private ASTToCFGConverter astToCFG = new ASTToCFGConverter();

		public void visit(FunctionDef node)
		{
			cfg = astToCFG.convert(node);
		}

		public CFG getResult()
		{
			return cfg;
		}
	}

	private class Walker extends ASTWalker
	{

		NodeVisitor visitor = new NodeVisitor();

		@Override
		public void startOfUnit(ParserRuleContext ctx, String filename)
		{
		}

		@Override
		public void endOfUnit(ParserRuleContext ctx, String filename)
		{
		}

		@Override
		public void begin()
		{
		}

		@Override
		public void end()
		{
		}

		@Override
		public void processItem(ASTNode node, Stack<ASTNodeBuilder> nodeStack)
		{
			node.accept(visitor);
		}

		public CFG getResult()
		{
			return visitor.getResult();
		}

	}

	public CFG getCFGForCode(String code)
	{
		ModuleParser parser = new ModuleParser();
		Walker walker = new Walker();
		parser.addObserver(walker);
		parser.parseString(code);

		return walker.getResult();
	}

}
