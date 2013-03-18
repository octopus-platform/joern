package tests;

import static org.junit.Assert.*;

import java.util.List;

import main.TokenSubStream;
import main.FunctionParser.FunctionParser;
import main.codeitems.CodeItem;
import main.codeitems.functionContent.CallItem;
import main.codeitems.functionContent.CompoundItem;
import main.codeitems.functionContent.IfItem;
import main.processors.TestProcessor;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import antlr.FunctionGrammarLexer;
import antlr.FunctionGrammarParser.StatementsContext;

public class FunctionContentBuilderTest {

	@Test
	public void emptyContent()
	{
		String input = "";
		List<CodeItem> codeItems = parseAndWalk(input);
		CompoundItem item = (CompoundItem) codeItems.get(0);
		assert(item.statements.size() == 0);
	}
	
	@Test
	public void compoundWithoutBlockStart()
	{
		String input = "bar(); {}";
		List<CodeItem> codeItems = parseAndWalk(input);
		CompoundItem contentItem = (CompoundItem) codeItems.get(0);
		assertTrue(contentItem.statements.size() == 2);
	}
	
	@Test
	public void ifBlockCompound()
	{
		String input = "if(foo){}";
		List<CodeItem> codeItems = parseAndWalk(input);
		CompoundItem contentItem = (CompoundItem) codeItems.get(0);
		assertTrue(contentItem.statements.size() == 1);
	}
	
	@Test
	public void ifBlockNoCompound()
	{
		String input = "if(foo) bar();";
		List<CodeItem> codeItems = parseAndWalk(input);
		CompoundItem contentItem = (CompoundItem) codeItems.get(0);
		assertTrue(contentItem.statements.size() == 1);
	}
	
	@Test
	public void ifBlocksNoCompound()
	{
		String input = "if(foo) bar(); if(fooAgain) barAgain();";
		List<CodeItem> codeItems = parseAndWalk(input);
		CompoundItem contentItem = (CompoundItem) codeItems.get(0);
		assertTrue(contentItem.statements.size() == 2);
	}
	
	@Test
	public void nestedIfBlocksNoCompound()
	{
		String input = "if(foo) if(fooAgain) bar();";
		List<CodeItem> codeItems = parseAndWalk(input);
		CompoundItem contentItem = (CompoundItem) codeItems.get(0);
		assertTrue(contentItem.statements.size() == 1);
	}
	
	@Test
	public void ifElse()
	{
		String input = "if(foo) foo(); else bar();";
		List<CodeItem> codeItems = parseAndWalk(input);
		CompoundItem contentItem = (CompoundItem) codeItems.get(0);
		IfItem ifItem = (IfItem) contentItem.statements.get(0);
		
		assertTrue(contentItem.statements.size() == 1);
		assertTrue(ifItem.elseItem != null);
	}
	
	@Test
	public void testPreElseSkipping()
	{
		String input = "#if foo\n bar(); #else\n foo(); foo(); #endif";
		List<CodeItem> codeItems = parseAndWalk(input);
		CompoundItem contentItem = (CompoundItem) codeItems.get(0);
		System.out.println(contentItem.statements.size());
		assertTrue(contentItem.statements.size() == 1);
	}
	
	@Test
	public void testLineNumbers()
	{
		String input = "if(foo)\nbar();\nfoo()\n";
		StatementsContext ctx = (StatementsContext) parse(input);
		assert(ctx.start.getLine() == 1);
		assert(ctx.stop.getLine() == 3);
	}
	
	@Test
	public void testFuncCallCallee()
	{
		String input = "foo(x,y,z+1);";
		List<CodeItem> codeItems = parseAndWalk(input);
		CompoundItem contentItem = (CompoundItem) codeItems.get(0);
		CallItem item = (CallItem) contentItem.statements.get(0);
		assertTrue(item.callee.getCodeStr().equals("foo"));
	}
	
	private List<CodeItem> parseAndWalk(String input)
	{
		FunctionParser parser = new FunctionParser();		
		parser.setProcessor(new TestProcessor());
		TokenSubStream tokens = tokenStreamFromString(input);
		
		parser.parseAndWalkStream(tokens);
		TestProcessor processor = (TestProcessor) parser.listener.getProcessor();
		return processor.codeItems;
	}
	
		
	private ParseTree parse(String input)
	{
		FunctionParser parser = new FunctionParser();
		return parser.parse(input);
	}

	private TokenSubStream tokenStreamFromString(String input)
	{
		ANTLRInputStream inputStream = new ANTLRInputStream(input);
		FunctionGrammarLexer lex = new FunctionGrammarLexer(inputStream);
		TokenSubStream tokens = new TokenSubStream(lex);
		return tokens;
	}
	
}
