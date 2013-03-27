package tools.retrieve;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import lucene.Finder;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexableField;
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
				System.out.println(getLocationString(document));
				printSummary(document);
			}
		
		} catch (IOException e)
		{
			System.err.println(e.getMessage());
		}
	}
	
	private String getLocationString(Document document)
	{
		String filename = document.getField("filename").stringValue();
		String positionStr = document.getField("location").stringValue();				
		return filename + ":" + positionStr;
	}
	
	private void printSummary(Document document)
	{
		Map<String, StringBuilder> map = getFieldMap(document);
		
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()){
			String fieldName = it.next();
			StringBuilder fieldValueBuilder = map.get(fieldName);
			String fieldValue = fieldValueBuilder.toString();
			System.out.format("%s: %s\n", fieldName, fieldValue);
		}
		System.out.println("");
	}

	private Map<String, StringBuilder> getFieldMap(Document document)
	{
		Map<String, StringBuilder> map = new TreeMap<String, StringBuilder>();
		List<IndexableField> fields = document.getFields();
		Iterator<IndexableField> it = fields.iterator();
		
		while(it.hasNext())
		{
			IndexableField field = it.next();
			String name = field.name();
			String fieldValue = field.stringValue();
			StringBuilder stringBuilder = map.get(name);
			
			if(stringBuilder == null){
				stringBuilder = new StringBuilder(fieldValue);
				map.put(name, stringBuilder);
			}else{			
				stringBuilder.append(", ");
				stringBuilder.append(fieldValue);
			}				
		}
		return map;
	}
	
}
