package parsing;

import java.util.List;
import java.util.Observer;

public class ModuleParser
{
	ANTLRModuleParserDriver parserDriver = new ANTLRModuleParserDriver();

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

	public void addObserver(Observer anObserver)
	{
		parserDriver.addObserver(anObserver);
	}

	// Not used?
	public void parseListOfFiles(List<String> filenames)
	{
		parserDriver.begin();

		for (String filename : filenames)
			parseFile(filename);

		parserDriver.end();
	}

}
