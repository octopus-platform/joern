package tests.parseTreeToAST;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ast.statements.CompoundStatement;

public class PreprocessorTests
{

	@Test
	public void NestedIfndefs()
	{
		String input = "#ifdef foo\n#else\n #ifdef foo\n#else\n#endif\n#endif";
		CompoundStatement item = (CompoundStatement) FunctionContentTestUtil
				.parseAndWalk(input);
		assertTrue(item.getStatements().size() == 0);
	}

	@Test
	public void testPreElseSkipping()
	{
		String input = "#if foo\n bar(); #else\n foo(); foo(); #endif";
		CompoundStatement contentItem = (CompoundStatement) FunctionContentTestUtil
				.parseAndWalk(input);
		System.out.println(contentItem.getStatements().size());
		assertTrue(contentItem.getStatements().size() == 1);
	}

}
