package main;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.antlr.v4.runtime.tree.ParseTree;


import main.codeitems.ClassDef;
import main.codeitems.CodeItem;
import main.codeitems.FunctionDef;
import main.codeitems.IdentifierDecl;

import antlr.CodeSensorBaseListener;
import antlr.CodeSensorParser;
import antlr.CodeSensorParser.Class_nameContext;
import antlr.CodeSensorParser.Init_declaratorContext;
import antlr.CodeSensorParser.Init_declarator_listContext;

public class ParseTreeListener extends CodeSensorBaseListener{
	
	Stack<CodeItem> itemStack = new Stack<CodeItem>();
	Printer nodePrinter = new CSVPrinter();
	String filename;
	
	ParseTreeListener(String aFilename)
	{
		filename = aFilename;
	}
	
	void setPrinter(Printer aPrinter)
	{
		nodePrinter = aPrinter;
	}
	
	@Override public void enterCode(CodeSensorParser.CodeContext ctx)
	{
		String nodeTypeName = "SOURCE_FILE";
		nodePrinter.startOfUnit(nodeTypeName, ctx, filename);
	}
	
	@Override public void enterFunction_def(CodeSensorParser.Function_defContext ctx)
	{
		FunctionDef func = new FunctionDef();
		func.create(ctx, itemStack);
		itemStack.push(func);
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
		nodePrinter.printItem(func);
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
		String typeName = "";
		Class_nameContext class_name = ctx.class_def().class_name();
		
		if(class_name != null)
			typeName = class_name.getText();
		
		emitDeclarations(decl_list, typeName);
		
		}
	}
	
	private void emitDeclarations(Init_declarator_listContext decl_list, String typeName)
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
			
			String completeType = typeName;
			if(decl_ctx.ptrs() != null)
				completeType += decl_ctx.ptrs().getText();
			if(decl_ctx.type_suffix() != null)
				completeType += decl_ctx.type_suffix().getText();
			
			idDecl.setType(typeName, completeType);
			
			nodePrinter.printItem(idDecl);
		}
		
	}
	
	@Override
	public void exitDeclByClass(CodeSensorParser.DeclByClassContext ctx)
	{
		CodeItem classDef = itemStack.pop();
		nodePrinter.printItem(classDef);
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
		
	/*
	@Override public void enterVar_decl(CodeSensorParser.Var_declContext ctx)
	{
		Init_declarator_listContext decl_list = ctx.init_declarator_list();
		CodeSensorParser.Init_declaratorContext decl_ctx;
		
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
				
			String typeName = ctx.type_name().getText();
			String completeTypeName = getVariableType(decl_ctx, typeName);
				
			CodeItem line = new CodeItem();
			line.nodeTypeName = "TYPE";
			line.level = level + 1;
			line.location = new CodeLocation(ctx);
			line.location.stopIndex = -1;
			line.codeStr = completeTypeName;
			nodePrinter.printItem(line);
			
			line.nodeTypeName = "NAME";
			line.codeStr = decl_ctx.identifier().getText();
			nodePrinter.printItem(line);
			
		}
		
		level++;
	}
	
	private String getVariableType(CodeSensorParser.Init_declaratorContext ctx, String baseType)
	{
		
		String completeTypeName = baseType;
		PtrsContext ptrs = ctx.ptrs();
		Type_suffixContext type_suffix = ctx.type_suffix();
		
		if(ptrs != null)
			completeTypeName += " " + ptrs.getText();
		if(type_suffix != null)
			completeTypeName += " " + type_suffix.getText();
		return completeTypeName;
	}
	
	@Override public void enterParameter_name(CodeSensorParser.Parameter_nameContext ctx)
	{
		String nodeTypeName = "NAME";
		nodePrinter.print(nodeTypeName, ctx, this.level);
		level++;
	}
	
	@Override public void enterType_suffix(CodeSensorParser.Type_suffixContext ctx)
	{
		String nodeTypeName = "TYPE_SUFFIX";
		nodePrinter.print(nodeTypeName, ctx, this.level);
		level++;
	}
		
	@Override public void enterCtor_initializer(CodeSensorParser.Ctor_initializerContext ctx)
	{
		String nodeTypeName = "CTOR_INITIALIZER";
		nodePrinter.print(nodeTypeName, ctx, this.level);
		level++;
	}
		
	@Override public void enterInitializer_id(CodeSensorParser.Initializer_idContext ctx)
	{
		String nodeTypeName = "INITIALIZER_ID";
		nodePrinter.print(nodeTypeName, ctx, this.level);
		level++;
	}
		
	@Override public void enterCtor_expr(CodeSensorParser.Ctor_exprContext ctx)
	{
		String nodeTypeName = "CTOR_EXPR";
		nodePrinter.print(nodeTypeName, ctx, this.level);
		level++;
	}
	
	@Override public void enterSimple_decl(CodeSensorParser.Simple_declContext ctx)
	{
		String nodeTypeName = "SIMPLE_DECL";
		nodePrinter.print(nodeTypeName, ctx, this.level);
		level++;
	}
	
	@Override public void enterClass_def(CodeSensorParser.Class_defContext ctx)
	{
		String nodeTypeName = "CLASS_DEF";
		nodePrinter.print(nodeTypeName, ctx, this.level);
		level++;
	}
		
	@Override public void enterInit_declarator_list(CodeSensorParser.Init_declarator_listContext ctx)
	{
		String nodeTypeName = "INIT_DECL_LIST";
		nodePrinter.print(nodeTypeName, ctx, this.level);
		level++;
	}
	
	@Override public void enterInit_declarator(CodeSensorParser.Init_declaratorContext ctx)
	{
		String nodeTypeName = "VAR_DECL";
		nodePrinter.print(nodeTypeName, ctx, this.level);		
		level++;
	}
	*/

}
