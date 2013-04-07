package tests;

import java.util.Stack;

import lucene.LuceneIndexCreatorMain;
import main.codeitems.CodeItemBuilder;
import main.codeitems.functionDef.FunctionDef;

import org.junit.Test;

public class LuceneIndexCreatorTest {

	public static LuceneIndexCreatorMain createValidIndexCreator()
	{
		LuceneIndexCreatorMain indexCreator = new LuceneIndexCreatorMain();
		indexCreator.setIndexDirectoryName("/tmp/foo/bar");
		indexCreator.begin();
		return indexCreator;
	}
	
	@Test
	public void testEmptyIndex()
	{
		LuceneIndexCreatorMain indexCreator = createValidIndexCreator();
		indexCreator.end();
	}
	
	@Test
	public void testInsert()
	{
		LuceneIndexCreatorMain indexCreator = createValidIndexCreator();
		indexCreator.processItem(new FunctionDef(), new Stack<CodeItemBuilder>());
		indexCreator.end();
	}
	
	
}
