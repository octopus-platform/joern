package lucene;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import lucene.DocumentFactory.DocumentType;
import main.codeitems.CodeItemVisitor;
import main.codeitems.declarations.ClassDef;
import main.codeitems.declarations.IdentifierDecl;
import main.codeitems.function.FunctionDef;
import main.codeitems.functionContent.ExprStatementItem;
import main.codeitems.functionContent.IdentifierDeclStatement;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.KeywordAnalyzer;
import org.apache.lucene.document.Document;

public class LuceneCodeItemVisitor extends CodeItemVisitor
{
	
	String filename = "";
	
	Stack<Document> documents = new Stack<Document>();
	Analyzer analyzer = new KeywordAnalyzer();
	LuceneIndexWriter writer = new LuceneIndexWriter(analyzer);
	
	
	public void setFilename(String aFilename)
	{
		filename = aFilename;
	}
	
	public void setIndexDirectoryName(String dirName)
	{
		writer.setIndexDirectoryName(dirName);
		writer.initialize();
	}
	
	public void visit(FunctionDef item)
	{
		Document newDocument = DocumentFactory.createNewDocument(DocumentType.FUNCTION);
		documents.push(newDocument);
		FunctionDefToDocumentConverter.convert(item, filename, documents);
		visitChildren(item);
	}
	
	public void visit(ClassDef item)
	{
		Document newDocument = DocumentFactory.createNewDocument(DocumentType.TYPE);
		documents.add(newDocument);
		ClassDefToDocumentConverter.convert(item, filename, documents);
		visitChildren(item);
	}
	
	public void visit(IdentifierDeclStatement statementItem)
	{
		Document d = documents.peek();
		Iterator<IdentifierDecl> it = statementItem.identifierDeclList.iterator();
		while(it.hasNext()){
			IdentifierDecl idDecl = it.next();
			String name = idDecl.name.getCodeStr();
			String completeType = idDecl.type.completeType;
			d.add(LuceneUtils.createField("localName", name));
			d.add(LuceneUtils.createField("localType", completeType));
		}
	
		visitChildren(statementItem);
	}
	
	public void visit(ExprStatementItem statementItem)
	{
		// TODO: implement me
		visitChildren(statementItem);
	}
	
	public List<Document> getDocuments()
	{
		return documents;
	}

	public void shutdown()
	{
		writer.shutdown();
	}

}
