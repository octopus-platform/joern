package lucene;

import java.util.Iterator;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;

import main.codeitems.declarations.IdentifierDecl;
import main.codeitems.expressions.CallItem;
import main.codeitems.functionContent.ExprStatementItem;
import main.codeitems.functionContent.IdentifierDeclStatement;
import main.codeitems.functionContent.StatementItem;
import main.codeitems.functionContent.StatementVisitor;

public class StatementInfoExtractor implements StatementVisitor
{
	Document d;

	void setDocument(Document aD)
	{
		d = aD;
	}
	
	@Override
	public void visit(CallItem statementItem)
	{
		d.add(new TextField("call", statementItem.callee, Field.Store.YES));
	}

	@Override
	public void visit(IdentifierDeclStatement statementItem)
	{
		Iterator<IdentifierDecl> it = statementItem.identifierDeclList.iterator();
		while(it.hasNext()){
			IdentifierDecl idDecl = it.next();
			String name = idDecl.name.getCodeStr();
			String completeType = idDecl.type.completeType;
			d.add(new TextField("localName", name, Field.Store.YES));
			d.add(new TextField("localType", completeType, Field.Store.YES));
		}
	}

	@Override
	public void visit(ExprStatementItem statementItem)
	{
		String codeStr = statementItem.getCodeStr();
		d.add(new TextField("field", codeStr, Field.Store.YES));
	}

	@Override
	public void visit(StatementItem statementItem){}
	
}
