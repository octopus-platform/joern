package tests;

import lucene.LuceneCodeItemVisitor;
import lucene.TestDocumentWriter;
import main.codeitems.Name;
import main.codeitems.declarations.ClassDef;
import main.codeitems.declarations.IdentifierDecl;
import main.codeitems.declarations.IdentifierDeclType;
import main.codeitems.expressions.Expression;
import main.codeitems.function.FunctionDef;
import main.codeitems.functionContent.IdentifierDeclStatement;

import org.apache.lucene.document.Document;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;


public class LuceneCodeItemVisitorTest {
	
	LuceneCodeItemVisitor visitor;
	TestDocumentWriter writer;
	
	@Before
	public void initialize()
	{
		visitor = new LuceneCodeItemVisitor();
		writer = new TestDocumentWriter();
		visitor.setDocumentWriter(writer);
	}
	
	@Test
	public void testVisitorPatternFunction()
	{
		FunctionDef functionDef = new FunctionDef();
		functionDef.accept(visitor);
		Document document = writer.getDocuments().get(0);
		System.out.println(document.getFieldable("type").stringValue());
		assertTrue(document.getFieldable("type").stringValue().equals("function"));
	}
		
	@Test
	public void testVisitorPatternClass()
	{
		ClassDef functionDef = new ClassDef();
		functionDef.accept(visitor);
		Document document = writer.getDocuments().get(0);
		System.out.println(document.getFieldable("type").stringValue());
		assertTrue(document.getFieldable("type").stringValue().equals("type"));
	}
	
	@Test
	public void testVisitorWalkChildren()
	{
		Expression expression = new Expression();
		expression.addChild(new FunctionDef());
		expression.accept(visitor);
		Document document = writer.getDocuments().get(0);
		System.out.println(document.getFieldable("type").stringValue());
		assertTrue(document.getFieldable("type").stringValue().equals("function"));
	}
	
	@Test
	public void testLocalVar()
	{	
		FunctionDef item = new FunctionDef();
		IdentifierDeclStatement declStatement = new IdentifierDeclStatement();
		IdentifierDecl decl = new IdentifierDecl();
		decl.name = new Name();
		decl.type = new IdentifierDeclType();
		decl.type.completeType = "";
		declStatement.identifierDeclList.add(decl);
		
		item.addStatement(declStatement);
		item.accept(visitor);		
		assertTrue(writer.getDocuments().get(0).getFieldable("localName") != null);
	}
}
