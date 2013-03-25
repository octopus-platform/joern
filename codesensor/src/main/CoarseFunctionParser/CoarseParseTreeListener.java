package main.CoarseFunctionParser;

import java.util.Iterator;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import main.CommonParser;
import main.codeitems.declarations.IdentifierDecl;
import main.codeitems.declarations.IdentifierDeclBuilder;
import main.codeitems.functionContent.CoarseFunctionContentBuilder;
import main.codeitems.functionContent.FineFunctionContentBuilder;
import antlr.CoarseFunctionGrammarBaseListener;
import antlr.CoarseFunctionGrammarParser;
import antlr.FineFunctionGrammarParser;

import antlr.CoarseFunctionGrammarParser.Init_declarator_listContext;
import antlr.CoarseFunctionGrammarParser.Type_nameContext;


public class CoarseParseTreeListener extends CoarseFunctionGrammarBaseListener
{
	CommonParser p;
	
	
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
	public void exitCoarse_content(CoarseFunctionGrammarParser.Coarse_contentContext ctx)
	{
		CoarseFunctionContentBuilder builder = (CoarseFunctionContentBuilder) p.itemStack.pop();
		p.processor.processItem(builder.getItem(), p.itemStack);
	}

	// Duplication
	@Override
	public void enterDeclByType(CoarseFunctionGrammarParser.DeclByTypeContext ctx)
	{
		CoarseFunctionContentBuilder builder = (CoarseFunctionContentBuilder) p.itemStack.peek();
		builder.enterDeclByType();
		
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
	// Duplication End
	
	
	@Override
	public void enterFuncCall(CoarseFunctionGrammarParser.FuncCallContext ctx)
	{
		CoarseFunctionContentBuilder builder = (CoarseFunctionContentBuilder) p.itemStack.peek();
		builder.enterFunctionCall(ctx);
	}
	
	@Override
	public void enterFieldOnly(CoarseFunctionGrammarParser.FieldOnlyContext ctx)
	{
		
	}
	
	@Override
	public void enterPrimary_expression(CoarseFunctionGrammarParser.Primary_expressionContext ctx)
	{
		
	}
	
}
