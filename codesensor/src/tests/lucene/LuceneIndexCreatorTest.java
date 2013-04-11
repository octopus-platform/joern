package tests.lucene;

import java.util.Stack;

import org.junit.Test;

import output.luceneIndex.LuceneIndexCreatorMain;
import astnodes.ASTNodeBuilder;
import astnodes.functionDef.FunctionDef;

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
		indexCreator.processItem(new FunctionDef(), new Stack<ASTNodeBuilder>());
		indexCreator.end();
	}
	
	
}
