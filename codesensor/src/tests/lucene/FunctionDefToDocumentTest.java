package tests.lucene;

import static org.junit.Assert.assertTrue;


import java.util.Stack;


import org.apache.lucene.document.Document;
import org.junit.Before;
import org.junit.Test;

import output.luceneIndex.FunctionDefToDocumentConverter;

import astnodes.functionDef.FunctionDef;
import astnodes.functionDef.Parameter;

@SuppressWarnings("deprecation")
public class FunctionDefToDocumentTest
{
	Document document;
	Stack<Document> documents = new Stack<Document>();
	
	@Before
	public void initialize()
	{
		document = new Document();
		documents.add(document);
	}
	
	@Test
	public void testUnnamedFunction()
	{		
		FunctionDef item = new FunctionDef();
		FunctionDefToDocumentConverter.convert(item, "", documents.peek());
		String nameInDoc = document.getField("name").stringValue();
		assertTrue(nameInDoc.equals("<unnamed>"));
	}	
	
	@Test
	public void testNoParams()
	{		
		FunctionDef item = new FunctionDef();
		FunctionDefToDocumentConverter.convert(item, "", documents.peek());
		assertTrue(document.getField("parameterName") == null);
	}
	
	@Test
	public void testSingleParamName()
	{		
		FunctionDef item = new FunctionDef();
		item.addParameter(new Parameter());
		FunctionDefToDocumentConverter.convert(item, "", documents.peek());
		assertTrue(document.getField("parameterName") != null);
	}
	
	@Test
	public void testSingleParamType()
	{		
		FunctionDef item = new FunctionDef();
		item.addParameter(new Parameter());
		FunctionDefToDocumentConverter.convert(item, "", documents.peek());
		assertTrue(document.getField("parameterType") != null);
	}
	
}
