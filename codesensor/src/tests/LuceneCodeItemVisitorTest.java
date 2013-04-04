package tests;

import lucene.LuceneCodeItemVisitor;
import main.codeitems.declarations.ClassDef;
import main.codeitems.function.FunctionDef;
import org.apache.lucene.document.Document;


import org.junit.Test;
import static org.junit.Assert.assertTrue;


public class LuceneCodeItemVisitorTest {
	
	@Test
	public void testVisitorPatternFunction()
	{
		LuceneCodeItemVisitor visitor = new LuceneCodeItemVisitor();
		FunctionDef functionDef = new FunctionDef();
		functionDef.accept(visitor);
		Document document = visitor.getDocuments().get(0);
		System.out.println(document.getField("type").stringValue());
		assertTrue(document.getField("type").stringValue().equals("function"));
	}
		
	@Test
	public void testVisitorPatternClass()
	{
		LuceneCodeItemVisitor visitor = new LuceneCodeItemVisitor();
		ClassDef functionDef = new ClassDef();
		functionDef.accept(visitor);
		Document document = visitor.getDocuments().get(0);
		System.out.println(document.getField("type").stringValue());
		assertTrue(document.getField("type").stringValue().equals("class"));
	}
	
	
}
