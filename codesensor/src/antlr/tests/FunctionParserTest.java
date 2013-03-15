package antlr.tests;

import main.FunctionParser.FunctionParser;

import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

public class FunctionParserTest {

	@Test
	public void test()
	{
		String input = "if(foo){ +; bar();}";
		FunctionParser functionParser = new FunctionParser();
		ParseTree tree = functionParser.parse(input);
		System.out.println(tree.toStringTree(functionParser.parser));
	}

}
