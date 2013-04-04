package lucene;

import java.util.LinkedList;
import java.util.List;

import main.codeitems.CodeItem;
import main.codeitems.CodeItemVisitor;
import main.codeitems.declarations.ClassDef;
import main.codeitems.function.FunctionDef;
import main.codeitems.functionContent.ExprStatementItem;
import main.codeitems.functionContent.IdentifierDeclStatement;

import org.apache.lucene.document.Document;

public class LuceneCodeItemVisitor extends CodeItemVisitor
{
	
	String filename = "";
	
	LinkedList<Document> documents = new LinkedList<Document>();
	
	
	public void setFilename(String aFilename)
	{
		filename = aFilename;
	}
	
	@Override
	public void visit(FunctionDef item)
	{
		Document newDocument = DocumentVendor.createNewDocument();
		documents.add(newDocument);
		FunctionDefToDocumentConverter.convert(item, filename, documents);
	}
	
	@Override
	public void visit(ClassDef item)
	{
		Document newDocument = DocumentVendor.createNewDocument();
		documents.add(newDocument);
		ClassDefToDocumentConverter.convert(item, filename, documents);
	}
		
	public List<Document> getDocuments()
	{
		return documents;
	}
	
	@Override public void visit(CodeItem item) {}
	@Override public void visit(IdentifierDeclStatement statementItem) {}
	@Override public void visit(ExprStatementItem statementItem) {}

}
