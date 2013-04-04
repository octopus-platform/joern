package tests;

import java.util.Stack;

import lucene.LuceneIndexCreator;
import main.codeitems.CodeItemBuilder;
import main.codeitems.function.FunctionDef;

import org.junit.Test;

public class LuceneIndexCreatorTest {

	public static LuceneIndexCreator createValidIndexCreator()
	{
		LuceneIndexCreator indexCreator = new LuceneIndexCreator();
		indexCreator.setIndexDirectoryName("/tmp/foo/bar");
		indexCreator.begin();
		return indexCreator;
	}
	
	@Test(expected=RuntimeException.class)
	public void testDirectoryNameUnset()
	{
		LuceneIndexCreator indexCreator = new LuceneIndexCreator();
		indexCreator.begin();
	}

	@Test
	public void testEmptyIndex()
	{
		LuceneIndexCreator indexCreator = createValidIndexCreator();
		indexCreator.end();
	}
	
	@Test
	public void testInsert()
	{
		LuceneIndexCreator indexCreator = createValidIndexCreator();
		indexCreator.processItem(new FunctionDef(), new Stack<CodeItemBuilder>());
		indexCreator.end();
	}
	
	
}
