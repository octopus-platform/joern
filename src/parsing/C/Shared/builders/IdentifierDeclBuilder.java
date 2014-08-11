package parsing.C.Shared.builders;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import parsing.ParseTreeUtils;
import parsing.C.Shared.InitDeclContextWrapper;
import ast.ASTNodeBuilder;
import ast.declarations.IdentifierDecl;
import ast.declarations.IdentifierDeclType;
import ast.expressions.Identifier;

public class IdentifierDeclBuilder extends ASTNodeBuilder
{
	IdentifierDecl thisItem;

	@Override
	public void createNew(ParserRuleContext ctx)
	{
		item = new IdentifierDecl();
		thisItem = (IdentifierDecl) item;
		item.initializeFromContext(ctx);
	}

	public void setType(InitDeclContextWrapper decl_ctx,
			ParserRuleContext typeName)
	{
		String baseType = "";
		if (typeName != null)
			baseType = ParseTreeUtils.childTokenString(typeName);
		String completeType = baseType;
		if (decl_ctx.ptrs() != null)
			completeType += " "
					+ ParseTreeUtils.childTokenString(decl_ctx.ptrs());
		if (decl_ctx.type_suffix() != null)
			completeType += " "
					+ ParseTreeUtils.childTokenString(decl_ctx.type_suffix());

		IdentifierDeclType newType = new IdentifierDeclType();
		newType.initializeFromContext(decl_ctx.getWrappedObject());
		newType.baseType = baseType;
		newType.completeType = completeType;
		thisItem.setType(newType);
	}

	public void setName(InitDeclContextWrapper decl_ctx)
	{
		ParserRuleContext identifier = decl_ctx.identifier();
		Identifier newName = new Identifier();
		newName.initializeFromContext(identifier);

		thisItem.setName(newName);
	}

	public List<IdentifierDecl> getDeclarations(ParserRuleContext decl_list,
			ParserRuleContext typeName)
	{
		List<IdentifierDecl> declarations = new LinkedList<IdentifierDecl>();
		InitDeclContextWrapper decl_ctx;
		for (Iterator<ParseTree> i = decl_list.children.iterator(); i.hasNext();)
		{

			decl_ctx = new InitDeclContextWrapper(i.next());
			// for ','s
			if (decl_ctx.getWrappedObject() == null)
				continue;

			createNew(decl_ctx.getWrappedObject());
			setType(decl_ctx, typeName);
			setName(decl_ctx);

			declarations.add((IdentifierDecl) getItem());
		}
		return declarations;
	}

}
