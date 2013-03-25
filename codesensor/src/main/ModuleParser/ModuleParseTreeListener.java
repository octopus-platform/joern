package main.ModuleParser;

import java.util.Iterator;
import java.util.List;

import main.CommonParser;

import main.FunctionParser.FunctionParser;
import main.codeitems.CodeItemBuilder;
import main.codeitems.declarations.ClassDefBuilder;
import main.codeitems.declarations.IdentifierDecl;
import main.codeitems.declarations.IdentifierDeclBuilder;
import main.codeitems.function.FunctionDefBuilder;


import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.ParserRuleContext;

import org.antlr.v4.runtime.misc.Interval;

import antlr.CodeSensorParser;
import antlr.CodeSensorParser.Class_defContext;

import antlr.CodeSensorBaseListener;
import antlr.CodeSensorParser.Compound_statementContext;
import antlr.CodeSensorParser.DeclByClassContext;
import antlr.CodeSensorParser.Function_defContext;
import antlr.CodeSensorParser.Init_declarator_listContext;
import antlr.CodeSensorParser.Type_nameContext;


public class ModuleParseTreeListener extends CodeSensorBaseListener
{
	
	CommonParser p;
	
	ModuleParseTreeListener(CommonParser aP)
	{
		p = aP;
	}
	
	@Override
	public void enterCode(CodeSensorParser.CodeContext ctx)
	{
		p.processor.startOfUnit(ctx, p.filename);
	}
	
	@Override public void exitCode(CodeSensorParser.CodeContext ctx)
	{
		p.processor.endOfUnit(ctx, p.filename);
	}	
	
	// Function Definitions
	
	@Override
	public void enterFunction_def(CodeSensorParser.Function_defContext ctx)
	{
		
		FunctionDefBuilder builder = new FunctionDefBuilder();
		builder.createNew(ctx);
		p.itemStack.push(builder);
	
		parseFunctionContents(ctx);
	}

	
	private String getCompoundStmtAsString(CodeSensorParser.Function_defContext ctx)
	{
		Compound_statementContext compound_statement = ctx.compound_statement();
		
		CharStream inputStream = compound_statement.start.getInputStream();
		int startIndex = compound_statement.start.getStopIndex();
		int stopIndex = compound_statement.stop.getStopIndex();
		return inputStream.getText(new Interval(startIndex+1, stopIndex-1));
	}
	
	
	private void parseFunctionContents(Function_defContext ctx)
	{
		String text = getCompoundStmtAsString(ctx);
		
		FunctionParser parser = new FunctionParser();
		// parser.enableFineParsing();
		
		try{
			parser.parseAndWalkString(text);
		}catch(RuntimeException ex){
			ex.printStackTrace();
			System.err.println("Error parsing function " +
							  ctx.function_name().getText()
							  + ". skipping.");
		}
	}

	@Override
	public void enterReturn_type(CodeSensorParser.Return_typeContext ctx)
	{
		FunctionDefBuilder builder = (FunctionDefBuilder) p.itemStack.peek();
		builder.setReturnType(ctx, p.itemStack);
	}
	
	@Override
	public void enterFunction_name(CodeSensorParser.Function_nameContext ctx)
	{
		FunctionDefBuilder builder = (FunctionDefBuilder) p.itemStack.peek();
		builder.setName(ctx, p.itemStack);
	}
	
	@Override
	public void enterFunction_param_list(CodeSensorParser.Function_param_listContext ctx)
	{
		FunctionDefBuilder builder = (FunctionDefBuilder) p.itemStack.peek();
		builder.setParameterList(ctx, p.itemStack);
	}
	
	@Override public void enterParameter_decl(CodeSensorParser.Parameter_declContext ctx)
	{
		FunctionDefBuilder builder = (FunctionDefBuilder) p.itemStack.peek();
		builder.addParameter(ctx, p.itemStack);
	}
	
	@Override
	public void exitFunction_def(CodeSensorParser.Function_defContext ctx)
	{
		FunctionDefBuilder builder = (FunctionDefBuilder) p.itemStack.pop();
		p.processor.processItem(builder.getItem(), p.itemStack);
	}	
	
	// DeclByType
	
	@Override public void enterDeclByType(CodeSensorParser.DeclByTypeContext ctx)
	{
		Init_declarator_listContext decl_list = ctx.init_declarator_list();
		Type_nameContext typeName = ctx.type_name();
		emitDeclarations(decl_list, typeName);
	}
	
	private void emitDeclarations(ParserRuleContext decl_list,
			  ParserRuleContext typeName)
	{
		IdentifierDeclBuilder builder = new IdentifierDeclBuilder();
		List<IdentifierDecl> declarations = builder.getDeclarations(decl_list, typeName);

		Iterator<IdentifierDecl> it = declarations.iterator();
		while(it.hasNext()){
			IdentifierDecl decl = it.next();
			p.processor.processItem(decl, p.itemStack);
		}		
	}
	
	// DeclByClass
	
	@Override
	public void enterDeclByClass(CodeSensorParser.DeclByClassContext ctx)
	{
		ClassDefBuilder builder = new ClassDefBuilder();
		builder.createNew(ctx);
		p.itemStack.push(builder);		
	}

	@Override
	public void enterClass_name(CodeSensorParser.Class_nameContext ctx)
	{
		ClassDefBuilder builder = (ClassDefBuilder) p.itemStack.peek();
		builder.setName(ctx);
	}
	
	private void emitDeclarationsForClass(DeclByClassContext ctx)
	{
		
		Init_declarator_listContext decl_list = ctx.init_declarator_list();		
		if(decl_list == null)
			return;
		
		ParserRuleContext typeName = ctx.class_def().class_name();
		emitDeclarations(decl_list, typeName);
	}
	
	
	@Override
	public void exitDeclByClass(CodeSensorParser.DeclByClassContext ctx)
	{
		CodeItemBuilder builder = p.itemStack.pop();
		p.processor.processItem(builder.getItem(), p.itemStack);
		
		parseClassContent(ctx);
		emitDeclarationsForClass(ctx);
	}

	private void parseClassContent(CodeSensorParser.DeclByClassContext ctx)
	{
		ModuleParser shallowParser = createNewShallowParser();
		restrictStreamToClassContent(ctx);
		shallowParser.parseAndWalkStream(p.stream);
		p.stream.resetRestriction();
	}

	private void restrictStreamToClassContent(
			CodeSensorParser.DeclByClassContext ctx)
	{
		Class_defContext class_def = ctx.class_def();
		int startIndex = class_def.OPENING_CURLY().getSymbol().getTokenIndex();
		int stopIndex = class_def.stop.getTokenIndex();
		p.stream.restrict(startIndex+1, stopIndex);
	}

	private ModuleParser createNewShallowParser()
	{
		ModuleParser shallowParser = new ModuleParser();
		shallowParser.setStack(p.itemStack);
		shallowParser.setProcessor(p.processor);
		return shallowParser;
	}
	
}
