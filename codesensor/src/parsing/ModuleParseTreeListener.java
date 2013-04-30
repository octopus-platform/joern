package parsing;

import java.util.Iterator;
import java.util.List;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;

import antlr.CodeSensorBaseListener;
import antlr.CodeSensorParser;
import antlr.CodeSensorParser.Class_defContext;
import antlr.CodeSensorParser.Compound_statementContext;
import antlr.CodeSensorParser.DeclByClassContext;
import antlr.CodeSensorParser.Function_defContext;
import antlr.CodeSensorParser.Init_declarator_listContext;
import antlr.CodeSensorParser.Type_nameContext;
import astnodes.builders.ClassDefBuilder;
import astnodes.builders.FunctionDefBuilder;
import astnodes.builders.IdentifierDeclBuilder;
import astnodes.declarations.IdentifierDecl;
import astnodes.statements.CompoundStatement;
import astnodes.statements.IdentifierDeclStatement;


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
		p.notifyObserversOfUnitStart(ctx);
	}
	
	@Override public void exitCode(CodeSensorParser.CodeContext ctx)
	{
		p.notifyObserversOfUnitEnd(ctx);
	}
	
	// Function Definitions
	
	@Override
	public void enterFunction_def(CodeSensorParser.Function_defContext ctx)
	{
		
		FunctionDefBuilder builder = new FunctionDefBuilder();
		builder.createNew(ctx);
		p.itemStack.push(builder);
	
		CompoundStatement functionContent = parseFunctionContents(ctx);
		builder.setContent(functionContent);
		
	}

	
	private String getCompoundStmtAsString(CodeSensorParser.Function_defContext ctx)
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
		parser.enableFineParsing();
		
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
		p.notifyObserversOfItem(builder.getItem());
	}	
	
	// DeclByType
	
	@Override public void enterDeclByType(CodeSensorParser.DeclByTypeContext ctx)
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
		emitDeclarations(decl_list, typeName, ctx);
	}
	
	
	@Override
	public void exitDeclByClass(CodeSensorParser.DeclByClassContext ctx)
	{
		ClassDefBuilder builder = (ClassDefBuilder) p.itemStack.pop();
		
		CompoundStatement content = parseClassContent(ctx);
		builder.setContent(content);
		
		p.notifyObserversOfItem(builder.getItem());		
		emitDeclarationsForClass(ctx);
	}

	private CompoundStatement parseClassContent(CodeSensorParser.DeclByClassContext ctx)
	{
		ModuleParser shallowParser = createNewShallowParser();
		CompoundItemAssembler generator = new CompoundItemAssembler();
		shallowParser.addObserver(generator);

		restrictStreamToClassContent(ctx);
		shallowParser.parseAndWalkStream(p.stream);
		p.stream.resetRestriction();
		
		return generator.getCompoundItem();
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
		return shallowParser;
	}
	
}
