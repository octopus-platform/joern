package lucene;

import java.util.Iterator;

import main.codeitems.CodeItem;
import main.codeitems.CodeItemVisitor;
import main.codeitems.declarations.ClassDef;
import main.codeitems.declarations.IdentifierDecl;
import main.codeitems.expressions.CallItem;
import main.codeitems.function.FunctionDef;
import main.codeitems.functionContent.ExprStatementItem;
import main.codeitems.functionContent.IdentifierDeclStatement;

import org.apache.lucene.document.Document;


public class StatementInfoExtractor implements CodeItemVisitor
{
	Document d;

	void setDocument(Document aD)
	{
		d = aD;
	}
	
	@Override
	public void visit(CallItem statementItem)
	{
		d.add(LuceneUtils.createField("call", statementItem.callee));
	}

	@Override
	public void visit(IdentifierDeclStatement statementItem)
	{
		Iterator<IdentifierDecl> it = statementItem.identifierDeclList.iterator();
		while(it.hasNext()){
			IdentifierDecl idDecl = it.next();
			String name = idDecl.name.getCodeStr();
			String completeType = idDecl.type.completeType;
			d.add(LuceneUtils.createField("localName", name));
			d.add(LuceneUtils.createField("localType", completeType));
		}
	}

	@Override
	public void visit(ClassDef statementItem)
	{
		String name = statementItem.getName().getCodeStr();
		d.add(LuceneUtils.createField("subClassName", name));
	}
	
	@Override
	public void visit(ExprStatementItem statementItem)
	{
		// TODO: fix this
		// String codeStr = statementItem.getCodeStr();
		// d.add(LuceneUtils.createField("field", codeStr));
	}

	@Override
	public void visit(CodeItem statementItem){}

	@Override
	public void visit(FunctionDef item) {
		// TODO Auto-generated method stub
		
	}

}
