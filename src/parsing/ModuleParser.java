package parsing;

import java.util.Observer;

public class ModuleParser
{
	ANTLRParserDriver parserDriver;
	
	public ModuleParser(ANTLRParserDriver driver)
	{
		parserDriver = driver;
	}
	
	public void parseFile(String filename)
	{
		System.out.println(filename);

		try
		{
			parserDriver.parseAndWalkFile(filename);
		}
		catch (ParserException ex)
		{
			System.err.println("Error parsing file: " + filename);
		}
	}

	public void addObserver(Observer anObserver)
	{
		parserDriver.addObserver(anObserver);
	}
	
	/*
	 * Testing
	 **/
	
	public void parseString(String code)
	{
		try
		{
			parserDriver.parseAndWalkString(code);
		}
		catch (ParserException ex)
		{
			System.err.println("Error parsing string.");
		}
	}

}
