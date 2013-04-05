package tools.retrieve;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import lucene.Finder;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Fieldable;
import org.apache.lucene.search.ScoreDoc;

public class OutputModule
{
	Finder finder;
	
	public OutputModule(Finder aFinder)
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
		String filename = document.getFieldable("filename").stringValue();
		String positionStr = document.getFieldable("location").stringValue();				
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
		
		List<Fieldable> fields = document.getFields();
		Iterator<Fieldable> it = fields.iterator();
		
		while(it.hasNext())
		{
			Fieldable field = it.next();
			String name = field.name();
			String fieldValue = field.stringValue();
			addFieldValueToMap(map, name, fieldValue);				
		}
		return map;
	}

	private void addFieldValueToMap(Map<String, StringBuilder> map,
			String name, String fieldValue)
	{
		StringBuilder stringBuilder = map.get(name);
		
		if(stringBuilder == null){
			stringBuilder = new StringBuilder("\"" + fieldValue + "\"");
			map.put(name, stringBuilder);
		}else{			
			stringBuilder.append(", \"");
			fieldValue = fieldValue.replace("\"", "\\\"");
			stringBuilder.append(fieldValue);
			stringBuilder.append("\"");
		}
	}
	
}
