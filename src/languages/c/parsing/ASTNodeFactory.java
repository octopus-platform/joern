package languages.c.parsing;

import org.antlr.v4.runtime.ParserRuleContext;

import ast.ASTNode;
import ast.expressions.AssignmentExpr;
import ast.expressions.BinaryExpression;
import ast.expressions.Expression;
import ast.functionDef.Parameter;
import ast.logical.statements.Statement;
import languages.c.antlr.FunctionParser.InitDeclWithAssignContext;
import languages.c.antlr.FunctionParser.StatementContext;
import languages.c.antlr.ModuleParser.Parameter_declContext;
import languages.c.antlr.ModuleParser.Parameter_idContext;
import languages.c.antlr.ModuleParser.Parameter_nameContext;
import parsing.ParseTreeUtils;

public class ASTNodeFactory
{
	public static void initializeFromContext(ASTNode node,
			ParserRuleContext ctx)
	{
		if (ctx == null)
			return;
		node.setLocation(CodeLocationExtractor.extractFromContext(ctx));
		node.setCodeStr(escapeCodeStr(ParseTreeUtils.childTokenString(ctx)));
	}

	public static void initializeFromContext(Expression node,
			ParserRuleContext ctx)
	{
		initializeFromContext((ASTNode) node, ctx);
		if (node instanceof BinaryExpression && ctx.getChildCount() == 3)
			node.setOperator(ctx.getChild(1).getText());
	}

	public static ASTNode create(StatementContext ctx)
	{
		ASTNode node = new Statement();
		initializeFromContext(node, ctx);
		return node;
	}

	private static String escapeCodeStr(String codeStr)
	{
		String retval = codeStr;
		retval = retval.replace("\n", "\\n");
		retval = retval.replace("\t", "\\t");
		return retval;
	}

	public static AssignmentExpr create(InitDeclWithAssignContext ctx)
	{
		AssignmentExpr assign = new AssignmentExpr();
		initializeFromContext(assign, ctx);
		if (ctx.getChildCount() == 3)
			assign.setOperator(ctx.getChild(1).getText());

		return assign;
	}

	public static Parameter create(Parameter_declContext ctx)
	{
		Parameter param = new Parameter();

		Parameter_declContext paramCtx = (Parameter_declContext) ctx;
		Parameter_nameContext paramName = getNameOfParameter(paramCtx);

		initializeFromContext(param.type, ctx);
		initializeFromContext(param.name, paramName);
		initializeFromContext(param, ctx);

		param.addChild(param.type);
		param.addChild(param.name);

		return param;
	}

	private static Parameter_nameContext getNameOfParameter(
			Parameter_declContext param_ctx)
	{
		Parameter_idContext parameter_id = param_ctx.parameter_id();

		while (parameter_id.parameter_name() == null)
		{
			parameter_id = parameter_id.parameter_id();
		}
		return parameter_id.parameter_name();
	}

}
