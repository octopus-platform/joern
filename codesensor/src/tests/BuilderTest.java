package tests;

import static org.junit.Assert.*;

import java.util.List;

import main.TokenSubStream;
import main.ShallowParser.ShallowParser;
import main.codeitems.CodeItem;
import main.processors.TestProcessor;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import antlr.CodeSensorLexer;

public class BuilderTest {

	@Test
	public void test()
	{
		String input = "struct x{ struct y {}; };";
		List<CodeItem> codeItems = parseInput(input);
		System.out.println(codeItems.size());
		assertTrue(codeItems.size() == 2);
	}

	private List<CodeItem> parseInput(String input)
	{
		ShallowParser parser = new ShallowParser();		
		parser.setProcessor(new TestProcessor());
		
		ANTLRInputStream inputStream = new ANTLRInputStream(input);
		CodeSensorLexer lex = new CodeSensorLexer(inputStream);
		TokenSubStream tokens = new TokenSubStream(lex);
		
		ParseTree tree = parser.parseTokenStream(tokens);
		parser.walkParseTree(tokens, tree);
		
		
		System.out.println(tree.toString());
		TestProcessor processor = (TestProcessor) parser.listener.getProcessor();
		return processor.codeItems;
	}

}
