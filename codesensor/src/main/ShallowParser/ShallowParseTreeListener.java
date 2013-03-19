package main.ShallowParser;

import java.util.Iterator;
import java.util.Stack;

import main.TokenSubStream;

import main.FunctionParser.FunctionParser;
import main.codeitems.CodeItemBuilder;
import main.codeitems.declarations.ClassDefBuilder;
import main.codeitems.declarations.IdentifierDeclBuilder;
import main.codeitems.function.FunctionDefBuilder;
import main.processors.CSVPrinter;
import main.processors.Processor;


import org.antlr.v4.runtime.ParserRuleContext;

import org.antlr.v4.runtime.tree.ParseTree;

import antlr.CodeSensorBaseListener;
import antlr.CodeSensorParser;
import antlr.CodeSensorParser.Class_defContext;

import antlr.CodeSensorParser.Compound_statementContext;
import antlr.CodeSensorParser.DeclByClassContext;
import antlr.CodeSensorParser.Function_defContext;
import antlr.CodeSensorParser.Init_declaratorContext;
import antlr.CodeSensorParser.Init_declarator_listContext;
import antlr.CodeSensorParser.Type_nameContext;


public class ShallowParseTreeListener extends CodeSensorBaseListener
{
	
	Stack<CodeItemBuilder> builderStack = new Stack<CodeItemBuilder>();
	Processor processor = new CSVPrinter();
	String filename;
	TokenSubStream stream;
	
	// Users can initialize the stack with
	// an existing stack. This allows us to
	// pass state from one parser to the next.
	public void setStack(Stack<CodeItemBuilder> aStack)
	{
		builderStack = aStack;
	}
	
	public void setProcessor(Processor aProcessor)
	{
		processor = aProcessor;
	}
	
	public void initializeContext(ShallowParserContext context)
	{
		filename = context.filename;
		stream = context.stream;
	}
	
	@Override
	public void enterCode(CodeSensorParser.CodeContext ctx)
	{
		processor.startOfUnit(ctx, filename);
	}
	
	@Override public void exitCode(CodeSensorParser.CodeContext ctx)
	{
		processor.endOfUnit(ctx, filename);
	}	
	
	// Function Definitions
	
	@Override
	public void enterFunction_def(CodeSensorParser.Function_defContext ctx)
	{
		
		FunctionDefBuilder builder = new FunctionDefBuilder();
		builder.createNew(ctx);
		builderStack.push(builder);
	
		parseFunctionContents(ctx);
	}

	private void parseFunctionContents(Function_defContext ctx)
	{
		restrictStreamToFunctionContent(ctx);
		FunctionParser parser = new FunctionParser();
		parser.parseAndWalkStream(stream);
		stream.resetRestriction();
	}

	private void restrictStreamToFunctionContent(
			CodeSensorParser.Function_defContext ctx)
	{
		Compound_statementContext compound = ctx.compound_statement();
		
		int startIndex = compound.OPENING_CURLY().getSymbol().getTokenIndex();
		int stopIndex = compound.stop.getTokenIndex();
		stream.restrict(startIndex+1, stopIndex);
	}
	
	@Override
	public void enterReturn_type(CodeSensorParser.Return_typeContext ctx)
	{
		FunctionDefBuilder builder = (FunctionDefBuilder) builderStack.peek();
		builder.setReturnType(ctx, builderStack);
	}
	
	@Override
	public void enterFunction_name(CodeSensorParser.Function_nameContext ctx)
	{
		FunctionDefBuilder builder = (FunctionDefBuilder) builderStack.peek();
		builder.setName(ctx, builderStack);
	}
	
	@Override
	public void enterFunction_param_list(CodeSensorParser.Function_param_listContext ctx)
	{
		FunctionDefBuilder builder = (FunctionDefBuilder) builderStack.peek();
		builder.setParameterList(ctx, builderStack);
	}
	
	@Override public void enterParameter_decl(CodeSensorParser.Parameter_declContext ctx)
	{
		FunctionDefBuilder builder = (FunctionDefBuilder) builderStack.peek();
		builder.addParameter(ctx, builderStack);
	}
	
	@Override
	public void exitFunction_def(CodeSensorParser.Function_defContext ctx)
	{
		FunctionDefBuilder builder = (FunctionDefBuilder) builderStack.pop();
		processor.processItem(builder.getItem(), builderStack);
	}	
	
	// Class/Structure Definitions
	
	@Override public void enterDeclByType(CodeSensorParser.DeclByTypeContext ctx)
	{
		Init_declarator_listContext decl_list = ctx.init_declarator_list();
		Type_nameContext typeName = ctx.type_name();
		emitDeclarations(decl_list, typeName);
	}
	
	@Override
	public void enterDeclByClass(CodeSensorParser.DeclByClassContext ctx)
	{
		ClassDefBuilder builder = new ClassDefBuilder();
		builder.createNew(ctx);
		builderStack.push(builder);		
	}

	@Override
	public void enterClass_name(CodeSensorParser.Class_nameContext ctx)
	{
		ClassDefBuilder builder = (ClassDefBuilder) builderStack.peek();
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
	
	private void emitDeclarations(Init_declarator_listContext decl_list,
								  ParserRuleContext typeName)
	{
		
		Init_declaratorContext decl_ctx;
		
		for(Iterator<ParseTree> i = decl_list.children.iterator(); i.hasNext();)
		{
			try{
				decl_ctx = (Init_declaratorContext) i.next();
			}catch(java.lang.ClassCastException e)
			{
				// this is perfectly normal:
				// not all child-nodes are init-declarators
				continue;
			}
			
			IdentifierDeclBuilder builder = new IdentifierDeclBuilder();
			builder.createNew(decl_ctx);
			builder.setName(decl_ctx);
			builder.setType(decl_ctx, typeName);
			
			processor.processItem(builder.getItem(), builderStack);
		}
	}
		
	@Override
	public void exitDeclByClass(CodeSensorParser.DeclByClassContext ctx)
	{
		CodeItemBuilder builder = builderStack.pop();
		processor.processItem(builder.getItem(), builderStack);
		
		parseClassContent(ctx);
	
		emitDeclarationsForClass(ctx);
	}

	private void parseClassContent(CodeSensorParser.DeclByClassContext ctx)
	{
		ShallowParser shallowParser = createNewShallowParser();
		restrictStreamToClassContent(ctx);
		shallowParser.parseAndWalkStream(stream);
		stream.resetRestriction();
	}

	private ShallowParser createNewShallowParser()
	{
		ShallowParser shallowParser = new ShallowParser();
		shallowParser.setStack(builderStack);
		shallowParser.setProcessor(processor);
		return shallowParser;
	}
	
	private void restrictStreamToClassContent(
			CodeSensorParser.DeclByClassContext ctx)
	{
		Class_defContext class_def = ctx.class_def();
		int startIndex = class_def.OPENING_CURLY().getSymbol().getTokenIndex();
		int stopIndex = class_def.stop.getTokenIndex();
		stream.restrict(startIndex+1, stopIndex);
	}
	
	public Processor getProcessor()
	{
		return processor;
	}
	
	
}
