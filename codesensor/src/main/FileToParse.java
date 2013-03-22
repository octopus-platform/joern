package main;

import org.antlr.v4.runtime.ANTLRFileStream;

public class FileToParse {
	
	public ANTLRFileStream stream;
	public String filename = null;

	public boolean isEndMarker()
	{
		return (filename == null);
	}
}
