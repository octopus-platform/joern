package main.CoarseFunctionParser;

import java.util.Iterator;
import java.util.List;

import main.codeitems.builders.CoarseFunctionContentBuilder;
import main.codeitems.builders.IdentifierDeclBuilder;
import main.codeitems.declarations.IdentifierDecl;

import org.antlr.v4.runtime.ParserRuleContext;

import tools.index.CommonParser;
import antlr.CoarseFunctionGrammarBaseListener;
import antlr.CoarseFunctionGrammarParser;
import antlr.CoarseFunctionGrammarParser.Init_declarator_listContext;
import antlr.CoarseFunctionGrammarParser.Type_nameContext;


public class CoarseParseTreeListener extends CoarseFunctionGrammarBaseListener
{
	CommonParser p;
	CoarseFunctionContentBuilder builder;
	
	public CoarseParseTreeListener(CoarseFunctionParser aP)
	{
		p = aP;
	}
	
	@Override
	public void enterCoarse_content(CoarseFunctionGrammarParser.Coarse_contentContext ctx)
	{
		CoarseFunctionContentBuilder builder = new CoarseFunctionContentBuilder();
		builder.createNew(ctx);
		p.itemStack.push(builder);
	}
	
	@Override
	public void enterCoarse_content_elem(CoarseFunctionGrammarParser.Coarse_content_elemContext ctx)
	{
		CoarseFunctionContentBuilder builder = (CoarseFunctionContentBuilder) p.itemStack.peek();
		builder.enterCoarseContentElem(ctx);
	}
	
	@Override
	public void exitCoarse_content_elem(CoarseFunctionGrammarParser.Coarse_content_elemContext ctx)
	{
		CoarseFunctionContentBuilder builder = (CoarseFunctionContentBuilder) p.itemStack.peek();
		builder.exitCoarseContentElem(ctx);
	}
	
	@Override public void enterFuncCall(CoarseFunctionGrammarParser.FuncCallContext ctx)
	{
		CoarseFunctionContentBuilder builder = (CoarseFunctionContentBuilder) p.itemStack.peek();
		builder.enterFuncCall(ctx);
	}
	
	@Override public void exitFuncCall(CoarseFunctionGrammarParser.FuncCallContext ctx)
	{
		CoarseFunctionContentBuilder builder = (CoarseFunctionContentBuilder) p.itemStack.peek();
		builder.exitFuncCall(ctx);
	}
	
	@Override public void enterFunction_argument_list(CoarseFunctionGrammarParser.Function_argument_listContext ctx)
	{
		CoarseFunctionContentBuilder builder = (CoarseFunctionContentBuilder) p.itemStack.peek();
		builder.enterArgumentList(ctx);
	}
	
	@Override public void exitFunction_argument_list(CoarseFunctionGrammarParser.Function_argument_listContext ctx)
	{
		CoarseFunctionContentBuilder builder = (CoarseFunctionContentBuilder) p.itemStack.peek();
		builder.exitArgumentList(ctx);	
	}
	
	
	@Override public void enterFieldOnly(CoarseFunctionGrammarParser.FieldOnlyContext ctx)
	{
		CoarseFunctionContentBuilder builder = (CoarseFunctionContentBuilder) p.itemStack.peek();
		builder.enterFieldOnly(ctx);
	}
	
	@Override public void exitFieldOnly(CoarseFunctionGrammarParser.FieldOnlyContext ctx)
	{
		CoarseFunctionContentBuilder builder = (CoarseFunctionContentBuilder) p.itemStack.peek();
		builder.exitFieldOnly(ctx);
	}

	@Override public void enterField(CoarseFunctionGrammarParser.FieldContext ctx)
	{
		CoarseFunctionContentBuilder builder = (CoarseFunctionContentBuilder) p.itemStack.peek();
		builder.enterField(ctx);
	}
	
	@Override public void exitField(CoarseFunctionGrammarParser.FieldContext ctx)
	{
		CoarseFunctionContentBuilder builder = (CoarseFunctionContentBuilder) p.itemStack.peek();
		builder.exitField(ctx);
	}
	
	
	@Override
	public void enterDeclByType(CoarseFunctionGrammarParser.DeclByTypeContext ctx)
	{
		CoarseFunctionContentBuilder builder = (CoarseFunctionContentBuilder) p.itemStack.peek();
		builder.enterDeclByType(ctx.type_name());
		
		Init_declarator_listContext decl_list = ctx.init_declarator_list();
		Type_nameContext typeName = ctx.type_name();
		emitDeclarations(decl_list, typeName);
	}
			
	private void emitDeclarations(ParserRuleContext decl_list,
			  ParserRuleContext typeName)
	{
		
		IdentifierDeclBuilder builder = new IdentifierDeclBuilder();
		List<IdentifierDecl> declarations = builder.getDeclarations(decl_list, typeName);

		CoarseFunctionContentBuilder contentBuilder = (CoarseFunctionContentBuilder) p.itemStack.peek();
		
		Iterator<IdentifierDecl> it = declarations.iterator();
		while(it.hasNext()){
			IdentifierDecl decl = it.next();
			contentBuilder.addLocalDecl(decl);
		}		
	
	
	
	}
	
}
