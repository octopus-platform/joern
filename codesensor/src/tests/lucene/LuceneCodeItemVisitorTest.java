package tests.lucene;

import lucene.LuceneCodeItemVisitor;
import lucene.TestDocumentWriter;

import org.apache.lucene.document.Document;

import org.junit.Before;
import org.junit.Test;

import astnodes.ASTNode;
import astnodes.declarations.ClassDef;
import astnodes.declarations.IdentifierDecl;
import astnodes.declarations.IdentifierDeclType;
import astnodes.expressions.CallExpression;
import astnodes.expressions.Expression;
import astnodes.expressions.Identifier;
import astnodes.functionDef.FunctionDef;
import astnodes.statements.Condition;
import astnodes.statements.ExprStatementItem;
import astnodes.statements.IdentifierDeclStatement;
import astnodes.statements.IfItem;
import astnodes.statements.Statement;
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
	public void testVisitCall()
	{
		FunctionDef item = new FunctionDef();
		
		ExprStatementItem exprStatement = new ExprStatementItem();
		CallExpression callExpression = new CallExpression();
		exprStatement.addChild(callExpression);
		item.addStatement(exprStatement);	
		item.accept(visitor);
		Document d = writer.getDocuments().get(0);
		assertTrue(d.getFieldable("exprType") != null);
	}
	
	@Test
	public void testVisitIfTerminates()
	{
		FunctionDef item = new FunctionDef();
		
		IfItem ifItem = new IfItem();
		Condition condition = new Condition();
		condition.addChild(new Expression());
		ifItem.setCondition(condition);
		ifItem.addChild(new Statement());
		item.addStatement(ifItem);	
		item.accept(visitor);
	}
	
	@Test
	public void testLocalVar()
	{	
		FunctionDef item = new FunctionDef();
		IdentifierDeclStatement declStatement = new IdentifierDeclStatement();
		IdentifierDecl decl = new IdentifierDecl();
		decl.name = new Identifier();
		decl.type = new IdentifierDeclType();
		decl.type.completeType = "";
		declStatement.addChild(decl);
		
		item.addStatement(declStatement);
		item.accept(visitor);
		assertTrue(writer.getDocuments().get(0).getFieldable("localName") != null);
	}
}
