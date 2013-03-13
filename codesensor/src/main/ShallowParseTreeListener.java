package main;

import java.util.Iterator;
import java.util.Stack;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;


import main.codeitems.ClassDef;
import main.codeitems.CodeItem;
import main.codeitems.FunctionDef;
import main.codeitems.IdentifierDecl;

import antlr.CodeSensorBaseListener;
import antlr.CodeSensorParser;
import antlr.CodeSensorParser.Class_defContext;
import antlr.CodeSensorParser.Class_nameContext;
import antlr.CodeSensorParser.Compound_statementContext;
import antlr.CodeSensorParser.Init_declaratorContext;
import antlr.CodeSensorParser.Init_declarator_listContext;
import antlr.CodeSensorParser.Type_nameContext;

public class ShallowParseTreeListener extends CodeSensorBaseListener{
	
	Stack<CodeItem> itemStack = new Stack<CodeItem>();
	Printer nodePrinter = new CSVPrinter();
	String filename;
	TokenSubStream stream;
	
	ShallowParseTreeListener(String aFilename, TokenSubStream aStream)
	{
		filename = aFilename;
		stream = aStream;
	}
	
	void setPrinter(Printer aPrinter)
	{
		nodePrinter = aPrinter;
	}
	
	@Override public void enterCode(CodeSensorParser.CodeContext ctx)
	{
		if(filename == null)
			return;
		String nodeTypeName = "SOURCE_FILE";
		nodePrinter.startOfUnit(nodeTypeName, ctx, filename);
	}
	
	@Override public void enterFunction_def(CodeSensorParser.Function_defContext ctx)
	{
		
		FunctionDef func = new FunctionDef();
		func.create(ctx, itemStack);
		itemStack.push(func);
	
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

	@Override public void enterFunction_name(CodeSensorParser.Function_nameContext ctx)
	{
		FunctionDef func = (FunctionDef) itemStack.peek();
		func.setName(ctx, itemStack);
	}
	
	
	@Override public void exitFunction_def(CodeSensorParser.Function_defContext ctx)
	{
		FunctionDef func = (FunctionDef) itemStack.pop();
		func.complete(ctx);
		nodePrinter.printItem(func, itemStack);
	}

	@Override public void exitCode(CodeSensorParser.CodeContext ctx)
	{
		String nodeTypeName = "SOURCE_FILE";
		nodePrinter.endOfUnit(nodeTypeName, ctx, filename);
	}
	
	
	@Override public void enterReturn_type(CodeSensorParser.Return_typeContext ctx)
	{
		FunctionDef func = (FunctionDef) itemStack.peek();
		func.setReturnType(ctx, itemStack);
	}
		
		
	@Override public void enterParameter_decl_clause(CodeSensorParser.Parameter_decl_clauseContext ctx)
	{
		FunctionDef func = (FunctionDef) itemStack.peek();
		func.setParameterList(ctx, itemStack);
	}
	
	@Override public void enterParameter_decl(CodeSensorParser.Parameter_declContext ctx)
	{
		FunctionDef func = (FunctionDef) itemStack.peek();
		func.addParameter(ctx, itemStack);
	}
	
	
	// Class/Structure Definitions
	
	@Override
	public void enterDeclByClass(CodeSensorParser.DeclByClassContext ctx)
	{
		ClassDef classDef = new ClassDef();
		classDef.create(ctx, itemStack);
		itemStack.push(classDef);
		
		Init_declarator_listContext decl_list = ctx.init_declarator_list();
		
		if(decl_list != null){
		Class_nameContext class_name = ctx.class_def().class_name();
		

		ParserRuleContext typeName = class_name;
		
		emitDeclarations(decl_list, typeName);
		
		}
	
	}

	private void restrictStreamToClassContent(
			CodeSensorParser.DeclByClassContext ctx)
	{
		Class_defContext class_def = ctx.class_def();
		int startIndex = class_def.OPENING_CURLY().getSymbol().getTokenIndex();
		int stopIndex = class_def.stop.getTokenIndex();
		stream.restrict(startIndex+1, stopIndex);
	}
	
		
	private void emitDeclarations(Init_declarator_listContext decl_list, ParserRuleContext typeName)
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
				
			IdentifierDecl idDecl = new IdentifierDecl();
			idDecl.create(decl_ctx, itemStack);
			idDecl.setName(decl_ctx.identifier(), itemStack);
			idDecl.setType(decl_ctx, typeName);
			
			nodePrinter.printItem(idDecl, itemStack);
		}
		
	}
	
	@Override
	public void exitDeclByClass(CodeSensorParser.DeclByClassContext ctx)
	{
		CodeItem classDef = itemStack.pop();
		nodePrinter.printItem(classDef, itemStack);
	
		parseClassContent(ctx);
	}

	private void parseClassContent(CodeSensorParser.DeclByClassContext ctx)
	{
		restrictStreamToClassContent(ctx);
		ShallowParser shallowParser = new ShallowParser();
		shallowParser.parse(null, stream);
		stream.resetRestriction();
	}

	@Override
	public void enterClass_name(CodeSensorParser.Class_nameContext ctx)
	{
		ClassDef classDef = (ClassDef) itemStack.peek();
		classDef.setName(ctx, itemStack);
	}
	
	@Override
	public void exitClass_name(CodeSensorParser.Class_nameContext ctx)
	{
		
	}
	
	@Override public void enterDeclByType(CodeSensorParser.DeclByTypeContext ctx)
	{
		Init_declarator_listContext decl_list = ctx.init_declarator_list();
		Type_nameContext typeName = ctx.type_name();
		emitDeclarations(decl_list, typeName);
	}
	
}
