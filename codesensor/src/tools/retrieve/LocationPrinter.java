package tools.retrieve;

import java.io.IOException;

import lucene.Finder;

import org.apache.lucene.document.Document;
import org.apache.lucene.search.ScoreDoc;

public class LocationPrinter
{
	Finder finder;
	
	public LocationPrinter(Finder aFinder)
	{
		finder = aFinder;
	}

	public void print(ScoreDoc[] documents)
	{
		try {
			for(ScoreDoc doc : documents){	
				Document document = finder.getDocumentById(doc.doc);
				String filename = document.getField("filename").stringValue();
				String stringValue = document.getField("location").stringValue();
				// String codeStr = document.getField("code").stringValue();				
				System.out.println(filename + ":" + stringValue);
			}
		
		} catch (IOException e)
		{
			System.err.println(e.getMessage());
		}
	}
	
}
