package tools.retrieve;

import lucene.Finder;

public class CodeSensorFind
{

	public static void main(String[] args)
	{
		String queryString = "call:malloc* and !test*";
		String directoryName = "/home/fabs/tmp/lucene/";		
		Finder finder = new Finder(directoryName);
		finder.find(queryString);
	}
	
}
