package main.ShallowParser;

import java.util.Iterator;
import java.util.Stack;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;


import main.CSVPrinter;
import main.Printer;
import main.TokenSubStream;
import main.FunctionParser.FunctionParser;
import main.codeitems.CodeItem;
import main.codeitems.CodeItemBuilder;
import main.codeitems.Name;
import main.codeitems.declarations.ClassDef;
import main.codeitems.declarations.ClassDefBuilder;
import main.codeitems.declarations.IdentifierDecl;
import main.codeitems.declarations.IdentifierDeclBuilder;
import main.codeitems.function.FunctionDef;
import main.codeitems.function.FunctionDefBuilder;

import antlr.CodeSensorBaseListener;
import antlr.CodeSensorParser;
import antlr.CodeSensorParser.Class_defContext;
import antlr.CodeSensorParser.Class_nameContext;
import antlr.CodeSensorParser.Compound_statementContext;
import antlr.CodeSensorParser.DeclByClassContext;
import antlr.CodeSensorParser.Init_declaratorContext;
import antlr.CodeSensorParser.Init_declarator_listContext;
import antlr.CodeSensorParser.Type_nameContext;

public class ShallowParseTreeListener extends CodeSensorBaseListener{
	
	Stack<CodeItemBuilder> itemStack = new Stack<CodeItemBuilder>();
	
	Printer nodePrinter = new CSVPrinter();
	String filename;
	TokenSubStream stream;
	
	ShallowParseTreeListener(ParserContext context)
	{
		filename = context.filename;
		stream = context.stream;
	}
	
	void setPrinter(Printer aPrinter)
	{
		nodePrinter = aPrinter;
	}
	
	@Override
	public void enterCode(CodeSensorParser.CodeContext ctx)
	{
		String nodeTypeName = "SOURCE_FILE";
		nodePrinter.startOfUnit(nodeTypeName, ctx, filename);
	}
	
	@Override public void exitCode(CodeSensorParser.CodeContext ctx)
	{
		String nodeTypeName = "SOURCE_FILE";
		nodePrinter.endOfUnit(nodeTypeName, ctx, filename);
	}	
	
	@Override
	public void enterFunction_def(CodeSensorParser.Function_defContext ctx)
	{
		
		FunctionDefBuilder builder = new FunctionDefBuilder();
		builder.createNew(ctx);
		
		itemStack.push(builder);
	
		// parseFunctionContents(ctx);
	}

	private void parseFunctionContents(CodeSensorParser.Function_defContext ctx)
	{
		String text = getCompoundStmtAsString(ctx);
		FunctionParser functionParser = new FunctionParser();
		functionParser.parse(text);	
	}

	private String getCompoundStmtAsString(
			CodeSensorParser.Function_defContext ctx)
	{
		Compound_statementContext compound_statement = ctx.compound_statement();
		
		CharStream inputStream = compound_statement.start.getInputStream();
		int startIndex = compound_statement.start.getStartIndex();
		int stopIndex = compound_statement.stop.getStopIndex();
		return inputStream.getText(new Interval(startIndex+1, stopIndex-1));
	}

	@Override
	public void enterReturn_type(CodeSensorParser.Return_typeContext ctx)
	{
		FunctionDefBuilder builder = (FunctionDefBuilder) itemStack.peek();
		builder.setReturnType(ctx, itemStack);
	}
	
	@Override
	public void enterFunction_name(CodeSensorParser.Function_nameContext ctx)
	{
		FunctionDefBuilder builder = (FunctionDefBuilder) itemStack.peek();
		builder.setName(ctx, itemStack);
	}
	
	@Override
	public void enterParameter_decl_clause(CodeSensorParser.Parameter_decl_clauseContext ctx)
	{
		FunctionDefBuilder builder = (FunctionDefBuilder) itemStack.peek();
		builder.setParameterList(ctx, itemStack);
	}
	
	@Override public void enterParameter_decl(CodeSensorParser.Parameter_declContext ctx)
	{
		FunctionDefBuilder builder = (FunctionDefBuilder) itemStack.peek();
		builder.addParameter(ctx, itemStack);
	}
	
	@Override
	public void exitFunction_def(CodeSensorParser.Function_defContext ctx)
	{
		FunctionDefBuilder builder = (FunctionDefBuilder) itemStack.pop();
		nodePrinter.printItem(builder.getItem(), itemStack);
	}	
	
	// Class/Structure Definitions
	
	@Override
	public void enterDeclByClass(CodeSensorParser.DeclByClassContext ctx)
	{
		ClassDefBuilder builder = new ClassDefBuilder();
		builder.createNew(ctx);
		
		itemStack.push(builder);
		
		emitDeclarationsForClass(ctx);		
	}

	@Override
	public void enterClass_name(CodeSensorParser.Class_nameContext ctx)
	{
		ClassDefBuilder builder = (ClassDefBuilder) itemStack.peek();
		builder.setName(ctx);
	}
	
	private void restrictStreamToClassContent(
			CodeSensorParser.DeclByClassContext ctx)
	{
		Class_defContext class_def = ctx.class_def();
		int startIndex = class_def.OPENING_CURLY().getSymbol().getTokenIndex();
		int stopIndex = class_def.stop.getTokenIndex();
		stream.restrict(startIndex+1, stopIndex);
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
			
			nodePrinter.printItem(builder.getItem(), itemStack);
		}
	}
		
	@Override
	public void exitDeclByClass(CodeSensorParser.DeclByClassContext ctx)
	{
		CodeItemBuilder builder = itemStack.pop();
		nodePrinter.printItem(builder.getItem(), itemStack);
	
		parseClassContent(ctx);
	}

	private void parseClassContent(CodeSensorParser.DeclByClassContext ctx)
	{
		restrictStreamToClassContent(ctx);
		ShallowParser shallowParser = new ShallowParser();
		shallowParser.parseTokenStream(stream);
		stream.resetRestriction();
	}

	
	@Override public void enterDeclByType(CodeSensorParser.DeclByTypeContext ctx)
	{
		Init_declarator_listContext decl_list = ctx.init_declarator_list();
		Type_nameContext typeName = ctx.type_name();
		emitDeclarations(decl_list, typeName);
	}
	
	
}
