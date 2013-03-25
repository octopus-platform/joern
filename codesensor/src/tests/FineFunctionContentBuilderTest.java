package tests;

import static org.junit.Assert.*;

import java.util.List;

import main.TokenSubStream;
import main.FineFunctionParser.FineFunctionParser;
import main.codeitems.CodeItem;
import main.codeitems.functionContent.CompoundItem;
import main.codeitems.functionContent.IfItem;
import main.processors.TestProcessor;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import antlr.FineFunctionGrammarLexer;
import antlr.FineFunctionGrammarParser.StatementsContext;

public class FineFunctionContentBuilderTest {

	@Test
	public void emptyContent()
	{
		String input = "";
		CompoundItem item = (CompoundItem) parseAndWalk(input);
		assert(item.statements.size() == 0);
	}
	
	@Test
	public void compoundWithoutBlockStart()
	{
		String input = "bar(); {}";
		CompoundItem item = (CompoundItem) parseAndWalk(input);
		assertTrue(item.statements.size() == 2);
	}
	
	@Test
	public void ifBlockCompound()
	{
		String input = "if(foo){}";
		CompoundItem item = (CompoundItem) parseAndWalk(input);
		assertTrue(item.statements.size() == 1);
	}
	
	@Test
	public void ifBlockNoCompound()
	{
		String input = "if(foo) bar();";
		CompoundItem item = (CompoundItem) parseAndWalk(input);
		assertTrue(item.statements.size() == 1);
	}
	
	@Test
	public void NestedIfndefs()
	{
		String input = "#ifdef foo\n#else\n #ifdef foo\n#else\n#endif\n#endif";
		CompoundItem item = (CompoundItem) parseAndWalk(input);
		assertTrue(item.statements.size() == 0);
	}
	
	@Test
	public void nestedIfBlocksNoCompound()
	{
		String input = "if(foo) if(fooAgain) bar();";
		CompoundItem item = (CompoundItem) parseAndWalk(input);
		assertTrue(item.statements.size() == 1);
	}
	
	@Test
	public void ifElse()
	{
		String input = "if(foo) foo(); else bar();";
		CompoundItem contentItem = (CompoundItem) parseAndWalk(input);
		IfItem ifItem = (IfItem) contentItem.statements.get(0);
		
		System.out.println(contentItem.statements.size());
		
		assertTrue(ifItem.elseItem != null);
		assertTrue(contentItem.statements.size() == 1);
		
	}
	
	@Test
	public void testPreElseSkipping()
	{
		String input = "#if foo\n bar(); #else\n foo(); foo(); #endif";
		CompoundItem contentItem = (CompoundItem) parseAndWalk(input);
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
	
	
	private CodeItem parseAndWalk(String input)
	{
		FineFunctionParser parser = new FineFunctionParser();		
		TokenSubStream tokens = tokenStreamFromString(input);
		
		parser.parseAndWalkStream(tokens);
		return parser.itemStack.peek().getItem();
	}
	
		
	private ParseTree parse(String input)
	{
		FineFunctionParser parser = new FineFunctionParser();
		return parser.parseString(input);
	}

	private TokenSubStream tokenStreamFromString(String input)
	{
		ANTLRInputStream inputStream = new ANTLRInputStream(input);
		FineFunctionGrammarLexer lex = new FineFunctionGrammarLexer(inputStream);
		TokenSubStream tokens = new TokenSubStream(lex);
		return tokens;
	}
	
}
