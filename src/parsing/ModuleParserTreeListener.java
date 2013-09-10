package parsing;

import java.util.Iterator;
import java.util.List;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;

import antlr.ModuleBaseListener;
import antlr.ModuleParser;
import antlr.ModuleParser.Class_defContext;
import antlr.ModuleParser.Compound_statementContext;
import antlr.ModuleParser.DeclByClassContext;
import antlr.ModuleParser.Function_defContext;
import antlr.ModuleParser.Init_declarator_listContext;
import antlr.ModuleParser.Type_nameContext;
import astnodes.builders.ClassDefBuilder;
import astnodes.builders.FunctionDefBuilder;
import astnodes.builders.IdentifierDeclBuilder;
import astnodes.declarations.IdentifierDecl;
import astnodes.statements.CompoundStatement;
import astnodes.statements.IdentifierDeclStatement;


public class ModuleParserTreeListener extends ModuleBaseListener
{
	
	ANTLRParserDriver p;
	
	ModuleParserTreeListener(ANTLRParserDriver aP)
	{
		p = aP;
	}
	
	@Override
	public void enterCode(ModuleParser.CodeContext ctx)
	{
		p.notifyObserversOfUnitStart(ctx);
	}
	
	@Override public void exitCode(ModuleParser.CodeContext ctx)
	{
		p.notifyObserversOfUnitEnd(ctx);
	}
	
	// Function Definitions
	
	@Override
	public void enterFunction_def(ModuleParser.Function_defContext ctx)
	{
		
		FunctionDefBuilder builder = new FunctionDefBuilder();
		builder.createNew(ctx);
		p.itemStack.push(builder);
	
		CompoundStatement functionContent = parseFunctionContents(ctx);
		builder.setContent(functionContent);
		
	}

	
	private String getCompoundStmtAsString(ModuleParser.Function_defContext ctx)
	{
		Compound_statementContext compound_statement = ctx.compound_statement();
		
		CharStream inputStream = compound_statement.start.getInputStream();
		int startIndex = compound_statement.start.getStopIndex();
		int stopIndex = compound_statement.stop.getStopIndex();
		return inputStream.getText(new Interval(startIndex+1, stopIndex-1));
	}
	
	
	private CompoundStatement parseFunctionContents(Function_defContext ctx)
	{
		String text = getCompoundStmtAsString(ctx);
		
		FunctionParser parser = new FunctionParser();
		
		try{
			parser.parseAndWalkString(text);
		}catch(RuntimeException ex){
			System.err.println("Error parsing function " +
							  ctx.function_name().getText()
							  + ". skipping.");
		}
		return parser.getResult();
	}

	@Override
	public void enterReturn_type(ModuleParser.Return_typeContext ctx)
	{
		FunctionDefBuilder builder = (FunctionDefBuilder) p.itemStack.peek();
		builder.setReturnType(ctx, p.itemStack);
	}
	
	@Override
	public void enterFunction_name(ModuleParser.Function_nameContext ctx)
	{
		FunctionDefBuilder builder = (FunctionDefBuilder) p.itemStack.peek();
		builder.setName(ctx, p.itemStack);
	}
	
	@Override
	public void enterFunction_param_list(ModuleParser.Function_param_listContext ctx)
	{
		FunctionDefBuilder builder = (FunctionDefBuilder) p.itemStack.peek();
		builder.setParameterList(ctx, p.itemStack);
	}
	
	@Override public void enterParameter_decl(ModuleParser.Parameter_declContext ctx)
	{
		FunctionDefBuilder builder = (FunctionDefBuilder) p.itemStack.peek();
		builder.addParameter(ctx, p.itemStack);
	}
	
	@Override
	public void exitFunction_def(ModuleParser.Function_defContext ctx)
	{
		FunctionDefBuilder builder = (FunctionDefBuilder) p.itemStack.pop();		
		p.notifyObserversOfItem(builder.getItem());
	}	
	
	// DeclByType
	
	@Override public void enterDeclByType(ModuleParser.DeclByTypeContext ctx)
	{
		Init_declarator_listContext decl_list = ctx.init_declarator_list();
		Type_nameContext typeName = ctx.type_name();
		emitDeclarations(decl_list, typeName, ctx);
	}
		
	private void emitDeclarations(ParserRuleContext decl_list,
			  ParserRuleContext typeName, ParserRuleContext ctx)
	{
		IdentifierDeclBuilder builder = new IdentifierDeclBuilder();
		List<IdentifierDecl> declarations = builder.getDeclarations(decl_list, typeName);

		IdentifierDeclStatement stmt = new IdentifierDeclStatement();
		// stmt.initializeFromContext(ctx);
		
		Iterator<IdentifierDecl> it = declarations.iterator();
		while(it.hasNext()){
			IdentifierDecl decl = it.next();
			stmt.addChild(decl);
		}		
	
		p.notifyObserversOfItem(stmt);
	}
	
	// DeclByClass
	
	@Override
	public void enterDeclByClass(ModuleParser.DeclByClassContext ctx)
	{
		ClassDefBuilder builder = new ClassDefBuilder();
		builder.createNew(ctx);
		p.itemStack.push(builder);		
	}

	@Override
	public void enterClass_name(ModuleParser.Class_nameContext ctx)
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
		emitDeclarations(decl_list, typeName, ctx);
	}
	
	
	@Override
	public void exitDeclByClass(ModuleParser.DeclByClassContext ctx)
	{
		ClassDefBuilder builder = (ClassDefBuilder) p.itemStack.pop();
		
		CompoundStatement content = parseClassContent(ctx);
		builder.setContent(content);
		
		p.notifyObserversOfItem(builder.getItem());		
		emitDeclarationsForClass(ctx);
	}

	private CompoundStatement parseClassContent(ModuleParser.DeclByClassContext ctx)
	{
		ANTLRModuleParserDriver shallowParser = createNewShallowParser();
		CompoundItemAssembler generator = new CompoundItemAssembler();
		shallowParser.addObserver(generator);

		restrictStreamToClassContent(ctx);
		shallowParser.parseAndWalkTokenStream(p.stream);
		p.stream.resetRestriction();
		
		return generator.getCompoundItem();
	}

	private void restrictStreamToClassContent(
			ModuleParser.DeclByClassContext ctx)
	{
		Class_defContext class_def = ctx.class_def();
		int startIndex = class_def.OPENING_CURLY().getSymbol().getTokenIndex();
		int stopIndex = class_def.stop.getTokenIndex();
		
		p.stream.restrict(startIndex+1, stopIndex);
	}

	private ANTLRModuleParserDriver createNewShallowParser()
	{
		ANTLRModuleParserDriver shallowParser = new ANTLRModuleParserDriver();
		shallowParser.setStack(p.itemStack);
		return shallowParser;
	}
	
}
