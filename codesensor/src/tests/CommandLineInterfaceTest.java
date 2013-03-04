package tests;

import static org.junit.Assert.*;

import java.io.IOException;

import main.CommandLineInterface;

import org.junit.Test;


public class CommandLineInterfaceTest {

	@Test
	public void testRecursiveDirSearch()
	{
		String [] args = {"src/samples/"};
		CommandLineInterface cmd = new CommandLineInterface();
		cmd.parseCommandLine(args);
		
		try {
			String expected = "[src/samples/test.c, src/samples/subdir/test.c]";
			assertTrue(expected.equals(cmd.getFilesToProcess().toString()));
		} catch (IOException e) {
			fail("IO Error");
		}
	}

}
