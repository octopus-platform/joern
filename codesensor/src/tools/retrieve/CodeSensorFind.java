package tools.retrieve;

import java.io.IOException;

import org.apache.commons.cli.ParseException;
import org.apache.lucene.queryparser.flexible.core.QueryNodeException;
import org.apache.lucene.search.ScoreDoc;

import lucene.Finder;

public class CodeSensorFind
{

	public static void main(String[] args)
	{
		CommandLineInterface cli = new CommandLineInterface();
		
		try {
			cli.parseCommandLine(args);
		} catch (RuntimeException | ParseException e) {
			System.err.println(e.getMessage());
			cli.outputHelp();
			return;
		}
		
		String queryString = cli.getQuery();
		String directoryName = cli.getIndexDir();
		
		Finder finder = new Finder(directoryName);
		ScoreDoc[] documents;
		
		try {
			documents = finder.find(queryString);
		} catch (QueryNodeException | IOException e) {
			System.err.println(e.getMessage());
			return;
		}
				
		LocationPrinter locationPrinter = new LocationPrinter(finder);
		locationPrinter.print(documents);
	
	}
	
}
