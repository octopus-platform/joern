package tests;

import static org.junit.Assert.*;

import java.util.List;

import main.TokenSubStream;
import main.FunctionParser.FunctionParser;
import main.codeitems.CodeItem;
import main.codeitems.functionContent.CompoundItem;
import main.processors.TestProcessor;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.junit.Test;

import antlr.FunctionGrammarLexer;

public class FunctionContentBuilderTest {

	@Test
	public void emptyContent()
	{
		String input = "";
		List<CodeItem> codeItems = parseInput(input);
		CompoundItem item = (CompoundItem) codeItems.get(0);
		assert(item.statements.size() == 0);
	}
	
	@Test
	public void ifBlockCompound()
	{
		String input = "if(foo){}";
		List<CodeItem> codeItems = parseInput(input);
		CompoundItem contentItem = (CompoundItem) codeItems.get(0);
		assertTrue(contentItem.statements.size() == 1);
	}
	
	@Test
	public void ifBlockNoCompound()
	{
		String input = "if(foo) bar();";
		List<CodeItem> codeItems = parseInput(input);
		CompoundItem contentItem = (CompoundItem) codeItems.get(0);
		assertTrue(contentItem.statements.size() == 1);
	}
	
	@Test
	public void ifBlocksNoCompound()
	{
		String input = "if(foo) bar(); if(fooAgain) barAgain();";
		List<CodeItem> codeItems = parseInput(input);
		CompoundItem contentItem = (CompoundItem) codeItems.get(0);
		assertTrue(contentItem.statements.size() == 2);
	}
	
	@Test
	public void nestedIfBlocksNoCompound()
	{
		String input = "if(foo) if(fooAgain) bar();";
		List<CodeItem> codeItems = parseInput(input);
		CompoundItem contentItem = (CompoundItem) codeItems.get(0);
		assertTrue(contentItem.statements.size() == 1);
	}
	
	@Test
	public void ifElse()
	{
		String input = "if(foo) foo(); else bar();";
		List<CodeItem> codeItems = parseInput(input);
		CompoundItem contentItem = (CompoundItem) codeItems.get(0);
		System.out.println(contentItem.statements.size());
		assertTrue(contentItem.statements.size() == 1);
	}
	
	@Test
	public void testPreElseSkipping()
	{
		String input = "#if foo\n bar(); #else\n foo(); foo(); #endif";
		List<CodeItem> codeItems = parseInput(input);
		CompoundItem contentItem = (CompoundItem) codeItems.get(0);
		System.out.println(contentItem.statements.size());
		assertTrue(contentItem.statements.size() == 1);
	}
		
	private List<CodeItem> parseInput(String input)
	{
		FunctionParser parser = new FunctionParser();		
		parser.setProcessor(new TestProcessor());
		
		ANTLRInputStream inputStream = new ANTLRInputStream(input);
		FunctionGrammarLexer lex = new FunctionGrammarLexer(inputStream);
		TokenSubStream tokens = new TokenSubStream(lex);
		
		parser.parseAndWalkStream(tokens);
		TestProcessor processor = (TestProcessor) parser.listener.getProcessor();
		return processor.codeItems;
	}
	
}
