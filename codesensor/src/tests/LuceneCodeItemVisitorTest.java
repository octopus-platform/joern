package tests;

import java.util.LinkedList;

import lucene.FunctionDefToDocumentConverter;
import lucene.LuceneCodeItemVisitor;
import main.codeitems.Name;
import main.codeitems.declarations.ClassDef;
import main.codeitems.declarations.IdentifierDecl;
import main.codeitems.declarations.IdentifierDeclType;
import main.codeitems.expressions.Expression;
import main.codeitems.function.FunctionDef;
import main.codeitems.functionContent.IdentifierDeclStatement;

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
		System.out.println(document.getFieldable("type").stringValue());
		assertTrue(document.getFieldable("type").stringValue().equals("function"));
	}
		
	@Test
	public void testVisitorPatternClass()
	{
		LuceneCodeItemVisitor visitor = new LuceneCodeItemVisitor();
		ClassDef functionDef = new ClassDef();
		functionDef.accept(visitor);
		Document document = visitor.getDocuments().get(0);
		System.out.println(document.getFieldable("type").stringValue());
		assertTrue(document.getFieldable("type").stringValue().equals("type"));
	}
	
	@Test
	public void testVisitorWalkChildren()
	{
		LuceneCodeItemVisitor visitor = new LuceneCodeItemVisitor();
		Expression expression = new Expression();
		expression.addChild(new FunctionDef());
		expression.accept(visitor);
		Document document = visitor.getDocuments().get(0);
		System.out.println(document.getFieldable("type").stringValue());
		assertTrue(document.getFieldable("type").stringValue().equals("function"));
	}
	
	@Test
	public void testLocalVar()
	{	
		LuceneCodeItemVisitor visitor = new LuceneCodeItemVisitor();
		FunctionDef item = new FunctionDef();
		IdentifierDeclStatement declStatement = new IdentifierDeclStatement();
		IdentifierDecl decl = new IdentifierDecl();
		decl.name = new Name();
		decl.type = new IdentifierDeclType();
		decl.type.completeType = "";
		declStatement.identifierDeclList.add(decl);
		
		item.addStatement(declStatement);
		item.accept(visitor);		
		assertTrue(visitor.getDocuments().get(0).getFieldable("localName") != null);
	}
}
