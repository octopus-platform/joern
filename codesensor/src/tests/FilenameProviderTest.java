package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import tools.index.FilenameProvider;


public class FilenameProviderTest {

	@Test
	public void testRecursiveDirSearch()
	{
		String [] args = {"src/samples/"};
		
		FilenameProvider provider = new FilenameProvider();
		
		try {
			String expected = "[src/samples/test.c, src/samples/tiff.cpp, src/samples/subdir/test.c]";
			List<String> filesProvided = provider.getFilesToProcess(args);
			assertTrue(expected.equals(filesProvided.toString()));
		} catch (IOException e) {
			fail("IO Error");
		}
	}

}
