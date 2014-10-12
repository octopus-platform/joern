package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import fileWalker.SourceFileWalker;
import fileWalker.UnorderedWalker;

public class CodebaseWalkerTest
{

	@Test
	public void testRecursiveDirSearch()
	{
		String[] args = { "src/tests/samples/" };

		SourceFileWalker provider = new UnorderedWalker();

		try
		{
			String expected = "[src/tests/samples/test.c, src/tests/samples/subdir/test.c, src/tests/samples/tiff.cpp]";
			FilenameAggregator listener = new FilenameAggregator();
			provider.addListener(listener);
			provider.walk(args);

			assertTrue(expected.equals(listener.filenames.toString()));
		}
		catch (IOException e)
		{
			fail("IO Error");
		}
	}

}
