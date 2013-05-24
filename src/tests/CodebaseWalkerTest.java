package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import tools.index.CodebaseWalker;


public class CodebaseWalkerTest {

	@Test
	public void testRecursiveDirSearch()
	{
		String [] args = {"src/tests/samples/"};
		
		CodebaseWalker provider = new CodebaseWalker();
		
		try {
			String expected = "[src/tests/samples/test.c, src/tests/samples/tiff.cpp, src/tests/samples/subdir/test.c]";
			FilenameAggregator listener = new FilenameAggregator();
			provider.addListener(listener);
			provider.walkUserSpecifiedFiles(args);
			
			assertTrue(expected.equals(listener.filenames.toString()));
		} catch (IOException e) {
			fail("IO Error");
		}
	}

}
