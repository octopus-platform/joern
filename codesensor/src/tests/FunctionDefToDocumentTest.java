package tests;

import static org.junit.Assert.assertTrue;

import java.util.LinkedList;

import lucene.FunctionDefToDocumentConverter;
import main.codeitems.Name;
import main.codeitems.declarations.IdentifierDecl;
import main.codeitems.function.FunctionDef;
import main.codeitems.function.Parameter;
import main.codeitems.functionContent.IdentifierDeclStatement;

import org.apache.lucene.document.Document;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("deprecation")
public class FunctionDefToDocumentTest
{
	Document document;
	LinkedList<Document> documents = new LinkedList<Document>();
	
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
		FunctionDefToDocumentConverter.convert(item, "", documents);
		String nameInDoc = document.getField("name").stringValue();
		assertTrue(nameInDoc.equals("<unnamed>"));
	}	
	
	@Test
	public void testNoParams()
	{		
		FunctionDef item = new FunctionDef();
		FunctionDefToDocumentConverter.convert(item, "", documents);
		assertTrue(document.getField("parameterName") == null);
	}
	
	@Test
	public void testSingleParamName()
	{		
		FunctionDef item = new FunctionDef();
		item.addParameter(new Parameter());
		FunctionDefToDocumentConverter.convert(item, "", documents);
		assertTrue(document.getField("parameterName") != null);
	}
	
	@Test
	public void testSingleParamType()
	{		
		FunctionDef item = new FunctionDef();
		item.addParameter(new Parameter());
		FunctionDefToDocumentConverter.convert(item, "", documents);
		assertTrue(document.getField("parameterType") != null);
	}
	
}
