package tests;

import static org.junit.Assert.*;

import lucene.FunctionDefToDocumentConverter;
import main.codeitems.function.FunctionDef;
import main.codeitems.function.Parameter;


import org.apache.lucene.document.Document;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("deprecation")
public class FunctionDefToDocumentTest
{
	Document document;
	
	@Before
	public void initialize()
	{
		document = new Document();
	}


	@Test
	public void testUnnamedFunction()
	{		
		FunctionDef item = new FunctionDef();
		FunctionDefToDocumentConverter.convert(item, "", document);
		String nameInDoc = document.getField("name").stringValue();
		assertTrue(nameInDoc.equals("<unnamed>"));
	}	
	
	@Test
	public void testNoParams()
	{		
		FunctionDef item = new FunctionDef();
		FunctionDefToDocumentConverter.convert(item, "", document);
		assertTrue(document.getField("parameterName") == null);
	}
	
	@Test
	public void testSingleParam()
	{		
		FunctionDef item = new FunctionDef();
		item.addParameter(new Parameter());
		FunctionDefToDocumentConverter.convert(item, "", document);
		assertTrue(document.getField("parameterName") != null);
	}
	
}
