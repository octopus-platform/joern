package parsing.C.Modules;

import java.util.Iterator;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import parsing.ANTLRParserDriver;
import parsing.CompoundItemAssembler;
import parsing.C.ModuleFunctionParserInterface;
import parsing.C.Modules.builder.FunctionDefBuilder;
import parsing.C.Shared.builders.ClassDefBuilder;
import parsing.C.Shared.builders.IdentifierDeclBuilder;
import antlr.C.ModuleBaseListener;
import antlr.C.ModuleParser;
import antlr.C.ModuleParser.Class_defContext;
import antlr.C.ModuleParser.DeclByClassContext;
import antlr.C.ModuleParser.Init_declarator_listContext;
import antlr.C.ModuleParser.Type_nameContext;
import ast.declarations.IdentifierDecl;
import ast.statements.CompoundStatement;
import ast.statements.IdentifierDeclStatement;

// Converts Parse Trees to ASTs for Modules

public class CModuleParserTreeListener extends ModuleBaseListener
{

	ANTLRParserDriver p;

	public CModuleParserTreeListener(ANTLRParserDriver aP)
	{
		p = aP;
	}

	@Override
	public void enterCode(ModuleParser.CodeContext ctx)
	{
		p.notifyObserversOfUnitStart(ctx);
	}

	@Override
	public void exitCode(ModuleParser.CodeContext ctx)
	{
		p.notifyObserversOfUnitEnd(ctx);
	}

	// /////////////////////////////////////////////////////////////
	// This is where the ModuleParser invokes the FunctionParser
	// /////////////////////////////////////////////////////////////
	// This function is invoked when a Function_Def parse tree node
	// is entered. This is where we hand over the function contents to
	// the function parser and connect the AST node created for the
	// function definition to the AST created by the function parser.
	// ////////////////////////////////////////////////////////////////

	@Override
	public void enterFunction_def(ModuleParser.Function_defContext ctx)
	{

		FunctionDefBuilder builder = new FunctionDefBuilder();
		builder.createNew(ctx);
		p.builderStack.push(builder);

		CompoundStatement functionContent = ModuleFunctionParserInterface
				.parseFunctionContents(ctx);
		builder.setContent(functionContent);
	}

	@Override
	public void exitFunction_def(ModuleParser.Function_defContext ctx)
	{
		FunctionDefBuilder builder = (FunctionDefBuilder) p.builderStack.pop();
		p.notifyObserversOfItem(builder.getItem());
	}

	@Override
	public void enterReturn_type(ModuleParser.Return_typeContext ctx)
	{
		FunctionDefBuilder builder = (FunctionDefBuilder) p.builderStack.peek();
		builder.setReturnType(ctx, p.builderStack);
	}

	@Override
	public void enterFunction_name(ModuleParser.Function_nameContext ctx)
	{
		FunctionDefBuilder builder = (FunctionDefBuilder) p.builderStack.peek();
		builder.setName(ctx, p.builderStack);
	}

	@Override
	public void enterFunction_param_list(
			ModuleParser.Function_param_listContext ctx)
	{
		FunctionDefBuilder builder = (FunctionDefBuilder) p.builderStack.peek();
		builder.setParameterList(ctx, p.builderStack);
	}

	@Override
	public void enterParameter_decl(ModuleParser.Parameter_declContext ctx)
	{
		FunctionDefBuilder builder = (FunctionDefBuilder) p.builderStack.peek();
		builder.addParameter(ctx, p.builderStack);
	}

	// DeclByType

	@Override
	public void enterDeclByType(ModuleParser.DeclByTypeContext ctx)
	{
		Init_declarator_listContext decl_list = ctx.init_declarator_list();
		Type_nameContext typeName = ctx.type_name();
		emitDeclarations(decl_list, typeName, ctx);
	}

	private void emitDeclarations(ParserRuleContext decl_list,
			ParserRuleContext typeName, ParserRuleContext ctx)
	{
		IdentifierDeclBuilder builder = new IdentifierDeclBuilder();
		List<IdentifierDecl> declarations = builder.getDeclarations(decl_list,
				typeName);

		IdentifierDeclStatement stmt = new IdentifierDeclStatement();
		// stmt.initializeFromContext(ctx);

		Iterator<IdentifierDecl> it = declarations.iterator();
		while (it.hasNext())
		{
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
		p.builderStack.push(builder);
	}

	@Override
	public void exitDeclByClass(ModuleParser.DeclByClassContext ctx)
	{
		ClassDefBuilder builder = (ClassDefBuilder) p.builderStack.pop();

		CompoundStatement content = parseClassContent(ctx);
		builder.setContent(content);

		p.notifyObserversOfItem(builder.getItem());
		emitDeclarationsForClass(ctx);
	}

	@Override
	public void enterClass_name(ModuleParser.Class_nameContext ctx)
	{
		ClassDefBuilder builder = (ClassDefBuilder) p.builderStack.peek();
		builder.setName(ctx);
	}

	private void emitDeclarationsForClass(DeclByClassContext ctx)
	{

		Init_declarator_listContext decl_list = ctx.init_declarator_list();
		if (decl_list == null)
			return;

		ParserRuleContext typeName = ctx.class_def().class_name();
		emitDeclarations(decl_list, typeName, ctx);
	}

	private CompoundStatement parseClassContent(
			ModuleParser.DeclByClassContext ctx)
	{
		ANTLRCModuleParserDriver shallowParser = createNewShallowParser();
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

		p.stream.restrict(startIndex + 1, stopIndex);
	}

	private ANTLRCModuleParserDriver createNewShallowParser()
	{
		ANTLRCModuleParserDriver shallowParser = new ANTLRCModuleParserDriver();
		shallowParser.setStack(p.builderStack);
		return shallowParser;
	}

}
